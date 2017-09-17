package chongci.myapplication.view;


import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.Bean.ImageBean;
import chongci.myapplication.Bean.ScreenBean;

/**
 * Created by ASUS on 2017/9/13.
 */

public interface BoBaoInter {
    void onSuccess(ImageBean imageBean);

    void onSuccess(BoBaoBean boBaoBean);

    void onSuccess(ScreenBean screenBean);
}
