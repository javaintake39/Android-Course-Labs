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
    public  String url = "https://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    public ArrayList<CountryPojo> countryList = new ArrayList();
    JsonParser parser;
    MyAsyncTask task;
    public MainContract.Ipresenter presenter;

    public networkService(final MainContract.Ipresenter presenter)
    {
        this.presenter=presenter;
        parser = new JsonParser();
        workerThread(url);
    } // End of Constructor

    /*
    this workerThread make background operation using thread
     */
    private void workerThread(final String link)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonObjectAsString = getJsonObjectFromURL(link); // get jsonObject as String from given URL
                countryList=parser.JsonProcess(jsonObjectAsString);    // JsonProcess take jsonObjectAsString - > arrayList of Countries
                presenter.fillCountryList(parser.getlist());            // send countryList to presenter
                presenter.showData(countryList.get(0));                // showData first time when  App launchs
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

    public void AsyncTaskcaller(String picURL)
    {
        task=new MyAsyncTask(presenter);
        task.execute(picURL);
     }

} // end of networkService class

