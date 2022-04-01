package com.popper.daw;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;
import com.popper.daw.activity.HomeActivity;
import com.popper.daw.activity.LoginActivity;
import com.popper.daw.activity.account.AccountActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String token= SPUtils.getInstance("daw").getString("token");
        if (ObjectUtils.isNotEmpty(token)){
            startActivity(new Intent(this, HomeActivity.class));
        }else {
            startActivity(new Intent(this, AccountActivity.class));
        }
    }
}