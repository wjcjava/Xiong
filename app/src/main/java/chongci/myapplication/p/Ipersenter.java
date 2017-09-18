package chongci.myapplication.p;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.Bean.BeanThree;
import chongci.myapplication.Bean.BeanTwo;
import chongci.myapplication.Bean.GunGunBean;
import chongci.myapplication.Bean.WenhuaBean;

/**
 * Created by Administrator on 2017/9/13.
 */

public interface Ipersenter {
    void BeanGet(String url);
    void BeanGet(Bean bean);

    void BeanGet1(String url1);
    void BeanGet1(BeanOne beanOne);

    void BeanGet2(String url2);
    void BeanGet2(BeanTwo beanTwo);

    void BeanGet3(String url3);
    void BeanGet3(BeanThree beanThree);

    void BeanWenHua(String url4);
    void BeanWenHua(WenhuaBean wenHuaBean);

    void BeanGunGun(String url5);
    void BeanGunGun(GunGunBean gunBean);
}
