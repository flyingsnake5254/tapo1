package com.tplink.libtpnetwork.cameranetwork.business.model;

import android.os.Build;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.tplink.libtpnetwork.cameranetwork.util.d;
import java.time.Instant;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: PlayBackOffset.java */
/* loaded from: classes3.dex */
public class k {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final long f14140b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14141c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14142d;

    /* renamed from: e  reason: collision with root package name */
    private int f14143e;

    /* renamed from: f  reason: collision with root package name */
    private TimeZone f14144f;
    private String g;
    private final Map<String, Long> h;
    private final Map<String, Long> i;
    private final Map<String, Calendar> j;
    private final Map<String, Calendar> k;
    private final Calendar l;

    public k() {
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = Calendar.getInstance();
        this.a = 0;
        this.f14140b = 0L;
        this.f14141c = false;
        this.f14142d = false;
        this.f14143e = 0;
    }

    @RequiresApi(api = 26)
    private long a(long j, int i) {
        TimeZone timeZone = this.f14144f;
        if (timeZone == null || !timeZone.useDaylightTime()) {
            return 0L;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i2 = instance.get(1) + i;
        Long l = this.i.get(String.valueOf(i2));
        if (l != null) {
            return l.longValue();
        }
        ZoneRules rules = this.f14144f.toZoneId().getRules();
        ZoneOffsetTransition nextTransition = rules.nextTransition(Instant.parse(String.format(Locale.US, "%d-01-01T00:00:00.00Z", Integer.valueOf(i2))));
        long epochMilli = (nextTransition.isGap() ? rules.nextTransition(nextTransition.getInstant()).getInstant() : nextTransition.getInstant()).toEpochMilli();
        this.i.put(String.valueOf(i2), Long.valueOf(epochMilli));
        return epochMilli;
    }

    @RequiresApi(api = 26)
    private long b(long j, int i) {
        TimeZone timeZone = this.f14144f;
        if (timeZone == null || !timeZone.useDaylightTime()) {
            return 0L;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i2 = instance.get(1) + i;
        Long l = this.h.get(String.valueOf(i2));
        if (l != null) {
            return l.longValue();
        }
        ZoneRules rules = this.f14144f.toZoneId().getRules();
        ZoneOffsetTransition nextTransition = rules.nextTransition(Instant.parse(String.format(Locale.US, "%d-01-01T00:00:00.00Z", Integer.valueOf(i2))));
        long epochMilli = (nextTransition.isGap() ? nextTransition.getInstant() : rules.nextTransition(nextTransition.getInstant()).getInstant()).toEpochMilli();
        this.h.put(String.valueOf(i2), Long.valueOf(epochMilli));
        return epochMilli;
    }

    private TimeZone c() {
        String str = this.g;
        if (str == null || !str.startsWith("UTC")) {
            return this.f14144f;
        }
        return TimeZone.getTimeZone(this.g.replace("UTC", "GMT"));
    }

    private Calendar n(TimeZone timeZone, long j) {
        if (timeZone == null || j <= 0) {
            return null;
        }
        this.l.setTimeZone(timeZone);
        this.l.setTimeInMillis(j);
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance.set(1, this.l.get(1));
        instance.set(2, this.l.get(2));
        instance.set(5, this.l.get(5));
        instance.set(11, this.l.get(11));
        instance.set(12, this.l.get(12));
        instance.set(13, this.l.get(13));
        instance.set(14, 0);
        return instance;
    }

    private long s(long j, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Long l = this.i.get(String.valueOf(instance.get(1) + i));
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    private long t(long j, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Long l = this.h.get(String.valueOf(instance.get(1) + i));
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @RequiresApi(api = 26)
    public void d(String str, String str2) {
        TimeZone timeZone = TimeZone.getTimeZone(str);
        this.f14144f = timeZone;
        this.g = str2;
        this.f14143e = timeZone.getDSTSavings();
        this.f14141c = this.f14144f.useDaylightTime();
        if (this.f14144f.useDaylightTime()) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.f14140b);
            boolean z = true;
            int i = instance.get(1);
            ZoneRules rules = this.f14144f.toZoneId().getRules();
            ZoneOffsetTransition nextTransition = rules.nextTransition(Instant.parse(String.format(Locale.US, "%d-01-01T00:00:00.00Z", Integer.valueOf(i))));
            ZoneOffsetTransition nextTransition2 = rules.nextTransition(nextTransition.getInstant());
            long epochMilli = (nextTransition.isGap() ? nextTransition.getInstant() : nextTransition2.getInstant()).toEpochMilli();
            long epochMilli2 = (nextTransition.isGap() ? nextTransition2.getInstant() : nextTransition.getInstant()).toEpochMilli();
            if (nextTransition.isGap()) {
                long j = this.f14140b;
                if (j < epochMilli || j >= epochMilli2) {
                    z = false;
                }
                this.f14142d = z;
                return;
            }
            long j2 = this.f14140b;
            if (j2 < epochMilli && j2 >= epochMilli2) {
                z = false;
            }
            this.f14142d = z;
        }
    }

    public void e(String str, String str2, Map<String, d.b> map) {
        TimeZone timeZone = TimeZone.getTimeZone(str);
        this.f14144f = timeZone;
        this.g = str2;
        this.f14143e = timeZone.getDSTSavings();
        this.f14141c = this.f14144f.useDaylightTime();
        if (!(this.f14144f == null || map.isEmpty())) {
            for (Map.Entry<String, d.b> entry : map.entrySet()) {
                String key = entry.getKey();
                d.b value = entry.getValue();
                this.h.put(key, Long.valueOf(value.b()));
                this.i.put(key, Long.valueOf(value.a()));
                Calendar n = n(this.f14144f, value.b());
                if (n != null) {
                    this.j.put(key, n);
                }
                Calendar n2 = n(this.f14144f, value.b());
                if (n2 != null) {
                    this.k.put(key, n2);
                }
            }
            long j = this.f14140b;
            if (j != 0) {
                boolean z = false;
                long h = h(j, 0);
                long g = g(this.f14140b, 0);
                if (h < g) {
                    long j2 = this.f14140b;
                    if (j2 >= h && j2 < g) {
                        z = true;
                    }
                    this.f14142d = z;
                    return;
                }
                long j3 = this.f14140b;
                if (j3 >= h || j3 < g) {
                    z = true;
                }
                this.f14142d = z;
            }
        }
    }

    public long f() {
        return this.f14140b;
    }

    public long g(long j, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a(j, i);
        }
        return s(j, i);
    }

    public long h(long j, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return b(j, i);
        }
        return t(j, i);
    }

