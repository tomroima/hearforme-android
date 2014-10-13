package com.android.tomas.hearforme;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;


public class Myactivity extends Activity {

    private static final String TAG = Settings.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myactivity);
        TextView text = (TextView) findViewById(R.id.maintextView);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int size = sharedPref.getInt("dialog_preference",40);
        text.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        boolean switch1 = sharedPref.getBoolean("switch_preference",true);
        Log.d(TAG,String.valueOf(switch1));
    }

    @Override
    protected void onResume(){
        super.onResume();
        TextView text = (TextView) findViewById(R.id.maintextView);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int size = sharedPref.getInt("dialog_preference",30);
        text.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.myactivity, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(Myactivity.this,Settings.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
