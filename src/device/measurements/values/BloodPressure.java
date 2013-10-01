package device.measurements.values;

import android.util.Log;

public class BloodPressure extends Measurement{

	private static final int diastolicPressureMin = 50;
	private static final int diastolicPressureMax = 90;

	private static final int multiplierSystolicPressureMin = 2;
	private static final int multiplierSystolicPressureMax = 5;


	public static int getDiastolicPressureMin() {
		return diastolicPressureMin;
	}

	public static int getDiastolicPressureMax() {
		return diastolicPressureMax;
	}

	public static int getMultiplierSystolicBloodPressureMin() {
		return multiplierSystolicPressureMin;
	}

	public static int getMultiplierSystolicBloodPressureMax() {
		return multiplierSystolicPressureMax;
	}

	public int getSystolicPressure(int diastolicPressure) {
		double value = this.getRandomValue(multiplierSystolicPressureMin, multiplierSystolicPressureMax);
		double multiplier = value / 10 + 1;
		double result = diastolicPressure * multiplier;
		return (int) result;
	}
	
	public int getDiastolicPressure() {
		return this.getRandomValue(BloodPressure.diastolicPressureMin, BloodPressure.diastolicPressureMax);
	}
	
	public String getMeasurementData()
	{
		int diastolic = getDiastolicPressure();
		return diastolic+"/"+getSystolicPressure(diastolic);
	}
}
