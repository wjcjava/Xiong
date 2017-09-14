package chongci.myapplication.p;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.Bean.BeanThree;
import chongci.myapplication.Bean.BeanTwo;
import chongci.myapplication.model.IModelImpl;
import chongci.myapplication.view.IView;

/**
 * Created by Administrator on 2017/9/13.
 */

public class PresenterImpl implements Ipersenter {

    private IView iView;
    private IModelImpl iModel;

    public PresenterImpl(IView iView) {
        this.iView = iView;
        iModel = new IModelImpl();
    }

    @Override
    public void BeanGet(String url) {
        iModel.BeanGet(url, this);


    }

    @Override
    public void BeanGet(Bean bean) {
        iView.OnSuccess(bean);
    }

    @Override
    public void BeanGet1(String url1) {
        iModel.BeanGet1(url1,this);
    }

    @Override
    public void BeanGet1(BeanOne beanOne) {
        iView.OnSuccess(beanOne);
    }

    @Override
    public void BeanGet2(String url2) {
        iModel.BeanGet2(url2,this);
    }

    @Override
    public void BeanGet2(BeanTwo beanTwo) {
        iView.OnSuccecc(beanTwo);
    }

    @Override
    public void BeanGet3(String url3) {
        iModel.BeanGet3(url3,this);
    }

    @Override
    public void BeanGet3(BeanThree beanThree) {
        iView.OnSuccecc(beanThree);
    }


}
