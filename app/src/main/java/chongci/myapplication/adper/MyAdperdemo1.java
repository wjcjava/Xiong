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

import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.R;


public class MyAdperdemo1 extends BaseAdapter {
    private final Context context;
    private final List<BeanOne.ListBean> list1;

    public MyAdperdemo1(Context context, List<BeanOne.ListBean> list3) {
        this.context = context;
        this.list1 = list3;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.liebiao1, null);
            hordle.name=convertView.findViewById(R.id.name);
            hordle.tu=convertView.findViewById(R.id.tu);
            hordle.time=convertView.findViewById(R.id.time);
            convertView.setTag(hordle);

        } else {
            hordle = (ViewHordle) convertView.getTag();
        }
        Glide.with(context).load(list1.get(position).getImage()).error(R.mipmap.ic_launcher).into(hordle.tu);
        hordle.name.setText(list1.get(position).getTitle());
        hordle.time.setText(list1.get(position).getDaytime());
        return convertView;
    }

    class ViewHordle {
        ImageView tu;
        TextView time;
        TextView name;
    }
}