package com.example.text_1219.presenter;

import com.example.mvlibrary.base.BasePresenter;
import com.example.mvlibrary.utils.NetCallBack;
import com.example.mvlibrary.utils.UrlUtil;
import com.example.text_1219.contract.MainContract;
import com.example.text_1219.view.MainActivity;
import com.example.text_1219.bean.ListBean;
import com.example.text_1219.model.MainModel;

public class MainPresenter extends BasePresenter<MainModel<ListBean>, MainContract.getMainView> implements MainContract.getMainPresenter {


    public MainPresenter(MainActivity mainActivity) {

        this.mainActivity = mainActivity;
    }

    @Override
    protected MainModel<ListBean> getModel() {
        return new MainModel<ListBean>();
    }
    private MainActivity mainActivity;



    @Override
    public void getMainPresenter() {
        MainContract.getMainModel mainModel = null;
        mainModel.getMainModer(UrlUtil.LIST, new NetCallBack<ListBean>() {
            @Override
            public void OnSeccuss(ListBean listBean) {
                mainActivity.OnSeccess(listBean);
            }

            @Override
            public void OnFail(String err) {
                mainActivity.OnFail(err);
            }
        });
    }


}

