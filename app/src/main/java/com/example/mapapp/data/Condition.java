package com.example.mapapp.data;

import org.json.JSONObject;

/**
 * Created by ext-jurkeant on 9/28/2016.
 */

public class Condition implements JSONPopulator {

    private String temp;

    @Override
    public void populate(JSONObject data) {
        temp=data.optString("temp");
    }

    public String getTemp() {
        return temp;
    }
}
