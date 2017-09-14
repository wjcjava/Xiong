package chongci.myapplication.p;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;

/**
 * Created by Administrator on 2017/9/13.
 */

public interface Ipersenter {
    void BeanGet(String url);
    void BeanGet(Bean bean);
    void BeanGet1(String url1);
    void BeanGet1(BeanOne beanOne);
}
