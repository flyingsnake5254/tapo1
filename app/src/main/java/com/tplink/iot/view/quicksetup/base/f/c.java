package com.tplink.iot.view.quicksetup.base.f;

import android.app.Application;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import io.reactivex.g0.j;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: TPLocationManager.java */
/* loaded from: classes2.dex */
public class c {
    private static volatile c a;

    /* renamed from: b  reason: collision with root package name */
    private Context f9533b;

    /* renamed from: c  reason: collision with root package name */
    private LocationManager f9534c;

    /* renamed from: d  reason: collision with root package name */
    private b f9535d;

    /* renamed from: e  reason: collision with root package name */
    private g<DeviceLocationInfo> f9536e = io.reactivex.m0.d.n1();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TPLocationManager.java */
    /* loaded from: classes2.dex */
    public class a implements io.reactivex.g0.a {
        a() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            c.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TPLocationManager.java */
    /* loaded from: classes2.dex */
    public class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            c.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TPLocationManager.java */
    /* renamed from: com.tplink.iot.view.quicksetup.base.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0234c implements j<Boolean, t<DeviceLocationInfo>> {
        C0234c() {
        }

        /* renamed from: a */
        public t<DeviceLocationInfo> apply(Boolean bool) throws Exception {
            if (bool.booleanValue()) {
                return c.this.k();
            }
            return q.f0(new DeviceLocationInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TPLocationManager.java */
    /* loaded from: classes2.dex */
    public class d implements LocationListener {
        d() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            c.this.f9536e.onNext(c.this.f(location));
            if (!c.this.f9536e.j1() && !c.this.f9536e.k1()) {
                c.this.f9536e.onComplete();
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    private String e() {
        String str;
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        try {
            str = this.f9534c.getBestProvider(criteria, true);
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "gps" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DeviceLocationInfo f(Location location) {
        if (location != null) {
            int longitude = (int) (location.getLongitude() * 10000.0d);
            int latitude = (int) (location.getLatitude() * 10000.0d);
            if (!(longitude == 0 && latitude == 0)) {
                return new DeviceLocationInfo(Integer.valueOf(longitude), Integer.valueOf(latitude));
            }
        }
        return new DeviceLocationInfo();
    }

    public static c h() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    private Location i(Context context) {
        List<String> list;
        Location location;
        if (this.f9534c == null) {
            return null;
        }
        if (!(ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
            return null;
        }
        try {
            list = this.f9534c.getProviders(true);
        } catch (Exception unused) {
            list = null;
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        Location location2 = null;
        for (String str : list) {
            try {
                location = this.f9534c.getLastKnownLocation(str);
            } catch (SecurityException unused2) {
                location = null;
            }
            if (location != null && (location2 == null || location.getAccuracy() < location2.getAccuracy())) {
                location2 = location;
            }
        }
        return location2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public t<DeviceLocationInfo> k() {
        Location i = i(this.f9533b);
        if (i == null) {
            i = n();
        }
        if (i != null) {
            return q.f0(f(i));
        }
        return l();
    }

    private t<DeviceLocationInfo> l() {
        if (this.f9534c == null) {
            return q.f0(new DeviceLocationInfo());
        }
        String e2 = e();
        b bVar = new b(new d(), this.f9534c);
        this.f9535d = bVar;
        try {
            this.f9534c.requestLocationUpdates(e2, 60000L, 1000.0f, bVar);
            return this.f9536e;
        } catch (SecurityException unused) {
            return q.f0(new DeviceLocationInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        b bVar;
        LocationManager locationManager = this.f9534c;
        if (locationManager != null && (bVar = this.f9535d) != null) {
            try {
                locationManager.removeUpdates(bVar);
            } catch (Exception unused) {
            }
        }
    }

    private Location n() {
        if (this.f9534c == null) {
            return null;
        }
        try {
            return this.f9534c.getLastKnownLocation(e());
        } catch (SecurityException unused) {
            return null;
        }
    }

    public q<DeviceLocationInfo> g(long j) {
        return q.f0(Boolean.valueOf(a.a(this.f9533b))).N(new C0234c()).T0(j, TimeUnit.MILLISECONDS).q0(new DeviceLocationInfo()).A(new b()).y(new a());
    }

    public void j(@NonNull Application application) {
        Context context = application;
        if (com.tplink.iot.Utils.a1.a.b()) {
            context = application.createAttributionContext("AttrTagTPLocationManager");
        }
        this.f9533b = context;
        this.f9534c = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
    }
}
