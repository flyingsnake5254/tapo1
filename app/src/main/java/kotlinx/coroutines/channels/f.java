package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.u;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public interface f<E> extends v<E>, r<E> {
    public static final a i = a.f16446b;

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ a f16446b = new a();
        private static final int a = u.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private a() {
        }

        public final int a() {
            return a;
        }
    }
}
