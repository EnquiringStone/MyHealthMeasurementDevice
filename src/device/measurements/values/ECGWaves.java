package device.measurements.values;

public class ECGWaves extends Measurement{

	private static final int lowMin = 0;
	private static final int lowMax = 8;

	private static final int highMin = 23;
	private static final int highMax = 31;

	private static final int heartbeatIntervalLow = 2;
	private static final int heartbeatIntervalHigh = 5;

	private int currentMeasurement;

	public ECGWaves() {
		this.currentMeasurement = 0;
	}

	public int getCurrentValue() {
		if(this.currentMeasurement >= getRandomValue(heartbeatIntervalLow, heartbeatIntervalHigh)) {
			this.currentMeasurement = 0;
			return getRandomValue(highMin, highMax);
		}
		currentMeasurement ++;
		return getRandomValue(lowMin, lowMax);
	}
}
