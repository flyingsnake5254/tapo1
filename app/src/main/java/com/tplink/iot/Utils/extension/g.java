package com.tplink.iot.Utils.extension;

import android.content.Context;
import com.tplink.iot.Utils.o0;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.j;

/* compiled from: TimeFormatUtils.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final String a(Date formatHourMinute, Context context, TimeZone timeZone, Locale locale) {
        j.e(formatHourMinute, "$this$formatHourMinute");
        j.e(timeZone, "timeZone");
        j.e(locale, "locale");
        return b.c(formatHourMinute, context == null ? false : o0.p(context) ? "H:mm" : "h:mm a", timeZone, locale);
    }

    public static /* synthetic */ String b(Date date, Context context, TimeZone timeZone, Locale locale, int i, Object obj) {
        if ((i & 2) != 0) {
            timeZone = TimeZone.getDefault();
            j.d(timeZone, "TimeZone.getDefault()");
        }
        if ((i & 4) != 0) {
            locale = Locale.getDefault();
            j.d(locale, "Locale.getDefault()");
        }
        return a(date, context, timeZone, locale);
    }

    public static final String c(Date formatMonthDayYear, TimeZone timeZone, Locale locale) {
        j.e(formatMonthDayYear, "$this$formatMonthDayYear");
        j.e(timeZone, "timeZone");
        j.e(locale, "locale");
        return b.c(formatMonthDayYear, "MMM dd, yyyy", timeZone, locale);
    }

    public static /* synthetic */ String d(Date date, TimeZone timeZone, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            timeZone = TimeZone.getDefault();
            j.d(timeZone, "TimeZone.getDefault()");
        }
        if ((i & 2) != 0) {
            locale = Locale.getDefault();
            j.d(locale, "Locale.getDefault()");
        }
        return c(date, timeZone, locale);
    }
}
