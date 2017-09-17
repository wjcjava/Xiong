package chongci.myapplication.p;


import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.Bean.ImageBean;
import chongci.myapplication.Bean.ScreenBean;
import chongci.myapplication.model.BaoImpl;
import chongci.myapplication.view.BoBaoInter;
import chongci.myapplication.view.fragment.ZhiboFragment;

/**
 * Created by ASUS on 2017/9/13.
 */

public class BoImpl implements BoInter {
    private BoBaoInter boBaoInterV;
    private BaoImpl baoImplM;
    public BoImpl(ZhiboFragment boBaoInter) {
        this.boBaoInterV = boBaoInter;
        baoImplM = new BaoImpl();
    }

    /**
     * 图片
     * @param url
     */
    @Override
    public void getImageBean(String url) {
        baoImplM.getImageBea(url,this);
    }

    @Override
    public void getImageBean(ImageBean imageBean) {
        boBaoInterV.onSuccess(imageBean);
    }

    /**
     * recyclerView
     * @param url
     */
    @Override
    public void getBoBaoBean(String url) {
        baoImplM.getBoBaoBea(url,this);
    }

    @Override
    public void getBoBaoBean(BoBaoBean boBaoBean) {
        boBaoInterV.onSuccess(boBaoBean);
    }

    /**
     * 视屏播放
     * @param url
     */
    @Override
    public void getScreenBean(String url) {
        baoImplM.getScreenbea(url,this);
    }

    @Override
    public void getScreenBean(ScreenBean screenBean) {
        boBaoInterV.onSuccess(screenBean);
    }
}
