package com.example.yinrong.androidframework.Fresco;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yinrong.androidframework.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_fresco_circle_and_corner)

public class FrescoCircleAndCornerActivity extends Activity {

    @ViewInject(R.id.sdv_fresco_circleandcorner)
    private SimpleDraweeView sdvFrescoCircleandcorner;

    private Uri uri;
    private GenericDraweeHierarchyBuilder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fresco_circle_and_corner);
        x.view().inject(this);

        uri = Uri.parse("http://img4q.duitang.com/uploads/item/201304/27/20130427043538_wAfHC.jpeg");
        builder = new GenericDraweeHierarchyBuilder(getResources());

    }

    @Event(value = {R.id.bt_fresco_circle, R.id.bt_fresco_corner })
    private  void getEvent(View view){
        switch (view.getId()){
            case R.id.bt_fresco_circle:
                // 参数设置为圆形
                RoundingParams params = RoundingParams.asCircle();
                GenericDraweeHierarchy hierarchy = builder.setRoundingParams(params).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy);

                // 加载图片
                sdvFrescoCircleandcorner.setImageURI(uri);
                break;
            case R.id.bt_fresco_corner:

                // 配置参数
                params = RoundingParams.fromCornersRadius(50f);//设置圆角大小
                params.setOverlayColor(getResources().getColor(android.R.color.holo_red_light));//覆盖层
                params.setBorder(getResources().getColor(android.R.color.holo_blue_light), 5);//边框
                //params.setRoundAsCircle(true);//如果是RoundingParams.fromCornersRadius，这个可以强制进行圆形展示

                // 设置圆形参数
                hierarchy = builder.setRoundingParams(params).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy);

                // 加载图片
                sdvFrescoCircleandcorner.setImageURI(uri);
                break;
        }
    }
}
