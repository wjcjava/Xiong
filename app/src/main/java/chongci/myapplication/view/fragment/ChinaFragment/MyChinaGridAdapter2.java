package chongci.myapplication.view.fragment.ChinaFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chongci.myapplication.R;
import chongci.myapplication.dao.ChangeBeanDao;

/**
 * Created by a on 2017/9/18.
 */

public class MyChinaGridAdapter2 extends BaseAdapter {



    String text;
    LiveSwichActivity liveSwichActivity;
    List<ChangeBean> users;
    ChangeBeanDao changeBeanDao;



    public MyChinaGridAdapter2(LiveSwichActivity liveSwichActivity, List<ChangeBean> users) {

        this.liveSwichActivity=liveSwichActivity;
        this.users=users;



    }




    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        VViewHolder vviewholder= null ;

            if (convertView == null) {
                vviewholder = new VViewHolder();

                convertView = LayoutInflater.from(liveSwichActivity).inflate(R.layout.griditemm_layout, null);

                vviewholder.vt_item = (TextView) convertView.findViewById(R.id.text_itemm);


                convertView.setTag(vviewholder);
            } else {
                vviewholder = (VViewHolder) convertView.getTag();
            }





        vviewholder.vt_item.setText(users.get(position).getTitle());



        return convertView;
    }





    public class VViewHolder{
        TextView  vt_item;

    }
}
