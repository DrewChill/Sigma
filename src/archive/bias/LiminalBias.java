package archive.bias;

import ml.foundation.primitive.l.Liminal;
import ml.foundation.Preliminal;

public abstract class LiminalBias<bias extends Preliminal> extends Liminal {

	public abstract bias bias();

}
