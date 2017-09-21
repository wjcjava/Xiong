package chongci.myapplication.view.fragment.ChinaFragment;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import chongci.myapplication.R;

/**
 * Created by a on 2017/9/15.
 */

class ChinaItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnItemClickListener onItemClickListener;
    FragmentActivity activity;
    List<LiveChinaBean.LiveBean> arrayLisst;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public ChinaItemAdapter(FragmentActivity activity, List<LiveChinaBean.LiveBean> arrayLisst) {

        this.activity = activity;
        this.arrayLisst = arrayLisst;

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
        Glide.with(activity).load(arrayLisst.get(position).getImage()).into(myViewHolder.liveChinaTabItemImg);
        myViewHolder.liveChinaTabItemJianjieDetail.setText(arrayLisst.get(position).getBrief());
        myViewHolder.liveChinaTabItemTitle.setText(arrayLisst.get(position).getTitle());
        myViewHolder.liveChinaTabItemJianjieImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewHolder.liveChinaTabItemJianjieDetail.setVisibility(View.VISIBLE);


            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return arrayLisst.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

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

        public MyViewHolder(View itemView) {
            super(itemView);
            liveChinaTabItemJianjieImg = (TextView) itemView.findViewById(R.id.live_china_tab_item_jianjie_img);
            liveChinaTabItemImg = (ImageView) itemView.findViewById(R.id.live_china_tab_item_img);
            liveChinaTabItemJianjieDetail = (TextView) itemView.findViewById(R.id.live_china_tab_item_jianjie_detail);
            liveChinaTabItemTitle = (TextView) itemView.findViewById(R.id.live_china_tab_item_title);
        }
    }

    public void show(OnItemClickListener onClickListener) {
        onItemClickListener = onClickListener;
    }


    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

}
