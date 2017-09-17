package chongci.myapplication.adper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.ChatBean;
import chongci.myapplication.R;

/**
 * Created by lenovo on 2017/9/15.
 */

public class MyChatAdapter extends BaseAdapter {
        private Context context;
            private List<ChatBean.DataBean.ContentBean> list= new ArrayList<>();
            private ViewHolder holder;

            public MyChatAdapter(Context context, List<ChatBean.DataBean.ContentBean> list) {
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
                    convertView=View.inflate(context, R.layout.chatitem,null);
                    holder.textView=(TextView)convertView.findViewById(R.id.tv_chatauthor);
                    holder.textView2=(TextView)convertView.findViewById(R.id.tv_chatauthorid);
                    holder.textView3=(TextView)convertView.findViewById(R.id.tv_chatmessage);
                    holder.textView4=(TextView)convertView.findViewById(R.id.tv_chattime);
                    convertView.setTag(holder);
                }else {
                    holder=(ViewHolder) convertView.getTag();
                }
                SimpleDateFormat sDateFormat    =   new    SimpleDateFormat("yyyy-MM-dd");
                String    date    =    sDateFormat.format(new    java.util.Date());
                holder.textView.setText(list.get(position).getAuthor());
                holder.textView2.setText(list.get(position).getAuthorid());
                holder.textView3.setText(list.get(position).getMessage());
                holder.textView4.setText(date);
                return convertView;
            }
            static  class ViewHolder{
                TextView textView;
                TextView textView2;
                TextView textView3;
                TextView textView4;

            }
           // public void delete(Bean student){
             //   list.remove(student);
           // }
}
