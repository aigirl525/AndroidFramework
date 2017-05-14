package com.example.yinrong.androidframework.Fresco;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;

import com.example.yinrong.androidframework.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_fresco_auto_size_img)
public class FrescoAutoSizeImgActivity extends Activity {
    @ViewInject(value = R.id.ll_fresco)
    private LinearLayout ll_fresco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fresco_auto_size_img);
        x.view().inject(this);

    }
    @Event(value = R.id.bt_fresco_loadsmall  )
    private void getEvent(View view){
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this);
        //宽高比设置  必须设置  否则不显示
        simpleDraweeView.setAspectRatio(2.0f);
        //图片的地址
        final Uri uri = Uri.parse("http://img4q.duitang.com/uploads/item/201304/27/20130427043538_wAfHC.jpeg");


        //图片的请求
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .build();

        //加载图片的控制
        PipelineDraweeController controller = (PipelineDraweeController)
                Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(simpleDraweeView.getController())
                        .build();
        //加载图片
        simpleDraweeView.setController(controller);

        //添加View到线性布局中
        ll_fresco.addView(simpleDraweeView);
    }
}


