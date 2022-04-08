package com.tplink.iot.e.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import java.util.Arrays;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;

/* compiled from: TimeAxisUtils.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    public final int a(int i, Context context) {
        j.e(context, "context");
        Resources resources = context.getResources();
        j.d(resources, "context\n                .resources");
        return (int) TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }

    public final String b(int i) {
        p pVar = p.a;
        String format = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 60)}, 1));
        j.d(format, "java.lang.String.format(format, *args)");
        String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i % 60)}, 1));
        j.d(format2, "java.lang.String.format(format, *args)");
        return format + ':' + format2;
    }
}
