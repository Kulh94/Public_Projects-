package com.example.smartcityambiance.Transport;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.smartcityambiance.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class TransportInfoActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;

    //The URL for the barchart: https://www.android-examples.com/create-bar-chart-graph-using-mpandroidchart-library/
    //We used it as a pattern and took some changes to make it fit for our environment and design
    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;

    //defining default android studio maps
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_info);

        //in this block blow the chart is simply set, the values initialized and the design adjusted
        chart = (BarChart) findViewById(R.id.chart1);
        BARENTRY = new ArrayList<>();
        BarEntryLabels = new ArrayList<String>();
        AddValuesToBARENTRY();
        AddValuesToBarEntryLabels();
        Bardataset = new BarDataSet(BARENTRY, "Projects");
        BARDATA = new BarData(BarEntryLabels, Bardataset);
        Bardataset.setColor(Color.WHITE);
        Bardataset.setHighLightColor(Color.CYAN);
        chart.setData(BARDATA);
        chart.animateY(3500);
        chart.setBackgroundColor(Color.DKGRAY);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        // Add a marker in Vienna and position the camera view
        LatLng vienna = new LatLng(48.185188   , 16.376592);
        mMap.addMarker(new MarkerOptions().position(vienna).title("Südtiroler Platz main train station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vienna,15));

    }

    public void AddValuesToBARENTRY(){

        BARENTRY.add(new BarEntry(3f, 0));
        BARENTRY.add(new BarEntry(4f, 1));
        BARENTRY.add(new BarEntry(6f, 2));
        BARENTRY.add(new BarEntry(5f, 3));
        BARENTRY.add(new BarEntry(9f, 4));
        BARENTRY.add(new BarEntry(11f, 5));
        BARENTRY.add(new BarEntry(10f, 6));
        BARENTRY.add(new BarEntry(6f, 7));
        BARENTRY.add(new BarEntry(5f, 8));
        BARENTRY.add(new BarEntry(8f, 9));
        BARENTRY.add(new BarEntry(9f, 10));
        BARENTRY.add(new BarEntry(11f, 11));
        BARENTRY.add(new BarEntry(11f, 12));
        BARENTRY.add(new BarEntry(10f, 13));
        BARENTRY.add(new BarEntry(7f, 14));
    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add("09:00");
        BarEntryLabels.add("10:00");
        BarEntryLabels.add("11:00");
        BarEntryLabels.add("12:00");
        BarEntryLabels.add("13:00");
        BarEntryLabels.add("14:00");
        BarEntryLabels.add("15:00");
        BarEntryLabels.add("16:00");
        BarEntryLabels.add("17:00");
        BarEntryLabels.add("18:00");
        BarEntryLabels.add("19:00");
        BarEntryLabels.add("20:00");
        BarEntryLabels.add("21:00");
        BarEntryLabels.add("22:00");
        BarEntryLabels.add("23:00");
    }

}