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

public class OtherCategories extends Activity implements OnItemClickListener {
	
	ListView list;
	private ArrayList<String> itemname = new ArrayList<String>();
	private ArrayList<String> itemdesc = new ArrayList<String>();
	private ArrayList<Integer> imgid = new ArrayList<Integer>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_electronics);
		
		itemname.add("Wall Decoration Set");
		itemname.add("Flower Decoration Set");
		itemname.add("Taps for Washroom");
		itemname.add("Bathroom Taps");
		itemname.add("Bean Bag with Different Colors");
		itemname.add("Bean Bag with Red Color");
		itemname.add("Sofa set Pillows");
		itemname.add("Bedroom Pillows");
		itemname.add("Coffee Cup for Kids");
		itemname.add("Coffee Cup with BatMan Picture");
		
		itemdesc.add("Wall Decoration item consists of two photo frames Television cupboard and Flower Set");
		itemdesc.add("Interior Wall Decoration set for Bedroom");
		itemdesc.add("Water Taps for House");
		itemdesc.add("Taps for Bathrooms");
		itemdesc.add("Bean Bag with different colors along with beans included");
		itemdesc.add("Bean Bag with Red color including Beans");
		itemdesc.add("Sofa Set pillows with pillow cover : Color Red and Pure Cotton Quality: Item Condition: New)");
		itemdesc.add("Pillow Covers ");
		itemdesc.add("Coffee or Milk Cups for Children with Design");
		itemdesc.add("Specially Designed Batman Coffee or Milk Cup for Children");
		
		
		imgid.add(R.drawable.oimg1);
		imgid.add(R.drawable.oimg2);
		imgid.add(R.drawable.oimg3);
		imgid.add(R.drawable.oimg4);
		imgid.add(R.drawable.oimg5);
		imgid.add(R.drawable.oimg6);
		imgid.add(R.drawable.oimg7);
		imgid.add(R.drawable.oimg8);
		imgid.add(R.drawable.oimg9);
		imgid.add(R.drawable.oimg10);
		
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
