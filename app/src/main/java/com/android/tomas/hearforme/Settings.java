package com.android.tomas.hearforme;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.MenuItem;



public class Settings extends Activity  {

    private static final String TAG = Settings.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener{

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.preferences);
            Preference switchPref = findPreference("switch_preference");
            switchPref.setOnPreferenceChangeListener(this);
        }

        public boolean onPreferenceChange(Preference preference,Object newValue){
            if((Boolean) newValue){

                MainActivity.setMainTextColor(Color.BLACK);
                MainActivity.setFrameBackgroundColor(Color.WHITE);

            }else {
                MainActivity.setMainTextColor(Color.WHITE);
                MainActivity.setFrameBackgroundColor(Color.BLACK);
            }
            return true;
        }

    }
}



