package com.example.yinrong.androidframework.ButterKnife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yinrong.androidframework.R;

import butterknife.OnClick;


public class ButterKnifeActivity extends Activity {

    @butterknife.Bind(R.id.tv_butterknife)
    TextView tv_butterknife;

    @butterknife.Bind(R.id.c_butterknife)
    CheckBox c_butterknife;

    @butterknife.Bind(R.id.bt_butterknife)
    Button bt_butterknife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        butterknife.ButterKnife.bind(this);

        initData();
    }

    private void initData() {
       tv_butterknife.setText("wohaoxihuan");
    }

    @OnClick(R.id.c_butterknife)
    void cbButterKnife(View view ){
        Toast.makeText(ButterKnifeActivity.this,"点击了chexkbox" ,Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.bt_butterknife)
    void btButterKnife(View view ){
        Toast.makeText(ButterKnifeActivity.this,"点击了button" ,Toast.LENGTH_SHORT).show();
    }
}
