package chongci.myapplication.view.fragment.livefragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.Bean.GreenDaoBean;
import chongci.myapplication.R;
import chongci.myapplication.activity.WebActivity;
import chongci.myapplication.adper.BoBaoAdapter;
import chongci.myapplication.adper.ListAdapter;
import chongci.myapplication.dao.GreenDaoBeanDao;
import chongci.myapplication.dao.GreenDaoUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class Jiangcaikandian extends Fragment {

    private RecyclerView sc_listView;
    private GreenDaoBeanDao shujudanli;
    private ListAdapter adapter;
    private ArrayList<BoBaoBean.ListBean> list1 = new ArrayList<>();

    public Jiangcaikandian() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jiangcaikandian, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        sc_listView = (RecyclerView) view.findViewById(R.id.sc_listView);

        shujudanli = GreenDaoUtil.getDianli().shujudanli(getContext());
        final List<GreenDaoBean> list = shujudanli.queryBuilder().list();
        adapter = new ListAdapter(getContext(),list);
        sc_listView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        sc_listView.setAdapter(adapter);
    }
}