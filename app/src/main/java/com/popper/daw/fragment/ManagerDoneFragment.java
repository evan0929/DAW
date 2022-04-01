package com.popper.daw.fragment;

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

import com.blankj.utilcode.util.SPUtils;
import com.popper.daw.R;
import com.popper.daw.adapter.ManagerAgencyAdapter;
import com.popper.daw.bean.ManagerAgencyBean;
import com.popper.daw.bean.ManagerItemBean;
import com.popper.daw.bean.OrderBean;
import com.popper.daw.bean.OrderListBean;
import com.popper.daw.network.ApiServer;
import com.popper.daw.network.RetrofitServiceManager;
import com.popper.daw.network.RxSubcriber;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**

 *  经理已办 fragment.
 */
public class ManagerDoneFragment extends Fragment {
    private RecyclerView mView;
    private List<ManagerAgencyBean> list=new ArrayList<>();
    private List<ManagerItemBean> itemList=new ArrayList<>();
    private List<OrderListBean> mOrderListBeans=new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_manager_done, container, false);
        initData();
        initView(view);
        return view;
    }

    //初始化数据
    private void initData() {
        getOrderList(1);
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
        mView.setAdapter(myAdapter);
    }


    private void getOrderList(int state){
        String token="Bearer "+ SPUtils.getInstance("daw").getString("token");
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