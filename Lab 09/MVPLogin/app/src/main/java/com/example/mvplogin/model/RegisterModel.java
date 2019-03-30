package com.example.mvplogin.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvplogin.screens.register.RegisterContract;

public class RegisterModel implements RegisterContract.Imodel {

    Context context;
    private static final String  EMAIL="email";
    private static final String  PASSWORD="password";
    SharedPreferences pref;
    public RegisterModel(Context context)
    {
        this.context=context;
    }

    @Override
    public String adduser(String email, String password)
    {
        pref = context.getSharedPreferences("Pref", 0);

            SharedPreferences.Editor editor = pref.edit();
            editor.putString(EMAIL,email);
            editor.putString(PASSWORD,password);
            editor.commit(); // commit changes

        return "Registered Successfully";
    }

    @Override
    public boolean checkUser(String email, String password) {
        boolean ckeck=false;
        pref = context.getSharedPreferences("Pref", 0);
        String userEmial=pref.getString(EMAIL,"");
        String userPassword = pref.getString(PASSWORD,"");
        if(userEmial.equals(email)&&userPassword.equals(password))
        {
            ckeck=true;
        }
        return  ckeck;
    }
}
