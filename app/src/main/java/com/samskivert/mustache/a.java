package com.samskivert.mustache;

import com.samskivert.mustache.f;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: BasicCollector.java */
/* loaded from: classes2.dex */
public abstract class a implements f.e {
    protected static final f.v a = new g();

    /* renamed from: b  reason: collision with root package name */
    protected static final f.v f5125b = new h();

    /* renamed from: c  reason: collision with root package name */
    protected static final f.v f5126c = new i();

    /* renamed from: d  reason: collision with root package name */
    protected static final f.v f5127d = new j();

    /* renamed from: e  reason: collision with root package name */
    protected static final o f5128e = new k();

    /* renamed from: f  reason: collision with root package name */
    protected static final o f5129f = new l();
    protected static final o g = new m();
    protected static final o h = new n();
    protected static final o i = new C0184a();
    protected static final o j = new b();
    protected static final o k = new c();
    protected static final o l = new d();
    protected static final o m = new e();

    /* compiled from: BasicCollector.java */
    /* renamed from: com.samskivert.mustache.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0184a extends o {
        C0184a() {
        }

        @Override // com.samskivert.mustache.a.o
        protected Object b(Object obj, int i) {
            return Short.valueOf(((short[]) obj)[i]);
        }

        @Override // com.samskivert.mustache.a.o
        public int c(Object obj) {
            return ((short[]) obj).length;
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class b extends o {
        b() {
        }

        @Override // com.samskivert.mustache.a.o
        protected Object b(Object obj, int i) {
            return Integer.valueOf(((int[]) obj)[i]);
        }

        @Override // com.samskivert.mustache.a.o
        public int c(Object obj) {
            return ((int[]) obj).length;
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class c extends o {
        c() {
        }

        @Override // com.samskivert.mustache.a.o
        protected Object b(Object obj, int i) {
            return Long.valueOf(((long[]) obj)[i]);
        }

        @Override // com.samskivert.mustache.a.o
        public int c(Object obj) {
            return ((long[]) obj).length;
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class d extends o {
        d() {
        }

        @Override // com.samskivert.mustache.a.o
        protected Object b(Object obj, int i) {
            return Float.valueOf(((float[]) obj)[i]);
        }

        @Override // com.samskivert.mustache.a.o
        public int c(Object obj) {
            return ((float[]) obj).length;
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class e extends o {
        e() {
        }

        @Override // com.samskivert.mustache.a.o
        protected Object b(Object obj, int i) {
            return Double.valueOf(((double[]) obj)[i]);
        }

        @Override // com.samskivert.mustache.a.o
        public int c(Object obj) {
            return ((double[]) obj).length;
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    class f implements Iterator<Object> {

        /* renamed from: c  reason: collision with root package name */
        private int f5130c;

        /* renamed from: d  reason: collision with root package name */
        private int f5131d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ o f5132f;
        final /* synthetic */ Object q;

        f(o oVar, Object obj) {
            this.f5132f = oVar;
            this.q = obj;
            this.f5130c = oVar.c(obj);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5131d < this.f5130c;
        }

