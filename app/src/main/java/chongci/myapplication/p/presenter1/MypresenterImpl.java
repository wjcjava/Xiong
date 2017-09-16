package chongci.myapplication.p.presenter1;

import chongci.myapplication.model.model1.MyModel;
import chongci.myapplication.model.model1.MyModelimpl;
import chongci.myapplication.view.VoidView;
import chongci.myapplication.voidbean.JingCaiBean;
import chongci.myapplication.voidbean.PanPanBean;

/**
 * Created by Administrator on 2017/9/15.
 */

public class MypresenterImpl implements Mypresenter{
    private VoidView voidView;
    private MyModel myModel;

    public MypresenterImpl(VoidView voidView) {
        this.voidView = voidView;
        myModel=new MyModelimpl();
    }

    @Override
    public void qingqiu(String url) {
        myModel.qingqiushuju(url,this);
    }

    @Override
    public void qingqiu(PanPanBean panBean) {
        voidView.chenggong1(panBean);
    }

    @Override
    public void qingqiu1(String url1) {
        myModel.qingqiushuju1(url1,this);
    }

    @Override
    public void qingqiu1(JingCaiBean jingCaiBean) {
        voidView.chenggong3(jingCaiBean);
    }
}
