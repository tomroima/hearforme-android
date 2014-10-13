package com.android.tomas.hearforme;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by tomasroigmartinez on 07/10/14.
 */
public class TheCustomDialogPreference extends DialogPreference {
    private static final String TAG = Settings.class.getSimpleName();

    private int mTextSize;

        public TheCustomDialogPreference(Context context, AttributeSet attrs) {
            super(context, attrs);
            setDialogLayoutResource(R.layout.preferences_custom_dialog);

        }
    @Override
    protected void onBindDialogView(View view){
        final TextView text = (TextView)view.findViewById(R.id.dialogtext);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        int size = sharedPref.getInt("dialog_preference",30);
        text.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        SeekBar mySeekbar = (SeekBar)view.findViewById(R.id.dialogseekbar);

        mySeekbar.setProgress(Math.max(size-30,0));

        mySeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            };

            public void onStopTrackingTouch(SeekBar seekBar) {
            };

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG,String.valueOf(progress));
                text.setTextSize(TypedValue.COMPLEX_UNIT_PX, progress + 30);
                mTextSize = progress + 30;
            };

        });

        super.onBindDialogView(view);
    }
    @Override
    protected void onDialogClosed(boolean positiveResult) {
        if(positiveResult){
            persistInt(mTextSize);
        }

    }

}
