package com.example.administrator.mytest20176_4;

import android.app.Application;

/**
 * Created by LCT
 * Time:2016/4/7 16:26.
 * Annotation：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationContext.context=this;
    }
}
