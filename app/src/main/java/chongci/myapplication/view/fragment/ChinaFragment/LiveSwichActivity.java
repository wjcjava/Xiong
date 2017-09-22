package chongci.myapplication.view.fragment.ChinaFragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import chongci.myapplication.R;
import chongci.myapplication.dao.ChangeBeanDao;
import chongci.myapplication.dao.DaoMaster;
import chongci.myapplication.dao.DaoSession;
import chongci.myapplication.widget.MyGridview;


/**
 * Created by a on 2017/9/14.
 */

public class LiveSwichActivity extends BaseActivity {
    TextView tv_long;
int keyi=0;
    Button but_cancel,but_write;
      CustomeGridView sgridview;

    CustomeGridView commom_gridview;
    ChangeBeanDao changeBeanDao;
    private List<ChangeBean> copy_users=new ArrayList<>();
    private List<ChangeBean> users;
    private List<ChangeBean> lala_users;
    private List<ChangeBean> commonusers;
    private List<ChangeBean> copy_commonusers=new ArrayList<>();
    MyChinaGridAdapter myGridAdapter;
    MyChinaGridAdapter2 myGridAdapter2;
    @Override
    protected void initData() {





    }

    @Override
    protected void initView() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "tvxq27.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        changeBeanDao = daoSession.getChangeBeanDao();

        users = changeBeanDao.queryBuilder()
                .where(ChangeBeanDao.Properties.Type.eq("1")).limit(100)
                .build().list();

           copy_users=users;


       commonusers= changeBeanDao.queryBuilder()
                .where(ChangeBeanDao.Properties.Type.eq("")).limit(100)
                .build().list();



        copy_commonusers=commonusers;
        sgridview= (CustomeGridView) findViewById(R.id.gv_onchange);
        commom_gridview= (CustomeGridView) findViewById(R.id.gv_unchange);
        sgridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(keyi==1) {




                    if(copy_users.size()<5){
                        Toast.makeText(LiveSwichActivity.this, "频道的个数不能少于4个偶", Toast.LENGTH_SHORT).show();
                    }else{
                        ChangeBean changeBean=copy_users.get(position);
                        copy_users.remove(changeBean);
                        myGridAdapter.notifyDataSetChanged();

                        copy_commonusers.add(changeBean);
                        myGridAdapter2.notifyDataSetChanged();
                    }

                }
            }
        });
        commom_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(keyi==1){
                    ChangeBean changeBean=copy_commonusers.get(position);
                    copy_commonusers.remove(copy_commonusers.get(position));
                    myGridAdapter2.notifyDataSetChanged();
                    copy_users.add(changeBean);
                    myGridAdapter.notifyDataSetChanged();
                }
            }
        });
           tv_long= (TextView) findViewById(R.id.tv_long);


        but_write= (Button) findViewById(R.id.but_finish);
        but_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  wen=but_write.getText().toString();
                if(wen.equals("编辑")){
                    but_write.setText("完成");
                    tv_long.setText("长按可以排序");
                       keyi=1;

                    myGridAdapter.notifyDataSetChanged();


                }else{
//                     数据库来进行改变
                    for (int d = 0; d <copy_users.size() ; d++) {

                        ChangeBean usero = changeBeanDao.queryBuilder()
                                .where(ChangeBeanDao.Properties.Title.eq(copy_users.get(d).getTitle()))
                                .build().unique();
                        usero.setType("1");
                        changeBeanDao.update(usero);
                    }

                    for (int f = 0; f <copy_commonusers.size() ; f++) {
                         Log.e("gggggggggggg","copy_commonusers.get(f).getTitle()");
                        ChangeBean useroo = changeBeanDao.queryBuilder()
                                .where(ChangeBeanDao.Properties.Title.eq(copy_commonusers.get(f).getTitle()))
                                .build().unique();



                        useroo.setType("");
                        changeBeanDao.update(useroo);
                    }






                        finish();


                }



            }
        });


        myGridAdapter=new MyChinaGridAdapter(this,copy_users);
        sgridview.setAdapter(myGridAdapter);

         myGridAdapter2=new MyChinaGridAdapter2(this,copy_commonusers);
           commom_gridview.setAdapter(myGridAdapter2);
           but_cancel= (Button) findViewById(R.id.live_chinnal_select_channel_cancel);
           but_cancel.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   finish();
               }
           });





    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.liveswich_layout;
    }


}
