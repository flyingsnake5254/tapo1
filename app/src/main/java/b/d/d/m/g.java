package b.d.d.m;

import b.d.d.j.b;

/* compiled from: NetworkMediaUtils.java */
/* loaded from: classes3.dex */
public class g {
    public static String a() {
        return b(b.a);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r3.contains("LTE") != false) goto L_0x005a;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(android.content.Context r5) {
        /*
            java.lang.String r0 = "other"
            if (r5 != 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.String r1 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r1)
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5
            android.net.NetworkInfo r5 = r5.getActiveNetworkInfo()
            java.lang.String r1 = "4G"
            java.lang.String r2 = "3G"
            if (r5 == 0) goto L_0x0058
            int r3 = r5.getType()
            r4 = 1
            if (r3 != r4) goto L_0x0021
            java.lang.String r1 = "wifi"
            goto L_0x005a
        L_0x0021:
            int r3 = r5.getType()
            if (r3 != 0) goto L_0x0058
            java.lang.String r3 = r5.getSubtypeName()
            int r5 = r5.getSubtype()
            switch(r5) {
                case 1: goto L_0x004c;
                case 2: goto L_0x004c;
                case 3: goto L_0x004a;
                case 4: goto L_0x004c;
                case 5: goto L_0x004a;
                case 6: goto L_0x004a;
                case 7: goto L_0x004c;
                case 8: goto L_0x004a;
                case 9: goto L_0x004a;
                case 10: goto L_0x004a;
                case 11: goto L_0x004c;
                case 12: goto L_0x004a;
                case 13: goto L_0x005a;
                case 14: goto L_0x004a;
                case 15: goto L_0x004a;
                default: goto L_0x0032;
            }
        L_0x0032:
            java.lang.String r5 = "TD-SCDMA"
            boolean r5 = r3.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x004a
            java.lang.String r5 = "WCDMA"
            boolean r5 = r3.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x004a
            java.lang.String r5 = "CDMA2000"
            boolean r5 = r3.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x004f
        L_0x004a:
            r1 = r2
            goto L_0x005a
        L_0x004c:
            java.lang.String r1 = "2G"
            goto L_0x005a
        L_0x004f:
            java.lang.String r5 = "LTE"
            boolean r5 = r3.contains(r5)
            if (r5 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            java.lang.String r1 = ""
        L_0x005a:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 == 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r0 = r1
        L_0x0062:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.d.m.g.b(android.content.Context):java.lang.String");
    }
}
