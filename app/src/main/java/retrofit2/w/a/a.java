package retrofit2.w.a;

import com.google.gson.Gson;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.f;
import retrofit2.r;

/* compiled from: GsonConverterFactory.java */
/* loaded from: classes4.dex */
public final class a extends f.a {
    private final Gson a;

    private a(Gson gson) {
        this.a = gson;
    }

    public static a f() {
        return g(new Gson());
    }

    public static a g(Gson gson) {
        Objects.requireNonNull(gson, "gson == null");
        return new a(gson);
    }

    @Override // retrofit2.f.a
    public f<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, r rVar) {
        return new b(this.a, this.a.n(com.google.gson.r.a.get(type)));
    }

    @Override // retrofit2.f.a
    public f<ResponseBody, ?> d(Type type, Annotation[] annotationArr, r rVar) {
        return new c(this.a, this.a.n(com.google.gson.r.a.get(type)));
    }
}
