package ml.kit.structs.group;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.ProbabilisticSymbol;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.SymbolGenerator;
import ml.kit.symbol.entropy.LocalEntropy;
import ml.kit.symbol.structure.StructureInfo;

public abstract class Synapse<T extends MLObject> implements Runnable {

	protected LocalEntropy<Symbol<T>> synapticEntropy;
	protected SymbolGenerator<T> symbolGenerator;
	protected Queue<Integer> bytesWaiting = new ConcurrentLinkedQueue<>();
	protected Collection<T> items = new ArrayList<>();
	private Random r = new Random();
	
	protected Pipe recvStream; //TODO

	public Synapse(SymbolGenerator<T> vocabulary) {
		this.symbolGenerator = vocabulary;
		this.synapticEntropy = vocabulary.registerSynapse(this);
	}

	public int vocabularySize() {
		return symbolGenerator.allClusters().size();
	}

	public void reuptake(Symbol<?> signaler) {
		synapticEntropy.addObservation((Symbol<T>) signaler);
	}

	public void degenerate(Symbol<T> signaler) {
		synapticEntropy.decayObservation(signaler);
	}

	public int getConnectionDimension() {
		return synapticEntropy.size;
	}

	public Collection<Symbol<T>> getConnections() {
		return synapticEntropy.getStationaryDistribution().keySet();
	}

	public void addData(ByteBuffer in) {
		try {
			synchronized (bytesWaiting) {
				bytesWaiting.add(in.capacity());
				recvStream.sink().write(in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract ProbabilisticSymbol<T> generateSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<Symbol<T>, Double> likelihoodForSymbol, StructureInfo<T> behavior);
	
	private Symbol<T> sample(){
		Map<Symbol<T>, Double> stationaryDistribution = synapticEntropy.getStationaryDistribution();
		double sample = r.nextDouble();
		for(Symbol<T> obj : stationaryDistribution.keySet()) {
			if(stationaryDistribution.get(obj) > sample) {
				return obj;
			}
		}
		return null;
	}
	
	public byte[] fire(double duration, double weight) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			double weightedSize = (double)synapticEntropy.size * weight;
			int objsToSample = (int)(((weightedSize/duration)) * synapticEntropy.size);
			for(int i=0; i<objsToSample; i++) {
				oos.writeObject(sample());
			}
			oos.flush();
			
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[0];
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				ByteBuffer encoded = null;
				synchronized (bytesWaiting) {
					encoded = ByteBuffer.allocate(bytesWaiting.poll());
					recvStream.source().read(encoded);
				}
				ByteArrayInputStream bis = new ByteArrayInputStream(encoded.array());
				ObjectInputStream oois = new ObjectInputStream(bis);
				T data = null;
				while((data = (T)oois.readObject()) != null) {
					data.registerSynapseToSymbolGeneratorID(this, symbolGenerator.id);
					symbolGenerator.queueMLObject(data);
					items.add(data);
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
