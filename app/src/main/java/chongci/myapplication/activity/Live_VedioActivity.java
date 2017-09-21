package chongci.myapplication.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import chongci.myapplication.Bean.LiveVideoBean;
import chongci.myapplication.R;
import chongci.myapplication.fengzhuang.Fengzhuang;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static chongci.myapplication.R.id.jcvplayer;


public class Live_VedioActivity extends AppCompatActivity implements View.OnClickListener {



    private JCVideoPlayer videocontroller1;
    private String hlsurl;
    private String title;
    private ImageView app_video_collect;
    private ImageView app_video_share;
    private ImageView app_video_menu;
    private String img;
    private String urlvedio;


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
        img = getIntent().getStringExtra("img");
        urlvedio = getIntent().getStringExtra("urlvedio");

        Log.i("22222222222", hlsurl);
        Log.i("22222222222", title);

    }


    private void initView() {
        String ttt = "http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=HVKzjl+2UNuKmfEVvWpcuwkC9uxP1mohwiY8YaWT+wZdZimGkodiDvXO7u7Q7DFZGolS762WrmLaeW4itNk2kA==";
        videocontroller1 = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        videocontroller1.setUp(hlsurl, title);
        Glide.with(this)
                .load(img)
                .into(videocontroller1.ivThumb);

        app_video_collect = (ImageView) findViewById(R.id.app_video_collect);
        app_video_collect.setOnClickListener(this);
        app_video_share = (ImageView) findViewById(R.id.app_video_share);
        app_video_share.setOnClickListener(this);
        app_video_menu = (ImageView) findViewById(R.id.app_video_menu);
        app_video_menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_video_collect:

                break;
            case R.id.app_video_share:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("是否分享视频到QQ?");
                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        UMImage thumb = new UMImage(Live_VedioActivity.this, img);
                        UMWeb web = new UMWeb(urlvedio);
                        web.setThumb(thumb);
                        web.setTitle(title);
                        new ShareAction(Live_VedioActivity.this)
                                .setPlatform(SHARE_MEDIA.QQ)
                                .withMedia(web)
                                .setCallback(umShareListener)
                                .share();
                    }
                });
                builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create();
                builder.show();

                break;
            case R.id.app_video_menu:

                break;
        }
    }



    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            com.umeng.socialize.utils.Log.d("plat", "platform" + platform);

            Toast.makeText(Live_VedioActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(Live_VedioActivity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (t != null) {
                com.umeng.socialize.utils.Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(Live_VedioActivity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

}
