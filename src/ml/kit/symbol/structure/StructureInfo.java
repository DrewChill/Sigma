package ml.kit.symbol.structure;

import java.util.HashMap;
import java.util.Map;

import ml.kit.function.DensityFunction;
import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.entropy.LocalEntropy;
import ml.kit.symbol.entropy.StructureEntropy;
import ml.kit.symbol.structure.nonparametric.DPSymbol;
import ml.kit.symbol.structure.nonparametric.DPSymbolStructure;
import ml.kit.symbol.structure.nonparametric.HDPSymbol;
import ml.kit.symbol.structure.nonparametric.HDPSymbolStructure;

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

	// ---------------

	InferenceStructure modelType;
	InferenceFlow flow;
	InferenceLocality locality;

	Map<String, StructureParameter<?>> parameters = new HashMap<>();

	protected StructureEntropy<T, Symbol<T>> structureEntropy = new StructureEntropy<>();
	private SymbolStructure<T> model;
	private Context<Symbol<T>> next = null;
	private DensityFunction<T> baseDistribution;

	@SuppressWarnings("unchecked")
	public StructureInfo(InferenceStructure modelType, InferenceFlow flow, InferenceLocality locality,
			DensityFunction<T> baseDistribution, StructureParameter<?>... parameters) {
		for (StructureParameter<?> parameter : parameters) {
			this.parameters.put(parameter.getName(), parameter);
		}
		this.modelType = modelType;
		this.flow = flow;
		this.locality = locality;
		this.baseDistribution = baseDistribution;

		switch (modelType) {
		case DP:
			StructureParameter<Double> dpGamma = (StructureParameter<Double>) this.parameters.get("gamma");
			this.model = new DPSymbolStructure<T>(this, dpGamma.getValue());
			break;
		case HDP:
			StructureParameter<Double> hdpGamma = (StructureParameter<Double>) this.parameters.get("gamma");
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

	public SymbolStructure<T> getStructure() {
		return model;
	}

	public void addNext(StructureInfo<T> next) {

	}

	// TODO: throw exception for null
	public StructureParameter<?> getParameterValue(String name) {
		return parameters.get(name);
	}

	@SuppressWarnings("unchecked")
	public Symbol<T> createNewSymbol() {
		Symbol<T> ret = null;
		switch (modelType) {
		case DP:
			ret = new DPSymbol<T>(structureEntropy.spawnSymbolicEntropy(), baseDistribution);
			break;
		case HDP:
			ret = new HDPSymbol<T>(structureEntropy.spawnSymbolicEntropy(), baseDistribution);
			break;
		case CUSTOM:
		case NP_PAM:
		case nDP:
		case nHDP:
		default:
			ret = null;
		}
		
		baseDistribution = baseDistribution.initNext();
		
		return ret;
	}

	public LocalEntropy<Symbol<T>> createUpstreamConnection(Synapse<T> synapse) {
		return structureEntropy.spawnSynapticEntropy(synapse);
	}

	public Context<Symbol<T>> getNextContext() {
		return next;
	}

}
