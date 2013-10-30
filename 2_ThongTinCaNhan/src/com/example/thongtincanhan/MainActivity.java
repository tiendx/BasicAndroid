/*
 * @ https://github.com/tiendx/BasicAndroid/
 * @ Date: 29/10/2013
 */
package com.example.thongtincanhan;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	private EditText eHoTen, eCMND, eThongTinBS;
	private RadioGroup rBangcap;
	private CheckBox cDocBao, cDocSach, cDocCoding;

	private Button bGuiTT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getControl();
		addEvent();
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		bGuiTT.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder b = new AlertDialog.Builder(
						MainActivity.this);
				b.setTitle("Thông tin cá nhân");
				b.setMessage(getThongTin());
				b.setPositiveButton("Đóng",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								dialog.cancel();
							}
						});
				b.create().show();
			}
		});

	}

	protected String getThongTin() {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer();
		str.append(eHoTen.getText() + "\n");
		str.append(eCMND.getText() + "\n");

		int idCheckedRadio = rBangcap.getCheckedRadioButtonId();
		switch (idCheckedRadio) {
		case R.id.radio0:
			RadioButton r0 = (RadioButton) findViewById(R.id.radio0);
			str.append(r0.getText() + "\n");
			break;
		case R.id.radio1:
			RadioButton r1 = (RadioButton) findViewById(R.id.radio1);
			str.append(r1.getText() + "\n");
			break;
		case R.id.radio2:
			RadioButton r2 = (RadioButton) findViewById(R.id.radio2);
			str.append(r2.getText() + "\n");
			break;
		}

		int i = 0;
		if (cDocBao.isChecked()) {
			str.append(cDocBao.getText());
			i = 1;
		}
		if (cDocSach.isChecked()) {
			i = i + 1;
			if (i == 2)
				str.append("-" + cDocSach.getText());
			else
				str.append(cDocSach.getText());
		}
		if (cDocCoding.isChecked()) {
			if (i > 0)
				str.append("-" + cDocCoding.getText());
			else
				str.append(cDocCoding.getText());
		}
		str.append("\n-----------------\nThông tin bổ sung\n");
		str.append(eThongTinBS.getText()+"\n");
		str.append("-----------------");
		return str.toString();
	}

	private void getControl() {
		// TODO Auto-generated method stub
		eHoTen = (EditText) findViewById(R.id.edHoTen);
		eCMND = (EditText) findViewById(R.id.edCMND);

		rBangcap = (RadioGroup) findViewById(R.id.rdBangCap);

		cDocBao = (CheckBox) findViewById(R.id.chkDocBao);
		cDocSach = (CheckBox) findViewById(R.id.chkDocSach);
		cDocCoding = (CheckBox) findViewById(R.id.chkDocCoding);

		eThongTinBS = (EditText) findViewById(R.id.edThongTinBS);

		bGuiTT = (Button) findViewById(R.id.btnGuiTT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
