package com.popper.daw.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.popper.daw.R;
import com.popper.daw.activity.manager.ManagerAgencyDetailActivity;
import com.popper.daw.adapter.DirectorAgencyAdapter;
import com.popper.daw.bean.DirectorOrderBean;
import com.popper.daw.bean.ManagerItemBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.ArrayList;
import java.util.List;


public class DirectorDoneFragment extends Fragment {
    private RecyclerView mView;
    private List<DirectorOrderBean> list=new ArrayList<>();
    private List<ManagerItemBean> itemList=new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_director_done, container, false);
        initData();
        initView(view);
        return view;
    }
    //初始化数据
    private void initData() {
        list.add(new DirectorOrderBean("测试","2022-03-29"));
        list.add(new DirectorOrderBean("测试","2022-03-29"));
        list.add(new DirectorOrderBean("测试","2022-03-29"));
        list.add(new DirectorOrderBean("测试","2022-03-29"));
        list.add(new DirectorOrderBean("测试","2022-03-29"));
        list.add(new DirectorOrderBean("测试","2022-03-29"));

        itemList.add(new ManagerItemBean("测试",20));
        itemList.add(new ManagerItemBean("测试",20));
        itemList.add(new ManagerItemBean("测试",20));

    }

    //初始化view
    private void initView(View view) {
        mView=view.findViewById(R.id.orderView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mView.setLayoutManager(linearLayoutManager);
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.custom_divider));
        mView.addItemDecoration(divider);

        DirectorAgencyAdapter myAdapter = new DirectorAgencyAdapter(list,getContext(),itemList);
        myAdapter.setOnItemClickListener(new ManagerDetailListener() {
            @Override
            public void onItemOnClick(View view) {
                startActivity(new Intent(getActivity(), ManagerAgencyDetailActivity.class));
            }
        });
        mView.setAdapter(myAdapter);

    }
}