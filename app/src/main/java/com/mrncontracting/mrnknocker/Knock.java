package com.mrncontracting.mrnknocker;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.List;
import java.util.Locale;

public class Knock extends AppCompatActivity implements OnMapReadyCallback {//} implements OnMapReadyCallback, LocationListener {


    GoogleMap mMap;
    LocationManager mLocationManager;
    public static Location currentLocation;
    private static Double lat = 0.0;
    private static Double lng = 0.0;

    String address;
    String city;
    String state;
    String zip;
    String country;

    static String knockaddress = "";
    static List<Address> addresses;

    LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            currentLocation = location;

        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knock);

        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        AsyncTaskGps updateTask = new AsyncTaskGps();
        try { updateTask.execute(mLocationManager, this).get(); } catch (Exception ex){}

        currentLocation = updateTask.location;

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }



    @Override
    protected void onResume() {
        super.onResume();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setBuildingsEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setIndoorEnabled(true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //currentLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(currentLocation != null) {
            lat = currentLocation.getLatitude();
            lng = currentLocation.getLongitude();
        }
        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 18));
        //mMap.setMyLocationEnabled(true);




    }

    public void getNewLocation(View view) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        AsyncTaskGps updateTask = new AsyncTaskGps();
        try { updateTask.execute(mLocationManager, this).get(); } catch (Exception ex){}

        currentLocation = updateTask.location;

        lat = currentLocation.getLatitude();
        lng = currentLocation.getLongitude();
        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 18));

        refreshLocation();
    }

    public void refreshLocation() {

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(currentLocation.getLatitude(), currentLocation.getLongitude(), 1);

            address = addresses.get(0).getAddressLine(0);
            city = addresses.get(0).getLocality();
            state = addresses.get(0).getAdminArea();
            zip = addresses.get(0).getPostalCode();
            country = addresses.get(0).getCountryName();

            knockaddress = address + ", " + city + ", " + zip;

            TextView you_are_at = (TextView)findViewById(R.id.current_address_label);
            you_are_at.setText("You are at: " + knockaddress);
        }
        catch(Exception ex){
            System.out.println("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRr");
        }
    }


    public void knocking(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Verify Location")
                .setMessage("Did the map look correct? This is the address we are seeing: \n\n" + knockaddress
                + "\n\nIf this is incorrect hit cancel and refresh your location.")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Members.setLatitude(lat);
                        Members.setLongitude(lng);
                        Members.setAddress(knockaddress);
                        Members.setCity(city);
                        Members.setState(state);
                        Members.setZip(zip);

                        continueToKnockResponse();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void continueToKnockResponse(){
        Intent i = new Intent(this, SelectResponse.class);
        startActivity(i);
    }

    /*@Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
*/
   /* @Override
    public void onLocationChanged(Location location) {
        System.out.println("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRr");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }*/
}
