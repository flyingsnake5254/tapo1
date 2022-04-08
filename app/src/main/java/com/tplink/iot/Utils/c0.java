package com.tplink.iot.Utils;

import android.content.Context;
import com.tplink.iot.R;
import com.tplink.libtpmediastatistics.SSLClient;
import java.text.DateFormatSymbols;
import java.util.Locale;

/* compiled from: ScheduleUtils.java */
/* loaded from: classes2.dex */
public class c0 {
    public static String a(Context context, int i) {
        return b(context, i, false);
    }

    public static String b(Context context, int i, boolean z) {
        if (i == 0) {
            if (z) {
                return context.getString(R.string.schedule_invalid);
            }
            return context.getString(R.string.plug_schedule_one_time);
        } else if (i == 127) {
            return context.getString(R.string.schedule_every_day);
        } else {
            if (i == 62) {
                return context.getString(R.string.schedule_every_weekday);
            }
            if (i == 65) {
                return context.getString(R.string.schedule_every_weekend);
            }
            StringBuilder sb = new StringBuilder();
            String[] shortWeekdays = DateFormatSymbols.getInstance(Locale.getDefault()).getShortWeekdays();
            int i2 = 1;
            for (int i3 = 1; i3 < shortWeekdays.length; i3++) {
                if ((i & i2) == i2) {
                    sb.append(shortWeekdays[i3]);
                    sb.append(SSLClient.WHITE_SPACE);
                }
                i2 <<= 1;
            }
            return sb.toString();
        }
    }
}
