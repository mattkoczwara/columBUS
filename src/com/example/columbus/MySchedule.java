package com.example.columbus;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MySchedule extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_schedule);
		TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
		tabHost.setup();

		TabSpec spec1=tabHost.newTabSpec("Tab 1");
		spec1.setContent(R.id.Mon);
		spec1.setIndicator("Mon");

		TabSpec spec2=tabHost.newTabSpec("Tab 2");
		spec2.setIndicator("Tue");
		spec2.setContent(R.id.Tue);

		TabSpec spec3=tabHost.newTabSpec("Tab 3");
		spec3.setIndicator("Wed");
		spec3.setContent(R.id.Wed);

		TabSpec spec4=tabHost.newTabSpec("Tab 4");
		spec4.setIndicator("Thu");
		spec4.setContent(R.id.Thu);

		TabSpec spec5=tabHost.newTabSpec("Tab 5");
		spec5.setIndicator("Fri");
		spec5.setContent(R.id.Fri);

		TabSpec spec6=tabHost.newTabSpec("Tab 6");
		spec6.setIndicator("Sat");
		spec6.setContent(R.id.Sat);

		TabSpec spec7=tabHost.newTabSpec("Tab 7");
		spec7.setIndicator("Sun");
		spec7.setContent(R.id.Sun);

		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		tabHost.addTab(spec3);
		tabHost.addTab(spec4);
		tabHost.addTab(spec5);
		tabHost.addTab(spec6);
		tabHost.addTab(spec7);
		}

}
