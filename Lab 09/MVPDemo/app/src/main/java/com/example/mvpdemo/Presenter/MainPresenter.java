package com.example.mvpdemo.Presenter;

import com.example.mvpdemo.Model.MainContract;
import com.example.mvpdemo.Model.MainModel;

public class MainPresenter implements MainContract.Ipresenter {
    private MainContract.Imodel model;
    private MainContract.Iview view;

    public MainPresenter(MainContract.Iview view)
    {
        model = new MainModel();
        this.view =view;
    }
    @Override
    public void onButtonClicked()
    {
        String data = model.getData();
        view.setData(data);
    }
}
