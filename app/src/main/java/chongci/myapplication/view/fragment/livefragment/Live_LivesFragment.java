package chongci.myapplication.view.fragment.livefragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.LiveIndexBean;
import chongci.myapplication.R;
import chongci.myapplication.adper.MyExpandableAdapter;
import chongci.myapplication.fengzhuang.Fengzhuang;
import chongci.myapplication.view.fragment.livefragment.base.BaseFragment;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;


/**
 * A simple {@link Fragment} subclass.
 */
public class Live_LivesFragment extends BaseFragment {

    private ExpandableListView expandableListView;
    List<List<String>> childList = new ArrayList<List<String>>();
    List<String> groupList = new ArrayList<String>();
    private MyExpandableAdapter expandableAdapter;
    private TabLayout tab;
    private ViewPager viewPager;
    private List<Fragment> fraglist = new ArrayList<Fragment>();
    private List<String> titlelist = new ArrayList<String>();
    private io.vov.vitamio.widget.VideoView video_view;

/*
    public  void expandlistview(){
        String url="http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json";
        Fengzhuang.getFengzhuang().parseIndexBean(url, new Fengzhuang.GetLiveIndexBean() {
            @Override
            public void show(LiveIndexBean bean) {
                List<String> liststring = new ArrayList<String>();
                String brief = bean.getLive().get(0).getBrief();
                liststring.add(brief);
                groupList.add("简介");
                childList.add(liststring);
                expandableAdapter.notifyDataSetChanged();
            }
        });
        expandableAdapter = new MyExpandableAdapter(getActivity(),childList,groupList);
        expandableListView.setAdapter(expandableAdapter);
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        expandableListView.setIndicatorBounds(width-400, width-370);

    }*/

    public void initVedio(){
  /*    //  video_view.setVideoPath("http://video.jiecao.fm/11/23/xin/%E5%81%87%E4%BA%BA.mp4");
     //   video_view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                video_view.start();
            }
        });
        video_view.setMediaController(new MediaController(getActivity()));*/

    }

    @Override
    protected void initData() {
      // expandlistview();
        initVedio();
    }

    @Override
    protected void initView(View view) {

      //  video_view = (io.vov.vitamio.widget.VideoView) view.findViewById(R.id.vitamio_viedoviews);
        expandableListView = (ExpandableListView) view.findViewById(R.id.el_listview);
        String url="http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json";
        Fengzhuang.getFengzhuang().parseIndexBean(url, new Fengzhuang.GetLiveIndexBean() {
            @Override
            public void show(LiveIndexBean bean) {
                List<String> liststring = new ArrayList<String>();
                String brief = bean.getLive().get(0).getBrief();
                liststring.add(brief);
                groupList.add("简介");
                childList.add(liststring);
                expandableAdapter.notifyDataSetChanged();
            }
        });
        expandableAdapter = new MyExpandableAdapter(getActivity(),childList,groupList);
        expandableListView.setAdapter(expandableAdapter);
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        expandableListView.setIndicatorBounds(width-400, width-370);



        tab = (TabLayout) view.findViewById(R.id.tab);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        initTitle();
        tab.addTab(tab.newTab().setText(titlelist.get(0)));
        tab.addTab(tab.newTab().setText(titlelist.get(1)));
        initFranment();
        MyAdapter adapter = new MyAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        viewPager.requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        viewPager.requestDisallowInterceptTouchEvent(false);
                    default:
                        break;
                }
                return true;
            }
        });
    }
    private void initTitle() {
        titlelist.add("多视角直播");
        titlelist.add("边看边聊");
    }

    private void initFranment() {
        fraglist.add(new Live_EyeFragment());
        fraglist.add(new Live_ChatFragment());
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
        public CharSequence getPageTitle(int position) {
            return titlelist.get(position);
        }
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_live__live;
    }
}
