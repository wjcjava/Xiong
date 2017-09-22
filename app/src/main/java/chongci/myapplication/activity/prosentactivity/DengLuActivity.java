package chongci.myapplication.activity.prosentactivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.Log;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chongci.myapplication.R;

public class DengLuActivity extends AppCompatActivity implements View.OnClickListener {


    private RadioButton qq;
    private ImageView back;
    private TextView name;
    private EditText num;
    private EditText pass;
    private Button dengl;
    private String passString;
    private String numString;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng_lu);
        initView();

    }


    private void initView() {
        qq = (RadioButton) findViewById(R.id.login_QQ);
        qq.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);
        name = (TextView) findViewById(R.id.name);

        num = (EditText) findViewById(R.id.num);
        num.setOnClickListener(this);
        pass = (EditText) findViewById(R.id.pass);
        pass.setOnClickListener(this);
        dengl = (Button) findViewById(R.id.dengl);
        dengl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.login_QQ:
                UMShareAPI.get(DengLuActivity.this).doOauthVerify(DengLuActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.num:
                break;
            case R.id.pass:
                break;
            case R.id.dengl:
                submit();
                SharedPreferences share = getSharedPreferences("setting", 0);


                if (num != null && pass != null) {

                    String phone = num.getText().toString().trim();
                    String password = pass.getText().toString().trim();
                    if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(password)) {


                        SharedPreferences.Editor edit = share.edit();
                        edit.putString("login", "yes");
                        edit.commit();


                        //finish();
                    } else {
                        Toast.makeText(this, "手机号和密码不能为空", Toast.LENGTH_SHORT).show();
                    }
                } else {

                }
                startActivity(new Intent(DengLuActivity.this,GeRenActivity.class));
                break;
        }
    }


    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            Set<String> keySet = data.keySet();
            num.setText(keySet.toString());
            System.out.println("+++++++" + keySet.toString());
            //得到头像
            String iconurl;
            //得到昵称
            String screenname;
            for (String string : keySet) {
                Log.i("TAG", string);
                if (string.equals("screen_name")) {
                    //获取登录的名字
                    screenname = data.get("screen_name");
                    name.setText(screenname);
                }
                if (string.equals("promfile_image_url")) {
                    //获取登录的图片
                    iconurl = data.get("profile_image_url");
                    name.setText(iconurl);
                }
            }


        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }



    private void submit() {
        // validate
        passString = pass.getText().toString().trim();
        if (TextUtils.isEmpty(passString)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        numString = num.getText().toString().trim();
        if (TextUtils.isEmpty(numString)) {
            Toast.makeText(this, "账号：请输入邮箱或手机号", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

