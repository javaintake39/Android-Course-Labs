package com.example.countries.Model.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.example.countries.Screens.MainActivity;
import com.example.countries.Screens.MainContract;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyAsyncTask extends AsyncTask<String, Void, Bitmap>
{

    MainContract.Ipresenter presenter;
    public MyAsyncTask(MainContract.Ipresenter presenter) {
        this.presenter = presenter;
    }
    @Override
    protected Bitmap doInBackground(String... url)
    {
        Bitmap result = null;
        try {
            result = downloadImage(url [0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    protected void onPostExecute(Bitmap bitmap)
    {
        super.onPostExecute(bitmap);
       presenter.setImage(bitmap);
    }
    private Bitmap downloadImage(String url) throws IOException {
        Bitmap result=null;
        URL urlObject ;
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        try {
            urlObject=new URL(url);
            httpURLConnection = (HttpURLConnection)urlObject.openConnection();
            httpURLConnection.connect();

            inputStream= httpURLConnection.getInputStream();
            result = BitmapFactory.decodeStream(inputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(inputStream !=null)
                inputStream.close();
        }
        return result;
    }
}