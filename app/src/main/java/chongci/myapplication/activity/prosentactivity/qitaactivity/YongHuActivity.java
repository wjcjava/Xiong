package chongci.myapplication.activity.prosentactivity.qitaactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.R;
import chongci.myapplication.activity.prosentactivity.fankunfragment.Wenti1Fragment;
import chongci.myapplication.activity.prosentactivity.fankunfragment.Wenti2Fragment;

public class YongHuActivity extends AppCompatActivity {

    private ImageView fanhui;
    private TabLayout layout;
    private ViewPager pager;
    List<Fragment> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    private Wenti1Fragment zhibo;
    private Wenti2Fragment j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yong_hu);
        initView();
        initDate();
    }

    private void initDate() {
        zhibo = new Wenti1Fragment();
        j = new Wenti2Fragment();
        list.add(zhibo);
        list.add(j);
        list1.add("直播");
        list1.add("精彩看点");
        MyAdper myAdper=new MyAdper(getSupportFragmentManager());
        pager.setAdapter(myAdper);
        layout.addTab(layout.newTab().setText(list1.get(0)));
        layout.addTab(layout.newTab().setText(list1.get(1)));
        layout.setupWithViewPager(pager);
    }

    private void initView() {
        fanhui = (ImageView) findViewById(R.id.fanhui);
        layout = (TabLayout) findViewById(R.id.layout);
        pager = (ViewPager) findViewById(R.id.pager);
    }

    private class MyAdper extends FragmentPagerAdapter {

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
