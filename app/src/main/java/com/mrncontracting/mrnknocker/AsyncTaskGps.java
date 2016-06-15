package com.mrncontracting.mrnknocker;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.ContentLoadingProgressBar;

/**
 * Created by Alyssa on 5/5/2016.
 */
public class AsyncTaskGps extends AsyncTask implements LocationListener {
    public Location location;
    public Context context;

    @Override
    protected Object doInBackground(Object... arg0) {
        LocationManager lm = (LocationManager) arg0[0];
        context = (Context)arg0[1];
        Looper.prepare();
        // Request GPS updates. The third param is the looper to use, which defaults the the one for
        // the current thread.
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        lm.requestSingleUpdate(LocationManager.GPS_PROVIDER, this, null);
        Looper.loop(); // start waiting...when this is done, we'll have the location in this.location


        return null;
    }

    @Override
    protected void onPostExecute(Object result) {
        // notify someone we are done...
    }

    @Override
    public void onLocationChanged(Location location) {
        // Store the location, then get the current thread's looper and tell it to
        // quit looping so it can continue on doing work with the new location.
        this.location = location;
        Looper.myLooper().quit();
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

}
