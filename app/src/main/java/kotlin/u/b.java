package kotlin.u;

import java.util.Random;
import kotlin.jvm.internal.j;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes4.dex */
public final class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a f16408c = new a();

    /* compiled from: PlatformRandom.kt */
    /* loaded from: classes4.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // kotlin.u.a
    public Random e() {
        Random random = this.f16408c.get();
        j.d(random, "implStorage.get()");
        return random;
    }
}
