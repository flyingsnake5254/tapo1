package kotlinx.coroutines.internal;

import kotlin.jvm.internal.j;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes4.dex */
public final class h {
    private static final Object a = new t("CONDITION_FALSE");

    /* renamed from: b  reason: collision with root package name */
    private static final Object f16473b = new t("ALREADY_REMOVED");

    /* renamed from: c  reason: collision with root package name */
    private static final Object f16474c = new t("LIST_EMPTY");

    /* renamed from: d  reason: collision with root package name */
    private static final Object f16475d = new t("REMOVE_PREPARED");

    public static final /* synthetic */ Object a() {
        return f16475d;
    }

    public static final Object b() {
        return a;
    }

    public static final Object c() {
        return f16474c;
    }

    public static final i d(Object unwrap) {
        i iVar;
        j.f(unwrap, "$this$unwrap");
        p pVar = (p) (!(unwrap instanceof p) ? null : unwrap);
        return (pVar == null || (iVar = pVar.a) == null) ? (i) unwrap : iVar;
    }
}
