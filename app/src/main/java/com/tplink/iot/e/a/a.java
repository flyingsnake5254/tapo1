package com.tplink.iot.e.a;

import android.app.Activity;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.network.bean.common.Summary;
import com.tplink.iot.dailysummary.network.bean.result.SummaryResult;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import java.util.ArrayList;
import kotlin.collections.n;
import kotlin.jvm.internal.j;

/* compiled from: MethodUtil.kt */
/* loaded from: classes2.dex */
public final class a {
    private static final ArrayList<String> a;

    static {
        ArrayList<String> c2;
        c2 = n.c("", "JAN", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec");
        a = c2;
    }

    public static final d a(String dateStr) {
        j.e(dateStr, "dateStr");
        if (dateStr.length() >= 10) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 <= 3; i3++) {
                i2 = (i2 * 10) + (dateStr.charAt(i3) - '0');
            }
            int i4 = 0;
            for (int i5 = 5; i5 <= 6; i5++) {
                i4 = (i4 * 10) + (dateStr.charAt(i5) - '0');
            }
            for (int i6 = 8; i6 <= 9; i6++) {
                i = (i * 10) + (dateStr.charAt(i6) - '0');
            }
            return new d(i2, i4, i);
        }
        throw new RuntimeException("datestrToOnedayinfo Exception: dateStr.length < 10");
    }

    public static final ArrayList<String> b() {
        return a;
    }

    public static final void c(Activity activity, String msg, boolean z) {
        j.e(activity, "activity");
        j.e(msg, "msg");
        TSnackbar.A(TSnackbar.r(activity), msg, z ? 0 : -1).N();
    }

    public static /* synthetic */ void d(Activity activity, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        c(activity, str, z);
    }

    public static final b e(SummaryResult result) {
        j.e(result, "result");
        if (result.getSummaryList().size() <= 0) {
            return null;
        }
        Summary summary = result.getSummaryList().get(0);
        j.d(summary, "result.summaryList[0]");
        if (summary.getStatus() == -6) {
            return null;
        }
        Summary resultData = result.getSummaryList().get(0);
        String date = result.getDate();
        j.d(date, "result.date");
        j.d(resultData, "resultData");
        return new b(date, resultData.getStatus(), resultData.getUuid(), resultData.getImage(), resultData.getClipSize(), false, false, 96, null);
    }
}
