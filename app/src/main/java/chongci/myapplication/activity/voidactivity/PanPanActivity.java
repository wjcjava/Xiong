package chongci.myapplication.activity.voidactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.R;
import chongci.myapplication.p.presenter1.MypresenterImpl;
import chongci.myapplication.view.VoidView;
import chongci.myapplication.voidbean.JingCaiBean;
import chongci.myapplication.voidbean.PanPanBean;

public class PanPanActivity extends AppCompatActivity implements VoidView {
    private String url = "http://115.182.35.91/api/getVideoInfoForCBox.do?pid=";
    List<PanPanBean.VideoBean.ChaptersBean> list = new ArrayList<>();
    private String shipin;
    private TextView text;
    private RelativeLayout activity_pan_pan;
    private MypresenterImpl mypresenter;
    private VideoView vitamio_viedoview;
    private VideoView videoView;
    private String mp4String;
    private VideoView vido;
    private TextView quanpin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan_pan);
        initView();


        shipin = getIntent().getStringExtra("shipin");
        mypresenter = new MypresenterImpl(this);
        mypresenter.qingqiu(url + shipin);


    }


    @Override
    public void chenggong1(PanPanBean panBean) {
        list.addAll(panBean.getVideo().getChapters());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mp4String = list.get(0).getUrl();
                Toast.makeText(PanPanActivity.this, mp4String, Toast.LENGTH_SHORT).show();
                vido = (VideoView) findViewById(R.id.vido);
                vido.setMediaController(new MediaController(PanPanActivity.this));
                vido.setVideoPath(mp4String);
                vido.start();
            }
        });


    }

    @Override
    public void chenggong3(JingCaiBean jingCaiBean) {

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        vido.stopPlayback();//将MediaPlayer释放
    }


    private void initView() {

    }



}
