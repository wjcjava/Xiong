package chongci.myapplication.view.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.Bean.BeanThree;
import chongci.myapplication.Bean.BeanTwo;
import chongci.myapplication.R;
import chongci.myapplication.activity.HudongActivity;
import chongci.myapplication.activity.voidactivity.PanPanActivity;
import chongci.myapplication.adper.MyAdperdemo;
import chongci.myapplication.adper.MyAdperdemo1;
import chongci.myapplication.adper.MyAdperdemo2;
import chongci.myapplication.adper.MyAdperdemo3;
import chongci.myapplication.p.PresenterImpl;
import chongci.myapplication.view.IView;
import chongci.myapplication.widget.MyGridview;
import chongci.myapplication.widget.MyListview;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends Fragment implements IView, View.OnClickListener {

    private List<String> list = new ArrayList<>();
    private List<String> liststring = new ArrayList<>();
    private List<Bean.DataBean.BigImgBean> list1 = new ArrayList();
    private List<Bean.DataBean.PandaliveBean.ListBean> list2 = new ArrayList<>();
    private List<BeanOne.ListBean> list3 = new ArrayList<>();
    private List<BeanTwo.ListBean> list4 = new ArrayList<>();
    private List<Bean.DataBean.ChinaliveBean.ListBeanX> list5 = new ArrayList<>();
    private List<Bean.DataBean.PandaeyeBean.ItemsBean> list6 = new ArrayList<>();

    private Banner banner;
    private TextView baiyun;
    private Button button2;
    private Button button;
    private GridView grid;
    private GridView grid1;
    private ImageView tupian;
    private PresenterImpl presenter;
    private ProgressDialog myDialog;
    private MyListview listview;
    private MyGridview grid2;
    private TextView guancha;
    private TextView xiuchang;
    private TextView jingcai;
    private TextView gungun;
    private TextView zhongguo;
    private TextView xunshui;
    private View view0;
    private View view2;
    private View view3;
    private View view4;
    private PtrClassicFrameLayout ptr;
    private TextView tv_hudong;
    private ProgressBar pregress;
    private PtrClassicFrameLayout test_list_view_frame;
    private android.os.Handler handler=new android.os.Handler();
    private MyAdperdemo adperdemo;
    private MyAdperdemo3 adperdemo3;
    private MyAdperdemo2 adperdemo2;


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
        initdianji();
        return view1;
    }


    private void initView(View view1) {

        banner = (Banner) view1.findViewById(R.id.banner);
        baiyun = (TextView) view1.findViewById(R.id.baiyun);

        button2 = (Button) view1.findViewById(R.id.button2);
        button = (Button) view1.findViewById(R.id.button);
        grid = view1.findViewById(R.id.grid);
        grid1 = view1.findViewById(R.id.grid1);
        tupian = (ImageView) view1.findViewById(R.id.tupian);
        button.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);


        listview = (MyListview) view1.findViewById(R.id.listview);
        grid2 = (MyGridview) view1.findViewById(R.id.grid2);
        guancha = (TextView) view1.findViewById(R.id.guancha);
        xiuchang = (TextView) view1.findViewById(R.id.xiuchang);
        jingcai = (TextView) view1.findViewById(R.id.jingcai);
        gungun = (TextView) view1.findViewById(R.id.gungun);
        zhongguo = (TextView) view1.findViewById(R.id.zhongguo);
        xunshui = (TextView) view1.findViewById(R.id.xunshui);
        view0 = (View) view1.findViewById(R.id.view1);
        view2 = (View) view1.findViewById(R.id.view2);
        view3 = (View) view1.findViewById(R.id.view3);
        view4 = (View) view1.findViewById(R.id.view4);
        view0.setVisibility(View.INVISIBLE);
        view2.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);
        view4.setVisibility(View.INVISIBLE);

        initData();
        tv_hudong = (TextView) view1.findViewById(R.id.tv_hudong);
        tv_hudong.setOnClickListener(this);


        test_list_view_frame = (PtrClassicFrameLayout) view1.findViewById(R.id.test_list_view_frame);

        test_list_view_frame.postDelayed(new Runnable() {

            @Override

            public void run() {

                //是否自动加载 默认true mPtrFrame.setAutoLoadMoreEnable(true)

                test_list_view_frame.autoRefresh(false);

            }

        }, 2000);

        test_list_view_frame.setPtrHandler(new PtrDefaultHandler() {



            @Override//下拉刷新的时候走这里

            public void onRefreshBegin(PtrFrameLayout frame) {

                handler.post(new Runnable() {

                    @Override

                    public void run() {
                        adperdemo.notifyDataSetChanged();
                        adperdemo3.notifyDataSetChanged();
                        adperdemo2.notifyDataSetChanged();
                        test_list_view_frame.refreshComplete();

                    }

                });

            }



        });
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    private void initData() {

        presenter = new PresenterImpl(this);
        presenter.BeanGet("http://www.ipanda.com/kehuduan/shouye/index.json");
        presenter.BeanGet1("http://www.ipanda.com/kehuduan/shipinliebieye/jingcaiyike/index.json");
        presenter.BeanGet2("http://www.ipanda.com/kehuduan/shipinliebieye/video/index.json");
    }


    @Override
    public void OnSuccess(Bean bean) {

        myDialog.dismiss();
        button.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);

        view0.setVisibility(View.VISIBLE);
        view2.setVisibility(View.VISIBLE);
        view3.setVisibility(View.VISIBLE);
        view4.setVisibility(View.VISIBLE);

        guancha.setText(bean.getData().getPandaeye().getTitle());
        xiuchang.setText(bean.getData().getPandalive().getTitle());
        jingcai.setText(bean.getData().getCctv().getTitle());
        gungun.setText(bean.getData().getList().get(0).getTitle());
        zhongguo.setText(bean.getData().getChinalive().getTitle());

        button2.setText(bean.getData().getPandaeye().getItems().get(1).getBrief());
        button.setText(bean.getData().getPandaeye().getItems().get(0).getBrief());


        xunshui.setText(bean.getData().getPandaeye().getItems().get(1).getTitle());
        baiyun.setText(bean.getData().getPandaeye().getItems().get(0).getTitle());

        list6.addAll(bean.getData().getPandaeye().getItems());

        xunshui.setOnClickListener(this);
        baiyun.setOnClickListener(this);

        Glide.with(getActivity()).load(bean.getData().getPandaeye().getPandaeyelogo()).into(tupian);
        list1.addAll(bean.getData().getBigImg());
        list2.addAll(bean.getData().getPandalive().getList());

        list5.addAll(bean.getData().getChinalive().getList());

        adperdemo = new MyAdperdemo(getActivity(), list2);
        grid.setAdapter(adperdemo);

        adperdemo3 = new MyAdperdemo3(getActivity(), list5);
        grid2.setAdapter(adperdemo3);
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
                adperdemo3.notifyDataSetChanged();

            }
        });


    }

    @Override
    public void OnSuccess(BeanOne beanOne) {

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

    @Override
    public void OnSuccecc(BeanTwo beanTwo) {
        list4.addAll(beanTwo.getList());
        adperdemo2 = new MyAdperdemo2(getActivity(), list4);
        listview.setAdapter(adperdemo2);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adperdemo2.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void OnSuccecc(BeanThree beanThree) {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_hudong:
                getActivity().startActivity(new Intent(getActivity(), HudongActivity.class));
                break;
            case R.id.baiyun:
                Intent intent = new Intent(getActivity(), PanPanActivity.class);
                intent.putExtra("shipin", list6.get(0).getPid());
                startActivity(intent);
                break;
            case R.id.xunshui:
                Intent intent2 = new Intent(getActivity(), PanPanActivity.class);
                intent2.putExtra("shipin", list6.get(1).getPid());
                startActivity(intent2);
                break;

        }
    }

    private void initdianji() {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getActivity(), PanPanActivity.class);
                intent.putExtra("shipin", list1.get(position).getPid());
                startActivity(intent);
            }
        });
        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), PanPanActivity.class);
                intent.putExtra("shipin", list3.get(i).getPid());
                startActivity(intent);
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), PanPanActivity.class);
                intent.putExtra("shipin", list4.get(i).getPid());
                startActivity(intent);
            }
        });

    }
}
