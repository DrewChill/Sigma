package ml.kit.structs.group;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.StochasticSymbol;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.SymbolGenerator;
import ml.kit.symbol.entropy.LocalEntropy;

public abstract class Synapse<T extends MLObject> implements Runnable {

	protected LocalEntropy<Symbol<T>> synapticEntropy;
	protected SymbolGenerator<T> symbolGenerator;
	protected Queue<Integer> bytesWaiting = new ConcurrentLinkedQueue<>();
	protected Collection<T> items = new ArrayList<>();
	
	protected Pipe recvStream; //TODO

	public Synapse(SymbolGenerator<T> vocabulary) {
		this.symbolGenerator = vocabulary;
		this.synapticEntropy = vocabulary.registerSynapse();
	}

	public int vocabularySize() {
		return symbolGenerator.allClusters().size();
	}

	public void reuptake(Symbol<T> signaler) {
		synapticEntropy.addObservation(signaler);
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

	@Override
	public void run() {
		while (true) {
			try {
				ByteBuffer encoded = null;
				synchronized (bytesWaiting) {
					encoded = ByteBuffer.allocate(bytesWaiting.poll());
					recvStream.source().read(encoded);
				}
				Symbol<T> inCluster = symbolGenerator.decodeBytes(encoded.array());
				reuptake(inCluster);
				T item = inCluster.sampleItemFromCluster();
				item.registerSynapseToSymbolGeneratorID(this, symbolGenerator.id);
				items.add(item);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public abstract StochasticSymbol<T> generateSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<Symbol<T>, Double> likelihoodForSymbol);

}
