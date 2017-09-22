package chongci.myapplication.view.fragment.ChinaFragment;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

import chongci.myapplication.R;


/**
 * Created by a on 2017/9/16.
 */

public class MyChinaGridAdapter extends BaseAdapter {
    String text;
    LiveSwichActivity liveSwichActivity;
    List<ChangeBean> users;
    public MyChinaGridAdapter(LiveSwichActivity liveSwichActivity, List<ChangeBean> users) {
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
        ViewHolder viewholder;


            Log.e("aaaaaaaaaaaa","asdfghjklkhjhghjk");
            if (convertView == null) {
                viewholder = new ViewHolder();
                convertView = LayoutInflater.from(liveSwichActivity).inflate(R.layout.griditem_layout, null);
                viewholder.t_item = (TextView) convertView.findViewById(R.id.text_ite);
                viewholder.im_oncheck = (ImageView) convertView.findViewById(R.id.live_china_txt_edig_edit);

                convertView.setTag(viewholder);
            } else {
                viewholder = (ViewHolder) convertView.getTag();
            }




        viewholder.t_item.setText(users.get(position).getTitle());
             text=liveSwichActivity.but_write.getText().toString();
          if(text.equals("完成")){
            viewholder.im_oncheck.setVisibility(View.VISIBLE);
        }





        return convertView;
    }




    public class ViewHolder{
         TextView  t_item;
        ImageView im_oncheck;
    }

}
