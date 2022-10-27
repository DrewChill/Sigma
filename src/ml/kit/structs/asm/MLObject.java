package ml.kit.structs.asm;

import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.group.Intraface;

public abstract class MLObject {
	
	private Map<Integer,Intraface<? extends MLObject>> synapseMap = new HashMap<>();
	
	public Intraface<? extends MLObject> getSynapseForStructureId(int id){
		return synapseMap.get(id);
	}
	
	public void registerSynapseToSymbolGeneratorID(Intraface<? extends MLObject> intraface, int id) {
		synapseMap.put(id, intraface);
	}

}
