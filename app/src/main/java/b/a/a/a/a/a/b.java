package b.a.a.a.a.a;

import android.net.NetworkInfo;
import io.reactivex.g0.l;

/* compiled from: ConnectivityPredicate.java */
/* loaded from: classes.dex */
public class b {

    /* compiled from: ConnectivityPredicate.java */
    /* loaded from: classes.dex */
    class a implements l<a> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NetworkInfo.State[] f10c;

        a(NetworkInfo.State[] stateArr) {
            this.f10c = stateArr;
        }

        /* renamed from: a */
        public boolean test(a aVar) throws Exception {
            for (NetworkInfo.State state : this.f10c) {
                if (aVar.h() == state) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: ConnectivityPredicate.java */
    /* renamed from: b.a.a.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0007b implements l<a> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int[] f11c;

        C0007b(int[] iArr) {
            this.f11c = iArr;
        }

        /* renamed from: a */
        public boolean test(a aVar) throws Exception {
            for (int i : this.f11c) {
                if (aVar.i() == i) {
                    return true;
                }
            }
            return false;
        }
    }

    protected static int[] a(int[] iArr) {
        int[] iArr2 = new int[iArr.length + 1];
        int i = 0;
        for (int i2 : iArr) {
            iArr2[i] = i2;
            i++;
        }
        iArr2[i] = -1;
        return iArr2;
    }

    public static l<a> b(NetworkInfo.State... stateArr) {
        return new a(stateArr);
    }

    public static l<a> c(int... iArr) {
        return new C0007b(a(iArr));
    }
}
