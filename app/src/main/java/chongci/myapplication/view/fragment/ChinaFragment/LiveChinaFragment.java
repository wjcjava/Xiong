package chongci.myapplication.view.fragment.ChinaFragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.R;


/**
 * Created by a on 2017/9/13.
 */

public class LiveChinaFragment extends BaseFragment {
    Message message;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what==1){
                adapter = new FindtabAdapter(getChildFragmentManager(),fragmentList,mTi);


                vp_live.setAdapter(adapter);

                tab_live.setupWithViewPager(vp_live);
            }




        }
    };
    FindtabAdapter adapter;
    private HorizontalScrollView scrollView;
    ImageView imageView_live;
    RelativeLayout liveChinaItemNotNet;
    FrameLayout fmLivechina;
    TabLayout tab_live;
    ViewPager vp_live;
ChangeBeanDao changeBeanDao;
List<String>mTitleList=new ArrayList<>();
    List<String>sTitleList=new ArrayList<>();
    List<String> urls=new ArrayList<>();
    private List<TestFm> fragmentList = new ArrayList<TestFm>();
    private List<ChangeBean> users;
    private List<ChangeBean> userss;
    List<String>   mTi=new ArrayList<>();

    @Override
    protected void initData() {

            for(int i=0;i<users.size();i++){
            Log.e("aaaaaaaaa++++++",users.size()+"dfghjkkl"+"---------"+users.get(i).getType()+000+users.get(i).getUrl()+77777+users.get(i).getTitle());
            mTi.add(users.get(i).getTitle());
            TestFm testFm=new TestFm().newInstance(users.get(i).getUrl(),i);
            fragmentList.add(testFm);
        }






        tab_live.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式，当前为系统默认模式
        tab_live.addTab(tab_live.newTab().setText(sTitleList.get(0)));//添加tab选项卡
        tab_live.addTab(tab_live.newTab().setText(sTitleList.get(1)));
        tab_live.addTab(tab_live.newTab().setText(sTitleList.get(2)));
        tab_live.addTab(tab_live.newTab().setText(sTitleList.get(3)));




        adapter = new FindtabAdapter(getChildFragmentManager(),fragmentList,mTi);


        vp_live.setAdapter(adapter);

        tab_live.setupWithViewPager(vp_live);



    }






    @Override
    protected void initView(View view) {

        sTitleList.add("八达岭");
        sTitleList.add("泰山");
        sTitleList.add("黄山");
        sTitleList.add("凤凰古城");
        sTitleList.add("峨眉山");
//        sTitleList.add("张家界");
//        sTitleList.add("黔县");
//        sTitleList.add("中央电视台");
//        sTitleList.add("恒山悬空寺");
        sTitleList.add("黄果树");
        sTitleList.add("黄龙");
//        sTitleList.add("婺源");
        sTitleList.add("武夷山");
//        sTitleList.add("龙虎山");
//       sTitleList.add("松陵少林寺");
        sTitleList.add("承德避暑山庄");
        sTitleList.add("敦煌月牙泉");
        sTitleList.add("都江堰");
        sTitleList.add("山海关");
//       sTitleList.add("水长城");
//        sTitleList.add("嘉峪关");
//        sTitleList.add("天山");
//        sTitleList.add("乌镇");
//        sTitleList.add("青海湖鸟岛");
//       sTitleList.add("金丝猴");
//        sTitleList.add("朱鹮");
//        sTitleList.add("丹霞山");
//        sTitleList.add("天涯海角");
//        sTitleList.add("雪乡");
        sTitleList.add("乐山大佛");
        sTitleList.add("哈尼梯田");
        urls.add("badaling");
        urls.add("taishan");
        urls.add("huangshan");
        urls.add("fenghuanggucheng");

        urls.add("emeishan");
//        urls.add("zhangjiajie");
//        urls.add("qianxian");
//        urls.add("zhongyangdianshitai");
//        urls.add("hengshanxuankongsi");
        urls.add("huangguoshu");
        urls.add("huanglong");
//        urls.add("wuyuan");

      urls.add("wuyishan");
                   
//        urls.add("songlingshaolingsi");
        urls.add("chengdebishushanzhuang");
        urls.add("dunhuangyueyaquan");
        urls.add("dujiangyan");
        urls.add("shanhaiguan");
//        urls.add("shuichangcheng");


//        urls.add("jiayuguan");
//        urls.add("tianshan");
//        urls.add("wuzhen");
//        urls.add("qinhaihuniaodao");
//        urls.add("jinsihou");
//        urls.add("zhuhuan");
//        urls.add("danxiashan");
//        urls.add("tianyahaijiao");

//        urls.add("xuexiang");
        urls.add("leshandafo");
        urls.add("hanititian");





        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getActivity(), "tvxq7.db", null);
                 DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
                 DaoSession daoSession = daoMaster.newSession();
                 changeBeanDao = daoSession.getChangeBeanDao();
        users = changeBeanDao.queryBuilder()
                .where(ChangeBeanDao.Properties.Type.eq("1")).limit(100)
                .build().list();

        for (ChangeBean user : users) {
            Log.e("-----fffffffffffff", "query: " + user.toString());
        }

        userss = changeBeanDao.queryBuilder()
                .where(ChangeBeanDao.Properties.Type.eq("")).limit(100)
                .build().list();
        for (ChangeBean user : userss) {
            Log.e("ooooooooooo--------", "query: " + user.toString());
        }


                               if(users.size()==0) {
                                   for (int i = 0; i < 4; i++) {
                                       ChangeBean user = new ChangeBean(null, sTitleList.get(i), urls.get(i), "1", "");
                                       changeBeanDao.insert(user);
                                   }

                                   for (int d = 4; d < sTitleList.size(); d++) {
                                       ChangeBean userr = new ChangeBean(null, sTitleList.get(d), urls.get(d), "", "");
                                       changeBeanDao.insert(userr);
                                       Log.e("ooooooooooo--------", "lllllllllll" + userr.toString());
                                   }


                                   users = changeBeanDao.queryBuilder()
                                           .where(ChangeBeanDao.Properties.Type.eq("1")).limit(100)
                                           .build().list();
                                   for (ChangeBean user : users) {
                                       Log.e("aaaaaaaaaaaddd--------", "query: " + user.toString());
                                   }




                               }
