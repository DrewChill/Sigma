package archive.adjoint;

import archive.relation.Op;
import archive.InitCharacter;
import ml.foundation.primitive.seq.TerminalCharacter;

public interface Adjoint<g,h,ch extends TerminalCharacter<h>> extends InitCharacter<g,h,ch> {

	Op<g,ch> adjunction();

}
