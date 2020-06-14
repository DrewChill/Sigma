package ml.kit.structs.impl.hdp;

import java.io.InputStream;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.structure.StructureInfo;

public class HDPContext<T extends MLObject> extends Context<T> {
		
	public HDPContext(StructureInfo<T> contextStructure) {
		super(contextStructure);
	}

	@Override
	public Synapse<T> createGroup(InputStream input) {
		Synapse<T> groupForInputStream = new FeedbackSynapse<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

	@Override
	protected Synapse<T> createGroup() {
		// TODO Auto-generated method stub
		return new FeedbackSynapse<T>(vocabulary);
	}

}
