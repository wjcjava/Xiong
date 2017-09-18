package chongci.myapplication.view.fragment.ChinaFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by a on 2017/9/16.
 */

class FindtabAdapter extends FragmentPagerAdapter{

     private List<String> list_Title;
         private List<TestFm>  list_fragment;                         //fragment列表

         public FindtabAdapter(FragmentManager supportFragmentManager, List<TestFm> list_fragment, List<String> list_title) {
             super(supportFragmentManager);
             this.list_fragment=list_fragment;
             this.list_Title=list_title;
         }


         @Override
         public Fragment getItem(int position) {
             return list_fragment.get(position);
         }

         @Override
         public int getCount() {
             return list_Title.size();
         }

         //此方法用来显示tab上的名字
         @Override
         public CharSequence getPageTitle(int position) {

             return list_Title.get(position % list_Title.size());
         }

}
