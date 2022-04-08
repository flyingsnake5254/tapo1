package com.google.android.exoplayer2.o2;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: FlacStreamMetadata.java */
/* loaded from: classes.dex */
public final class s {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3064b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3065c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3066d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3067e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3068f;
    public final int g;
    public final int h;
    public final int i;
    public final long j;
    @Nullable
    public final a k;
    @Nullable
    private final Metadata l;

    /* compiled from: FlacStreamMetadata.java */
    /* loaded from: classes.dex */
    public static class a {
        public final long[] a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f3069b;

        public a(long[] jArr, long[] jArr2) {
            this.a = jArr;
            this.f3069b = jArr2;
        }
    }

    public s(byte[] bArr, int i) {
        c0 c0Var = new c0(bArr);
        c0Var.p(i * 8);
        this.a = c0Var.h(16);
        this.f3064b = c0Var.h(16);
        this.f3065c = c0Var.h(24);
        this.f3066d = c0Var.h(24);
        int h = c0Var.h(20);
        this.f3067e = h;
        this.f3068f = k(h);
        this.g = c0Var.h(3) + 1;
        int h2 = c0Var.h(5) + 1;
        this.h = h2;
        this.i = f(h2);
        this.j = c0Var.j(36);
        this.k = null;
        this.l = null;
    }

    @Nullable
    private static Metadata a(List<String> list, List<PictureFrame> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] F0 = o0.F0(str, SSLClient.EQUALS);
            if (F0.length != 2) {
                String valueOf = String.valueOf(str);
                u.h("FlacStreamMetadata", valueOf.length() != 0 ? "Failed to parse Vorbis comment: ".concat(valueOf) : new String("Failed to parse Vorbis comment: "));
            } else {
                arrayList.add(new VorbisComment(F0[0], F0[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static int f(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int k(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public s b(List<PictureFrame> list) {
        return new s(this.a, this.f3064b, this.f3065c, this.f3066d, this.f3067e, this.g, this.h, this.j, this.k, i(a(Collections.emptyList(), list)));
    }

    public s c(@Nullable a aVar) {
        return new s(this.a, this.f3064b, this.f3065c, this.f3066d, this.f3067e, this.g, this.h, this.j, aVar, this.l);
    }

    public s d(List<String> list) {
        return new s(this.a, this.f3064b, this.f3065c, this.f3066d, this.f3067e, this.g, this.h, this.j, this.k, i(a(list, Collections.emptyList())));
    }

    public long e() {
        long j;
        long j2;
        int i = this.f3066d;
        if (i > 0) {
            j = (i + this.f3065c) / 2;
            j2 = 1;
        } else {
            int i2 = this.a;
            j = ((((i2 != this.f3064b || i2 <= 0) ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : i2) * this.g) * this.h) / 8;
            j2 = 64;
        }
        return j + j2;
    }

    public long g() {
        long j = this.j;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / this.f3067e;
    }

    public Format h(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE;
        int i = this.f3066d;
        if (i <= 0) {
            i = -1;
        }
        return new Format.b().e0("audio/flac").W(i).H(this.g).f0(this.f3067e).T(Collections.singletonList(bArr)).X(i(metadata)).E();
    }

    @Nullable
    public Metadata i(@Nullable Metadata metadata) {
        Metadata metadata2 = this.l;
        return metadata2 == null ? metadata : metadata2.b(metadata);
    }

    public long j(long j) {
        return o0.q((j * this.f3067e) / 1000000, 0L, this.j - 1);
    }

    private s(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, @Nullable a aVar, @Nullable Metadata metadata) {
        this.a = i;
        this.f3064b = i2;
        this.f3065c = i3;
        this.f3066d = i4;
        this.f3067e = i5;
        this.f3068f = k(i5);
        this.g = i6;
        this.h = i7;
        this.i = f(i7);
        this.j = j;
        this.k = aVar;
        this.l = metadata;
    }
}
