package kotlinx.coroutines.scheduling;

import kotlin.jvm.internal.j;

/* compiled from: Tasks.kt */
/* loaded from: classes4.dex */
public abstract class h implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    public long f16546c;

    /* renamed from: d  reason: collision with root package name */
    public i f16547d;

    public h(long j, i taskContext) {
        j.f(taskContext, "taskContext");
        this.f16546c = j;
        this.f16547d = taskContext;
    }

    public final TaskMode a() {
        return this.f16547d.e();
    }

    public h() {
        this(0L, g.f16545d);
    }
}
