package com.example.mapapp.data

import org.json.JSONObject

/**
 * Created by ext-jurkeant on 9/28/2016.
 */

class Condition : JSONPopulator {

    var temp: String? = null
        private set

    override fun populate(data: JSONObject) {
        temp = data.optString("temp")
    }
}
