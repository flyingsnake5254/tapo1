package com.tplink.iot.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tplink.iot.R;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

/* compiled from: TPLoadingDialog.java */
/* loaded from: classes2.dex */
public class h0 {
    private Activity a;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f5318b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f5319c;

    /* renamed from: d  reason: collision with root package name */
    private TPCircleProgressBar f5320d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f5321e;

    /* compiled from: TPLoadingDialog.java */
    /* loaded from: classes2.dex */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (h0.this.f5320d != null) {
                h0.this.f5320d.i();
                h0.this.f5320d = null;
            }
        }
    }

    public h0(Activity activity) {
        this(activity, R.drawable.shape_circle, R.color.white);
    }

    public void c() {
        Activity activity;
        Dialog dialog = this.f5318b;
        if (dialog != null && dialog.isShowing() && (activity = this.a) != null && !activity.isDestroyed() && !this.a.isFinishing()) {
            this.f5318b.dismiss();
        }
    }

    public Activity d() {
        return this.a;
    }

    @Nullable
    public Dialog e() {
        return this.f5318b;
    }

    public boolean f() {
        Dialog dialog = this.f5318b;
        return dialog != null && dialog.isShowing();
    }

    public void g(boolean z) {
        Dialog dialog = this.f5318b;
        if (dialog != null && !dialog.isShowing()) {
            this.f5318b.setCancelable(z);
        }
    }

    public void h(String str) {
        if (str == null || str.isEmpty()) {
            this.f5321e.setVisibility(8);
            return;
        }
        this.f5321e.setText(str);
        this.f5321e.setVisibility(0);
    }

    public void i() {
        Dialog dialog = this.f5318b;
        if (dialog != null && !dialog.isShowing()) {
            this.f5318b.show();
        }
    }

    public h0(Activity activity, int i, int i2) {
        this.a = activity;
        Dialog dialog = new Dialog(activity, R.style.TPLoadingDialog);
        this.f5318b = dialog;
        dialog.setContentView(R.layout.tp_loading_dialog);
        this.f5318b.setCancelable(false);
        RelativeLayout relativeLayout = (RelativeLayout) this.f5318b.findViewById(R.id.rl_dialog);
        this.f5319c = relativeLayout;
        relativeLayout.setBackgroundResource(i);
        TPCircleProgressBar tPCircleProgressBar = (TPCircleProgressBar) this.f5318b.findViewById(R.id.progress);
        this.f5320d = tPCircleProgressBar;
        tPCircleProgressBar.setProgressBarColor(ContextCompat.getColor(activity, i2));
        this.f5320d.h();
        TextView textView = (TextView) this.f5318b.findViewById(R.id.message);
        this.f5321e = textView;
        textView.setVisibility(8);
        this.f5318b.setOnDismissListener(new a());
    }
}
