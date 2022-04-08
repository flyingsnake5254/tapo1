package com.tplink.iot.Utils.extension;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.s0;
import kotlin.jvm.b.a;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: DialogUtils.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final void a() {
        s0.g();
    }

    public static final void b(DialogFragment makeFullscreen, boolean z, boolean z2, boolean z3) {
        Window window;
        j.e(makeFullscreen, "$this$makeFullscreen");
        Dialog dialog = makeFullscreen.getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            View decorView = window.getDecorView();
            j.d(decorView, "decorView");
            decorView.setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            if (z3) {
                window.clearFlags(2);
            }
            if (z) {
                attributes.width = -1;
            }
            if (z2) {
                attributes.height = -1;
            }
            p pVar = p.a;
            window.setAttributes(attributes);
        }
    }

    public static /* synthetic */ void c(DialogFragment dialogFragment, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        b(dialogFragment, z, z2, z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.tplink.iot.Utils.extension.d] */
    public static final void d(Activity showCommonFailDialog, a<p> aVar) {
        j.e(showCommonFailDialog, "$this$showCommonFailDialog");
        if (aVar != null) {
            aVar = new d(aVar);
        }
        s0.o(showCommonFailDialog, R.string.common_operation_failed, (s0.h) aVar);
    }

    public static /* synthetic */ void e(Activity activity, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = null;
        }
        d(activity, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.tplink.iot.Utils.extension.d] */
    public static final void f(Activity showCommonSuccessDialog, a<p> aVar) {
        j.e(showCommonSuccessDialog, "$this$showCommonSuccessDialog");
        if (aVar != null) {
            aVar = new d(aVar);
        }
        s0.B(showCommonSuccessDialog, (s0.h) aVar);
    }

    public static /* synthetic */ void g(Activity activity, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = null;
        }
        f(activity, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.tplink.iot.Utils.extension.d] */
    public static final void h(Activity showFailDialog, @StringRes int i, a<p> aVar) {
        j.e(showFailDialog, "$this$showFailDialog");
        if (aVar != null) {
            aVar = new d(aVar);
        }
        s0.o(showFailDialog, i, (s0.h) aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.tplink.iot.Utils.extension.d] */
    public static final void i(Activity showFailDialog, String str, a<p> aVar) {
        j.e(showFailDialog, "$this$showFailDialog");
        if (aVar != null) {
            aVar = new d(aVar);
        }
        s0.q(showFailDialog, str, (s0.h) aVar);
    }

    public static /* synthetic */ void j(Activity activity, int i, a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        h(activity, i, aVar);
    }

    public static /* synthetic */ void k(Activity activity, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            aVar = null;
        }
        i(activity, str, aVar);
    }

    public static final void l(Activity showLoadingDialog, String str) {
        j.e(showLoadingDialog, "$this$showLoadingDialog");
        if (str != null) {
            s0.m(showLoadingDialog, str);
        } else {
            s0.l(showLoadingDialog);
        }
    }

    public static /* synthetic */ void m(Activity activity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        l(activity, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.tplink.iot.Utils.extension.d] */
    public static final void n(Activity showMessageDialog, String str, a<p> aVar) {
        j.e(showMessageDialog, "$this$showMessageDialog");
        if (aVar != null) {
            aVar = new d(aVar);
        }
        s0.w(showMessageDialog, str, (s0.h) aVar);
    }

    public static /* synthetic */ void o(Activity activity, String str, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            aVar = null;
        }
        n(activity, str, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.tplink.iot.Utils.extension.d] */
    public static final void p(Activity showOperationFailDialog, a<p> aVar) {
        j.e(showOperationFailDialog, "$this$showOperationFailDialog");
        if (aVar != null) {
            aVar = new d(aVar);
        }
        s0.o(showOperationFailDialog, R.string.operation_failed_try_again, (s0.h) aVar);
    }

    public static /* synthetic */ void q(Activity activity, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = null;
        }
        p(activity, aVar);
    }

    public static final void r(Context showTPMaterialDialogV3, l<? super f, p> configs) {
        j.e(showTPMaterialDialogV3, "$this$showTPMaterialDialogV3");
        j.e(configs, "configs");
        f fVar = new f(new TPMaterialDialogV3.Builder(showTPMaterialDialogV3));
        configs.invoke(fVar);
        fVar.k();
    }
}
