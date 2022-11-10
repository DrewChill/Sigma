package ml.kit.structs.vector;

import archive.NumberValue;
import ml.kit.structs.dictionary.Entry;

public interface Scalar<Coefficient,Variable> extends Entry<Variable, NumberValue<? super Coefficient>>
{}
