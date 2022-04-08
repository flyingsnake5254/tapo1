package retrofit2;

import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParameterHandler.java */
/* loaded from: classes4.dex */
public abstract class m<T> {

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    class a extends m<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(o oVar, @Nullable Iterable<T> iterable) throws IOException {
            if (iterable != null) {
                for (T t : iterable) {
                    m.this.a(oVar, t);
                }
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    class b extends m<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.m
        void a(o oVar, @Nullable Object obj) throws IOException {
            if (obj != null) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    m.this.a(oVar, Array.get(obj, i));
                }
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class c<T> extends m<T> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17612b;

        /* renamed from: c  reason: collision with root package name */
        private final f<T, RequestBody> f17613c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Method method, int i, f<T, RequestBody> fVar) {
            this.a = method;
            this.f17612b = i;
            this.f17613c = fVar;
        }

        @Override // retrofit2.m
        void a(o oVar, @Nullable T t) {
            if (t != null) {
                try {
                    oVar.l(this.f17613c.convert(t));
                } catch (IOException e2) {
                    Method method = this.a;
                    int i = this.f17612b;
                    throw v.q(method, e2, i, "Unable to convert " + t + " to RequestBody", new Object[0]);
                }
            } else {
                throw v.p(this.a, this.f17612b, "Body parameter value must not be null.", new Object[0]);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class d<T> extends m<T> {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final f<T, String> f17614b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f17615c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(String str, f<T, String> fVar, boolean z) {
            this.a = (String) v.b(str, "name == null");
            this.f17614b = fVar;
            this.f17615c = z;
        }

        @Override // retrofit2.m
        void a(o oVar, @Nullable T t) throws IOException {
            String convert;
            if (t != null && (convert = this.f17614b.convert(t)) != null) {
                oVar.a(this.a, convert, this.f17615c);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class e<T> extends m<Map<String, T>> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17616b;

        /* renamed from: c  reason: collision with root package name */
        private final f<T, String> f17617c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f17618d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(Method method, int i, f<T, String> fVar, boolean z) {
            this.a = method;
            this.f17616b = i;
            this.f17617c = fVar;
            this.f17618d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(o oVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.f17617c.convert(value);
                            if (convert != null) {
                                oVar.a(key, convert, this.f17618d);
                            } else {
                                Method method = this.a;
                                int i = this.f17616b;
                                throw v.p(method, i, "Field map value '" + value + "' converted to null by " + this.f17617c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            Method method2 = this.a;
                            int i2 = this.f17616b;
                            throw v.p(method2, i2, "Field map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw v.p(this.a, this.f17616b, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw v.p(this.a, this.f17616b, "Field map was null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class f<T> extends m<T> {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final f<T, String> f17619b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(String str, f<T, String> fVar) {
            this.a = (String) v.b(str, "name == null");
            this.f17619b = fVar;
        }

        @Override // retrofit2.m
        void a(o oVar, @Nullable T t) throws IOException {
            String convert;
            if (t != null && (convert = this.f17619b.convert(t)) != null) {
                oVar.b(this.a, convert);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class g<T> extends m<Map<String, T>> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17620b;

        /* renamed from: c  reason: collision with root package name */
        private final f<T, String> f17621c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Method method, int i, f<T, String> fVar) {
            this.a = method;
            this.f17620b = i;
            this.f17621c = fVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(o oVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            oVar.b(key, this.f17621c.convert(value));
                        } else {
                            Method method = this.a;
                            int i = this.f17620b;
                            throw v.p(method, i, "Header map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw v.p(this.a, this.f17620b, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw v.p(this.a, this.f17620b, "Header map was null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class h extends m<Headers> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17622b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(Method method, int i) {
            this.a = method;
            this.f17622b = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(o oVar, @Nullable Headers headers) {
            if (headers != null) {
                oVar.c(headers);
                return;
            }
            throw v.p(this.a, this.f17622b, "Headers parameter must not be null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class i<T> extends m<T> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17623b;

        /* renamed from: c  reason: collision with root package name */
        private final Headers f17624c;

        /* renamed from: d  reason: collision with root package name */
        private final f<T, RequestBody> f17625d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(Method method, int i, Headers headers, f<T, RequestBody> fVar) {
            this.a = method;
            this.f17623b = i;
            this.f17624c = headers;
            this.f17625d = fVar;
        }

        @Override // retrofit2.m
        void a(o oVar, @Nullable T t) {
            if (t != null) {
                try {
                    oVar.d(this.f17624c, this.f17625d.convert(t));
                } catch (IOException e2) {
                    Method method = this.a;
                    int i = this.f17623b;
                    throw v.p(method, i, "Unable to convert " + t + " to RequestBody", e2);
                }
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class j<T> extends m<Map<String, T>> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17626b;

        /* renamed from: c  reason: collision with root package name */
        private final f<T, RequestBody> f17627c;

        /* renamed from: d  reason: collision with root package name */
        private final String f17628d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(Method method, int i, f<T, RequestBody> fVar, String str) {
            this.a = method;
            this.f17626b = i;
            this.f17627c = fVar;
            this.f17628d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(o oVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            oVar.d(Headers.of("Content-Disposition", "form-data; name=\"" + key + SSLClient.DOUBLE_QUOTATION, HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, this.f17628d), this.f17627c.convert(value));
                        } else {
                            Method method = this.a;
                            int i = this.f17626b;
                            throw v.p(method, i, "Part map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw v.p(this.a, this.f17626b, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw v.p(this.a, this.f17626b, "Part map was null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class k<T> extends m<T> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17629b;

        /* renamed from: c  reason: collision with root package name */
        private final String f17630c;

        /* renamed from: d  reason: collision with root package name */
        private final f<T, String> f17631d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f17632e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(Method method, int i, String str, f<T, String> fVar, boolean z) {
            this.a = method;
            this.f17629b = i;
            this.f17630c = (String) v.b(str, "name == null");
            this.f17631d = fVar;
            this.f17632e = z;
        }

        @Override // retrofit2.m
        void a(o oVar, @Nullable T t) throws IOException {
            if (t != null) {
                oVar.f(this.f17630c, this.f17631d.convert(t), this.f17632e);
                return;
            }
            Method method = this.a;
            int i = this.f17629b;
            throw v.p(method, i, "Path parameter \"" + this.f17630c + "\" value must not be null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class l<T> extends m<T> {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final f<T, String> f17633b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f17634c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public l(String str, f<T, String> fVar, boolean z) {
            this.a = (String) v.b(str, "name == null");
            this.f17633b = fVar;
            this.f17634c = z;
        }

        @Override // retrofit2.m
        void a(o oVar, @Nullable T t) throws IOException {
            String convert;
            if (t != null && (convert = this.f17633b.convert(t)) != null) {
                oVar.g(this.a, convert, this.f17634c);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.m$m  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0349m<T> extends m<Map<String, T>> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17635b;

        /* renamed from: c  reason: collision with root package name */
        private final f<T, String> f17636c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f17637d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0349m(Method method, int i, f<T, String> fVar, boolean z) {
            this.a = method;
            this.f17635b = i;
            this.f17636c = fVar;
            this.f17637d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(o oVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.f17636c.convert(value);
                            if (convert != null) {
                                oVar.g(key, convert, this.f17637d);
                            } else {
                                Method method = this.a;
                                int i = this.f17635b;
                                throw v.p(method, i, "Query map value '" + value + "' converted to null by " + this.f17636c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            Method method2 = this.a;
                            int i2 = this.f17635b;
                            throw v.p(method2, i2, "Query map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw v.p(this.a, this.f17635b, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw v.p(this.a, this.f17635b, "Query map was null", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class n<T> extends m<T> {
        private final f<T, String> a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f17638b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public n(f<T, String> fVar, boolean z) {
            this.a = fVar;
            this.f17638b = z;
        }

        @Override // retrofit2.m
        void a(o oVar, @Nullable T t) throws IOException {
            if (t != null) {
                oVar.g(this.a.convert(t), null, this.f17638b);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class o extends m<MultipartBody.Part> {
        static final o a = new o();

        private o() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(o oVar, @Nullable MultipartBody.Part part) {
            if (part != null) {
                oVar.e(part);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class p extends m<Object> {
        private final Method a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17639b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public p(Method method, int i) {
            this.a = method;
            this.f17639b = i;
        }

        @Override // retrofit2.m
        void a(o oVar, @Nullable Object obj) {
            if (obj != null) {
                oVar.m(obj);
                return;
            }
            throw v.p(this.a, this.f17639b, "@Url parameter is null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes4.dex */
    static final class q<T> extends m<T> {
        final Class<T> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public q(Class<T> cls) {
            this.a = cls;
        }

        @Override // retrofit2.m
        void a(o oVar, @Nullable T t) {
            oVar.h(this.a, t);
        }
    }

    m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(o oVar, @Nullable T t) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m<Object> b() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m<Iterable<T>> c() {
        return new a();
    }
}
