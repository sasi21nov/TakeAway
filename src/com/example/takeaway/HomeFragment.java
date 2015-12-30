package com.example.takeaway;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements OnClickListener {
	
	public HomeFragment(){}
	
	Button housing;
	Button electronics;
	Button motorVehicles;
	Button other;
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.home, container, false);
        
        housing = (Button) rootView.findViewById(R.id.housing);
        electronics =(Button) rootView.findViewById(R.id.electronics);
        motorVehicles =(Button) rootView.findViewById(R.id.motorVehicles);
        other =(Button) rootView.findViewById(R.id.others);
        
        
        
        
        
        housing.setOnClickListener(this);
        electronics.setOnClickListener(this);
        motorVehicles.setOnClickListener(this);
        other.setOnClickListener(this);
         
        return rootView;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.housing){
			startActivity(new Intent(getActivity(),Housing.class));
		}
		else if(v.getId()== R.id.electronics){
			startActivity(new Intent(getActivity(),Electronics.class));
				}
		else if(v.getId()== R.id.motorVehicles){
			startActivity(new Intent(getActivity(),MotorVehicle.class));
		}
		else if(v.getId()== R.id.others){
			startActivity(new Intent(getActivity(),OtherCategories.class));
		}
	}
}
