package com.google.android.exoplayer2.text.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.common.base.c;
import com.tplink.libtpmediastatistics.SSLClient;

/* compiled from: SsaDialogueFormat.java */
/* loaded from: classes.dex */
final class b {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3519b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3520c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3521d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3522e;

    private b(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.f3519b = i2;
        this.f3520c = i3;
        this.f3521d = i4;
        this.f3522e = i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public static b a(String str) {
        char c2;
        g.a(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), SSLClient.COMMA);
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < split.length; i5++) {
            String e2 = c.e(split[i5].trim());
            e2.hashCode();
            switch (e2.hashCode()) {
                case 100571:
                    if (e2.equals("end")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3556653:
                    if (e2.equals("text")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109757538:
                    if (e2.equals("start")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109780401:
                    if (e2.equals("style")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    i2 = i5;
                    break;
                case 1:
                    i4 = i5;
                    break;
                case 2:
                    i = i5;
                    break;
                case 3:
                    i3 = i5;
                    break;
            }
        }
        if (i == -1 || i2 == -1 || i4 == -1) {
            return null;
        }
        return new b(i, i2, i3, i4, split.length);
    }
}
