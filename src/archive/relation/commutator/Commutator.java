package archive.relation.commutator;

import archive.relation.DisjointRelation;
import archive.relation.Op;

public interface Commutator<g,h> extends Op<DisjointRelation<g,h>,DisjointRelation<h,g>> {}
