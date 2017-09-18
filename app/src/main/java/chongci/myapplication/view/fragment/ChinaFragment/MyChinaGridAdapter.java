package chongci.myapplication.view.fragment.ChinaFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import chongci.myapplication.R;


/**
 * Created by a on 2017/9/16.
 */

public class MyChinaGridAdapter extends BaseAdapter {
    private onCheckListener listener;
    private static HashMap<Integer, Boolean> isSelected;
    ImageView im_oncheck;
    String text;
    LiveSwichActivity liveSwichActivity;
    List<ChangeBean> users;
    public MyChinaGridAdapter(LiveSwichActivity liveSwichActivity, List<ChangeBean> users) {

       this.liveSwichActivity=liveSwichActivity;
        this.users=users;

        isSelected = new HashMap<Integer, Boolean>();
        for (int i = 0; i < users.size(); i++) {
            getIsSelected().put(i, false);
        }


    }

    

    public HashMap<Integer,Boolean> getIsSelected() {
        
        return isSelected;
    }
public void setIsSelected(HashMap<Integer,Boolean> isSelected) {
        MyChinaGridAdapter.isSelected = isSelected;
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
        final ViewHolder viewholder;

           if(convertView==null){
               viewholder=new ViewHolder();
               convertView= LayoutInflater.from(liveSwichActivity).inflate(R.layout.griditem_layout,null);
                viewholder.t_item= (TextView) convertView.findViewById(R.id.text_item);
              viewholder.im_oncheck= (ImageView) convertView.findViewById(R.id.live_china_txt_edig_edit);

               convertView.setTag(viewholder);
           }else{
              viewholder= (ViewHolder) convertView.getTag();
           }

//        viewholder.im_oncheck.setTag(getIsSelected().get(position));
//        viewholder.im_oncheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO 自动生成的方法存根
//                if (isSelected.get(position)) {
//                    isSelected.put(position, false);
//                    setIsSelected(isSelected);
//                } else {
//                    isSelected.put(position, true);
//                    setIsSelected(isSelected);
//                    viewholder.im_oncheck.setVisibility(View.VISIBLE);
//
//                }
//                listener.onCheck(isSelected);
//            }
//
//        });



        viewholder.t_item.setText(users.get(position).getTitle());
             text=liveSwichActivity.but_write.getText().toString();
        if(text.equals("完成")){
            Log.e("lllkkkkkkkk","asdfgdhf");
           viewholder.im_oncheck.setVisibility(View.GONE);
        }





        return convertView;
    }


    public void setListener(onCheckListener listener) {
        this.listener = listener;
    }

    public interface onCheckListener {
        void onCheck(HashMap<Integer, Boolean> map);
    }

    public class ViewHolder{
         TextView  t_item;

        ImageView im_oncheck;
    }

}
