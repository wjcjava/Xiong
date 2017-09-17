package chongci.myapplication.adper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.R;

/**
 * Created by ASUS on 2017/9/14.
 */

public class BoBaoAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<BoBaoBean.ListBean> list;

    public BoBaoAdapter(Context context, ArrayList<BoBaoBean.ListBean> list) {
        this.list = list;
        this.context = context;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView bitmap_iv;
        private TextView title_tv;
        private TextView time_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            bitmap_iv = (ImageView) itemView.findViewById(R.id.bitmap_iv);
            title_tv = (TextView) itemView.findViewById(R.id.title_tv);
            time_tv = (TextView) itemView.findViewById(R.id.time_tv);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bobao, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        Glide.with(context).load(list.get(position).getPicurl()).into(holder1.bitmap_iv);
        holder1.title_tv.setText(list.get(position).getTitle());
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
