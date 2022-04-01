package com.popper.daw.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.popper.daw.R;
import com.popper.daw.adapter.RemakeAdapter;
import com.popper.daw.bean.RemakeBean;
import com.popper.daw.popup.SelectColorView;

import java.util.ArrayList;
import java.util.List;


public class ColoristFragment extends Fragment {
    private List<RemakeBean> remakeBeans=new ArrayList<>();
    private RemakeAdapter mRemakeAdapter;
    private RecyclerView mRemakeView;
    private RelativeLayout mColorInfo;
    private List<String> mColorList=new ArrayList<>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_colorist, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initView(View view) {

        mRemakeView=view.findViewById(R.id.remakeView);
        mRemakeView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        mRemakeAdapter=new RemakeAdapter(remakeBeans,getContext());
        mRemakeView.setAdapter(mRemakeAdapter);
        mColorInfo=view.findViewById(R.id.colorInfo);
        mColorInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectColorView selectColorView=new SelectColorView(getContext(),mColorList);
                selectColorView.setPopupGravity(Gravity.CENTER)
                        .showPopupWindow();
            }
        });
    }

    private void initData() {

        remakeBeans.add(new RemakeBean("王老师","20222-3-6","xxxxxxxxxx"));
        remakeBeans.add(new RemakeBean("王老师","20222-3-6","xxxxxxxxxx"));
        remakeBeans.add(new RemakeBean("王老师","20222-3-6","xxxxxxxxxx"));
        mColorList.add("色号1");
        mColorList.add("色号2");
        mColorList.add("色号3");
        mColorList.add("色号4");
    }
}