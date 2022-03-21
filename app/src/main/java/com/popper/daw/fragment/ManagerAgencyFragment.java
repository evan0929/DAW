package com.popper.daw.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.popper.daw.R;
import com.popper.daw.adapter.ManagerAgencyAdapter;
import com.popper.daw.bean.ManagerAgencyBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 经理代办 fragment.
 */
public class ManagerAgencyFragment extends Fragment {
    private RecyclerView mView;
    List<ManagerAgencyBean> list=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_manager_agency, container, false);
        initData();
        initView(view);
        return view;
    }

    //初始化数据
    private void initData() {
        list.add(new ManagerAgencyBean("测试","20210318","测是测试测试测试测试",0));
        list.add(new ManagerAgencyBean("测试","20210318","测是测试测试测试测试",30));
        list.add(new ManagerAgencyBean("测试","20210318","测是测试测试测试测试",40));
        list.add(new ManagerAgencyBean("测试","20210318","测是测试测试测试测试",50));
        list.add(new ManagerAgencyBean("测试","20210318","测是测试测试测试测试",100));
    }

    //初始化view
    private void initView(View view) {
        mView=view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mView.setLayoutManager(linearLayoutManager);

        ManagerAgencyAdapter myAdapter = new ManagerAgencyAdapter(list,getContext());
        mView.setAdapter(myAdapter);
    }
}