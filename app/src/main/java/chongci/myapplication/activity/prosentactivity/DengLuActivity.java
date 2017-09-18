package chongci.myapplication.activity.prosentactivity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zhy.android.percent.support.PercentLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chongci.myapplication.R;

public class DengLuActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login_weixin)
    RadioButton loginWeixin;
    @BindView(R.id.login_QQ)
    RadioButton loginQQ;
    @BindView(R.id.login_weibo)
    RadioButton loginWeibo;
    @BindView(R.id.num)
    EditText num;
    @BindView(R.id.num_x)
    ImageView numX;
    @BindView(R.id.tishi_email)
    TextView tishiEmail;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.pass_x)
    ImageView passX;
    @BindView(R.id.tishi_pass)
    TextView tishiPass;
    @BindView(R.id.forget_pass)
    TextView forgetPass;
    @BindView(R.id.dengl)
    Button dengl;
    @BindView(R.id.aaaa)
    PercentLinearLayout aaaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng_lu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.register, R.id.login_weixin, R.id.login_QQ, R.id.login_weibo, R.id.forget_pass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register:  //注册
                break;
            case R.id.login_weixin:
                break;
            case R.id.login_QQ:
                break;
            case R.id.login_weibo:
                break;
            case R.id.forget_pass:  //忘记密码
                break;
        }
    }
}
