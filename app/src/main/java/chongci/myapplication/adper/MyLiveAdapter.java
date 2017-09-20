package chongci.myapplication.adper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.LiveBean;
import chongci.myapplication.R;

public class MyLiveAdapter extends RecyclerView.Adapter<MyLiveAdapter.ViewHolder> {
    private Context context;
    private List<LiveBean.VideoBean> list = new ArrayList<>();
    private Listener listener;
    private ArrayList<View> mFootViews = new ArrayList<>();

    public MyLiveAdapter(Context context, List<LiveBean.VideoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.live_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
       holder.textView1.setText(list.get(position).getT());
        holder.textView2.setText(list.get(position).getPtime());
         Glide.with(context).load(list.get(position).getImg())
                             .error(R.mipmap.ic_launcher).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.click(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView1;
        TextView textView2;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_itemimage);
            textView1= (TextView) itemView.findViewById(R.id.tv_itemtitle);
            textView2= (TextView) itemView.findViewById(R.id.tv_itemtime);
        }
    }

    public interface Listener {
        void click(View v, int position);
    }

    public void setItemOnClick(Listener listener) {

        this.listener = listener;
    }

}
