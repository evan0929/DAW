package com.popper.daw.activity.manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.popper.daw.R;
import com.popper.daw.adapter.OrderAdapter;
import com.popper.daw.adapter.RemakeAdapter;
import com.popper.daw.bean.ManagerAgencyBean;
import com.popper.daw.bean.OrderBean;
import com.popper.daw.bean.RemakeBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.ArrayList;
import java.util.List;

public class ManagerAgencyDetailActivity extends AppCompatActivity {
    private TextView mTitle,mMore;
    private ImageView mReturn;
    private RecyclerView mOrderView,mRemakeView,mProgressView;
    private List<OrderBean> list=new ArrayList<>();
    private List<RemakeBean> remakeBeans=new ArrayList<>();
    private OrderAdapter mAdapter;
    private RemakeAdapter mRemakeAdapter;
    private RelativeLayout mGetProgress;
    private LinearLayout mProgress;
    private Boolean isShowProgress;
    private LinearLayout mGetMore;
    private boolean isShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImmersionBar.with(this)
                .statusBarColor(R.color.back)     //状态栏颜色，不写默认透明色
                .fitsSystemWindows(true)
                .init();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_agency_detail);
        initData();
        initView();
    }
    //初始化数据
    private void initData() {
        isShowProgress=false;
        list.add(new OrderBean("30203016-0901","真石漆（0-3%岩片+PO12M）",345,100000,1000));
        list.add(new OrderBean("30203016-0901","真石漆（0-3%岩片+PO12M）",345,100000,1000));
        list.add(new OrderBean("30203016-0901","真石漆（0-3%岩片+PO12M）",345,100000,1000));
        list.add(new OrderBean("30203016-0901","真石漆（0-3%岩片+PO12M）",345,100000,1000));
        list.add(new OrderBean("30203016-0901","真石漆（0-3%岩片+PO12M）",345,100000,1000));

        remakeBeans.add(new RemakeBean("王老师","20222-3-6","xxxxxxxxxx"));
        remakeBeans.add(new RemakeBean("王老师","20222-3-6","xxxxxxxxxx"));
        remakeBeans.add(new RemakeBean("王老师","20222-3-6","xxxxxxxxxx"));
    }
    private void initView() {
        mTitle=findViewById(R.id.title);
        mReturn=findViewById(R.id.close);
        mTitle.setText("申请XXXX");
        mReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mOrderView=findViewById(R.id.orderView);
        mOrderView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mOrderView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mAdapter=new OrderAdapter(list,this,true);
        mAdapter.setOnItemClickListener(new ManagerDetailListener() {
            @Override
            public void onItemOnClick(View view) {
                startActivity(new Intent(ManagerAgencyDetailActivity.this,MaterialsActivity.class));
            }
        });
        mOrderView.setAdapter(mAdapter);
        mProgress=findViewById(R.id.progress);
        mGetProgress=findViewById(R.id.getProgress);
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
        mRemakeView=findViewById(R.id.remakeView);
        mRemakeView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mRemakeAdapter=new RemakeAdapter(remakeBeans,this);
        mRemakeView.setAdapter(mRemakeAdapter);


        mMore=findViewById(R.id.more);
        mGetMore=findViewById(R.id.getMore);
        mMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isShow){
                    isShow=false;
                    mGetMore.setVisibility(View.GONE);
                }else {
                    isShow=true;
                    mGetMore.setVisibility(View.VISIBLE);
                }
            }
        });
    }


}