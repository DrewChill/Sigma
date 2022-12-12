package ml.kit.primitive.operator.combinator;

import ml.kit.primitive.seq.TerminalCharacter;

public interface Terminator<g,h,result> extends Combinator<g,h,TerminalCharacter<h>,result> {}