//                               }else{
//                                   users = changeBeanDao.queryBuilder()
//                                           .where(ChangeBeanDao.Properties.Type.eq("1")).limit(100)
//                                           .build().list();
//                                   for (ChangeBean user : users) {
//                                       Log.e("------------", "query: " + user.toString());
//                                   }
//                               }










        scrollView = (HorizontalScrollView)view.findViewById(R.id.scrollView);
        fmLivechina= (FrameLayout) view.findViewById(R.id.fm_livechina);
        liveChinaItemNotNet= (RelativeLayout) view.findViewById(R.id.live_china_item_not_net);


        if(isNetworkAvailable(getActivity())==true){
            liveChinaItemNotNet.setVisibility(View.GONE);
            View view1=LayoutInflater.from(getActivity()).inflate(R.layout.liveitem_layout,null);
             imageView_live= (ImageView) view1.findViewById(R.id.imageView_live);
              imageView_live.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent=new Intent(getActivity(),LiveSwichActivity.class);
                      startActivity(intent);
                  }
              });



             tab_live= (TabLayout) view1.findViewById(R.id.tab_live);
            vp_live= (ViewPager) view1.findViewById(R.id.vp_live);
            fmLivechina.addView(view1);
        }else{
            liveChinaItemNotNet.setVisibility(View.VISIBLE);}

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.livechina_layout;

    }



    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected())
            {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED)
                {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public void onResume() {
        super.onResume();
        message= new Message();
        message.what = 1;
        handler.sendMessage(message);
        users.clear();
        userss.clear();
        mTi.clear();
        fragmentList.clear();

        users = changeBeanDao.queryBuilder()
                .where(ChangeBeanDao.Properties.Type.eq("1")).limit(100)
                .build().list();

        for (ChangeBean user : users) {
            Log.e("ppppppppppp", "query: " + user.toString());
        }

        userss = changeBeanDao.queryBuilder()
                .where(ChangeBeanDao.Properties.Type.eq("")).limit(100)
                .build().list();
        for (ChangeBean user : userss) {
            Log.e("pppppppppppppp", "query: " + user.toString());
        }

        for(int i=0;i<users.size();i++){
            Log.e("aaaaaaaaa++++++",users.size()+"dfghjkkl"+"---------"+users.get(i).getType()+000+users.get(i).getUrl()+77777+users.get(i).getTitle());
            mTi.add(users.get(i).getTitle());
            TestFm testFm=new TestFm().newInstance(users.get(i).getUrl(),i);
            fragmentList.add(testFm);
        }

    }
}
