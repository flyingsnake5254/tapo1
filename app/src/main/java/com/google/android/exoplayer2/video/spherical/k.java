package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.video.t;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SceneRenderer.java */
/* loaded from: classes.dex */
final class k implements t, d {
    @Nullable
    private byte[] I3;
    private int p1;
    private SurfaceTexture p2;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f4060c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f4061d = new AtomicBoolean(true);

    /* renamed from: f  reason: collision with root package name */
    private final j f4062f = new j();
    private final f q = new f();
    private final k0<Long> x = new k0<>();
    private final k0<h> y = new k0<>();
    private final float[] z = new float[16];
    private final float[] p0 = new float[16];
    private volatile int p3 = 0;
    private int H3 = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.f4060c.set(true);
    }

    private void i(@Nullable byte[] bArr, int i, long j) {
        byte[] bArr2 = this.I3;
        int i2 = this.H3;
        this.I3 = bArr;
        if (i == -1) {
            i = this.p3;
        }
        this.H3 = i;
        if (i2 != i || !Arrays.equals(bArr2, this.I3)) {
            h hVar = null;
            byte[] bArr3 = this.I3;
            if (bArr3 != null) {
                hVar = i.a(bArr3, this.H3);
            }
            if (hVar == null || !j.c(hVar)) {
                hVar = h.b(this.H3);
            }
            this.y.a(j, hVar);
        }
    }

    @Override // com.google.android.exoplayer2.video.t
    public void a(long j, long j2, Format format, @Nullable MediaFormat mediaFormat) {
        this.x.a(j2, Long.valueOf(j));
        i(format.R3, format.S3, j2);
    }

    public void b(float[] fArr, boolean z) {
        GLES20.glClear(16384);
        q.b();
        if (this.f4060c.compareAndSet(true, false)) {
            ((SurfaceTexture) g.e(this.p2)).updateTexImage();
            q.b();
            if (this.f4061d.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.z, 0);
            }
            long timestamp = this.p2.getTimestamp();
            Long g = this.x.g(timestamp);
            if (g != null) {
                this.q.c(this.z, g.longValue());
            }
            h j = this.y.j(timestamp);
            if (j != null) {
                this.f4062f.d(j);
            }
        }
        Matrix.multiplyMM(this.p0, 0, fArr, 0, this.z, 0);
        this.f4062f.a(this.p1, this.p0, z);
    }

    @Override // com.google.android.exoplayer2.video.spherical.d
    public void c(long j, float[] fArr) {
        this.q.e(j, fArr);
    }

    public SurfaceTexture d() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        q.b();
        this.f4062f.b();
        q.b();
        this.p1 = q.g();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.p1);
        this.p2 = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.google.android.exoplayer2.video.spherical.a
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                k.this.g(surfaceTexture2);
            }
        });
        return this.p2;
    }

    @Override // com.google.android.exoplayer2.video.spherical.d
    public void e() {
        this.x.c();
        this.q.d();
        this.f4061d.set(true);
    }

    public void h(int i) {
        this.p3 = i;
    }
}
