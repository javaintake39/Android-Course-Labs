package com.example.mvplogin.screens.login;

import android.content.Context;

public interface LoginContract
{
    public interface Ipresenter
    {
        void checkUser(String email,String password);
    }
    public interface Iview
    {
        void showErrorMessage(String result);
        Context getContext();
        void showCountryList();
    }
}
