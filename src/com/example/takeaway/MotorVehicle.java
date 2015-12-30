package com.example.takeaway;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import adapter.CustomListAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MotorVehicle extends Activity implements OnItemClickListener {
	
	ListView list;
	private ArrayList<String> itemname = new ArrayList<String>();
	private ArrayList<String> itemdesc = new ArrayList<String>();
	private ArrayList<Integer> imgid = new ArrayList<Integer>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_motor_vehicles);
		
		itemname.add("HYUNDAI");
		itemname.add("HONDA");
		itemname.add("AUDI");
		itemname.add("FORD");
		itemname.add("BMW");
		itemname.add("ISUZU");
		itemname.add("TOYOTA");
		itemname.add("SUZUKI");
		itemname.add("LEXUS");
		itemname.add("MERCEDES-BENZ");
		
		itemdesc.add("Car For Sale. HYUNDAI ELEGANCE single hand lady driven just like brand new car ");
		itemdesc.add("Honda Brio Good Condition for Driving lover");
		itemdesc.add("2010 AUDI A6 DIESEL well maintained.");
		itemdesc.add("Ford fista2012 modal");
		itemdesc.add("Look like good one, BMW LXI, Child A/c,Doubly Audio & Video System");
		itemdesc.add("ISUZU 2004 well maintained new seat covers good tyres");
		itemdesc.add("TOYOTA SINGLE HAND DRIVEN fully loaded original paint brand new");
		itemdesc.add("SUZUKI ZEN Diesel (2003) white, PKL 2 dig. no. 0095, gd conditi");
		itemdesc.add("LEXUS Car in Good Condition");
		itemdesc.add("Mercedes_Benz Car in good Condition with new seat covers and good tyres.");
		
		
		imgid.add(R.drawable.mimg1);
		imgid.add(R.drawable.mimg2);
		imgid.add(R.drawable.mimg3);
		imgid.add(R.drawable.mimg4);
		imgid.add(R.drawable.mimg5);
		imgid.add(R.drawable.mimg6);
		imgid.add(R.drawable.mimg7);
		imgid.add(R.drawable.mimg8);
		imgid.add(R.drawable.mimg9);
		imgid.add(R.drawable.mimg10);
		
		 CustomListAdapter adapter=new CustomListAdapter(this, itemname,itemdesc, imgid);
		 list=(ListView)findViewById(R.id.list);
		 list.setAdapter(adapter);
		 
		 list.setOnItemClickListener(this);
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), itemname.get(position), 1).show();
				Bitmap bmp = BitmapFactory.decodeResource(getResources(), imgid.get(position));
				
				//Convert to byte array 
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
				byte[] byteArray = stream.toByteArray();
				Intent i = new Intent(this,CategoryDescription.class);
				i.putExtra("details",itemdesc.get(position));
				i.putExtra("tittle", itemname.get(position));
				i.putExtra("image",byteArray);
				startActivity(i);
}

	
}
