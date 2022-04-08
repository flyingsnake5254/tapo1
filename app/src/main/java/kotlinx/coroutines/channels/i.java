package kotlinx.coroutines.channels;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public final class i {
    public static final <E> f<E> a(int i) {
        if (i == -2) {
            return new d(f.i.a());
        }
        if (i == -1) {
            return new l();
        }
        if (i == 0) {
            return new t();
        }
        if (i != Integer.MAX_VALUE) {
            return new d(i);
        }
        return new m();
    }
}
