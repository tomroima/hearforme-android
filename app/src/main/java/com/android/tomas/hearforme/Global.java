package com.android.tomas.hearforme;

import android.app.Application;

/**
 * Created by tomasroigmartinez on 06/10/14.
 */
public class Global extends Application {
    private float textSize = 40;

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float size) {
        this.textSize = size;
    }
}
