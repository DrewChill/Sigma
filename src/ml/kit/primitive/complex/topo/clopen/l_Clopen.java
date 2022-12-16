package ml.kit.primitive.complex.topo.clopen;

import ml.kit.primitive.Liminal;
import ml.kit.primitive.direction.d_Right;
import ml.kit.primitive.direction.v_Left;

public abstract class l_Clopen implements v_Left, d_Right {

	@Override
	public abstract Liminal getCenter();

}
