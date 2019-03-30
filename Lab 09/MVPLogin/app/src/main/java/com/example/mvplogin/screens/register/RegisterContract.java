package com.example.mvplogin.screens.register;

import android.content.Context;

public interface RegisterContract {

    public interface Imodel
    {
        String adduser(String email,String password);
        boolean checkUser(String email,String password);
    }
    public interface Ipresenter
    {
        void adduser(String email,String password);
    }
    public interface Iview
    {
        void showResult(String result);
        Context getContext();
    }

}
