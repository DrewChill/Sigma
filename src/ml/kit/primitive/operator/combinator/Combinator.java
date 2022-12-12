package ml.kit.primitive.operator.combinator;

import ml.kit.primitive.operator.Mapping;
import ml.kit.primitive.seq.TerminalCharacter;

public interface Combinator<g,h,ch extends TerminalCharacter<h>,result> extends Mapping<ch,Mapping<g,result>> {}
