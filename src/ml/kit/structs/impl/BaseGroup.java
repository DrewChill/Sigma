package ml.kit.structs.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.ProbabilisticSymbol;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.SymbolGenerator;
import ml.kit.symbol.structure.StructureInfo;

public class BaseGroup<T extends MLObject> extends Synapse<T>{

	public BaseGroup(SymbolGenerator<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public ProbabilisticSymbol<T> generateSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<Symbol<T>, Double> likelihoodForSymbol, StructureInfo<T> behavior) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(item);
			oos.flush();
			
			return new ProbabilisticSymbol<T>(symbolGenerator.decodeBytes(bos.toByteArray()), 1.0);
		} catch (IOException e) {
			return null;
		}
	}
	
}
