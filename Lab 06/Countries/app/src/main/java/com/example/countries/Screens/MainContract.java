package com.example.countries.Screens;


import android.graphics.Bitmap;
import android.widget.ImageView;
import com.example.countries.Model.CountryPojo;
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
        ImageView getImage();
        void setImage(Bitmap bitmap);
        void setCountryList(ArrayList<CountryPojo> countryList);
        void nextButton();
        void previousButton();
        void showData(CountryPojo countryPojo);
    }
}