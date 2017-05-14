package com.example.yinrong.androidframework.xUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yinrong.androidframework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_x_utils3)
public class xUtils3Activity extends Activity {

    @ViewInject(R.id.btn_annotation)
    private Button textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_x_utils3);
        x.view().inject(this);
    }

    @Event(value = {R.id.btn_annotation, R.id.btn_net, R.id.btn_image, R.id.btn_imagelist})
    private  void getEvent(View view){
        switch (view.getId()){
            case R.id.btn_annotation:
                Intent intent = new Intent(xUtils3Activity.this, FragmentxUtils3Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_net:
                intent = new Intent(xUtils3Activity.this, xUtils3NetActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_image: break;
            case R.id.btn_imagelist: break;
        }
    }
}
