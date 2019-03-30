package com.example.countriesfromscratch.Screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.countriesfromscratch.Model.CountryPojo;
import com.example.countriesfromscratch.R;

public class MainActivity extends AppCompatActivity implements MainContract.Iview {

    TextView txtRank,txtCountry,txtPopulation;
    Button btnPrev,btnNext;
    ImageView imgFlag;
    MainContract.Ipresenter ipresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        ipresenter=new MainPresenter(this);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipresenter.nextClicked();
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ipresenter.previousClicked();
            }
        });

    }

    private void initComponents()
    {
        txtRank=(TextView)findViewById(R.id.txtRank);
        txtCountry=(TextView)findViewById(R.id.txtCountry);
        txtPopulation=(TextView)findViewById(R.id.txtPopulation);
        btnPrev=(Button)findViewById(R.id.btnPrev) ;
        btnNext=(Button)findViewById(R.id.btnNext);
        imgFlag=(ImageView)findViewById(R.id.imgFlag);
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
