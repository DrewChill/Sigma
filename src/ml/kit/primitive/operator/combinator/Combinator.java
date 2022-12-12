package ml.kit.primitive.operator.combinator;

import ml.kit.primitive.operator.Operator;
import ml.kit.primitive.str.TerminalCharacter;

public interface Combinator<g,h,ch extends TerminalCharacter<h>,result> extends Operator<ch,Operator<g,result>> {}
