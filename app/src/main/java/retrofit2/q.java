package retrofit2;

import javax.annotation.Nullable;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: Response.java */
/* loaded from: classes4.dex */
public final class q<T> {
    private final Response a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final T f17657b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final ResponseBody f17658c;

    private q(Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.a = response;
        this.f17657b = t;
        this.f17658c = responseBody;
    }

    public static <T> q<T> c(ResponseBody responseBody, Response response) {
        v.b(responseBody, "body == null");
        v.b(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new q<>(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> q<T> g(@Nullable T t, Response response) {
        v.b(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new q<>(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    @Nullable
    public T a() {
        return this.f17657b;
    }

    public int b() {
        return this.a.code();
    }

    @Nullable
    public ResponseBody d() {
        return this.f17658c;
    }

    public boolean e() {
        return this.a.isSuccessful();
    }

    public String f() {
        return this.a.message();
    }

    public String toString() {
        return this.a.toString();
    }
}
