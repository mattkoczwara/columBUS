package com.example.columbus;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.columbus.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity implements OnClickListener{
	static final String TAGMAIN="Main";
	public final static String EXTRA_MESSAGE = "com.example.columbus.MESSAGE";
	//private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 View btnGo=(Button)findViewById(R.id.button_send);
	     btnGo.setOnClickListener(this);
 	
//map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	
	//Main Activity
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.cota_information:
	            //link
	        	Intent intent = new Intent(MainActivity.this, CotaInformation.class);
	        	this.startActivity(intent); 
	            break;
	        case R.id.cabs_information:
	            //link
	        	Intent intentCabs = new Intent(MainActivity.this, CabsInformation.class);
	        	this.startActivity(intentCabs); 
	            break;
	        case R.id.nearby_stops:
	        	//
	        	Intent intentStops = new Intent(MainActivity.this, NearestStops.class);
	        	this.startActivity(intentStops); 
	        	break;
	        case R.id.preferences:
	        	startActivity(new Intent(this, Preference.class));
	        	return true;
	        	
	        case R.id.about:
	        	//
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	    return true;
	}
	
	//Called when the user clicks the Send button */
	public void sendMessage(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, BusLineSchedule.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);


	}
	
	 public void onClick(View v) {
			switch (v.getId()) {
	  		case R.id.button_send:
	  			startActivity(new Intent(this, ShowResult.class));
			    break;
	  		
			}
	    }
	
	@Override
	protected void onResume() {
		Log.d(TAGMAIN, "Entering onResume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.d(TAGMAIN, "Entering onPause");
		super.onPause();
		System.gc();
		}
	
	@Override
	protected void onStart() {
		Log.d(TAGMAIN, "Entering onStart");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.d(TAGMAIN, "Entering onStop");
		super.onStop();
		System.gc();
		}
	}