package com.example.yinrong.androidframework.TabLayoutViewPager.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yinrong.androidframework.TabLayoutViewPager.fragment.MyFragment;

import java.util.ArrayList;

/**
 * Created by hasee on 2017/1/11.
 */
public class ViewPagerAdapter  extends FragmentPagerAdapter{
    ArrayList<MyFragment> mFragments;
    public ViewPagerAdapter(FragmentManager fm ,  ArrayList<MyFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    /**
     * 得到页面的标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return  mFragments.get(position).getTitle();
    }
}
