package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import kotlin.jvm.internal.j;

/* compiled from: Locale.kt */
/* loaded from: classes.dex */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(Locale layoutDirection) {
        j.f(layoutDirection, "$this$layoutDirection");
        return TextUtils.getLayoutDirectionFromLocale(layoutDirection);
    }
}
