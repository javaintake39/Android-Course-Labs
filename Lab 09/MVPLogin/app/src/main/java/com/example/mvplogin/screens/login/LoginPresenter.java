package com.example.mvplogin.screens.login;

import com.example.mvplogin.model.RegisterModel;
import com.example.mvplogin.screens.register.RegisterContract;

public class LoginPresenter implements LoginContract.Ipresenter {
    RegisterContract.Imodel model;
    LoginContract.Iview view;
    public LoginPresenter(LoginContract.Iview view)
    {
       this.view=view;
       model=new RegisterModel(view.getContext());
    }
    @Override
    public void checkUser(String email, String password) {
        boolean result = model.checkUser(email,password);
        if(result)
        {
            view.showCountryList();
        }
        else
        {
            view.showErrorMessage("Error in Login");
        }
    }
}
