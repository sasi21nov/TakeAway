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

public class StartActivity extends Activity implements OnClickListener,OnLoginCompleted {
	
	Button Login;
	TextView Appname,UserName,Password,ForgotPassword;
	EditText userdetails,userpswd;
	Check_Services isNetwork;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		Login = (Button) findViewById(R.id.agree);
		Appname =(TextView) findViewById(R.id.UserName);
		Password = (TextView) findViewById(R.id.Password);
		ForgotPassword =(TextView) findViewById(R.id.ForgotPassword);
		userdetails = (EditText) findViewById(R.id.UserDetails);
		userpswd = (EditText) findViewById(R.id.UserPassword);
				
		
		Login.setOnClickListener(this);
		ForgotPassword.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.agree){
			if(userdetails.getText() != null && userdetails.getText().length() > 1){
			  if(userdetails.getText().toString().matches("[0-9]+")){
				  	 isNetwork = (Check_Services) getApplicationContext();
				  	if(isNetwork.isNetworkAvailable()){
                  LoginAsync post = new LoginAsync(StartActivity.this);
                  post.execute(new String[]{userdetails.getText().toString(),userpswd.getText().toString(),"phone"});
			  }else{
				  Toast.makeText(getApplicationContext(), "No Internet", 1).show();
			  }

              }else{

                  LoginAsync post = new LoginAsync(StartActivity.this);
                  post.execute(new String[]{userdetails.getText().toString(),userpswd.getText().toString(),"email"});

              }
			}else{
				Toast.makeText(getApplicationContext(), "Please Enter Details", 1).show();
			}
			
		
	}
		else if(v.getId()==R.id.ForgotPassword){
			startActivity(new Intent(StartActivity.this,ForgotPassword.class));
			
		}
}


	@Override
	public void OnLoginCompleted(String result) {
		// TODO Auto-generated method stub

        Log.d("response login", result+"");
	if(result != null){
        try {
            JSONObject jObj = new JSONObject(result);

            String status = jObj.getString("status");
            String error = jObj.getString("error");
            String userid = jObj.getString("userId");
            if (status.contains("150")) {
               
                CommonsUtils.putPrefString(getApplicationContext(), userid,"userid");
                CommonsUtils.putPrefBooleans(getApplicationContext(), true, "login");
                startActivity(new Intent(StartActivity.this,AppMainPage.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                finish();

            } else {
            	CommonsUtils.putPrefBooleans(getApplicationContext(), false, "login");
                Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
	}

	}
}
