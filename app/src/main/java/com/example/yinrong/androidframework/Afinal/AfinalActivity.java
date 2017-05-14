package com.example.yinrong.androidframework.Afinal;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yinrong.androidframework.R;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.io.File;
import java.io.FileNotFoundException;

public class AfinalActivity extends FinalActivity {

    @ViewInject(id = R.id.btn_afinal_base,click = "btn_afinal_base_click")
    private Button btn_afinal_base;

    @ViewInject(id = R.id.btn_afinal_gettext,click = "btn_afinal_gettext_click")
    private Button btn_afinal_gettext;

    @ViewInject(id = R.id.btn_afinal_filedownload,click = "btn_afinal_filedownload_click")
    private Button btn_afinal_filedownload;

    @ViewInject(id = R.id.btn_afinal_fileupload,click = "btn_afinal_fileupload_click")
    private Button btn_afinal_fileupload;

    @ViewInject(id = R.id.iv_afinal)
    private ImageView iv_afinal;

    @ViewInject(id = R.id.tv_afinal)
    private TextView tv_afinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afinal);
    }
    //加载图片点击事件处理
    public void btn_afinal_base_click(View view){
        FinalBitmap finalBitmap = FinalBitmap.create(this);
        //网络请求图片时默认显示的图片
        finalBitmap.configLoadfailImage(R.mipmap.demo);
        //开始加载图片
        finalBitmap.display(iv_afinal,"http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg");
    }
    //文本请求点击事件处理
    public void btn_afinal_gettext_click(View view){
        FinalHttp finalHttp = new FinalHttp();
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        finalHttp.get(url, new AjaxCallBack<Object>() {
            @Override
            public void onStart() {
                tv_afinal.setText("开始加载");
                super.onStart();
            }

            @Override
            public void onSuccess(Object o) {
                tv_afinal.setText(o.toString());
                super.onSuccess(o);
            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                tv_afinal.setText("加载失败");
                super.onFailure(t, strMsg);
            }
        });
    }
    //文件下载点击事件处理
    public void btn_afinal_filedownload_click(View view){
        {
            FinalHttp finalHttp = new FinalHttp();
           //请求网络资源的地址
            String url = "http://vfx.mtime.cn/Video/2016/10/11/mp4/161011092841270064_480.mp4";
            //存放视频文件到本地位置
            String target = getFilesDir()+"/afinalmusic.mp4";
            String target1 = Environment.getExternalStorageDirectory().getPath() +"/afinalmusic.mp4";
            finalHttp.download(url, target1, new AjaxCallBack<File>() {
                @Override
                public void onStart() {
                    tv_afinal.setText("开始加载");
                    super.onStart();
                }

                @Override
                public void onSuccess(File file) {
                    tv_afinal.setText("下载文件成功");
                    super.onSuccess(file);
                }

                @Override
                public void onFailure(Throwable t, String strMsg) {
                    tv_afinal.setText("下载文件失败");
                    super.onFailure(t, strMsg);
                }
            });
        }

    }
    //文件上传点击事件处理
    public void btn_afinal_fileupload_click(View view){
        FinalHttp finalHttp = new FinalHttp();
        //文件上传到服务器的地址
        String url = "http://192.168.35.1:8080/FileUpload/FileUploadServlet";
        AjaxParams params = new AjaxParams();
        try {
            params.put("File",new File(Environment.getExternalStorageDirectory().getPath() +"/afinalmusic.mp4"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finalHttp.post(url, params, new AjaxCallBack<File>() {
            @Override
            public void onStart() {
                tv_afinal.setText("开始上传");
                super.onStart();
            }

            @Override
            public void onSuccess(File file) {
                tv_afinal.setText("上传文件成功");
                super.onSuccess(file);
            }

            @Override
            public void onFailure(Throwable t, String strMsg) {
                tv_afinal.setText("上传文件失败");
                super.onFailure(t, strMsg);
            }
        });
    }

    }

