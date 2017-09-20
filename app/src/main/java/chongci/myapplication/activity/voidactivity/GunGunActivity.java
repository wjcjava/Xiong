package chongci.myapplication.activity.voidactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.Bean.BeanThree;
import chongci.myapplication.Bean.BeanTwo;
import chongci.myapplication.Bean.GunGunBean;
import chongci.myapplication.Bean.WenhuaBean;
import chongci.myapplication.R;
import chongci.myapplication.p.PresenterImpl;
import chongci.myapplication.view.IView;


public class GunGunActivity extends AppCompatActivity implements IView {
    private List<GunGunBean.VideoBean.ChaptersBean> list = new ArrayList<>();
    private VideoView video;
    private String url = "http://115.182.35.91/api/getVideoInfoForCBox.do?pid=";
    private String shipin;
    private String mp4String;
    private PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gun);
        shipin = getIntent().getStringExtra("void");
        presenter = new PresenterImpl(this);
        presenter.BeanGunGun(url + shipin);
        initView();

    }

    private void initDate() {

    }

    private void initView() {


    }

    @Override
    public void OnSuccess(WenhuaBean bean) {

    }

    @Override
    public void OnSuccess(Bean bean) {

    }

    @Override
    public void OnSuccess(BeanOne beanOne) {

    }

    @Override
    public void OnSuccecc(BeanTwo beanTwo) {

    }

    @Override
    public void OnSuccecc(BeanThree beanThree) {

    }

    @Override
    public void OnSuccess(GunGunBean gunBean) {
        list.addAll(gunBean.getVideo().getChapters());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mp4String = list.get(0).getUrl();
                video = (VideoView) findViewById(R.id.video);
                video.setMediaController(new MediaController(GunGunActivity.this));
                video.setVideoPath(mp4String);
                video.start();
            }
        });
    }

}
