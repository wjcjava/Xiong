package chongci.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import chongci.myapplication.Bean.LiveVideoBean;
import chongci.myapplication.R;
import chongci.myapplication.fengzhuang.Fengzhuang;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class Live_VedioActivity extends AppCompatActivity {


    private JCVideoPlayer videocontroller1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live__vedio);
        initView();
    }

  /*  @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
*/


    private void initView() {
        videocontroller1 = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        videocontroller1.setUp("http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=HVKzjl+2UNuKmfEVvWpcuwkC9uxP1mohwiY8YaWT+wZdZimGkodiDvXO7u7Q7DFZGolS762WrmLaeW4itNk2kA==","dsfj");
        //videocontroller1.setUp("http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=HVKzjl+2UNuKmfEVvWpcuwkC9uxP1mohwiY8YaWT+wZdZimGkodiDvXO7u7Q7DFZGolS762WrmLaeW4itNk2kA==","758783498");
       // videocontroller1.ivThumb.setThumbInCustomProject("视频/MP3缩略图地址");
    }
}
