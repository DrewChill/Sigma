package ml.kit.structs.asm;

import ml.kit.structs.group.Synapse;

public interface MLObject {
	
	public <T extends MLObject> Synapse<T> getSynapseForStructureId(int structId);

}
