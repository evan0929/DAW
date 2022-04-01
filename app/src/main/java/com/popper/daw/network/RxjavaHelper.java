package com.popper.daw.network;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author dd8
 * @project DAW
 * @date 30/3/2022 4:04 下午
 * desc   :Observable转换器 切换线程操作
 */
public class RxjavaHelper {
    /**
     * 切换线程操作
     * @return Observable转换器
     */
    public static <T> ObservableTransformer<T, T> observeOnMainThread() {
        return new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
