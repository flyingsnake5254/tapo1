package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.j;

/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(Size component1) {
        j.f(component1, "$this$component1");
        return component1.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(Size component2) {
        j.f(component2, "$this$component2");
        return component2.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(SizeF component1) {
        j.f(component1, "$this$component1");
        return component1.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF component2) {
        j.f(component2, "$this$component2");
        return component2.getHeight();
    }
}
