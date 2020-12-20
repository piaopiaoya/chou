package com.example.text_1219.base;

public abstract class BasePresenter<M extends BaseModel, V extends BaseView> {
    protected M model;
    protected V view;

    public void attachView(V view) {
        model = getModel();
        this.view = view;
    }

    public void detachView(){
        this.view = null;
        model = null;
    }

    protected abstract M getModel();
}

