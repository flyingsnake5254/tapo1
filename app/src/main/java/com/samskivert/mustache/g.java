package com.samskivert.mustache;

import com.samskivert.mustache.MustacheException;
import com.samskivert.mustache.f;
import com.tplink.libtpmediastatistics.SSLClient;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: Template.java */
/* loaded from: classes2.dex */
public class g {
    public static final Object a = new String("<no fetcher found>");

    /* renamed from: b  reason: collision with root package name */
    protected static f.v f5171b = new b();

    /* renamed from: c  reason: collision with root package name */
    protected final f[] f5172c;

    /* renamed from: d  reason: collision with root package name */
    protected final f.C0186f f5173d;

    /* renamed from: e  reason: collision with root package name */
    protected final Map<e, f.v> f5174e;

    /* renamed from: f  reason: collision with root package name */
    protected final e f5175f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Template.java */
    /* loaded from: classes2.dex */
    public class a extends d {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f5176b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f[] f5177c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c cVar, f[] fVarArr) {
            super();
            this.f5176b = cVar;
            this.f5177c = fVarArr;
        }
    }

    /* compiled from: Template.java */
    /* loaded from: classes2.dex */
    static class b implements f.v {
        b() {
        }

        @Override // com.samskivert.mustache.f.v
        public Object a(Object obj, String str) throws Exception {
            return g.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Template.java */
    /* loaded from: classes2.dex */
    public static class c {
        public final Object a;

        /* renamed from: b  reason: collision with root package name */
        public final c f5179b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5180c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f5181d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f5182e;

        public c(Object obj, c cVar, int i, boolean z, boolean z2) {
            this.a = obj;
            this.f5179b = cVar;
            this.f5180c = i;
            this.f5181d = z;
            this.f5182e = z2;
        }

        public c a(Object obj) {
            return new c(obj, this, this.f5180c, this.f5181d, this.f5182e);
        }

        public c b(Object obj, int i, boolean z, boolean z2) {
            return new c(obj, this, i, z, z2);
        }
    }

    /* compiled from: Template.java */
    /* loaded from: classes2.dex */
    public abstract class d {
        public d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Template.java */
    /* loaded from: classes2.dex */
    public static class e {
        public final Class<?> a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5183b;

        public e(Class<?> cls, String str) {
            this.a = cls;
            this.f5183b = str;
        }

        public boolean equals(Object obj) {
            e eVar = (e) obj;
            return eVar.a == this.a && eVar.f5183b.equals(this.f5183b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.f5183b.hashCode();
        }

        public String toString() {
            return this.a.getName() + SSLClient.COLON + this.f5183b;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Template.java */
    /* loaded from: classes2.dex */
    public static abstract class f {
        /* JADX INFO: Access modifiers changed from: protected */
        public static void b(Writer writer, String str) {
            try {
                writer.write(str);
            } catch (IOException e2) {
                throw new MustacheException(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract void a(g gVar, c cVar, Writer writer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(f[] fVarArr, f.C0186f fVar, e eVar) {
        this.f5172c = fVarArr;
        this.f5173d = fVar;
        this.f5174e = fVar.j.b();
        this.f5175f = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean l(String str) {
        return ".".equals(str) || "this".equals(str);
    }

    protected Object a(String str, int i, boolean z, Object obj) {
        if (obj != a) {
            return obj;
        }
        if (z) {
            return null;
        }
        throw new MustacheException.Context("No method or field with name '" + str + "' on line " + i, str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d b(f[] fVarArr, c cVar) {
        return new a(cVar, fVarArr);
    }

    public String c(Object obj) throws MustacheException {
        StringWriter stringWriter = new StringWriter();
        d(obj, stringWriter);
        return stringWriter.toString();
    }

    public void d(Object obj, Writer writer) throws MustacheException {
        e(new c(obj, null, 0, false, false), writer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(c cVar, Writer writer) throws MustacheException {
        for (f fVar : this.f5172c) {
            fVar.a(this, cVar, writer);
        }
    }

    protected Object f(c cVar, String str, int i, boolean z) {
        String[] split = str.split("\\.");
        Object i2 = i(cVar, split[0], i, z);
        for (int i3 = 1; i3 < split.length; i3++) {
            if (i2 == a) {
                if (z) {
                    return null;
                }
                throw new MustacheException.Context("Missing context for compound variable '" + str + "' on line " + i + ". '" + split[i3 - 1] + "' was not found.", str, i);
            } else if (i2 == null) {
                return null;
            } else {
                i2 = j(i2, split[i3], i);
            }
        }
        return a(str, i, z, i2);
    }

    protected Object g(c cVar, d dVar, int i) {
        Object i2 = i(cVar, dVar.a(), i, true);
        if (!(i2 instanceof f.k)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : dVar.b()) {
                if (obj instanceof d) {
                    Object g = g(cVar, (d) obj, i);
                    if (g != null) {
                        arrayList.add(g);
                    }
                } else if (obj instanceof String) {
                    Object i3 = i(cVar, (String) obj, i, true);
                    if (i3 == null) {
                        arrayList.add(obj);
                    } else {
                        arrayList.add(i3);
                    }
                }
            }
            return ((f.k) i2).a(cVar.a, arrayList);
        } catch (Exception e2) {
            throw new MustacheException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object h(c cVar, String str, int i) {
        Object i2 = i(cVar, str, i, !this.f5173d.f5149b);
        return i2 == null ? Collections.emptyList() : i2;
    }

    protected Object i(c cVar, String str, int i, boolean z) {
        if (str.equals("@first")) {
            return Boolean.valueOf(cVar.f5181d);
        }
        if (str.equals("@last")) {
            return Boolean.valueOf(cVar.f5182e);
        }
        if (str.equals("@index")) {
            return Integer.valueOf(cVar.f5180c);
        }
        if (str.equals("@indexPlusOne")) {
            return Integer.valueOf(cVar.f5180c + 1);
        }
        if (this.f5173d.a) {
            return a(str, i, z, j(cVar.a, str, i));
        }
        if (!this.f5175f.b(str) || this.f5175f.a(str)) {
            for (c cVar2 = cVar; cVar2 != null; cVar2 = cVar2.f5179b) {
                Object j = j(cVar2.a, str, i);
                if (j != a) {
                    return j;
                }
            }
            if (!(str.equals(".") || str.indexOf(".") == -1)) {
                return f(cVar, str, i, z);
            }
            if (!this.f5175f.b(str)) {
                return a(str, i, z, a);
            }
            d c2 = this.f5175f.c(str);
            if (c2 != null) {
                return g(cVar, c2, i);
            }
            throw new MustacheException.Context("Could not parse function", str, i);
        }
        d c3 = this.f5175f.c(str);
        if (c3 != null) {
            return g(cVar, c3, i);
        }
        throw new MustacheException.Context("Could not parse function", str, i);
    }

    protected Object j(Object obj, String str, int i) {
        f.v c2;
        if (l(str)) {
            return obj;
        }
        if (obj != null) {
            e eVar = new e(obj.getClass(), str);
            f.v vVar = this.f5174e.get(eVar);
            if (vVar != null) {
                try {
                    return vVar.a(obj, str);
                } catch (Exception unused) {
                    c2 = this.f5173d.j.c(obj, eVar.f5183b);
                }
            } else {
                c2 = this.f5173d.j.c(obj, eVar.f5183b);
            }
            if (c2 == null) {
                c2 = f5171b;
            }
            try {
                Object a2 = c2.a(obj, str);
                this.f5174e.put(eVar, c2);
                return a2;
            } catch (Exception e2) {
                throw new MustacheException.Context("Failure fetching variable '" + str + "' on line " + i, str, i, e2);
            }
        } else {
            throw new NullPointerException("Null context for variable '" + str + "' on line " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object k(c cVar, String str, int i) {
        Object i2 = i(cVar, str, i, this.f5173d.f5151d);
        return i2 == null ? this.f5173d.c(str) : i2;
    }
}
