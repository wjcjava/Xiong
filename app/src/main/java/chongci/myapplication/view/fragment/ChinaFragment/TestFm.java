package chongci.myapplication.view.fragment.ChinaFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.MainActivity;
import chongci.myapplication.R;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by a on 2017/9/15.
 */

public class  TestFm extends Fragment {
    JCVideoPlayer re;
    int pos;
//    http://www.ipanda.com/kehuduan/liebiao/taishan/index.json
    List<LiveChinaBean.LiveBean> arrayLisst=new ArrayList<>();
    String baseurl="http://www.ipanda.com/kehuduan/liebiao/";
    ChinaItemAdapter adapter;
   String addurl;
    String live_url;
    int flag;
    ArrayList<String> fujson=new ArrayList<>();


     private Handler handler = new Handler() {
             @Override
             public void handleMessage(Message msg) {
                 super.handleMessage(msg);
                 switch (msg.what) {
                     case 111:
                         adapter.notifyDataSetChanged();
                         break;
                 }
             }
         };

        private XRecyclerView news_xrecycle;
//        private List<> list = new ArrayList<String>();

    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle != null){
            addurl = bundle.getString("content");
            flag = bundle.getInt("flag");
        }
    }





    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            View view = inflater.inflate(R.layout.fm_test, container,false);
            initView(view);
            return view;
        }

    public void initView(View view){
        news_xrecycle = (XRecyclerView) view.findViewById(R.id.xrecycle);

        initreData();
        news_xrecycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

               arrayLisst.clear();


                initreData();

                handler.sendEmptyMessage(111);
                news_xrecycle.refreshComplete(); //下拉刷新完成

            }

            public void onLoadMore() {

                news_xrecycle.loadMoreComplete();//加载更多完成
           }
        });



    }

    private void initreData() {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(addurl)

                .build();
        Log.e("aaaaaaa---------",baseurl+addurl);
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String aa = response.body().string();

                    Log.e("wwww",response.body().string());

                Gson gson = new Gson();
                LiveChinaBean tiaoz = gson.fromJson(aa, LiveChinaBean.class);

                arrayLisst.addAll(tiaoz.getLive());

                   for (LiveChinaBean.LiveBean liveBean:arrayLisst){

                     ;
                       fujson.add(liveBean.getId());



                   }



               getActivity(). runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        news_xrecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                        news_xrecycle.setHasFixedSize(true);
                        adapter = new ChinaItemAdapter(getActivity(),arrayLisst);
                        news_xrecycle.setAdapter(adapter);

                    }
                });
            }
        });



            }









    public static TestFm newInstance(String addurl,int flag){
        Bundle bundle = new Bundle();
        bundle.putString("content",addurl);
        bundle.putInt("flag", flag);
        TestFm testFm = new TestFm();
        testFm.setArguments(bundle);
        return testFm;

    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
