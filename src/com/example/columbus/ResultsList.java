
package com.example.columbus;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


import com.example.columbus.ResultsList;
import com.example.columbus.CustomBaseAdapter;
import com.example.columbus.R;
import com.example.columbus.SearchResults;

public class ResultsList extends Activity {

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_list);
        
        List<String> supplierNames1 = new ArrayList<String>();
        supplierNames1 = MainActivity.arrivalTime;
        
        List<String> supplierCity = new ArrayList<String>();
        supplierCity = MainActivity.departureTime;
        
        List<String> supplierPhone = new ArrayList<String>();
        supplierPhone = MainActivity.dur;
        
        
        ArrayList<SearchResults> searchResults = GetSearchResults(supplierNames1, supplierCity, supplierPhone);
        
        final ListView lv1 = (ListView) findViewById(R.id.ListView01);
        lv1.setAdapter(new CustomBaseAdapter(this, searchResults));
        
        lv1.setOnItemClickListener(new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
        		Object o = lv1.getItemAtPosition(position);
            	SearchResults fullObject = (SearchResults)o;
        		Toast.makeText(ResultsList.this, "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
        	}  
        });
    }
    
    private ArrayList<SearchResults> GetSearchResults(List<String> route, List<String> dur, List<String> time ){
    	ArrayList<SearchResults> results = new ArrayList<SearchResults>();
    	
    	int counter = 0;
    	
    	SearchResults sr1 = new SearchResults();
    	
    	while(counter < route.size())
    	{
    		sr1 = new SearchResults();
        	sr1.setName("Arrival Time: " + route.get(counter));
        	sr1.setCityState("Departure Time: " + dur.get(counter));
        	sr1.setPhone("Duration: " + time.get(counter));
        	results.add(sr1);
        	
        	counter++;
    	}

    	return results;
    }
 
}