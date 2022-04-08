package retrofit2;

import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.coroutines.c;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import retrofit2.m;
import retrofit2.x.b;
import retrofit2.x.d;
import retrofit2.x.e;
import retrofit2.x.f;
import retrofit2.x.g;
import retrofit2.x.h;
import retrofit2.x.i;
import retrofit2.x.j;
import retrofit2.x.k;
import retrofit2.x.l;
import retrofit2.x.m;
import retrofit2.x.n;
import retrofit2.x.o;
import retrofit2.x.q;
import retrofit2.x.r;
import retrofit2.x.s;
import retrofit2.x.t;
import retrofit2.x.u;
import retrofit2.x.v;
import retrofit2.x.x;
import retrofit2.x.y;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestFactory.java */
/* loaded from: classes4.dex */
public final class p {
    private final Method a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpUrl f17647b;

    /* renamed from: c  reason: collision with root package name */
    final String f17648c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f17649d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Headers f17650e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final MediaType f17651f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final m<?>[] j;
    final boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestFactory.java */
    /* loaded from: classes4.dex */
    public static final class a {
        private static final Pattern a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: b  reason: collision with root package name */
        private static final Pattern f17652b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: c  reason: collision with root package name */
        final r f17653c;

        /* renamed from: d  reason: collision with root package name */
        final Method f17654d;

        /* renamed from: e  reason: collision with root package name */
        final Annotation[] f17655e;

        /* renamed from: f  reason: collision with root package name */
        final Annotation[][] f17656f;
        final Type[] g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;
        boolean o;
        @Nullable
        String p;
        boolean q;
        boolean r;
        boolean s;
        @Nullable
        String t;
        @Nullable
        Headers u;
        @Nullable
        MediaType v;
        @Nullable
        Set<String> w;
        @Nullable
        m<?>[] x;
        boolean y;

        a(r rVar, Method method) {
            this.f17653c = rVar;
            this.f17654d = method;
            this.f17655e = method.getAnnotations();
            this.g = method.getGenericParameterTypes();
            this.f17656f = method.getParameterAnnotations();
        }

