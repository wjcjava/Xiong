package chongci.myapplication.view.fragment.livefragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.LiveBean;
import chongci.myapplication.Bean.LiveVedioItemBean;
import chongci.myapplication.R;
import chongci.myapplication.activity.Live_VedioActivity;
import chongci.myapplication.adper.MyLiveAdapter;
import chongci.myapplication.fengzhuang.Fengzhuang;
import chongci.myapplication.view.fragment.livefragment.base.BaseFragment;

/**
 * Created by lenovo on 2017/9/14.
 */

public class Live_SpecialFragment extends BaseFragment {
    private XRecyclerView xrecycleview;
    private List<LiveBean.VideoBean> list = new ArrayList<>();
    private MyLiveAdapter adapter;

    int page;
    private String hls_url;
    private String title;
    private String urls;

    @Override
    protected void initView(View view) {
        xrecycleview= (XRecyclerView) view.findViewById(R.id.xrecycleview);
        adapter = new MyLiveAdapter(getActivity(),list);
        xrecycleview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        xrecycleview.setAdapter(adapter);
        xrecycleview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                initData();
                xrecycleview.refreshComplete();
            }
            @Override
            public void onLoadMore() {
                page++;
                initData();
                xrecycleview.loadMoreComplete();
            }
        });


    }

    @Override
    protected void initData() {
        String url="http://api.cntv.cn/video/videolistById?vsid=VSET100167308855&n=7&serviceId=panda&o=desc&of=time&p="+page;
        Fengzhuang.getFengzhuang().parthlive(url, new Fengzhuang.GetLiveBean() {
            @Override
            public void show(LiveBean bean) {
                list.addAll(bean.getVideo());
                adapter.notifyDataSetChanged();
            }
        });
        initIntent();
    }

    public  void  initIntent(){
        adapter.setItemOnClick(new MyLiveAdapter.Listener() {
            @Override
            public void click(View v, final int position) {

                String vid = list.get(position).getVid();
                Log.i("11111111111",vid);

                urls = "http://115.182.35.91/api/getVideoInfoForCBox.do?pid="+vid;
                Log.i("1111111111111",urls);


                Fengzhuang.getFengzhuang().parseVedioItemBean(urls, new Fengzhuang.GetLiveVedioItemBean() {
                    @Override
                    public void show(LiveVedioItemBean bean) {
                        hls_url = bean.getHls_url();
                        title = bean.getTitle();

                        String cdn_name = bean.getCdn_info().getCdn_name();
                        final Intent intent=new Intent(getActivity(),Live_VedioActivity.class);
                        String img = list.get(position).getImg();
                        String urlvedio = list.get(position).getUrl();
                        intent.putExtra("urlvedio",urlvedio);
                        intent.putExtra("img",img);
                        intent.putExtra("hlsurl",hls_url);
                        intent.putExtra("title",title);
                        Log.i("11111111111",hls_url);
                        Log.i("11111111111",title);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_live__wonder;
    }
}
