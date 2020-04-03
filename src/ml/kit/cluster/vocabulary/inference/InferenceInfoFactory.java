package ml.kit.cluster.vocabulary.inference;

public class InferenceInfoFactory<T> {
	
	public enum InferenceStructure {
		HDP,
		DP,
		nHDP,
		nDP,
		NP_PAM,
		CUSTOM;
		
		public static InferenceStructure parseValue(String structure) {
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
	
	public enum InferenceFlow{
		CIRCULAR,
		LINEAR
	}
	
	public enum InferenceLocality{
		GLOBAL,
		LOCAL
	}
	
	public InferenceInfo<T> createInferenceInfo(InferenceStructure structure){
		switch(structure) {
		case CUSTOM:
			break;
		case DP:
			break;
		case HDP:
			break;
		case NP_PAM:
			break;
		case nDP:
			break;
		case nHDP:
			break;
		default:
			break;
		}
		return null;
	}
	
	public InferenceInfo<T> createInferenceInfo(String inferenceStructure){
		return createInferenceInfo(InferenceStructure.parseValue(inferenceStructure));
	}

}
