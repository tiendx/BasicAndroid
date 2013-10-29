package com.example.giaiptb2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText numA, numB, numC;
	Button btnTiep, btnGiai, btnThoat;
	TextView tvKQ;
	
	final public float VO_SO=1.123456f;
	final public float VO_NGHIEM=3.654321f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getControl();
		addAction();

	}

	private void addAction() {
		// TODO Auto-generated method stub
		btnTiep.setOnClickListener(new MyEvent());
		btnGiai.setOnClickListener(new MyEvent());
		btnThoat.setOnClickListener(new MyEvent());

	}

	private void getControl() {
		// TODO Auto-generated method stub
		numA = (EditText) findViewById(R.id.edNumA);
		numB = (EditText) findViewById(R.id.edNumB);
		numC = (EditText) findViewById(R.id.edNumC);

		btnTiep = (Button) findViewById(R.id.btTiepTuc);
		btnGiai = (Button) findViewById(R.id.btGiaPT);
		btnThoat = (Button) findViewById(R.id.btThoat);
		
		tvKQ =(TextView) findViewById(R.id.tvKetQua);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class MyEvent implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (v == btnTiep) {
				xuLy_btnTiep();
			} else if (v == btnGiai) {
				xuLy_btnGiai();
			} else if (v == btnThoat) {
				xuLy_btnThoat();
			}

		}

		private void xuLy_btnThoat() {
			// TODO Auto-generated method stub
			finish();

		}

		private void xuLy_btnGiai() {
			// TODO Auto-generated method stub
			String sA=numA.getText().toString();
			String sB=numB.getText().toString();
			String sC=numC.getText().toString();
			if(check(sA, sB, sC)==true){
				float a=Float.parseFloat(sA);
				float b=Float.parseFloat(sB);
				float c=Float.parseFloat(sC);
				
				if(a==0){
					if(b==0){
						if(c==0) tvKQ.setText("Vô số nghiệm");
						else tvKQ.setText("Vô nghiệm");
					}
					else{
						tvKQ.setText("Có 1 nghiệm X="+(-c/b));
					}
				}
				else {
					float delta=b*b-4*a*c;
					if(delta<0) tvKQ.setText("Vô nghiệm");
					else if(delta==0) {
						float x1=-b/(2*a);
						tvKQ.setText("Có nghiệm kép X1=X2="+x1);
					}
					else {
						float x1=(float) ((-b-Math.sqrt(delta))/(2*a));
						float x2=(float) ((-b+Math.sqrt(delta))/(2*a));
						tvKQ.setText("Có 2 nghiệm X1="+x1+" , x2="+x2);
					}
				}

			}
			else {
				tvKQ.setText("Input Error !");
				
			}
		}

		private void xuLy_btnTiep() {
			// TODO Auto-generated method stub
			numA.setText("");
			
			numA.requestFocus();
			numB.setText("");
			numC.setText("");
			
			tvKQ.setText("");

		}
		public boolean check(String a,String b,String c){
			try {
				float n1 =Float.parseFloat(a);
				float n2= Float.parseFloat(b);
				float n3= Float.parseFloat(c);
				
				return true;
			} catch(Exception e){
				return false;
			}
		}

	}

}
