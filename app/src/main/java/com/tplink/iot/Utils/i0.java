package com.tplink.iot.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tplink.iot.R;
import com.tplink.libtpcontrols.TPLoadingFailView;

/* compiled from: TPLoadingFailDialog.java */
/* loaded from: classes2.dex */
public class i0 {
    private Activity a;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f5323b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f5324c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f5325d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f5326e;

    /* renamed from: f  reason: collision with root package name */
    private TPLoadingFailView f5327f;
    private b g = null;

    /* compiled from: TPLoadingFailDialog.java */
    /* loaded from: classes2.dex */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (i0.this.g != null) {
                i0.this.g.onDismiss();
            }
        }
    }

    /* compiled from: TPLoadingFailDialog.java */
    /* loaded from: classes2.dex */
    public interface b {
        void onDismiss();
    }

    public i0(Activity activity, String str) {
        this.a = activity;
        this.f5323b = new Dialog(activity, R.style.TPLoadingDialog);
        if (str == null || str.isEmpty() || str.length() <= 14) {
            this.f5323b.setContentView(R.layout.tp_loading_dialog_fail);
        } else {
            this.f5323b.setContentView(R.layout.tp_loading_dialog_fail_240);
        }
        this.f5323b.setCancelable(false);
        this.f5324c = (RelativeLayout) this.f5323b.findViewById(R.id.rl_dialog);
        this.f5326e = (ImageView) this.f5323b.findViewById(R.id.img_tips);
        this.f5327f = (TPLoadingFailView) this.f5323b.findViewById(R.id.img_error);
        TextView textView = (TextView) this.f5323b.findViewById(R.id.message);
        this.f5325d = textView;
        textView.setVisibility(8);
        this.f5323b.setOnDismissListener(new a());
    }

    public void b() {
        Activity activity;
        Dialog dialog = this.f5323b;
        if (dialog != null && dialog.isShowing() && (activity = this.a) != null && !activity.isDestroyed() && !this.a.isFinishing()) {
            this.f5323b.dismiss();
        }
    }

    public void c(boolean z) {
        Dialog dialog = this.f5323b;
        if (dialog != null && !dialog.isShowing()) {
            this.f5323b.setCancelable(z);
        }
    }

    public void d(int i) {
        if (i > 0) {
            this.f5327f.setVisibility(8);
            this.f5326e.setImageResource(i);
        }
    }

    public void e(String str) {
        if (str == null || str.isEmpty()) {
            this.f5325d.setVisibility(8);
            return;
        }
        this.f5325d.setText(str);
        this.f5325d.setVisibility(0);
    }

    public void f(b bVar) {
        this.g = bVar;
    }

    public void g() {
        Dialog dialog = this.f5323b;
        if (dialog != null && !dialog.isShowing()) {
            this.f5323b.show();
        }
    }
}
