package b.d.d.m;

import androidx.annotation.Nullable;

/* compiled from: MediaEvent.java */
/* loaded from: classes3.dex */
public class f<T> {
    private T a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f214b = false;

    public f(T t) {
        if (t != null) {
            this.a = t;
            return;
        }
        throw new IllegalArgumentException("null values in Event are not allowed.");
    }

    @Nullable
    public T a() {
        if (this.f214b) {
            return null;
        }
        this.f214b = true;
        return this.a;
    }
}
