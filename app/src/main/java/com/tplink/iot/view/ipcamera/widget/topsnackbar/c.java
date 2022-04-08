package com.tplink.iot.view.ipcamera.widget.topsnackbar;

import android.content.Context;

/* compiled from: ScreenUtil.java */
/* loaded from: classes2.dex */
public class c {
    private static int a = -1;

    /* JADX WARN: Removed duplicated region for block: B:26:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r6) {
        /*
            boolean r0 = r6 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto L_0x001d
            r0 = r6
            androidx.appcompat.app.AppCompatActivity r0 = (androidx.appcompat.app.AppCompatActivity) r0
            androidx.appcompat.app.ActionBar r1 = r0.getSupportActionBar()
            if (r1 == 0) goto L_0x001d
            java.lang.String r1 = "isAppCompatActivity"
            java.lang.String r2 = "==AppCompatActivity"
            b.d.w.c.a.c(r1, r2)
            androidx.appcompat.app.ActionBar r0 = r0.getSupportActionBar()
            int r0 = r0.getHeight()
            goto L_0x008b
        L_0x001d:
            boolean r0 = r6 instanceof android.app.Activity
            if (r0 == 0) goto L_0x003a
            r0 = r6
            android.app.Activity r0 = (android.app.Activity) r0
            android.app.ActionBar r1 = r0.getActionBar()
            if (r1 == 0) goto L_0x003a
            java.lang.String r1 = "isActivity"
            java.lang.String r2 = "==Activity"
            b.d.w.c.a.c(r1, r2)
            android.app.ActionBar r0 = r0.getActionBar()
            int r0 = r0.getHeight()
            goto L_0x008b
        L_0x003a:
            boolean r0 = r6 instanceof android.app.ActivityGroup
            if (r0 == 0) goto L_0x008a
            java.lang.String r0 = "ActivityGroup"
            java.lang.String r1 = "==ActivityGroup"
            b.d.w.c.a.c(r0, r1)
            r0 = r6
            android.app.ActivityGroup r0 = (android.app.ActivityGroup) r0
            android.app.Activity r1 = r0.getCurrentActivity()
            boolean r1 = r1 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L_0x006b
            android.app.Activity r1 = r0.getCurrentActivity()
            androidx.appcompat.app.AppCompatActivity r1 = (androidx.appcompat.app.AppCompatActivity) r1
            androidx.appcompat.app.ActionBar r1 = r1.getSupportActionBar()
            if (r1 == 0) goto L_0x006b
            android.app.Activity r0 = r0.getCurrentActivity()
            androidx.appcompat.app.AppCompatActivity r0 = (androidx.appcompat.app.AppCompatActivity) r0
            androidx.appcompat.app.ActionBar r0 = r0.getSupportActionBar()
            int r0 = r0.getHeight()
            goto L_0x008b
        L_0x006b:
            android.app.Activity r1 = r0.getCurrentActivity()
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 == 0) goto L_0x008a
            android.app.Activity r1 = r0.getCurrentActivity()
            android.app.ActionBar r1 = r1.getActionBar()
            if (r1 == 0) goto L_0x008a
            android.app.Activity r0 = r0.getCurrentActivity()
            android.app.ActionBar r0 = r0.getActionBar()
            int r0 = r0.getHeight()
            goto L_0x008b
        L_0x008a:
            r0 = 0
        L_0x008b:
            if (r0 == 0) goto L_0x008e
            return r0
        L_0x008e:
            android.util.TypedValue r1 = new android.util.TypedValue
            r1.<init>()
            android.content.res.Resources$Theme r2 = r6.getTheme()
            r3 = 2130968589(0x7f04000d, float:1.7545836E38)
            r4 = 1
            boolean r2 = r2.resolveAttribute(r3, r1, r4)
            if (r2 == 0) goto L_0x00ba
            android.content.res.Resources$Theme r2 = r6.getTheme()
            boolean r2 = r2.resolveAttribute(r3, r1, r4)
            if (r2 == 0) goto L_0x00f4
            int r0 = r1.data
            android.content.res.Resources r6 = r6.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r6)
            goto L_0x00f4
        L_0x00ba:
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 11
            if (r2 < r5) goto L_0x00dc
            android.content.res.Resources$Theme r2 = r6.getTheme()
            r3 = 16843499(0x10102eb, float:2.3695652E-38)
            boolean r2 = r2.resolveAttribute(r3, r1, r4)
            if (r2 == 0) goto L_0x00f4
            int r0 = r1.data
            android.content.res.Resources r6 = r6.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r6)
            goto L_0x00f4
        L_0x00dc:
            android.content.res.Resources$Theme r2 = r6.getTheme()
            boolean r2 = r2.resolveAttribute(r3, r1, r4)
            if (r2 == 0) goto L_0x00f4
            int r0 = r1.data
            android.content.res.Resources r6 = r6.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r6)
        L_0x00f4:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "===="
            r6.append(r1)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r1 = "actionBarHeight"
            b.d.w.c.a.c(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.view.ipcamera.widget.topsnackbar.c.a(android.content.Context):int");
    }

    public static int b(Context context) {
        int i = a;
        if (i != -1) {
            return i;
        }
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                a = context.getResources().getDimensionPixelSize(identifier);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return a;
    }
}
