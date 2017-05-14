package com.example.yinrong.androidframework.Picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.yinrong.androidframework.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PicassoListViewActivity extends Activity {

    @Bind(R.id.lv_picasso)
    ListView lv_picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_list_view);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        PicassoListViewAdapter picassoListViewAdapter = new PicassoListViewAdapter(this);
        lv_picasso.setAdapter(picassoListViewAdapter);
    }
}