        private static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        private Headers c(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw v.n(this.f17654d, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.v = MediaType.get(trim);
                    } catch (IllegalArgumentException e2) {
                        throw v.o(this.f17654d, e2, "Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void d(String str, String str2, boolean z) {
            String str3 = this.p;
            if (str3 == null) {
                this.p = str;
                this.q = z;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (a.matcher(substring).find()) {
                            throw v.n(this.f17654d, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.t = str2;
                    this.w = h(str2);
                    return;
                }
                return;
            }
            throw v.n(this.f17654d, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof b) {
                d("DELETE", ((b) annotation).value(), false);
            } else if (annotation instanceof f) {
                d(SSLClient.HTTP_GET, ((f) annotation).value(), false);
            } else if (annotation instanceof g) {
                d("HEAD", ((g) annotation).value(), false);
            } else if (annotation instanceof n) {
                d("PATCH", ((n) annotation).value(), true);
            } else if (annotation instanceof o) {
                d(SSLClient.HTTP_POST, ((o) annotation).value(), true);
            } else if (annotation instanceof retrofit2.x.p) {
                d(SSLClient.HTTP_PUT, ((retrofit2.x.p) annotation).value(), true);
            } else if (annotation instanceof m) {
                d("OPTIONS", ((m) annotation).value(), false);
            } else if (annotation instanceof h) {
                h hVar = (h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
            } else if (annotation instanceof k) {
                String[] value = ((k) annotation).value();
                if (value.length != 0) {
                    this.u = c(value);
                    return;
                }
                throw v.n(this.f17654d, "@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof l) {
                if (!this.r) {
                    this.s = true;
                    return;
                }
                throw v.n(this.f17654d, "Only one encoding annotation is allowed.", new Object[0]);
            } else if (!(annotation instanceof e)) {
            } else {
                if (!this.s) {
                    this.r = true;
                    return;
                }
                throw v.n(this.f17654d, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        @Nullable
        private m<?> f(int i, Type type, @Nullable Annotation[] annotationArr, boolean z) {
            m<?> mVar;
            if (annotationArr != null) {
                mVar = null;
                for (Annotation annotation : annotationArr) {
                    m<?> g = g(i, type, annotationArr, annotation);
                    if (g != null) {
                        if (mVar == null) {
                            mVar = g;
                        } else {
                            throw v.p(this.f17654d, i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                    }
                }
            } else {
                mVar = null;
            }
            if (mVar != null) {
                return mVar;
            }
            if (z) {
                try {
                    if (v.i(type) == c.class) {
                        this.y = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw v.p(this.f17654d, i, "No Retrofit annotation found.", new Object[0]);
        }

        @Nullable
        private m<?> g(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof y) {
                j(i, type);
                if (this.o) {
                    throw v.p(this.f17654d, i, "Multiple @Url method annotations found.", new Object[0]);
                } else if (this.k) {
                    throw v.p(this.f17654d, i, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.l) {
                    throw v.p(this.f17654d, i, "A @Url parameter must not come after a @Query.", new Object[0]);
                } else if (this.m) {
                    throw v.p(this.f17654d, i, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.n) {
                    throw v.p(this.f17654d, i, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.t == null) {
                    this.o = true;
                    if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new m.p(this.f17654d, i);
                    }
                    throw v.p(this.f17654d, i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                } else {
                    throw v.p(this.f17654d, i, "@Url cannot be used with @%s URL", this.p);
                }
            } else if (annotation instanceof s) {
                j(i, type);
                if (this.l) {
                    throw v.p(this.f17654d, i, "A @Path parameter must not come after a @Query.", new Object[0]);
                } else if (this.m) {
                    throw v.p(this.f17654d, i, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.n) {
                    throw v.p(this.f17654d, i, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.o) {
                    throw v.p(this.f17654d, i, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.t != null) {
                    this.k = true;
                    s sVar = (s) annotation;
                    String value = sVar.value();
                    i(i, value);
                    return new m.k(this.f17654d, i, value, this.f17653c.j(type, annotationArr), sVar.encoded());
                } else {
                    throw v.p(this.f17654d, i, "@Path can only be used with relative url on @%s", this.p);
                }
            } else if (annotation instanceof t) {
                j(i, type);
                t tVar = (t) annotation;
                String value2 = tVar.value();
                boolean encoded = tVar.encoded();
                Class<?> i2 = v.i(type);
                this.l = true;
                if (Iterable.class.isAssignableFrom(i2)) {
                    if (type instanceof ParameterizedType) {
                        return new m.l(value2, this.f17653c.j(v.h(0, (ParameterizedType) type), annotationArr), encoded).c();
                    }
                    throw v.p(this.f17654d, i, i2.getSimpleName() + " must include generic type (e.g., " + i2.getSimpleName() + "<String>)", new Object[0]);
                } else if (i2.isArray()) {
                    return new m.l(value2, this.f17653c.j(a(i2.getComponentType()), annotationArr), encoded).b();
                } else {
                    return new m.l(value2, this.f17653c.j(type, annotationArr), encoded);
                }
            } else if (annotation instanceof v) {
                j(i, type);
                boolean encoded2 = ((v) annotation).encoded();
                Class<?> i3 = v.i(type);
                this.m = true;
                if (Iterable.class.isAssignableFrom(i3)) {
                    if (type instanceof ParameterizedType) {
                        return new m.n(this.f17653c.j(v.h(0, (ParameterizedType) type), annotationArr), encoded2).c();
                    }
                    throw v.p(this.f17654d, i, i3.getSimpleName() + " must include generic type (e.g., " + i3.getSimpleName() + "<String>)", new Object[0]);
                } else if (i3.isArray()) {
                    return new m.n(this.f17653c.j(a(i3.getComponentType()), annotationArr), encoded2).b();
                } else {
                    return new m.n(this.f17653c.j(type, annotationArr), encoded2);
                }
            } else if (annotation instanceof u) {
                j(i, type);
                Class<?> i4 = v.i(type);
                this.n = true;
                if (Map.class.isAssignableFrom(i4)) {
                    Type j = v.j(type, i4, Map.class);
                    if (j instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) j;
                        Type h = v.h(0, parameterizedType);
                        if (String.class == h) {
                            return new m.C0349m(this.f17654d, i, this.f17653c.j(v.h(1, parameterizedType), annotationArr), ((u) annotation).encoded());
                        }
                        throw v.p(this.f17654d, i, "@QueryMap keys must be of type String: " + h, new Object[0]);
                    }
                    throw v.p(this.f17654d, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw v.p(this.f17654d, i, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof i) {
                j(i, type);
                String value3 = ((i) annotation).value();
                Class<?> i5 = v.i(type);
                if (Iterable.class.isAssignableFrom(i5)) {
                    if (type instanceof ParameterizedType) {
                        return new m.f(value3, this.f17653c.j(v.h(0, (ParameterizedType) type), annotationArr)).c();
                    }
                    throw v.p(this.f17654d, i, i5.getSimpleName() + " must include generic type (e.g., " + i5.getSimpleName() + "<String>)", new Object[0]);
                } else if (i5.isArray()) {
                    return new m.f(value3, this.f17653c.j(a(i5.getComponentType()), annotationArr)).b();
                } else {
                    return new m.f(value3, this.f17653c.j(type, annotationArr));
                }
            } else if (annotation instanceof j) {
                if (type == Headers.class) {
                    return new m.h(this.f17654d, i);
                }
                j(i, type);
                Class<?> i6 = v.i(type);
                if (Map.class.isAssignableFrom(i6)) {
                    Type j2 = v.j(type, i6, Map.class);
                    if (j2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) j2;
                        Type h2 = v.h(0, parameterizedType2);
                        if (String.class == h2) {
                            return new m.g(this.f17654d, i, this.f17653c.j(v.h(1, parameterizedType2), annotationArr));
                        }
                        throw v.p(this.f17654d, i, "@HeaderMap keys must be of type String: " + h2, new Object[0]);
                    }
                    throw v.p(this.f17654d, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw v.p(this.f17654d, i, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof retrofit2.x.c) {
                j(i, type);
                if (this.r) {
                    retrofit2.x.c cVar = (retrofit2.x.c) annotation;
                    String value4 = cVar.value();
                    boolean encoded3 = cVar.encoded();
                    this.h = true;
                    Class<?> i7 = v.i(type);
                    if (Iterable.class.isAssignableFrom(i7)) {
                        if (type instanceof ParameterizedType) {
                            return new m.d(value4, this.f17653c.j(v.h(0, (ParameterizedType) type), annotationArr), encoded3).c();
                        }
                        throw v.p(this.f17654d, i, i7.getSimpleName() + " must include generic type (e.g., " + i7.getSimpleName() + "<String>)", new Object[0]);
                    } else if (i7.isArray()) {
                        return new m.d(value4, this.f17653c.j(a(i7.getComponentType()), annotationArr), encoded3).b();
                    } else {
                        return new m.d(value4, this.f17653c.j(type, annotationArr), encoded3);
                    }
                } else {
                    throw v.p(this.f17654d, i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
            } else if (annotation instanceof d) {
                j(i, type);
                if (this.r) {
                    Class<?> i8 = v.i(type);
                    if (Map.class.isAssignableFrom(i8)) {
                        Type j3 = v.j(type, i8, Map.class);
                        if (j3 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) j3;
                            Type h3 = v.h(0, parameterizedType3);
                            if (String.class == h3) {
                                f j4 = this.f17653c.j(v.h(1, parameterizedType3), annotationArr);
                                this.h = true;
                                return new m.e(this.f17654d, i, j4, ((d) annotation).encoded());
                            }
                            throw v.p(this.f17654d, i, "@FieldMap keys must be of type String: " + h3, new Object[0]);
                        }
                        throw v.p(this.f17654d, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw v.p(this.f17654d, i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw v.p(this.f17654d, i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof q) {
                j(i, type);
                if (this.s) {
                    q qVar = (q) annotation;
                    this.i = true;
                    String value5 = qVar.value();
                    Class<?> i9 = v.i(type);
                    if (!value5.isEmpty()) {
                        Headers of = Headers.of("Content-Disposition", "form-data; name=\"" + value5 + SSLClient.DOUBLE_QUOTATION, HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, qVar.encoding());
                        if (Iterable.class.isAssignableFrom(i9)) {
                            if (type instanceof ParameterizedType) {
                                Type h4 = v.h(0, (ParameterizedType) type);
                                if (!MultipartBody.Part.class.isAssignableFrom(v.i(h4))) {
                                    return new m.i(this.f17654d, i, of, this.f17653c.h(h4, annotationArr, this.f17655e)).c();
                                }
                                throw v.p(this.f17654d, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                            }
                            throw v.p(this.f17654d, i, i9.getSimpleName() + " must include generic type (e.g., " + i9.getSimpleName() + "<String>)", new Object[0]);
                        } else if (i9.isArray()) {
                            Class<?> a2 = a(i9.getComponentType());
                            if (!MultipartBody.Part.class.isAssignableFrom(a2)) {
                                return new m.i(this.f17654d, i, of, this.f17653c.h(a2, annotationArr, this.f17655e)).b();
                            }
                            throw v.p(this.f17654d, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        } else if (!MultipartBody.Part.class.isAssignableFrom(i9)) {
                            return new m.i(this.f17654d, i, of, this.f17653c.h(type, annotationArr, this.f17655e));
                        } else {
                            throw v.p(this.f17654d, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                    } else if (Iterable.class.isAssignableFrom(i9)) {
                        if (!(type instanceof ParameterizedType)) {
                            throw v.p(this.f17654d, i, i9.getSimpleName() + " must include generic type (e.g., " + i9.getSimpleName() + "<String>)", new Object[0]);
                        } else if (MultipartBody.Part.class.isAssignableFrom(v.i(v.h(0, (ParameterizedType) type)))) {
                            return m.o.a.c();
                        } else {
                            throw v.p(this.f17654d, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    } else if (i9.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(i9.getComponentType())) {
                            return m.o.a.b();
                        }
                        throw v.p(this.f17654d, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    } else if (MultipartBody.Part.class.isAssignableFrom(i9)) {
                        return m.o.a;
                    } else {
                        throw v.p(this.f17654d, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                } else {
                    throw v.p(this.f17654d, i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
            } else if (annotation instanceof r) {
                j(i, type);
                if (this.s) {
                    this.i = true;
                    Class<?> i10 = v.i(type);
                    if (Map.class.isAssignableFrom(i10)) {
                        Type j5 = v.j(type, i10, Map.class);
                        if (j5 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) j5;
                            Type h5 = v.h(0, parameterizedType4);
                            if (String.class == h5) {
                                Type h6 = v.h(1, parameterizedType4);
                                if (!MultipartBody.Part.class.isAssignableFrom(v.i(h6))) {
                                    return new m.j(this.f17654d, i, this.f17653c.h(h6, annotationArr, this.f17655e), ((r) annotation).encoding());
                                }
                                throw v.p(this.f17654d, i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw v.p(this.f17654d, i, "@PartMap keys must be of type String: " + h5, new Object[0]);
                        }
                        throw v.p(this.f17654d, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw v.p(this.f17654d, i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw v.p(this.f17654d, i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof retrofit2.x.a) {
                j(i, type);
                if (this.r || this.s) {
                    throw v.p(this.f17654d, i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                } else if (!this.j) {
                    try {
                        f h7 = this.f17653c.h(type, annotationArr, this.f17655e);
                        this.j = true;
                        return new m.c(this.f17654d, i, h7);
                    } catch (RuntimeException e2) {
                        throw v.q(this.f17654d, e2, i, "Unable to create @Body converter for %s", type);
                    }
                } else {
                    throw v.p(this.f17654d, i, "Multiple @Body method annotations found.", new Object[0]);
                }
            } else if (!(annotation instanceof x)) {
                return null;
            } else {
                j(i, type);
                Class<?> i11 = v.i(type);
                for (int i12 = i - 1; i12 >= 0; i12--) {
                    m<?> mVar = this.x[i12];
                    if ((mVar instanceof m.q) && ((m.q) mVar).a.equals(i11)) {
                        throw v.p(this.f17654d, i, "@Tag type " + i11.getName() + " is duplicate of parameter #" + (i12 + 1) + " and would always overwrite its value.", new Object[0]);
                    }
                }
                return new m.q(i11);
            }
        }

        static Set<String> h(String str) {
            Matcher matcher = a.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i, String str) {
            if (!f17652b.matcher(str).matches()) {
                throw v.p(this.f17654d, i, "@Path parameter name must match %s. Found: %s", a.pattern(), str);
            } else if (!this.w.contains(str)) {
                throw v.p(this.f17654d, i, "URL \"%s\" does not contain \"{%s}\".", this.t, str);
            }
        }

        private void j(int i, Type type) {
            if (v.k(type)) {
                throw v.p(this.f17654d, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        p b() {
            for (Annotation annotation : this.f17655e) {
                e(annotation);
            }
            if (this.p != null) {
                if (!this.q) {
                    if (this.s) {
                        throw v.n(this.f17654d, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.r) {
                        throw v.n(this.f17654d, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f17656f.length;
                this.x = new m[length];
                int i = length - 1;
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 >= length) {
                        break;
                    }
                    m<?>[] mVarArr = this.x;
                    Type type = this.g[i2];
                    Annotation[] annotationArr = this.f17656f[i2];
                    if (i2 != i) {
                        z = false;
                    }
                    mVarArr[i2] = f(i2, type, annotationArr, z);
                    i2++;
                }
                if (this.t != null || this.o) {
                    boolean z2 = this.r;
                    if (!z2 && !this.s && !this.q && this.j) {
                        throw v.n(this.f17654d, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                    } else if (z2 && !this.h) {
                        throw v.n(this.f17654d, "Form-encoded method must contain at least one @Field.", new Object[0]);
                    } else if (!this.s || this.i) {
                        return new p(this);
                    } else {
                        throw v.n(this.f17654d, "Multipart method must contain at least one @Part.", new Object[0]);
                    }
                } else {
                    throw v.n(this.f17654d, "Missing either @%s URL or @Url parameter.", this.p);
                }
            } else {
                throw v.n(this.f17654d, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }
    }

    p(a aVar) {
        this.a = aVar.f17654d;
        this.f17647b = aVar.f17653c.f17660c;
        this.f17648c = aVar.p;
        this.f17649d = aVar.t;
        this.f17650e = aVar.u;
        this.f17651f = aVar.v;
        this.g = aVar.q;
        this.h = aVar.r;
        this.i = aVar.s;
        this.j = aVar.x;
        this.k = aVar.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p b(r rVar, Method method) {
        return new a(rVar, method).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request a(Object[] objArr) throws IOException {
        m<?>[] mVarArr = this.j;
        int length = objArr.length;
        if (length == mVarArr.length) {
            o oVar = new o(this.f17648c, this.f17647b, this.f17649d, this.f17650e, this.f17651f, this.g, this.h, this.i);
            if (this.k) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(objArr[i]);
                mVarArr[i].a(oVar, objArr[i]);
            }
            return oVar.k().tag(i.class, new i(this.a, arrayList)).build();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + mVarArr.length + ")");
    }
}
