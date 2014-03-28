package com.example.columbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class ShowResult  extends FragmentActivity
	implements OnClickListener, RouteOptionDialogFragment.RouteOptionDialogListener {
		
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);	
		
		 View btnRouteOpt=(Button)findViewById(R.id.options_button);
	     btnRouteOpt.setOnClickListener(this);
	     
		 View btnDone=(Button)findViewById(R.id.done_button);
	     btnDone.setOnClickListener(this);
		
 	
		//map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		}
	
	 public void onClick(View v) {
			switch (v.getId()) {
	  		case R.id.options_button:
	  			showRouteOptionDialog();
			    break;
	        case R.id.done_button:
	        	startActivity(new Intent(this, ResultsList.class));
	        	break;
	  		
			}
	    }
	
	
	 public void showRouteOptionDialog() {
	        // Create an instance of the dialog fragment and show it
		
		    RouteOptionDialogFragment dialog = new RouteOptionDialogFragment();
	        dialog.show(getSupportFragmentManager(), "RouteOptionDialogFragment");
	    }
	 
	 public void showTimePickerDialog(View v) {
		    DialogFragment newFragment = new TimePickerFragment();
		    newFragment.show(getSupportFragmentManager(), "timePicker");
		}
	 
	 public void showDatePickerDialog(View v) {
		    DialogFragment newFragment = new DatePickerFragment();
		    newFragment.show(getSupportFragmentManager(), "datePicker");
		}

	 
	// The dialog fragment receives a reference to this Activity through the
	    // Fragment.onAttach() callback, which it uses to call the following methods
	    // defined by the NoticeDialogFragment.NoticeDialogListener interface
	    @Override
	    public void onDialogPositiveClick(DialogFragment dialog) {
	        // User touched the dialog's positive button
	        
	    }

	    @Override
	    public void onDialogNegativeClick(DialogFragment dialog) {
	        // User touched the dialog's negative button
	      
	    }
	
}