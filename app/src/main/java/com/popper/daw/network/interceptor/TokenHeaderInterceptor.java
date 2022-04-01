package com.popper.daw.network.interceptor;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenHeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        String token = SPUtils.getInstance("daw").getString("token"); //SpUtils是SharedPreferences的工具类，自行实现
        if (ObjectUtils.isNotEmpty(token)) {
            Request originalRequest = chain.request();
            //key的话以后台给的为准，我这边是叫token
            Request updateRequest = originalRequest.newBuilder().header("token", token).build();
            return chain.proceed(updateRequest);
        }else {
            Request originalRequest = chain.request();
            return chain.proceed(originalRequest);
        }
    }

}
