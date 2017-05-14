package com.example.yinrong.androidframework.OpenDanmaku;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.yinrong.androidframework.R;
import com.opendanmaku.DanmakuItem;
import com.opendanmaku.DanmakuView;
import com.opendanmaku.IDanmakuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;

/**
 * DanmakuView的自定义属性
 *  start_Y_offset
 第一条播放航道距离弹幕View上边缘的偏移量,注意值是百分比量,以弹幕View的高度为基准,简而言之就是弹幕View的上边缘空出多少百分比.
 * end_Y_offset
 与上一个属性类似,最后一条播放航道距离弹幕View上边缘的偏移量,注意值是百分比量,以弹幕View的高度为基准,主要作用是便于在弹幕View的底部留出一定的空白.
 * max_row
 设置最多多少条播放航道
 * max_running_per_row
 每条航道上最多同时有多少条弹幕运行.
 * pick_interval
 每隔多少毫秒取出一条弹幕来播放.
 * show_debug
 是否显示航道线及播放帧率,调试时很有用,主要用于调试.
 */
public class OpenDanmakuActivity extends Activity implements View.OnClickListener {
    @butterknife.Bind(R.id.danmakuView)
    public DanmakuView mDanmakuView;
    @butterknife.Bind(R.id.switcher)
    public Button switcherBtn;
    @butterknife.Bind(R.id.send)
    public Button sendBtn;
    @butterknife.Bind(R.id.text)
    public EditText textEditText;
    @butterknife.Bind(R.id.tv_title)
    public TextView tv_title;
    @butterknife.Bind(R.id.videoView)
    public VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_danmaku);
        ButterKnife.bind(this);
        tv_title.setText("OpenDanmaku");
        //设置相关播放视频
        setVideoView();
        //重点
        List<IDanmakuItem> list = initItems();
        //变成随机数据
        Collections.shuffle(list);
        //添加到弹幕控件里面
        //true/**是否新建后台线程来执行添加任务*/
        mDanmakuView.addItem(list, true);

        switcherBtn.setOnClickListener(this);
        sendBtn.setOnClickListener(this);
    }

    /**
     * 播放视频相关
     */
    private void setVideoView() {
        //设置准备好的监听
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //开始播放
                videoView.start();//开始播放
            }
        });
        //设置播放完成
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();//重新开始播放
            }
        });
        //设置播放出错
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(OpenDanmakuActivity.this, "播放出错了", Toast.LENGTH_SHORT).show();
                return true;//true不显示提示框，false显示提示框
            }
        });
        //设置控制面板  可以暂停，调进度
        videoView.setMediaController(new MediaController(this));
        //设置播放地址
        //videoView.setVideoPath("http://vfx.mtime.cn/Video/2016/12/12/mp4/161212190638286683_480.mp4");
        //oppo.mp4放到D:\androidstudy\apache-tomcat-6.0.48\webapps\ROOT
        videoView.setVideoPath("http://172.27.35.1:8080/oppo.mp4");
    }

    /**
     * 构建弹幕集合
     * @return
     */
    private List<IDanmakuItem> initItems() {
        List<IDanmakuItem> list = new ArrayList<>();
        //创建100条文本的弹幕
        for (int i = 0; i < 100; i++) {
            IDanmakuItem item = new DanmakuItem(this, i + " : plain text danmuku", mDanmakuView.getWidth());
            list.add(item);
        }
        //创建100条文本带图片的弹幕
        String msg = " : text with image   ";
        for (int i = 0; i < 100; i++) {
            ImageSpan imageSpan = new ImageSpan(this, R.drawable.em);
            //图片和文字形成一个整体
            SpannableString spannableString = new SpannableString(i + msg);
            spannableString.setSpan(imageSpan, spannableString.length() - 2, spannableString.length() - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            IDanmakuItem item = new DanmakuItem(this, spannableString, mDanmakuView.getWidth(), 0, 0, 0, 1.5f);
            list.add(item);
        }
        return list;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //显示弹幕
        mDanmakuView.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //隐藏弹幕
        mDanmakuView.hide();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //清除  弹幕
        mDanmakuView.clear();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switcher:
                if (mDanmakuView.isPaused()) {
                    switcherBtn.setText(R.string.hide);
                    mDanmakuView.show();
                } else {
                    switcherBtn.setText(R.string.show);
                    mDanmakuView.hide();
                }
                break;
            case R.id.send:
                String input = textEditText.getText().toString();
                if (TextUtils.isEmpty(input)) {
                    Toast.makeText(OpenDanmakuActivity.this, R.string.empty_prompt, Toast.LENGTH_SHORT).show();
                } else {
                    IDanmakuItem item = new DanmakuItem(this, new SpannableString(input), mDanmakuView.getWidth(),0,R.color.my_item_color,0,1);
//                    IDanmakuItem item = new DanmakuItem(this, input, mDanmakuView.getWidth());
//                    item.setTextColor(getResources().getColor(R.color.my_item_color));
//                    item.setTextSize(14);
//                    item.setTextColor(textColor);
                    mDanmakuView.addItemToHead(item);
                }
                textEditText.setText("");
                break;
        }
    }
}
