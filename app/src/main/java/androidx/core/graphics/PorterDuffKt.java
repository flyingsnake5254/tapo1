package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import kotlin.jvm.internal.j;

/* compiled from: PorterDuff.kt */
/* loaded from: classes.dex */
public final class PorterDuffKt {
    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode toColorFilter, int i) {
        j.f(toColorFilter, "$this$toColorFilter");
        return new PorterDuffColorFilter(i, toColorFilter);
    }

    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode toXfermode) {
        j.f(toXfermode, "$this$toXfermode");
        return new PorterDuffXfermode(toXfermode);
    }
}
