package com.tplink.libtpnetwork.Utils;

import com.github.mikephil.charting.utils.Utils;
import kotlin.jvm.internal.j;
import kotlin.text.v;
import kotlin.text.w;

/* compiled from: SdCardUtils.kt */
/* loaded from: classes3.dex */
public final class p {
    private static final String a = "GB";

    /* renamed from: b  reason: collision with root package name */
    private static final String f14085b = "MB";

    /* renamed from: c  reason: collision with root package name */
    private static final String f14086c = "KB";

    /* renamed from: d  reason: collision with root package name */
    private static final String f14087d = "B";

    public static final double a(String space) {
        boolean D;
        boolean D2;
        boolean D3;
        boolean D4;
        String w;
        String w2;
        String w3;
        double parseDouble;
        double d2;
        String w4;
        j.e(space, "space");
        String str = a;
        D = w.D(space, str, false, 2, null);
        if (D) {
            w4 = v.w(space, str, "", false, 4, null);
            parseDouble = Double.parseDouble(w4);
            d2 = 1048576;
        } else {
            String str2 = f14085b;
            D2 = w.D(space, str2, false, 2, null);
            if (D2) {
                w3 = v.w(space, str2, "", false, 4, null);
                parseDouble = Double.parseDouble(w3);
                d2 = 1024;
            } else {
                String str3 = f14086c;
                D3 = w.D(space, str3, false, 2, null);
                if (D3) {
                    w2 = v.w(space, str3, "", false, 4, null);
                    return Double.parseDouble(w2);
                }
                String str4 = f14087d;
                D4 = w.D(space, str4, false, 2, null);
                if (!D4) {
                    return Utils.DOUBLE_EPSILON;
                }
                w = v.w(space, str4, "", false, 4, null);
                return Double.parseDouble(w) / 1024;
            }
        }
        return parseDouble * d2;
    }

    public static final int b(String space1, String space2) {
        j.e(space1, "space1");
        j.e(space2, "space2");
        double a2 = a(space1);
        double a3 = a(space2);
        if (a2 > a3) {
            return 1;
        }
        return a2 == a3 ? 0 : -1;
    }
}
