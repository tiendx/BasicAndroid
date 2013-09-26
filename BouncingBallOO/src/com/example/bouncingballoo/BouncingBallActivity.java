package com.example.bouncingballoo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
  
public class BouncingBallActivity extends Activity {
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      View bouncingBallView = new BouncingBallView(this);
      bouncingBallView.setBackgroundColor(Color.BLACK);
      setContentView(bouncingBallView);
   }
}