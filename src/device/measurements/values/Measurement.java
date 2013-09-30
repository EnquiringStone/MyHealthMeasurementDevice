package device.measurements.values;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: EnquiringStone
 * Date: 26-9-13
 * Time: 13:04
 * To change this template use File | Settings | File Templates.
 */
abstract class Measurement {

	public int getRandomValue(int min, int max) {
		Random random = new Random();
		long range = (long)max - (long)min + 1;
		long fraction = (long)(range * random.nextDouble());
		return (int)(fraction + min);
	}

}
