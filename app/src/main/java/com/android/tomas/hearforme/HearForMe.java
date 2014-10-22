package com.android.tomas.hearforme;

import android.app.Application;
import android.content.Context;

/**
 * Created by tomasroigmartinez on 22/10/14.
 */
public class HearForMe extends Application {
   private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
    public static Context getContext() {
        return mContext;
    }
}
