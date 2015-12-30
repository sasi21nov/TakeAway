package com.example.takeaway;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener{

	Button Login,CreateAccount;
	TextView SignIn,AppName;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Login= (Button)findViewById(R.id.Login);
		CreateAccount= (Button)findViewById(R.id.CreateAccount);
		SignIn=(TextView)findViewById(R.id.SignIn);
		AppName=(TextView)findViewById(R.id.AppName);

		Login.setOnClickListener(this);
		CreateAccount.setOnClickListener(this);


	}

	/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	 */
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.Login){
			
				startActivity(new Intent(MainActivity.this,StartActivity.class));
		}
		else if(v.getId()==R.id.CreateAccount){
			startActivity(new Intent(MainActivity.this,CreateAccountStartAc.class));
		}
	}
}
