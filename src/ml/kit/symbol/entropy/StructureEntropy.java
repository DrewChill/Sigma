package ml.kit.symbol.entropy;

import ml.kit.structs.asm.MLObject;

public class StructureEntropy<T extends MLObject> {
	
	public LocalEntropy<T> spawnEntropy() {
		return new LocalEntropy<T>();
	}

}
