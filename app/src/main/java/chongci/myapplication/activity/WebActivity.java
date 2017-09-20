package chongci.myapplication.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.utils.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.Bean.ImageBean;
import chongci.myapplication.Bean.ScreenBean;
import chongci.myapplication.Bean.WebBean;
import chongci.myapplication.R;
import chongci.myapplication.p.BoImpl;
import chongci.myapplication.view.BoBaoInter;

public class WebActivity extends AppCompatActivity implements View.OnClickListener, BoBaoInter {

    private ImageView back_iv;
    private ImageView shoucang_iv;
    private ImageView fenxiang_iv;
    private int CODE_FOR_WRITE_PERMISSION = 0;
    private ArrayList<BoBaoBean.ListBean> list;
    private ArrayList<WebBean> webBee = new ArrayList<>();
    private String url;
    private int pos;
    private int count = 1;
    private TextView title_tv;
    private TextView name_tv;
    private TextView time_tv;
    private TextView content_tv;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
        initData();
    }

    private void initView() {
        back_iv = (ImageView) findViewById(R.id.back_iv);
        shoucang_iv = (ImageView) findViewById(R.id.shoucang_iv);
        fenxiang_iv = (ImageView) findViewById(R.id.fenxiang_iv);

        back_iv.setOnClickListener(this);
        shoucang_iv.setOnClickListener(this);
        fenxiang_iv.setOnClickListener(this);
        title_tv = (TextView) findViewById(R.id.title_tv);
        title_tv.setOnClickListener(this);
        name_tv = (TextView) findViewById(R.id.name_tv);
        name_tv.setOnClickListener(this);
        time_tv = (TextView) findViewById(R.id.time_tv);
        time_tv.setOnClickListener(this);
        content_tv = (TextView) findViewById(R.id.content_tv);
        content_tv.setOnClickListener(this);
    }

    private void initData() {
        url = getIntent().getStringExtra("url");
        list = (ArrayList<BoBaoBean.ListBean>) getIntent().getSerializableExtra("list");
        pos = getIntent().getIntExtra("pos", 0);

        BoImpl boImplP = new BoImpl(this);
        boImplP.getWebBean("http://api.cntv.cn/article/contentinfo?id="+ list.get(pos).getId()+"&serviceId=panda");
        check();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.shoucang_iv:
                shoucang_iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (count == 0) {
                            shoucang_iv.setImageResource(R.drawable.collect_yes);
                            count = 1;
                            Toast.makeText(WebActivity.this, "已添加到收藏", Toast.LENGTH_SHORT).show();
                        } else {
                            shoucang_iv.setImageResource(R.drawable.collect_no);
                            count = 0;
                            Toast.makeText(WebActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.fenxiang_iv:
                View views = View.inflate(WebActivity.this, R.layout.item_popup, null);
                final PopupWindow popupWindow = new PopupWindow(views, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(4));
                popupWindow.setOutsideTouchable(true);
                int[] location = new int[2];
                popupWindow.showAtLocation(fenxiang_iv, Gravity.BOTTOM, 0, location[1] - popupWindow.getHeight());

                ImageView qqIv = (ImageView) views.findViewById(R.id.qq_iv);
                qqIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UMImage thumb = new UMImage(WebActivity.this, list.get(pos).getPicurl());
                        UMWeb web = new UMWeb(url);
                        web.setThumb(thumb);
                        web.setTitle(list.get(pos).getTitle());
                        new ShareAction(WebActivity.this)
                                .setPlatform(SHARE_MEDIA.QQ)
                                .withMedia(web)
                                .setCallback(umShareListener)
                                .share();
                    }
                });
                ImageView weixinIv = (ImageView) views.findViewById(R.id.weixin_iv);
                weixinIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UMImage thumb = new UMImage(WebActivity.this, list.get(pos).getPicurl());
                        UMWeb web = new UMWeb(url);
                        web.setThumb(thumb);
                        web.setTitle(list.get(pos).getTitle());
                        new ShareAction(WebActivity.this)
                                .setPlatform(SHARE_MEDIA.WEIXIN)
                                .withMedia(web)
                                .setCallback(umShareListener)
                                .share();
                    }
                });
                ImageView sinaIv = (ImageView) views.findViewById(R.id.sina_iv);
                sinaIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UMImage thumb = new UMImage(WebActivity.this, list.get(pos).getPicurl());
                        UMWeb web = new UMWeb(url);
                        web.setThumb(thumb);
                        web.setTitle(list.get(pos).getTitle());
                        new ShareAction(WebActivity.this)
                                .setPlatform(SHARE_MEDIA.SINA)
                                .withMedia(web)
                                .setCallback(umShareListener)
                                .share();
                    }
                });
                break;
        }
    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);

            Toast.makeText(WebActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(WebActivity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(WebActivity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

    public void check() {

        int hasWriteContactsPermission = ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION);
        int hasGrantedPermission = ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //这个判断是用来审验是否获取了权限
        if (hasGrantedPermission == PackageManager.PERMISSION_GRANTED && hasWriteContactsPermission == PackageManager.PERMISSION_GRANTED) {
            //已经获取了权限不需要再次申请，可以直接在这里进行你需要的操作

        }//需要弹出dialog让用户手动赋予权限
        else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION}, CODE_FOR_WRITE_PERMISSION);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 200:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    //申请权限成功在这里做操作
                } else {
                }
                return;
        }
    }

    @Override
    public void onSuccess(ImageBean imageBean) {

    }

    @Override
    public void onSuccess(BoBaoBean boBaoBean) {

    }

    @Override
    public void onSuccess(ScreenBean screenBean) {

    }

    @Override
    public void onSuccess(WebBean webBean) {
        webBee.add(webBean);
        String title = webBean.getTitle();
        String pubtime = webBean.getPubtime();
        String name = webBean.getSource();
        final String content = webBean.getContent();
        time_tv.setText(pubtime);
        title_tv.setText(title);
        name_tv.setText(name);

        content_tv.setMovementMethod(ScrollingMovementMethod.getInstance());// 滚动
        // TODO Auto-generated method stub
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                if (msg.what == 0x101) {
                    content_tv.setText((CharSequence) msg.obj);
                }
                super.handleMessage(msg);
            }
        };

        // 因为从网上下载图片是耗时操作 所以要开启新线程
        Thread t = new Thread(new Runnable() {
            Message msg = Message.obtain();

            @Override
            public void run() {
                // TODO Auto-generated method stub
                /**
                 * 要实现图片的显示需要使用Html.fromHtml的一个重构方法：public static Spanned
                 * fromHtml (String source, Html.ImageGetterimageGetter,
                 * Html.TagHandler
                 * tagHandler)其中Html.ImageGetter是一个接口，我们要实现此接口，在它的getDrawable
                 * (String source)方法中返回图片的Drawable对象才可以。
                 */
                Html.ImageGetter imageGetter = new Html.ImageGetter() {

                    @Override
                    public Drawable getDrawable(String source) {
                        // TODO Auto-generated method stub
                        URL url;
                        Drawable drawable = null;
                        try {
                            url = new URL(source);
                            drawable = Drawable.createFromStream(url.openStream(), null);
                            drawable.setBounds(20, 0, 900, 600);
                        } catch (MalformedURLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        return drawable;
                    }
                };
                CharSequence test = Html.fromHtml(content, imageGetter, null);
                msg.what = 0x101;
                msg.obj = test;
                handler.sendMessage(msg);
            }
        });
        t.start();

    }
}
