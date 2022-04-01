package com.popper.daw.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.popper.daw.R;
import com.popper.daw.activity.colorist.ColoristDetailActivity;
import com.popper.daw.activity.manager.ManagerAgencyDetailActivity;
import com.popper.daw.activity.manager.MaterialsActivity;
import com.popper.daw.adapter.OrderAdapter;
import com.popper.daw.bean.OrderBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.ArrayList;
import java.util.List;


public class ColoristAgencyFragment extends Fragment {
    private List<OrderBean> list=new ArrayList<>();
    private OrderAdapter mAdapter;
    private RecyclerView mOrderView;
    private TextView mPrint;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_coloriset_agency, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        mOrderView=view.findViewById(R.id.orderView);
        mOrderView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mOrderView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        mAdapter=new OrderAdapter(list,getContext(),false);
        mAdapter.setOnItemClickListener(new ManagerDetailListener() {
            @Override
            public void onItemOnClick(View view) {
                startActivity(new Intent(getActivity(), ColoristDetailActivity.class));
            }
        });
        mOrderView.setAdapter(mAdapter);

        mPrint=view.findViewById(R.id.print);
        mPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initData() {
        list.add(new OrderBean("30203016-0901","真石漆（0-3%岩片+PO12M）",345,100000,1000));
        list.add(new OrderBean("30203016-0901","真石漆（0-3%岩片+PO12M）",345,100000,1000));
        list.add(new OrderBean("30203016-0901","真石漆（0-3%岩片+PO12M）",345,100000,1000));
        list.add(new OrderBean("30203016-0901","真石漆（0-3%岩片+PO12M）",345,100000,1000));
        list.add(new OrderBean("30203016-0901","真石漆（0-3%岩片+PO12M）",345,100000,1000));
    }
}