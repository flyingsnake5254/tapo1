package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzal {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, int i2, int i3) {
        return (i & (~i3)) | (i2 & i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            StringBuilder sb = new StringBuilder(52);
            sb.append("must be power of 2 between 2^1 and 2^30: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i <= 256) {
            return new byte[i];
        } else {
            if (i <= 65536) {
                return new short[i];
            }
            return new int[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & 255;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i] & 65535;
        }
        return ((int[]) obj)[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        r9 = r6 & r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r5 != (-1)) goto L_0x0033;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        zza(r12, r1, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        r13[r5] = zza(r13[r5], r9, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zza(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r9, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r10, int r11, java.lang.Object r12, int[] r13, java.lang.Object[] r14, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object[] r15) {
        /*
            int r0 = com.google.android.gms.internal.mlkit_vision_barcode.zzak.zza(r9)
            r1 = r0 & r11
            int r2 = zza(r12, r1)
            r3 = -1
            if (r2 != 0) goto L_0x000e
            return r3
        L_0x000e:
            int r4 = ~r11
            r0 = r0 & r4
            r5 = -1
        L_0x0011:
            int r2 = r2 + (-1)
            r6 = r13[r2]
            r7 = r6 & r4
            if (r7 != r0) goto L_0x003c
            r7 = r14[r2]
            boolean r7 = com.google.android.gms.internal.mlkit_vision_barcode.zze.zza(r9, r7)
            if (r7 == 0) goto L_0x003c
            if (r15 == 0) goto L_0x002b
            r7 = r15[r2]
            boolean r7 = com.google.android.gms.internal.mlkit_vision_barcode.zze.zza(r10, r7)
            if (r7 == 0) goto L_0x003c
        L_0x002b:
            r9 = r6 & r11
            if (r5 != r3) goto L_0x0033
            zza(r12, r1, r9)
            goto L_0x003b
        L_0x0033:
            r10 = r13[r5]
            int r9 = zza(r10, r9, r11)
            r13[r5] = r9
        L_0x003b:
            return r2
        L_0x003c:
            r5 = r6 & r11
            if (r5 != 0) goto L_0x0041
            return r3
        L_0x0041:
            r8 = r5
            r5 = r2
            r2 = r8
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzal.zza(java.lang.Object, java.lang.Object, int, java.lang.Object, int[], java.lang.Object[], java.lang.Object[]):int");
    }
}
