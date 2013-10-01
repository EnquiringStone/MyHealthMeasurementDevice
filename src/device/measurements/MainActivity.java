package device.measurements;

import com.example.myhealthmeasurementdevice.R;

import device.measurements.values.*;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {  
	
	public static final int BLOOD_PRESSURE=0;
	public static final int PULSE=1;
	public static final int ECG=2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Spinner spinner = (Spinner) findViewById(R.id.choose_measurements);
		
		ArrayAdapter<CharSequence> adpt = ArrayAdapter.createFromResource(this, R.array.measurement_options, android.R.layout.simple_list_item_1);
		adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adpt);
	}
	
	public class MeasureTask extends AsyncTask<String, Void, String>
	{
		protected String doInBackground(String... measurementId)
		{
			Measurement measurement= this.getMeasurementType(Integer.parseInt(measurementId[0]));
			String jsonString = measurement.getMeasurementData();
			Log.d("pulsetest", jsonString);
			return null;
			
		}
		
		private Measurement getMeasurementType(int type) {
			Measurement measurement = null;
			switch(type)
			{
				case BLOOD_PRESSURE:
				measurement = new BloodPressure();
				break;
					
				case ECG:
				measurement = new ECGWaves();
				break;
				
				case PULSE:
				measurement = new Pulse();
				break;
			}
			return measurement;
		}
	}
	
	public void startMeasure(View view)
	{
		Spinner spinner = (Spinner) findViewById(R.id.choose_measurements);
		String selectedMeasurementId = Long.valueOf(spinner.getSelectedItemId()).toString();
		new MeasureTask().execute(selectedMeasurementId);
	}
}
