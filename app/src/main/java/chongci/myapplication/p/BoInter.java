package chongci.myapplication.p;


import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.Bean.ImageBean;
import chongci.myapplication.Bean.ScreenBean;
import chongci.myapplication.Bean.WebBean;

/**
 * Created by ASUS on 2017/9/13.
 */

public interface BoInter {
    void getImageBean(String url);
    void getImageBean(ImageBean imageBean);

    void getBoBaoBean(String url);
    void getBoBaoBean(BoBaoBean boBaoBean);

    void getScreenBean(String url);
    void getScreenBean(ScreenBean screenBean);

    void getWebBean(String url);
    void getWebBean(WebBean webBean);
}
