package device.measurements.values;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ECGWaves extends Measurement{

	private static final int lowMin = 0;
	private static final int lowMax = 5;

	private static final int highMin = 41;
	private static final int highMax = 47;

	private static final int heartbeatIntervalLow = 25;
	private static final int heartbeatIntervalHigh = 30;
	
	private static final int[] ecgValues={60, 59, 58, 57, 56, 56, 56, 56, 56, 56, 56, 55, 55, 56, 56, 56, 56, 56, 56, 57, 57, 57, 56, 56, 56, 56, 55, 55, 55, 55, 56, 56, 55, 55, 55, 55, 55, 55, 54, 54, 54, 55, 56, 57, 58, 58, 58, 58, 56, 55, 55, 54, 54, 53, 53, 54, 54, 55, 56, 58, 59, 59, 58, 56, 55, 55, 55, 56, 56, 56, 56, 57, 57, 57, 57, 57, 57, 57, 57, 57, 57, 57, 57, 57, 58, 58, 58, 58, 58, 58, 58, 57, 57, 58, 59, 60, 59, 58, 58, 57, 57, 57, 57, 58, 58, 58, 58, 59, 60, 61, 61, 61, 62, 62, 61, 61, 60, 61, 61, 62, 63, 63, 63, 64, 64, 64, 64, 64, 64, 63, 62, 62, 62, 62, 62, 62, 62, 62, 63, 63, 62, 61, 60, 60, 60, 59, 58, 57, 56, 56, 56, 56, 57, 57, 57, 57, 57, 57, 57, 57, 56, 56, 56, 56, 56, 57, 57, 57, 57, 56, 56, 56, 56, 56, 57, 57, 58, 57, 57, 56, 56, 55, 54, 52, 49, 47, 45, 44, 45, 48, 52, 58, 66, 75, 86, 99, 111, 121, 127, 129, 126, 119, 108, 94, 79, 66, 57, 51, 46, 43, 42, 44, 49, 54, 58, 59, 58, 57, 56, 55, 56, 57, 59, 61, 62, 62, 61, 60, 59, 58, 57, 57, 57, 59, 61, 62, 63, 62, 62, 62, 62, 62, 62, 62, 62, 62, 63, 64, 64, 64, 64, 64, 64, 65, 65, 66, 67, 68, 69, 69, 68, 67, 66, 66, 66, 67, 67, 67, 67, 68, 69, 71, 73, 74, 74, 73, 71, 70, 69, 70, 70, 71, 70, 70, 70, 71, 72, 74, 75, 76, 76, 76, 77, 77, 77, 77, 78, 80, 81, 82, 82, 82, 83, 84, 85, 85, 86, 87, 88, 89, 91, 91, 91, 92, 92, 93, 93, 94, 94, 95, 95, 94, 94, 93, 92, 90, 89, 87, 86, 85, 82, 79, 76, 74, 73, 72, 71, 69, 67, 65, 64, 64, 63, 63, 62, 62, 62, 60, 59, 58, 57, 57, 57};

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
		String returnString="";
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i=0;i<ecgValues.length;i++)
		{
			int value=ecgValues[i];
			int min=(int) (value*0.94);
			int max=(int) (value*1.06);
			values.add(getRandomValue(min, max));
		}
		JSONArray array = new JSONArray(values);
		try {
			returnString = new JSONObject().put("ECG", array).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return returnString;
	}
}
