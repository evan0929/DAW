package com.popper.daw.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.popper.daw.MainActivity;
import com.popper.daw.R;
import com.popper.daw.customView.CountdownButton;

public class LoginActivity extends AppCompatActivity {
    private TextView mLogin;
    private EditText mAccount,mPwd;
    private CountdownButton mVerCode;
    private String account,verCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImmersionBar.with(this)
                .statusBarColor(R.color.back)     //状态栏颜色，不写默认透明色
                .init();
        initView();
    }

    //初始化view
    private void initView() {
        mLogin=findViewById(R.id.login);
        mAccount=findViewById(R.id.account);
        mPwd=findViewById(R.id.pwd);
        mVerCode=findViewById(R.id.verCode);
        mAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                account=editable.toString();
            }
        });
        mVerCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                verCode=editable.toString();
            }
        });
        mVerCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取验证码
            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //登录
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
    }
}