package com.example.yinrong.androidframework.EventBus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yinrong.androidframework.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends Activity {
    private TextView tv_eventbus_result;
    private Button bt_eventbus_send;
    private Button bt_eventbus_sticky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        initView();
        initData();
        initListener();
    }

    private void initData() {
        //1.注册广播
        EventBus.getDefault().register(EventBusActivity.this);
    }

    private void initListener() {
        //跳转到发送页面
        bt_eventbus_send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(EventBusActivity.this,EventBusSendActivity.class);
                startActivity(intent);
            }
        });
        bt_eventbus_sticky.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //2.发送粘性事件
                EventBus.getDefault().postSticky(new StickyEvent("我是粘性事件"));

                Intent intent =  new Intent(EventBusActivity.this,EventBusSendActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        tv_eventbus_result = (TextView)findViewById(R.id.tv_eventbus_result);
        bt_eventbus_send = (Button)findViewById(R.id.bt_eventbus_send);
        bt_eventbus_sticky = (Button)findViewById(R.id.bt_eventbus_sticky);
    }
   //5.接收消息
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent msg){
        tv_eventbus_result.setText(msg.name);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //2.解注册
        EventBus.getDefault().unregister(EventBusActivity.this);
    }
}
