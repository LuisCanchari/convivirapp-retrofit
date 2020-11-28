package edu.cientifica.convivirapp.view.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import edu.cientifica.convivirapp.R;


public class MapUbicacionFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_ubicacion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Fragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        //mapFragment


        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoom = 16f;
        double latitud, longitud;
        latitud=-12.2226549;
        longitud=-76.9768628;
        LatLng miubicacion = new LatLng(latitud,longitud);

        MarkerOptions marker;
        marker = new MarkerOptions();
        marker.title("Universidad Cientifica del Sur");
        //marker.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_vivienda));
        marker.anchor(0.0f, 0.1f);
        marker.position(miubicacion);

        mMap.addMarker(marker);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(miubicacion,zoom));

        //mMap.addMarker(new MarkerOptions().position(miubicacion).title("Universidad Cientifica"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(miubicacion));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(miubicacion,zoom));
        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(miubicacion,zoom));

      //  mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory).for)

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}