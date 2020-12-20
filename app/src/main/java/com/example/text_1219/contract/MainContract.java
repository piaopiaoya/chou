package com.example.text_1219.contract;

import com.example.mvlibrary.base.BaseModel;
import com.example.mvlibrary.base.BaseView;
import com.example.mvlibrary.utils.NetCallBack;
import com.example.text_1219.bean.ListBean;

public class MainContract {
    public interface MainModel<B> extends BaseModel {
        void OnSeccess(ListBean listBean);
        void OnFail(String err);
    }

    public interface getMainPresenter{
        void getMainPresenter();
    }

    public interface getMainModel<B> extends BaseModel {
         void getMainModer(String url, NetCallBack<B> callBack);
    }

    public interface getMainView<T> extends BaseView {
        void OnSeccess(ListBean listBean);
        void OnFail(String err);
    }
}

