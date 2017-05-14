package com.example.yinrong.androidframework.countDownView;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.yinrong.androidframework.R;

import java.security.PrivateKey;

import cn.iwgang.countdownview.CountdownView;

public class CountdownViewMainActivity extends Activity {
    //定义Handler对象
    private Handler mHandler = new Handler();
    private CountdownView mCvCountdownViewTest5;
    private long time = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_view_main);

        TextView title = (TextView)findViewById(R.id.tv_title);
        title.setText("CountdownView");

        CountdownView mCvCountdownViewTest1 = (CountdownView)findViewById(R.id.cv_countdownViewTest1);
        mCvCountdownViewTest1.setTag("test1");
        //倒计时5小时
        long time1 = (long)5 * 60 * 60 * 1000;
        mCvCountdownViewTest1.start(time1);

        CountdownView mCvCountdownViewTest2 = (CountdownView)findViewById(R.id.cv_countdownViewTest2);
        mCvCountdownViewTest2.setTag("test2");
        //倒计时30分钟
        long time2 = (long)30 * 60 * 1000;
        mCvCountdownViewTest2.start(time2);

        CountdownView cvCountdownViewTest211 = (CountdownView)findViewById(R.id.cv_countdownViewTest211);
        cvCountdownViewTest211.setTag("test21");
        //倒计时30分钟
        long time211 = (long)30 * 60 * 1000;
        cvCountdownViewTest211.start(time211);

        CountdownView mCvCountdownViewTest21 = (CountdownView)findViewById(R.id.cv_countdownViewTest21);
        mCvCountdownViewTest21.setTag("test21");
        //倒计时24小时
        long time21 = (long)24 * 60 * 60 * 1000;
        mCvCountdownViewTest21.start(time21);

        CountdownView mCvCountdownViewTest22 = (CountdownView)findViewById(R.id.cv_countdownViewTest22);
        mCvCountdownViewTest22.setTag("test22");
        //倒计时30分钟
        long time22 = (long)30 * 60 * 1000;
        mCvCountdownViewTest22.start(time22);

        CountdownView mCvCountdownViewTest3 = (CountdownView)findViewById(R.id.cv_countdownViewTest3);
        //倒计时9小时
        long time3 = (long)9 * 60 * 60 * 1000;
        mCvCountdownViewTest3.start(time3);

        CountdownView mCvCountdownViewTest4 = (CountdownView)findViewById(R.id.cv_countdownViewTest4);
        //倒计时150天
        long time4 = (long)150 * 24 * 60 * 60 * 1000;
        mCvCountdownViewTest4.start(time4);

        mCvCountdownViewTest5 = (CountdownView)findViewById(R.id.cv_countdownViewTest5);

        //1s后执行Runnable对象的run方法
        mHandler.postDelayed(new MyRunnable(),1000);

        new AsyncTask<Void, Long, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                long time = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                        time += 1000;
                        publishProgress(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            protected void onProgressUpdate(Long... values) {
                super.onProgressUpdate(values);
    //            mCvCountdownViewTest5.updateShow(values[0]);
            }
        }.execute();

        CountdownView mCvCountdownViewTest6 = (CountdownView)findViewById(R.id.cv_countdownViewTest6);
      //倒计时2小时
        long time6 = (long)2 * 60 * 60 * 1000;
        mCvCountdownViewTest6.start(time6);


        findViewById(R.id.btn_toDynamicShowActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CountdownViewMainActivity.this, DynamicShowActivity.class));
            }
        });

        findViewById(R.id.btn_toListViewActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(CountdownViewMainActivity.this, CountdownListViewActivity.class));
            }
        });

        findViewById(R.id.btn_toRecyclerViewActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CountdownViewMainActivity.this, RecyclerViewActivity.class));
            }
        });
    }
    /**
     * 自定义Runnable对象
     * @author maoxf
     *
     */
    class MyRunnable implements Runnable{

        @Override
        public void run() {
          /*  //定义时间格式，获取系统时间
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            String time = format.format(date);
            mTime.setText(time);*/
            time += 1000;
            mCvCountdownViewTest5.updateShow(time);
            //每隔1s执行一次Run方法
            mHandler.postDelayed(this, 1000);
        }
    }
}