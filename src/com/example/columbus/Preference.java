package com.example.columbus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Preference extends Activity {
	/*
	private final static String 	OPT_PLAY_FIRST 		= "human_starts";
	private final static boolean 	OPT_PLAY_FIRST_DEF 	= true;
	*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 getFragmentManager().beginTransaction()
         .replace(android.R.id.content, new SetPreferenceFragment())
         .commit();
		 
		// final Button btnSetLocation=(Button)findViewById(R.id.button_send);
		 //btnSetLocation.setOnClickListener(this);
	}

	
}
