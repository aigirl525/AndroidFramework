package com.example.yinrong.androidframework.banner.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.yinrong.androidframework.MyApplication;
import com.example.yinrong.androidframework.R;
import com.example.yinrong.androidframework.banner.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

public class BannerStyleActivity extends Activity implements  AdapterView.OnItemSelectedListener {
    Banner banner;
    Spinner spinnerStyle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_style);
        banner = (Banner) findViewById(R.id.banner);
        spinnerStyle= (Spinner) findViewById(R.id.spinnerStyle);
        spinnerStyle.setOnItemSelectedListener(this);

        //默认是CIRCLE_INDICATOR
        banner.setImages(MyApplication.images)
                .setBannerTitles(MyApplication.titles)
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            //设置不同样式的方法
            case 0:
                banner.updateBannerStyle(BannerConfig.NOT_INDICATOR);
                break;
            case 1:
                banner.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                break;
            case 2:
                banner.updateBannerStyle(BannerConfig.NUM_INDICATOR);
                break;
            case 3:
                banner.updateBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
                break;
            case 4:
                banner.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                break;
            case 5:
                banner.updateBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
