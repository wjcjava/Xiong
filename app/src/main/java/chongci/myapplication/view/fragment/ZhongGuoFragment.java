package chongci.myapplication.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chongci.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhongGuoFragment extends Fragment {

    public ZhongGuoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zhong_guo, container, false);
    }

}
