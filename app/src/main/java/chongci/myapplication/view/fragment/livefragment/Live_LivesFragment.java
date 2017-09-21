package chongci.myapplication.view.fragment.livefragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.LiveIndexBean;
import chongci.myapplication.Bean.LiveVideoBean;
import chongci.myapplication.R;
import chongci.myapplication.fengzhuang.Fengzhuang;
import chongci.myapplication.view.fragment.livefragment.base.BaseFragment;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static chongci.myapplication.R.id.tv_vediotitle;


/**
 * A simple {@link Fragment} subclass.
 */
public class Live_LivesFragment extends BaseFragment implements View.OnClickListener {

    private TabLayout tab;
    private ViewPager viewPager;
    private List<Fragment> fraglist = new ArrayList<Fragment>();
    private List<String> titlelist = new ArrayList<String>();
    private io.vov.vitamio.widget.VideoView video_view;
    private TextView contenttitle;
    private ImageView clicktile; private ImageView lpanda_live_operate,lpanda_live_img;
    private Button bt_liveeye;
    private Button bt_livechat;
    private TextView tv_vediotitle;
    private FrameLayout fram;
    private Live_EyeFragment live_eyeFragment;
    private Live_ChatFragment live_chatFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction,transactionn;
    int a = 0;
    private JCVideoPlayer jcvplayer;
    private MyReceiver receiver;
    private String liveid;
    private String livetitle;
    private String hls1;
    private String parseurl;
    private String liveimage;


    @Override
    protected void initData() {
        String url="http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json";
        Fengzhuang.getFengzhuang().parseIndexBean(url, new Fengzhuang.GetLiveIndexBean() {
            @Override
            public void show(LiveIndexBean bean) {
                String brief = bean.getLive().get(0).getBrief();
                contenttitle.setText(brief);
            }
        });
        //注册广播
        receiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.socketserverdemo.SocketService");
        getActivity().registerReceiver(receiver, intentFilter);


        clicktile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (a) {
                    case 0:
                        a = 1;
                        contenttitle.setVisibility(View.VISIBLE);
                        clicktile.setImageResource(R.drawable.lpanda_off);
                        break;
                    case 1:
                        a = 0;
                        clicktile.setImageResource(R.drawable.lpanda_show);
                        contenttitle.setVisibility(View.GONE);
                        break;
                }

            }
        });
    }


    @Override
    protected void initView(View view) {
        jcvplayer = (JCVideoPlayer) view.findViewById(R.id.jcvplayer);
        contenttitle = (TextView) view.findViewById(R.id.tv_contenttitle);
        tv_vediotitle = (TextView) view.findViewById(R.id.tv_vediotitle);
        clicktile = (ImageView) view.findViewById(R.id.iv_clicktitle);
        lpanda_live_operate = (ImageView) view.findViewById(R.id.lpanda_live_operate);
        lpanda_live_img = (ImageView) view.findViewById(R.id.lpanda_live_img);
        bt_liveeye = (Button) view.findViewById(R.id.bt_liveeye);
        bt_livechat = (Button) view.findViewById(R.id.bt_livechat);
        fram = (FrameLayout) view.findViewById(R.id.fram);
        String ser="http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=an+zYnLPuLGXZLIAMLXB4hnpW5WGmN8S1M3SYC27aX1JMaSAdXxxZvm0AAUZ5cj/0M1MZZIYhcSCZ0azfxcKsQ==";
        String str="成都地区高清精切线路";
        jcvplayer.setUp(ser,str);
        tv_vediotitle.setText("[正在直播]："+ str);

        // 進入系統默認為哪个界面
        manager = getActivity().getSupportFragmentManager();
        transactionn = manager.beginTransaction();
        live_eyeFragment = new Live_EyeFragment();
        transactionn.add(R.id.fram,live_eyeFragment);
        transactionn.commit();

        bt_liveeye.setOnClickListener(this);
        bt_livechat.setOnClickListener(this);
        lpanda_live_operate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lpanda_live_img.setVisibility(View.GONE);
                lpanda_live_operate.setVisibility(View.GONE);
            }
        });


    }

    @Override
    public void onClick(View v) {
        manager = getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();
        hideAll(transaction);
        switch (v.getId()) {
            case R.id.bt_liveeye:
                if(live_eyeFragment==null){

                    transaction.add(R.id.fram, live_eyeFragment);
                }else{
                    transaction.show(live_eyeFragment);
                }

                break;
            case R.id.bt_livechat:
                if(live_chatFragment==null){
                    live_chatFragment = new Live_ChatFragment();
                    transaction.add(R.id.fram, live_chatFragment);
                }else{
                    transaction.show(live_chatFragment);
                }
                break;
        }
        // transaction.addToBackStack(null);
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if(live_eyeFragment!=null){
            transaction.hide(live_eyeFragment);
        }
        if(live_chatFragment!=null){
            transaction.hide(live_chatFragment);
        }
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_live__live;
    }
    private class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            liveid = bundle.getString("liveid");
            livetitle = bundle.getString("livetitle");
            liveimage = bundle.getString("liveimage");
            tv_vediotitle.setText("[正在直播]："+ livetitle);
            parseurl = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+liveid+"&amp;client=androidapp'";
            Fengzhuang.getFengzhuang().parseVedioBean(parseurl, new Fengzhuang.GetLiveVedioBean() {
                @Override
                public void show(LiveVideoBean bean) {
                    hls1 = bean.getHls_url().getHls1();
                    jcvplayer.setUp(hls1,livetitle);
                    Glide.with(getActivity())
                            .load(liveimage)
                            .into(jcvplayer.ivThumb);
                }
            });

        }
    }
}







