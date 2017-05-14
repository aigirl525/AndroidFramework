package com.example.yinrong.androidframework;


import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zxy.recovery.core.Recovery;

import org.xutils.x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yinrong on 2016/11/28.
 */
//代表整个软件
public class MyApplication extends Application {

    public static List<?> images=new ArrayList<>();
    public static List<String> titles=new ArrayList<>();
    public static int H;
    @Override
    public void onCreate() {
        super.onCreate();
        //xUtil3初始化
        x.Ext.init(this);
        // 是否输出debug日志, 开启debug会影响性能.
        x.Ext.setDebug(true);
        Fresco.initialize(this);
        //初始化banner
        initBanner();
    }

    private void initBanner() {
        H=getScreenH(this);
        Fresco.initialize(this);
        //让软件状态还原的框架
        Recovery.getInstance()
                .debug(true)
                .recoverInBackground(false)
                .recoverStack(true)
                .mainPage(MainActivity.class)
                .init(this);
        String[] urls = getResources().getStringArray(R.array.url4);
        String[] tips = getResources().getStringArray(R.array.title);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        titles= Arrays.asList(tips);
    }

    /**
     * 得到屏幕的高
     * @param aty
     * @return
     */
    public int getScreenH(Context aty) {
        DisplayMetrics dm = aty.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
}
