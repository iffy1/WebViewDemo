package com.example.myapplication;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * author : iffy
 * time   : 2020/03/08
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openDebug();
        ARouter.openLog();
        //初始化ARouter
        ARouter.init(this);
    }
}
