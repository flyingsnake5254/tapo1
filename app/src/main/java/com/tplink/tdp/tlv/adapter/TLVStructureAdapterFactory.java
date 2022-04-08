package com.tplink.tdp.tlv.adapter;

import b.d.c0.m.d.c;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class TLVStructureAdapterFactory implements d {
    private a a;

    /* loaded from: classes3.dex */
    static final class Adapter<T> extends c<T> {
        private b<T> a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Short, b> f15230b;

        Adapter(b<T> bVar, Map<Short, b> map) {
            this.a = bVar;
            this.f15230b = map;
        }

        @Override // com.tplink.tdp.tlv.adapter.c
        public T a(b.d.c0.m.e.a aVar) {
            try {
                T a = this.a.a();
                while (aVar.b()) {
                    b bVar = this.f15230b.get(Short.valueOf(aVar.n()));
                    if (bVar == null) {
                        aVar.o();
                    } else {
                        bVar.a(aVar, a);
                    }
                }
                return a;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends b {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f15231c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Field f15232d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(short s, boolean z, c cVar, Field field) {
            super(s, z);
            this.f15231c = cVar;
            this.f15232d = field;
        }

        @Override // com.tplink.tdp.tlv.adapter.TLVStructureAdapterFactory.b
        public void a(b.d.c0.m.e.a aVar, Object obj) throws IllegalAccessException {
            c cVar = this.f15231c;
            if (cVar != null) {
                if (this.f15234b) {
                    this.f15232d.set(obj, this.f15231c.a(new b.d.c0.m.e.a(aVar.o())));
                    return;
                }
                this.f15232d.set(obj, cVar.a(aVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class b {
        final short a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f15234b;

        b(short s, boolean z) {
            this.a = s;
            this.f15234b = z;
        }

        public abstract void a(b.d.c0.m.e.a aVar, Object obj) throws IllegalAccessException;
    }

    public TLVStructureAdapterFactory(a aVar) {
        this.a = aVar;
    }

    private b b(b.d.c0.m.a aVar, short s, Field field) {
        Class<?> type = field.getType();
        return new a(s, type.isAnnotationPresent(b.d.c0.m.d.b.class), c(aVar, new e<>(type, field.getGenericType()), field.isAnnotationPresent(b.d.c0.m.d.a.class) ? (b.d.c0.m.d.a) field.getAnnotation(b.d.c0.m.d.a.class) : null), field);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tplink.tdp.tlv.adapter.c<?> c(b.d.c0.m.a r3, com.tplink.tdp.tlv.adapter.e<?> r4, b.d.c0.m.d.a r5) {
        /*
            r2 = this;
            if (r5 == 0) goto L_0x0027
            com.tplink.tdp.tlv.adapter.a r0 = r2.a
            com.tplink.tdp.tlv.adapter.e r1 = new com.tplink.tdp.tlv.adapter.e
            java.lang.Class r5 = r5.value()
            r1.<init>(r5)
            com.tplink.tdp.tlv.adapter.b r5 = r0.a(r1)
            java.lang.Object r5 = r5.a()
            boolean r0 = r5 instanceof com.tplink.tdp.tlv.adapter.c
            if (r0 == 0) goto L_0x001c
            com.tplink.tdp.tlv.adapter.c r5 = (com.tplink.tdp.tlv.adapter.c) r5
            goto L_0x0028
        L_0x001c:
            boolean r0 = r5 instanceof com.tplink.tdp.tlv.adapter.d
            if (r0 == 0) goto L_0x0027
            com.tplink.tdp.tlv.adapter.d r5 = (com.tplink.tdp.tlv.adapter.d) r5
            com.tplink.tdp.tlv.adapter.c r5 = r5.a(r3, r4)
            goto L_0x0028
        L_0x0027:
            r5 = 0
        L_0x0028:
            if (r5 != 0) goto L_0x002e
            com.tplink.tdp.tlv.adapter.c r5 = r3.b(r4)
        L_0x002e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.tdp.tlv.adapter.TLVStructureAdapterFactory.c(b.d.c0.m.a, com.tplink.tdp.tlv.adapter.e, b.d.c0.m.d.a):com.tplink.tdp.tlv.adapter.c");
    }

    private Map<Short, b> d(b.d.c0.m.a aVar, e eVar) {
        HashMap hashMap = new HashMap();
        for (Class<?> a2 = eVar.a(); a2 != Object.class; a2 = f.c(a2)) {
            Field[] declaredFields = a2.getDeclaredFields();
            short[] c2 = aVar.c();
            boolean z = c2 != null && c2.length > 0;
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(c.class)) {
                    field.setAccessible(true);
                    short value = ((c) field.getAnnotation(c.class)).value();
                    if (!z || !e(c2, value)) {
                        hashMap.put(Short.valueOf(value), b(aVar, value, field));
                    }
                }
            }
        }
        return hashMap;
    }

    private boolean e(short[] sArr, short s) {
        for (short s2 : sArr) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tplink.tdp.tlv.adapter.d
    public <T> c<T> a(b.d.c0.m.a aVar, e<T> eVar) {
        if (!Object.class.isAssignableFrom(eVar.a())) {
            return null;
        }
        return new Adapter(this.a.a(eVar), d(aVar, eVar));
    }
}
