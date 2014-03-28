package com.example.columbus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class MainActivity extends FragmentActivity implements
GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener, OnClickListener{
	
	 LatLng source;
	 LatLng destination;
	 EditText etPlace;
	 TextView tvDistanceDuration;
	 ArrayList<LatLng> markerPoints;
	 
    private SupportMapFragment mapFragment;
    private GoogleMap map;
    private LocationClient mLocationClient;
    public static List<String> arrivalTime = new ArrayList<String>();
    public static List<String> departureTime = new ArrayList<String>();
    public static List<String> dur = new ArrayList<String>();
    
    /*
	 * Define a request code to send to Google Play services
	 * This code is returned in Activity.onActivityResult
	 */
	private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    
	// Define a DialogFragment that displays the error dialog
	public static class ErrorDialogFragment extends DialogFragment {
	    
	    // Global field to contain the error dialog
	    private Dialog mDialog;
	    
	    // Default constructor. Sets the dialog field to null
	    public ErrorDialogFragment() {
	        super();
	        mDialog = null;
	    }
	    
	    // Set the dialog to display
	    public void setDialog(Dialog dialog) {
	        mDialog = dialog;
	    }
	    
	    // Return a Dialog to the DialogFragment.
	    @Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	        return mDialog;
	    }
	}
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        View btnGo=(Button)findViewById(R.id.button_send);
		btnGo.setOnClickListener(this);
		
		
		etPlace = (EditText) findViewById(R.id.et_destination);
		
		//tvDistanceDuration = (TextView) findViewById(R.id.test);
		 
	        // Initializing
	    markerPoints = new ArrayList<LatLng>();
	 
        mLocationClient = new LocationClient(this, this, this);
        
        mapFragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
        map = mapFragment.getMap();
        
        map.setMyLocationEnabled(true);
        
	}
    
	 @Override
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
	                break;
	                 
	            case R.id.about:
	                break;
	            default:
	                return super.onOptionsItemSelected(item);
	        }
	        return true;
	    }
	     
	     
	    public void onClick(View v) {
	        switch (v.getId()) {
	            case R.id.button_send:
	            	String location = etPlace.getText().toString();
	            	 
	                if(location==null || location.equals("")){
	                    Toast.makeText(getBaseContext(), "No Place is entered", Toast.LENGTH_SHORT).show();
	                    return;
	                }
	 
	                String url = "https://maps.googleapis.com/maps/api/geocode/json?";
	 
	                try {
	                    // encoding special characters like space in the user input place
	                    location = URLEncoder.encode(location, "utf-8");
	                } catch (UnsupportedEncodingException e) {
	                    e.printStackTrace();
	                }
	 
	                String address = "address=" + location;
	 
	                String sensor = "sensor=false";
	 
	                // url , from where the geocoding data is fetched
	                url = url + address + "&" + sensor;
	 
	                // Instantiating DownloadTask to get places from Google Geocoding service
	                // in a non-ui thread
	                DownloadTask downloadTask = new DownloadTask();
	 
	                // Start downloading the geocoding places
	                downloadTask.execute(url);  
	                startActivity(new Intent(this, ResultsList.class));
	            }
	    }
	    
	    private String getDirectionsUrl(LatLng origin,LatLng dest){
	    	 
	        // Origin of route
	        String str_origin = "origin="+origin.latitude+","+origin.longitude;
	 
	        // Destination of route
	        
	        String str_dest = "destination="+dest.latitude+","+dest.longitude;
	        //String str_dest = etDestination.getText().toString();
	 
	        // Sensor enabled
	        String sensor = "sensor=false";
	        
	        int current_time = (int) (System.currentTimeMillis() / 1000); 
	        String departure_time = "departure_time="+current_time;

	        String mode = "mode=transit";
	        
	        String alternatives = "alternatives=true";
	 
	        // Building the parameters to the web service
	        //String parameters = str_origin+"&"+str_dest+"&"+sensor;
	        String parameters = str_origin+"&"+str_dest+"&"+sensor +"&"+departure_time+"&"+mode+"&"+alternatives;
	        
	        
	        // Output format
	        String output = "json";
	 
	        // Building the url to the web service
	        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;
	        Log.v("the url is: " , url);
	 
	        return url;
	    }
	 
	          
	/*
	 * Called when the Activity becomes visible.
	 */
	@Override
	protected void onStart() {
        super.onStart();
        // Connect the client.
        if(isGooglePlayServicesAvailable()){
            mLocationClient.connect();
        }
        
	}
    
	/*
	 * Called when the Activity is no longer visible.
	 */
	@Override
	protected void onStop() {
        // Disconnecting the client invalidates it.
        mLocationClient.disconnect();
        super.onStop();
	}
    
	/*
	 * Handle results returned to the FragmentActivity
	 * by Google Play services
	 */
	@Override
	protected void onActivityResult(
                                    int requestCode, int resultCode, Intent data) {
        // Decide what to do based on the original request code
        switch (requestCode) {
                
            case CONNECTION_FAILURE_RESOLUTION_REQUEST:
                /*
                 * If the result code is Activity.RESULT_OK, try
                 * to connect again
                 */
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        mLocationClient.connect();
                        break;
                }
                
        }
	}
    
	private boolean isGooglePlayServicesAvailable() {
        // Check that Google Play services is available
        int resultCode =  GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        // If Google Play services is available
        if (ConnectionResult.SUCCESS == resultCode) {
            // In debug mode, log the status
            Log.d("Location Updates", "Google Play services is available.");
            return true;
        } else {
            // Get the error dialog from Google Play services
            Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog( resultCode,
                                                                       this,
                                                                       CONNECTION_FAILURE_RESOLUTION_REQUEST);
            
            // If Google Play services can provide an error dialog
            if (errorDialog != null) {
                // Create a new DialogFragment for the error dialog
                ErrorDialogFragment errorFragment = new ErrorDialogFragment();
                errorFragment.setDialog(errorDialog);
                errorFragment.show(getSupportFragmentManager(), "Location Updates");
            }
            
            return false;
        }
	}
    
	/*
	 * Called by Location Services when the request to connect the
	 * client finishes successfully. At this point, you can
	 * request the current location or start periodic updates
	 */
	@Override	
	public void onConnected(Bundle dataBundle) {
	// Display the connection status
		 Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
		Location location = mLocationClient.getLastLocation();
		source = new LatLng(location.getLatitude(), location.getLongitude());
		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(source, 17);
		map.animateCamera(cameraUpdate);
	}
    
	/*
	 * Called by Location Services if the connection to the
	 * location client drops because of an error.
	 */
	@Override
	public void onDisconnected() {
        // Display the connection status
        Toast.makeText(this, "Disconnected. Please re-connect.",
                       Toast.LENGTH_SHORT).show();
	}
    
	/*
	 * Called by Location Services if the attempt to
	 * Location Services fails.
	 */
	@Override
	public void onConnectionFailed(ConnectionResult connectionResult) {
        /*
         * Google Play services can resolve some errors it detects.
         * If the error has a resolution, try sending an Intent to
         * start a Google Play services activity that can resolve
         * error.
         */
        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(
                                                          this,
                                                          CONNECTION_FAILURE_RESOLUTION_REQUEST);
                /*
                 * Thrown if Google Play services canceled the original
                 * PendingIntent
                 */
            } catch (IntentSender.SendIntentException e) {
                // Log the error
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Sorry. Location services not available to you", Toast.LENGTH_LONG).show();
        }
	}
	
	  private String downloadUrl(String strUrl) throws IOException{
	        String data = "";
	        InputStream iStream = null;
	        HttpURLConnection urlConnection = null;
	        try{
	            URL url = new URL(strUrl);
	            // Creating an http connection to communicate with url
	            urlConnection = (HttpURLConnection) url.openConnection();
	 
	            // Connecting to url
	            urlConnection.connect();
	 
	            // Reading data from url
	            iStream = urlConnection.getInputStream();
	 
	            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
	 
	            StringBuffer sb = new StringBuffer();
	 
	            String line = "";
	            while( ( line = br.readLine()) != null){
	                sb.append(line);
	            }
	 
	            data = sb.toString();
	            br.close();
	 
	        }catch(Exception e){
	            Log.d("Exception while downloading url", e.toString());
	        }finally{
	            iStream.close();
	            urlConnection.disconnect();
	        }
	 
	        return data;
	    }
	    /** A class, to download Places from Geocoding webservice */
	    private class DownloadTask extends AsyncTask<String, Integer, String>{
	 
	        String data = null;
	 
	        // Invoked by execute() method of this object
	        @Override
	        protected String doInBackground(String... url) {
	            try{
	                data = downloadUrl(url[0]);
	            }catch(Exception e){
	                Log.d("Background Task",e.toString());
	            }
	            return data;
	        }
	 
	        // Executed after the complete execution of doInBackground() method
	        @Override
	        protected void onPostExecute(String result){
	 
	            // Instantiating ParserTask which parses the json data from Geocoding webservice
	            // in a non-ui thread
	            ParserTask parserTask = new ParserTask();
	 
	            // Start parsing the places in JSON format
	            // Invokes the "doInBackground()" method of the class ParseTask
	            parserTask.execute(result);                   
	        }
	    }
	 
	    /** A class to parse the Geocoding Places in non-ui thread */
	    class ParserTask extends AsyncTask<String, Integer, List<HashMap<String,String>>>{
	 
	        JSONObject jObject;
	 
	        // Invoked by execute() method of this object
	        @Override
	        protected List<HashMap<String,String>> doInBackground(String... jsonData) {
	 
	            List<HashMap<String, String>> places = null;
	            GeocodeJSONParser parser = new GeocodeJSONParser();
	 
	            try{
	                jObject = new JSONObject(jsonData[0]);
	 
	                /** Getting the parsed data as a an ArrayList */
	                places = parser.parse(jObject);
	 
	            }catch(Exception e){
	                Log.d("Exception",e.toString());
	            }
	            return places;
	        }
	 
	        // Executed after the complete execution of doInBackground() method
	        @Override
	        protected void onPostExecute(List<HashMap<String,String>> list){
	 
	            // Clears all the existing markers
	            map.clear();
	            
	            if (list.size() == 0){
                    Toast.makeText(getBaseContext(), "No place is found", Toast.LENGTH_SHORT).show();
	            }else{
	            	 HashMap<String, String> hmPlace = list.get(0);
	            	 
		                // Getting latitude of the place
		                double lat = Double.parseDouble(hmPlace.get("lat"));
		 
		                // Getting longitude of the place
		                double lng = Double.parseDouble(hmPlace.get("lng"));
		 
		                // Getting name
		                String name = hmPlace.get("formatted_address");
		 
		                destination = new LatLng(lat, lng);	
		                
		                String url2 = getDirectionsUrl(source, destination);   
		                
		                DownloadDirectionTask downloadDestinationTask = new DownloadDirectionTask();

		                // Start downloading json data from Google Directions API
		                downloadDestinationTask.execute(url2);
	            }
	          
	        }
	    }
	 
	    private class DownloadDirectionTask extends AsyncTask<String, Void, String>{
	    	 
	        // Downloading data in non-ui thread
	        @Override
	        protected String doInBackground(String... url) {
	 
	            // For storing data from web service
	            String data = "";
	 
	            try{
	                // Fetching the data from web service
	                data = downloadUrl(url[0]);
	            }catch(Exception e){
	                Log.d("Background Task",e.toString());
	            }
	            return data;
	        }
	 
	        // Executes in UI thread, after the execution of
	        // doInBackground()
	        @Override
	        protected void onPostExecute(String result) {
	            super.onPostExecute(result);
	 
	            ParserDirectionTask parserDestTask = new ParserDirectionTask();
	 
	            // Invokes the thread for parsing the JSON data
	            parserDestTask.execute(result);
	        }
	    }
	    
	    /** A class to parse the Google Places in JSON format */
	    private class ParserDirectionTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{
	 
	        // Parsing the data in non-ui thread
	        @Override
	        protected  List<List<HashMap<String, String>>>  doInBackground(String... jsonData) {
	 
	            JSONObject jObject;
	            List<List<HashMap<String, String>>> routes = null;
	 
	            try{
	                jObject = new JSONObject(jsonData[0]);
	                DirectionsJSONParser parser = new DirectionsJSONParser();
	 
	                // Starts parsing data
	                routes = parser.parse(jObject);
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	            return routes;
	        }
	 
	       
	        // Executes in UI thread, after the parsing process
	        @Override
	        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
	            ArrayList<LatLng> points = null;
	            PolylineOptions lineOptions = null;
	            MarkerOptions markerOptions = new MarkerOptions();
	            List<String> arrival_time = new ArrayList<String>();
	            List<String> departure_time = new ArrayList<String>();
	            List<String> duration = new ArrayList<String>();
	 
	            if(result.size()<1){
	                Toast.makeText(getBaseContext(), "No Points", Toast.LENGTH_SHORT).show();
	                return;
	            }
	 
	            // Traversing through all the routes
	            for(int i=0;i<result.size();i++){
	                points = new ArrayList<LatLng>();
	                lineOptions = new PolylineOptions();
	 
	                // Fetching i-th route
	                List<HashMap<String, String>> path = result.get(i);
	 
	                // Fetching all the points in i-th route
	                for(int j=0;j<path.size();j++){
	                    HashMap<String,String> point = path.get(j);
	 
	                    if(j==0){    // Get distance from the list
	                    	arrival_time.add((String)point.get("arrival_time"));
	                        continue;
	                    }else if(j==1){ // Get duration from the list
	                    	departure_time.add((String)point.get("departure_time"));
	                        continue;
	                    }
	                    else if(j==2){ // Get duration from the list
	                        duration.add((String)point.get("duration"));
	                        continue;
	                    }
	 
	                    double lat = Double.parseDouble(point.get("lat"));
	                    double lng = Double.parseDouble(point.get("lng"));
	                    LatLng position = new LatLng(lat, lng);
	 
	                    points.add(position);
	                }
	 
	                // Adding all the points in the route to LineOptions
	                lineOptions.addAll(points);
	                lineOptions.width(2);
	                lineOptions.color(Color.RED);
	            }
	 
	          //  tvDistanceDuration.setText("ArrTime:"+arrival_time +",DepTime"+departure_time 
	           // 		+", Duration:"+duration);

 
	            map.addPolyline(lineOptions); 
	            arrivalTime = arrival_time;
	            departureTime = departure_time;
	            dur = duration;
	        }
	    }
	 
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	}

    


