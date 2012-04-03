package br.com.coding.cervejaemconta;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CervejaEmContaActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				TextView result = (TextView) findViewById(R.id.result);
				EditText editA = (EditText) findViewById(R.id.editTextA);
				EditText editB = (EditText) findViewById(R.id.editTextB);
				RadioButton rA1 = (RadioButton) findViewById(R.id.radioA0);
				RadioButton rA2 = (RadioButton) findViewById(R.id.radioA1);
				RadioButton rA3 = (RadioButton) findViewById(R.id.radioA2);
				RadioButton rB1 = (RadioButton) findViewById(R.id.radioB0);
				RadioButton rB2 = (RadioButton) findViewById(R.id.radioB1);
				RadioButton rB3 = (RadioButton) findViewById(R.id.radioB2);

				String a = "0.0";
				String b = "0.0";

				a = editA.getText().toString();
				b = editB.getText().toString();

				if ((a.equals("") == true) || (b.equals("") == true)) {

					Context context = getApplicationContext();
					CharSequence text = "Entre com os preos!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();

					
				} else {

					float priceA = Float.parseFloat(a);
					float priceB = Float.parseFloat(b);

					float volumeA, volumeB;

					volumeA = 1;
					volumeB = 1;

					if (rA1.isChecked() == true) { volumeA = 355; }
					if (rA2.isChecked() == true) { volumeA = 470; }
					if (rA3.isChecked() == true) { volumeA = 250; }

					if (rB1.isChecked() == true) { volumeB = 355; }
					if (rB2.isChecked() == true) { volumeB = 470; }
					if (rB3.isChecked() == true) { volumeB = 250; }

					float resultA = priceA / volumeA;
					float resultB = priceB / volumeB;

					if (resultA > resultB) {
						result.setText("Compra a cerveja B!");           		
					}

					if (resultA < resultB) {
						result.setText("Compra a cerveja A!");           		
					}

					if (resultA == resultB) {
						result.setText("Compra qualquer uma ;-)");           		
					}
				}
			}

		});

	}
}