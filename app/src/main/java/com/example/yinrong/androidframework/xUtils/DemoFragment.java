package com.example.yinrong.androidframework.xUtils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yinrong.androidframework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by yinrong on 2016/11/29.
 */
@ContentView(R.layout.fragment_demo)
public class DemoFragment extends Fragment {
    @ViewInject(R.id.btn_fragment)
    private Button btn_fragment;

    @ViewInject(R.id.tv_fragment)
    private TextView tv_fragment;

    private Context context;
    //Fragment 被创建
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // context = getContext();
    }
    //Fragment 视图 被创建

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
     //   return super.onCreateView(inflater, container, savedInstanceState);
        return x.view().inject(this,inflater,container);
    }
    //activity 创建好了
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"我被点击了",Toast.LENGTH_SHORT).show();
            }
        });
        tv_fragment.setText("fragment中的textview");
    }
}
