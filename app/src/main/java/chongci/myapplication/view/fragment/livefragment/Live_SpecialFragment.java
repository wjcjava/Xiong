package chongci.myapplication.view.fragment.livefragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.LiveBean;
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
        adapter.setItemOnClick(new MyLiveAdapter.Listener() {
            @Override
            public void click(View v, int position) {
                Intent intent=new Intent(getActivity(),Live_VedioActivity.class);
                startActivity(intent);
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
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_live__wonder;
    }

}
