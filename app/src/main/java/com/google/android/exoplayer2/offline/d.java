package com.google.android.exoplayer2.offline;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.c;
import com.google.android.exoplayer2.util.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: DownloadManager.java */
/* loaded from: classes.dex */
public final class d {
    public static final Requirements a = new Requirements(1);

    /* renamed from: b  reason: collision with root package name */
    private final Context f3096b;

    /* renamed from: c  reason: collision with root package name */
    private final c.AbstractC0082c f3097c;

    /* renamed from: d  reason: collision with root package name */
    private final CopyOnWriteArraySet<a> f3098d;

    /* renamed from: e  reason: collision with root package name */
    private int f3099e;

    /* renamed from: f  reason: collision with root package name */
    private int f3100f;
    private boolean g;
    private boolean h;
    private int i;
    private boolean j;
    private List<b> k;
    private c l;

    /* compiled from: DownloadManager.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(d dVar, boolean z);

        void b(d dVar, Requirements requirements, int i);
    }

    private void i() {
        Iterator<a> it = this.f3098d.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.j);
        }
    }

    private void j(c cVar, int i) {
        Requirements f2 = cVar.f();
        if (this.i == i) {
            boolean r = r();
            Iterator<a> it = this.f3098d.iterator();
            while (it.hasNext()) {
                it.next().b(this, f2, i);
            }
            if (r) {
                i();
                return;
            }
            return;
        }
        this.i = i;
        this.f3099e++;
        throw null;
    }

    private void o(boolean z) {
        if (this.h != z) {
            this.h = z;
            this.f3099e++;
            throw null;
        }
    }

    private boolean r() {
        boolean z;
        boolean z2 = true;
        if (!this.h && this.i != 0) {
            for (int i = 0; i < this.k.size(); i++) {
                if (this.k.get(i).a == 0) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (this.j == z) {
            z2 = false;
        }
        this.j = z;
        return z2;
    }

    public void a(DownloadRequest downloadRequest, int i) {
        this.f3099e++;
        throw null;
    }

    public void b(a aVar) {
        g.e(aVar);
        this.f3098d.add(aVar);
    }

    public List<b> c() {
        return this.k;
    }

    public boolean d() {
        return this.h;
    }

    public Requirements e() {
        return this.l.f();
    }

    public boolean f() {
        return this.f3100f == 0 && this.f3099e == 0;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.j;
    }

    public void k() {
        o(true);
    }

    public void l() {
        this.f3099e++;
        throw null;
    }

    public void m(String str) {
        this.f3099e++;
        throw null;
    }

    public void n() {
        o(false);
    }

    public void p(Requirements requirements) {
        if (!requirements.equals(this.l.f())) {
            this.l.j();
            c cVar = new c(this.f3096b, this.f3097c, requirements);
            this.l = cVar;
            j(this.l, cVar.i());
        }
    }

    public void q(@Nullable String str, int i) {
        this.f3099e++;
        throw null;
    }
}
