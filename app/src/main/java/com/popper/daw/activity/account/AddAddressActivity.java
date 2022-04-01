package com.popper.daw.activity.account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.popper.daw.R;

public class AddAddressActivity extends AppCompatActivity {
    private TextView mTitle,mAddressCity;
    private ImageView mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        initData();
        initView();
    }

    private void initData() {
    }
    private void initView() {
        mTitle=findViewById(R.id.title);
        mTitle.setText("地址信息");
        mAccount=findViewById(R.id.goAccount);
        mAccount.setVisibility(View.GONE);
        mAddressCity=findViewById(R.id.addressCity);
        mAddressCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}