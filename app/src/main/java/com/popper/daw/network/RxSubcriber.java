package com.popper.daw.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;


import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

import java.io.IOException;


import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @author dd8
 * @project DAW
 * @date 30/3/2022 3:58 下午
 * desc   :
 */
public abstract class RxSubcriber<T> implements Observer<BaseResponse<T>> {
    private ProgressDialog mProgressDialog;
    private Disposable disposable;
    private Context context;
    private String errorMsg;

    public RxSubcriber(Context context){
        this.context = context;
    }


    @Override
    public void onSubscribe(Disposable d) {
        disposable = new CompositeDisposable();
        showLoading();
    }

    @Override
    public void onNext(BaseResponse<T> value) {
        if(!value.isSuccess()){
            ApiException apiException = new ApiException(new Status(value.getCode(),value.getMsg()));
            onError(apiException);
            return;
        }
        onSuccess(value.getData());

    }


    @Override
    public void onError(Throwable e) {
        if (e instanceof IOException) {
            /** 没有网络 */
            errorMsg = "请检查设备的网络状态";
        } else if (e instanceof HttpException) {
            /** 网络异常，http 请求失败，即 http 状态码不在 [200, 300) 之间, such as: "server internal error". */
            errorMsg = ((HttpException) e).response().message();
        } else if (e instanceof ApiException) {
            /** 网络正常，http 请求成功，服务器返回逻辑错误 */
            errorMsg = ((ApiException)e).getMessage();
        } else {
            /** 其他未知错误 */
            errorMsg = !TextUtils.isEmpty(e.getMessage()) ? e.getMessage() : "unknown error";
        }


        dismissLoading();

        new AlertDialog.Builder(context)
                .setTitle("提示")
                .setMessage(errorMsg)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if(!disposable.isDisposed()){
                            disposable.dispose();
                        }
                    }
                }).show();
    }

    @Override
    public void onComplete() {
        dismissLoading();
    }

    public abstract void onSuccess(T t);


    private void showLoading(){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setMessage("正在加载中...");
            mProgressDialog.show();
        }
    }

    private void dismissLoading(){
        if(mProgressDialog != null){
            mProgressDialog.dismiss();
        }
    }


}
