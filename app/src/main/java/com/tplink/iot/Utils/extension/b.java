package com.tplink.iot.Utils.extension;

import androidx.annotation.StringRes;
import com.tplink.iot.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;

/* compiled from: DateTimeUtils.kt */
/* loaded from: classes2.dex */
public final class b {
    @StringRes
    public static final int a(Integer num) {
        return (num == null || num.intValue() > 1) ? R.string.time_seconds : R.string.time_second;
    }

    public static final String b(Date date, String str, TimeZone timeZone) {
        return d(date, str, timeZone, null, 4, null);
    }

    public static final String c(Date toFormatString, String str, TimeZone timeZone, Locale locale) {
        j.e(toFormatString, "$this$toFormatString");
        j.e(timeZone, "timeZone");
        j.e(locale, "locale");
        if (str == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(toFormatString);
        j.d(format, "dateFormat.format(this)");
        return format;
    }

    public static /* synthetic */ String d(Date date, String str, TimeZone timeZone, Locale locale, int i, Object obj) {
        if ((i & 2) != 0) {
            timeZone = TimeZone.getDefault();
            j.d(timeZone, "TimeZone.getDefault()");
        }
        if ((i & 4) != 0) {
            locale = Locale.getDefault();
            j.d(locale, "Locale.getDefault()");
        }
        return c(date, str, timeZone, locale);
    }

    public static final long e(long j) {
        return TimeUnit.SECONDS.toMillis(j);
    }
}
