package com.example.yinrong.androidframework.Fresco;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yinrong.androidframework.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_fresco_modify_img)

public class FrescoModifyImgActivity extends Activity {
    @ViewInject(R.id.sdv_fresco_modify)
    private SimpleDraweeView sdv_fresco_modify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_fresco_modify_img);
        x.view().inject(this);

    }
    @Event(value =  R.id.bt_fresco_modify )
    private void getEvent(View view){


        Uri uri = Uri.parse("http://c.hiphotos.baidu.com/image/pic/item/962bd40735fae6cd21a519680db30f2442a70fa1.jpg");

        Postprocessor redMeshPostprocessor = new BasePostprocessor() {
            @Override
            public String getName() {
                return "redMeshPostprocessor";
            }

            //绘制红色点状网格
            @Override
            public void process(Bitmap bitmap) {

                for (int x = 0; x < bitmap.getWidth(); x += 2) {

                    for (int y = 0; y < bitmap.getHeight(); y += 2) {
                        bitmap.setPixel(x, y, Color.RED);
                    }
                }
            }
        };

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(redMeshPostprocessor)
                .build();

        PipelineDraweeController controller = (PipelineDraweeController)
                Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(sdv_fresco_modify.getController())
                        .build();

        sdv_fresco_modify.setController(controller);
    }
}
