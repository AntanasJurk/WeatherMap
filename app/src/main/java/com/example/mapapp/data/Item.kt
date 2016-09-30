package com.example.mapapp.data

import org.json.JSONObject

/**
 * Created by ext-jurkeant on 9/28/2016.
 */

class Item : JSONPopulator {
    var condition: Condition? = null
        private set
    var latitude: Double = 0.toDouble()
        private set
    var longtitude: Double = 0.toDouble()
        private set

    override fun populate(data: JSONObject) {
        condition = Condition()
        condition!!.populate(data.optJSONObject("condition"))
        latitude = data.optDouble("latitude")
        longtitude = data.optDouble("longtitude")
    }

}
