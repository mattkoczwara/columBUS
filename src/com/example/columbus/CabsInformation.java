package com.example.columbus;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

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

                // Cabs Bus Line Information
                if((groupPosition==1)&&(childPosition==0))
                {
                	// North Express
                    Uri uri = Uri.parse("http://ttm.osu.edu/cabs-ne");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==1))
                {
                	// Campus Loop North
                    Uri uri = Uri.parse("http://ttm.osu.edu/cabs-cln");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==2))
                {
                	// Campus Loop South
                    Uri uri = Uri.parse("http://ttm.osu.edu/cabs-cls");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==3))
                {
                	// Central Connector
                    Uri uri = Uri.parse("http://ttm.osu.edu/cabs-cc");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==4))
                {
                	// East Residential
                    Uri uri = Uri.parse("http://ttm.osu.edu/cabs-er");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==5))
                {
                	// Buckeye Village
                    Uri uri = Uri.parse("http://ttm.osu.edu/cabs-bv");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==6))
                {
                	// Med Center Express
                    Uri uri = Uri.parse("http://ttm.osu.edu/cabs-mc");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==7))
                {
                	// Martha Morehouse
                    Uri uri = Uri.parse("http://ttm.osu.edu/cabs-mm");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==8))
                {
                	// Patient Courtesy Shuttle
                    Uri uri = Uri.parse("http://ttm.osu.edu/patient-courtesy-shuttle");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
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
        //listDataHeader.add("Recently Accessed");
        listDataHeader.add("See All");
        //listDataHeader.add("Coming Soon..");
 
        // Adding child data
        /*
        List<String> recentlyAccessed = new ArrayList<String>();
        recentlyAccessed.add("Recently Accessed Routh #1");
        recentlyAccessed.add("Recently Accessed Routh #2");
        recentlyAccessed.add("Recently Accessed Route #3");
        recentlyAccessed.add("Recently Accessed Route #4");
 */
        List<String> seeAllCota = new ArrayList<String>();
        seeAllCota.add("North Express");
        seeAllCota.add("Campus Loop North");
        seeAllCota.add("Campus Loop South");
        seeAllCota.add("Central Connector");
        seeAllCota.add("East Residential");
        seeAllCota.add("Buckeye Village");
        seeAllCota.add("Med Center Express");
        seeAllCota.add("Martha Morehouse");
        seeAllCota.add("Patient Courtest Shuttle");
 /*
        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Extra");
        comingSoon.add("Extra 1");
        comingSoon.add("Extra 2");
 */
        //listDataChild.put(listDataHeader.get(0), recentlyAccessed); // Header, Child data
        listDataChild.put(listDataHeader.get(1), seeAllCota);
       // listDataChild.put(listDataHeader.get(2), comingSoon);
	}

}
