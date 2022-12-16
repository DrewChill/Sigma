package ml.observer.symbol.relation;

public enum RelationShape {
	HDP, DP, nHDP, nDP, NP_PAM, CUSTOM;

	public static RelationShape parseValue(String structure) {
		switch(structure) {
			case "HDP":
				return HDP;
			case "DP":
				return DP;
			case "nHDP":
				return nHDP;
			case "nDP":
				return nDP;
			case "NP_PAM":
				return NP_PAM;
			default:
				return CUSTOM;
		}
	}
}
