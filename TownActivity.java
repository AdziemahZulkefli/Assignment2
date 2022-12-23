package com.example.auth;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.auth.databinding.ActivityTownBinding;

import java.io.IOException;
import java.util.ArrayList;

public class TownActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityTownBinding binding;

    // below are the latitude and longitude
    // of 15 different locations.
    LatLng Melaka = new LatLng(2.1971, 1102.249);
    LatLng KualaLumpur = new LatLng(3.1412, 101.68653);
    LatLng Putrajaya = new LatLng( 2.93527, 101.69112);
    LatLng Muar = new LatLng(2.039272, 102.569092);
    LatLng PasirGudang = new LatLng(1.4666667, 103.8833333);
    LatLng PortDickson = new LatLng(2.522540, 101.796295);
    LatLng Nilai = new LatLng( 2.8122617, 101.780868);
    LatLng KotaBharu = new LatLng(6.139872, 102.242203);
    LatLng Temerloh = new LatLng(3.448649, 102.416348);
    LatLng Ipoh = new LatLng(4.5841, 101.0829);
    LatLng Kangar = new LatLng( 6.4414, 100.19862);
    LatLng Georgetown = new LatLng(6.80448, -58.15527);
    LatLng KotaKinabalu = new LatLng(5.9749, 116.0724);
    LatLng Kuching = new LatLng(  1.607681 , 110.378544);
    LatLng Dungun = new LatLng(4.756459, 103.399681);

    private ArrayList<LatLng> locationArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // in below line we are initializing our array list.
        locationArrayList = new ArrayList<>();

        // on below line we are adding our
        // locations in our array list.
        locationArrayList.add(Melaka);
        locationArrayList.add(KualaLumpur);
        locationArrayList.add(Putrajaya);
        locationArrayList.add(Muar);
        locationArrayList.add(PasirGudang);
        locationArrayList.add(PortDickson);
        locationArrayList.add(Nilai);
        locationArrayList.add(KotaBharu);
        locationArrayList.add(Temerloh);
        locationArrayList.add(Ipoh);
        locationArrayList.add(Kangar);
        locationArrayList.add(Georgetown);
        locationArrayList.add(KotaKinabalu);
        locationArrayList.add(Kuching);
        locationArrayList.add(Dungun);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // inside on map ready method
        // we will be displaying all our markers.
        // for adding markers we are running for loop and
        // inside that we are drawing marker on our map.
        for (int i = 0; i < locationArrayList.size(); i++) {

            // below line is use to add marker to each location of our array list.
            mMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Marker"));

            // below line is use to zoom our camera on map.
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));

            // below line is use to move our camera to the specific location.
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList.get(i)));
        }
    }
}
