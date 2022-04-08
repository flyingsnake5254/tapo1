package b.d.y;

import com.tplink.libtpdemux.tsdemux.common.EnumESType;

/* loaded from: classes3.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[EnumESType.values().length];
        a = iArr;
        iArr[EnumESType.TS_ES_TYPE_AUDIO.ordinal()] = 1;
        iArr[EnumESType.TS_ES_TYPE_VIDEO.ordinal()] = 2;
    }
}
