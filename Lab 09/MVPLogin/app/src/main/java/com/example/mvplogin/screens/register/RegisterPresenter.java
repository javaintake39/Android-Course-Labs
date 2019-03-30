package com.example.mvplogin.screens.register;

import com.example.mvplogin.model.RegisterModel;

public class RegisterPresenter implements RegisterContract.Ipresenter {

    RegisterContract.Imodel model;
    RegisterContract.Iview view;

    public RegisterPresenter(RegisterContract.Iview view)
    {
        this.view = view;
        model=new RegisterModel(view.getContext());
    }


    @Override
    public void adduser(String email, String password) {
        String message = model.adduser(email,password);
        view.showResult(message);
    }
}
