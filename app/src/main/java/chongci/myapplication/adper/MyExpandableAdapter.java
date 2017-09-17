package chongci.myapplication.adper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.R;

/**
 * Created by lenovo on 2017/9/14.
 */
public class MyExpandableAdapter  extends BaseExpandableListAdapter{
    private Context context;
    List<List<String>> childList = new ArrayList<List<String>>();
    List<String> groupList = new ArrayList<String>();

    public MyExpandableAdapter(Context context, List<List<String>> childList, List<String> groupList) {
        this.context = context;
        this.childList = childList;
        this.groupList = groupList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHold1 hold1;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.grouplayout, null);
            hold1 = new ViewHold1();
            hold1.tv = (TextView) convertView.findViewById(R.id.tv_grouptext);
           // hold1.img = (ImageView) convertView.findViewById(R.id.iv_groupimage);
            convertView.setTag(hold1);

        } else {
            hold1 = (ViewHold1) convertView.getTag();
        }

        hold1.tv.setText(groupList.get(groupPosition));
        return convertView;
    }

    static class ViewHold1 {
        TextView tv;
        ImageView img;
    }

    static class ViewHold2 {
        TextView tv;
    }

    @Override

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHold2 hold1;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.childlayout, null);
            hold1 = new ViewHold2();
            hold1.tv = (TextView) convertView.findViewById(R.id.tv_childtext);
            convertView.setTag(hold1);
        } else {
            hold1 = (ViewHold2) convertView.getTag();
        }
        hold1.tv.setText(childList.get(groupPosition).get(childPosition));
        return convertView;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
