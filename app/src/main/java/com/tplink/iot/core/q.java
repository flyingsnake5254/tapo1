package com.tplink.iot.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Process;
import android.view.View;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.libtpnetwork.Utils.a0;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* compiled from: TrialIoTEnvironmentUI.java */
/* loaded from: classes2.dex */
public class q {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(int i, TPMaterialDialogV2 tPMaterialDialogV2, View view, View view2) {
        i("dist", i);
        tPMaterialDialogV2.dismiss();
        h(view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(int i, TPMaterialDialogV2 tPMaterialDialogV2, View view, View view2) {
        i("beta", i);
        tPMaterialDialogV2.dismiss();
        h(view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(int i, TPMaterialDialogV2 tPMaterialDialogV2, View view, View view2) {
        i("beta2", i);
        tPMaterialDialogV2.dismiss();
        h(view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(int i, TPMaterialDialogV2 tPMaterialDialogV2, View view, View view2) {
        i("beta3", i);
        tPMaterialDialogV2.dismiss();
        h(view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(int i, TPMaterialDialogV2 tPMaterialDialogV2, View view, View view2) {
        i("dev", i);
        tPMaterialDialogV2.dismiss();
        h(view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(int i, TPMaterialDialogV2 tPMaterialDialogV2, View view, View view2) {
        i("staging", i);
        tPMaterialDialogV2.dismiss();
        h(view.getContext());
    }

    private static void h(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).set(1, System.currentTimeMillis() + 2500, PendingIntent.getActivity(context.getApplicationContext(), 0, context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), Pow2.MAX_POW2));
        Process.killProcess(Process.myPid());
    }

    private static void i(String str, int i) {
        if (i == 0) {
            a0.l(str);
        } else if (1 == i) {
            a0.m(str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f6, code lost:
        if (r12.equals("dev") == false) goto L_0x00c4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j(android.app.Activity r11, final int r12) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.core.q.j(android.app.Activity, int):void");
    }
}
