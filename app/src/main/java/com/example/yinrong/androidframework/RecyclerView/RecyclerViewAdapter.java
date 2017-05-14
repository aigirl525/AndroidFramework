package com.example.yinrong.androidframework.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yinrong.androidframework.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by yinrong on 2016/12/2.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHoder> {

    private Context mContext;
    private ArrayList<String> mDatas;
    public RecyclerViewAdapter(Context context , ArrayList<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    /**
     * 相当于getview中创建view和viewholder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerViewAdapter.ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_recycleview,null);
        return new ViewHoder(itemView);
    }

    /**
     * 相当于getview中的绑定数据的代码
     * 数据和view绑定
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerViewAdapter. ViewHoder holder, int position) {
        holder.item_recycleview_tv.setText(mDatas.get(position));
    }

    /**
     *  得到总条数
     */
    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 添加数据
     * @param i
     * @param new_content
     */
    public void addData(int i, String new_content) {
        mDatas.add(i,new_content);
        //刷新适配器
        notifyItemInserted(i);
    }
    /**
     * 删除数据
     * @param i
     */
    public void deleteData(int i) {
        mDatas.remove(i);
        //刷新适配器
        notifyItemRemoved(i);
    }

    class  ViewHoder extends RecyclerView.ViewHolder{

        @ViewInject(R.id.item_recycleview_iv)
        private ImageView item_recycleview_iv;

        @ViewInject(R.id.item_recycleview_tv)
        private TextView item_recycleview_tv;

        public ViewHoder(final View itemView) {
            super(itemView);
            x.view().inject(this,itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //回调设置监听
                    if(onItemClickListener != null){
                        onItemClickListener.onItemClick(itemView, mDatas.get(getLayoutPosition()));
                    }
                    //直接设置监听
                 //   Toast.makeText(mContext,  mDatas.get(getLayoutPosition()),Toast.LENGTH_SHORT).show();
                }
            });
            item_recycleview_iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                      Toast.makeText(mContext,  "我是图片" + mDatas.get(getLayoutPosition()),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * 点击RecycleView某条的监听
     */
    public interface OnItemClickListener{
        /**
         * 当RecycleView某条被点击的时候回调
         * @param itemView  点击item的视图
         * @param data  点击得到的数据
         */
        public void onItemClick(View itemView , String data);
    }

    private OnItemClickListener onItemClickListener;

    /**
     * 设置RecycleView某条的监听
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
