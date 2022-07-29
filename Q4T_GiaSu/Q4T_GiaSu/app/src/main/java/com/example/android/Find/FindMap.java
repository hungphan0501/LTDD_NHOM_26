package com.example.android.Find;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.giasu.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FindMap extends Fragment implements OnMapReadyCallback {
    GoogleMap google_Map;
    SupportMapFragment mapFragment;
    SearchView searchView;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_find2,container,false);
        return v;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        google_Map=googleMap;
        LatLng sydney=new LatLng(10.871472401416693, 106.79000535285431);
        google_Map.addMarker(new MarkerOptions().position(sydney).title("Phan Văn Hùng"));

        LatLng sydney1=new LatLng(10.850608146084644, 106.76586923324291);
        google_Map.addMarker(new MarkerOptions().position(sydney1).title("Nguyễn Ngọc Hiếu"));

        LatLng sydney2=new LatLng(10.829910196000462, 106.72034369749014);
        google_Map.addMarker(new MarkerOptions().position(sydney2).title("Trần VŨ Lam"));
    }
}
