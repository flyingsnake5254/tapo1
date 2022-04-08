package kotlinx.coroutines.internal;

import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemProps.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class v {
    private static final int a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return a;
    }

    public static final String b(String propertyName) {
        j.f(propertyName, "propertyName");
        try {
            return System.getProperty(propertyName);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
