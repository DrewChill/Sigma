package ml.kit.primitive.topo.clopen;

import ml.kit.primitive.Liminal;
import ml.kit.primitive.direction.d_Left;
import ml.kit.primitive.direction.d_Right;
import ml.kit.primitive.direction.v_Left;
import ml.kit.primitive.direction.v_Right;

public abstract class r_Clopen implements d_Left, v_Right {

	@Override
	public abstract Liminal getCenter();

}
