package ml.kit.structs.asm;

import java.util.HashMap;
import java.util.Map;

import ml.kit.identity.Identity;
import ml.kit.observer.emitter.Emitter;
import archive.EmitterGroup;

public abstract class Observable {
	
	public Map<Identity,EmitterGroup<?>> pathHistory = new HashMap<>();
	
	public void registerEmitter(Emitter<? extends Observable> emitter) {
		//pathHistory.put(emitter.relations(), emitter.group());
	}

}
