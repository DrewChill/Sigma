package ml.kit.symbol.structure;

import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.entropy.LocalEntropy;
import ml.kit.symbol.entropy.StructureEntropy;
import ml.kit.symbol.structure.hdp.HDPSymbol;
import ml.kit.symbol.structure.hdp.HDPSymbolStructure;
import ml.kit.symbol.structure.nonparametric.DPSymbol;
import ml.kit.symbol.structure.nonparametric.DPSymbolStructure;

public class StructureInfo<T extends MLObject> {

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
	
	InferenceStructure modelType;
	InferenceFlow flow;
	InferenceLocality locality;
	
	Map<String, StructureParameter<?>> parameters = new HashMap<>();
	
	protected StructureEntropy<T, Symbol<T>> structureEntropy = new StructureEntropy<>();
	private SymbolStructure<T> model;

	@SuppressWarnings("unchecked")
	public StructureInfo(InferenceStructure modelType, InferenceFlow flow, InferenceLocality locality,
			StructureParameter<?>... parameters) {
		for(StructureParameter<?> parameter : parameters) {
			this.parameters.put(parameter.getName(), parameter);
		}
		this.modelType = modelType;
		this.flow = flow;
		this.locality = locality;
		
		switch(modelType) {
		case DP:
			StructureParameter<Double> dpGamma = (StructureParameter<Double>)this.parameters.get("gamma");
			this.model = new DPSymbolStructure<T>(this, dpGamma.getValue());
			break;
		case HDP:
			StructureParameter<Double> hdpGamma = (StructureParameter<Double>)this.parameters.get("gamma");
			this.model = new HDPSymbolStructure<T>(this, hdpGamma.getValue());
			break;
		case CUSTOM:
		case NP_PAM:
		case nDP:
		case nHDP:
		default:
			break;
		}
	}
	
	public SymbolStructure<T> getStructure(){
		return model;
	}
	
	public void addNext(StructureInfo<T> next) {
		
	}

	public StructureInfo<T> getNext() {
		return null;
	}
	
	//TODO: throw exception for null
	public StructureParameter<?> getParameterValue(String name){
		return parameters.get(name);
	}
	
	@SuppressWarnings("unchecked")
	public Symbol<T> createNewSymbol(){
		switch(modelType) {
		case DP:
			StructureParameter<Double> dpBeta = (StructureParameter<Double>)parameters.get("beta");
			return new DPSymbol<T>(structureEntropy.spawnSymbolicEntropy(), dpBeta.getValue());
		case HDP:
			StructureParameter<Double> hdpBeta = (StructureParameter<Double>)parameters.get("beta");
			return new HDPSymbol<T>(structureEntropy.spawnSymbolicEntropy(), hdpBeta.getValue());
		case CUSTOM:
		case NP_PAM:
		case nDP:
		case nHDP:
		default:
			return null;
		}
	}
	
	public LocalEntropy<Symbol<T>> createUpstreamConnection(){
		return structureEntropy.spawnSynapticEntropy();
	}

}
