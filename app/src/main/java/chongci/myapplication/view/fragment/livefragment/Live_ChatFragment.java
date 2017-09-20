package chongci.myapplication.view.fragment.livefragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import chongci.myapplication.Bean.ChatBean;
import chongci.myapplication.R;
import chongci.myapplication.adper.MyChatAdapter;
import chongci.myapplication.fengzhuang.Fengzhuang;
import chongci.myapplication.view.fragment.livefragment.base.BaseFragment;
import chongci.myapplication.widget.ClearEditText;
import chongci.myapplication.widget.MyXListView;

import static chongci.myapplication.R.id.lpanda_watcktalk_listview;

/**
 * A simple {@link Fragment} subclass.
 */
public class Live_ChatFragment extends BaseFragment {


    private Button send;
    private ClearEditText et_input;
    private MyXListView listView;
    private List<ChatBean.DataBean.ContentBean> list= new ArrayList<>();
    private MyChatAdapter adapter;
    int page;
    private String comment;

    @Override
    protected void initData() {
        String url="http://newcomment.cntv.cn/comment/list?prepage=20&app=ipandaApp&itemid=zhiboye_chat&nature=1&page="+page;
        Fengzhuang.getFengzhuang().parseChatBean(url, new Fengzhuang.GetChatBean() {
            @Override
            public void show(ChatBean bean) {
                list.addAll(bean.getData().getContent());
                adapter.notifyDataSetChanged();
            }
        });
        adapter = new MyChatAdapter(getActivity(),list);
        listView.setAdapter(adapter);



    }

    @Override
    protected void initView(View view) {
            send= (Button) view.findViewById(R.id.lpanda_btn);
        et_input= (ClearEditText) view.findViewById(R.id.lpanda_input);
        listView= (MyXListView) view.findViewById(lpanda_watcktalk_listview);
        listView.setXListViewListener(new MyXListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                page=1;
                initData();
            }

            @Override
            public void onLoadMore() {
                page++;
                initData();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comment = et_input.getText().toString().trim();
                ChatBean.DataBean.ContentBean bean=new ChatBean.DataBean.ContentBean();
                bean.setMessage(comment);
                String author = list.get(0).getAuthor();
                bean.setAuthor(author);
                list.add(0,bean);
                adapter.notifyDataSetChanged();
                et_input.setText("");
                InputMethodManager inputMethodManager =
                        (InputMethodManager)getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(et_input.getWindowToken(), 0);
            }
        });
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_live__chat;
    }


}
