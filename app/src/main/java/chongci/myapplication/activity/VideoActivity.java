package chongci.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

import chongci.myapplication.Bean.ScreenBean;
import chongci.myapplication.R;

public class VideoActivity extends AppCompatActivity {

    private VideoView video_bobao;
    private TextView buffer_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
    }

    private void initView() {
        video_bobao = (VideoView) findViewById(R.id.video_bobao);
        buffer_tv = (TextView) findViewById(R.id.buffer_tv);

        ArrayList<ScreenBean.VideoBean.ChaptersBean> video = (ArrayList<ScreenBean.VideoBean.ChaptersBean>) getIntent().getSerializableExtra("video");
        int pos = getIntent().getIntExtra("pos", 1);

        //String url = video.get(pos).getUrl();
        video_bobao.setMediaController(new MediaController(VideoActivity.this));
        video_bobao.setVideoPath("http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4");
        video_bobao.start();
    }
}
