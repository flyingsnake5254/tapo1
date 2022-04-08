package com.tplink.iot.h.h;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: M3U8.java */
/* loaded from: classes2.dex */
public class a {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private List<b> f7990b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private long f7991c;

    /* renamed from: d  reason: collision with root package name */
    private long f7992d;

    /* renamed from: e  reason: collision with root package name */
    private long f7993e;

    /* renamed from: f  reason: collision with root package name */
    private long f7994f;

    public void a(b bVar) {
        this.f7990b.add(bVar);
    }

    public String b() {
        return this.a;
    }

    public List<b> c() {
        return this.f7990b;
    }

    public void d(String str) {
        this.a = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nbasepath: " + this.a);
        Iterator<b> it = this.f7990b.iterator();
        while (it.hasNext()) {
            sb.append("\nts_file_name = " + it.next());
        }
        sb.append("\nstartTime = " + this.f7991c);
        sb.append("\nendTime = " + this.f7992d);
        sb.append("\nstartDownloadTime = " + this.f7993e);
        sb.append("\nendDownloadTime = " + this.f7994f);
        return sb.toString();
    }
}
