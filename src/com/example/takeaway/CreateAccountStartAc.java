package com.example.takeaway;


import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccountStartAc extends Activity implements OnClickListener,OnRegistrationCompleted {
	
	TextView Terms;
	Button create;
	EditText etFirstName,etLastName,etUserName,etPswd,etRetype,etEmail,etphone;
		Check_Services isNetwork;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_account_start);
		
		Terms = (TextView) findViewById(R.id.terms);
		create = (Button) findViewById(R.id.createbutton);
		
		etFirstName = (EditText) findViewById(R.id.etFirstName);
		etLastName = (EditText) findViewById(R.id.etLatName);
		etUserName = (EditText) findViewById(R.id.etUserName);
		etPswd = (EditText) findViewById(R.id.etpswd);
		etRetype = (EditText) findViewById(R.id.etRetype);
		etEmail = (EditText) findViewById(R.id.etEmail);
		etphone = (EditText) findViewById(R.id.etphone);
		
		
		
		create.setOnClickListener(this);
		Terms.setOnClickListener(this);
		
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub		
		
		if (v.getId()==R.id.terms){
			startActivity(new Intent(CreateAccountStartAc.this,TermsandConditions.class));
	}
		else if(v.getId()==R.id.createbutton){
			if(etFirstName.getText().toString().length() >1 && etLastName.getText().toString().length() > 1 && etUserName.getText().toString().length()>1 &&
					etPswd.getText().toString().length() > 1 && etRetype.getText().toString().length()>1 && etEmail.getText().toString().length() > 1
					&& etphone.getText().toString().length() > 1){
              
				if(etPswd.getText().toString().equals(etRetype.getText().toString())){
					isNetwork = (Check_Services) getApplicationContext();
				  	if(isNetwork.isNetworkAvailable()){
					RegistraionAsync post = new RegistraionAsync(CreateAccountStartAc.this);
	                post.execute(new String[]{etEmail.getText().toString(),etPswd.getText().toString(),etFirstName.getText().toString(),etLastName.getText().toString(),
	                        "07-03-1991",etphone.getText().toString(),"101","m"});
				  	}else{
						Toast.makeText(this, "No Internet!!!", Toast.LENGTH_LONG).show();
					}
				}else{
					Toast.makeText(this, "password mismatch!!!", Toast.LENGTH_LONG).show();
				}
			
            }else{
                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_LONG).show();
            }		
		}
	}

	@Override
	public void onRegisterComplete(String result) {
		// TODO Auto-generated method stub
				Log.d("on regiser resukt", result);
        try {
            JSONObject jObj = new JSONObject(result);

            String status = jObj.getString("status");
            String error = jObj.getString("error");
            String userid = jObj.getString("userId");
            if(status.contains("150")){
            	CommonsUtils.putPrefBooleans(getApplicationContext(), true, "login");
            	startActivity(new Intent(CreateAccountStartAc.this,AppMainPage.class));
            	Toast.makeText(getApplicationContext(), "Registered Successfully", 1).show();
            	finish();
            }
        }catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        
	}
}
