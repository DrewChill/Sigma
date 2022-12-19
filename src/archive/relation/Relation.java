package archive.relation;

import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.d.Closed;

public abstract class Relation<x,R,y> extends Closed<x,y> implements Dense<R> {}
