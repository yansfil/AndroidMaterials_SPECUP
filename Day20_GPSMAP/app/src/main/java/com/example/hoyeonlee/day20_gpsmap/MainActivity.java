package com.example.hoyeonlee.day20_gpsmap;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView locationText;
    Button gpsButton;
    Button mapButtton;
    LocationManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();

        locationText = findViewById(R.id.tv_location);
        gpsButton = findViewById(R.id.btn_gps);
        mapButtton = findViewById(R.id.btn_map);

        //GPS 관리해주는 Class
        lm  = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //GPS를 켜서 위치정보를 받아온다.
        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. GPS, Network가 켜져있는지 확인한다.
                if(lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
                        || lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
                    //2 켜져있다면...
                    lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,5000,0,listener);
                    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,0,listener);
                }else{
                    //3 안켜져있다면...
                    Toast.makeText(MainActivity.this, "GPS, Network를 켜주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //구글 지도 액티비티로 넘어간다.
        mapButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapActivity.class);
                startActivity(intent);
            }
        });
    }
    //위치정보를 받았을 때 처리해주는 Listener
    LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            locationText.setText(String.format("경도 : %f 위도 : %f",lat,lng));
            Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
            try {
                List<Address> addresses = geocoder.getFromLocation(lat,lng,1);
                Address address = addresses.get(0);
                locationText.setText(address.getAddressLine(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };


    void checkPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            //클라이언트가 권한을 허락했을 때
            return ;
        }else{
            //클라이언트가 권한을 거부하거나 설정하지 않았을 때
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
        }
    }
}








