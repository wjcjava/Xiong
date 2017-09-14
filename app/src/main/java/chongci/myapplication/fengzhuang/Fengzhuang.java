package chongci.myapplication.fengzhuang;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.Bean.BeanThree;
import chongci.myapplication.Bean.BeanTwo;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Fengzhuang {

    private static volatile Fengzhuang fengzhuang;

    private Handler handler;

    private OkHttpClient client;


    public static Fengzhuang getFengzhuang() {

        if (fengzhuang == null) {

            fengzhuang = new Fengzhuang();

        }

        return fengzhuang;

    }


    public Fengzhuang() {

        this.handler = new Handler();

        this.client = new OkHttpClient();

    }


    public interface GetBeantu {

        void showtu(Bean bean);

    }


    public interface GetBeatxinxi {

        void show(BeanOne bean);

    }
    public interface GetBeanjie{
        void jiexi(BeanTwo beanTwo);

    }
    public interface GetBeanjie1{
        void jiexi1(BeanThree bean);
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

                final Bean bean = gson.fromJson(bb, Bean.class);

                handler.post(new Runnable() {

                    @Override

                    public void run() {

                        getBeantu.showtu(bean);

                    }

                });


            }

        });


    }

    public void jiexi1(String url, final GetBeatxinxi beatxinxi) {

        final Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {

            @Override

            public void onFailure(Call call, IOException e) {


            }


            @Override

            public void onResponse(Call call, Response response) throws IOException {

                String bb = response.body().string();

                Gson gson = new Gson();

                final BeanOne bean = gson.fromJson(bb, BeanOne.class);

                handler.post(new Runnable() {

                    @Override

                    public void run() {

                       beatxinxi.show(bean);

                    }

                });


            }

        });


    }


    public void jiexi3(String url, final GetBeanjie beanjie) {

        final Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {

            @Override

            public void onFailure(Call call, IOException e) {


            }


            @Override

            public void onResponse(Call call, Response response) throws IOException {

                String bb = response.body().string();

                Gson gson = new Gson();

                final BeanTwo bean = gson.fromJson(bb, BeanTwo.class);

                handler.post(new Runnable() {

                    @Override

                    public void run() {

                       beanjie.jiexi(bean);

                    }

                });


            }

        });


    }






















    public void jiexi4(String url, final GetBeanjie1 beanjie1) {

        final Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {

            @Override

            public void onFailure(Call call, IOException e) {


            }


            @Override

            public void onResponse(Call call, Response response) throws IOException {

                String bb = response.body().string();

                Gson gson = new Gson();

                final BeanThree bean = gson.fromJson(bb, BeanThree.class);

                handler.post(new Runnable() {

                    @Override

                    public void run() {

                        beanjie1.jiexi1(bean);

                    }

                });


            }

        });


    }
}