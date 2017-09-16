package chongci.myapplication.model.model1;

import chongci.myapplication.fengzhuang.Fengzhuang1;
import chongci.myapplication.p.presenter1.Mypresenter;
import chongci.myapplication.voidbean.JingCaiBean;
import chongci.myapplication.voidbean.PanPanBean;

/**
 * Created by Administrator on 2017/9/15.
 */

public class MyModelimpl implements MyModel{
    @Override
    public void qingqiushuju(String url, final Mypresenter mypresenter) {
        Fengzhuang1.getFengzhuang().jiexi(url, new Fengzhuang1.GetBeantu() {
            @Override
            public void showtu(PanPanBean panBean) {
            mypresenter.qingqiu(panBean);
            }
        });
    }

    @Override
    public void qingqiushuju1(String url1, final Mypresenter mypresenter) {
        Fengzhuang1.getFengzhuang().jiexi1(url1, new Fengzhuang1.GetBeantu1() {
            @Override
            public void showtu1(JingCaiBean jingCaiBean) {
                mypresenter.qingqiu1(jingCaiBean);
            }
        });
    }

}
