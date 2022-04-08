package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;

/* compiled from: SeekMap.java */
/* loaded from: classes.dex */
public interface y {

    /* compiled from: SeekMap.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final z a;

        /* renamed from: b  reason: collision with root package name */
        public final z f3076b;

        public a(z zVar) {
            this(zVar, zVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a.equals(aVar.a) && this.f3076b.equals(aVar.f3076b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.f3076b.hashCode();
        }

        public String toString() {
            String str;
            String valueOf = String.valueOf(this.a);
            if (this.a.equals(this.f3076b)) {
                str = "";
            } else {
                String valueOf2 = String.valueOf(this.f3076b);
                StringBuilder sb = new StringBuilder(valueOf2.length() + 2);
                sb.append(", ");
                sb.append(valueOf2);
                str = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + String.valueOf(str).length());
            sb2.append("[");
            sb2.append(valueOf);
            sb2.append(str);
            sb2.append("]");
            return sb2.toString();
        }

        public a(z zVar, z zVar2) {
            this.a = (z) g.e(zVar);
            this.f3076b = (z) g.e(zVar2);
        }
    }

    /* compiled from: SeekMap.java */
    /* loaded from: classes.dex */
    public static class b implements y {
        private final long a;

        /* renamed from: b  reason: collision with root package name */
        private final a f3077b;

        public b(long j) {
            this(j, 0L);
        }

        @Override // com.google.android.exoplayer2.o2.y
        public a a(long j) {
            return this.f3077b;
        }

        @Override // com.google.android.exoplayer2.o2.y
        public boolean g() {
            return false;
        }

        @Override // com.google.android.exoplayer2.o2.y
        public long i() {
            return this.a;
        }

        public b(long j, long j2) {
            this.a = j;
            this.f3077b = new a(j2 == 0 ? z.a : new z(0L, j2));
        }
    }

    a a(long j);

    boolean g();

    long i();
}
