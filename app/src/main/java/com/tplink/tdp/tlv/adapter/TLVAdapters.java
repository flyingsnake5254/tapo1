package com.tplink.tdp.tlv.adapter;

/* loaded from: classes3.dex */
public class TLVAdapters {
    private static final c<String> a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f15222b;

    /* renamed from: c  reason: collision with root package name */
    private static final c<Integer> f15223c;

    /* renamed from: d  reason: collision with root package name */
    public static final d f15224d;

    /* renamed from: e  reason: collision with root package name */
    private static final c<Boolean> f15225e;

    /* renamed from: f  reason: collision with root package name */
    public static final d f15226f;
    private static final c<Byte> g;
    public static final d h;
    private static final c<Double> i;
    public static final d j;
    private static final c<Float> k;
    public static final d l;
    private static final c<Long> m;
    public static final d n;
    private static final c<Short> o;
    public static final d p;
    private static final c<Character> q;
    public static final d r;
    private static final c<b.d.c0.m.c> s = new c<b.d.c0.m.c>() { // from class: com.tplink.tdp.tlv.adapter.TLVAdapters.10
        /* renamed from: b */
        public b.d.c0.m.c a(b.d.c0.m.e.a aVar) {
            aVar.o();
            return new b.d.c0.m.c();
        }
    };
    public static final d t = new a();

    /* loaded from: classes3.dex */
    static class a implements d {
        a() {
        }

        @Override // com.tplink.tdp.tlv.adapter.d
        public <T> c<T> a(b.d.c0.m.a aVar, e<T> eVar) {
            if (b.d.c0.m.c.class.isAssignableFrom(eVar.a())) {
                return TLVAdapters.s;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b implements d {
        final /* synthetic */ Class a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f15227b;

        b(Class cls, c cVar) {
            this.a = cls;
            this.f15227b = cVar;
        }

        @Override // com.tplink.tdp.tlv.adapter.d
        public <T> c<T> a(b.d.c0.m.a aVar, e<T> eVar) {
            if (eVar.a() == this.a) {
                return this.f15227b;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c implements d {
        final /* synthetic */ Class a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f15228b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f15229c;

        c(Class cls, Class cls2, c cVar) {
            this.a = cls;
            this.f15228b = cls2;
            this.f15229c = cVar;
        }

        @Override // com.tplink.tdp.tlv.adapter.d
        public <T> c<T> a(b.d.c0.m.a aVar, e<T> eVar) {
            Class<? super T> a = eVar.a();
            if (a == this.a || a == this.f15228b) {
                return this.f15229c;
            }
            return null;
        }
    }

    static {
        c<String> cVar = new c<String>() { // from class: com.tplink.tdp.tlv.adapter.TLVAdapters.1
            /* renamed from: b */
            public String a(b.d.c0.m.e.a aVar) {
                return aVar.m();
            }
        };
        a = cVar;
        f15222b = b(String.class, cVar);
        c<Integer> cVar2 = new c<Integer>() { // from class: com.tplink.tdp.tlv.adapter.TLVAdapters.2
            /* renamed from: b */
            public Integer a(b.d.c0.m.e.a aVar) {
                return aVar.i();
            }
        };
        f15223c = cVar2;
        f15224d = c(Integer.TYPE, Integer.class, cVar2);
        c<Boolean> cVar3 = new c<Boolean>() { // from class: com.tplink.tdp.tlv.adapter.TLVAdapters.3
            /* renamed from: b */
            public Boolean a(b.d.c0.m.e.a aVar) {
                return aVar.d();
            }
        };
        f15225e = cVar3;
        f15226f = c(Boolean.TYPE, Boolean.class, cVar3);
        c<Byte> cVar4 = new c<Byte>() { // from class: com.tplink.tdp.tlv.adapter.TLVAdapters.4
            /* renamed from: b */
            public Byte a(b.d.c0.m.e.a aVar) {
                return aVar.e();
            }
        };
        g = cVar4;
        h = c(Byte.TYPE, Byte.class, cVar4);
        c<Double> cVar5 = new c<Double>() { // from class: com.tplink.tdp.tlv.adapter.TLVAdapters.5
            /* renamed from: b */
            public Double a(b.d.c0.m.e.a aVar) {
                return aVar.g();
            }
        };
        i = cVar5;
        j = c(Double.TYPE, Double.class, cVar5);
        c<Float> cVar6 = new c<Float>() { // from class: com.tplink.tdp.tlv.adapter.TLVAdapters.6
            /* renamed from: b */
            public Float a(b.d.c0.m.e.a aVar) {
                return aVar.h();
            }
        };
        k = cVar6;
        l = c(Float.TYPE, Float.class, cVar6);
        c<Long> cVar7 = new c<Long>() { // from class: com.tplink.tdp.tlv.adapter.TLVAdapters.7
            /* renamed from: b */
            public Long a(b.d.c0.m.e.a aVar) {
                return aVar.k();
            }
        };
        m = cVar7;
        n = c(Long.TYPE, Long.class, cVar7);
        c<Short> cVar8 = new c<Short>() { // from class: com.tplink.tdp.tlv.adapter.TLVAdapters.8
            /* renamed from: b */
            public Short a(b.d.c0.m.e.a aVar) {
                return aVar.l();
            }
        };
        o = cVar8;
        p = c(Short.TYPE, Short.class, cVar8);
        c<Character> cVar9 = new c<Character>() { // from class: com.tplink.tdp.tlv.adapter.TLVAdapters.9
            /* renamed from: b */
            public Character a(b.d.c0.m.e.a aVar) {
                return aVar.f();
            }
        };
        q = cVar9;
        r = c(Character.TYPE, Character.class, cVar9);
    }

    private static <TT> d b(Class<TT> cls, c<TT> cVar) {
        return new b(cls, cVar);
    }

    private static <TT> d c(Class<TT> cls, Class<TT> cls2, c<TT> cVar) {
        return new c(cls, cls2, cVar);
    }
}
