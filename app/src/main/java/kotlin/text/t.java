package kotlin.text;

import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: classes4.dex */
public class t extends s {
    public static Double i(String toDoubleOrNull) {
        j.e(toDoubleOrNull, "$this$toDoubleOrNull");
        try {
            if (l.a.matches(toDoubleOrNull)) {
                return Double.valueOf(Double.parseDouble(toDoubleOrNull));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float j(String toFloatOrNull) {
        j.e(toFloatOrNull, "$this$toFloatOrNull");
        try {
            if (l.a.matches(toFloatOrNull)) {
                return Float.valueOf(Float.parseFloat(toFloatOrNull));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
