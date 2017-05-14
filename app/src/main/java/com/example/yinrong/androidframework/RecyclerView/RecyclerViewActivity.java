package com.example.yinrong.androidframework.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.yinrong.androidframework.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

@ContentView(R.layout.activity_recycler_view)
public class RecyclerViewActivity extends Activity {
    @ViewInject(R.id.recyclerview)
    private RecyclerView recyclerview;
    private RecyclerViewAdapter recyclerViewAdapter;

    private ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_recycler_view);
        x.view().inject(this);

        //准备数据集合
        datas = new ArrayList<String>();
        for(int i = 0; i <100 ; i++){
            datas.add("content" + i);
        }
        //设置RecyclerViewAdapter适配器
         recyclerViewAdapter = new RecyclerViewAdapter(this,datas);
        recyclerview.setAdapter(recyclerViewAdapter);

        //设置layoutmanager
        recyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this,LinearLayoutManager.VERTICAL,false));

        //添加recyclerview的灰色分割线
        recyclerview.addItemDecoration(new DividerListItemDecoration(this,DividerListItemDecoration.VERTICAL_LIST));

        //回调设置监听
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, String data) {
                 Toast.makeText(RecyclerViewActivity.this ,  data,Toast.LENGTH_SHORT).show();
            }
        });

        //设置动画
        recyclerview.setItemAnimator(new DefaultItemAnimator() );
    }
    @Event(value = {R.id.btn_add, R.id.btn_delete, R.id.btn_list, R.id.btn_grid, R.id.btn_flow  })
    private  void getEvent(View view){
        switch (view.getId()){
            case R.id.btn_add:
                recyclerViewAdapter.addData(0,"new_content");
                recyclerview.scrollToPosition(0);
                break;
            case R.id.btn_delete:
                recyclerViewAdapter.deleteData(0);
                break;
            case R.id.btn_list:
                //设置layoutmanager
                //设置listview效果
               recyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this,LinearLayoutManager.VERTICAL,false));
                //  recyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this,LinearLayoutManager.HORIZONTAL,false));
              /*  recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
                recyclerview.scrollToPosition(datas.size() - 1);*/
                break;
            case R.id.btn_grid:
                //设置gridview效果
                recyclerview.setLayoutManager(new GridLayoutManager(RecyclerViewActivity.this,7,GridLayoutManager.VERTICAL,false));
                break;
            case R.id.btn_flow:
                //设置瀑布流效果
                recyclerview.setLayoutManager(new StaggeredGridLayoutManager(7,StaggeredGridLayoutManager.VERTICAL));
                break;
        }
    }
}
