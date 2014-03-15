package com.example.columbus;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class RouteOptionDialogFragment extends DialogFragment {
	 private int routeoptionchose = 0;
	
	 public interface RouteOptionDialogListener {
	        public void onDialogPositiveClick(DialogFragment dialog);
	        public void onDialogNegativeClick(DialogFragment dialog);
	    }
	    
	// Use this instance of the interface to deliver action events
	 RouteOptionDialogListener mListener;
	    
	// Override the Fragment.onAttach() method to instantiate the RouteOptionDialogListener
	    @Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        // Verify that the host activity implements the callback interface
	        try {
	            // Instantiate the RouteOptionDialogListener so we can send events to the host
	        	 mListener = (RouteOptionDialogListener) activity;
	        } catch (ClassCastException e) {
	            // The activity doesn't implement the interface, throw exception
	            throw new ClassCastException(activity.toString()
	                    + " must implement NoticeDialogListener");
	        }
	    }
	
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        
    	//ArrayList mSelectedItems = new ArrayList();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.options)
        	   .setSingleChoiceItems(R.array.route_options, 1,
                       new DialogInterface.OnClickListener() { 
        		   @Override
        		   public void onClick(DialogInterface dialog, int which ) {
        			   switch (which) {
        		  		case 1:
        		  			routeoptionchose = 0;  //best route
        				    break;
        		  		case 2:
        		  			routeoptionchose = 1;  //fewer transfer
        		    		break;
        		    	case 3:
        		    		routeoptionchose = 2;  //less walking
        		    	    break;
        				}
        			  
                     
                   }

			
               })
               .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
               @Override
               		public void onClick(DialogInterface dialog, int id) {
                   // User clicked OK, so save the mSelectedItems results somewhere
                   // or return them to the component that opened the dialog
            	      	mListener.onDialogPositiveClick(RouteOptionDialogFragment.this);
               		}
               })
               .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
               @Override
               		public void onClick(DialogInterface dialog, int id) {
            	   		mListener.onDialogPositiveClick(RouteOptionDialogFragment.this);
               		}
               });
               
        // Create the AlertDialog object and return it
        return builder.create();
    }
}