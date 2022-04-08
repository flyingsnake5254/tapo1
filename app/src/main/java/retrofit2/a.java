package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.p;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.f;
import retrofit2.x.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BuiltInConverters.java */
/* loaded from: classes4.dex */
public final class a extends f.a {
    private boolean a = true;

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0343a implements f<ResponseBody, ResponseBody> {
        static final C0343a a = new C0343a();

        C0343a() {
        }

        /* renamed from: a */
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            try {
                return v.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes4.dex */
    static final class b implements f<RequestBody, RequestBody> {
        static final b a = new b();

        b() {
        }

        /* renamed from: a */
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes4.dex */
    static final class c implements f<ResponseBody, ResponseBody> {
        static final c a = new c();

        c() {
        }

        /* renamed from: a */
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes4.dex */
    public static final class d implements f<Object, String> {
        static final d a = new d();

        d() {
        }

        /* renamed from: a */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes4.dex */
    static final class e implements f<ResponseBody, p> {
        static final e a = new e();

        e() {
        }

        /* renamed from: a */
        public p convert(ResponseBody responseBody) {
            responseBody.close();
            return p.a;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes4.dex */
    static final class f implements f<ResponseBody, Void> {
        static final f a = new f();

        f() {
        }

        /* renamed from: a */
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    @Override // retrofit2.f.a
    @Nullable
    public f<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, r rVar) {
        if (RequestBody.class.isAssignableFrom(v.i(type))) {
            return b.a;
        }
        return null;
    }

    @Override // retrofit2.f.a
    @Nullable
    public f<ResponseBody, ?> d(Type type, Annotation[] annotationArr, r rVar) {
        if (type == ResponseBody.class) {
            if (v.m(annotationArr, w.class)) {
                return c.a;
            }
            return C0343a.a;
        } else if (type == Void.class) {
            return f.a;
        } else {
            if (!this.a || type != p.class) {
                return null;
            }
            try {
                return e.a;
            } catch (NoClassDefFoundError unused) {
                this.a = false;
                return null;
            }
        }
    }
}
