package com.example.yinrong.androidframework.Fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.yinrong.androidframework.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
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

@ContentView(R.layout.activity_fresco_jpeg)

public class FrescoJpegActivity extends Activity {
    @ViewInject(R.id.sdv_fresco_jpeg)
    private SimpleDraweeView sdv_fresco_jpeg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_fresco_jpeg);
           x.view().inject(this);

    }
    @Event(value =  R.id.sdv_fresco_askImg)
    private  void getEvent(View view) {
        // 加载质量配置
        ProgressiveJpegConfig jpegConfig = new ProgressiveJpegConfig() {
            @Override
            public int getNextScanNumberToDecode(int scanNumber) {
                return scanNumber + 2;
            }

            @Override
            public QualityInfo getQualityInfo(int scanNumber) {
                boolean isGoodEnough = (scanNumber >= 5);

                return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
            }
        };

        ImagePipelineConfig.newBuilder(this).setProgressiveJpegConfig(jpegConfig).build();
        // 获取图片URL
        Uri uri = Uri.parse("http://cdn.duitang.com/uploads/item/201303/12/20130312021353_45Qix.jpeg");

        // 获取图片请求
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(true).build();

        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setTapToRetryEnabled(true)
                .setOldController(sdv_fresco_jpeg.getController())//使用oldController可以节省不必要的内存分配
                .build();

        // 设置加载的控制
        sdv_fresco_jpeg.setController(draweeController);
    }
}
