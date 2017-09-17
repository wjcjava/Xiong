package chongci.myapplication.activity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

import chongci.myapplication.Bean.ScreenBean;
import chongci.myapplication.R;
import chongci.myapplication.activity.voidactivity.ZhiboActivity;
import io.vov.vitamio.Vitamio;

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

        String url = video.get(pos).getUrl();
        video_bobao.setMediaController(new MediaController(VideoActivity.this));
        video_bobao.setVideoPath(url);
        video_bobao.start();
    }
}
