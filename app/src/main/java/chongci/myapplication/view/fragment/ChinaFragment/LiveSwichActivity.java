package chongci.myapplication.view.fragment.ChinaFragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.HashMap;
import java.util.List;

import chongci.myapplication.R;


/**
 * Created by a on 2017/9/14.
 */

public class LiveSwichActivity extends BaseActivity implements MyChinaGridAdapter.onCheckListener {

    Button but_cancel,but_write;
      GridView sgridview,commom_gridview;
    ChangeBeanDao changeBeanDao;
    private List<ChangeBean> users;
    private List<ChangeBean> commonusers;
    MyChinaGridAdapter myGridAdapter,myGridAdapter2;
    @Override
    protected void initData() {





    }

    @Override
    protected void initView() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "tvxq7.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        changeBeanDao = daoSession.getChangeBeanDao();

        users = changeBeanDao.queryBuilder()
                .where(ChangeBeanDao.Properties.Type.eq("1")).limit(100)
                .build().list();

       commonusers= changeBeanDao.queryBuilder()
                .where(ChangeBeanDao.Properties.Type.eq("")).limit(100)
                .build().list();
        Log.e("aaaaaaa=======",commonusers.size()+"dfghjkkfghjk");

        sgridview= (GridView) findViewById(R.id.gv_onchange);
        commom_gridview= (GridView) findViewById(R.id.gv_unchange);
        sgridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  users.clear();
                    users = changeBeanDao.queryBuilder()
                        .where(ChangeBeanDao.Properties.Type.eq("1")).limit(100)
                        .build().list();
                myGridAdapter=new MyChinaGridAdapter(LiveSwichActivity.this,users);
                sgridview.setAdapter(myGridAdapter);




            }
        });
        commom_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChangeBean user = changeBeanDao.queryBuilder()
                        .where(ChangeBeanDao.Properties.Title.eq(commonusers.get(position).getTitle()))
                        .build().unique();
                user.setType("1");
                changeBeanDao.update(user);

                commonusers.remove(user);
               myGridAdapter2.notifyDataSetChanged();
                users.add(user);
                myGridAdapter.notifyDataSetChanged();

            }
        });







        but_write= (Button) findViewById(R.id.but_finish);
        but_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  wen=but_write.getText().toString();
                if(wen.equals("编辑")){
                    but_write.setText("完成");

                    for (int i = 0; i < users.size(); i++) {
                        myGridAdapter.getIsSelected().put(i, true);
                    }

                         myGridAdapter.notifyDataSetChanged();


                }else{

                    but_write.setText("编辑");


                }



            }
        });


        myGridAdapter=new MyChinaGridAdapter(this,users);
        sgridview.setAdapter(myGridAdapter);

  myGridAdapter2=new MyChinaGridAdapter(this,commonusers);
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

    @Override
    public void onCheck(HashMap<Integer, Boolean> map) {

    }
}
