package chongci.myapplication.dao;

import android.content.Context;

/**
 * Created by ASUS on 2017/9/5.
 */

public class GreenDaoUtil {
    private static GreenDaoUtil dianli;
    private GreenDaoBeanDao userDao;

    public static GreenDaoUtil getDianli() {
        if (dianli == null) {
            dianli = new GreenDaoUtil();
        }
        return dianli;
    }

    interface Danli {
        void huoqu(String string);
    }

    public GreenDaoBeanDao shujudanli(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "dent.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getGreenDaoBeanDao();
        return userDao;
    }
}