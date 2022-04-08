package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;

/* compiled from: AudioTimestampPoller.java */
/* loaded from: classes.dex */
final class v {
    @Nullable
    private final a a;

    /* renamed from: b  reason: collision with root package name */
    private int f2120b;

    /* renamed from: c  reason: collision with root package name */
    private long f2121c;

    /* renamed from: d  reason: collision with root package name */
    private long f2122d;

    /* renamed from: e  reason: collision with root package name */
    private long f2123e;

    /* renamed from: f  reason: collision with root package name */
    private long f2124f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AudioTimestampPoller.java */
    @RequiresApi(19)
    /* loaded from: classes.dex */
    public static final class a {
        private final AudioTrack a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioTimestamp f2125b = new AudioTimestamp();

        /* renamed from: c  reason: collision with root package name */
        private long f2126c;

        /* renamed from: d  reason: collision with root package name */
        private long f2127d;

        /* renamed from: e  reason: collision with root package name */
        private long f2128e;

        public a(AudioTrack audioTrack) {
            this.a = audioTrack;
        }

        public long a() {
            return this.f2128e;
        }

        public long b() {
            return this.f2125b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.a.getTimestamp(this.f2125b);
            if (timestamp) {
                long j = this.f2125b.framePosition;
                if (this.f2127d > j) {
                    this.f2126c++;
                }
                this.f2127d = j;
                this.f2128e = j + (this.f2126c << 32);
            }
            return timestamp;
        }
    }

    public v(AudioTrack audioTrack) {
        if (o0.a >= 19) {
            this.a = new a(audioTrack);
            g();
            return;
        }
        this.a = null;
        h(3);
    }

    private void h(int i) {
        this.f2120b = i;
        if (i == 0) {
            this.f2123e = 0L;
            this.f2124f = -1L;
            this.f2121c = System.nanoTime() / 1000;
            this.f2122d = 10000L;
        } else if (i == 1) {
            this.f2122d = 10000L;
        } else if (i == 2 || i == 3) {
            this.f2122d = 10000000L;
        } else if (i == 4) {
            this.f2122d = 500000L;
        } else {
            throw new IllegalStateException();
        }
    }

    public void a() {
        if (this.f2120b == 4) {
            g();
        }
    }

    @TargetApi(19)
    public long b() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    @TargetApi(19)
    public long c() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.b();
        }
        return -9223372036854775807L;
    }

    public boolean d() {
        return this.f2120b == 2;
    }

    @TargetApi(19)
    public boolean e(long j) {
        a aVar = this.a;
        if (aVar == null || j - this.f2123e < this.f2122d) {
            return false;
        }
        this.f2123e = j;
        boolean c2 = aVar.c();
        int i = this.f2120b;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (c2) {
                        g();
                    }
                } else if (!c2) {
                    g();
                }
            } else if (!c2) {
                g();
            } else if (this.a.a() > this.f2124f) {
                h(2);
            }
        } else if (c2) {
            if (this.a.b() < this.f2121c) {
                return false;
            }
            this.f2124f = this.a.a();
            h(1);
        } else if (j - this.f2121c > 500000) {
            h(3);
        }
        return c2;
    }

    public void f() {
        h(4);
    }

    public void g() {
        if (this.a != null) {
            h(0);
        }
    }
}
