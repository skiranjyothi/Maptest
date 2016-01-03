package com.example.kiran.maptest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    public static android.support.v4.app.FragmentManager fragmentManager;
    private static final LatLng OAT =  new LatLng(12.98901266,80.23360491);
    private static final LatLng SAC =  new LatLng(12.98932629,80.23770869);
    private static final LatLng CRC =  new LatLng(12.9899062,80.2303675);
    private static final LatLng CLT =  new LatLng(12.9895429,80.2318990);
    private static final LatLng ICSR =  new LatLng(12.99174122,80.23208678);
    private static final LatLng Initial =  new LatLng(12.9923294,80.2368454);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        fragmentManager=getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
     //   setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Initial, 17));
        googleMap.addMarker(new MarkerOptions().position(OAT).title("OAT")).showInfoWindow();
        googleMap.addMarker(new MarkerOptions().position(CRC).title("CRC")).showInfoWindow();
        googleMap.addMarker(new MarkerOptions().position(CLT).title("CLT")).showInfoWindow();
        googleMap.addMarker(new MarkerOptions().position(ICSR).title("ICSR")).showInfoWindow();
        googleMap.addMarker(new MarkerOptions().position(SAC).title("SAC")).showInfoWindow();

    }
}
