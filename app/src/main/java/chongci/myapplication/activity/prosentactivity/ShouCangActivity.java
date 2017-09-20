package chongci.myapplication.activity.prosentactivity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.R;
import chongci.myapplication.view.fragment.Zhibo;
import chongci.myapplication.view.fragment.livefragment.Jiangcaikandian;



public class ShouCangActivity extends AppCompatActivity {
    List<Fragment> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    private Zhibo zhibo;
    private Jiangcaikandian j;
    private TabLayout layout;
    private ImageView fanhui;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_cang);
        initView();
        initDate();
        MyAdper myAdper=new MyAdper(getSupportFragmentManager());
        pager.setAdapter(myAdper);
    }

    private void initDate() {
        zhibo = new Zhibo();
        j = new Jiangcaikandian();
        list.add(zhibo);
        list.add(j);
        list1.add("直播");
        list1.add("精彩看点");
        layout.addTab(layout.newTab().setText(list1.get(0)));
        layout.addTab(layout.newTab().setText(list1.get(1)));
        layout.setupWithViewPager(pager);
    }




    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void initView() {
        fanhui = (ImageView) findViewById(R.id.fanhui);
        pager = (ViewPager) findViewById(R.id.pager);
        layout = (TabLayout) findViewById(R.id.layout);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    private class MyAdper extends FragmentPagerAdapter{

        public MyAdper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list1.get(position);
        }
    }
}
