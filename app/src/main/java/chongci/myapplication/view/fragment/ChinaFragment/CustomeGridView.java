package chongci.myapplication.view.fragment.ChinaFragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * Created by a on 2017/9/19.
 */

public class CustomeGridView extends GridView {

    public CustomeGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomeGridView(Context context) {
        super(context);
    }

    public CustomeGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
