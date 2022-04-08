package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.j;

/* compiled from: CoroutineName.kt */
/* loaded from: classes4.dex */
public final class c0 extends kotlin.coroutines.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f16426c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private final String f16427d;

    /* compiled from: CoroutineName.kt */
    /* loaded from: classes4.dex */
    public static final class a implements f.c<c0> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof c0) && j.a(this.f16427d, ((c0) obj).f16427d);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f16427d;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CoroutineName(" + this.f16427d + ')';
    }

    public final String u() {
        return this.f16427d;
    }
}
