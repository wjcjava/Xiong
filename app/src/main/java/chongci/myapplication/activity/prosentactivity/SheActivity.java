package chongci.myapplication.activity.prosentactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.android.percent.support.PercentRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chongci.myapplication.R;

public class SheActivity extends AppCompatActivity {
    @BindView(R.id.set_back)
    ImageView setBack;
    @BindView(R.id.accept_box)
    CheckBox acceptBox;
    @BindView(R.id.automatic_box)
    CheckBox automaticBox;
    @BindView(R.id.laji)
    TextView laji;
    @BindView(R.id.clear)
    PercentRelativeLayout clear;
    @BindView(R.id.user_tickling)
    PercentRelativeLayout userTickling;
    @BindView(R.id.upgrade)
    PercentRelativeLayout upgrade;
    @BindView(R.id.goodreputation)
    PercentRelativeLayout goodreputation;
    @BindView(R.id.about_pandachannel)
    PercentRelativeLayout aboutPandachannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.user_tickling, R.id.upgrade, R.id.goodreputation, R.id.about_pandachannel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_tickling:// 用户反馈
                break;
            case R.id.upgrade: //检测升级
                break;
            case R.id.goodreputation: //好评
                break;
            case R.id.about_pandachannel: //关于熊猫
                break;
        }
    }
}
