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

public class CotaInformation extends Activity {
	
	ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cota_information);
		
		// get the list view
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
 
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
                if((groupPosition==0)&&(childPosition==0))
                {
                	// Cleveland
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/001c.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==1))
                {
                	// Livingston
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/001l.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==2))
                {
                	// North High
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/002h.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==3))
                {
                	// East Main
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/002m.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==4))
                {
                	// West Mound
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/003m.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==5))
                {
                	// Northwest Blvd.
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/003n.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==6))
                {
                	// Indianola
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/004i.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==7))
                {
                	// Parsons
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/004p.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==8))
                {
                	// W. 5th Ave.
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/005.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==9))
                {
                	// Mt. Vernon
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/006m.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==10))
                {
                	// Sullivant
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/006s.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==11))
                {
                	// Neil
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/007n.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==12))
                {
                	// Whittier
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/007w.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==13))
                {
                	// Frebis
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/008f.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==14))
                {
                	// Hamilton Ave.
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/008h.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==15))
                {
                	// Leonard/Brentnell
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/009.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==16))
                {
                	// E. Broad
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/010e.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==17))
                {
                	// W. Broad
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/010w.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==18))
                {
                	// Oak/Bryden
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/011o.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==19))
                {
                	// St. Clair
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/011s.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==20))
                {
                	// McKinley/Fields
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/012.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==21))
                {
                	// US 33/Watermark
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/013.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==22))
                {
                	// Harmon/Greenlawn
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/014.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==23))
                {
                	// Grove City
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/015.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==24))
                {
                	// South High Street
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/016h.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==25))
                {
                	// E. Long
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/016l.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==26))
                {
                	// Kenny
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/018.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==27))
                {
                	// Arlington/Grandview
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/019.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==28))
                {
                	// Night Owl
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/021.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==29))
                {
                	// Zoo Bus
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/098.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==0)&&(childPosition==30))
                {
                	// West Broad Casino
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/222.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==0))
                {
                	// Brooksedge
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/027.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==1))
                {
                	// Polaris
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/029.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==2))
                {
                	// Smoky Row
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/030.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==3))
                {
                	// Worthington
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/031.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==4))
                {
                	// Crosswoods
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/032.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==5))
                {
                	// North Central
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/033.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==6))
                {
                	// Karl
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/034.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==7))
                {
                	// Tamarack
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/035.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==8))
                {
                	// Annehurst
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/036.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==9))
                {
                	// Westerville
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/037.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==10))
                {
                	// Easton
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/038.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==11))
                {
                	// New Albany
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/039.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==12))
                {
                	// New Albany Business Park
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/040.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==13))
                {
                	// Gahanna
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/041.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==14))
                {
                	// E. Broad
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/043.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==15))
                {
                	// North Reynoldsburg
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/044.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==16))
                {
                	// Reynoldsburg
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/045.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==17))
                {
                	// Eastland
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/046.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==18))
                {
                	// Brice
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/047.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==19))
                {
                	// Eastgreen
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/048.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==20))
                {
                	// Southeast
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/049.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==21))
                {
                	// OSU/Airport
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/052.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==22))
                {
                	// Lincoln Village
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/053.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==23))
                {
                	// London-Graveport
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/054.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==24))
                {
                	// Gender
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/055.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==25))
                {
                	// Tuttle
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/056.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==26))
                {
                	// Hilliard
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/057.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==27))
                {
                	// Dublin
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/058.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==28))
                {
                	// Dublin/Metro
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/059.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==29))
                {
                	// Arlington
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/060.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==30))
                {
                	// Kenny
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/061.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==31))
                {
                	// Grove City
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/064.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==32))
                {
                	// Southpark
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/065.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==33))
                {
                	// Hilliard/OSU
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/066.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==34))
                {
                	// East Hilliard
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/067.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==1)&&(childPosition==35))
                {
                	// Hilliard/Westbelt
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/068.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==0))
                {
                	// OSU/Lennox
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/080.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==1))
                {
                	// Hudson/Ohio
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/081.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==2))
                {
                	// Grandview/OSU
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/082.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==3))
                {
                	// Oakland/Weber
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/83.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==4))
                {
                	// Hilliard/Arlington/OSU
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/084.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==5))
                {
                	// Cassady
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/087.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==6))
                {
                	// Hamilton Rd.
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/089.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==7))
                {
                	// James/Stelzer
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/092.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==8))
                {
                	// Morse/Henderson
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/095.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==9))
                {
                	// 5th Ave.
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/096.pdf");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if((groupPosition==2)&&(childPosition==10))
                {
                	// Sawmill
                    Uri uri = Uri.parse("http://www.cota.com/assets/Riding-Cota/Schedules/Current/118.pdf");
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
        listDataHeader.add("Local");
        listDataHeader.add("Express");
        listDataHeader.add("Crosstown");
 
        // Adding child data
        
        // Local COTA Bus Lines
        List<String> local = new ArrayList<String>();
        local.add("1 - Cleveland");
        local.add("1 - Livingston");
        local.add("2 - North High");
        local.add("2 - East Main");
        local.add("3 - W. Mound");
        local.add("3 - Northwest Blvd.");
        local.add("4 - Indianola");
        local.add("4 - Parsons");
        local.add("5 - W. 5th Ave.");
        local.add("6 - Mt. Vernon");
        local.add("6 - Sullivant");
        local.add("7 - Neil");
        local.add("7 - Whittier");
        local.add("8 - Frebis");
        local.add("8 - Hamilton Ave.");
        local.add("9 - Leonard/Bretnell");
        local.add("10 - East Broad");
        local.add("10 - West Broad");
        local.add("11 - Oak/Bryden");
        local.add("11 - St. Clair");
        local.add("12 - McKinley/Fields");
        local.add("13 - US 33/Watermark");
        local.add("14 - Harmon/Greenlawn");
        local.add("15 - Grove City");
        local.add("16 - South High Street");
        local.add("16 - E. Long");
        local.add("18 - Kenny");
        local.add("19 - Arlington/Grandview");
        local.add("21 - Night Owl");
        local.add("98 - Zoo Bus");
        local.add("222 - W. Broad Casino");
        
        // Express Cota Bus Lines
        List<String> express = new ArrayList<String>();
        express.add("27 - Brooksedge");
        express.add("29 - Polaris");
        express.add("30 - Smoky Row");
        express.add("31 - Worthington");
        express.add("32 - Crosswoods");
        express.add("33 - North Central");
        express.add("34 - Karl");
        express.add("35 - Tamarack");
        express.add("36 - Annehurst");
        express.add("37 - Westerville");
        express.add("38 - Easton");
        express.add("39 - New Albany");
        express.add("40 - New Albany Business Park");
        express.add("41 - Gahanna");
        express.add("43 - E. Broad");
        express.add("44 - North Reynoldsburg");
        express.add("45 - Reynoldsburh");
        express.add("46 - Eastland");
        express.add("47 - Brice");
        express.add("48 - Eastgreen");
        express.add("49 - Southeast");
        express.add("52 - OSU/Airport");
        express.add("53 - Lincoln Village");
        express.add("54 - London-Graveport");
        express.add("55 - Gender");
        express.add("56 - Tuttle");
        express.add("57 - Hilliard");
        express.add("58 - Dublin");
        express.add("59 - Dublin/Metro");
        express.add("60 - Arlington");
        express.add("61 - Kenny");
        express.add("64 - Grove City");
        express.add("65 - Southpark");
        express.add("66 - Hilliard/OSU");
        express.add("67 - East Hilliard");
        express.add("68 - Hilliard/Westbelt");
        
        // Crosstown COTA Bus Lines
        List<String> crosstown = new ArrayList<String>();
        crosstown.add("80 - OSU/Lennox");
        crosstown.add("81 - Hudson/Ohio");
        crosstown.add("82 - Grandview/OSU");
        crosstown.add("83 - Oakland/Weber");
        crosstown.add("84 - Hilliard/Arlington/OSU");
        crosstown.add("87 - Cassady");
        crosstown.add("89 - Hamilton Rd.");
        crosstown.add("92 - James/Stelzer");
        crosstown.add("95 - Morse/Henderson");
        crosstown.add("96 - 5th Ave.");
        crosstown.add("118 - Sawmill");

        listDataChild.put(listDataHeader.get(0), local); // Header, Child data
        listDataChild.put(listDataHeader.get(1), express);
        listDataChild.put(listDataHeader.get(2), crosstown);
	}

}
