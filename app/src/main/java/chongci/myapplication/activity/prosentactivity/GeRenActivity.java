package chongci.myapplication.activity.prosentactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chongci.myapplication.R;


public class GeRenActivity extends AppCompatActivity {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.login_image)
    ImageView loginImage;
    @BindView(R.id.login_text)
    TextView loginText;
    @BindView(R.id.login)
    LinearLayout login;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textt)
    TextView textt;
    @BindView(R.id.hostory)
    RelativeLayout hostory;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.textt1)
    TextView textt1;
    @BindView(R.id.shoucang)
    RelativeLayout shoucang;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.textt2)
    TextView textt2;
    @BindView(R.id.set)
    RelativeLayout set;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_text, R.id.textt, R.id.textt1, R.id.textt2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_text:
                break;
            case R.id.textt:
                break;
            case R.id.textt1:
                break;
            case R.id.textt2:
                break;
        }
    }
}