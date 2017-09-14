package chongci.myapplication.view.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.R;
import chongci.myapplication.adper.MyAdperdemo;
import chongci.myapplication.adper.MyAdperdemo1;
import chongci.myapplication.p.PresenterImpl;
import chongci.myapplication.view.IView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends Fragment implements IView {


    private List<String> list = new ArrayList<>();
    private List<String> liststring = new ArrayList<>();

    private List<Bean.DataBean.BigImgBean> list1 = new ArrayList();
    private List<Bean.DataBean.PandaliveBean.ListBean> list2=new ArrayList<>();
    private List<BeanOne.ListBean> list3=new ArrayList<>();



    private Banner banner;
    private TextView textView;
    private Button button2;
    private Button button;
    private GridView grid;
    private GridView grid1;
    private ImageView tupian;
    private PresenterImpl presenter;
    private ProgressDialog myDialog;

    public ShouyeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1 = inflater.inflate(R.layout.fragment_shouye, container, false);

        myDialog = new ProgressDialog(getActivity());
        myDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        myDialog.setTitle("友情提示");
        myDialog.setMessage("数据加载中，请稍后...");
        myDialog.setIcon(R.mipmap.ic_launcher);
        myDialog.setIndeterminate(false);
        myDialog.setCancelable(true);
        myDialog.show();
        initView(view1);

        return view1;
    }

    private void initView(View view1) {
        banner = (Banner) view1.findViewById(R.id.banner);
        textView = (TextView) view1.findViewById(R.id.textView);
        button2 = (Button) view1.findViewById(R.id.button2);
        button = (Button) view1.findViewById(R.id.button);
        grid = view1.findViewById(R.id.grid);
        grid1 = view1.findViewById(R.id.grid1);

        //tupian = (ImageView) view1.findViewById(R.id.tupian);
        initData();

    }

    private void initData() {
        presenter = new PresenterImpl(this);
        presenter.BeanGet("http://www.ipanda.com/kehuduan/shouye/index.json");
        presenter.BeanGet1("http://www.ipanda.com/kehuduan/shipinliebieye/jingcaiyike/index.json");
    }


    @Override
    public void OnSuccess(Bean bean) {
        list1.addAll(bean.getData().getBigImg());
        list2.addAll(bean.getData().getPandalive().getList());
        final MyAdperdemo adperdemo = new MyAdperdemo(getActivity(), list2);
        grid.setAdapter(adperdemo);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                banner.setImageLoader(new LuBoTu());
                for (int i = 0; i < 4; i++) {
                    list.add(list1.get(i).getImage());

                }
                banner.setIndicatorGravity(BannerConfig.RIGHT);
                banner.setImages(list);
                for (int i = 0; i < 4; i++) {
                    liststring.add(list1.get(i).getTitle());

                }
                banner.setBannerTitles(liststring);
                banner.start();
                adperdemo.notifyDataSetChanged();

            }
        });


    }

    @Override
    public void OnSuccess(BeanOne beanOne) {
        myDialog.dismiss();
            list3.addAll(beanOne.getList());
        final MyAdperdemo1 adperdemo1 = new MyAdperdemo1(getActivity(), list3);
        grid1.setAdapter(adperdemo1);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adperdemo1.notifyDataSetChanged();

            }
        });
    }


}
