package com.tplink.iab;

import com.tplink.iab.beans.Period;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public class b {
    private static final Pattern a = Pattern.compile("P(?:([0-9]+)Y)?(?:([0-9]+)M)?(?:([0-9]+)W)?(?:([0-9]+)D)?", 2);

    /* renamed from: b  reason: collision with root package name */
    private static final DecimalFormat f5253b = new DecimalFormat("0.00");

    public static double a(double d2) {
        return Math.round(d2 * 100.0d) / 100.0d;
    }

    public static int b(String str) {
        if (str == null) {
            return 1;
        }
        if (!str.equals(Period.P3M)) {
            return !str.equals(Period.P6M) ? 1 : 6;
        }
        return 3;
    }

    public static int c(String str) {
        if (str == null) {
            return 2;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 78476:
                if (str.equals(Period.P1M)) {
                    c2 = 0;
                    break;
                }
                break;
            case 78486:
                if (str.equals(Period.P1W)) {
                    c2 = 1;
                    break;
                }
                break;
            case 78538:
                if (str.equals(Period.P3M)) {
                    c2 = 2;
                    break;
                }
                break;
            case 78631:
                if (str.equals(Period.P6M)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 2:
            case 3:
                return 2;
            case 1:
                return 5;
            default:
                return 3;
        }
    }
}
