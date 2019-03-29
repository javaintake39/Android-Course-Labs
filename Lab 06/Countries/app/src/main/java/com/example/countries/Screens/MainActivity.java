package com.example.countries.Screens;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.countries.Model.CountryPojo;
import com.example.countries.Model.network.JsonParser;
import com.example.countries.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.Iview
{
    TextView txtRank,txtCountry,txtPopulation;
    Button btnPrev,btnNext;
    ImageView imgFlag;
    MainContract.Ipresenter ipresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ipresenter=new MainPresenter(this);
        initComponents();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipresenter.nextButton();
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipresenter.previousButton();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
    }


    public void initComponents()
    {
        txtRank=(TextView)findViewById(R.id.txtRank);
        txtCountry=(TextView)findViewById(R.id.txtCountry);
        txtPopulation=(TextView)findViewById(R.id.txtPopulation);
        btnPrev=(Button)findViewById(R.id.btnPrev) ;
        btnNext=(Button)findViewById(R.id.btnNext);
        imgFlag=(ImageView)findViewById(R.id.imgFlag);
    }


    private boolean checkInternetConnection()
    {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public ImageView getImage() {
        return imgFlag;
    }

    @Override
    public void showData(final CountryPojo countryPojo)
    {
       MainActivity.this.runOnUiThread(new Runnable() {
           @Override
           public void run() {
               txtRank.setText(countryPojo.getRank());
               txtCountry.setText(countryPojo.getCountry());
               txtPopulation.setText(countryPojo.getPopulation());
           }
       });
    }


}
