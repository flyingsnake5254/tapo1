package com.tplink.iot.Utils.extension;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import kotlin.jvm.internal.j;

/* compiled from: ViewUtils.kt */
/* loaded from: classes2.dex */
public final class i {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TPSwitchCompat f5311c;

        a(TPSwitchCompat tPSwitchCompat) {
            this.f5311c = tPSwitchCompat;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f5311c.setEnabled(true);
        }
    }

    public static final void a(TPSwitchCompat disableForAWhile, long j) {
        j.e(disableForAWhile, "$this$disableForAWhile");
        disableForAWhile.setEnabled(false);
        disableForAWhile.postDelayed(new a(disableForAWhile), j);
    }

    public static /* synthetic */ void b(TPSwitchCompat tPSwitchCompat, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 800;
        }
        a(tPSwitchCompat, j);
    }

    public static final void c(Activity hideKeyboard, int i) {
        j.e(hideKeyboard, "$this$hideKeyboard");
        InputMethodManager inputMethodManager = (InputMethodManager) hideKeyboard.getSystemService("input_method");
        Window window = hideKeyboard.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (inputMethodManager != null && decorView != null) {
            inputMethodManager.hideSoftInputFromWindow(decorView.getWindowToken(), i);
        }
    }

    public static /* synthetic */ void d(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        c(activity, i);
    }

    public static final void e(Activity hideKeyboardFromView, View view, int i) {
        j.e(hideKeyboardFromView, "$this$hideKeyboardFromView");
        j.e(view, "view");
        InputMethodManager inputMethodManager = (InputMethodManager) hideKeyboardFromView.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), i);
        }
    }

    public static /* synthetic */ void f(Activity activity, View view, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        e(activity, view, i);
    }

    public static final void g(RecyclerView removeItemAnimator) {
        j.e(removeItemAnimator, "$this$removeItemAnimator");
        RecyclerView.ItemAnimator itemAnimator = removeItemAnimator.getItemAnimator();
        if (!(itemAnimator instanceof SimpleItemAnimator)) {
            itemAnimator = null;
        }
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
    }

    public static final void h(Activity showKeyboard, int i) {
        j.e(showKeyboard, "$this$showKeyboard");
        InputMethodManager inputMethodManager = (InputMethodManager) showKeyboard.getSystemService("input_method");
        if (inputMethodManager != null && showKeyboard.getCurrentFocus() != null) {
            inputMethodManager.showSoftInput(showKeyboard.getCurrentFocus(), i);
        }
    }

    public static final void i(Activity showKeyboardImplicit) {
        j.e(showKeyboardImplicit, "$this$showKeyboardImplicit");
        h(showKeyboardImplicit, 1);
    }

    public static final void j(View toGone) {
        j.e(toGone, "$this$toGone");
        toGone.setVisibility(8);
    }

    public static final void k(View toInvisible) {
        j.e(toInvisible, "$this$toInvisible");
        toInvisible.setVisibility(4);
    }

    public static final void l(View toVisible) {
        j.e(toVisible, "$this$toVisible");
        toVisible.setVisibility(0);
    }
}
