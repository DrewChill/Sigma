package ml.kit.cluster.indicator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ml.kit.cluster.Symbol;
import ml.kit.structs.item.Stimulus;

public class HDPIndicatorGenerator<T> implements IndicatorGenerator<T>{

	@Override
	public byte[] getLabelForCluster(Symbol<T> cluster) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			for(Stimulus<T> data : cluster.itemList()) {
				oos.writeObject(data.getValue());
			}
			oos.flush();
			return bos.toByteArray();
		} catch (IOException e) {
			return null;
		}
		
	}

}
