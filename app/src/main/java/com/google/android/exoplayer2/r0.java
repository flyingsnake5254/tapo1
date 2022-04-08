package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* compiled from: AudioBecomingNoisyManager.java */
/* loaded from: classes.dex */
final class r0 {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3111b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3112c;

    /* compiled from: AudioBecomingNoisyManager.java */
    /* loaded from: classes.dex */
    private final class a extends BroadcastReceiver implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final b f3113c;

        /* renamed from: d  reason: collision with root package name */
        private final Handler f3114d;

        public a(Handler handler, b bVar) {
            this.f3114d = handler;
            this.f3113c = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f3114d.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r0.this.f3112c) {
                this.f3113c.m();
            }
        }
    }

    /* compiled from: AudioBecomingNoisyManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void m();
    }

    public r0(Context context, Handler handler, b bVar) {
        this.a = context.getApplicationContext();
        this.f3111b = new a(handler, bVar);
    }

    public void b(boolean z) {
        if (z && !this.f3112c) {
            this.a.registerReceiver(this.f3111b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f3112c = true;
        } else if (!z && this.f3112c) {
            this.a.unregisterReceiver(this.f3111b);
            this.f3112c = false;
        }
    }
}
