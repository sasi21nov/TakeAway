package com.example.takeaway;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		  /****** Create Thread that will sleep for 5 seconds *************/         
        Thread background = new Thread() {
            public void run() { 
                  
                try { 
                    // Thread will sleep for 5 seconds 
                    sleep(2*1000);
                      
                    // After 5 seconds redirect to another intent 
                    if(CommonsUtils.getPrefBoolean(getApplicationContext(), "login")){
                    	Intent i=new Intent(getApplicationContext(),AppMainPage.class);
                        startActivity(i);
                    }else{
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    }
                      
                    //Remove activity 
                    finish();
                      
                } catch (Exception e) {
                  
                } 
            } 
        }; 
          
        // start thread 
        background.start();
	}

}
