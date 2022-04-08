package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.u;

/* compiled from: WakeLockManager.java */
/* loaded from: classes.dex */
final class k2 {
    @Nullable
    private final PowerManager a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f2339b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2340c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2341d;

    public k2(Context context) {
        this.a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @SuppressLint({"WakelockTimeout"})
    private void c() {
        PowerManager.WakeLock wakeLock = this.f2339b;
        if (wakeLock != null) {
            if (!this.f2340c || !this.f2341d) {
                wakeLock.release();
            } else {
                wakeLock.acquire();
            }
        }
    }

    public void a(boolean z) {
        if (z && this.f2339b == null) {
            PowerManager powerManager = this.a;
            if (powerManager == null) {
                u.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
            this.f2339b = newWakeLock;
            newWakeLock.setReferenceCounted(false);
        }
        this.f2340c = z;
        c();
    }

    public void b(boolean z) {
        this.f2341d = z;
        c();
    }
}
