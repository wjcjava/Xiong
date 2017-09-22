package chongci.myapplication.fengzhuang;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;

import chongci.myapplication.adper.TobGunGunxiubean;
import chongci.myapplication.voidbean.JingCaiBean;
import chongci.myapplication.voidbean.PanPanBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Fengzhuang1 {
    private static volatile Fengzhuang1 fengzhuang;
    private Handler handler;
    private OkHttpClient client;
    public static Fengzhuang1 getFengzhuang() {
        if (fengzhuang == null) {
            fengzhuang = new Fengzhuang1();
        }
        return fengzhuang;
    }

    public Fengzhuang1() {
        this.handler = new Handler();
        this.client = new OkHttpClient();
    }

    public interface GetBeantu {
        void showtu(PanPanBean panBean);
    }

    public interface GetBeantu1 {
        void showtu1(JingCaiBean jingCaiBean);
    }

    public interface Gungun{
      void   gungunjiexi(TobGunGunxiubean gunxiubean);
    }

    public void jiexi(String url, final GetBeantu getBeantu) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bb = response.body().string();
                Gson gson = new Gson();
                final PanPanBean bean = gson.fromJson(bb,PanPanBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getBeantu.showtu(bean);
                    }
                });
            }
        });
    }
    public void jiexi1(String url, final GetBeantu1 getBeantu1) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String bb = response.body().string();

                Gson gson = new Gson();

                final JingCaiBean bean = gson.fromJson(bb,JingCaiBean.class);

                handler.post(new Runnable() {

                    @Override

                    public void run() {

                        getBeantu1.showtu1(bean);
                    }
                });
            }
        });
    }

    public void gunxiujiexi(String url, final Gungun gungun) {

        final Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bb = response.body().string();
                Gson gson = new Gson();
                final TobGunGunxiubean bean = gson.fromJson(bb,TobGunGunxiubean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gungun.gungunjiexi(bean);
                    }
                });
            }
        });
    }
}