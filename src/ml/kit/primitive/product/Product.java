package ml.kit.primitive.product;

import ml.kit.primitive.seq.TerminalCharacter;

public abstract class Product<left,center,right> implements Left<left>,Right<right>,TerminalCharacter<center> {}
