package ml.kit.structs.asm;

import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.group.Synapse;

public abstract class MLObject {
	
	private Map<Integer, Synapse<?>> synapseMap = new HashMap<>();
	
	public Synapse<?> getSynapseForStructureId(int id){
		return synapseMap.get(id);
	}
	
	public <T extends MLObject> void registerSynapseToSymbolGeneratorID(Synapse<T> synapse, int id) {
		synapseMap.put(id, synapse);
	}

}
