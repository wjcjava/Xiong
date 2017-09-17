package chongci.myapplication.model;


import chongci.myapplication.p.BoImpl;

/**
 * Created by ASUS on 2017/9/13.
 */

public interface BaoInter {
    void getImageBea(String url, BoImpl boImplP);

    void getBoBaoBea(String url, BoImpl boImplP);

    void getScreenbea(String url, BoImpl boImplP);
}
