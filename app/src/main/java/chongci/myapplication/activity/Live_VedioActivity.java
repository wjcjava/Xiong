package chongci.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import chongci.myapplication.Bean.LiveVideoBean;
import chongci.myapplication.R;
import chongci.myapplication.fengzhuang.Fengzhuang;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static chongci.myapplication.R.id.jcvplayer;


public class Live_VedioActivity extends AppCompatActivity {


    private JCVideoPlayer videocontroller1;
    private String hlsurl;
    private String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live__vedio);
        initData();
        initView();

    }

    private void initData() {
        hlsurl = getIntent().getStringExtra("hlsurl");
        title = getIntent().getStringExtra("title");

      Log.i("22222222222", hlsurl);
     Log.i("22222222222", title);

    }


    private void initView() {
        String ttt="http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=HVKzjl+2UNuKmfEVvWpcuwkC9uxP1mohwiY8YaWT+wZdZimGkodiDvXO7u7Q7DFZGolS762WrmLaeW4itNk2kA==";
        videocontroller1 = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        //videocontroller1.setUp("http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=7nYJKu92swTI1IkNvTld4YKAZGq9ZXE9zhTvJEFL2+nSJ2pY1+cyBAkIzmOp59gdVFl67ssiNRapK1Nmh/jfyQ==","视频/MP3标题");

        videocontroller1.setUp(hlsurl,title);
    }
}
