package chongci.myapplication.activity.prosentactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chongci.myapplication.R;


public class GeRenActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout denglu;
    private RelativeLayout lishi;
    private RelativeLayout shoucang;
    private RelativeLayout shezhi;
    private ImageView back;
    private ImageView tu;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);

        initView();

    }


    private void initView() {
        denglu = (LinearLayout) findViewById(R.id.denglu);
        lishi = (RelativeLayout) findViewById(R.id.lishi);
        shoucang = (RelativeLayout) findViewById(R.id.shoucang);
        shezhi = (RelativeLayout) findViewById(R.id.shezhi);
        denglu.setOnClickListener(this);
        lishi.setOnClickListener(this);
        shoucang.setOnClickListener(this);
        shezhi.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);
        tu = (ImageView) findViewById(R.id.tu);
        tu.setOnClickListener(this);
        text = (TextView) findViewById(R.id.text);
        text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                //startActivity(new Intent(GeRenActivity.this, MyActivity.class));
                finish();
                break;
            case R.id.denglu:
                onResume();
                startActivity(new Intent(GeRenActivity.this, DengLuActivity.class));
                break;
            case R.id.lishi:
                startActivity(new Intent(GeRenActivity.this, LiShiActivity.class));
                break;
            case R.id.shoucang:
                startActivity(new Intent(GeRenActivity.this, ShouCangActivity.class));
                break;
            case R.id.shezhi:
                startActivity(new Intent(GeRenActivity.this, SheActivity.class));
                break;
        }
    }

    public void onResume() {
        super.onResume();
        SharedPreferences shar = this.getSharedPreferences("setting", 0);
        String login = shar.getString("login", "");
        if (!TextUtils.isEmpty(login)) {
            tu.setImageResource(R.drawable.tab_panda_live_normal);
            text.setText("小米");
        }
    }
}