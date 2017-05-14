package com.example.yinrong.androidframework.Fresco;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yinrong.androidframework.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_fresco_resize)

public class FrescoResizeActivity extends Activity {
    @ViewInject(R.id.sdv_fresco_resize)
    private SimpleDraweeView sdv_fresco_resize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fresco_resize);
        x.view().inject(this);

    }


    @Event(value =  {R.id.bt_fresco_resize,R.id.bt_fresco_rotate })
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.bt_fresco_resize :
                //图片地址
                Uri uri = Uri.parse("http://c.hiphotos.baidu.com/image/pic/item/962bd40735fae6cd21a519680db30f2442a70fa1.jpg");
                //图片的请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                                        .setResizeOptions(new ResizeOptions(50,50))
                                        .build();
                //控制图片的加载
                PipelineDraweeController  controller = (PipelineDraweeController)Fresco.newDraweeControllerBuilder()
                                                        .setOldController(sdv_fresco_resize.getController())
                                                        .setImageRequest(request)
                                                        .build();
                //加载图片
                sdv_fresco_resize.setController(controller);
                break;
            case R.id.bt_fresco_rotate :
                //图片地址
                Uri uri1 = Uri.parse("http://c.hiphotos.baidu.com/image/pic/item/962bd40735fae6cd21a519680db30f2442a70fa1.jpg");
                //图片的请求
                ImageRequest request1 = ImageRequestBuilder.newBuilderWithSource(uri1)
                        .setAutoRotateEnabled(true)
                        .build();
                //控制图片的加载
                DraweeController  controller1 =  Fresco.newDraweeControllerBuilder()
                        .setOldController(sdv_fresco_resize.getController())
                        .setImageRequest(request1)
                        .build();
                //加载图片
                sdv_fresco_resize.setController(controller1);
                break;
        }
    }
}
