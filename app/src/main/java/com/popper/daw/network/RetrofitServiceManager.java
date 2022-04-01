package com.popper.daw.network;

import android.os.Environment;

import com.popper.daw.network.interceptor.CommonParamsInterceptor;
import com.popper.daw.network.interceptor.HttpCacheInterceptor;
import com.popper.daw.network.interceptor.HttpHeaderInterceptor;
import com.popper.daw.network.interceptor.TokenHeaderInterceptor;
import com.popper.daw.utils.HttpsUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitServiceManager {
    public final String BASE_URL= "https://cs198.yuhong.com.cn/";

    private static final int DEFAULT_TIME_OUT = 10;//超时时间5s
    private static final int DEFAULT_READ_TIME_OUT = 10;//读取时间
    private static final int DEFAULT_WRITE_TIME_OUT = 10;//读取时间
    private Retrofit mRetrofit;
    private static RetrofitServiceManager mRetrofitServiceManager;


    private RetrofitServiceManager(){
        //OkHttpClient配置
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_WRITE_TIME_OUT,TimeUnit.SECONDS);
        //设置支持所有https请求
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        builder.hostnameVerifier((hostname, session) -> true).sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);
//        builder.cache(new Cache(new File(Environment.getExternalStorageDirectory() + "/RxJavaDemo"),1024*1024*10));
        //cookie持久化管理
//        builder.cookieJar(new PersistentCookieJar(new SetCookieCache(),new SharedPrefsCookiePersistor(App.getInstance())));

        addInterceptor(builder);


        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 添加各种拦截器
     * @param builder
     */
    private void addInterceptor(OkHttpClient.Builder builder) {
        // 添加日志拦截器，非debug模式不打印任何日志
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

//        RetrofitDownloadInterceptor retrofitDownloadInterceptor = new RetrofitDownloadInterceptor(retrofitDownloadListener);

        HttpHeaderInterceptor httpHeaderInterceptor = new HttpHeaderInterceptor.Builder().build();
        HttpCacheInterceptor httpCacheInterceptor = new HttpCacheInterceptor();
//        if (retrofitDownloadListener != null) {
//            builder.addInterceptor(retrofitDownloadInterceptor);
//        }
        TokenHeaderInterceptor tokenHeaderInterceptor=new TokenHeaderInterceptor();
        builder.addInterceptor(loggingInterceptor);

        builder.addInterceptor(httpHeaderInterceptor);
        builder.addInterceptor(new CommonParamsInterceptor());
        builder.addInterceptor(httpCacheInterceptor);
        builder.addNetworkInterceptor(httpCacheInterceptor);
        builder.cache(new Cache(new File(Environment.getExternalStorageDirectory() + "/RxJavaDemo"), 1024 * 1024 * 10));

    }

    //单例 饿汉模式
    private static class SingletonHolder{
        private static RetrofitServiceManager retrofitServiceManager = new RetrofitServiceManager();
    }

    public static RetrofitServiceManager getInstance(){
        return SingletonHolder.retrofitServiceManager;
    }

    //获取Service实例
    public <T> T creat(Class<T> tClass){
        return mRetrofit.create(tClass);
    }


}
