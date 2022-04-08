package com.tplink.iot.g.b.c;

import android.text.InputFilter;
import android.text.Spanned;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.util.internal.StringUtil;
import java.util.regex.Pattern;
import kotlin.jvm.internal.j;
import kotlin.text.v;

/* compiled from: DecimalDigitsInputFilter.kt */
/* loaded from: classes2.dex */
public final class a implements InputFilter {

    /* renamed from: c  reason: collision with root package name */
    private final Pattern f7959c;

    public a(int i, int i2) {
        this.f7959c = Pattern.compile("^\\d{0," + i + "}((\\.\\d{0," + i2 + "})|(\\.)?)$");
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String v;
        boolean z = false;
        if (j.a(".", charSequence)) {
            if (spanned == null || spanned.length() == 0) {
                return "0.";
            }
        }
        if (j.a(SSLClient.COMMA, charSequence)) {
            if (spanned == null || spanned.length() == 0) {
                z = true;
            }
            if (z) {
                return "0,";
            }
        }
        if (spanned == null) {
            spanned = "";
        }
        StringBuilder sb = new StringBuilder(spanned);
        if (j.a("", charSequence)) {
            sb.replace(i3, i4, "");
        } else {
            sb.insert(i3, charSequence);
        }
        String sb2 = sb.toString();
        j.d(sb2, "builder.toString()");
        v = v.v(sb2, StringUtil.COMMA, '.', false, 4, null);
        if (!this.f7959c.matcher(v).matches()) {
            return "";
        }
        return null;
    }
}
