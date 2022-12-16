package archive.relation;

import ml.foundation.primitive.Dense;
import ml.foundation.complex.topo.Closed;

public abstract class Relation<x,R,y> extends Closed<x,y> implements Dense<R> {}
