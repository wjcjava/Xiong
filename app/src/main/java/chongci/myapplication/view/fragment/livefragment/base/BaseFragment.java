package chongci.myapplication.view.fragment.livefragment.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.vov.vitamio.Vitamio;

/**
 * Created by lenovo on 2017/9/13.
 */

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),getFragmentLayoutId(), null);
        initView(view);
        initData();
        Vitamio.isInitialized(getActivity());
        return view;
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    public abstract int getFragmentLayoutId();
}
