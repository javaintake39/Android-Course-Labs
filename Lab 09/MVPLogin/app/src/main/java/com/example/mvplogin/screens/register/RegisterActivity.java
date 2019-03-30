package com.example.mvplogin.screens.register;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvplogin.R;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.Iview {

    RegisterContract.Ipresenter ipresenter;
    EditText edtemailregister,edtpasswordregister;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtemailregister=(EditText) findViewById(R.id.edtemailregister);
        edtpasswordregister=(EditText) findViewById(R.id.edtpasswordregister);
        ipresenter=new RegisterPresenter(this);
    }
    public void registeruser(View view)
    {
        email=edtemailregister.getText().toString();
        password=edtpasswordregister.getText().toString();
        ipresenter.adduser(email,password);
    }

    @Override
    public void showResult(String result)
    {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext()
    {
        return super.getApplicationContext();
    }
}
