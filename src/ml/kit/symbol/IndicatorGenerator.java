package ml.kit.symbol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class IndicatorGenerator {

	public static byte[] getLabelForCluster(List<?> items) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			for(Object data : items) {
				//oos.writeObject(data.getValue());
			}
			oos.flush();
			return bos.toByteArray();
		} catch (IOException e) {
			return null;
		}
		
	}
	
}
