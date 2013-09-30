package device.measurements.values;

public class BloodPressure extends Measurement{

	//50-90 * 1,(random 2-5)
	private static final int lowBloodPressureMin = 50;
	private static final int lowBloodPressureMax = 90;

	private static final int multiplierHighBloodPressureMin = 2;
	private static final int multiplierHighBloodPressureMax = 5;


	public static int getLowBloodPressureMin() {
		return lowBloodPressureMin;
	}

	public static int getLowBloodPressureMax() {
		return lowBloodPressureMax;
	}

	public static int getMultiplierHighBloodPressureMin() {
		return multiplierHighBloodPressureMin;
	}

	public static int getMultiplierHighBloodPressureMax() {
		return multiplierHighBloodPressureMax;
	}

	public int getHighBloodPressure() {
		int value = this.getRandomValue(BloodPressure.multiplierHighBloodPressureMin, BloodPressure.multiplierHighBloodPressureMax);
		double multiplier = value / 10 + 1;
		int lowBloodPressure = this.getRandomValue(BloodPressure.lowBloodPressureMin, BloodPressure.lowBloodPressureMax);
		double result = lowBloodPressure * multiplier;
		return (int) result;
	}
}
