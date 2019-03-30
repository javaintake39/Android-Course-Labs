package com.example.countriesfromscratch.Screens;

import android.graphics.Bitmap;

import com.example.countriesfromscratch.Model.CountryPojo;
import com.example.countriesfromscratch.Model.network.networkService;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Ipresenter
{
    ArrayList<CountryPojo> countryList;
    MainContract.Iview view;
    networkService  networkservice;
    CountryPojo countryPojo;
    int counter=0;
    public MainPresenter(MainContract.Iview view)
    {
        this.view=view;
        networkservice=new networkService(this);
    }
    @Override
    public void setImage(Bitmap bitmap)
    {
        view.getImage().setImageBitmap(bitmap);
    }

    @Override
    public void fillCountryList(ArrayList<CountryPojo> arrayList)
    {
        countryList=arrayList;
    }

    @Override
    public void nextClicked() {
            if(counter<9)
            {
                counter++;
            }
            else{
                counter=0;
            }
            countryPojo=countryList.get(counter);
            showData(countryPojo);
    }

    @Override
    public void previousClicked() {
        if(counter==0)
        {
            counter=9;
        }
        else{
            counter--;
        }
        countryPojo=countryList.get(counter);
        showData(countryPojo);
    }

    @Override
    public void showData(CountryPojo countryPojo)
    {
        view.showData(countryPojo);
        networkservice.AsyncLoader(countryPojo.getFlag());
    }
}
