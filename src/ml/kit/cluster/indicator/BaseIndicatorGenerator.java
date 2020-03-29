package ml.kit.cluster.indicator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import ml.kit.cluster.Cluster;
import ml.kit.structs.item.Item;

public class BaseIndicatorGenerator<T extends Serializable> implements IndicatorGenerator<T>{

//	@Override
//	public byte[] getLabelForCluster(Cluster<T> cluster) {
//		String k = "";
//		for(Item<T> data : cluster.itemList()) {
//			k = k.isEmpty() ? data.getValue().toString() : k + "<-->" +data.getValue().toString();
//		}
//		
//		Integer indicator = null;
//		synchronized(indicatorMap) {
//			indicator = indicatorMap.get(k);
//			if(indicator == null) {
//				indicator = nextIndicator++;
//				indicatorMap.put(k, indicator);
//			}
//		}
//		
//		return ByteBuffer.allocate(4).putInt(indicator).array();
//	}
	
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
