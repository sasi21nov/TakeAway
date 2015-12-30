package com.example.takeaway;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryDescription extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		TextView tvdetails = (TextView) findViewById(R.id.itemtype);
		TextView tvTittle = (TextView) findViewById(R.id.tvtittle);
		
		Button btCall = (Button) findViewById(R.id.call); 
		
		ImageView iv = (ImageView) findViewById(R.id.imageView1);
		
		Bundle extras = getIntent().getExtras();
		
		tvdetails.setText(extras.getString("details"));
		tvTittle.setText(extras.getString("tittle"));	
		
		byte[] byteArray = getIntent().getByteArrayExtra("image");
		Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
		iv.setImageBitmap(bmp);
		
		btCall.setOnClickListener(new OnClickListener() {

		    

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 String phnum = "+16602382988";
				    Intent callIntent = new Intent(Intent.ACTION_CALL);
				    callIntent.setData(Uri.parse("tel:" + phnum));
				    startActivity(callIntent);
			}
		  });
				
	}

	
}
