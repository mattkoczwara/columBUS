package com.example.columbus;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SetPreferenceFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.layout.preference);
    }

}