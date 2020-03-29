package ml.kit.cluster.indicator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ml.kit.cluster.Cluster;
import ml.kit.structs.item.Item;

public class DPIndicatorGenerator<T> implements IndicatorGenerator<T> {

	@Override
	public byte[] getLabelForCluster(Cluster<T> cluster) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			for(Item<T> data : cluster.itemList()) {
				oos.writeObject(data.getValue());
			}
			oos.flush();
			return bos.toByteArray();
		} catch (IOException e) {
			return null;
		}
		
	}
	
}
