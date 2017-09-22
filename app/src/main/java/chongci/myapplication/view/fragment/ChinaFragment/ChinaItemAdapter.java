package chongci.myapplication.view.fragment.ChinaFragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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

class ChinaItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

String live_url;
    private OnItemClickListener onItemClickListener;
    FragmentActivity activity;
    List<LiveChinaBean.LiveBean> arrayLisst;
    ArrayList<LiveLiveBeans.HlsUrlBean> hlsUrllist=new ArrayList<>();


        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }


    public ChinaItemAdapter(FragmentActivity activity, List<LiveChinaBean.LiveBean> arrayLisst) {

        this.activity=activity;
        this.arrayLisst=arrayLisst;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(activity).inflate(R.layout.item_china, parent, false);
        RecyclerView.LayoutParams layoutP = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        itemview.setLayoutParams(layoutP);

        MyViewHolder viewHolder = new MyViewHolder(itemview);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

           final MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.liveChinaTabItemJianjieDetail.setText(arrayLisst.get(position).getBrief());
       myViewHolder.liveChinaTabItemTitle.setText("[正在直播]"+arrayLisst.get(position).getTitle());
        myViewHolder.live_videocontroller1.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);
        live_url="http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+arrayLisst.get(position).getId()+"&amp;client=androidapp";

//       myViewHolder.live_videocontroller1.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               if(isWifi(activity)){
//               }else{
//                   View popupView = activity.getLayoutInflater().inflate(R.layout.alert_layout, null);
//                   PopupWindow window = new PopupWindow(popupView, 400, 600);
//                   window.showAsDropDown(myViewHolder.live_videocontroller1, -400, 0);
//
//
//
//               }
//           }
//       });0











        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(live_url)

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
                LiveLiveBeans  tiaoz = gson.fromJson(aa,LiveLiveBeans.class);
                hlsUrllist.clear();
                hlsUrllist.add(tiaoz.getHls_url());

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        myViewHolder.live_videocontroller1.setUp(hlsUrllist.get(0).getHls2(),"");

                    }
                });
            }
        });




        Glide.with(activity)
                .load(arrayLisst.get(position).getImage())
                .into(myViewHolder.live_videocontroller1.ivThumb);
        myViewHolder.liveChinaTabItemJianjieImg.setOnClickListener(new View.OnClickListener() {
            int a=0;
            @Override
            public void onClick(View v) {

                a++;
                if(a%2==0){
                    myViewHolder.liveChinaTabItemJianjieImg.setBackgroundResource(R.drawable.live_china_detail_down);
                    myViewHolder.liveChinaTabItemJianjieDetail.setVisibility(View.GONE);
                }else{
                    myViewHolder.liveChinaTabItemJianjieImg.setBackgroundResource(R.drawable.live_china_detail_up);
                    myViewHolder.liveChinaTabItemJianjieDetail.setVisibility(View.VISIBLE);
                }

            }
        });



    }


    @Override
    public int getItemCount() {
        return arrayLisst.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
//ImageView imageView2;
        ImageView liveChinaTabItemImg;
        @BindView(R.id.btn_play)
        ImageView btnPlay;

        @BindView(R.id.play_layout)
        RelativeLayout playLayout;

        TextView liveChinaTabItemTitle;
        @BindView(R.id.live_china_tab_item_jianjie_tishi)
        TextView liveChinaTabItemJianjieTishi;
        @BindView(R.id.live_china_tab_item_jianjie_img)
        TextView liveChinaTabItemJianjieImg;
        @BindView(R.id.livechina_arrow)
        RelativeLayout livechinaArrow;
        @BindView(R.id.livechina_jianjie_underline)
        View livechinaJianjieUnderline;

        TextView liveChinaTabItemJianjieDetail;
        @BindView(R.id.live_china_tab_item_jianjie_btn)
        RelativeLayout liveChinaTabItemJianjieBtn;
        JCVideoPlayer live_videocontroller1;

        public MyViewHolder(View itemView) {
            super(itemView);
//            imageView2= (ImageView) itemView.findViewById(R.id.imageView2);
            btnPlay= (ImageView) itemView.findViewById(R.id.btn_play);
            playLayout= (RelativeLayout) itemView.findViewById(R.id.play_layout);
            liveChinaTabItemJianjieImg= (TextView) itemView.findViewById(R.id.live_china_tab_item_jianjie_img);
            liveChinaTabItemImg= (ImageView) itemView.findViewById(R.id.live_china_tab_item_img);
            liveChinaTabItemJianjieDetail= (TextView) itemView.findViewById(R.id.live_china_tab_item_jianjie_detail);
            liveChinaTabItemTitle=(TextView) itemView.findViewById(R.id.live_china_tab_item_title);
            live_videocontroller1= (JCVideoPlayer) itemView.findViewById(R.id.live_videocontroller1);
        }
    }
    public  void show(OnItemClickListener onClickListener){
        onItemClickListener=onClickListener;
    }


    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }


    private static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }


}
