package com.example.convertfandc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText edFah, edCel;
	Button butCelsius, butFahrenheit, butClear;
	
	OnClickListener myClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (v == butCelsius) {
				ConvertToCelsius();
			} else if (v == butFahrenheit) {
				convertToFahrenheit();
			} else if (v == butClear) {
				clear();
			}

		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getControl();
		addAction();
	}

	private void addAction() {
		// TODO Auto-generated method stub
		butCelsius.setOnClickListener(myClickListener);
		butClear.setOnClickListener(myClickListener);
		butFahrenheit.setOnClickListener(myClickListener);

	}

	private void getControl() {
		// TODO Auto-generated method stub
		edCel = (EditText) findViewById(R.id.edCe);
		edFah = (EditText) findViewById(R.id.edFa);
		
		butCelsius = (Button) findViewById(R.id.btnToCel);
		butFahrenheit = (Button) findViewById(R.id.btnToFah);
		butClear = (Button) findViewById(R.id.btnClear);
	}

	protected void clear() {
		// TODO Auto-generated method stub
		edCel.setEnabled(true);
		edFah.setEnabled(true);
		edCel.setText("");
		edCel.requestFocus();
		edFah.setText("");
	}

	private void convertToFahrenheit() {
		// TODO Auto-generated method stub
		String txtCel = edCel.getText().toString();
		if(check(txtCel)){
			float c=Float.parseFloat(txtCel);
			float t=c*9/5+32;
			edFah.setText(t+"");
			edCel.requestFocus();
			edFah.setEnabled(false);
		}
		else {
			edFah.setText("Error input !");
		}
		edCel.setEnabled(false);
	}

	private void ConvertToCelsius() {
		// TODO Auto-generated method stub
		String txtFah = edFah.getText().toString();
		if(check(txtFah)){
			float t=Float.parseFloat(txtFah);
			float c=(t-32)*5/9;
			edCel.setText(c+"");
			edCel.requestFocus();
		}
		else {
			edCel.setText("Error input !");
		}
		edCel.setEnabled(false);
	}
	private boolean check(String str){
		try {
			float t=Float.parseFloat(str);
			return true;
		} catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
