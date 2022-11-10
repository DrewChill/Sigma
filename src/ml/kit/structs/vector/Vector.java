package ml.kit.structs.vector;

import archive.NumberValue;
import ml.kit.structs.dictionary.Dictionary;

public interface Vector<Coefficient,Basis> extends Dictionary<Basis, NumberValue<? super Coefficient>>
{}
