package chongci.myapplication.adper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import chongci.myapplication.Bean.BeanTwo;
import chongci.myapplication.R;


public class MyAdperdemo2 extends BaseAdapter {
    private final Context context;
    private final List<BeanTwo.ListBean> list1;

    public MyAdperdemo2(Context context, List<BeanTwo.ListBean> list4) {
        this.context = context;
        this.list1 = list4;


    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int position) {
        return list1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHordle hordle;
        if (convertView == null) {
            hordle = new ViewHordle();
            convertView = LayoutInflater.from(context).inflate(R.layout.liebiao2, null);
            hordle.name2=convertView.findViewById(R.id.name2);
            hordle.tu2=convertView.findViewById(R.id.tu2);
            hordle.time2=convertView.findViewById(R.id.time2);
            hordle.shichang=convertView.findViewById(R.id.shichang);
            convertView.setTag(hordle);

        } else {
            hordle = (ViewHordle) convertView.getTag();
        }
        Glide.with(context).load(list1.get(position).getImage()).error(R.mipmap.ic_launcher).into(hordle.tu2);
        hordle.name2.setText(list1.get(position).getTitle());
        hordle.time2.setText(list1.get(position).getDaytime());
        hordle.shichang.setText(list1.get(position).getVideoLength());
        return convertView;
    }

    class ViewHordle {
        ImageView tu2;
        TextView name2;
        TextView time2;
        TextView shichang;
    }
}