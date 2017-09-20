package chongci.myapplication.activity.gungun_activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.io.Serializable;
import java.util.ArrayList;

import chongci.myapplication.Bean.BoBaoBean;
import chongci.myapplication.Bean.WenhuaBean;
import chongci.myapplication.R;
import chongci.myapplication.activity.WebActivity;
import chongci.myapplication.fengzhuang.Fengzhuang;
import io.vov.vitamio.widget.VideoView;


public class GunGun_things extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_back_rollVideoFragment;
    private TextView tv_details_title;
    private VideoView videoController;
    private CheckBox iv_addView;
    private TextView intro;
    private PercentLinearLayout intro_lay;
    private XRecyclerView xrecycler_view;
    private ImageView iv_rollVideoCollect;
    private ImageView iv_rollVideoShare;
    private int count = 0;
    private int CODE_FOR_WRITE_PERMISSION = 0;
    private ArrayList<WenhuaBean.ListBean> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gun_gun_things);
        initView();
        initData();
        check();
    }

    private void initData() {

    }

    private void initView() {
        list = (ArrayList<WenhuaBean.ListBean>) getIntent().getSerializableExtra("list");
        iv_addView = (CheckBox) findViewById(R.id.iv_addView);
        intro_lay = (PercentLinearLayout) findViewById(R.id.intro_lay);
        iv_back_rollVideoFragment = (ImageView) findViewById(R.id.iv_back_rollVideoFragment);
        iv_rollVideoCollect = (ImageView) findViewById(R.id.iv_rollVideoCollect);
        iv_rollVideoShare = (ImageView) findViewById(R.id.iv_rollVideoShare);

        iv_addView.setOnClickListener(this);
        iv_back_rollVideoFragment.setOnClickListener(this);
        iv_rollVideoCollect.setOnClickListener(this);
        iv_rollVideoShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_addView:
                if (iv_addView.isChecked()) {
                    Drawable up = getResources().getDrawable(R.drawable.live_china_detail_up);
                    iv_addView.setBackground(up);
                    intro_lay.setVisibility(View.VISIBLE);
                } else {
                    Drawable down = getResources().getDrawable(R.drawable.live_china_detail_down);
                    iv_addView.setBackground(down);
                    intro_lay.setVisibility(View.GONE);
                }
                break;
            case R.id.iv_back_rollVideoFragment://返回
                finish();
                break;
            case R.id.iv_rollVideoCollect://收藏
                iv_rollVideoCollect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (count==0){
                            iv_rollVideoCollect.setImageResource(R.drawable.collect_yes);
                            count=1;
                            Toast.makeText(GunGun_things.this,"已添加请到[我的收藏]中查看",Toast.LENGTH_SHORT).show();
                        }else {
                            iv_rollVideoCollect.setImageResource(R.drawable.collect_no);
                            count=0;
                            Toast.makeText(GunGun_things.this,"已取消收藏",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                break;
            case R.id.iv_rollVideoShare://分享
                View views = View.inflate(GunGun_things.this,R.layout.gungun_item_popup,null);
                final PopupWindow popupWindow=new PopupWindow(views, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(4));
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(iv_back_rollVideoFragment, Gravity.BOTTOM, 0, 100);
                ImageView qqIv = (ImageView) views.findViewById(R.id.qqq_iv);
                qqIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UMImage thumb = new UMImage(GunGun_things.this,list.get(0).getImage());
                        UMWeb web = new UMWeb(list.get(0).getUrl());
                        web.setThumb(thumb);
                        web.setTitle(list.get(0).getTitle());
                        new ShareAction(GunGun_things.this)
                                .setPlatform(SHARE_MEDIA.QQ)
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
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {
            Log.d("plat","platform"+share_media);

            Toast.makeText(GunGun_things.this, share_media + " 分享成功啦", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            Toast.makeText(GunGun_things.this, share_media + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (throwable != null) {
                Log.d("throw", "throw:" + throwable.getMessage());
            }

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            Toast.makeText(GunGun_things.this,share_media + " 分享取消了", Toast.LENGTH_SHORT).show();
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