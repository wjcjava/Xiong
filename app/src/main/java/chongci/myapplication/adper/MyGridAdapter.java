package chongci.myapplication.adper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.LiveEyesBean;
import chongci.myapplication.R;

/**
 * Created by lenovo on 2017/9/15.
 */

public class MyGridAdapter extends BaseAdapter{
        private Context context;
            private List<LiveEyesBean.ListBean> list= new ArrayList<>();
            private ViewHolder holder;

            public MyGridAdapter(Context context, List<LiveEyesBean.ListBean> list) {
                this.context = context;
                this.list = list;
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    holder= new ViewHolder();
                    convertView=View.inflate(context, R.layout.griditem,null);
                    holder.textView=(TextView)convertView.findViewById(R.id.tv_gridtitle);
                    holder.imageView= (ImageView) convertView.findViewById(R.id.iv_gridimage);
                    convertView.setTag(holder);
                }else {
                    holder=(ViewHolder) convertView.getTag();
                }
                holder.textView.setText(list.get(position).getTitle());
                Glide.with(context).load(list.get(position).getImage())
                        .error(R.mipmap.ic_launcher).into(holder.imageView);
                return convertView;
            }
            static  class ViewHolder{
                ImageView imageView;
                TextView textView;
            }
           // public void delete(Bean student){
             //   list.remove(student);
           // }


}
