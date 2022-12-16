package ml.kit.primitive.complex.topo.clopen;

import ml.kit.primitive.Liminal;
import ml.kit.primitive.direction.d_Left;
import ml.kit.primitive.direction.v_Right;

public abstract class r_Clopen implements d_Left, v_Right {

	@Override
	public abstract Liminal getCenter();

}
