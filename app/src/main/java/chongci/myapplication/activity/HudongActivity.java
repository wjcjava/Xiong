package chongci.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.Bean.BeanThree;
import chongci.myapplication.Bean.BeanTwo;
import chongci.myapplication.R;
import chongci.myapplication.adper.MyAdperdemo4;
import chongci.myapplication.p.PresenterImpl;
import chongci.myapplication.view.IView;

public class HudongActivity extends AppCompatActivity implements IView {
    private List<BeanThree.InteractiveBean> list = new ArrayList<>();
    private ListView listview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hudong);
        initView();
        initDate();
    }

    private void initDate() {
        PresenterImpl presenter = new PresenterImpl(this);
        presenter.BeanGet3("http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json");
    }

    @Override
    public void OnSuccess(Bean bean) {

    }

    @Override
    public void OnSuccess(BeanOne beanOne) {

    }

    @Override
    public void OnSuccecc(BeanTwo beanTwo) {

    }

    @Override
    public void OnSuccecc(BeanThree beanThree) {
        list.addAll(beanThree.getInteractive());
        final MyAdperdemo4 adperdemo4 = new MyAdperdemo4(HudongActivity.this, list);
        listview1.setAdapter(adperdemo4);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adperdemo4.notifyDataSetChanged();
            }
        });

    }

    private void initView() {
        listview1 = (ListView) findViewById(R.id.listview1);
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(HudongActivity.this,HtmlActivity.class);
                intent.putExtra("hrml",list.get(i).getUrl());
                startActivity(intent);
            }
        });
    }
}
