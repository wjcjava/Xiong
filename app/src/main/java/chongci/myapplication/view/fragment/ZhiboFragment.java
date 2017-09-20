package chongci.myapplication.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import chongci.myapplication.Bean.WebBean;
import chongci.myapplication.R;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrDefaultHandler2;

import java.util.ArrayList;

import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.Bean.ImageBean;
import chongci.myapplication.Bean.ScreenBean;
import chongci.myapplication.activity.VideoActivity;
import chongci.myapplication.activity.WebActivity;
import chongci.myapplication.adper.BoBaoAdapter;
import chongci.myapplication.fengzhuang.OkHttpUtil;
import chongci.myapplication.p.BoImpl;
import chongci.myapplication.view.BoBaoInter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiboFragment extends Fragment implements BoBaoInter {


    private ImageView img_iv;
    private TextView title_tv;
    private RecyclerView bobao_recyclerView;
    private PtrFrameLayout ptrclassic;
    private ArrayList<BoBaoBean.ListBean> list = new ArrayList<>();
    private ArrayList<ImageBean.DataBean.BigImgBean> imgBeen = new ArrayList<>();
    private ArrayList<ScreenBean.VideoBean.ChaptersBean> scrBean = new ArrayList<>();
    private ArrayList<WebBean> webBee = new ArrayList<>();
    private BoBaoAdapter adapter;
    private int a = 1;
    private int pos;
    public ZhiboFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhibo, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        BoImpl boImplP = new BoImpl(this);
        boImplP.getImageBean("http://www.ipanda.com/kehuduan/news/index.json");
        boImplP.getBoBaoBean("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=6&page=" + a);
    }

    private void initView(View view) {
        img_iv = (ImageView) view.findViewById(R.id.img_iv);
        title_tv = (TextView) view.findViewById(R.id.title_tv);
        bobao_recyclerView = (RecyclerView) view.findViewById(R.id.bobao_recyclerView);
        ptrclassic = (PtrFrameLayout) view.findViewById(R.id.ptrclassic);

        img_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                intent.putExtra("video",scrBean);
                intent.putExtra("pos",pos);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(ImageBean imageBean) {
        imgBeen.addAll(imageBean.getData().getBigImg());
        for (int i = 0; i < imgBeen.size(); i++) {
            Glide.with(getContext()).load(imgBeen.get(i).getImage()).into(img_iv);
            title_tv.setText(imgBeen.get(i).getTitle());
        }
    }

    /**
     * RecyclerView 上拉、下拉
     * @param boBaoBean
     */
    @Override
    public void onSuccess(final BoBaoBean boBaoBean) {
        list.addAll(boBaoBean.getList());
        adapter = new BoBaoAdapter(getContext(), list);
        bobao_recyclerView.setSaveEnabled(true);
        bobao_recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        bobao_recyclerView.setAdapter(adapter);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });

        adapter.setOnItemClickListener(new BoBaoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                pos = position;
                Intent intent = new Intent(getContext(), WebActivity.class);
                String url1 = list.get(position).getUrl();
                intent.putExtra("list", list);
                intent.putExtra("url", url1);
                intent.putExtra("pos", position);
                startActivity(intent);
            }
        });

        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getContext());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getContext());
        ptrclassic.setHeaderView(header);
        ptrclassic.setFooterView(footer);
        ptrclassic.addPtrUIHandler(header);
        ptrclassic.addPtrUIHandler(footer);

        ptrclassic.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                if (a == 14) {
                    frame.refreshComplete();
                    Toast.makeText(getContext(), "没有啦", Toast.LENGTH_SHORT).show();
                } else {
                    a++;
                    OkHttpUtil.getUtil().SendGet1("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=6&page=" + a, new OkHttpUtil.GetBeantu1() {
                        @Override
                        public void showtu(BoBaoBean boBaoBean) {
                            list.addAll(boBaoBean.getList());
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataSetChanged();
                                }
                            });
                        }
                    });
                    frame.refreshComplete();
                }
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                a = 1;
                list.clear();
                OkHttpUtil.getUtil().SendGet1("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=6&page=" + a, new OkHttpUtil.GetBeantu1() {
                    @Override
                    public void showtu(BoBaoBean boBaoBean) {
                        list.addAll(boBaoBean.getList());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                });
                frame.refreshComplete();
            }
        });
    }

    @Override
    public void onSuccess(ScreenBean screenBean) {
        scrBean.addAll(screenBean.getVideo().getChapters());
    }

    @Override
    public void onSuccess(WebBean webBean) {
        webBee.add(webBean);
    }

}
