package chongci.myapplication.p;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
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


}
