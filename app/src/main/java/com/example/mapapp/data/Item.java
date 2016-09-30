package com.example.mapapp.data;

import org.json.JSONObject;

/**
 * Created by ext-jurkeant on 9/28/2016.
 */

public class Item implements JSONPopulator {
    private Condition condition;
    private double latitude;
    private double longtitude;

    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));
        latitude = data.optDouble("latitude");
        longtitude = data.optDouble("longtitude");
    }

    public Condition getCondition() {
        return condition;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }
}
