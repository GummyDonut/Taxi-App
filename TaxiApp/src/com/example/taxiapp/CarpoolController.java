package com.example.taxiapp;



import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import android.app.Activity;
import android.content.Intent;

import android.widget.SimpleAdapter;
//Array of options ---> Array Adapter ---> ListView(layout)
//listview : {views:caritems.xml}
public class CarpoolController extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.taxiapp.MESSAGE"; //query for passing data, its just required
	 // Array of strings storing country names
    String[] users = new String[] {
        "Peter Hoang",
        "Mahima",
        "Bobb22",
        "ninn",
        "Jemar8",
        "LOL",
        "hahaha",
        "Trolls rule this",
        "South Korea",
        "Japan"
    };
 
    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] flags = new int[]{
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher
    };
 
    // Array of strings to store currencies
    String[] destination = new String[]{
        "India",
        "Pakistani ",
        "Sri Lankan",
        "Renminbi",
        "Bangladeshi ",
        "Nepalese ",
        "Afghani",
        "North Korea",
        "South Korea",
        "Japanese"
    };
//********************************Start page intent moves*************************************** 
    //go to make offer
    public void goToMakeOffer(View view) {
    	Intent makeOfferIntent = new Intent(this, MakeOfferTest.class);
    	startActivity(makeOfferIntent);
    }
    
    
    //go to make offer
    public void goToEditProfile(View view) {
    	Intent editIntent = new Intent(this, EditProfile.class);
    	startActivity(editIntent);
    }
    //go to logout page //Note that the logout class here is temporary
    public void goToLogout(View view) {
    	Intent logoutIntent = new Intent(this, LoginActivity.class);
    	startActivity(logoutIntent);
    }
    
//*****************************************End page intent moves*************************************    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carpoollist);
 
        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
 
        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", "User : " + users[i]);
            hm.put("cur","Destination : " + destination[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }
 
        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };
 
        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur};
 
        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.caritems, from, to);
 
        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.listviewCarpool);
 
        // Setting the adapter to the listView
        listView.setAdapter(adapter);
        registerClickCallback(); //makes the elements clickable
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
	private void registerClickCallback() {
		ListView list =(ListView) findViewById(R.id.listviewCarpool); // get the list reference
		list.setOnItemClickListener(new OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view,
			    int position, long id) {
				  intentpass(position);
				  
			    /*Toast.makeText(getApplicationContext(),
			      "Click ListItem Number " + position, Toast.LENGTH_LONG)
			      .show();*/
				  //Old code for displaying list item clicked
			  }
			});
		/*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


			@Override
			public void onItemClick(AdapterView<?> paret, View viewClicked, int position,
					long id) {
				// TODO Auto-generated method stub
				TextView textview = (TextView) viewClicked;
				String message = "You clicked #" + position 
						+ ", Which is string:" + textview.getText().toString();
				Toast.makeText(CarpoolController.this,message,Toast.LENGTH_LONG).show();
			}

			
		});*/
	}
	private void intentpass(int positionlocal){//must be a private function // will be passing profile info and name
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		//TextView carpool =(TextView) findViewById(R.id.cur);
		  String message = "Would you like to Carpool With "+users[positionlocal]+"TO: "+ destination[positionlocal];
		  intent.putExtra(EXTRA_MESSAGE, message);
		  startActivity(intent);
	}

}




/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
	*/

