package com.example.mvplogin.screens.main;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.mvplogin.model.CountryPojo;

import java.util.ArrayList;

public interface MainContract
{
    public interface Iview
    {
        ImageView getImage();
        void showData(CountryPojo countryPojo);
    }
    public interface Ipresenter
    {
        void setImage(Bitmap bitmap);
        void fillCountryList(ArrayList<CountryPojo> countryList);
        void nextButton();
        void previousButton();
        void showData(CountryPojo countryPojo);
    }
}