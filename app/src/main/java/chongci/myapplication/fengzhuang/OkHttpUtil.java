package chongci.myapplication.fengzhuang;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;

import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.Bean.ImageBean;
import chongci.myapplication.Bean.ScreenBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ASUS on 2017/9/13.
 */

public class OkHttpUtil {
    private static OkHttpUtil util;
    private OkHttpClient client;
    private Handler handler;
    private OkHttpUtil(){
        client = new OkHttpClient();
        handler = new Handler();
    }

    public static synchronized OkHttpUtil getUtil(){
        if(util == null){
            util = new OkHttpUtil();
        }
        return util;
    }

    /**
     * 图片
     */
    public interface GetBeantu {
        void showtu(ImageBean imageBean);
    }

    public void SendGet(String url, final GetBeantu getBeantu) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final ImageBean bean = gson.fromJson(string, ImageBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getBeantu.showtu(bean);
                    }
                });

            }
        });
    }


    /**
     * recyclerView
     */
    public interface GetBeantu1 {
        void showtu(BoBaoBean boBaoBean);
    }
    public void SendGet1(String url, final GetBeantu1 getBeantu1) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final BoBaoBean boBaoBean = gson.fromJson(string, BoBaoBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getBeantu1.showtu(boBaoBean);
                    }
                });

            }
        });
    }

    /**
     * 视屏播放
     */
    public interface GetBeantu2 {
        void showtu(ScreenBean screenBean);
    }
    public void SendGet2(String url, final GetBeantu2 getBeantu2) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final ScreenBean screenBean = gson.fromJson(string, ScreenBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getBeantu2.showtu(screenBean);
                    }
                });

            }
        });
    }
}
