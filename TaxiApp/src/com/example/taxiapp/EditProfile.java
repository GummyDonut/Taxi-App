package com.example.taxiapp;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;



public class EditProfile extends Activity{     
	
	EditText namef, namel, dobu, hobbiesu, interestu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
      
   
        RadioButton ugender[]= {
        		(RadioButton) findViewById(R.id.maleg),
        		(RadioButton) findViewById(R.id.femaleg)
        }; 
        RadioButton uq1[]= {
        		(RadioButton) findViewById(R.id.q1yes),
        		(RadioButton) findViewById(R.id.q1no)
        };
        RadioButton uq2[]= {
        		(RadioButton) findViewById(R.id.q2yes),
        		(RadioButton) findViewById(R.id.q2no)
        };
        RadioButton uq3[]= {
        		(RadioButton) findViewById(R.id.q3yes),
        		(RadioButton) findViewById(R.id.q3no)
        };
        RadioButton uq4[]= {
        		(RadioButton) findViewById(R.id.q4yes),
        		(RadioButton) findViewById(R.id.q4no)
        };
        RadioButton uq5[]= {
        		(RadioButton) findViewById(R.id.q5yes),
        		(RadioButton) findViewById(R.id.q5no)
        };
        Button confirmation= (Button) findViewById(R.id.editProfileBTN);
        final AlertDialog confirmDialog = new AlertDialog.Builder(this).create();
        
        confirmDialog.setMessage("Do you wish to confirm your changes?");
        confirmDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Confirm", 
        new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
        confirmDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", 
                new DialogInterface.OnClickListener() {
        			
        			@Override
        			public void onClick(DialogInterface dialog, int which) {
        				// TODO Auto-generated method stub
        				
        			}
        		});
                
        confirmation.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				confirmDialog.show();
				
			}
		});
}
}