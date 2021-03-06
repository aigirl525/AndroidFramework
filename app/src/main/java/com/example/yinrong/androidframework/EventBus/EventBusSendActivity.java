package com.example.yinrong.androidframework.EventBus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yinrong.androidframework.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusSendActivity extends Activity {
    private TextView tv_eventbus_send_result;
    private Button bt_eventbus_send_main;
    private Button bt_eventbus_send_sticky;
    private boolean isFirst = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_send);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        tv_eventbus_send_result = (TextView)findViewById(R.id.tv_eventbus_send_result);
        bt_eventbus_send_main = (Button)findViewById(R.id.bt_eventbus_send_main);
        bt_eventbus_send_sticky = (Button)findViewById(R.id.bt_eventbus_send_sticky);
    }

    private void initData() {
    }

    private void initListener() {
        //主线程发送数据按钮点击事件处理
        bt_eventbus_send_main.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            //4.发送消息
                EventBus.getDefault().post(new MessageEvent("主线程发送过来的数据"));
                finish();
            }
        });
        //接收粘性事件数据按钮的点击事件处理
        bt_eventbus_send_sticky.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //4.注册
                if(isFirst){
                    EventBus.getDefault().register(EventBusSendActivity.this);
                    isFirst = false;
                }
            }
        });
    }
    //3.接收粘性事件
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void StickyEventBus(StickyEvent msg){
        tv_eventbus_send_result.setText(msg.name);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //5.解注册
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(EventBusSendActivity.this);
    }
}
