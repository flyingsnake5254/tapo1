package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzmo extends zzmq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmo(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzmq
    public final void zza(Object obj, long j, byte b2) {
        if (zzmr.zzb) {
            zzmr.zzD(obj, j, b2);
        } else {
            zzmr.zzE(obj, j, b2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmq
    public final boolean zzb(Object obj, long j) {
        if (zzmr.zzb) {
            return zzmr.zzv(obj, j);
        }
        return zzmr.zzw(obj, j);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.android.gms.internal.measurement.zzmr.zzx(java.lang.Object, long, boolean):void
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.ArrayIndexOutOfBoundsException: arraycopy: length -1 is negative
        	at java.base/java.lang.System.arraycopy(Native Method)
        	at java.base/java.util.ArrayList.shiftTailOverGap(Unknown Source)
        	at java.base/java.util.ArrayList.removeIf(Unknown Source)
        */
    @Override // com.google.android.gms.internal.measurement.zzmq
    public final void zzc(java.lang.Object r2, long r3, boolean r5) {
        /*
            r1 = this;
            boolean r0 = com.google.android.gms.internal.measurement.zzmr.zzb
            if (r0 == 0) goto L_0x0008
            com.google.android.gms.internal.measurement.zzmr.zzx(r2, r3, r5)
            return
        L_0x0008:
            com.google.android.gms.internal.measurement.zzmr.zzy(r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzmo.zzc(java.lang.Object, long, boolean):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzmq
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(zzk(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmq
    public final void zze(Object obj, long j, float f2) {
        zzl(obj, j, Float.floatToIntBits(f2));
    }

    @Override // com.google.android.gms.internal.measurement.zzmq
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(zzm(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmq
    public final void zzg(Object obj, long j, double d2) {
        zzn(obj, j, Double.doubleToLongBits(d2));
    }
}
