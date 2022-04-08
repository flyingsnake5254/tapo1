package com.google.android.exoplayer2.text.s;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.base.c;
import com.google.common.collect.ImmutableSet;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.util.regex.Pattern;

/* compiled from: TextEmphasis.java */
/* loaded from: classes.dex */
final class b {
    private static final Pattern a = Pattern.compile("\\s+");

    /* renamed from: b  reason: collision with root package name */
    private static final ImmutableSet<String> f3542b = ImmutableSet.of(ThingModelDefine.Property.PROPERTY_AUTO, "none");

    /* renamed from: c  reason: collision with root package name */
    private static final ImmutableSet<String> f3543c = ImmutableSet.of("dot", "sesame", "circle");

    /* renamed from: d  reason: collision with root package name */
    private static final ImmutableSet<String> f3544d = ImmutableSet.of("filled", "open");

    /* renamed from: e  reason: collision with root package name */
    private static final ImmutableSet<String> f3545e = ImmutableSet.of("after", "before", "outside");

    /* renamed from: f  reason: collision with root package name */
    public final int f3546f;
    public final int g;
    public final int h;

    private b(int i, int i2, int i3) {
        this.f3546f = i;
        this.g = i2;
        this.h = i3;
    }

    @Nullable
    public static b a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String e2 = c.e(str.trim());
        if (e2.isEmpty()) {
            return null;
        }
        return b(ImmutableSet.copyOf(TextUtils.split(e2, a)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
        if (r9.equals(com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine.Property.PROPERTY_AUTO) != false) goto L_0x0085;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.text.s.b b(com.google.common.collect.ImmutableSet<java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.s.b.b(com.google.common.collect.ImmutableSet):com.google.android.exoplayer2.text.s.b");
    }
}
