package com.example.countries.Screens;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.example.countries.Model.CountryPojo;
import com.example.countries.Model.network.networkService;

import java.util.ArrayList;


public class MainPresenter implements MainContract.Ipresenter {

    MainContract.Iview view;
    com.example.countries.Model.network.networkService networkService;
    ArrayList<CountryPojo> countryList;
    CountryPojo countryPojo;
    private int counter=0;

    public  MainPresenter(MainContract.Iview view)
    {
        this.view=view;
        networkService=new networkService(this);
    }

    @Override
    public void setImage(Bitmap bitmap)
    {
        view.getImage().setImageBitmap(bitmap);
    }

    @Override
    public void fillCountryList(ArrayList<CountryPojo> countryList)

    {
        this.countryList=countryList;
    }

    @Override
    public void nextButton()
    {
            if(counter<9)
            {
                counter++;
            }
            else
            {
                counter=0;
            }
            countryPojo=countryList.get(counter);
            showData(countryPojo);
    }

    @Override
    public void previousButton()
    {
        if(counter==0)
        {
            counter=9;
        }
        else
        {
            counter--;
        }
            countryPojo=countryList.get(counter);
            showData(countryPojo);

    }

    @Override
    public void showData(CountryPojo countryPojo)
    {
        view.showData(countryPojo);
        networkService.AsyncTaskcaller(countryPojo.getFlag());
    }

}
