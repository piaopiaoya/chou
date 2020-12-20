package com.example.text_1219.view;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvlibrary.utils.UrlUtil;
import com.example.text_1219.R;
import com.example.text_1219.adapter.RvAdapter;
import com.example.text_1219.base.BaseActivity;
import com.example.text_1219.bean.ListBean;
import com.example.text_1219.contract.MainContract;
import com.example.text_1219.presenter.MainPresenter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.getMainView<ListBean> {

    private RecyclerView rv;
    private MainPresenter mainPresenter;
    private ArrayList<ListBean.ResultsBean> list;
    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter.getMainPresenter();
        initView();
    }

    @Override
    protected void initData() {
        mainPresenter = new MainPresenter(UrlUtil.LIST);
    }

    protected void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new RvAdapter(this, list);
        rv.setAdapter(adapter);
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int setConentById() {
        return 0;
    }

    @Override
    public void OnSeccess(ListBean listBean) {
        list.addAll(listBean.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnFail(String err) {
        Log.d("TAG","错误信息："+err);
    }
}