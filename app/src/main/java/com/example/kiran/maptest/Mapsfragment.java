package com.example.kiran.maptest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by kiran on 3/1/16.
 */
public class Mapsfragment extends Fragment {

    private static GoogleMap mMap;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=(RelativeLayout) inflater.inflate(R.layout.fragment_maps,container,false);
        if(v==null)
        Log.d("error","no view");
        setUpMapIfNeeded();
        return v;
    }

    public void setUpMapIfNeeded(){

        if(mMap==null)
        {
            mMap=((SupportMapFragment) MapsActivity.fragmentManager.findFragmentById(R.id.location_map)).getMap();
            if(mMap==null)
                Log.d("error","no map");
        }
        if(mMap!=null)
            setUpMap();
    }

    public void setUpMap(){

        mMap.setMyLocationEnabled(true);
        mMap.addMarker(new MarkerOptions().position(new LatLng(26.78,72.56)).title("Home").snippet("Add"));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (mMap != null)
            setUpMap();

        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) MapsActivity.fragmentManager
                    .findFragmentById(R.id.location_map)).getMap();}
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mMap != null) {
            MapsActivity.fragmentManager.beginTransaction()
                    .remove(MapsActivity.fragmentManager.findFragmentById(R.id.location_map)).commit();
            mMap = null;
        }
    }
}
