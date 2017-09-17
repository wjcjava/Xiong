package chongci.myapplication.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.utils.Log;

import java.util.ArrayList;

import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.R;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back_iv;
    private ImageView shoucang_iv;
    private ImageView fenxiang_iv;
    private WebView webView;
    private int CODE_FOR_WRITE_PERMISSION = 0;
    private ArrayList<BoBaoBean.ListBean> list;
    private String url;
    private int pos;
    private int count = 1;

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
        webView = (WebView) findViewById(R.id.webView);

        back_iv.setOnClickListener(this);
        shoucang_iv.setOnClickListener(this);
        fenxiang_iv.setOnClickListener(this);
    }

    private void initData() {
        url = getIntent().getStringExtra("url");
        list = (ArrayList<BoBaoBean.ListBean>) getIntent().getSerializableExtra("list");
        pos = getIntent().getIntExtra("pos", 0);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        /*settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        settings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        settings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        settings.setDisplayZoomControls(false); //隐藏原生的缩放控件*/
        settings.setDefaultTextEncodingName("utf-8");
        webView.loadUrl(url);

        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSupportZoom(true);  //支持缩放
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 16) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        String ua = settings.getUserAgentString();
        settings.setUserAgentString(ua + ";cntv_app_client_pandaandroid_mobile");

        check();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_iv:
                finish();
                break;
            case R.id.shoucang_iv:
                shoucang_iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(count == 0){
                            shoucang_iv.setImageResource(R.drawable.collect_yes);
                            count = 1;
                            Toast.makeText(WebActivity.this,"已添加到收藏",Toast.LENGTH_SHORT).show();
                        }else {
                            shoucang_iv.setImageResource(R.drawable.collect_no);
                            count = 0;
                            Toast.makeText(WebActivity.this,"已取消收藏",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.fenxiang_iv:
                View views = View.inflate(WebActivity.this, R.layout.item_popup, null);
                final PopupWindow popupWindow=new PopupWindow(views, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(4));
                popupWindow.setOutsideTouchable(true);
                int[] location = new int[2];
                webView.getLocationOnScreen(location);
                popupWindow.showAtLocation(webView, Gravity.BOTTOM, 0, location[1]-popupWindow.getHeight());

                ImageView qqIv = (ImageView) views.findViewById(R.id.qq_iv);
                qqIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UMImage thumb = new UMImage(WebActivity.this,list.get(pos).getPicurl());
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
                        UMImage thumb = new UMImage(WebActivity.this,list.get(pos).getPicurl());
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
                        UMImage thumb = new UMImage(WebActivity.this,list.get(pos).getPicurl());
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
            Log.d("plat","platform"+platform);

            Toast.makeText(WebActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(WebActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(WebActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

    public void check() {

        int hasWriteContactsPermission = ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION);
        int hasGrantedPermission = ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //这个判断是用来审验是否获取了权限
        if (hasGrantedPermission == PackageManager.PERMISSION_GRANTED&&hasWriteContactsPermission==PackageManager.PERMISSION_GRANTED) {
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
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED&&grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    //申请权限成功在这里做操作
                } else {
                }
                return;

        }
    }
}
