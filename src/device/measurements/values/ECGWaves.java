package device.measurements.values;

import java.util.ArrayList;

import org.json.JSONArray;

public class ECGWaves extends Measurement{

	private static final int lowMin = 0;
	private static final int lowMax = 5;

	private static final int highMin = 41;
	private static final int highMax = 47;

	private static final int heartbeatIntervalLow = 25;
	private static final int heartbeatIntervalHigh = 30;

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
	
	public String getMeasurementData()
	{
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i=0;i<300;i++)
		{
			values.add(getCurrentValue());
		}
		JSONArray array = new JSONArray(values);
		return array.toString();
	}
}
