package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.common.base.c;

/* compiled from: HttpDataSource.java */
/* loaded from: classes.dex */
public final /* synthetic */ class u {
    public static /* synthetic */ boolean a(String str) {
        if (str == null) {
            return false;
        }
        String e2 = c.e(str);
        if (!TextUtils.isEmpty(e2)) {
            return (!e2.contains("text") || e2.contains("text/vtt")) && !e2.contains("html") && !e2.contains("xml");
        }
        return false;
    }
}
