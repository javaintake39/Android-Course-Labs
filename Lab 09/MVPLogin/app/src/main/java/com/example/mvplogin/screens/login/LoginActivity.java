package com.example.mvplogin.screens.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvplogin.R;
import com.example.mvplogin.screens.main.MainActivity;
import com.example.mvplogin.screens.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.Iview {

    EditText edtemailLogin,edtpasswordLogin;
    String email,password;
    LoginContract.Ipresenter ipresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ipresenter=new LoginPresenter(this);
        edtemailLogin=(EditText) findViewById(R.id.edtemailLogin);
        edtpasswordLogin=(EditText) findViewById(R.id.edtpasswordLogin);
    }

    public void checklogin(View view) // Login Button
    {
        email=edtemailLogin.getText().toString();
        password=edtpasswordLogin.getText().toString();
        ipresenter.checkUser(email,password);
    }

    public void registeruser(View view) // Register Button
    {
        Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void showErrorMessage(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
    @Override
    public Context getContext() {
        return super.getApplicationContext();
    }

    @Override
    public void showCountryList()
    {
        Intent mainIntent=new Intent(LoginActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }
}
