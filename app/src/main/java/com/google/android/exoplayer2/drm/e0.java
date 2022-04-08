package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: ExoMediaDrm.java */
/* loaded from: classes.dex */
public interface e0 {

    /* compiled from: ExoMediaDrm.java */
    /* loaded from: classes.dex */
    public static final class a {
        private final byte[] a;

        /* renamed from: b  reason: collision with root package name */
        private final String f2211b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2212c;

        public a(byte[] bArr, String str, int i) {
            this.a = bArr;
            this.f2211b = str;
            this.f2212c = i;
        }

        public byte[] a() {
            return this.a;
        }

        public String b() {
            return this.f2211b;
        }
    }

    /* compiled from: ExoMediaDrm.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(e0 e0Var, @Nullable byte[] bArr, int i, int i2, @Nullable byte[] bArr2);
    }

    /* compiled from: ExoMediaDrm.java */
    /* loaded from: classes.dex */
    public interface c {
        e0 a(UUID uuid);
    }

    /* compiled from: ExoMediaDrm.java */
    /* loaded from: classes.dex */
    public static final class d {
        private final byte[] a;

        /* renamed from: b  reason: collision with root package name */
        private final String f2213b;

        public d(byte[] bArr, String str) {
            this.a = bArr;
            this.f2213b = str;
        }

        public byte[] a() {
            return this.a;
        }

        public String b() {
            return this.f2213b;
        }
    }

    Class<? extends d0> a();

    Map<String, String> b(byte[] bArr);

    d0 c(byte[] bArr) throws MediaCryptoException;

    d d();

    byte[] e() throws MediaDrmException;

    void f(byte[] bArr, byte[] bArr2);

    void g(@Nullable b bVar);

    void h(byte[] bArr) throws DeniedByServerException;

    void i(byte[] bArr);

    @Nullable
    byte[] j(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException;

    void release();
}
