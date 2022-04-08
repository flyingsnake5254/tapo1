package org.apache.commons.lang;

/* compiled from: Validate.java */
/* loaded from: classes4.dex */
public class g {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("The validated expression is false");
        }
    }

    public static void b(boolean z, String str, long j) {
        if (!z) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(j);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }
}
