package com.example.tinhbmi;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Button btTinh;
	EditText txtChieuCao,txtCanNang,txtBMI,txtChuanDoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btTinh=(Button) findViewById(R.id.btnProcess);
        txtChieuCao=(EditText) findViewById(R.id.edHeight);
        txtCanNang=(EditText) findViewById(R.id.edWeight);
        txtBMI =(EditText) findViewById(R.id.edBMI);
        txtChuanDoan=(EditText) findViewById(R.id.edResult);
        
        btTinh.setOnClickListener(this);
        
    }
    /*
     * Kiem tra input chieu cao va can nang co hop le
     * h: chieu cao
     * w: Can nang
     */
    public boolean Check(String h,String w){
    	boolean kq=true;
    	try{
    		float hi=Float.parseFloat(h);
    		float we=Float.parseFloat(w);
    	} catch(Exception e){
    		return false;
    	}
    	return kq;
    }

    public double TinhBMI(){
    	String cao=txtChieuCao.getText().toString();
		String nang=txtCanNang.getText().toString();
		if(Check(cao, nang)){
			double c =Double.parseDouble(cao);
			double n =Float.parseFloat(nang);
			double kq=n/Math.pow(c, 2);
			return kq;
		}
		else return -1;
    }
    
    public String chuanDoan(double bmi){
    	if(bmi<18) {
    		return "Người gầy";
    	} else if(bmi>=18&&bmi<=24.9){
    		return "Người bình thường";
    	} else if(bmi>=25&&bmi<=34.9){
    		return "Người béo phì độ I";
    	} else if(bmi>=30&&bmi<34.9){
    		return "Người béo phì độ II";
    	} else {
    		return "Người béo phì độ III";
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		double BMI=TinhBMI();
		if(BMI>0){
			txtBMI.setText(BMI+"");
			txtChuanDoan.setText(chuanDoan(BMI));
		}else {
			txtBMI.setText("Input Error !");
			txtChuanDoan.setText("Input Error !");
		}
		
	}
    
}
