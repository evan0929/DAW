package com.popper.daw.network;

import com.popper.daw.bean.LoginBean;
import com.popper.daw.bean.LoginResponseBean;
import com.popper.daw.bean.OrderListBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ApiServer {
    //获取验证码
    @GET("color/wechat/sendMessage/{mobile}")
    Observable<BaseResponse<String>> getVCode(@Path("mobile") String mobile);

    //登录
    @POST("dawLogin")
    Observable<LoginResponseBean> login(@Body LoginBean loginBean);

    //获取首页
    @GET("color/mobile/order/agencyOrderlist/{state}")
    Observable<BaseResponse<List<OrderListBean>>> getOrderList(@Path("state") int state,@Header("Authorization") String header);
}
