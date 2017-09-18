package chongci.myapplication.model;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.Bean.BeanThree;
import chongci.myapplication.Bean.BeanTwo;
import chongci.myapplication.Bean.GunGunBean;
import chongci.myapplication.Bean.WenhuaBean;
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

    @Override
    public void BeanGet2(String url, final PresenterImpl presenter) {
        Fengzhuang.getFengzhuang().jiexi3(url, new Fengzhuang.GetBeanjie() {
            @Override
            public void jiexi(BeanTwo beanTwo) {
                presenter.BeanGet2(beanTwo);
            }
        });
    }

    @Override
    public void BeanGet3(String url, final PresenterImpl presenter) {
        Fengzhuang.getFengzhuang().jiexi4(url, new Fengzhuang.GetBeanjie1() {
            @Override
            public void jiexi1(BeanThree bean) {
                presenter.BeanGet3(bean);
            }
        });
    }

    @Override
    public void BeanWenHuan(String url, final PresenterImpl presenter) {
        Fengzhuang.getFengzhuang().wenhuajiexi(url, new Fengzhuang.WenHuanBean() {
            @Override
            public void wenhuajiexi(WenhuaBean wenhaBean) {
                presenter.BeanWenHua(wenhaBean);
            }
        });
    }

    @Override
    public void BeanGunGun(String url, final PresenterImpl presenter) {
        Fengzhuang.getFengzhuang().GunGunjiexi(url, new Fengzhuang.GunGunBeanl() {
            @Override
            public void gugunjiexi(GunGunBean gunBean) {
                presenter.BeanGunGun(gunBean);
            }
        });
    }
}
