package com.example.taxiapp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

	private String emailDummy = "hello";
	private String passDummy = "world";

	private Editable getEmail;
	private Editable getPass;

	
	TextView loginError;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Button loginButton = (Button) findViewById(R.id.loginBtn);
		Button regButton = (Button) findViewById(R.id.regBtn);
		loginError = (TextView) findViewById(R.id.failedLogin);
		final EditText emailText = (EditText) findViewById(R.id.emailTxtField);
		final EditText passText = (EditText) findViewById(R.id.passwrdTextField);
		


		loginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				getEmail = emailText.getText();
				getPass = passText.getText();
				new Thread() //HTTP POST code
				 
				{
					public void run(){
							HttpClient client = new DefaultHttpClient();  
						    HttpPost post = new HttpPost("http://192.168.43.188/login");   
						    post.setHeader("Content-type", "application/json");
						    post.setHeader("Accept", "application/json");
						JSONObject obj = new JSONObject();
						try {
							obj.put("email", getEmail);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							obj.put("password", getPass);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						    try {
								post.setEntity(new StringEntity(obj.toString(), "UTF-8"));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						    try {
								HttpResponse response = client.execute(post);
								final String responseStr = EntityUtils.toString(response.getEntity());
								if(responseStr.equals("[\"true\"]")){
									

												
									    	 loggedIn();
									
								}
								else{
								runOnUiThread(new Runnable() {
								     @Override
								     public void run() {

											
								    	 loginError.setText(responseStr);

								    }
								});
						    }

								/*HttpEntity data= response.getEntity();
								String stringData = EntityUtils.toString(data);*/
								 //ResponseHandler<String> responseHandler = new BasicResponseHandler();
		                        //String stringData = client.execute(post, responseHandler);
		                        
								
								//		textview.setText(stringData);
							} catch (ClientProtocolException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
						
					}
				}.start();

				/*if(emailDummy.equals(getEmail.toString())){
					if(passDummy.equals(getPass.toString())){
						success.setVisibility(View.VISIBLE);
						loginError.setVisibility(View.INVISIBLE);
						loggedIn();
					}else{
						success.setVisibility(View.INVISIBLE);
						loginError.setVisibility(View.VISIBLE);
					}
				}else{
					success.setVisibility(View.INVISIBLE);
					loginError.setVisibility(View.VISIBLE);
				}*/
			}
		});

		regButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				register();
			}
		});
	}


	//@Override
	/* boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}*/

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

	private void loggedIn(){
		Intent onwards =  new Intent(this, chooseTwoRP.class);
		startActivity(onwards);
	}

	private void register(){
		Intent register = new Intent(this, register.class);
		startActivity(register);
	}
	
}
