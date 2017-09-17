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

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.R;


public class MyAdperdemo extends BaseAdapter {
    private final Context context;
    private final List<Bean.DataBean.PandaliveBean.ListBean> list1;

    public MyAdperdemo(Context context, List<Bean.DataBean.PandaliveBean.ListBean> list2) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.liebiao, null);
            hordle.name= (TextView) convertView.findViewById(R.id.name);
            hordle.tu= (ImageView) convertView.findViewById(R.id.tu);
            convertView.setTag(hordle);

        } else {
            hordle = (ViewHordle) convertView.getTag();
        }
        Glide.with(context).load(list1.get(position).getImage()).error(R.mipmap.ic_launcher).into(hordle.tu);
        hordle.name.setText(list1.get(position).getTitle());
        return convertView;
    }

    class ViewHordle {
        ImageView tu;
        TextView name;
    }
}