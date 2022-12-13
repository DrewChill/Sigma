package ml.kit.primitive.product.relation.combinator;

import ml.kit.primitive.seq.TerminalCharacter;

public interface Terminator<g,h,result> extends Combinator<g,h,TerminalCharacter<h>,result> {}
