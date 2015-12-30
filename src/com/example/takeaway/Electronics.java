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

public class Electronics extends Activity implements OnItemClickListener {
	
	ListView list;
	private ArrayList<String> itemname = new ArrayList<String>();
	private ArrayList<String> itemdesc = new ArrayList<String>();
	private ArrayList<Integer> imgid = new ArrayList<Integer>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_electronics);
		
		itemname.add("Dell Laptops");
		itemname.add("Lenovo Tablet");
		itemname.add("Samsung Tablet");
		itemname.add("Dell Laptop");
		itemname.add("Sony Laptop");
		itemname.add("Dell Laptop");
		itemname.add("Apple Iphone6 Silver");
		itemname.add("Apple Iphone6 Gold");
		itemname.add("Samsung Television 40");
		itemname.add("Sony Television 46");
		
		itemdesc.add("15.6 inch Dell laptops Touch Screen ");
		itemdesc.add("7 inch Lenovo Tablet with full touch screen 2.2 GHz processor, 8 MP camera, 2Gb Ram");
		itemdesc.add("7 inch Samsung Tablet with full touch screen 2.2 GHz processor, 16 MP camera, 4Gb Ram.");
		itemdesc.add("Dell Inspiron 3541 (Notebook) (APU Dual Core E1/ 4GB/ 500GB/ Win8.1) (X560161IN9)");
		itemdesc.add("Dell Inspiron 3541 (Notebook) (APU Dual Core E1/ 8GB/ 1TB/ Win8.1) (X560521IN9)");
		itemdesc.add("Sony VAIO Fit 15 SVF15A13SNB Laptop (3rd Gen Ci5/ 4GB/ 750GB/ Win8/ 2GB Graph/ Touch)");
		itemdesc.add("Apple iPhone 6(Space Silver, 16 GB)");
		itemdesc.add("Apple iPhone 6(Space Gold, 64 GB)");
		itemdesc.add("Samsung 32B200HDi 81 cm (40) LED TV(HD Ready).");
		itemdesc.add("Sony 32B200HDi 81 cm (46) LED TV(HD Ready)");
		
		
		imgid.add(R.drawable.eimg1);
		imgid.add(R.drawable.eimg2);
		imgid.add(R.drawable.eimg3);
		imgid.add(R.drawable.eimg4);
		imgid.add(R.drawable.eimg5);
		imgid.add(R.drawable.eimg6);
		imgid.add(R.drawable.eimg7);
		imgid.add(R.drawable.eimg8);
		imgid.add(R.drawable.eimg9);
		imgid.add(R.drawable.eimg10);
		
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
