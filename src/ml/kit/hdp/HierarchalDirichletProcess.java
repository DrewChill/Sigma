package ml.kit.hdp;

import java.io.FileInputStream;
import java.util.Collection;

import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;

public class HierarchalDirichletProcess<T> {
	
	private double beta = 0.5;
	private double gamma = 1.5;
	private double alpha = 1.5;
	
	private double[] p;
	private double[] f;
	
	private Collection<Synapse<?,T>> groups;
	private int[] numberOfTablesByTopic;
	private int[] itemCountByTopic;
	private int[] itemCountByTopicAndTerm;
	
	
	public HierarchalDirichletProcess(Context<T> corpus, Collection<FileInputStream> inFiles) {
		groups = corpus.getCorpus(inFiles);
		
		p = new double[20];
		f = new double[20];
		
	}

}
