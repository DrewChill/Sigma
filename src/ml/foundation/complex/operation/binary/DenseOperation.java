package ml.foundation.complex.operation.binary;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.Preliminal;
import ml.foundation.complex.operation.Operation;

public abstract class DenseOperation<one extends Dense> implements Operation<Preliminal,one,one>,Dense { }
