package com.example.taxiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chooseTwoRP extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rpoption_activity);
        
        Button logoutButton = (Button) findViewById(R.id.logoutBtn);
        Button createTrip = (Button) findViewById(R.id.tripInfoBtn);
        Button viewProfile = (Button) findViewById(R.id.viewProfileBtn);
        
        logoutButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
        
        createTrip.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getTripInfo();
			}
        	
        	
        });       
        
        viewProfile.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 goToViewProfile();
				
			}
        	
        	
        });
}
   
    private void getTripInfo(){
    	Intent tripInfoPage = new Intent(this, route_input.class);
    	startActivity(tripInfoPage);
    }
    private void goToViewProfile() {
    	Intent profileIntent = new Intent(this, ViewProfile.class);
    	startActivity(profileIntent);
    }
   /* public void goToMap(){
    	Intent mapIntent = new Intent(this, route_input.class);
    	startActivity(mapIntent);
    }*/
    }

