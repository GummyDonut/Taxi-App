package com.example.taxiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ViewProfile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_profile);
        
        //adding text input through code rather than in the xml
/*        TextView tv1 = (TextView)findViewById(R.id.UNumbRating);
        tv1.setText("Hello");*/
        float rating = 2.5f;
        String fName = "Mango";
        String lName = "Cake";
        Integer [] Birth = {01, 31, 1999};
        String ThisGender = "Female";
        String [] Hobbies = {"cook", "read"};
        String [] Interest = {"Ski", "bike"};
        
        
        //setting  first name
        TextView nameF = (TextView)findViewById(R.id.UCFName);
        nameF.setText(fName);
        //setting last name
        TextView nameL = (TextView)findViewById(R.id.UCLName);
        nameL.setText(lName);
        //setting date of birthday
        TextView DayBirth = (TextView)findViewById(R.id.ucdob);
        DayBirth.setText(Birth[0] + "/" +Birth[1] + "/" +Birth[2]);// DOES NOT SHOW UP
        //setting gender
        TextView Sex = (TextView)findViewById(R.id.UCGender);
        Sex.setText(ThisGender);
        //setting hobbies
        TextView HObbies = (TextView)findViewById(R.id.cuhobbies);
        HObbies.setText(Hobbies[0] + ", " +Hobbies[1]);
        //setting interests
        TextView INterests = (TextView)findViewById(R.id.ucinterest);
        INterests.setText(Interest[0] + ", " +Interest[1]);
        //adding number for user rating through code
        RatingBar Userating =(RatingBar)findViewById(R.id.CUserRating);
        Userating.setRating(rating);
        
        
        Button udelete= (Button) findViewById(R.id.deleteAcc);
        Button logout= (Button) findViewById(R.id.logOut);
        Button editprofile= (Button) findViewById(R.id.editProfileBTN);
        
        final AlertDialog deleteDialog = new AlertDialog.Builder(this).create();
        
        deleteDialog.setMessage("Do you wish to delete your account?");
        deleteDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Delete", 
        new DialogInterface.OnClickListener() {
    		
    		@Override
    		public void onClick(DialogInterface dialog, int which) {
    			// TODO Auto-generated method stub
    			//This is where the user get forwarded to the log in page
    			//also send information to the data to delete the stored information
    		}
    	});
        
       deleteDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", 
                new DialogInterface.OnClickListener() {
        			
        			@Override
        			public void onClick(DialogInterface dialog, int which) {
        				// TODO Auto-generated method stub
        				
        			}
        		});
                
        udelete.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			deleteDialog.show();
    			
    		}
    	});
        
        
        editprofile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				forwardedit();	
				
			}
		});
        
    }
    
    private void forwardedit(){
    Intent toeditpage = new Intent(this, EditProfile.class);
    startActivity(toeditpage);
    } 
   /* TextView tv1 = (TextView) findViewById(R.id.UNumbRating);{ 
    tv1.setText("2.5");
    setContentView(tv1);
}*/
    public void goToLogout(View view) {
    	Intent logoutIntent = new Intent(this, LoginActivity.class);
    	startActivity(logoutIntent);
    }
    public void goToRate(View view) {
    	Intent rateIntent = new Intent(this, RatingUser.class);
    	startActivity(rateIntent);
    }
}
