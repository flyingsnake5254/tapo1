package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.j;

/* compiled from: Exceptions.kt */
/* loaded from: classes4.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        j.d(sb2, "sb.toString()");
        return sb2;
    }
}