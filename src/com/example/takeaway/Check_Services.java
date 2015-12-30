package com.example.takeaway;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Config;



public class Check_Services extends Application{



	public  boolean isNetworkAvailable(){
		ConnectivityManager connectivity = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivity.getActiveNetworkInfo();
		//For 3G check
		boolean is3g = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.isConnectedOrConnecting();
//For WiFi Check
		boolean isWifi = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
				.isConnectedOrConnecting();

		return activeNetworkInfo != null && activeNetworkInfo.isConnected();

	}
	
}
