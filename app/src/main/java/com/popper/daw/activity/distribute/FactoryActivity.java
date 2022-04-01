package com.popper.daw.activity.distribute;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.immersionbar.ImmersionBar;
import com.popper.daw.R;
import com.popper.daw.activity.manager.ManagerAgencyDetailActivity;
import com.popper.daw.activity.manager.MaterialsActivity;
import com.popper.daw.adapter.OrderAdapter;
import com.popper.daw.adapter.SelectAdapter;
import com.popper.daw.callback.ManagerDetailListener;

import java.util.ArrayList;
import java.util.List;

public class FactoryActivity extends AppCompatActivity {
    private TextView mTitle,mSure;
    private ImageView mReturn;
    private SelectAdapter mAdapter;
    private RecyclerView mView;
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
        ImmersionBar.with(this)
                .statusBarColor(R.color.back)     //状态栏颜色，不写默认透明色
                .fitsSystemWindows(true)
                .init();
        initData();
        initView();

    }

    private void initData() {
        list.add("测试测试测试测试");
        list.add("测试测试测试测试");
        list.add("测试测试测试测试");
        list.add("测试测试测试测试");
        list.add("测试测试测试测试");
        list.add("测试测试测试测试");
    }

    private void initView() {
        mTitle=findViewById(R.id.title);
        mReturn=findViewById(R.id.close);
        mTitle.setText("选择工厂");
        mReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mView=findViewById(R.id.factoryView);
        mView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mAdapter=new SelectAdapter(list,this);
        mAdapter.setOnItemClickListener(new ManagerDetailListener() {
            @Override
            public void onItemOnClick(View view) {
                // TODO: 2022/3/27
            }
        });
        mView.setAdapter(mAdapter);
        mSure=findViewById(R.id.sure);
        mSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FactoryActivity.this, "确定选择！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}