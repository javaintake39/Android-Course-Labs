package com.example.countriesfromscratch.Screens;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.countriesfromscratch.Model.CountryPojo;

import java.util.ArrayList;

public interface MainContract {

    public interface Iview
    {
        ImageView getImage();
        void showData(CountryPojo countryPojo);
    }
    public interface Ipresenter
    {
        void setImage(Bitmap bitmap);
        void fillCountryList(ArrayList<CountryPojo> arrayList);
        void nextClicked();
        void previousClicked();
        void showData(CountryPojo countryPojo);

    }
}
