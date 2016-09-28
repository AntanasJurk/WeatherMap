package com.example.mapapp.service;

import com.example.mapapp.data.Channel;

/**
 * Created by ext-jurkeant on 9/28/2016.
 */

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
