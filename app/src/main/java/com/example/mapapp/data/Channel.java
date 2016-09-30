package com.example.mapapp.data;

import org.json.JSONObject;

/**
 * Created by ext-jurkeant on 9/28/2016.
 */

public class Channel implements JSONPopulator {


    private Item item;
    @Override
    public void populate(JSONObject data) {
        item = new Item();
        item.populate(data.optJSONObject("item"));
    }


    public Item getItem() {
        return item;
    }
}
