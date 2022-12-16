package archive.relation;

import ml.kit.primitive.Dense;
import ml.kit.primitive.complex.topo.Closed;

public abstract class Relation<x,R,y> extends Closed<x,y> implements Dense<R> {}
