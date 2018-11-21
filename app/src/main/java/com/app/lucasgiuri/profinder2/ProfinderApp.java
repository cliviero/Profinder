package com.app.lucasgiuri.profinder2;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class ProfinderApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
