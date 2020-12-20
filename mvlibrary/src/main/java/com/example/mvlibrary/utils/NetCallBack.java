package com.example.mvlibrary.utils;

public interface NetCallBack<T> {
    void OnSeccuss(T t);
    void OnFail(String err);
}