    public Pair<Long, Long> i(int i, int i2, int i3) {
        Calendar calendar;
        if (l() != null) {
            calendar = Calendar.getInstance(l());
        } else {
            calendar = Calendar.getInstance();
        }
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(6, 1);
        return new Pair<>(Long.valueOf(calendar.getTimeInMillis() / 1000), Long.valueOf((calendar.getTimeInMillis() / 1000) - 1));
    }

    public int j() {
        return this.a;
    }

    public int k() {
        return this.f14143e;
    }

    public TimeZone l() {
        if (this.f14141c) {
            return this.f14144f;
        }
        return c();
    }

    public long m(int i, int i2, int i3, int i4, int i5, int i6) {
        Calendar calendar;
        if (l() != null) {
            calendar = Calendar.getInstance(l());
        } else {
            calendar = Calendar.getInstance();
        }
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        calendar.set(11, i4);
        calendar.set(12, i5);
        calendar.set(13, i6);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    public boolean o() {
        return this.f14142d;
    }

    public boolean p() {
        return this.f14141c;
    }

    public boolean q(long j, long j2, long j3) {
        return j >= j2 && j < j3;
    }

    public boolean r(long j, long j2, long j3) {
        return j >= j2 || j < j3;
    }

    public void u(String str, String str2) {
        this.f14144f = TimeZone.getTimeZone(str);
        this.g = str2;
    }

    public k(int i, long j) {
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = Calendar.getInstance();
        this.a = i;
        this.f14140b = j;
        this.f14141c = false;
        this.f14142d = false;
        this.f14143e = 0;
    }
}
