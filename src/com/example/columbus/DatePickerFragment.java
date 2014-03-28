package com.example.columbus;

import java.util.Calendar;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


public class DatePickerFragment extends DialogFragment
	implements DatePickerDialog.OnDateSetListener {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
	    // Use the current time as the default values for the picker
		 final Calendar c = Calendar.getInstance();
	     int year = c.get(Calendar.YEAR);
	     int month = c.get(Calendar.MONTH);
	     int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of TimePickerDialog and return it
		 return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateChanged(TimePicker view, int hourOfDay, int minute) {
			// Do something with the time chosen by the user
		}

		@Override
		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}
	}