package com.example.administrator.myapplication;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Administrator on 2017/3/17.
 */

public class Appllication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // 这个是用于分析内存的线程，这个里面不能初始化项目
            return;
        }
        LeakCanary.install(this);
    }
}
