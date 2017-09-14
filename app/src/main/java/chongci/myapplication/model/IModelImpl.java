package chongci.myapplication.model;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.fengzhuang.Fengzhuang;
import chongci.myapplication.p.PresenterImpl;

/**
 * Created by Administrator on 2017/9/13.
 */

public class IModelImpl implements IModel {



    @Override
    public void BeanGet(String url, final PresenterImpl presenter) {
        Fengzhuang.getFengzhuang().jiexi(url, new Fengzhuang.GetBeantu() {
            @Override
            public void showtu(Bean bean) {
                presenter.BeanGet(bean);
            }
        });
    }

    @Override
    public void BeanGet1(String url, final PresenterImpl presenter) {
       Fengzhuang.getFengzhuang().jiexi1(url, new Fengzhuang.GetBeatxinxi() {
           @Override
           public void show(BeanOne bean) {
               presenter.BeanGet1(bean);
           }
       });
    }
}
