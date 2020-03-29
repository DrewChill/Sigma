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

import ml.kit.cluster.Cluster;
import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.item.Item;

public abstract class Group<T> implements Runnable{

	protected Collection<Item<T>> items;
	Set<Cluster<T>> contributions;
	protected Vocabulary<T> vocabulary;
	protected Pipe recvStream;
	protected Queue<Integer> bytesWaiting = new ConcurrentLinkedQueue<>();
	
	public Group(Vocabulary<T> vocabulary) {
		items = new ArrayList<>();
		contributions = new HashSet<>();
		this.vocabulary = vocabulary;
	}
		
	public int vocabularySize() {
		return vocabulary.allClusters().size();
	}
	
	public void signalContribution(Cluster<T> signaler) {
		synchronized(contributions) {
			contributions.add(signaler);
		}
	}
	
	public void nullifyContribution(Cluster<T> signaler) {
		synchronized(contributions) {
			contributions.remove(signaler);
		}
	}
	
	public int getTotalContributions() {
		return contributions.size();
	}
	
	public Collection<Cluster<T>> getContributions(){
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
				Cluster<T> inCluster = vocabulary.decodeBytes(encoded.array());
				Item<T> item = new Item<T>(inCluster.sampleItemFromCluster().getValue(), this);
				if(vocabulary.getDerivedVocabulary() != null) {
					vocabulary.getDerivedVocabulary().clusterItem(item);
				}
				items.add(item);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract Cluster<T> sampleGroupForCluster(Item<T> item, int populationSize, double totalAssignmentLikelihood);
	
	
}
