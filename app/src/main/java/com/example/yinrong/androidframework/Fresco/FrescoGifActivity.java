package com.example.yinrong.androidframework.Fresco;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.yinrong.androidframework.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_fresco_gif)
public class FrescoGifActivity extends Activity {
    @ViewInject(R.id.sdv_fresco_gif)
    private SimpleDraweeView sdv_fresco_gif;
    @ViewInject(R.id.tv_title)
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_fresco_gif);
        x.view().inject(this);

        tv_title.setText("Gif动画");
    }
    @Event(value = {R.id.bt_fresco_askImg, R.id.bt_fresco_startAnim,R.id.bt_fresco_stopAnim})
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.bt_fresco_askImg:
                // 图片地址
                //Uri uri = Uri.parse("http://www.sznews.com/humor/attachement/gif/site3/20140902/4487fcd7fc66156f51db5d.gif");
                Uri uri = Uri.parse("http://img.huofar.com/data/jiankangrenwu/shizi.gif");

                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(true)
                        .setOldController(sdv_fresco_gif.getController())
                        .build();

                //设置控制器
                sdv_fresco_gif.setController(controller);

                break;
            case R.id.bt_fresco_startAnim:
                Animatable animation = sdv_fresco_gif.getController().getAnimatable();

                if (animation != null && !animation.isRunning()) {
                    animation.start();
                }
                break;
            case R.id.bt_fresco_stopAnim:

                animation = sdv_fresco_gif.getController().getAnimatable();

                if (animation != null && animation.isRunning()) {
                    animation.stop();
                }
                break;
        }

    }
}
