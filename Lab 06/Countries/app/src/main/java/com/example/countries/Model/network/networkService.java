package com.example.countries.Model.network;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.countries.Model.CountryPojo;
import com.example.countries.Screens.MainContract;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class networkService
{
    public static final String TAG="tag";
    public final String url = "https://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    public ArrayList<CountryPojo> countryList = new ArrayList();
    private Handler handler;
    JsonParser parser = new JsonParser();
    MyAsyncTask task;
    public MainContract.Ipresenter presenter;

    public networkService(final MainContract.Ipresenter presenter)
    {
        this.presenter=presenter;
        task=new MyAsyncTask(presenter);
        workerThread(url);
        handler=new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                presenter.setCountryList(getCountriesList());
            }
        };
    } // End of Constructor

    public void workerThread(final String link)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonObjectAsString = getJsonObjectFromURL(link);
                Log.i(TAG,jsonObjectAsString);
                countryList=parser.JsonProcess(jsonObjectAsString);
                task.execute(countryList.get(0).getFlag());
                handler.sendEmptyMessage(0);
            }
        });
        thread.start();
    }
    private String getJsonObjectFromURL(String urlLink)
    {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String data="";
        try {
            StringBuffer buffer = new StringBuffer();
            URL url = new URL(urlLink);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while ((line = reader.readLine()) != null) {

                buffer.append(line + "\n");
            }
            data = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;

    }
    private ArrayList<CountryPojo> getCountriesList()
    {
        return countryList;
    }

    public void startAsyncTask(String picURL)
    {
        task=new MyAsyncTask(presenter);
      task.execute(picURL);
     }

} // end of networkService class

