package device.measurements.values;

/**
 * Created with IntelliJ IDEA.
 * User: EnquiringStone
 * Date: 26-9-13
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
public class Pulse extends Measurement{
	//55-200
	private static final int pulseLow = 55;
	private static final int pulseHigh = 200;


	public static int getPulseLow() {
		return pulseLow;
	}

	public static int getPulseHigh() {
		return pulseHigh;
	}
	
	public int getRandomPulse() {
		return getRandomValue(pulseLow, pulseHigh);
	}
	
	public String getMeasurementData()
	{
		return String.valueOf(getRandomPulse());
	}
}
