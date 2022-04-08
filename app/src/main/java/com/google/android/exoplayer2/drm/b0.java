package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.e0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DummyExoMediaDrm.java */
@RequiresApi(18)
/* loaded from: classes.dex */
public final class b0 implements e0 {
    @Override // com.google.android.exoplayer2.drm.e0
    public Class<j0> a() {
        return j0.class;
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public Map<String, String> b(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public d0 c(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public e0.d d() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public byte[] e() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public void f(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public void g(@Nullable e0.b bVar) {
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public void h(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public void i(byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.drm.e0
    @Nullable
    public byte[] j(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public e0.a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> hashMap) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.e0
    public void release() {
    }
}
