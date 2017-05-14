package com.example.yinrong.androidframework.Fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yinrong.androidframework.Afinal.AfinalActivity;
import com.example.yinrong.androidframework.ButterKnife.ButterKnifeActivity;
import com.example.yinrong.androidframework.EventBus.EventBusActivity;
import com.example.yinrong.androidframework.Fresco.FrescoActivity;
import com.example.yinrong.androidframework.OpenDanmaku.OpenDanmakuActivity;
import com.example.yinrong.androidframework.Picasso.PicassoActivity;
import com.example.yinrong.androidframework.PullToRefresh.PullToRefreshActivity;
import com.example.yinrong.androidframework.R;
import com.example.yinrong.androidframework.RecyclerView.RecyclerViewActivity;
import com.example.yinrong.androidframework.TabLayoutViewPager.activity.TabLayoutViewPagerMainActivity;
import com.example.yinrong.androidframework.banner.activity.BannerMainActivity;
import com.example.yinrong.androidframework.countDownView.CountdownViewMainActivity;
import com.example.yinrong.androidframework.okhttp.adapter.CommonFrameFragmentAdapter;
import com.example.yinrong.androidframework.okhttp.base.BaseFragment;
import com.example.yinrong.androidframework.xUtils.xUtils3Activity;

/**
 * 作者：尚硅谷-杨光福 on 2016/7/21 19:27
 * 微信：yangguangfu520
 * QQ号：541433511
 * 作用：常用框架Fragment
 */
public class CommonFrameFragment extends BaseFragment {

    private ListView mListView;

    private String[] datas;

    private CommonFrameFragmentAdapter adapter;

    private static final String TAG = CommonFrameFragment.class.getSimpleName();//"CommonFrameFragment"

    @Override
    protected View initView() {

        Log.e(TAG, "常用框架Fragment页面被初始化了...");

        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        mListView = (ListView) view.findViewById(R.id.listview);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String data = datas[position];//okhttp

                if (data.toLowerCase().equals("okhttp")) {
                    // 点击条目跳转到OKHttp页面
                    //Intent intent = new Intent(mContext, OKHttpActivity.class);
                   // mContext.startActivity(intent);

                } else if (data.toLowerCase().equals("nativejsonprase")) {
                    // 点击条目跳转到手动JSON解析页面
                    // Intent intent = new Intent(mContext, NativeJsonPraseActivity.class);
                    // mContext.startActivity(intent);

                } else if (data.toLowerCase().equals("gson")) {
                    // 点击条目跳转到Gson解析页面
                    // Intent intent = new Intent(mContext, GsonActivity.class);
                    // mContext.startActivity(intent);

                } else if(data.toLowerCase().equals("fastjson")){
                    // 点击条目跳转到FastJson解析页面
                    // Intent intent = new Intent(mContext, FastJsonActivity.class);

                    //mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("xutils3--ok")){
                    // 点击条目跳转到FastJson解析页面
                    Intent intent = new Intent(mContext,xUtils3Activity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("afinal--ok")) {
                    // 点击条目跳转到Afinal页面
                    Intent intent = new Intent(mContext, AfinalActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("volley")) {
                    // 点击条目跳转到VolleyActivity页面
                    // Intent intent = new Intent(mContext, VolleyActivity.class);
                    // mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("eventbus--ok")) {
                    // 点击条目跳转到EventBusActivity页面
                    Intent intent = new Intent(mContext, EventBusActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("butterknife--ok")) {
                    // 点击条目跳转到Butterknife页面
                    Intent intent = new Intent(mContext, ButterKnifeActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("imageloader")) {
                    // 点击条目跳转到Imageloader页面
                    //Intent intent = new Intent(mContext, ImageLoaderActivity.class);
                    //mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("picasso--ok")) {
                    // 点击条目跳转到picasso页面
                    Intent intent = new Intent(mContext, PicassoActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("recyclerview--ok")) {
                    // 点击条目跳转到RecyclerView页面
                    Intent intent = new Intent(mContext, RecyclerViewActivity.class);

                    mContext.startActivity(intent);
                }else if(data.toLowerCase().equals("glide")) {
                    // 点击条目跳转到Glide页面
                    //Intent intent = new Intent(mContext, GlideActivity.class);
                    //startActivity(intent);
                }else if(data.toLowerCase().equals("fresco--ok")) {
                    // 点击条目跳转到Fresco页面
                    Intent intent = new Intent(mContext, FrescoActivity.class);
                    startActivity(intent);
                }else if(data.toLowerCase().equals("android-pulltorefresh--ok")) {
                    // 点击条目跳转到Fresco页面
                    Intent intent = new Intent(mContext, PullToRefreshActivity.class);
                    startActivity(intent);
                }else if(data.toLowerCase().equals("universalvideoview")) {
                    // 点击条目跳转到Fresco页面
                    // Intent intent = new Intent(mContext, UniversalVideoViewActivity.class);
                    // startActivity(intent);
                }else if(data.toLowerCase().equals("jiecaovideoplayer")) {
                    // 点击条目跳转到Fresco页面
                    // Intent intent = new Intent(mContext, JieCaoVideoPlayerMainActivity.class);
                    // startActivity(intent);
                }else if(data.toLowerCase().equals("banner--ok")) {
                    // 点击条目跳转到Fresco页面
                    Intent intent = new Intent(mContext, BannerMainActivity.class);
                    startActivity(intent);
                }
                else if(data.equals("CountdownView--OK")) {
                    // 点击条目跳转到Fresco页面
                    Intent intent = new Intent(mContext, CountdownViewMainActivity.class);
                    startActivity(intent);
                }
                else if(data.equals("OpenDanmaku弹幕--OK")) {
                    // 点击条目跳转到OpenDanmaku弹幕页面
                    Intent intent = new Intent(mContext, OpenDanmakuActivity.class);
                    startActivity(intent);
                } else if(data.equals("TabLayoutViewPager--OK")) {
                    // 点击条目跳转到OpenDanmaku弹幕页面
                    Intent intent = new Intent(mContext, TabLayoutViewPagerMainActivity.class);
                    startActivity(intent);
                }
                // 点击位置的显示
                Toast.makeText(mContext, "data==" + data, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    protected void initData() {
        super.initData();

        Log.e(TAG, "常用框架Fragment数据被初始化了...");

        //准备数据
        datas = new String[]{"OKHttp", "nativeJsonPrase", "Gson",
                "FastJson", "xUtils3--OK", "Afinal--OK", "Volley","Eventbus--OK",
                "Butterknife--OK","Imageloader","Picasso--OK","RecyclerView--OK","Glide",
                "Fresco--OK","Android-PullToRefresh--OK","UniversalVideoView",
                "JieCaoVideoPlayer", "Banner--OK","CountdownView--OK","OpenDanmaku弹幕--OK",
                 "TabLayoutViewPager--OK", "Retrofit2",  "greenDao",
                "RxJava", "Expandablelistview", "....."};

        //设置适配器
        adapter = new CommonFrameFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);
    }
}
