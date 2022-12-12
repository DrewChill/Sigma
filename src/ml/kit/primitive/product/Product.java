package ml.kit.primitive.product;

import ml.kit.primitive.str.TerminalCharacter;

public abstract class Product<left,center,right> implements Left<left>, Right<right>, TerminalCharacter<center> {}
