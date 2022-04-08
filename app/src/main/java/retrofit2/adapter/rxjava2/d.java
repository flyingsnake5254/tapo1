package retrofit2.adapter.rxjava2;

import java.util.Objects;
import javax.annotation.Nullable;
import retrofit2.q;

/* compiled from: Result.java */
/* loaded from: classes4.dex */
public final class d<T> {
    @Nullable
    private final q<T> a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f17557b;

    private d(@Nullable q<T> qVar, @Nullable Throwable th) {
        this.a = qVar;
        this.f17557b = th;
    }

    public static <T> d<T> a(Throwable th) {
        Objects.requireNonNull(th, "error == null");
        return new d<>(null, th);
    }

    public static <T> d<T> b(q<T> qVar) {
        Objects.requireNonNull(qVar, "response == null");
        return new d<>(qVar, null);
    }
}
