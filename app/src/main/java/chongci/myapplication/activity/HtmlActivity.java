package chongci.myapplication.activity;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import chongci.myapplication.R;

public class HtmlActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CODE_FOR_WRITE_PERMISSION = 0 ;
    private WebView webview;
    private String html;
    private ImageView back;
    private ImageView fenxiang;
    private AlertDialog ad;
    private String title;
    private TextView title1;
    private ImageView qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        html = getIntent().getStringExtra("hrml");
        title = getIntent().getStringExtra("title");
        initView();
    }

    private void initView() {
        webview = (WebView) findViewById(R.id.webview);
//

//        webview.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(html);
//                return true;
//            }
//        });

        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(html);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        fenxiang = (ImageView) findViewById(R.id.fenxiang);

        fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initkuang();
            }
        });
        title1 = (TextView) findViewById(R.id.title1);
        title1.setText(title);

    }

    private void initkuang() {
        ad = new AlertDialog.Builder(HtmlActivity.this, R.style.MediaController_Text).create();
        ad.show();
        ad.setCanceledOnTouchOutside(true);
//得到对话框的窗口
        Window w = ad.getWindow();
//设置对话框位于屏幕的底部
        w.setGravity(Gravity.BOTTOM);
//设置自定义布局
        View view1 = View.inflate(HtmlActivity.this, R.layout.layout_dialog, null);
        w.setContentView(view1);
        qq= (ImageView) view1.findViewById(R.id.qq);

        qq.setOnClickListener(this);
        //设置对话框无边距
        w.getDecorView().setPadding(0, 0, 0, 0);

//给对话框设置宽高
        WindowManager wm = getWindowManager();
        Display display = wm.getDefaultDisplay();
        WindowManager.LayoutParams lp = ad.getWindow().getAttributes();
        lp.width = (int) (display.getWidth());
        lp.height = (int) (display.getHeight() * 0.37);
check();
        ad.getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.qq:
                UMImage umimage=new UMImage(HtmlActivity.this,R.mipmap.ic_launcher);

                UMWeb web=new UMWeb(html);
                web.setTitle(html);

                new ShareAction(HtmlActivity.this).setPlatform(SHARE_MEDIA.QQ)
                        .withText("hello")
                        .withMedia(web)
                        .setCallback(umShareListener)
                        .share();
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

            Toast.makeText(HtmlActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(HtmlActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(HtmlActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
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
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_COARSE_LOCATION}, CODE_FOR_WRITE_PERMISSION);
    
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
