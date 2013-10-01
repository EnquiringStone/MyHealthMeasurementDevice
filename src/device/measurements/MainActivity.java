package device.measurements;

import org.json.JSONObject;

import com.example.myhealthmeasurementdevice.R;

import device.measurements.values.*;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {  
	
	public static boolean MEASURING=false;
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
			while(MEASURING) 
			{
				String jsonString = JSONObject.quote(measurement.getMeasurementData());
				Log.d("pulsetest", jsonString);
				try
				{
					Thread.sleep(500);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
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
		Button button = (Button) view;
		Spinner spinner = (Spinner) findViewById(R.id.choose_measurements);
		String selectedMeasurementId = Long.valueOf(spinner.getSelectedItemId()).toString();
		
		Log.d("pulsetest", ""+selectedMeasurementId);
		
		MEASURING=!MEASURING;
		if(MEASURING)
		{
			button.setText("Stop Measuring");
			new MeasureTask().execute(selectedMeasurementId);
		}
		else
		{
			button.setText("Start Measuring");
		}
	}
}
