package com.example.columbus;

import android.os.Bundle;
import android.app.Activity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
import info.androidhive.expandablelistview.*;

public class CabsInformation extends Activity {
	
	ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cabs_information);
		
		// get the list view
        expListView = (ExpandableListView) findViewById(R.id.lvExp2);
 
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListsAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
 
        // List view Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
 
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                    int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        
        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
 
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });
 
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
 
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();
 
            }
        });
 
        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {
 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                        listDataHeader.get(groupPosition)).get(
                                        childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }
 
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("Recently Accessed");
        listDataHeader.add("See All");
        listDataHeader.add("Coming Soon..");
 
        // Adding child data
        List<String> recentlyAccessed = new ArrayList<String>();
        recentlyAccessed.add("Recently Accessed Route #1");
        recentlyAccessed.add("Recently Accessed Route #2");
        recentlyAccessed.add("Recently Accessed Route #3");
        recentlyAccessed.add("Recently Accessed Route #4");
 
        List<String> seeAllCota = new ArrayList<String>();
        seeAllCota.add("Cabs Bus Route #1");
        seeAllCota.add("Cabs Bus Route #2");
        seeAllCota.add("Cabs Bus Route #3");
        seeAllCota.add("Cabs Bus Route #4");
        seeAllCota.add("Cabs Bus Route #5");
 
        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Extra");
        comingSoon.add("Extra 1");
        comingSoon.add("Extra 2");
 
        listDataChild.put(listDataHeader.get(0), recentlyAccessed); // Header, Child data
        listDataChild.put(listDataHeader.get(1), seeAllCota);
        listDataChild.put(listDataHeader.get(2), comingSoon);
	}

}
