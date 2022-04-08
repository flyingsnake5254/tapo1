package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.t;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: MediaCodecAdapter.java */
/* loaded from: classes.dex */
public interface q {

    /* compiled from: MediaCodecAdapter.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final r a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaFormat f2525b;

        /* renamed from: c  reason: collision with root package name */
        public final Format f2526c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final Surface f2527d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public final MediaCrypto f2528e;

        /* renamed from: f  reason: collision with root package name */
        public final int f2529f;

        public a(r rVar, MediaFormat mediaFormat, Format format, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
            this.a = rVar;
            this.f2525b = mediaFormat;
            this.f2526c = format;
            this.f2527d = surface;
            this.f2528e = mediaCrypto;
            this.f2529f = i;
        }
    }

    /* compiled from: MediaCodecAdapter.java */
    /* loaded from: classes.dex */
    public interface b {
        public static final b a = new t.b();

        q a(a aVar) throws IOException;
    }

    /* compiled from: MediaCodecAdapter.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(q qVar, long j, long j2);
    }

    void a(int i, int i2, com.google.android.exoplayer2.decoder.b bVar, long j, int i3);

    MediaFormat b();

    @RequiresApi(23)
    void c(c cVar, Handler handler);

    void d(int i);

    @Nullable
    ByteBuffer e(int i);

    @RequiresApi(23)
    void f(Surface surface);

    void flush();

    void g(int i, int i2, int i3, long j, int i4);

    boolean h();

    @RequiresApi(19)
    void i(Bundle bundle);

    @RequiresApi(21)
    void j(int i, long j);

    int k();

    int l(MediaCodec.BufferInfo bufferInfo);

    void m(int i, boolean z);

    @Nullable
    ByteBuffer n(int i);

    void release();
}
