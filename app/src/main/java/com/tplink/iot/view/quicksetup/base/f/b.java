package com.tplink.iot.view.quicksetup.base.f;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import b.d.w.c.a;

/* compiled from: TPLocationListener.java */
/* loaded from: classes2.dex */
public class b implements LocationListener {
    private String a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private LocationListener f9531b;

    /* renamed from: c  reason: collision with root package name */
    private LocationManager f9532c;

    public b(LocationListener locationListener, LocationManager locationManager) {
        this.f9531b = locationListener;
        this.f9532c = locationManager;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        LocationManager locationManager = this.f9532c;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this);
            } catch (SecurityException e2) {
                a.c(this.a, Log.getStackTraceString(e2));
            }
        }
        LocationListener locationListener = this.f9531b;
        if (locationListener != null) {
            locationListener.onLocationChanged(location);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        LocationListener locationListener = this.f9531b;
        if (locationListener != null) {
            locationListener.onProviderDisabled(str);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        LocationListener locationListener = this.f9531b;
        if (locationListener != null) {
            locationListener.onProviderEnabled(str);
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        LocationListener locationListener = this.f9531b;
        if (locationListener != null) {
            locationListener.onStatusChanged(str, i, bundle);
        }
    }
}
