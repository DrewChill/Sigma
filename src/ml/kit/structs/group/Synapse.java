package ml.kit.structs.group;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import ml.kit.cluster.Symbol;
import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.item.Stimulus;

public abstract class Synapse<T> implements Runnable{

	protected Collection<Stimulus<T>> items;
	Set<Symbol<T>> contributions;
	protected Vocabulary<T> vocabulary;
	protected Pipe recvStream;
	protected Queue<Integer> bytesWaiting = new ConcurrentLinkedQueue<>();
	
	public Synapse(Vocabulary<T> vocabulary) {
		items = new ArrayList<>();
		contributions = new HashSet<>();
		this.vocabulary = vocabulary;
	}
		
	public int vocabularySize() {
		return vocabulary.allClusters().size();
	}
	
	public void signalContribution(Symbol<T> signaler) {
		synchronized(contributions) {
			contributions.add(signaler);
		}
	}
	
	public void nullifyContribution(Symbol<T> signaler) {
		synchronized(contributions) {
			contributions.remove(signaler);
		}
	}
	
	public int getTotalContributions() {
		return contributions.size();
	}
	
	public Collection<Symbol<T>> getContributions(){
		return contributions;
	}
	
	public void addData(ByteBuffer in){
		try {
			synchronized(bytesWaiting) {
				bytesWaiting.add(in.capacity());
				recvStream.sink().write(in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				ByteBuffer encoded = null;
				synchronized(bytesWaiting) {
					encoded = ByteBuffer.allocate(bytesWaiting.poll());
					recvStream.source().read(encoded);
				}
				Symbol<T> inCluster = vocabulary.decodeBytes(encoded.array());
				Stimulus<T> item = new Stimulus<T>(inCluster.sampleItemFromCluster().getValue(), this);
				if(vocabulary.getDerivedVocabulary() != null) {
					vocabulary.getDerivedVocabulary().addItem(item);
				}
				items.add(item);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract Symbol<T> sampleGroupForCluster(Stimulus<T> item, int populationSize, double totalAssignmentLikelihood);
	
	
}
