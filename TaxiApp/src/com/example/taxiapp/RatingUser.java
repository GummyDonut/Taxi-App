package com.example.taxiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingUser extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_profile);
        float givenRating = 2.5f;
        //setting rating from sever?
        final RatingBar giveUserating =(RatingBar)findViewById(R.id.AskingUserRating);
        //giveUserating.setRating(givenRating); not setting it, will take it from user at the bottom THIS IS NEW

	//Dialog for confirming rating of user
	Button ratingConfirmation= (Button) findViewById(R.id.ConfirmRating);
    final AlertDialog ratingConfirmDialog = new AlertDialog.Builder(this).create();
    
    ratingConfirmDialog.setMessage("Do you wish to confirm the rating?");
    ratingConfirmDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Confirm", 
    new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			
		}
	});
    ratingConfirmDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", 
            new DialogInterface.OnClickListener() {
    			
    			@Override
    			public void onClick(DialogInterface dialog, int which) {
    				// TODO Auto-generated method stub
    				//THIS IS NEW trying to taking the rating user set and display it after pressing cancel
    				float rating=giveUserating.getRating();
    				String nRating = String.valueOf(rating);
    		        TextView displayRatingUser = (TextView)findViewById(R.id.displayRating);
    		        displayRatingUser.setText(nRating);
    			}
    		});
            
    ratingConfirmation.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ratingConfirmDialog.show();
			
			}
		});
	}	
}
