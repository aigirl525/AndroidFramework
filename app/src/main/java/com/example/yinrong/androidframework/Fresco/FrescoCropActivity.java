package com.example.yinrong.androidframework.Fresco;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.yinrong.androidframework.R;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_fresco_crop)

public class FrescoCropActivity extends Activity {
private  GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
    @ViewInject(R.id.sdv_fresco_crop)
    private SimpleDraweeView sdv_fresco_crop;
    @ViewInject(R.id.tv_fresco_explain)
    private TextView tvFrescoExplain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_fresco_crop);

        x.view().inject(this);

        genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());

    }

    @Event(value = {R.id.bt_fresco_center, R.id.bt_fresco_centercrop, R.id.bt_fresco_focuscrop, R.id.bt_fresco_centerinside
            ,R.id.bt_fresco_fitcenter, R.id.bt_fresco_fitstart, R.id.bt_fresco_fitend, R.id.bt_fresco_fitxy
            ,R.id.bt_fresco_none })
    private  void getEvent(View view){
        switch (view.getId()){
            //居中无缩放
            case R.id.bt_fresco_center:

                tvFrescoExplain.setText("居中无缩放");

                //樣式設置
                GenericDraweeHierarchy hierarchy = genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER).build();

                imageDispaly(hierarchy);

                break;
            case R.id.bt_fresco_centercrop:

                tvFrescoExplain.setText("保持宽高比缩小或放大，使得两边都大于或等于显示边界。居中显示");

                //樣式設置
                hierarchy = genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build();

                imageDispaly(hierarchy);

                break;
            case R.id.bt_fresco_focuscrop:
                tvFrescoExplain.setText("同centerCrop, 但居中点不是中点，而是指定的某个点,这里我设置为图片的左上角那点");

                //设置focusCrop的缩放形式，并指定缩放的中心点在左上角
                PointF point = new PointF(0f,0f);
                //樣式設置
                hierarchy = genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP)
                        .setActualImageFocusPoint(point)
                        .build();

                imageDispaly(hierarchy);

                break;
            case R.id.bt_fresco_centerinside:
                tvFrescoExplain.setText("使两边都在显示边界内，居中显示。如果图尺寸大于显示边界，则保持长宽比缩小图片");

                //樣式設置
                hierarchy = genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build();

                imageDispaly(hierarchy);

                break;
            case R.id.bt_fresco_fitcenter:
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内。居中显示");

                //樣式設置
                hierarchy = genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();

                imageDispaly(hierarchy);
                break;
            case R.id.bt_fresco_fitstart:
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界左上对齐");

                //樣式設置
                hierarchy = genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).build();

                imageDispaly(hierarchy);

                break;
            case R.id.bt_fresco_fitend:
                tvFrescoExplain.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，不居中，和显示边界右下对齐");

                //樣式設置
                hierarchy = genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_END).build();

                imageDispaly(hierarchy);

                break;
            case R.id.bt_fresco_fitxy:
                tvFrescoExplain.setText("不保持宽高比，填充满显示边界");

                //樣式設置
                hierarchy = genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();

                imageDispaly(hierarchy);

                break;
            case R.id.bt_fresco_none:
                tvFrescoExplain.setText("如要使用tile mode显示, 需要设置为none");

                //樣式設置
                hierarchy = genericDraweeHierarchyBuilder.setActualImageScaleType(null).build();

                imageDispaly(hierarchy);

                break;
        }
    }
    public void imageDispaly(GenericDraweeHierarchy hierarchy){
        sdv_fresco_crop.setHierarchy(hierarchy);
        //加载图片
        Uri uri = Uri.parse("http://img4q.duitang.com/uploads/item/201305/20/20130520115416_VrUUR.jpeg");
        sdv_fresco_crop.setImageURI(uri);
    }
}
