package com.popper.daw.network.interceptor;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/**
 * @author dd8
 * @project DAW
 * @date 30/3/2022 4:35 下午
 * desc   :
 */
public class CommonParamsInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (request.method().equals("GET")) {
            HttpUrl httpUrl = request.url().newBuilder()
//                    .addQueryParameter("version", "xxx")
//                    .addQueryParameter("device", "Android")
//                    .addQueryParameter("timestamp", String.valueOf(System.currentTimeMillis()))
                    .build();
            request = request.newBuilder().url(httpUrl).build();
        } else if (request.method().equals("POST")) {
            if (request.body() instanceof FormBody) {
                FormBody.Builder bodyBuilder = new FormBody.Builder();
                FormBody formBody = (FormBody) request.body();

                for (int i = 0; i < formBody.size(); i++) {
                    bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                }

                formBody = bodyBuilder
//                        .addEncoded("version", "xxx")
//                        .addEncoded("device", "Android")
//                        .addEncoded("timestamp", String.valueOf(System.currentTimeMillis()))
                        .build();

                request = request.newBuilder().post(formBody).build();
            }
        }

        return chain.proceed(request);
    }
}
