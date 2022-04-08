package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;

/* compiled from: Option.java */
/* loaded from: classes.dex */
public final class e<T> {
    private static final b<Object> a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final T f1375b;

    /* renamed from: c  reason: collision with root package name */
    private final b<T> f1376c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1377d;

    /* renamed from: e  reason: collision with root package name */
    private volatile byte[] f1378e;

    /* compiled from: Option.java */
    /* loaded from: classes.dex */
    class a implements b<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.e.b
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* compiled from: Option.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private e(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        this.f1377d = i.b(str);
        this.f1375b = t;
        this.f1376c = (b) i.d(bVar);
    }

    @NonNull
    public static <T> e<T> a(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        return new e<>(str, t, bVar);
    }

    @NonNull
    private static <T> b<T> b() {
        return (b<T>) a;
    }

    @NonNull
    private byte[] d() {
        if (this.f1378e == null) {
            this.f1378e = this.f1377d.getBytes(c.a);
        }
        return this.f1378e;
    }

    @NonNull
    public static <T> e<T> e(@NonNull String str) {
        return new e<>(str, null, b());
    }

    @NonNull
    public static <T> e<T> f(@NonNull String str, @NonNull T t) {
        return new e<>(str, t, b());
    }

    @Nullable
    public T c() {
        return this.f1375b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f1377d.equals(((e) obj).f1377d);
        }
        return false;
    }

    public void g(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f1376c.a(d(), t, messageDigest);
    }

    public int hashCode() {
        return this.f1377d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f1377d + "'}";
    }
}
