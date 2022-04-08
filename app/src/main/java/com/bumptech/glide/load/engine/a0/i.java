package com.bumptech.glide.load.engine.a0;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public final class i {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1400b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1401c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1402d;

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    public static final class a {
        static final int a;

        /* renamed from: b  reason: collision with root package name */
        final Context f1403b;

        /* renamed from: c  reason: collision with root package name */
        ActivityManager f1404c;

        /* renamed from: d  reason: collision with root package name */
        c f1405d;

        /* renamed from: f  reason: collision with root package name */
        float f1407f;

        /* renamed from: e  reason: collision with root package name */
        float f1406e = 2.0f;
        float g = 0.4f;
        float h = 0.33f;
        int i = 4194304;

        static {
            a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f1407f = a;
            this.f1403b = context;
            this.f1404c = (ActivityManager) context.getSystemService("activity");
            this.f1405d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.e(this.f1404c)) {
                this.f1407f = 0.0f;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    private static final class b implements c {
        private final DisplayMetrics a;

        b(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.a0.i.c
        public int a() {
            return this.a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.a0.i.c
        public int b() {
            return this.a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        int i;
        this.f1401c = aVar.f1403b;
        if (e(aVar.f1404c)) {
            i = aVar.i / 2;
        } else {
            i = aVar.i;
        }
        this.f1402d = i;
        int c2 = c(aVar.f1404c, aVar.g, aVar.h);
        float b2 = aVar.f1405d.b() * aVar.f1405d.a() * 4;
        int round = Math.round(aVar.f1407f * b2);
        int round2 = Math.round(b2 * aVar.f1406e);
        int i2 = c2 - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f1400b = round2;
            this.a = round;
        } else {
            float f2 = i2;
            float f3 = aVar.f1407f;
            float f4 = aVar.f1406e;
            float f5 = f2 / (f3 + f4);
            this.f1400b = Math.round(f4 * f5);
            this.a = Math.round(f5 * aVar.f1407f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f1400b));
            sb.append(", pool size: ");
            sb.append(f(this.a));
            sb.append(", byte array size: ");
            sb.append(f(i));
            sb.append(", memory class limited? ");
            sb.append(i3 > c2);
            sb.append(", max size: ");
            sb.append(f(c2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f1404c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.f1404c));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f2, float f3) {
        boolean e2 = e(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (e2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int i) {
        return Formatter.formatFileSize(this.f1401c, i);
    }

    public int a() {
        return this.f1402d;
    }

    public int b() {
        return this.a;
    }

    public int d() {
        return this.f1400b;
    }
}
