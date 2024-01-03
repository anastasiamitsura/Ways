package com.example.ways;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ways.databinding.ActivityMainBinding;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MapController mMapController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.mapView.setTileSource(TileSourceFactory.HIKEBIKEMAP);
        binding.mapView.setClickable(true);
        binding.mapView.setMultiTouchControls(true);
        mMapController = (MapController) binding.mapView.getController();
        mMapController.setZoom(13);
        GeoPoint gPt = new GeoPoint(29.624471, 52.523935);
        mMapController.setCenter(gPt);

    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        binding.mapView.onPause();
    }
}
