package chongci.myapplication.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.Bean.BeanThree;
import chongci.myapplication.Bean.BeanTwo;
import chongci.myapplication.Bean.GunGunBean;
import chongci.myapplication.Bean.WenhuaBean;
import chongci.myapplication.R;
import chongci.myapplication.activity.gungun_activity.GunGun_things;
import chongci.myapplication.activity.prosentactivity.GeRenActivity;
import chongci.myapplication.activity.voidactivity.GunGunActivity;
import chongci.myapplication.adper.MyAdperdemo5;
import chongci.myapplication.p.PresenterImpl;
import chongci.myapplication.view.IView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WenhuaFragment extends Fragment implements IView {

    List<WenhuaBean.BigImgBean> listBeanList = new ArrayList<>();
    List<WenhuaBean.ListBean> list1 = new ArrayList<>();
    private PresenterImpl presenter;
    private ImageView tupian;
    private ListView listview;
    private TextView text;
    private TextView tv_wenhuatype;

    public WenhuaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view1 = inflater.inflate(R.layout.fragment_wenhua, container, false);
        initView(view1);
        presenter = new PresenterImpl(this);
        presenter.BeanWenHua("http://www.ipanda.com/kehuduan/video/index.json");
        return view1;
    }

    private void initView(View view1) {

        tupian = (ImageView) view1.findViewById(R.id.tupian);
        listview = (ListView) view1.findViewById(R.id.listview);
        text = (TextView) view1.findViewById(R.id.text);
        tupian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GunGunActivity.class);
                intent.putExtra("void", listBeanList.get(0).getPid());
                getActivity().startActivity(intent);
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), GunGun_things.class);
                intent.putExtra("list", (Serializable) list1);
                startActivity(intent);
            }
        });

        tv_wenhuatype = (TextView) view1.findViewById(R.id.tv_wenhuatype);
        tv_wenhuatype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), GeRenActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void OnSuccess(Bean bean) {

    }

    @Override
    public void OnSuccess(BeanOne beanOne) {

    }

    @Override
    public void OnSuccecc(BeanTwo beanTwo) {

    }

    @Override
    public void OnSuccecc(BeanThree beanThree) {

    }

    @Override
    public void OnSuccess(WenhuaBean bean) {
        listBeanList.addAll(bean.getBigImg());
        Glide.with(getActivity()).load(listBeanList.get(0).getImage()).into(tupian);
        text.setText(listBeanList.get(0).getTitle());

        list1.addAll(bean.getList());
        final MyAdperdemo5 adperdemo = new MyAdperdemo5(getActivity(), list1);
        listview.setAdapter(adperdemo);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adperdemo.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void OnSuccess(GunGunBean gunBean) {

    }
}