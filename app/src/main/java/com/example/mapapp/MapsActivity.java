package com.example.mapapp;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapapp.data.Channel;
import com.example.mapapp.data.Item;
import com.example.mapapp.service.WeatherServiceCallback;
import com.example.mapapp.service.YahooWeatherService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, WeatherServiceCallback {

    public GoogleMap mMap;
    private YahooWeatherService service;
    private TextView temperatureTextView;
    private TextView locationTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        service = new YahooWeatherService(this);

        service.refreshWeather("Vilnius");
        locationTextView = (TextView) findViewById(R.id.locationTextView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng kaunas = new LatLng(54.8985, 23.9036);
        LatLng vilnius = new LatLng(54.6872, 25.2797);
        mMap.addMarker(new MarkerOptions()
                .position(kaunas)
                .title("Kaunas"));
        mMap.addMarker(new MarkerOptions()
                .position(vilnius)
                .title("Vilnius"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kaunas));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(vilnius));
    }

    @Override
    public void serviceSuccess(Channel channel) {
        Item item = channel.getItem();

        locationTextView.setText(service.getLocation());
        temperatureTextView.setText(item.getCondition().getTemp());

    }

    @Override
    public void serviceFailure(Exception exception) {
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
