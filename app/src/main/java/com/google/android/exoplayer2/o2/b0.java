package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.d0;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: TrackOutput.java */
/* loaded from: classes.dex */
public interface b0 {

    /* compiled from: TrackOutput.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f2647b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2648c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2649d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.a = i;
            this.f2647b = bArr;
            this.f2648c = i2;
            this.f2649d = i3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f2648c == aVar.f2648c && this.f2649d == aVar.f2649d && Arrays.equals(this.f2647b, aVar.f2647b);
        }

        public int hashCode() {
            return (((((this.a * 31) + Arrays.hashCode(this.f2647b)) * 31) + this.f2648c) * 31) + this.f2649d;
        }
    }

    int a(i iVar, int i, boolean z, int i2) throws IOException;

    int b(i iVar, int i, boolean z) throws IOException;

    void c(d0 d0Var, int i);

    void d(Format format);

    void e(long j, int i, int i2, int i3, @Nullable a aVar);

    void f(d0 d0Var, int i, int i2);
}
