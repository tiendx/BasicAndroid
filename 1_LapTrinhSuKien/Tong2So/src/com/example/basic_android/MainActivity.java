package com.example.basic_android;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // function check String is number
    public boolean isNumber(String str){
    	try {
    		int a=Integer.parseInt(str);
    	} catch(Exception e){
    		return false;
    	}
    	return true;
    }

    public void btn_sum(View v){
    	int a=0,b=0;
    	EditText edita=(EditText) findViewById(R.id.edNum1);
    	EditText editb=(EditText) findViewById(R.id.edNum2);
    	String strA=edita.getText().toString();
    	String strB=editb.getText().toString();
    	TextView txtResult =(TextView) findViewById(R.id.tvResult);
    	if(isNumber(strA)==true&&isNumber(strB)==true){
        	a=Integer.parseInt(strA);
        	b=Integer.parseInt(strB);
    		txtResult.setText(a+"+"+b+"="+(a+b));
    	} else {
    		txtResult.setText("Error input");
    	}
    		
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}
