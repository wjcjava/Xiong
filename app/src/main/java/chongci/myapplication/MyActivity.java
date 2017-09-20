package chongci.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import chongci.myapplication.view.fragment.ChinaFragment.LiveChinaFragment;
import chongci.myapplication.view.fragment.GuanchaFragment;
import chongci.myapplication.view.fragment.ShouyeFragment;
import chongci.myapplication.view.fragment.WenhuaFragment;
import chongci.myapplication.view.fragment.ZhiboFragment;


public class MyActivity extends AppCompatActivity implements View.OnClickListener {
    private ShouyeFragment shouyeFragment;
    private GuanchaFragment guanchaFragment;
    private WenhuaFragment wenhuaFragment;
    private ZhiboFragment zhiboFragment;
    private LiveChinaFragment zhongGuoFragment;
    private RadioButton guancha;
    private RadioButton wenhua;
    private RadioButton zhibo;
    private RadioButton zhongguo;
    private RadioButton shouye;
    private static Boolean isExit = false;
    private static Boolean hasTask = false;
    Timer tExit = new Timer();
    TimerTask task = new TimerTask(){

        @Override
        public void run() {
            isExit = true;
            hasTask = true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initView();
        initDate();
        initDenglu();

    }

    private void initDenglu() {
       SharedPreferences share = getSharedPreferences("setting", 0);


        if (TextUtils.isEmpty(share.getString("login", ""))) {
            Toast.makeText(this, "你未登录哦", Toast.LENGTH_SHORT).show();

        }

        else {
            Toast.makeText(this, "欢迎再次进入", Toast.LENGTH_SHORT).show();

        }
    }

    private void initDate() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        shouyeFragment=new ShouyeFragment();
        transaction.add(R.id.fragment,shouyeFragment);
        transaction.commit();
    }
    private void initView() {
        shouye = (RadioButton) findViewById(R.id.shouye);
        guancha = (RadioButton) findViewById(R.id.guancha);
        wenhua = (RadioButton) findViewById(R.id.wenhua);
        zhibo = (RadioButton) findViewById(R.id.zhibo);
        zhongguo = (RadioButton) findViewById(R.id.zhongguo);
        shouye.setOnClickListener(this);
        guancha.setOnClickListener(this);
        wenhua.setOnClickListener(this);
        zhibo.setOnClickListener(this);
        zhongguo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideAll(transaction);
        switch (view.getId()) {
            case R.id.shouye:
                if(shouyeFragment==null){
                    shouyeFragment=new ShouyeFragment();
                    transaction.add(R.id.fragment,shouyeFragment);
                }else {
                    transaction.show(shouyeFragment);
                }
                break;
            case R.id.guancha:
                if(guanchaFragment==null){
                    guanchaFragment=new GuanchaFragment();
                    transaction.add(R.id.fragment,guanchaFragment);
                }else {
                    transaction.show(guanchaFragment);
                }
                break;
            case R.id.wenhua:
                if(wenhuaFragment==null){
                    wenhuaFragment=new WenhuaFragment();
                    transaction.add(R.id.fragment,wenhuaFragment);
                }else {
                    transaction.show(wenhuaFragment);
                }
                break;
            case R.id.zhibo:
                if(zhiboFragment==null){
                    zhiboFragment=new ZhiboFragment();
                    transaction.add(R.id.fragment,zhiboFragment);
                }else {
                    transaction.show(zhiboFragment);
                }
                break;
            case R.id.zhongguo:
                if(zhongGuoFragment==null){
                    zhongGuoFragment=new LiveChinaFragment();
                    transaction.add(R.id.fragment,zhongGuoFragment);
                }else {
                    transaction.show(zhongGuoFragment);
                }
                break;
        }
        transaction.commit();
    }
    private void hideAll(FragmentTransaction transaction) {
        if(shouyeFragment!=null){
            transaction.hide(shouyeFragment);
        }
        if(guanchaFragment!=null){
            transaction.hide(guanchaFragment);
        }
        if(wenhuaFragment!=null){
            transaction.hide(wenhuaFragment);
        }
        if(zhiboFragment!=null){
            transaction.hide(zhiboFragment);
        }
        if(zhongGuoFragment!=null){
            transaction.hide(zhongGuoFragment);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(isExit == false){
                Toast.makeText(MyActivity.this, "再按一次返回键回到桌面", Toast.LENGTH_SHORT).show();
                if(!hasTask){
                    tExit.schedule(task, 2000);
                    SharedPreferences shar = getSharedPreferences("setting", 0);
                    shar.edit().clear().commit();
                }
            }else{
                finish();
                System.exit(0);

                finish();
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {

        SharedPreferences shar = getSharedPreferences("setting", 0);
        shar.edit().clear().commit();
        super.onDestroy();
    }
}

