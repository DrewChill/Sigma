package ml.foundation.complex.topo.clopen;

import ml.foundation.primitive.Liminal;
import ml.foundation.primitive.direction.d_Left;
import ml.foundation.primitive.direction.v_Right;

public abstract class R_Clopen implements d_Left, v_Right {

	@Override
	public abstract Liminal getCenter();

}
