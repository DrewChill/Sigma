package ml.kit.primitive.product;

import ml.kit.primitive.LeftCharacter;
import ml.kit.primitive.RightCharacter;

public abstract class Product<x,y> implements LeftCharacter<x>, RightCharacter<y> {}
