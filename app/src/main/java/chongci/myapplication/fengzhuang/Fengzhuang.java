package chongci.myapplication.fengzhuang;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;

import chongci.myapplication.Bean.Bean;
import chongci.myapplication.Bean.BeanOne;
import chongci.myapplication.Bean.BeanThree;
import chongci.myapplication.Bean.BeanTwo;
import chongci.myapplication.Bean.ChatBean;
import chongci.myapplication.Bean.GunGunBean;
import chongci.myapplication.Bean.LiveBean;
import chongci.myapplication.Bean.LiveEyesBean;
import chongci.myapplication.Bean.LiveIndexBean;
import chongci.myapplication.Bean.LiveVedioItemBean;
import chongci.myapplication.Bean.LiveVideoBean;
import chongci.myapplication.Bean.WenhuaBean;
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

    public interface GetBeanjie {
        void jiexi(BeanTwo beanTwo);

    }

    public interface GetBeanjie1 {
        void jiexi1(BeanThree bean);
    }

    public interface GetLiveBean {
        void show(LiveBean bean);
    }

    public interface GetLiveIndexBean {
        void show(LiveIndexBean bean);
    }

    public interface GetLiveEyesBean {
        void show(LiveEyesBean bean);
    }

    public interface GetChatBean {
        void show(ChatBean bean);
    }


    public interface WenHuanBean {
        void wenhuajiexi(WenhuaBean wenhaBean);
    }

    public interface GunGunBeanl {
        void gugunjiexi(GunGunBean gunBean);
    }
    public interface GetLiveVedioBean{
        void show(LiveVideoBean bean);
    }
    public interface GetLiveVedioItemBean{
        void show(LiveVedioItemBean bean);
    }
    public void GunGunjiexi(String url, final GunGunBeanl gunBeanl) {

        final Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {

            @Override

            public void onFailure(Call call, IOException e) {


            }


            @Override

            public void onResponse(Call call, Response response) throws IOException {

                String bb = response.body().string();

                Gson gson = new Gson();

                final GunGunBean bean = gson.fromJson(bb, GunGunBean.class);

                handler.post(new Runnable() {

                    @Override

                    public void run() {
                        gunBeanl.gugunjiexi(bean);


                    }

                });


            }

        });


    }

    public void wenhuajiexi(String url, final WenHuanBean wenHuanBean) {

        final Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {

            @Override

            public void onFailure(Call call, IOException e) {


            }


            @Override

            public void onResponse(Call call, Response response) throws IOException {

                String bb = response.body().string();

                Gson gson = new Gson();

                final WenhuaBean bean = gson.fromJson(bb, WenhuaBean.class);

                handler.post(new Runnable() {

                    @Override

                    public void run() {

                        wenHuanBean.wenhuajiexi(bean);

                    }

                });


            }

        });


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


    public void parthlive(String url, final GetLiveBean liveBean) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bb = response.body().string();
                Gson gson = new Gson();
                final LiveBean bean = gson.fromJson(bb, LiveBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        liveBean.show(bean);
                    }
                });
            }
        });
    }


    public void parseIndexBean(String url, final GetLiveIndexBean indexbean) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bb = response.body().string();
                Gson gson = new Gson();
                final LiveIndexBean bean = gson.fromJson(bb, LiveIndexBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        indexbean.show(bean);
                    }
                });
            }
        });
    }

    public void parseEyesBean(String url, final GetLiveEyesBean eyesBean) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bb = response.body().string();
                Gson gson = new Gson();
                final LiveEyesBean bean = gson.fromJson(bb, LiveEyesBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        eyesBean.show(bean);
                    }
                });
            }
        });
    }


    public void parseChatBean(String url, final GetChatBean chatBean) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bb = response.body().string();
                Gson gson = new Gson();
                final ChatBean bean = gson.fromJson(bb, ChatBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        chatBean.show(bean);
                    }
                });
            }
        });
    }


    public void parseVedioBean(String url, final GetLiveVedioBean vedioBean) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bb = response.body().string();
                Gson gson = new Gson();
                final LiveVideoBean bean = gson.fromJson(bb, LiveVideoBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        vedioBean.show(bean);
                    }
                });
            }
        });
    }


    public void parseVedioItemBean(String url, final GetLiveVedioItemBean vedioItemBean) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bb = response.body().string();
                Gson gson = new Gson();
                final LiveVedioItemBean bean = gson.fromJson(bb, LiveVedioItemBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        vedioItemBean.show(bean);
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