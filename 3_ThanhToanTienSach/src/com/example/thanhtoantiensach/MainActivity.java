package com.example.thanhtoantiensach;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText eTenKH, eSLSach, eTongKH, eTongKHVip, eTongDT;
	private CheckBox cKHVip;
	private TextView tSoTien;
	private Button btnTinh, btnTiep, btnThongKe;
	private ImageButton imgButton;

	boolean flag = false;

	DSKhachHang danhsach = new DSKhachHang();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getControl();
		addEvent();
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		btnTiep.setOnClickListener(new MyEvent());
		btnTinh.setOnClickListener(new MyEvent());
		btnThongKe.setOnClickListener(new MyEvent());
		imgButton.setOnClickListener(new MyEvent());
	}

	private void getControl() {
		// TODO Auto-generated method stub
		eTenKH = (EditText) findViewById(R.id.edTenKH);
		eSLSach = (EditText) findViewById(R.id.edSoLuongSach);

		cKHVip = (CheckBox) findViewById(R.id.chkKHVip);
		tSoTien = (TextView) findViewById(R.id.tvThanhTien);

		btnTinh = (Button) findViewById(R.id.butTinhTT);
		btnTiep = (Button) findViewById(R.id.butTiep);
		btnThongKe = (Button) findViewById(R.id.butTK);

		eTongKH = (EditText) findViewById(R.id.edTongKH);
		eTongKHVip = (EditText) findViewById(R.id.edTongKHVip);
		eTongDT = (EditText) findViewById(R.id.edTongDoanhThu);

		imgButton = (ImageButton) findViewById(R.id.butExit);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class MyEvent implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (arg0 == btnTinh) {
				process_btnTinh();
			} else if (arg0 == btnTiep) {
				process_btnTiep();
			} else if (arg0 == btnThongKe) {
				process_btnThongKe();
			} else if (arg0 == imgButton) {
				finish();
			}
		}

	}

	public void process_btnTinh() {
		// TODO Auto-generated method stub
		String strSoSach = eSLSach.getText().toString();
		KhachHang kh = new KhachHang();
		if (check(strSoSach)) {
			int n = Integer.parseInt(strSoSach);
			kh.setTenKH(eTenKH.getText().toString());
			kh.setSoLuong(n);

			if (cKHVip.isChecked())
				kh.setVIP(true);
			else
				kh.setVIP(false);

			this.tSoTien.setText(kh.getSoTien() + "");

		} else {
			tSoTien.setText("Error Input !");
		}

	}

	private boolean check(String strSoSach) {
		// TODO Auto-generated method stub
		try {
			int in = Integer.parseInt(strSoSach);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void process_btnThongKe() {
		// TODO Auto-generated method stub
		this.eTongKH.setText(this.danhsach.getTongKH()+"");
		this.eTongKHVip.setText(this.danhsach.getTongKHVip()+"");
		this.eTongDT.setText(this.danhsach.getTongDoanhThu()+"");
	}

	public void process_btnTiep() {
		// TODO Auto-generated method stub
		String strSoSach = eSLSach.getText().toString();
		KhachHang kh = new KhachHang();
		int n = Integer.parseInt(strSoSach);
		kh.setTenKH(eTenKH.getText().toString());
		kh.setSoLuong(n);

		if (cKHVip.isChecked())
			kh.setVIP(true);
		else
			kh.setVIP(false);

		danhsach.addKhachHang(kh);
		
		eTenKH.setText("");
		eTenKH.requestFocus();

		eSLSach.setText("");
		tSoTien.setText("");
		eTongKH.setText("");
		eTongKHVip.setText("");
		eTongDT.setText("");

	}

}
