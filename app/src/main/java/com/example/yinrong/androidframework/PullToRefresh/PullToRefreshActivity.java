package com.example.yinrong.androidframework.PullToRefresh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.yinrong.androidframework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_pull_to_refresh)
public class PullToRefreshActivity extends Activity {
 //   @ViewInject(R.id.tv_title)
 //   private TextView titlebar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_pull_to_refresh);
        x.view().inject(this);
//        titlebar.setText("PullToRefreshActivity");
    }
    @Event(value = {R.id.listview, R.id.gridview, R.id.fragment, R.id.viewpager, R.id.viewpager2, R.id.webview})
    private  void getEvent(View view){
        switch (view.getId()){
            case R.id.listview:
                startActivity(new Intent(PullToRefreshActivity.this,PullToRefreshListActivity.class));
                break;
            case R.id.gridview:
                startActivity(new Intent(PullToRefreshActivity.this,PullToRefreshGridActivity.class));
                break;
            case R.id.fragment:
                startActivity(new Intent(PullToRefreshActivity.this,PullToRefreshListFragmentActivity.class));
                break;
            case R.id.viewpager:
                startActivity(new Intent(PullToRefreshActivity.this,PullToRefreshListInViewPagerActivity.class));
                break;
            case R.id.viewpager2:
                startActivity(new Intent(PullToRefreshActivity.this,PullToRefreshViewPagerActivity.class));
                break;
            case R.id.webview:
                startActivity(new Intent(PullToRefreshActivity.this,PullToRefreshWebViewActivity.class));
                break;
        }
    }
}
