package com.example.countries.Screens;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.example.countries.Model.CountryPojo;
import com.example.countries.Model.network.networkService;

import java.util.ArrayList;


public class MainPresenter implements MainContract.Ipresenter {

    MainContract.Iview view;
    ImageView imageView;
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
    public ImageView getImage() {
        imageView=view.getImage();
        return  imageView;
    }
    @Override
    public void setImage(Bitmap bitmap) {
        getImage().setImageBitmap(bitmap);
    }

    @Override
    public void setCountryList(ArrayList<CountryPojo> countryList) {
        this.countryList=countryList;
    }
    @Override
    public void nextButton() {
            if(counter<9)
            {
                counter++;
            }
            else
            {
                counter=0;
            }
            countryPojo=countryList.get(counter);
            view.showData(countryPojo);
            networkService.startAsyncTask(countryPojo.getFlag());
    }

    @Override
    public void previousButton() {
        if(counter==0)
        {
            counter=9;
        }
        else
        {
            counter--;
        }
            countryPojo=countryList.get(counter);
            view.showData(countryPojo);
            networkService.startAsyncTask(countryPojo.getFlag());

    }

    @Override
    public void showData(CountryPojo countryPojo) {
        view.showData(countryPojo);
    }

}
