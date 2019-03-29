package com.example.mvpdemo.Model;

public class MainContract {

    public interface Iview
    {
        public void setData(String data);
    }

    public interface Ipresenter
    {
        public void onButtonClicked();
    }

    public interface Imodel
    {
        public String getData();
    }
}
