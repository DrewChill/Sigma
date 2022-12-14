package archive;

import archive.relation.seq.Kernel;

public interface NullCharacter<c> extends ml.kit.primitive.seq.NullCharacter {

	c value();

	default <result> result read(Kernel<c,result> operator){
		return this.value().read(operator).operate(value());
	}

}
