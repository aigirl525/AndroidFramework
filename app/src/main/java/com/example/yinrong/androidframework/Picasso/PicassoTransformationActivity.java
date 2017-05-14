package com.example.yinrong.androidframework.Picasso;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.yinrong.androidframework.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PicassoTransformationActivity extends Activity {
    @Bind(R.id.lv_picasso_transformation)
    ListView lv_picasso_transformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_transformation);
        ButterKnife.bind(this);

        initData();

    }

    private void initData() {

        List<String> list = new ArrayList<String>();
        for(int i = 1 ; i <= 36 ; i++){
            list.add(i+"");
        }
        PicassoTransformationAdapter picassoListViewAdapter = new PicassoTransformationAdapter(this,list);
        lv_picasso_transformation.setAdapter(picassoListViewAdapter);
    }
}
