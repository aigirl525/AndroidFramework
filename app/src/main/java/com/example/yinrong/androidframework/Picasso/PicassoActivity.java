package com.example.yinrong.androidframework.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yinrong.androidframework.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PicassoActivity extends Activity {
    @Bind(R.id.btn_picasso_base)
    Button btn_picasso_base;

    @Bind(R.id.btn_picasso_listview)
    Button btn_picasso_listview;

    @Bind(R.id.btn_picasso_transformations)
    Button btn_picasso_transformations;

    @Bind(R.id.iv_picasso1)
    ImageView ivPicasso1;

    @Bind(R.id.iv_picasso2)
    ImageView ivPicasso2;

    @Bind(R.id.iv_picasso3)
    ImageView ivPicasso3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
         ButterKnife.bind(this);
        initData();
    }

    private void initData() {

    }

    @OnClick(R.id.btn_picasso_base)
    void btn_picasso_base_click(View view){
        //基本用法

       //普通加载
        Picasso.with(PicassoActivity.this).load("http://n.sinaimg.cn/translate/20160819/9BpA-fxvcsrn8627957.jpg")
                .into(ivPicasso1);
        //裁剪方式
       Picasso.with(this).load("http://n.sinaimg.cn/translate/20160819/9BpA-fxvcsrn8627957.jpg")
               .resize(100,100)
               .into(ivPicasso2);
        //旋转180度
       Picasso.with(this).load("http://n.sinaimg.cn/translate/20160819/9BpA-fxvcsrn8627957.jpg")
               .rotate(180)
               .into(ivPicasso3);

    }

    @OnClick(R.id.btn_picasso_listview)
    void btn_picasso_listview_click(View view){
        //跳转到ListView页面
        Intent intent = new Intent(PicassoActivity.this,PicassoListViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_picasso_transformations)
    void btn_picasso_transformations_click(View view){
        //跳转到图片转换页面
        Intent intent = new Intent(PicassoActivity.this,PicassoTransformationActivity.class);
        startActivity(intent);
    }
}
