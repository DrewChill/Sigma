package archive.relation.combinator;

import ml.foundation.primitive.seq.TerminalCharacter;

public interface Terminator<g,h,result> extends Combinator<g,h,TerminalCharacter<h>,result> {}