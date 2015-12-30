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

public class Housing extends Activity implements OnItemClickListener {
	
	ListView list;
	private ArrayList<String> itemname = new ArrayList<String>();
	private ArrayList<String> itemdesc = new ArrayList<String>();
	private ArrayList<Integer> imgid = new ArrayList<Integer>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_house_rentals);
		
		itemname.add("Individual House");
		itemname.add("Paying Guest");
		itemname.add("Apartment");
		itemname.add("Apartment");
		itemname.add("Individual House");
		itemname.add("Apartment");
		itemname.add("Apartment");
		itemname.add("Individual House");
		itemname.add("Paying Guest");
		itemname.add("Apartment");
		
		itemdesc.add("Individual house with 3 bedroom and 2 bath.");
		itemdesc.add("House consists of all facilities with hall, kithchen and 1 bath");
		itemdesc.add("3rd Floor apartment with 2 bedroom and 2 bath, consists of lift and maintainenece charges apply.");
		itemdesc.add("Fully Furnished apartment with 2 bedroom and 2 bath, it contains lift and maintainence charges apply");
		itemdesc.add("description");
		itemdesc.add("Fully Furnished apartment with 2 bedroom and 2 bath, it contains lift and maintainence charges apply");
		itemdesc.add("Fully Furnished apartment with 2 bedroom and 2 bath, it contains lift and maintainence charges apply");
		itemdesc.add("Fully Furnished apartment with 2 bedroom and 2 bath, it contains lift and maintainence charges apply");
		itemdesc.add("3rd Floor apartment with 2 bedroom and 2 bath, consists of lift and maintainenece charges apply.");
		itemdesc.add("Individual house with 3 bedroom and 2 bath.");
		
		
		imgid.add(R.drawable.himg1);
		imgid.add(R.drawable.himg2);
		imgid.add(R.drawable.himg3);
		imgid.add(R.drawable.himg4);
		imgid.add(R.drawable.himg5);
		imgid.add(R.drawable.himg6);
		imgid.add(R.drawable.himg7);
		imgid.add(R.drawable.himg8);
		imgid.add(R.drawable.himg9);
		imgid.add(R.drawable.himg10);
		
		 CustomListAdapter adapter=new CustomListAdapter(this, itemname,itemdesc, imgid);
		 list=(ListView)findViewById(R.id.list);
		 list.setAdapter(adapter);
		 
		 list.setOnItemClickListener(this);
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
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
