package chongci.myapplication.view.fragment;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

import chongci.myapplication.R;

/**
 * Created by Administrator on 2017/9/13.
 */
public class LuBoTu extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).error(R.mipmap.ic_launcher).into(imageView);
    }
}
