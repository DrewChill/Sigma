package archive;

import archive.relation.Op;
import archive.relation.Action;
import archive.relation.seq.TerminalOp;
import archive.relation.DisjointRelation;
import archive.relation.Relation;

public class TestTerminalOp<c,b,a,result> implements TerminalOp<c,b,a,result> {
	@Override
	public Op<c,Op<b,Op<a,result>>> operate(Something zero) {
		return null;
	}

	@Override
	public <extension, extCenter, extIdentity extends Relation<Op<c,Op<b,Op<a,result>>>,extCenter,extension>, centralProduct extends Relation<NullCharacter,Op<c,Op<b,Op<a,result>>>,extCenter>> Action<Something,centralProduct,extension,? extends Relation<Something,centralProduct,extension>> append(Action<Op<c,Op<b,Op<a,result>>>,extCenter,extension,extIdentity> action) {
		return null;
	}

	@Override
	public <prefix, preCenter, preIdentity extends Relation<prefix,preCenter,Something>, centralProduct extends Relation<preCenter,Something,NullCharacter>> Action<prefix,centralProduct,Op<c,Op<b,Op<a,result>>>,? extends Relation<prefix,centralProduct,Op<c,Op<b,Op<a,result>>>>> prepend(Action<prefix,preCenter,Something,preIdentity> action) {
		return null;
	}

	@Override
	public <E> Op<Something,E> append(Op<Op<c,Op<b,Op<a,result>>>,E> operator) {
		return null;
	}

	@Override
	public <E> Op<E,Op<c,Op<b,Op<a,result>>>> prepend(Op<E,Something> operator) {
		return null;
	}

	@Override
	public DisjointRelation<Something,Op<c,Op<b,Op<a,result>>>> real() {
		return null;
	}

	@Override
	public NullCharacter value() {
		return null;
	}
}
