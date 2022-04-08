package com.google.android.gms.internal.mlkit_vision_barcode;

import io.netty.util.internal.StringUtil;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzhp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzhk zzhkVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzhkVar, sb, 0);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e5, code lost:
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L_0x01e7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e7, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01f8, code lost:
        if (((java.lang.Integer) r6).intValue() == 0) goto L_0x01e7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0209, code lost:
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L_0x01e7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x021b, code lost:
        if (((java.lang.Double) r6).doubleValue() == com.github.mikephil.charting.utils.Utils.DOUBLE_EPSILON) goto L_0x01e7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.mlkit_vision_barcode.zzhk r13, java.lang.StringBuilder r14, int r15) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzhp.zza(com.google.android.gms.internal.mlkit_vision_barcode.zzhk, java.lang.StringBuilder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zza(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zza(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzip.zza(zzew.zza((String) obj)));
                sb.append(StringUtil.DOUBLE_QUOTE);
            } else if (obj instanceof zzew) {
                sb.append(": \"");
                sb.append(zzip.zza((zzew) obj));
                sb.append(StringUtil.DOUBLE_QUOTE);
            } else if (obj instanceof zzga) {
                sb.append(" {");
                zza((zzga) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                zza(sb, i4, "key", entry2.getKey());
                zza(sb, i4, "value", entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static final String zza(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
