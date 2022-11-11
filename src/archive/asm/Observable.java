package archive.asm;

import java.util.HashMap;
import java.util.Map;

import ml.kit.code.Code;
import ml.kit.observer.emitter.Emitter;
import archive.EmitterGroup;

public abstract class Observable {
	
	public Map<Code,EmitterGroup<?>> pathHistory = new HashMap<>();
	
	public void registerEmitter(Emitter<? extends Observable> emitter) {
		//pathHistory.put(emitter.relations(), emitter.group());
	}

}
