package chongci.myapplication.activity.prosentactivity.qitaactivity;

import android.os.Bundle;
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

public class FanKunActivity extends AppCompatActivity {

    private ImageView back;
    private TabLayout tablayout;
    private ViewPager pager;
    private List<Fragment> list=new ArrayList<>();
    private List<String> list1=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_kun);
        initView();
        initDate();
        MyAdper myAdper=new MyAdper(getSupportFragmentManager());
        pager.setAdapter(myAdper);
    }

    private void initDate() {

        list1.add("遇到的问题");
        list1.add("常见的问题");
        tablayout.addTab(tablayout.newTab().setText(list1.get(0)));
        tablayout.addTab(tablayout.newTab().setText(list1.get(1)));
        tablayout.setupWithViewPager(pager);
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        pager = (ViewPager) findViewById(R.id.pager);
        back.setOnClickListener(new View.OnClickListener() {
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
