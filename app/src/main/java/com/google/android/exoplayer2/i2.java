package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StreamVolumeManager.java */
/* loaded from: classes.dex */
public final class i2 {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f2322b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2323c;

    /* renamed from: d  reason: collision with root package name */
    private final AudioManager f2324d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private c f2325e;

    /* renamed from: f  reason: collision with root package name */
    private int f2326f = 3;
    private int g;
    private boolean h;

    /* compiled from: StreamVolumeManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void l(int i);

        void x(int i, boolean z);
    }

    /* compiled from: StreamVolumeManager.java */
    /* loaded from: classes.dex */
    private final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = i2.this.f2322b;
            final i2 i2Var = i2.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.l0
                @Override // java.lang.Runnable
                public final void run() {
                    i2.this.i();
                }
            });
        }
    }

    public i2(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f2322b = handler;
        this.f2323c = bVar;
        AudioManager audioManager = (AudioManager) g.i((AudioManager) applicationContext.getSystemService("audio"));
        this.f2324d = audioManager;
        this.g = f(audioManager, 3);
        this.h = e(audioManager, this.f2326f);
        c cVar = new c();
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f2325e = cVar;
        } catch (RuntimeException e2) {
            u.i("StreamVolumeManager", "Error registering stream volume receiver", e2);
        }
    }

    private static boolean e(AudioManager audioManager, int i) {
        if (o0.a >= 23) {
            return audioManager.isStreamMute(i);
        }
        return f(audioManager, i) == 0;
    }

    private static int f(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e2) {
            StringBuilder sb = new StringBuilder(60);
            sb.append("Could not retrieve stream volume for stream type ");
            sb.append(i);
            u.i("StreamVolumeManager", sb.toString(), e2);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int f2 = f(this.f2324d, this.f2326f);
        boolean e2 = e(this.f2324d, this.f2326f);
        if (this.g != f2 || this.h != e2) {
            this.g = f2;
            this.h = e2;
            this.f2323c.x(f2, e2);
        }
    }

    public int c() {
        return this.f2324d.getStreamMaxVolume(this.f2326f);
    }

    public int d() {
        if (o0.a >= 28) {
            return this.f2324d.getStreamMinVolume(this.f2326f);
        }
        return 0;
    }

    public void g() {
        c cVar = this.f2325e;
        if (cVar != null) {
            try {
                this.a.unregisterReceiver(cVar);
            } catch (RuntimeException e2) {
                u.i("StreamVolumeManager", "Error unregistering stream volume receiver", e2);
            }
            this.f2325e = null;
        }
    }

    public void h(int i) {
        if (this.f2326f != i) {
            this.f2326f = i;
            i();
            this.f2323c.l(i);
        }
    }
}
