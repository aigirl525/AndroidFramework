package com.example.yinrong.androidframework.Fresco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yinrong.androidframework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;
@ContentView(R.layout.activity_fresco)
public class FrescoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fresco);
        x.view().inject(this);
    }

    @Event(value = {R.id.bt_fresco_spimg, R.id.bt_fresco_crop, R.id.bt_fresco_circleAndCorner, R.id.bt_fresco_jpeg
            ,R.id.bt_fresco_gif, R.id.bt_fresco_multi, R.id.bt_fresco_listener, R.id.bt_fresco_resize
            ,R.id.bt_fresco_modifyImg, R.id.bt_fresco_autoSizeImg})
    private  void getEvent(View view){
        switch (view.getId()){
            case R.id.bt_fresco_spimg:
                startActivity(new Intent(FrescoActivity.this,FrescoSpimgActivity.class));
                break;
            case R.id.bt_fresco_crop:
                startActivity(new Intent(FrescoActivity.this,FrescoCropActivity.class));
                break;
            case R.id.bt_fresco_circleAndCorner:
                startActivity(new Intent(FrescoActivity.this,FrescoCircleAndCornerActivity.class));
                break;
            case R.id.bt_fresco_jpeg:
                startActivity(new Intent(FrescoActivity.this,FrescoJpegActivity.class));
                break;
            case R.id.bt_fresco_gif:
                startActivity(new Intent(FrescoActivity.this,FrescoGifActivity.class));
                break;
            case R.id.bt_fresco_multi:
                startActivity(new Intent(FrescoActivity.this,FrescoMultiActivity.class));
                break;
            case R.id.bt_fresco_listener:
                startActivity(new Intent(FrescoActivity.this,FrescoListenerActivity.class));
                break;
            case R.id.bt_fresco_resize:
                startActivity(new Intent(FrescoActivity.this,FrescoResizeActivity.class));
                break;
            case R.id.bt_fresco_modifyImg:
                startActivity(new Intent(FrescoActivity.this,FrescoModifyImgActivity.class));
                break;
            case R.id.bt_fresco_autoSizeImg:
                startActivity(new Intent(FrescoActivity.this,FrescoAutoSizeImgActivity.class));
                break;
        }
    }
}
