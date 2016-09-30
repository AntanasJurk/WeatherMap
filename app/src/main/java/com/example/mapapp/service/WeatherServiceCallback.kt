package com.example.mapapp.service

import com.example.mapapp.data.Channel

/**
 * Created by ext-jurkeant on 9/28/2016.
 */

interface WeatherServiceCallback {
    fun serviceSuccess(channel: Channel)
    fun serviceFailure(exception: Exception)
}
