package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.h.n;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.synchronization.a;
import java.util.concurrent.Executor;

/* compiled from: WorkInitializer.java */
/* loaded from: classes.dex */
public class s {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final y f1998b;

    /* renamed from: c  reason: collision with root package name */
    private final u f1999c;

    /* renamed from: d  reason: collision with root package name */
    private final a f2000d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Executor executor, y yVar, u uVar, a aVar) {
        this.a = executor;
        this.f1998b = yVar;
        this.f1999c = uVar;
        this.f2000d = aVar;
    }

    private /* synthetic */ Object b() {
        for (n nVar : this.f1998b.h()) {
            this.f1999c.a(nVar, 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e() {
        this.f2000d.a(new a.AbstractC0073a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.k
            @Override // com.google.android.datatransport.runtime.synchronization.a.AbstractC0073a
            public final Object execute() {
                s.this.c();
                return null;
            }
        });
    }

    public void a() {
        this.a.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.l
            @Override // java.lang.Runnable
            public final void run() {
                s.this.e();
            }
        });
    }

    public /* synthetic */ Object c() {
        b();
        return null;
    }
}
