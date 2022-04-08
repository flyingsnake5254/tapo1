package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadContext.kt */
/* loaded from: classes4.dex */
public final class a0 {
    private Object[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f16471b;

    /* renamed from: c  reason: collision with root package name */
    private final f f16472c;

    public a0(f context, int i) {
        j.f(context, "context");
        this.f16472c = context;
        this.a = new Object[i];
    }

    public final void a(Object obj) {
        Object[] objArr = this.a;
        int i = this.f16471b;
        this.f16471b = i + 1;
        objArr[i] = obj;
    }

    public final f b() {
        return this.f16472c;
    }

    public final void c() {
        this.f16471b = 0;
    }

    public final Object d() {
        Object[] objArr = this.a;
        int i = this.f16471b;
        this.f16471b = i + 1;
        return objArr[i];
    }
}
