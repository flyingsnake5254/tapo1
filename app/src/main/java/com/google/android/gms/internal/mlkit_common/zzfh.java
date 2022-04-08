package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public class zzfh extends IOException {
    private zzgh zza = null;

    public zzfh(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfk zza() {
        return new zzfk("Protocol message tag had invalid wire type.");
    }
}
