package com.example.mvlibrary.utils;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class ResultUtil implements NetWork {

    private static volatile ResultUtil resultUtil;
    private final ApiService apiService;

    public ResultUtil() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(UrlUtil.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = build.create(ApiService.class);
    }

    public static ResultUtil getInstance() {
        if (resultUtil==null) {
            synchronized (ResultUtil.class  ){
                if (resultUtil ==null) {
                    resultUtil = new ResultUtil();
                }
            }
        }
        return resultUtil;
    }


    @Override
    public <T> void get(String url, NetCallBack<T> callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            callBack.OnSeccuss(new Gson().fromJson(string,t));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("TAG","解析错误信息："+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

