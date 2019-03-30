package com.example.mvpdemo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mvpdemo.Model.MainContract;
import com.example.mvpdemo.Model.MainContract.Iview;
import com.example.mvpdemo.Presenter.MainPresenter;
import com.example.mvpdemo.R;

public class MainActivity extends AppCompatActivity implements Iview {

    TextView txtData;
    MainContract.Ipresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtData=(TextView) findViewById(R.id.txtData);
        mainPresenter=new MainPresenter(this);
    }

    public void changeText(View view) {
        mainPresenter.onButtonClicked();
    }

    @Override
    public void setData(String data) {
        txtData.setText(data);
    }
}
