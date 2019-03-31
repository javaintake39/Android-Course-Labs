package com.example.retrofitdemo.Model.network;

import com.example.retrofitdemo.Model.postPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonParser {

    ArrayList<postPojo> postsList;

    public ArrayList<postPojo> JsonProcess(String jsonFile) {

        postsList = new ArrayList<>();
        try {

            JSONArray mainJsonArray = new JSONArray(jsonFile);
            for (int i = 0; i < mainJsonArray.length(); i++) {

                JSONObject jsonObject = mainJsonArray.getJSONObject(i);

                postPojo encap = new postPojo
                        (
                                jsonObject.getInt(KeyTags.userIdKey),
                                jsonObject.getInt(KeyTags.idKey),
                                jsonObject.getString(KeyTags.titleKey),
                                jsonObject.getString(KeyTags.bodyKey)
                        );
                postsList.add(encap);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return postsList;
    }

    public ArrayList<postPojo> getlist()
    {
        return postsList;
    }
}