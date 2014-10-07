package com.android.tomas.hearforme;

import android.app.Activity;

import android.os.Bundle;

import android.preference.PreferenceFragment;

import android.view.Menu;
import android.view.MenuItem;



public class Settings extends Activity {

    private static final String TAG = Settings.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
 /*
    @Override
    protected void onResume() {
        super.onResume();
        TextView text = (TextView) findViewById(R.id.textView);
        Global g = (Global) getApplication();
        text.setTextSize(TypedValue.COMPLEX_UNIT_PX, g.getTextSize());
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }
    /*
    public void magnify(View v) {
        TextView text = (TextView) findViewById(R.id.textView);
        Log.d(TAG, String.valueOf(text.getTextSize() ));

        text.setTextSize(TypedValue.COMPLEX_UNIT_PX, text.getTextSize() + 4);
        Global g = (Global) getApplication();
        g.setTextSize(text.getTextSize());


    }

    public void minify(View v){
        TextView text = (TextView) findViewById(R.id.textView);
        Log.d(TAG, String.valueOf(text.getTextSize() ));

        text.setTextSize(TypedValue.COMPLEX_UNIT_PX, text.getTextSize() - 4);
        Global g = (Global) getApplication();
        g.setTextSize(text.getTextSize());
    }
    */
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

    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.preferences);

        }

    }

}
