package chongci.myapplication.activity.prosentactivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.android.percent.support.PercentRelativeLayout;

import chongci.myapplication.R;
import chongci.myapplication.activity.prosentactivity.qitaactivity.FanKunActivity;

public class SheActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView set_back;
    private TextView laji;
    private ImageView qingchuhuancun;
    private PercentRelativeLayout fankui;
    private PercentRelativeLayout ruanjian;
    private PercentRelativeLayout haoping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she);
        initView();
    }


    private void initView() {
        set_back = (ImageView) findViewById(R.id.set_back);
        laji = (TextView) findViewById(R.id.laji);
        qingchuhuancun = (ImageView) findViewById(R.id.qingchuhuancun);
        fankui = (PercentRelativeLayout) findViewById(R.id.fankui);
        ruanjian = (PercentRelativeLayout) findViewById(R.id.ruanjian);
        haoping = (PercentRelativeLayout) findViewById(R.id.haoping);
        set_back.setOnClickListener(this);
        qingchuhuancun.setOnClickListener(this);
        ruanjian.setOnClickListener(this);
        haoping.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set_back:
                finish();
                break;
            case R.id.qingchuhuancun:
                AlertDialog.Builder builder = new AlertDialog.Builder(SheActivity.this);
                builder.setTitle("是否缓存数据？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        laji.setText("0.0"+"MB");
                    }
                });
                builder.setNegativeButton("取消", null)
                        .show()
                ;
                break;
            case R.id.fankui:
                startActivity(new Intent(SheActivity.this, FanKunActivity.class));
                break;
            case R.id.ruanjian:
                Toast.makeText(this, "已经是最新版本了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.haoping:
                break;
        }
    }
}
