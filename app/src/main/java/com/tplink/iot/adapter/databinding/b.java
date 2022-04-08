package com.tplink.iot.adapter.databinding;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import kotlin.jvm.internal.j;

/* compiled from: BlankAndDividerDecoration.kt */
/* loaded from: classes2.dex */
public final class b {
    @TargetApi(17)
    public static final boolean a(Context context) {
        j.e(context, "context");
        Resources resources = context.getResources();
        j.d(resources, "context.resources");
        Configuration configuration = resources.getConfiguration();
        j.d(configuration, "context.resources.configuration");
        return configuration.getLayoutDirection() == 1;
    }
}
