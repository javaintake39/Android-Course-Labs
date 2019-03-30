package com.example.mvplogin.model.network;



import com.example.mvplogin.model.CountryPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    ArrayList<CountryPojo> data;

    public ArrayList<CountryPojo> JsonProcess(String jsonFile) {

        data = new ArrayList<>();
        try {
            JSONObject mainObject = new JSONObject(jsonFile);
            JSONArray jsonArray = mainObject.getJSONArray("worldpopulation");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                CountryPojo encap = new CountryPojo
                        (
                        mainObjectArray.getString(KeyTags.rankKey),
                        mainObjectArray.getString(KeyTags.countryKey),
                        mainObjectArray.getString(KeyTags.populationKey),
                        mainObjectArray.getString(KeyTags.flagKey)
                         );
                data.add(encap);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<CountryPojo> getlist()
    {
        return data;
    }
}