package com.example.retrofitdemo.Screens;

import com.example.retrofitdemo.Model.postPojo;

import java.util.ArrayList;

public interface MainContract {

    public interface Iview
    {
        public void getPostList(ArrayList<postPojo> posts);
        public void getPost(postPojo pojo);
    }
    public interface Ipresenter
    {
        void loadData();
        void getPostList(ArrayList<postPojo> posts);
    }
    public interface IService
    {
        public void fillList();
    }

}
