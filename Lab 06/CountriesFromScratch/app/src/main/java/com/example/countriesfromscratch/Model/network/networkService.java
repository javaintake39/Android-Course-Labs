package com.example.countriesfromscratch.Model.network;

import com.example.countriesfromscratch.Model.CountryPojo;
import com.example.countriesfromscratch.Screens.MainContract;
import com.example.countriesfromscratch.Screens.MainPresenter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class networkService {
    public  String url = "https://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    ArrayList<CountryPojo> countryList= new ArrayList();
    JsonParser parser;
    MainContract.Ipresenter presenter;
    MyAsyncTask task;

    public networkService(MainContract.Ipresenter ipresenter)
    {
        this.presenter=ipresenter;
        parser=new JsonParser();
        workerThread(url);
    }

    private void workerThread(final String url)
    {
        Thread worker=new Thread(new Runnable() {
            @Override
            public void run() {
             String jsonObjectAsString = getJsonObjectFromURL(url);
             countryList=parser.JsonProcess(jsonObjectAsString);
             presenter.fillCountryList(parser.getlist());
             presenter.showData(countryList.get(0));
            }
        });
        worker.start();
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

    public void AsyncLoader(String imageUrl)
    {
        task=new MyAsyncTask(presenter);
        task.execute(imageUrl);

    }

}
