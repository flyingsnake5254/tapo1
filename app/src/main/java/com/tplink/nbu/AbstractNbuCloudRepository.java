package com.tplink.nbu;

import com.tplink.cloud.context.b;
import com.tplink.nbu.b.m;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class AbstractNbuCloudRepository extends b.d.b.f.a {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<b, m> f15151c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    protected m f15152d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements b.a {
        final /* synthetic */ b a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f15153b;

        a(b bVar, m mVar) {
            this.a = bVar;
            this.f15153b = mVar;
        }

        @Override // com.tplink.cloud.context.b.a
        public void a() {
            AbstractNbuCloudRepository.e(this.a);
            this.f15153b.Q1();
            this.a.f(this);
        }
    }

    public AbstractNbuCloudRepository(b bVar) {
        super(bVar);
        this.f15152d = f(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(b bVar) {
        f15151c.remove(bVar);
    }

    private static m f(b bVar) {
        Map<b, m> map = f15151c;
        m mVar = map.get(bVar);
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(bVar);
        map.put(bVar, mVar2);
        g(bVar, mVar2);
        return mVar2;
    }

    private static void g(b bVar, m mVar) {
        bVar.a(new a(bVar, mVar));
    }
}
