package chongci.myapplication.view.fragment.ChinaFragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import chongci.myapplication.R;
import chongci.myapplication.activity.prosentactivity.DengLuActivity;
import chongci.myapplication.activity.prosentactivity.GeRenActivity;
import chongci.myapplication.dao.ChangeBeanDao;
import chongci.myapplication.dao.DaoMaster;
import chongci.myapplication.dao.DaoSession;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by a on 2017/9/13.
 */

public class LiveChinaFragment extends BaseFragment {
    Message message,messagee;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                adapter = new FindtabAdapter(getChildFragmentManager(),fragmentList,mTi);

                vp_live.setAdapter(adapter);
                tab_live.setupWithViewPager(vp_live);
            }else if(msg.what==2){

                users.clear();
                userss.clear();
                mTi.clear();
                fragmentList.clear();

                users = changeBeanDao.queryBuilder()
                        .where(ChangeBeanDao.Properties.Type.eq("1")).limit(100)
                        .build().list();

                userss = changeBeanDao.queryBuilder()
                        .where(ChangeBeanDao.Properties.Type.eq("")).limit(100)
                        .build().list();

                for (int i = 0; i < users.size(); i++) {
                    mTi.add(users.get(i).getTitle());
                    TestFm testFm = new TestFm().newInstance(users.get(i).getUrl(), i);
                    fragmentList.add(testFm);
                }
                tab_live.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式，当前为系统默认模式
                adapter = new FindtabAdapter(getChildFragmentManager(), fragmentList, mTi);
                vp_live.setAdapter(adapter);
                tab_live.setupWithViewPager(vp_live);
            }
        }
    };
    FindtabAdapter adapter;
    ImageView imageView_live;
    RelativeLayout liveChinaItemNotNet;
    FrameLayout fmLivechina;
    TabLayout tab_live;
    NoScrollViewPager vp_live;
    ChangeBeanDao changeBeanDao;
    private List<TestFm> fragmentList = new ArrayList<TestFm>();
    private List<ChangeBean> users;
    private List<ChangeBean> userss;
    List<AddressBean.TablistBean> list=new ArrayList<>();
    List<AddressBean.AlllistBean> list1=new ArrayList<>();

    List<String>   mTi=new ArrayList<>();
    private TextView tv_chinatype;

    @Override
    protected void initData() {
    }

    @Override
    protected void initView(View view) {
        tv_chinatype = (TextView) view.findViewById(R.id.tv_chinatype);
        tv_chinatype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GeRenActivity.class);
                startActivity(intent);
            }
        });
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
            vp_live= (NoScrollViewPager) view1.findViewById(R.id.vp_live);
            fmLivechina.addView(view1);
        }else{
            liveChinaItemNotNet.setVisibility(View.VISIBLE);

            ImageView moren= (ImageView) view.findViewById(R.id.moren);
            moren.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(isNetworkAvailable(getActivity())==true) {
                        ProgressDialog mypDialog=new ProgressDialog(getActivity());
                        //实例化
                        View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.pro_layout, null);
                        mypDialog.setView(view2);
//                        mypDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                        mypDialog.setCancelable(true);
                        //设置ProgressDialog 是否可以按退回按键取消
                        mypDialog.show();
                        liveChinaItemNotNet.setVisibility(View.GONE);
                        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.liveitem_layout, null);
                        imageView_live = (ImageView) view1.findViewById(R.id.imageView_live);
                        imageView_live.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), LiveSwichActivity.class);
                                startActivity(intent);
                            }
                        });

                        tab_live = (TabLayout) view1.findViewById(R.id.tab_live);
                        vp_live = (NoScrollViewPager) view1.findViewById(R.id.vp_live);
                        fmLivechina.addView(view1);
                        changeview();
                        mypDialog.dismiss();
                    }
                }
            });
        }
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getActivity(), "tvxq27.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        changeBeanDao = daoSession.getChangeBeanDao();

        users = changeBeanDao.queryBuilder()
                .where(ChangeBeanDao.Properties.Type.eq("1")).limit(100)
                .build().list();

        userss = changeBeanDao.queryBuilder()
                .where(ChangeBeanDao.Properties.Type.eq("")).limit(100)
                .build().list();
        changeview();

    }

 private void changeview(){
     if(isNetworkAvailable(getActivity())){
         OkHttpClient okHttpClient = new OkHttpClient();
         Request request = new Request.Builder()
                 .url("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json")
                 .build();
         Call call = okHttpClient.newCall(request);
         call.enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {

             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 final String aa = response.body().string();
                 Gson gson = new Gson();
                 AddressBean tiaoz = gson.fromJson(aa, AddressBean.class);
                 list.addAll(tiaoz.getTablist());
                 list1.addAll(tiaoz.getAlllist());
                 getActivity(). runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         if(users.size()==0) {
                             for (int i = 0; i < list.size(); i++) {
                                 ChangeBean user = new ChangeBean(null, list.get(i).getTitle(), list.get(i).getUrl(), "1", "");
                                 changeBeanDao.insert(user);
                             }
                             for (int d = 0; d <list1.size() ; d++) {
                                 ChangeBean usero = changeBeanDao.queryBuilder()
                                         .where(ChangeBeanDao.Properties.Title.eq(list1.get(d).getTitle()))
                                         .build().unique();
                                 if(usero!=null){

                                 }else{
                                     ChangeBean userr = new ChangeBean(null, list1.get(d).getTitle(), list1.get(d).getUrl(), "", "");
                                     changeBeanDao.insert(userr);
                                 }
                             }

                             users = changeBeanDao.queryBuilder()
                                     .where(ChangeBeanDao.Properties.Type.eq("1")).limit(100)
                                     .build().list();
                             for (ChangeBean user : users) {
                             }
                         }
                         messagee= new Message();
                         messagee.what = 2;
                         handler.sendMessage(messagee);

                     }
                 });
             }
         });
     }
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
        if(isNetworkAvailable(getActivity())){
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

            userss = changeBeanDao.queryBuilder()
                    .where(ChangeBeanDao.Properties.Type.eq("")).limit(100)
                    .build().list();

            for(int i=0;i<users.size();i++){

                mTi.add(users.get(i).getTitle());
                TestFm testFm=new TestFm().newInstance(users.get(i).getUrl(),i);
                fragmentList.add(testFm);
            }
        }
    }
}
