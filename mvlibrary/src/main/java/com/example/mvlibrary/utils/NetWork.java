package com.example.mvlibrary.utils;

public interface NetWork {
    <T> void get(String url, NetCallBack<T> callBack);
}

