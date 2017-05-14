package com.example.yinrong.androidframework.Fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.example.yinrong.androidframework.R;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_fresco_spimg)
public class FrescoSpimgActivity extends Activity {
    @ViewInject(R.id.sdv_fresco)
    private SimpleDraweeView sdv_fresco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_fresco_spimg);
        x.view().inject(this);

        initData();
    }

    private void initData() {
        //设置样式
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());

        GenericDraweeHierarchy hierarcy = genericDraweeHierarchyBuilder.setProgressBarImage(new ProgressBarDrawable()).build();

        sdv_fresco.setHierarchy(hierarcy);

        //加载图片的地址
        Uri uri = Uri.parse("http://img4.duitang.com/uploads/item/201211/24/20121124175330_ruKEK.jpeg");

        //加载图片
       sdv_fresco.setImageURI(uri);
    }
}
