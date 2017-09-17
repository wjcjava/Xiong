package chongci.myapplication.activity.prosentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import chongci.myapplication.R;

public class GeRenActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout denglu;
    private LinearLayout lishi;
    private LinearLayout shoucang;
    private LinearLayout shezhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        initView();
    }

    private void initView() {
        denglu = (LinearLayout) findViewById(R.id.denglu);
        lishi = (LinearLayout) findViewById(R.id.lishi);
        shoucang = (LinearLayout) findViewById(R.id.shoucang);
        shezhi = (LinearLayout) findViewById(R.id.shezhi);
        denglu.setOnClickListener(this);
        lishi.setOnClickListener(this);
        shoucang.setOnClickListener(this);
        shezhi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.denglu:
                startActivity(new Intent(GeRenActivity.this,DengLuActivity.class));
            break;
            case R.id.lishi:
                startActivity(new Intent(GeRenActivity.this,LiShiActivity.class));
            break;
            case R.id.shoucang:
                startActivity(new Intent(GeRenActivity.this,ShouCangActivity.class));
            break;
            case R.id.shezhi:
                startActivity(new Intent(GeRenActivity.this,SheActivity.class));
                break;
        }
    }
}
