package com.example.yinrong.androidframework.TabLayoutViewPager.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yinrong.androidframework.R;
import com.example.yinrong.androidframework.TabLayoutViewPager.Adapter.ViewPagerAdapter;
import com.example.yinrong.androidframework.TabLayoutViewPager.fragment.MyFragment;

import java.util.ArrayList;

public class TabLayoutViewPagerMainActivity extends AppCompatActivity {
    TextView title;
    ViewPager viewpager;
    ArrayList<MyFragment> fragments;
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_view_pager_main);
        title = (TextView)findViewById(R.id.tv_title);
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        title.setText("TabLayout的使用");
        //初始化数据
        fragments = new ArrayList<>();
        for (int i = 0; i < 12 ;i++){
            fragments.add(new MyFragment("标题"+i,"内容"+i));
        }
        //设置适配器
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewpager.setAdapter(viewPagerAdapter);
        //关联ViewPager
        tabLayout.setupWithViewPager(viewpager);
        //设置固定的
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
