package ml.kit.structs.asm;

import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.group.Synapse;

public abstract class MLObject {
	
	private Map<Integer, Synapse<? extends MLObject>> synapseMap = new HashMap<>();
	
	public Synapse<? extends MLObject> getSynapseForStructureId(int id){
		return synapseMap.get(id);
	}
	
	public void registerSynapseToSymbolGeneratorID(Synapse<? extends MLObject> synapse, int id) {
		synapseMap.put(id, synapse);
	}

}
