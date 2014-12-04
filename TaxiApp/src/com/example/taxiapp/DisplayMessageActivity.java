package com.example.taxiapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choiceofacceptreject);
		Intent intent = getIntent(); //note this is to signify the reciev of query, other just oncreate normally
		String message = intent.getStringExtra(CarpoolController.EXTRA_MESSAGE); // recieves the query
		
	    // Create the text view, actually overwrite
	   // TextView textView = new TextView(this);
		TextView textview =(TextView) findViewById(R.id.textView1);
		textview.setText(message);

	    // Set the text view as the activity layout//if the contentview is the only onw
	    //setContentView(textview);
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                  Bundle savedInstanceState) {
              View rootView = inflater.inflate(R.layout.activity_display_message,//check this is true frag
                      container, false);
              return rootView;
        }
    }
 //***********************************************Intents start
    public void goToCarpool(View view) {
    	Intent carpoolIntent = new Intent(this, CarpoolController.class);
    	startActivity(carpoolIntent);
    }
    public void goToViewProfile(View view) {
    	Intent profileIntent = new Intent(this, ViewProfile.class);
    	startActivity(profileIntent);
    }
    //***********************************************Intents end
   }

