package kotlinx.coroutines.channels;

/* compiled from: LinkedListChannel.kt */
/* loaded from: classes4.dex */
public class m<E> extends a<E> {
    @Override // kotlinx.coroutines.channels.a
    protected final boolean K() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean L() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean s() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    public Object v(E e2) {
        s<?> x;
        do {
            Object v = super.v(e2);
            Object obj = b.a;
            if (v == obj) {
                return obj;
            }
            if (v == b.f16436b) {
                x = x(e2);
                if (x == null) {
                    return obj;
                }
            } else if (v instanceof k) {
                return v;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + v).toString());
            }
        } while (!(x instanceof k));
        return x;
    }
}
