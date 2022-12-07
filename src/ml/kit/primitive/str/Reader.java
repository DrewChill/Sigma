package ml.kit.primitive.str;

import ml.kit.primitive.num.number;

public interface Reader<g> {

	//TODO: yeah...idk, we'll see
	<result> result read(g obj, number options);

}
