package com.example.retrofitdemo.Model.network;

import android.util.Log;

import com.example.retrofitdemo.Model.postPojo;
import com.example.retrofitdemo.Screens.MainContract;
import com.example.retrofitdemo.Screens.MainPrsenter;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class networkService implements MainContract.IService
{
    MainContract.Ipresenter presenter;
    Retrofit retrofit;
    jsonPlaceholderService placeholderService;
    ArrayList<postPojo> postsList;
    JsonParser parser;
    public static final String baseUrl="https://jsonplaceholder.typicode.com/";
    public networkService(MainPrsenter mainPrsenter)
    {
        presenter=mainPrsenter;
        postsList=new ArrayList<>();
        parser=new JsonParser();
    }
    @Override
    public void fillList()
    {
                retrofit=new Retrofit.Builder().baseUrl(baseUrl).build();
                placeholderService=retrofit.create(jsonPlaceholderService.class);
                Log.i("tag","ok");
                placeholderService.getPosts().enqueue(new Callback<ResponseBody>() 
                {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String json=response.body().string();
                            Log.i("tag",json);
                            postsList=parser.JsonProcess(json);
                            presenter.getPostList(postsList);
                            Log.i("tag",postsList.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                    }
                });
    }
}
