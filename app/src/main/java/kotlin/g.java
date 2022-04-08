package kotlin;

/* loaded from: classes4.dex */
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[LazyThreadSafetyMode.values().length];
        a = iArr;
        iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
        iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
        iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
    }
}
