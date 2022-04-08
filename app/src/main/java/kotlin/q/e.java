package kotlin.q;

import java.util.Comparator;
import kotlin.jvm.internal.j;

/* compiled from: Comparisons.kt */
/* loaded from: classes4.dex */
final class e implements Comparator<Comparable<? super Object>> {

    /* renamed from: c  reason: collision with root package name */
    public static final e f16357c = new e();

    private e() {
    }

    /* renamed from: a */
    public int compare(Comparable<Object> a, Comparable<Object> b2) {
        j.e(a, "a");
        j.e(b2, "b");
        return a.compareTo(b2);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return f.f16358c;
    }
}
