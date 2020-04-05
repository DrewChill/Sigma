package ml.kit.symbol.generator.inference;

import java.util.HashMap;
import java.util.Map;

public class InferenceInfo {

	public enum InferenceStructure {
		HDP, DP, nHDP, nDP, NP_PAM, CUSTOM;

		public static InferenceStructure parseValue(String structure) {
			switch (structure) {
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

	public enum InferenceFlow {
		CIRCULAR, LINEAR
	}

	public enum InferenceLocality {
		GLOBAL, LOCAL
	}
	
	//---------------
	Map<String, Parameter<?>> parameters = new HashMap<>();

	public InferenceInfo(InferenceStructure modelType, InferenceFlow flow, InferenceLocality locality,
			Parameter<?>... parameters) {
		for(Parameter<?> parameter : parameters) {
			this.parameters.put(parameter.getName(), parameter);
		}
	}
	
	public void addNext(InferenceInfo next) {
		
	}

	public InferenceInfo getNext() {
		return null;
	}

}
