package com.android.tomas.hearforme;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();


    private static TextView sTextView;
    private static FrameLayout sFrameLayout;

    public static void setMainTextColor(int newColor) {
        sTextView.setTextColor(newColor);
    }

    public static void setFrameBackgroundColor(int newColor){
        sFrameLayout.setBackgroundColor(newColor);
    }

    private void setTextStyle(boolean preference){
        if(preference){

            MainActivity.setMainTextColor(Color.BLACK);
            MainActivity.setFrameBackgroundColor(Color.WHITE);


        }else {
            MainActivity.setMainTextColor(Color.WHITE);
            MainActivity.setFrameBackgroundColor(Color.BLACK);
        }
    }

    private void setInputLanguage(String code){

    }

    private void setOutputLanguage(String code){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myactivity);
        sTextView = (TextView) findViewById(R.id.main_text_view);
        sFrameLayout = (FrameLayout) findViewById(R.id.container);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int size = sharedPref.getInt("dialog_preference",40);
        sTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        boolean style = sharedPref.getBoolean("switch_preference",true);
        this.setTextStyle(style);
        Log.d(TAG,sharedPref.getString("input_language_preference","None"));
        Log.d(TAG,sharedPref.getString("output_language_preference","None"));

    }

    @Override
    protected void onResume(){
        super.onResume();
        sTextView = (TextView) findViewById(R.id.main_text_view);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int size = sharedPref.getInt("dialog_preference",30);
        sTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        boolean style = sharedPref.getBoolean("switch_preference",true);
        this.setTextStyle(style);
        Log.d(TAG,sharedPref.getString("input_language_preference","None"));
        Log.d(TAG,sharedPref.getString("output_language_preference","None"));
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        sTextView = (TextView) findViewById(R.id.main_text_view);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int size = sharedPref.getInt("dialog_preference",30);
        sTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        boolean style = sharedPref.getBoolean("switch_preference",true);
        this.setTextStyle(style);
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
            Intent intent = new Intent(MainActivity.this,Settings.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
