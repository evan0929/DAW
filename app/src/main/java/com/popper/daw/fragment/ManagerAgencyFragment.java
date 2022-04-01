package com.popper.daw.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.popper.daw.R;
import com.popper.daw.activity.LoginActivity;
import com.popper.daw.activity.manager.ManagerAgencyDetailActivity;
import com.popper.daw.adapter.ManagerAgencyAdapter;
import com.popper.daw.bean.ManagerAgencyBean;
import com.popper.daw.bean.ManagerItemBean;
import com.popper.daw.bean.OrderBean;
import com.popper.daw.bean.OrderListBean;
import com.popper.daw.callback.ManagerDetailListener;
import com.popper.daw.network.ApiServer;
import com.popper.daw.network.BaseResponse;
import com.popper.daw.network.RetrofitServiceManager;
import com.popper.daw.network.RxSubcriber;
import com.popper.daw.network.RxjavaHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * 经理代办 fragment.
 */
public class ManagerAgencyFragment extends Fragment {
    private RecyclerView mView;
    private List<ManagerAgencyBean> list=new ArrayList<>();
    private List<OrderListBean> mOrderListBeans=new ArrayList<>();
    private List<ManagerItemBean> itemList=new ArrayList<>();

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
        getOrderList(0);
        list.add(new ManagerAgencyBean("测试","10000","测试","紧急","郑州"));
        list.add(new ManagerAgencyBean("测试","10000","测试","紧急","郑州"));
        list.add(new ManagerAgencyBean("测试","10000","测试","紧急","郑州"));
        list.add(new ManagerAgencyBean("测试","10000","测试","紧急","郑州"));
        list.add(new ManagerAgencyBean("测试","10000","测试","紧急","郑州"));
        itemList.add(new ManagerItemBean("测试",20));
        itemList.add(new ManagerItemBean("测试",20));
        itemList.add(new ManagerItemBean("测试",20));
    }

    //初始化view
    private void initView(View view) {
        mView=view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mView.setLayoutManager(linearLayoutManager);
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.custom_divider));
        mView.addItemDecoration(divider);

        ManagerAgencyAdapter myAdapter = new ManagerAgencyAdapter(mOrderListBeans,getContext(),itemList);
        myAdapter.setOnItemClickListener(new ManagerDetailListener() {
            @Override
            public void onItemOnClick(View view) {
                startActivity(new Intent(getActivity(), ManagerAgencyDetailActivity.class));
            }
        });
        mView.setAdapter(myAdapter);

    }

    private void getOrderList(int state){
        String token="Bearer "+SPUtils.getInstance("daw").getString("token");
        RetrofitServiceManager.getInstance().creat(ApiServer.class)
                .getOrderList(state,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubcriber<List<OrderListBean>>(getContext()) {
                    @Override
                    public void onSuccess(List<OrderListBean> orderListBeans) {
                        Log.e("getOrderList", orderListBeans.toString());
                        mOrderListBeans=orderListBeans;
                    }
                });
    }


}