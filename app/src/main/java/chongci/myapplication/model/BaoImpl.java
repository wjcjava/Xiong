package chongci.myapplication.model;


import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.Bean.ImageBean;
import chongci.myapplication.Bean.ScreenBean;
import chongci.myapplication.Bean.WebBean;
import chongci.myapplication.fengzhuang.OkHttpUtil;
import chongci.myapplication.p.BoImpl;

/**
 * Created by ASUS on 2017/9/13.
 */

public class BaoImpl implements BaoInter {
    @Override
    public void getImageBea(String url, final BoImpl boImplP) {
        OkHttpUtil.getUtil().SendGet(url, new OkHttpUtil.GetBeantu() {
            @Override
            public void showtu(ImageBean imageBean) {
                boImplP.getImageBean(imageBean);
            }
        });
    }

    @Override
    public void getBoBaoBea(String url, final BoImpl boImplP) {
        OkHttpUtil.getUtil().SendGet1(url, new OkHttpUtil.GetBeantu1() {
            @Override
            public void showtu(BoBaoBean boBaoBean) {
                boImplP.getBoBaoBean(boBaoBean);
            }
        });
    }

    @Override
    public void getScreenbea(String url, final BoImpl boImplP) {
        OkHttpUtil.getUtil().SendGet2(url, new OkHttpUtil.GetBeantu2() {
            @Override
            public void showtu(ScreenBean screenBean) {
                boImplP.getScreenBean(screenBean);
            }
        });
    }

    @Override
    public void getWebBea(String url, final BoImpl boImplP) {
        OkHttpUtil.getUtil().SendGet3(url, new OkHttpUtil.GetBeantu3() {
            @Override
            public void showtu(WebBean webBean) {
                boImplP.getWebBean(webBean);
            }
        });
    }
}
