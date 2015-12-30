package com.example.takeaway;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

public  class ForgotPassword extends Activity implements OnItemSelectedListener, OnClickListener {

	private Spinner spinner1;
	private Button btnsubmit;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgot_password);
		spinner1 =(Spinner) findViewById(R.id.Spinner2);
		btnsubmit =(Button) findViewById(R.id.submit);
		
		spinner1.setOnItemSelectedListener(this);
		btnsubmit.setOnClickListener(this);
		
	}
	
	
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.submit){
			
			  try {    
                  GmailSender sender = new GmailSender("vijay98480@gmail.com", "khk");
                  sender.sendMail("This is Subject",   
                          "This is Body",    
                          "vijay98480@gmail.com",    
                          "vijay98480@gmail.com");    
              } catch (Exception e) {   
                  Log.e("SendMail", e.getMessage(), e);   
              }  
	}
		
	}
}
