package com.popper.daw.app;

import android.app.Application;


public class MyApp extends Application {
    private static Application myApp;
    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
    }

    public static MyApp getInstance(){
        return (MyApp) myApp;
    }
}
