package kotlin.text;

import kotlin.v.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharJVM.kt */
/* loaded from: classes4.dex */
public class b {
    public static int a(int i) {
        if (2 <= i && 36 >= i) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new d(2, 36));
    }

    public static final int b(char c2, int i) {
        return Character.digit((int) c2, i);
    }

    public static final boolean c(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }
}
