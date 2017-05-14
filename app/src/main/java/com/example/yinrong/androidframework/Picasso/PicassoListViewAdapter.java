package com.example.yinrong.androidframework.Picasso;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yinrong.androidframework.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yinrong on 2016/11/22.
 */

public class PicassoListViewAdapter extends BaseAdapter{

    private Context mContext;

    public PicassoListViewAdapter(Context context) {
        mContext = context;
    }

    @Override

    public int getCount() {
        return Constants.IMAGES.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_picasso_listview,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Picasso.with(mContext).load(Constants.IMAGES[position])
                .placeholder(R.mipmap.demo)
                .error(R.mipmap.check)
                .into(viewHolder.iv_picasso_item);
        viewHolder.tv_picasso_item.setText("item"+(position+1));
        return convertView;
    }

    class ViewHolder{
        @Bind(R.id.iv_picasso_item)
        ImageView iv_picasso_item;
        @Bind(R.id.tv_picasso_item)
        TextView tv_picasso_item;
        public ViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }
}
