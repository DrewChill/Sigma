package ml.kit.primitive.operator;

import ml.kit.primitive.num.number;

public interface Operator<I,O> extends number {

	O operate(I input);

}
