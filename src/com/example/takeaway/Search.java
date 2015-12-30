package com.example.takeaway;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class Search extends Fragment {

	public Search(){}
	AutoCompleteTextView text;
	String[] languages={"Dell","Sony","Lenova","Apple","Samsung","Sony","Iphone","Iphone 5s","Iphone 6","Talets","Laptops"
			,"Television","House","Individual","Paying Guest","Rent","Apartment",
			"Hyundai","Honda","Audi","Ford","BMW","Isuzu","Toyota","Lexus","Mercedes-Benz","Benz",
			"Wall Decoration set","Flower","Taps","Bean Bags","Sofa","Pillows","Coffee Cup","Cups","Bathroom Taps"};

	private ArrayList<String> itemname = new ArrayList<String>();
	private ArrayList<String> itemdesc = new ArrayList<String>();
	private ArrayList<Integer> imgid = new ArrayList<Integer>();
	
	int position = -1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.search, container, false);

		text=(AutoCompleteTextView) rootView.findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,languages);

		text.setAdapter(adapter);
		text.setThreshold(1);

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
		
		
		text.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position1, long id) {
				// TODO Auto-generated method stub
				position = -1;
				for(int i = 0 ; i < itemname.size() ; i++){
					if(parent.getItemAtPosition(position1).toString().contains(itemname.get(i))){
					position 	= i;
					}
				}
				if(position!= -1){
				Toast.makeText(getActivity(), itemname.get(position), 1).show();
				Bitmap bmp = BitmapFactory.decodeResource(getResources(), imgid.get(position));
				
				//Convert to byte array 
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
				byte[] byteArray = stream.toByteArray();
				Intent i = new Intent(getActivity(),CategoryDescription.class);
				i.putExtra("details",itemdesc.get(position));
				i.putExtra("tittle", itemname.get(position));
				i.putExtra("image",byteArray);
				startActivity(i);
				}else{
					Toast.makeText(getActivity(), "Not Found", 1).show();
				}
				/*if(parent.getItemAtPosition(position).toString().contains("Dell") || parent.getItemAtPosition(position).toString().contains("Lenovo")
						|| parent.getItemAtPosition(position).toString().contains("Samsung") || parent.getItemAtPosition(position).toString().contains("Sony")
						|| parent.getItemAtPosition(position).toString().contains("Apple") || parent.getItemAtPosition(position).toString().contains("Iphone")
						|| parent.getItemAtPosition(position).toString().contains("Iphone 5s") || parent.getItemAtPosition(position).toString().contains("Iphone 6")
						|| parent.getItemAtPosition(position).toString().contains("laptops") || parent.getItemAtPosition(position).toString().contains("Tablets")
						|| parent.getItemAtPosition(position).toString().contains("Television")){

					startActivity(new Intent(getActivity(),Electronics.class));
				}else if(parent.getItemAtPosition(position).toString().contains("House") || parent.getItemAtPosition(position).toString().contains("Individual")
						|| parent.getItemAtPosition(position).toString().contains("Paying") || parent.getItemAtPosition(position).toString().contains("Apartment")
						|| parent.getItemAtPosition(position).toString().contains("Rent") ){

					startActivity(new Intent(getActivity(),Electronics.class));
				}else if(parent.getItemAtPosition(position).toString().contains("Hyundai") || parent.getItemAtPosition(position).toString().contains("Honda")
						|| parent.getItemAtPosition(position).toString().contains("Audi") || parent.getItemAtPosition(position).toString().contains("Ford")
						|| parent.getItemAtPosition(position).toString().contains("BMW") || parent.getItemAtPosition(position).toString().contains("Isuzu")
						|| parent.getItemAtPosition(position).toString().contains("Toyota") || parent.getItemAtPosition(position).toString().contains("Lexus")
						|| parent.getItemAtPosition(position).toString().contains("Benz") ){
					
								startActivity(new Intent(getActivity(),MotorVehicle.class));
				}else{
					startActivity(new Intent(getActivity(),OtherCategories.class));
				}
*/			}
		});

		return rootView;
	}
}