        @Override // java.util.Iterator
        public Object next() {
            o oVar = this.f5132f;
            Object obj = this.q;
            int i = this.f5131d;
            this.f5131d = i + 1;
            return oVar.b(obj, i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class g implements f.v {
        g() {
        }

        @Override // com.samskivert.mustache.f.v
        public Object a(Object obj, String str) throws Exception {
            Object obj2 = ((f.g) obj).get(str);
            return obj2 == null ? g.a : obj2;
        }

        public String toString() {
            return "CUSTOM_FETCHER";
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class h implements f.v {
        h() {
        }

        @Override // com.samskivert.mustache.f.v
        public Object a(Object obj, String str) throws Exception {
            Map map = (Map) obj;
            return map.containsKey(str) ? map.get(str) : "entrySet".equals(str) ? map.entrySet() : g.a;
        }

        public String toString() {
            return "MAP_FETCHER";
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class i implements f.v {
        i() {
        }

        @Override // com.samskivert.mustache.f.v
        public Object a(Object obj, String str) throws Exception {
            try {
                return ((List) obj).get(Integer.parseInt(str));
            } catch (IndexOutOfBoundsException unused) {
                return g.a;
            } catch (NumberFormatException unused2) {
                return g.a;
            }
        }

        public String toString() {
            return "LIST_FETCHER";
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class j implements f.v {
        j() {
        }

        @Override // com.samskivert.mustache.f.v
        public Object a(Object obj, String str) throws Exception {
            try {
                Iterator it = (Iterator) obj;
                int parseInt = Integer.parseInt(str);
                for (int i = 0; i < parseInt; i++) {
                    it.next();
                }
                return it.next();
            } catch (NumberFormatException unused) {
                return g.a;
            } catch (NoSuchElementException unused2) {
                return g.a;
            }
        }

        public String toString() {
            return "ITER_FETCHER";
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class k extends o {
        k() {
        }

        @Override // com.samskivert.mustache.a.o
        protected Object b(Object obj, int i) {
            return ((Object[]) obj)[i];
        }

        @Override // com.samskivert.mustache.a.o
        public int c(Object obj) {
            return ((Object[]) obj).length;
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class l extends o {
        l() {
        }

        @Override // com.samskivert.mustache.a.o
        protected Object b(Object obj, int i) {
            return Boolean.valueOf(((boolean[]) obj)[i]);
        }

        @Override // com.samskivert.mustache.a.o
        public int c(Object obj) {
            return ((boolean[]) obj).length;
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class m extends o {
        m() {
        }

        @Override // com.samskivert.mustache.a.o
        protected Object b(Object obj, int i) {
            return Byte.valueOf(((byte[]) obj)[i]);
        }

        @Override // com.samskivert.mustache.a.o
        public int c(Object obj) {
            return ((byte[]) obj).length;
        }
    }

    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    static class n extends o {
        n() {
        }

        @Override // com.samskivert.mustache.a.o
        protected Object b(Object obj, int i) {
            return Character.valueOf(((char[]) obj)[i]);
        }

        @Override // com.samskivert.mustache.a.o
        public int c(Object obj) {
            return ((char[]) obj).length;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: BasicCollector.java */
    /* loaded from: classes2.dex */
    public static abstract class o implements f.v {
        protected o() {
        }

        @Override // com.samskivert.mustache.f.v
        public Object a(Object obj, String str) throws Exception {
            try {
                return b(obj, Integer.parseInt(str));
            } catch (ArrayIndexOutOfBoundsException unused) {
                return g.a;
            } catch (NumberFormatException unused2) {
                return g.a;
            }
        }

        protected abstract Object b(Object obj, int i);

        public abstract int c(Object obj);
    }

    protected static o d(Object obj) {
        if (obj instanceof Object[]) {
            return f5128e;
        }
        if (obj instanceof boolean[]) {
            return f5129f;
        }
        if (obj instanceof byte[]) {
            return g;
        }
        if (obj instanceof char[]) {
            return h;
        }
        if (obj instanceof short[]) {
            return i;
        }
        if (obj instanceof int[]) {
            return j;
        }
        if (obj instanceof long[]) {
            return k;
        }
        if (obj instanceof float[]) {
            return l;
        }
        if (obj instanceof double[]) {
            return m;
        }
        return null;
    }

    @Override // com.samskivert.mustache.f.e
    public Iterator<?> a(Object obj) {
        if (obj instanceof Iterable) {
            return ((Iterable) obj).iterator();
        }
        if (obj instanceof Iterator) {
            return (Iterator) obj;
        }
        if (obj.getClass().isArray()) {
            return new f(d(obj), obj);
        }
        return null;
    }

    @Override // com.samskivert.mustache.f.e
    public f.v c(Object obj, String str) {
        if (obj instanceof f.g) {
            return a;
        }
        if (obj instanceof Map) {
            return f5125b;
        }
        char charAt = str.charAt(0);
        if (charAt < '0' || charAt > '9') {
            return null;
        }
        if (obj instanceof List) {
            return f5126c;
        }
        if (obj instanceof Iterator) {
            return f5127d;
        }
        if (obj.getClass().isArray()) {
            return d(obj);
        }
        return null;
    }
}
