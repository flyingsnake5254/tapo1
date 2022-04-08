package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.j;

/* compiled from: String.kt */
/* loaded from: classes.dex */
public final class StringKt {
    public static final String htmlEncode(String htmlEncode) {
        j.f(htmlEncode, "$this$htmlEncode");
        String htmlEncode2 = TextUtils.htmlEncode(htmlEncode);
        j.b(htmlEncode2, "TextUtils.htmlEncode(this)");
        return htmlEncode2;
    }
}
