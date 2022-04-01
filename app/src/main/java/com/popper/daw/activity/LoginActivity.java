package com.popper.daw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.popper.daw.R;
import com.popper.daw.bean.LoginBean;
import com.popper.daw.bean.LoginResponseBean;
import com.popper.daw.customView.CountdownButton;
import com.popper.daw.network.ApiServer;
import com.popper.daw.network.BaseResponse;
import com.popper.daw.network.RetrofitServiceManager;
import com.popper.daw.network.RxSubcriber;
import com.popper.daw.network.RxjavaHelper;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends AppCompatActivity {
    private TextView mLogin;
    private EditText mAccount, mPwd;
    private CountdownButton mVerCode;
    private String account, verCode;
    private SPUtils spUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImmersionBar.with(this)
                .statusBarColor(R.color.back)     //状态栏颜色，不写默认透明色
                .init();
        spUtils=SPUtils.getInstance("daw");
        initView();
    }

    //初始化view
    private void initView() {
        mLogin = findViewById(R.id.login);
        mAccount = findViewById(R.id.account);
        mPwd = findViewById(R.id.pwd);
        mVerCode = findViewById(R.id.verCode);
        mAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                account = editable.toString();
            }
        });
        mPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                verCode = editable.toString();
            }
        });
        mVerCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ObjectUtils.isNotEmpty(account)){
                    //获取验证码
                    SPUtils.getInstance("daw").clear();
                    RetrofitServiceManager.getInstance().creat(ApiServer.class)
                            .getVCode("17602173231")
                            .compose(RxjavaHelper.<BaseResponse<String>>observeOnMainThread())
                            .subscribe(new RxSubcriber<String>(LoginActivity.this) {
                                @Override
                                public void onSuccess(String o) {
                                    mVerCode.setIsStart(true);
                                    Toast.makeText(LoginActivity.this, "验证码已发送～", Toast.LENGTH_SHORT).show();
                                }
                            });
                }else {
                    Toast.makeText(LoginActivity.this, "请先输入手机号码！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (ObjectUtils.isNotEmpty(account) && ObjectUtils.isNotEmpty(verCode)) {
//                    if (account.equals("17602173231") && verCode.equals("1234")) {
//                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
//                    } else if (account.equals("17602173232") && verCode.equals("1234")) {
//                        startActivity(new Intent(LoginActivity.this, DirectorActivity.class));
//                    } else if (account.equals("17602173233") && verCode.equals("1234")) {
//                        startActivity(new Intent(LoginActivity.this, ColoristActivity.class));
//                    } else {
//                        Toast.makeText(LoginActivity.this, "手机号或验证码不正确！", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(LoginActivity.this, "手机号和验证码不能为空！", Toast.LENGTH_SHORT).show();
//                }
                //登录
                if (ObjectUtils.isNotEmpty(account) && ObjectUtils.isNotEmpty(verCode)) {
                    RetrofitServiceManager.getInstance().creat(ApiServer.class)
                            .login(new LoginBean(account,verCode))
                            .compose(RxjavaHelper.<LoginResponseBean>observeOnMainThread())
                            .subscribe(new Observer<LoginResponseBean>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(LoginResponseBean loginResponseBean) {
                                    if (loginResponseBean.getCode()==200){
                                        //登录成功
                                        spUtils.put("token",loginResponseBean.getToken());
                                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                                        finish();
                                    }else {
                                        Toast.makeText(LoginActivity.this, loginResponseBean.getMsg(), Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onError(Throwable e) {

                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }else {
                    Toast.makeText(LoginActivity.this, "请先输入手机号码和验证码！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}