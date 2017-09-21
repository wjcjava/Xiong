package chongci.myapplication.adper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import chongci.myapplication.R;
import chongci.myapplication.activity.gungun_activity.GunGun_things;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by 冯玉苗 on 2017/9/21.
 */

public class GunGunAdper extends RecyclerView.Adapter<GunGunAdper.MyHolder>{

    private  Context context;
    private  List<TobGunGunxiubean.VideoBean> list1;

    public GunGunAdper(Context context, List<TobGunGunxiubean.VideoBean> list1) {
    this.context=context;
        this.list1=list1;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1=View.inflate(context,R.layout.leibiao,null);
        MyHolder holder=new MyHolder(view1);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Glide.with(context).load(list1.get(position).getImg()).into(holder.tutu);
        holder.name.setText(list1.get(position).getT());
        holder.time.setText(list1.get(position).getPtime());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView tutu;
        private TextView name;
        private TextView time;
        public MyHolder(View itemView) {
            super(itemView);
            tutu= (ImageView) itemView.findViewById(R.id.tutu);
            name= (TextView) itemView.findViewById(R.id.name3);
            time= (TextView) itemView.findViewById(R.id.exe3);
        }
    }
}
