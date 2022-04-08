package com.tplink.iot.Utils.a1;

import android.app.AppOpsManager;
import android.app.AsyncNotedAppOp;
import android.app.SyncNotedAppOp;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.j;
import kotlin.text.o;

/* compiled from: AndroidRCompatUtils.kt */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: AndroidRCompatUtils.kt */
    /* renamed from: com.tplink.iot.Utils.a1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class AppOpsManager$OnOpNotedCallbackC0189a extends AppOpsManager.OnOpNotedCallback {
        private final String a = "AuditDataAccess";

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f5290b;

        AppOpsManager$OnOpNotedCallbackC0189a(boolean z) {
            this.f5290b = z;
        }

        private final void a(String str, String str2, Throwable th) {
            String f2;
            String f3;
            if (this.f5290b) {
                f3 = o.f("\n                    Private data accessed.\n                    Operation: " + str + "\n                    Attribution Tag: " + str2 + "\n                    Stack Trace\n                ");
                b.d.w.c.a.f(this.a, th, f3, new Object[0]);
                return;
            }
            f2 = o.f("\n                    Private data accessed.\n                    Operation: " + str + "\n                    Attribution Tag: " + str2 + "\n                ");
            b.d.w.c.a.e(this.a, f2);
        }

        @Override // android.app.AppOpsManager.OnOpNotedCallback
        public void onAsyncNoted(AsyncNotedAppOp asyncOp) {
            j.e(asyncOp, "asyncOp");
            String op = asyncOp.getOp();
            j.d(op, "asyncOp.op");
            a(op, asyncOp.getAttributionTag(), new Throwable());
        }

        @Override // android.app.AppOpsManager.OnOpNotedCallback
        public void onNoted(SyncNotedAppOp op) {
            j.e(op, "op");
            String op2 = op.getOp();
            j.d(op2, "op.op");
            a(op2, op.getAttributionTag(), new Throwable());
        }

        @Override // android.app.AppOpsManager.OnOpNotedCallback
        public void onSelfNoted(SyncNotedAppOp op) {
            j.e(op, "op");
            String op2 = op.getOp();
            j.d(op2, "op.op");
            a(op2, op.getAttributionTag(), new Throwable());
        }
    }

    public static final boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static final boolean b() {
        return a();
    }

    public static final void c(Context context, boolean z) {
        j.e(context, "context");
        if (b() && Build.VERSION.SDK_INT >= 28) {
            d(context, z);
        }
    }

    @RequiresApi(api = 30)
    private static final void d(Context context, boolean z) {
        AppOpsManager$OnOpNotedCallbackC0189a aVar = new AppOpsManager$OnOpNotedCallbackC0189a(z);
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        if (appOpsManager != null) {
            appOpsManager.setOnOpNotedCallback(context.getMainExecutor(), aVar);
        }
    }
}
