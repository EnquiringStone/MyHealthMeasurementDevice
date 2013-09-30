package device.measurements;

import com.example.myhealthmeasurementdevice.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Spinner spinner = (Spinner) findViewById(R.id.choose_measurements);
		
		ArrayAdapter<CharSequence> adpt = ArrayAdapter.createFromResource(this, R.array.measurement_options, android.R.layout.simple_list_item_1);
		adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adpt);
	}
}
