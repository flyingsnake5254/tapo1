package kotlin.jvm.internal;

import com.tplink.libtpnetwork.cameranetwork.bean.listing.ColumnFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.d0;
import kotlin.collections.e0;
import kotlin.collections.n;
import kotlin.jvm.b.b;
import kotlin.jvm.b.e;
import kotlin.jvm.b.f;
import kotlin.jvm.b.g;
import kotlin.jvm.b.h;
import kotlin.jvm.b.i;
import kotlin.jvm.b.j;
import kotlin.jvm.b.k;
import kotlin.jvm.b.l;
import kotlin.jvm.b.m;
import kotlin.jvm.b.o;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.b.r;
import kotlin.jvm.b.s;
import kotlin.jvm.b.t;
import kotlin.jvm.b.u;
import kotlin.jvm.b.v;
import kotlin.jvm.b.w;
import kotlin.reflect.c;

/* compiled from: ClassReference.kt */
/* loaded from: classes4.dex */
public final class d implements c<Object>, c {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends kotlin.c<?>>, Integer> f16345c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f16346d;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, String> f16347f;
    private static final HashMap<String, String> q;
    private static final Map<String, String> x;
    public static final a y = new a(null);
    private final Class<?> z;

    /* compiled from: ClassReference.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
            if (r1 != null) goto L_0x0066;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String a(java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.j.e(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                java.lang.String r1 = "Array"
                r2 = 0
                if (r0 == 0) goto L_0x0011
            L_0x000e:
                r1 = r2
                goto L_0x00c1
            L_0x0011:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L_0x0073
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r1 = r8.getEnclosingMethod()
                java.lang.String r3 = "$"
                r4 = 2
                java.lang.String r5 = "name"
                if (r1 == 0) goto L_0x0043
                kotlin.jvm.internal.j.d(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = r1.getName()
                r6.append(r1)
                r6.append(r3)
                java.lang.String r1 = r6.toString()
                java.lang.String r1 = kotlin.text.m.m0(r0, r1, r2, r4, r2)
                if (r1 == 0) goto L_0x0043
                goto L_0x0066
            L_0x0043:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L_0x0065
                kotlin.jvm.internal.j.d(r0, r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r8 = r8.getName()
                r1.append(r8)
                r1.append(r3)
                java.lang.String r8 = r1.toString()
                java.lang.String r8 = kotlin.text.m.m0(r0, r8, r2, r4, r2)
                r1 = r8
                goto L_0x0066
            L_0x0065:
                r1 = r2
            L_0x0066:
                if (r1 == 0) goto L_0x0069
                goto L_0x00c1
            L_0x0069:
                kotlin.jvm.internal.j.d(r0, r5)
                r8 = 36
                java.lang.String r1 = kotlin.text.m.l0(r0, r8, r2, r4, r2)
                goto L_0x00c1
            L_0x0073:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto L_0x00ab
                java.lang.Class r8 = r8.getComponentType()
                java.lang.String r0 = "componentType"
                kotlin.jvm.internal.j.d(r8, r0)
                boolean r0 = r8.isPrimitive()
                if (r0 == 0) goto L_0x00a7
                java.util.Map r0 = kotlin.jvm.internal.d.c()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto L_0x00a7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r1)
                java.lang.String r2 = r0.toString()
            L_0x00a7:
                if (r2 == 0) goto L_0x00c1
                goto L_0x000e
            L_0x00ab:
                java.util.Map r0 = kotlin.jvm.internal.d.c()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto L_0x00bd
                goto L_0x00c1
            L_0x00bd:
                java.lang.String r1 = r8.getSimpleName()
            L_0x00c1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.d.a.a(java.lang.Class):java.lang.String");
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List g;
        int l;
        Map<Class<? extends kotlin.c<?>>, Integer> k;
        int a2;
        String o0;
        String o02;
        int i = 0;
        g = n.g(kotlin.jvm.b.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, b.class, kotlin.jvm.b.c.class, kotlin.jvm.b.d.class, e.class, f.class, g.class, h.class, i.class, j.class, k.class, m.class, kotlin.jvm.b.n.class, o.class);
        l = kotlin.collections.o.l(g, 10);
        ArrayList arrayList = new ArrayList(l);
        for (Object obj : g) {
            i++;
            if (i < 0) {
                n.k();
            }
            arrayList.add(kotlin.n.a((Class) obj, Integer.valueOf(i)));
        }
        k = e0.k(arrayList);
        f16345c = k;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ColumnFilter.TYPE_BOOLEAN, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put(ColumnFilter.TYPE_FLOAT, "kotlin.Float");
        hashMap.put(ColumnFilter.TYPE_LONG, "kotlin.Long");
        hashMap.put(ColumnFilter.TYPE_DOUBLE, "kotlin.Double");
        f16346d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f16347f = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        j.d(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            j.d(kotlinName, "kotlinName");
            o02 = kotlin.text.w.o0(kotlinName, '.', null, 2, null);
            sb.append(o02);
            sb.append("CompanionObject");
            Pair a3 = kotlin.n.a(sb.toString(), kotlinName + ".Companion");
            hashMap3.put(a3.getFirst(), a3.getSecond());
        }
        for (Map.Entry<Class<? extends kotlin.c<?>>, Integer> entry : f16345c.entrySet()) {
            int intValue = entry.getValue().intValue();
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + intValue);
        }
        q = hashMap3;
        a2 = d0.a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(a2);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            o0 = kotlin.text.w.o0((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, o0);
        }
        x = linkedHashMap;
    }

    public d(Class<?> jClass) {
        j.e(jClass, "jClass");
        this.z = jClass;
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> a() {
        return this.z;
    }

    @Override // kotlin.reflect.c
    public String b() {
        return y.a(a());
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && j.a(kotlin.jvm.a.b(this), kotlin.jvm.a.b((c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.b(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
