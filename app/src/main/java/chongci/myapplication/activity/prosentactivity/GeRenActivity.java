package chongci.myapplication.activity.prosentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import chongci.myapplication.R;


public class GeRenActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout denglu;
    private RelativeLayout lishi;
    private RelativeLayout shoucang;
    private RelativeLayout shezhi;
    private ImageView back;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.denglu:
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
}