package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;

/* compiled from: LoadErrorHandlingPolicy.java */
/* loaded from: classes.dex */
public interface x {

    /* compiled from: LoadErrorHandlingPolicy.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3865b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3866c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3867d;

        public a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.f3865b = i2;
            this.f3866c = i3;
            this.f3867d = i4;
        }

        public boolean a(int i) {
            if (i == 1) {
                if (this.a - this.f3865b <= 1) {
                    return false;
                }
            } else if (this.f3866c - this.f3867d <= 1) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: LoadErrorHandlingPolicy.java */
    /* loaded from: classes.dex */
    public static final class b {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3868b;

        public b(int i, long j) {
            g.a(j >= 0);
            this.a = i;
            this.f3868b = j;
        }
    }

    /* compiled from: LoadErrorHandlingPolicy.java */
    /* loaded from: classes.dex */
    public static final class c {
        public final com.google.android.exoplayer2.source.x a;

        /* renamed from: b  reason: collision with root package name */
        public final a0 f3869b;

        /* renamed from: c  reason: collision with root package name */
        public final IOException f3870c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3871d;

        public c(com.google.android.exoplayer2.source.x xVar, a0 a0Var, IOException iOException, int i) {
            this.a = xVar;
            this.f3869b = a0Var;
            this.f3870c = iOException;
            this.f3871d = i;
        }
    }

    long a(c cVar);

    int b(int i);

    @Nullable
    b c(a aVar, c cVar);

    void d(long j);
}
