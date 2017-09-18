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

import chongci.myapplication.Bean.WenhuaBean;
import chongci.myapplication.R;


public class MyAdperdemo5 extends BaseAdapter {
    private final Context context;
    private final List<WenhuaBean.ListBean> list1;

    public MyAdperdemo5(Context context, List<WenhuaBean.ListBean> list2) {
        this.context = context;
        this.list1 = list2;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.liebiao5, null);
            hordle.name= (TextView) convertView.findViewById(R.id.name1);
            hordle.tu= (ImageView) convertView.findViewById(R.id.tu1);
            hordle.xiangqing= (TextView) convertView.findViewById(R.id.xiangqing);
            convertView.setTag(hordle);

        } else {
            hordle = (ViewHordle) convertView.getTag();
        }
        Glide.with(context).load(list1.get(position).getImage()).error(R.mipmap.ic_launcher).into(hordle.tu);
        hordle.name.setText(list1.get(position).getTitle());
        hordle.xiangqing.setText(list1.get(position).getBrief());
        return convertView;
    }

    class ViewHordle {
        ImageView tu;
        TextView name;
        TextView xiangqing;
    }
}