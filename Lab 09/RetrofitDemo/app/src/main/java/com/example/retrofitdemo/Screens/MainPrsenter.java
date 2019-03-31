package com.example.retrofitdemo.Screens;

import com.example.retrofitdemo.Model.network.networkService;
import com.example.retrofitdemo.Model.postPojo;

import java.util.ArrayList;

public class MainPrsenter implements MainContract.Ipresenter
{
    MainContract.Iview view;
    ArrayList<postPojo> postsList;
    networkService service;


    public MainPrsenter(MainContract.Iview view)
    {
        this.view=view;
        service=new networkService(this);
        postsList=new ArrayList<>();
    }

    @Override
    public void loadData()
    {
        service.fillList(); // this
    }

    @Override
    public void getPostList(ArrayList<postPojo> posts)
    {
        postsList=posts;
        view.getPostList(postsList);
    }

}
