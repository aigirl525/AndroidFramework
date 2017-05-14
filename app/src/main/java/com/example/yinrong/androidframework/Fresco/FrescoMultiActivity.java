package com.example.yinrong.androidframework.Fresco;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yinrong.androidframework.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

@ContentView(R.layout.activity_fresco_multi)
public class FrescoMultiActivity extends Activity {
    @ViewInject(R.id.sdv_fresco_multi)
    private SimpleDraweeView sdv_fresco_multi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fresco_multi);
        x.view().inject(this);

    }
    @Event(value = {R.id.bt_fresco_multiImg, R.id.bt_fresco_thumbnailImg,R.id.bt_fresco_multiplexImg})
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.bt_fresco_multiImg:
                //同一张图片，不同品质的两个uri
                Uri lowResUri = Uri.parse("http://img1.gamedog.cn/2012/03/11/19-120311133617-50.jpg");
                Uri highResUri = Uri.parse("http://img5.duitang.com/uploads/item/201312/03/20131203153823_Y4y8F.jpeg");

                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setLowResImageRequest(ImageRequest.fromUri(lowResUri))
                        .setImageRequest(ImageRequest.fromUri(highResUri))
                        .setOldController(sdv_fresco_multi.getController())
                        .build();

                sdv_fresco_multi.setController(controller);
                break;
            case R.id.bt_fresco_thumbnailImg:

                //将本地图片地址转换成Uri
                Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory()+"/meinv1.jpeg"));

                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setLocalThumbnailPreviewsEnabled(true)
                        .build();

                controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(sdv_fresco_multi.getController())
                        .build();

                sdv_fresco_multi.setController(controller);
                break;
            case R.id.bt_fresco_multiplexImg:


                //本地图片的复用
                //在请求之前，还会去内存中请求一次图片，没有才会先去本地，最后去网络uri
                //本地准备复用图片的uri  如果本地这个图片不存在，会自动去加载下一个uri
                Uri uri1 = Uri.fromFile(new File(Environment.getExternalStorageDirectory()+"/meinv1.jpeg"));
                //图片的网络uri
                Uri uri2 = Uri.parse("http://img5.duitang.com/uploads/item/201312/03/20131203153823_Y4y8F.jpeg");

                ImageRequest request1 = ImageRequest.fromUri(uri1);
                ImageRequest request2 = ImageRequest.fromUri(uri2);
                ImageRequest[] requests = {request1, request2};

                controller = Fresco.newDraweeControllerBuilder()
                        .setFirstAvailableImageRequests(requests)
                        .setOldController(sdv_fresco_multi.getController())
                        .build();

                sdv_fresco_multi.setController(controller);
                break;
        }

    }
}
