package com.google.android.exoplayer2.o2.g0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.util.List;

/* compiled from: MotionPhotoDescription.java */
/* loaded from: classes.dex */
final class b {
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f2701b;

    /* compiled from: MotionPhotoDescription.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2702b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2703c;

        /* renamed from: d  reason: collision with root package name */
        public final long f2704d;

        public a(String str, String str2, long j, long j2) {
            this.a = str;
            this.f2702b = str2;
            this.f2703c = j;
            this.f2704d = j2;
        }
    }

    public b(long j, List<a> list) {
        this.a = j;
        this.f2701b = list;
    }

    @Nullable
    public MotionPhotoMetadata a(long j) {
        long j2;
        if (this.f2701b.size() < 2) {
            return null;
        }
        long j3 = j;
        long j4 = -1;
        long j5 = -1;
        long j6 = -1;
        long j7 = -1;
        boolean z = false;
        for (int size = this.f2701b.size() - 1; size >= 0; size--) {
            a aVar = this.f2701b.get(size);
            boolean equals = "video/mp4".equals(aVar.a) | z;
            if (size == 0) {
                j3 = 0;
                j2 = j3 - aVar.f2704d;
            } else {
                j3 -= aVar.f2703c;
                j2 = j3;
            }
            if (!equals || j3 == j2) {
                z = equals;
            } else {
                j7 = j2 - j3;
                j6 = j3;
                z = false;
            }
            if (size == 0) {
                j4 = j3;
                j5 = j2;
            }
        }
        if (j6 == -1 || j7 == -1 || j4 == -1 || j5 == -1) {
            return null;
        }
        return new MotionPhotoMetadata(j4, j5, this.a, j6, j7);
    }
}
