package ml.kit.structs.impl.hdp;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import ml.kit.cluster.Symbol;
import ml.kit.cluster.impl.hdp.HDPClusterPool;
import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.item.Stimulus;

public class nHDPGroup<T> extends HDPGroup<T>{

	private Map<Symbol<T>, nHDPGroup<T>> children;
	private Map<nHDPGroup<T>, Thread> childrenThreads;
	private Vocabulary<T> childVocabulary;
	private int depth = 0;
	private static final int MAX_DEPTH = 7;
	private boolean inheritDerivedVocabulary;

	public nHDPGroup(Vocabulary<T> vocabulary, int depth, boolean inheritDerivedVocabulary) {
		super(vocabulary);
		this.inheritDerivedVocabulary = inheritDerivedVocabulary;
		children = new HashMap<>();
		childVocabulary = inheritDerivedVocabulary ? vocabulary.getDerivedVocabulary() : new Vocabulary<T>(new HDPClusterPool<T>());
		this.depth = depth;
	}

	@Override
	public Symbol<T> sampleGroupForCluster(Stimulus<T> item, int populationSize, double totalAssignmentLikelihood) {
		Symbol<T> ret = super.sampleGroupForCluster(item, populationSize, totalAssignmentLikelihood);
		if(ret != null && depth<MAX_DEPTH) {
			nHDPGroup<T> child = children.get(ret);
			if(child == null) {
				child = new nHDPGroup<T>(childVocabulary, depth+1, inheritDerivedVocabulary);
				children.put(ret, child);
				
				Thread childThread = new Thread(child);
				childThread.start();
				childrenThreads.put(child, childThread);
			}
			ByteBuffer buf = ByteBuffer.wrap(ret.getIndicator());
			child.addData(buf);
			ret = child.sampleGroupForCluster(item, populationSize, totalAssignmentLikelihood);
		}
		return ret;
	}
	
}
