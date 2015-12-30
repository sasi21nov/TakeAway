package com.example.takeaway;



import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.example.takeaway.OnLoginCompleted;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

;

public class LoginAsync extends AsyncTask<String, String, String> {

	View view;
	OnLoginCompleted onLoginCompleted;
	String json;
	
	public LoginAsync(OnLoginCompleted onLoginCompleted) {
        
        this.onLoginCompleted = onLoginCompleted;
    }
	
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		 HttpClient httpclient = new DefaultHttpClient();
	        HttpPost httppost = new HttpPost("http://ec2-52-27-57-49.us-west-2.compute.amazonaws.com//user");

	        try {
	            // Add your data
	            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	            nameValuePairs.add(new BasicNameValuePair(params[2], params[0]));
	            nameValuePairs.add(new BasicNameValuePair("password", params[1]));
	            nameValuePairs.add(new BasicNameValuePair("type", "102"));
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	            

	            // Execute HTTP Post Request
	            HttpResponse response = httpclient.execute(httppost);
	            HttpEntity httpEntity = response.getEntity();
	            InputStream is = httpEntity.getContent();

	    		try {
	    			BufferedReader reader = new BufferedReader(new InputStreamReader(
	    					is, "UTF8"), 8);
	    			

	    			StringBuilder sb = new StringBuilder();
	    			String line = null;
	    			while ((line = reader.readLine()) != null) {
	    				sb.append(line + "\n");
	    			}
	    			is.close();
	    			
	    			json = sb.toString();
	    			
	    		
	    			
	    		} catch (Exception e) {
	    			/*Toast t = Toast.makeText(getApplicationContext(),
	    					"Buffer Error",
	    					Toast.LENGTH_LONG);*/
	    			/*t.show();*/
	    			Log.e("Buffer Error", "Error converting result " + e.toString());
	    		}

	        } catch (ClientProtocolException e) {
	            // TODO Auto-generated catch block
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	        }
		return json;
	}

	 @Override
	    protected void onPreExecute() {
	    }

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		onLoginCompleted.OnLoginCompleted(result);
	}

	 
}
