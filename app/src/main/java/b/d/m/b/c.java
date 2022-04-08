package b.d.m.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DownloadStreamConnectionInfo.java */
/* loaded from: classes3.dex */
public class c {
    private a a;

    /* renamed from: b  reason: collision with root package name */
    private b f539b;

    /* renamed from: c  reason: collision with root package name */
    private int f540c;

    /* renamed from: d  reason: collision with root package name */
    private int f541d;

    /* renamed from: e  reason: collision with root package name */
    private String f542e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, io.reactivex.e0.c> f543f;

    public void a(String str, int i, io.reactivex.e0.c cVar) {
        if (this.f543f == null) {
            this.f543f = new HashMap();
        }
        String str2 = str + "_" + i;
        io.reactivex.e0.c cVar2 = this.f543f.get(str2);
        if (cVar2 != null && !cVar2.isDisposed()) {
            cVar2.dispose();
        }
        this.f543f.put(str2, cVar);
    }

    public void b() {
        Map<String, io.reactivex.e0.c> map = this.f543f;
        if (map != null) {
            Iterator<Map.Entry<String, io.reactivex.e0.c>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                io.reactivex.e0.c value = it.next().getValue();
                if (value != null && !value.isDisposed()) {
                    value.dispose();
                }
                it.remove();
            }
        }
    }

    public int c() {
        return this.f540c;
    }

    public a d() {
        return this.a;
    }

    public b e() {
        return this.f539b;
    }

    public int f() {
        return this.f541d;
    }

    public String g() {
        return this.f542e;
    }

    public void h(int i) {
        this.f540c = i;
    }

    public void i(a aVar) {
        this.a = aVar;
    }

    public void j(b bVar) {
        this.f539b = bVar;
    }

    public void k(int i) {
        this.f541d = i;
    }

    public void l(String str) {
        this.f542e = str;
    }
}
