package chongci.myapplication.view.fragment.livefragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.LiveEyesBean;
import chongci.myapplication.R;
import chongci.myapplication.adper.MyGridAdapter;
import chongci.myapplication.fengzhuang.Fengzhuang;
import chongci.myapplication.view.fragment.livefragment.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Live_EyeFragment extends BaseFragment {


    private GridView gridView;
    private List<LiveEyesBean.ListBean> list= new ArrayList<>();
    private MyGridAdapter gridAdapter;

    @Override
    protected void initData() {
        String url="http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json";
        Fengzhuang.getFengzhuang().parseEyesBean(url, new Fengzhuang.GetLiveEyesBean() {
            @Override
            public void show(LiveEyesBean bean) {
                list.addAll(bean.getList());
                gridAdapter.notifyDataSetChanged();
            }
        });
        gridAdapter = new MyGridAdapter(getActivity(),list);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String liveid = list.get(position).getId();
                String livetitle = list.get(position).getTitle();
                String liveimage = list.get(position).getImage();
                Log.i("99999999",liveid);
                Log.i("99999999",livetitle);
                //发送广播
                Intent intent = new Intent();
                intent.putExtra("liveid", liveid);
                intent.putExtra("livetitle",livetitle);intent.putExtra("liveimage",liveimage);
                intent.setAction("com.example.socketserverdemo.SocketService");
                getActivity().sendBroadcast(intent);

            }
        });

    }


    @Override
    protected void initView(View view) {
        gridView = (GridView) view.findViewById(R.id.gv_gridview);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_live__eye;
    }
}
