package chongci.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

import chongci.myapplication.Bean.ScreenBean;
import chongci.myapplication.R;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

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
        JCVideoPlayer videoPlayer = (JCVideoPlayer) findViewById(R.id.video_jc);

        ArrayList<ScreenBean> list = new ArrayList<>();
        ArrayList<ScreenBean.VideoBean.ChaptersBean> video = (ArrayList<ScreenBean.VideoBean.ChaptersBean>) getIntent().getSerializableExtra("video");
        int pos = getIntent().getIntExtra("pos", 1);

        videoPlayer.setUp("http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4","熊猫频道");
    }
}
