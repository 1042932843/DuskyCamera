package com.dusky.duskycamera;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lib.camera2.Camera2Config;


public class Camera2RecordFinishActivity extends AppCompatActivity {
    private String picPath;//图片地址
    private String videoPath;//视频地址

    private ImageView iv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏模式
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_record_detail);

        iv = findViewById(R.id.iv);
        tv = findViewById(R.id.tv);

        if (getIntent() != null) {
            //获取传递过来的图片地址
            picPath = getIntent().getStringExtra(Camera2Config.INTENT_PATH_SAVE_PIC);
            if (TextUtils.isEmpty(picPath)) {
                iv.setVisibility(View.GONE);
            } else {
                iv.setImageBitmap(BitmapFactory.decodeFile(picPath));
            }

            //获取传递过来的视频地址
            videoPath = getIntent().getStringExtra(Camera2Config.INTENT_PATH_SAVE_VIDEO);
            if (TextUtils.isEmpty(videoPath)) {
                iv.setVisibility(View.VISIBLE);
                tv.setText("类型：图片-存放地址:" + picPath);
            } else {
                iv.setVisibility(View.GONE);
                tv.setText("类型：视频-存放地址:" + videoPath);
            }
        }
    }
}
