package com.example.yinrong.androidframework.xUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yinrong.androidframework.R;

import org.xutils.common.Callback;
import org.xutils.common.task.PriorityExecutor;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;


@ContentView(R.layout.activity_x_utils3_net)
public class xUtils3NetActivity extends Activity {
    @ViewInject(R.id.tv_result)
    private TextView textview;
    @ViewInject(R.id.progressBar)
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_x_utils3_net);
        x.view().inject(this);
    }

    @Event(value = {R.id.btn_get_post, R.id.btn_downloadfile, R.id.btn_uploadfile })
    private  void getEvent(View view){
        switch (view.getId()){
            case R.id.btn_get_post:
                getAndPostNet();
                break;
            case R.id.btn_downloadfile:
                downloadFile();
                break;
            case R.id.btn_uploadfile:
                uploadFile();
                break;
        }
    }

    /**
     * 文件上传
     */
    private void uploadFile() {
        RequestParams params = new RequestParams("http://192.168.35.1:8080/FileUpload/FileUploadServlet");
        //以表单方式上传
        params.setMultipart(true);
        //设置上传文件的路径
        params.addBodyParameter("File",new File(Environment.getExternalStorageDirectory() +"/aigirl/480.mp4"),null ,"500.mp4");

        x.http().post(params, new Callback.ProgressCallback<File>() {
            @Override
            public void onSuccess(File result) {
                //当下载成功的时候会回调这个方法   并且把下载到哪个路径回传回来
                Log.e("TAG","onSuccess"+result.toString());
                Toast.makeText(xUtils3NetActivity.this,"onSuccess"+result.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG","onError"+ex.getMessage() );

            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG","onCancelled" );

            }

            @Override
            public void onFinished() {
                Log.e("TAG","onFinished" );

            }

            @Override
            public void onWaiting() {
                Log.e("TAG","onWaiting" );

            }

            @Override
            public void onStarted() {
                Log.e("TAG","onStarted" );

            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                progressBar.setMax((int)total);
                progressBar.setProgress((int)current);
                Log.e("TAG","onLoading=="+current/total+",isdownloading=="+isDownloading );

            }
        });
    }

    private void downloadFile() {
        RequestParams params = new RequestParams("http://vfx.mtime.cn/Video/2016/11/28/mp4/161128092413441663_480.mp4");
        //设置保存路径
        params.setSaveFilePath(Environment.getExternalStorageDirectory() +"/aigirl/480.mp4");
        //设置是否可以立即取消下载
        params.setCancelFast(true);
        //设置是否自动根据头信息命名
        params.setAutoRename(false);
        //自定义线程池，有效的值范围[1,3],设置为3时，可能阻塞图片加载
        params.setExecutor(new PriorityExecutor(3,true));
        params.setAutoResume(true);
         x.http().get(params, new Callback.ProgressCallback<File>() {
             @Override
             public void onSuccess(File result) {
                //当下载成功的时候会回调这个方法   并且把下载到哪个路径回传回来
                 Log.e("TAG","onSuccess"+result.toString());
                 Toast.makeText(xUtils3NetActivity.this,"onSuccess"+result.toString(),Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onError(Throwable ex, boolean isOnCallback) {
                 Log.e("TAG","onError"+ex.getMessage() );

             }

             @Override
             public void onCancelled(CancelledException cex) {
                 Log.e("TAG","onCancelled" );

             }

             @Override
             public void onFinished() {
                 Log.e("TAG","onFinished" );

             }

             @Override
             public void onWaiting() {
                 Log.e("TAG","onWaiting" );

             }

             @Override
             public void onStarted() {
                 Log.e("TAG","onStarted" );

             }

             @Override
             public void onLoading(long total, long current, boolean isDownloading) {
                progressBar.setMax((int)total);
                 progressBar.setProgress((int)current);
                 Log.e("TAG","onLoading=="+current/total+",isdownloading=="+isDownloading );

             }
         });
    }

    // http://api.m.mtime.cn/PageSubArea/TrailerList.api
    // http://vfx.mtime.cn/Video/2016/11/28/mp4/161128092413441663_480.mp4
    private void getAndPostNet() {
        RequestParams params = new RequestParams("http://api.m.mtime.cn/PageSubArea/TrailerList.api");
        //1.get请求
        //    x.http().get(params, new Callback.CommonCallback<String>() {
        //2.post
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String  result) {
                Log.e("TAG","onSuccess");
                textview.setText(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG","onError");
                textview.setText(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG","onCancelled");

            }

            @Override
            public void onFinished() {
                Log.e("TAG","onFinished");

            }
        });
    }
}
