package com.example.text_1219.model;

import com.example.mvlibrary.base.BaseModel;
import com.example.mvlibrary.utils.NetCallBack;
import com.example.mvlibrary.utils.ResultUtil;
import com.example.text_1219.bean.ListBean;
import com.example.text_1219.contract.MainContract;
import com.example.text_1219.presenter.MainPresenter;

public class MainModel<L> implements MainContract.getMainModel, BaseModel {


    @Override
    public void getMainModer(String url, NetCallBack callBack) {
        ResultUtil.getInstance().get(url,callBack);
    }
}

