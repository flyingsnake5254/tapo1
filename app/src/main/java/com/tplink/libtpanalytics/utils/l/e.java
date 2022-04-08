package com.tplink.libtpanalytics.utils.l;

/* compiled from: RsaKeyUtil.java */
/* loaded from: classes3.dex */
public class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.InputStream] */
    /* JADX WARN: Unknown variable types count: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.PrivateKey a(android.content.Context r5, java.lang.String r6) {
        /*
            android.content.res.AssetManager r5 = r5.getAssets()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStream r5 = r5.open(r6)     // Catch: all -> 0x008c, Exception -> 0x008f
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: all -> 0x0087, Exception -> 0x0089
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: all -> 0x0087, Exception -> 0x0089
            r2.<init>(r5)     // Catch: all -> 0x0087, Exception -> 0x0089
            r6.<init>(r2)     // Catch: all -> 0x0087, Exception -> 0x0089
        L_0x0018:
            java.lang.String r2 = r6.readLine()     // Catch: Exception -> 0x0085, all -> 0x00a7
            if (r2 == 0) goto L_0x0027
            r0.append(r2)     // Catch: Exception -> 0x0085, all -> 0x00a7
            r2 = 10
            r0.append(r2)     // Catch: Exception -> 0x0085, all -> 0x00a7
            goto L_0x0018
        L_0x0027:
            org.bouncycastle.openssl.e r2 = new org.bouncycastle.openssl.e     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.io.StringReader r3 = new java.io.StringReader     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.lang.String r4 = r0.toString()     // Catch: Exception -> 0x0085, all -> 0x00a7
            r3.<init>(r4)     // Catch: Exception -> 0x0085, all -> 0x00a7
            r2.<init>(r3)     // Catch: Exception -> 0x0085, all -> 0x00a7
            org.bouncycastle.openssl.e r3 = new org.bouncycastle.openssl.e     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.io.StringReader r4 = new java.io.StringReader     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.lang.String r0 = r0.toString()     // Catch: Exception -> 0x0085, all -> 0x00a7
            r4.<init>(r0)     // Catch: Exception -> 0x0085, all -> 0x00a7
            r3.<init>(r4)     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.lang.Object r0 = r2.readObject()     // Catch: Exception -> 0x0060, all -> 0x00a7
            org.bouncycastle.asn1.n2.h r0 = (org.bouncycastle.asn1.n2.h) r0     // Catch: Exception -> 0x0060, all -> 0x00a7
            org.bouncycastle.openssl.g.a r2 = new org.bouncycastle.openssl.g.a     // Catch: Exception -> 0x0060, all -> 0x00a7
            r2.<init>()     // Catch: Exception -> 0x0060, all -> 0x00a7
            java.security.PrivateKey r0 = r2.c(r0)     // Catch: Exception -> 0x0060, all -> 0x00a7
            r6.close()     // Catch: IOException -> 0x005b
            if (r5 == 0) goto L_0x005f
            r5.close()     // Catch: IOException -> 0x005b
            goto L_0x005f
        L_0x005b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005f:
            return r0
        L_0x0060:
            r0 = move-exception
            r0.printStackTrace()     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.lang.Object r0 = r3.readObject()     // Catch: Exception -> 0x0085, all -> 0x00a7
            org.bouncycastle.openssl.c r0 = (org.bouncycastle.openssl.c) r0     // Catch: Exception -> 0x0085, all -> 0x00a7
            org.bouncycastle.openssl.g.a r2 = new org.bouncycastle.openssl.g.a     // Catch: Exception -> 0x0085, all -> 0x00a7
            r2.<init>()     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.security.KeyPair r0 = r2.b(r0)     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.security.PrivateKey r0 = r0.getPrivate()     // Catch: Exception -> 0x0085, all -> 0x00a7
            r6.close()     // Catch: IOException -> 0x0080
            if (r5 == 0) goto L_0x0084
            r5.close()     // Catch: IOException -> 0x0080
            goto L_0x0084
        L_0x0080:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0084:
            return r0
        L_0x0085:
            r0 = move-exception
            goto L_0x0092
        L_0x0087:
            r0 = move-exception
            goto L_0x00a9
        L_0x0089:
            r0 = move-exception
            r6 = r1
            goto L_0x0092
        L_0x008c:
            r0 = move-exception
            r5 = r1
            goto L_0x00a9
        L_0x008f:
            r0 = move-exception
            r5 = r1
            r6 = r5
        L_0x0092:
            r0.printStackTrace()     // Catch: all -> 0x00a7
            if (r6 == 0) goto L_0x009d
            r6.close()     // Catch: IOException -> 0x009b
            goto L_0x009d
        L_0x009b:
            r5 = move-exception
            goto L_0x00a3
        L_0x009d:
            if (r5 == 0) goto L_0x00a6
            r5.close()     // Catch: IOException -> 0x009b
            goto L_0x00a6
        L_0x00a3:
            r5.printStackTrace()
        L_0x00a6:
            return r1
        L_0x00a7:
            r0 = move-exception
            r1 = r6
        L_0x00a9:
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch: IOException -> 0x00af
            goto L_0x00b1
        L_0x00af:
            r5 = move-exception
            goto L_0x00b7
        L_0x00b1:
            if (r5 == 0) goto L_0x00ba
            r5.close()     // Catch: IOException -> 0x00af
            goto L_0x00ba
        L_0x00b7:
            r5.printStackTrace()
        L_0x00ba:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpanalytics.utils.l.e.a(android.content.Context, java.lang.String):java.security.PrivateKey");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.InputStream] */
    /* JADX WARN: Unknown variable types count: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.PublicKey b(android.content.Context r5, java.lang.String r6) {
        /*
            android.content.res.AssetManager r5 = r5.getAssets()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStream r5 = r5.open(r6)     // Catch: all -> 0x008c, Exception -> 0x008f
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: all -> 0x0087, Exception -> 0x0089
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: all -> 0x0087, Exception -> 0x0089
            r2.<init>(r5)     // Catch: all -> 0x0087, Exception -> 0x0089
            r6.<init>(r2)     // Catch: all -> 0x0087, Exception -> 0x0089
        L_0x0018:
            java.lang.String r2 = r6.readLine()     // Catch: Exception -> 0x0085, all -> 0x00a7
            if (r2 == 0) goto L_0x0027
            r0.append(r2)     // Catch: Exception -> 0x0085, all -> 0x00a7
            r2 = 10
            r0.append(r2)     // Catch: Exception -> 0x0085, all -> 0x00a7
            goto L_0x0018
        L_0x0027:
            org.bouncycastle.openssl.e r2 = new org.bouncycastle.openssl.e     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.io.StringReader r3 = new java.io.StringReader     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.lang.String r4 = r0.toString()     // Catch: Exception -> 0x0085, all -> 0x00a7
            r3.<init>(r4)     // Catch: Exception -> 0x0085, all -> 0x00a7
            r2.<init>(r3)     // Catch: Exception -> 0x0085, all -> 0x00a7
            org.bouncycastle.openssl.e r3 = new org.bouncycastle.openssl.e     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.io.StringReader r4 = new java.io.StringReader     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.lang.String r0 = r0.toString()     // Catch: Exception -> 0x0085, all -> 0x00a7
            r4.<init>(r0)     // Catch: Exception -> 0x0085, all -> 0x00a7
            r3.<init>(r4)     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.lang.Object r0 = r2.readObject()     // Catch: Exception -> 0x0060, all -> 0x00a7
            org.bouncycastle.asn1.x509.w r0 = (org.bouncycastle.asn1.x509.w) r0     // Catch: Exception -> 0x0060, all -> 0x00a7
            org.bouncycastle.openssl.g.a r2 = new org.bouncycastle.openssl.g.a     // Catch: Exception -> 0x0060, all -> 0x00a7
            r2.<init>()     // Catch: Exception -> 0x0060, all -> 0x00a7
            java.security.PublicKey r0 = r2.d(r0)     // Catch: Exception -> 0x0060, all -> 0x00a7
            r6.close()     // Catch: IOException -> 0x005b
            if (r5 == 0) goto L_0x005f
            r5.close()     // Catch: IOException -> 0x005b
            goto L_0x005f
        L_0x005b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005f:
            return r0
        L_0x0060:
            r0 = move-exception
            r0.printStackTrace()     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.lang.Object r0 = r3.readObject()     // Catch: Exception -> 0x0085, all -> 0x00a7
            org.bouncycastle.openssl.c r0 = (org.bouncycastle.openssl.c) r0     // Catch: Exception -> 0x0085, all -> 0x00a7
            org.bouncycastle.openssl.g.a r2 = new org.bouncycastle.openssl.g.a     // Catch: Exception -> 0x0085, all -> 0x00a7
            r2.<init>()     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.security.KeyPair r0 = r2.b(r0)     // Catch: Exception -> 0x0085, all -> 0x00a7
            java.security.PublicKey r0 = r0.getPublic()     // Catch: Exception -> 0x0085, all -> 0x00a7
            r6.close()     // Catch: IOException -> 0x0080
            if (r5 == 0) goto L_0x0084
            r5.close()     // Catch: IOException -> 0x0080
            goto L_0x0084
        L_0x0080:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0084:
            return r0
        L_0x0085:
            r0 = move-exception
            goto L_0x0092
        L_0x0087:
            r0 = move-exception
            goto L_0x00a9
        L_0x0089:
            r0 = move-exception
            r6 = r1
            goto L_0x0092
        L_0x008c:
            r0 = move-exception
            r5 = r1
            goto L_0x00a9
        L_0x008f:
            r0 = move-exception
            r5 = r1
            r6 = r5
        L_0x0092:
            r0.printStackTrace()     // Catch: all -> 0x00a7
            if (r6 == 0) goto L_0x009d
            r6.close()     // Catch: IOException -> 0x009b
            goto L_0x009d
        L_0x009b:
            r5 = move-exception
            goto L_0x00a3
        L_0x009d:
            if (r5 == 0) goto L_0x00a6
            r5.close()     // Catch: IOException -> 0x009b
            goto L_0x00a6
        L_0x00a3:
            r5.printStackTrace()
        L_0x00a6:
            return r1
        L_0x00a7:
            r0 = move-exception
            r1 = r6
        L_0x00a9:
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch: IOException -> 0x00af
            goto L_0x00b1
        L_0x00af:
            r5 = move-exception
            goto L_0x00b7
        L_0x00b1:
            if (r5 == 0) goto L_0x00ba
            r5.close()     // Catch: IOException -> 0x00af
            goto L_0x00ba
        L_0x00b7:
            r5.printStackTrace()
        L_0x00ba:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpanalytics.utils.l.e.b(android.content.Context, java.lang.String):java.security.PublicKey");
    }
}
