package chongci.myapplication.activity.voidactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.R;
import chongci.myapplication.p.presenter1.MypresenterImpl;
import chongci.myapplication.view.VoidView;
import chongci.myapplication.voidbean.JingCaiBean;
import chongci.myapplication.voidbean.PanPanBean;

public class ZhiboActivity extends AppCompatActivity implements VoidView, View.OnClickListener {
    private VideoView vido3;
    private LinearLayout activity_zhibo;
    private String url = "http://115.182.35.91/api/getVideoInfoForCBox.do?pid=";
    private List<JingCaiBean.VideoBean.ChaptersBean> list = new ArrayList<>();
    private String shipin;
    private MypresenterImpl mypresenter;
    private String mp4String;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhibo);
        shipin = getIntent().getStringExtra("shipin");
        mypresenter = new MypresenterImpl(this);
        mypresenter.qingqiu1(url + shipin);
        initView();
    }

    private void initView() {

        activity_zhibo = (LinearLayout) findViewById(R.id.activity_zhibo);
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(this);
    }

    @Override
    public void chenggong1(PanPanBean panBean) {

    }

    @Override
    public void chenggong3(JingCaiBean jingCaiBean) {
        list.addAll(jingCaiBean.getVideo().getChapters());
        mp4String = list.get(0).getUrl();
        Toast.makeText(ZhiboActivity.this, mp4String, Toast.LENGTH_SHORT).show();
        vido3 = (VideoView) findViewById(R.id.vido3);
        vido3.setMediaController(new MediaController(ZhiboActivity.this));
        vido3.setVideoPath(mp4String);
        vido3.start();


    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:

                break;
        }
    }
}