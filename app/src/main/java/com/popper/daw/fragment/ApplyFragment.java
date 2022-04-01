package com.popper.daw.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.popper.daw.R;


public class ApplyFragment extends Fragment {

    private LinearLayout mProgress;
    private Boolean isShowProgress;
    private RelativeLayout mGetProgress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_apply, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        mProgress=view.findViewById(R.id.progress);
        mGetProgress=view.findViewById(R.id.getProgress);
        mGetProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isShowProgress){
                    isShowProgress=false;
                    mProgress.setVisibility(View.GONE);
                }else {
                    isShowProgress=true;
                    mProgress.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void initData() {
        isShowProgress=false;

    }
}