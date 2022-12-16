package ml.foundation.complex.topo.clopen;

import ml.foundation.primitive.Liminal;
import ml.foundation.primitive.direction.d_Right;
import ml.foundation.primitive.direction.v_Left;

public abstract class l_Clopen implements v_Left, d_Right {

	@Override
	public abstract Liminal getCenter();

}
