package com.google.android.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.p.b;
import com.google.android.exoplayer2.util.g;
import com.google.common.base.o;

/* compiled from: SubtitleViewUtils.java */
/* loaded from: classes.dex */
final class x0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(Object obj) {
        return !(obj instanceof b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean b(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void c(c.b bVar) {
        bVar.b();
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            e((Spannable) g.e(bVar.e()), b0.f3732c);
        }
        d(bVar);
    }

    public static void d(c.b bVar) {
        bVar.q(-3.4028235E38f, Integer.MIN_VALUE);
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            e((Spannable) g.e(bVar.e()), c0.f3734c);
        }
    }

    private static void e(Spannable spannable, o<Object> oVar) {
        Object[] spans;
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (oVar.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float f(int i, float f2, int i2, int i3) {
        float f3;
        if (f2 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f3 = i3;
        } else if (i == 1) {
            f3 = i2;
        } else if (i != 2) {
            return -3.4028235E38f;
        } else {
            return f2;
        }
        return f2 * f3;
    }
}
