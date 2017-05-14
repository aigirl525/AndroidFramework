package com.example.yinrong.androidframework.xUtils;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yinrong.androidframework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

@ContentView(R.layout.activity_fragmentx_utils3)
public class FragmentxUtils3Activity extends FragmentActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_fragmentx_utils3);
        x.view().inject(this);

        //得到FragmentManeger
        FragmentManager fm = getSupportFragmentManager();
        //开启事务
        android.support.v4.app.FragmentTransaction tt = fm.beginTransaction();
        //替换Fragment
        tt.replace(R.id.fl_content,new DemoFragment());
        //提交
        tt.commit();
    }
}
