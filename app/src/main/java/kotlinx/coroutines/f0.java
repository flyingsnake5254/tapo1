package kotlinx.coroutines;

/* loaded from: classes4.dex */
public final /* synthetic */ class f0 {
    public static final /* synthetic */ int[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f16448b;

    static {
        int[] iArr = new int[CoroutineStart.values().length];
        a = iArr;
        CoroutineStart coroutineStart = CoroutineStart.DEFAULT;
        iArr[coroutineStart.ordinal()] = 1;
        CoroutineStart coroutineStart2 = CoroutineStart.ATOMIC;
        iArr[coroutineStart2.ordinal()] = 2;
        CoroutineStart coroutineStart3 = CoroutineStart.UNDISPATCHED;
        iArr[coroutineStart3.ordinal()] = 3;
        CoroutineStart coroutineStart4 = CoroutineStart.LAZY;
        iArr[coroutineStart4.ordinal()] = 4;
        int[] iArr2 = new int[CoroutineStart.values().length];
        f16448b = iArr2;
        iArr2[coroutineStart.ordinal()] = 1;
        iArr2[coroutineStart2.ordinal()] = 2;
        iArr2[coroutineStart3.ordinal()] = 3;
        iArr2[coroutineStart4.ordinal()] = 4;
    }
}
