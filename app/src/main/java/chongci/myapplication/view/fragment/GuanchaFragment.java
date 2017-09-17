package chongci.myapplication.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.R;
import chongci.myapplication.view.fragment.livefragment.Live_AsBearFragment;
import chongci.myapplication.view.fragment.livefragment.Live_LivesFragment;
import chongci.myapplication.view.fragment.livefragment.Live_MengFragment;
import chongci.myapplication.view.fragment.livefragment.Live_OriginalFragment;
import chongci.myapplication.view.fragment.livefragment.Live_RecardFragment;
import chongci.myapplication.view.fragment.livefragment.Live_SpecialFragment;
import chongci.myapplication.view.fragment.livefragment.Live_ThingFragment;
import chongci.myapplication.view.fragment.livefragment.Live_TopFragment;
import chongci.myapplication.view.fragment.livefragment.Live_WondFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuanchaFragment extends Fragment {

    private TabLayout tab;
    private ViewPager viewpage;
    private List<Fragment> fraglist = new ArrayList<Fragment>();
    private List<String> titlelist = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = View.inflate(getActivity(), R.layout.fragment_guancha, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab = (TabLayout) view.findViewById(R.id.tb_tabfirst);
        viewpage = (ViewPager) view.findViewById(R.id.vp_viewpager);

        initTitle();
        tab.addTab(tab.newTab().setText(titlelist.get(0)));
        tab.addTab(tab.newTab().setText(titlelist.get(1)));
        initFranment();
        MyAdapter adapter = new MyAdapter(getActivity().getSupportFragmentManager());
        viewpage.setAdapter(adapter);
        tab.setupWithViewPager(viewpage);

        viewpage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        viewpage.requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        viewpage.requestDisallowInterceptTouchEvent(false);
                    default:
                        break;
                }
                return true;
            }
        });


    }

    private void initTitle() {
        titlelist.add("直播");
        titlelist.add("精彩一刻");
        titlelist.add("当熊不让");
        titlelist.add("超萌滚滚秀");
        titlelist.add("熊猫档案");
        titlelist.add("熊猫TOP榜");
        titlelist.add("熊猫那些事儿");
        titlelist.add("特别节目");
        titlelist.add("原创新闻");

    }

    private void initFranment() {
        fraglist.add(new Live_LivesFragment());
        fraglist.add(new Live_WondFragment());
        fraglist.add(new Live_AsBearFragment());
        fraglist.add(new Live_MengFragment());
        fraglist.add(new Live_RecardFragment());
        fraglist.add(new Live_TopFragment());
        fraglist.add(new Live_ThingFragment());
        fraglist.add(new Live_SpecialFragment());
        fraglist.add(new Live_OriginalFragment());

    }

    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return fraglist.get(position);
        }

        @Override
        public int getCount() {

            return fraglist.size();
        }

        @Override
        //
        public CharSequence getPageTitle(int position) {
            return titlelist.get(position);
        }
    }

}



