package com.popper.daw.activity.account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.popper.daw.R;
import com.popper.daw.activity.HomeActivity;
import com.popper.daw.activity.manager.ManagerAgencyDetailActivity;
import com.popper.daw.adapter.AddressAdapater;
import com.popper.daw.adapter.ManagerAgencyAdapter;
import com.popper.daw.bean.AddressBean;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {
    private TextView mTitle,mAddAddress;
    private ImageView mAccount;
    private RecyclerView mAddressView;
    private List<AddressBean> mList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        initData();
        initView();
    }

    private void initData() {
        mList.add(new AddressBean("张三","河南省郑州市金水区国基路街道北文雅小区55号楼1603室"));
        mList.add(new AddressBean("张三","河南省郑州市金水区国基路街道北文雅小区55号楼1603室"));
        mList.add(new AddressBean("张三","河南省郑州市金水区国基路街道北文雅小区55号楼1603室"));
        mList.add(new AddressBean("张三","河南省郑州市金水区国基路街道北文雅小区55号楼1603室"));
        mList.add(new AddressBean("张三","河南省郑州市金水区国基路街道北文雅小区55号楼1603室"));
    }

    private void initView() {
        mTitle=findViewById(R.id.title);
        mTitle.setText("个人中心");
        mAccount=findViewById(R.id.goAccount);
        mAccount.setVisibility(View.GONE);
        mAddressView=findViewById(R.id.addressView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AccountActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mAddressView.setLayoutManager(linearLayoutManager);
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(AccountActivity.this,DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(AccountActivity.this,R.drawable.custom_divider));
        mAddressView.addItemDecoration(divider);

        AddressAdapater myAdapter = new AddressAdapater(mList,AccountActivity.this);
        myAdapter.setOnItemClickListener(new ManagerDetailListener() {
            @Override
            public void onItemOnClick(View view) {
                startActivity(new Intent(AccountActivity.this, EditAddressActivity.class));
            }
        });
        mAddressView.setAdapter(myAdapter);
        mAddAddress=findViewById(R.id.addAddress);
        mAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this, AddAddressActivity.class));
            }
        });
    }
}