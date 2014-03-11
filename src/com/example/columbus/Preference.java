package com.example.columbus;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

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
		
	}
	/*
	public static boolean doesHumanPlayFirst(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
		.getBoolean(OPT_PLAY_FIRST, OPT_PLAY_FIRST_DEF);
	}
	*/
	
}
