package com.tplink.iot.Utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.andexert.library.RippleView;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class TPMaterialDialog extends AlertDialog {
    private ColorStateList J3;
    private ColorStateList N3;

    /* renamed from: c  reason: collision with root package name */
    private CardView f5274c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f5275d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f5276f;
    private RippleView p0;
    private Button q;
    private Button x;
    private FrameLayout y;
    private RippleView z;
    private String p1 = "";
    private int p2 = R.color.common_tplink_dark_gray;
    private String p3 = "";
    private int H3 = R.color.common_tplink_dark_gray;
    private String I3 = "";
    private float K3 = -1.0f;
    private d L3 = null;
    private String M3 = "";
    private float O3 = -1.0f;
    private d P3 = null;
    private View Q3 = null;
    private c R3 = null;
    private View S3 = null;
    private c T3 = null;
    private boolean U3 = true;
    private boolean V3 = true;
    private int W3 = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    private int X3 = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;

    /* loaded from: classes2.dex */
    public static class Builder extends AlertDialog.Builder {
        private TPMaterialDialog a;

        public Builder(Context context) {
            super(context);
            this.a = new TPMaterialDialog(context);
        }

        /* renamed from: a */
        public TPMaterialDialog create() {
            return this.a;
        }

        /* renamed from: b */
        public Builder setCancelable(boolean z) {
            this.a.setCancelable(z);
            return this;
        }

        public Builder c(boolean z) {
            this.a.setCanceledOnTouchOutside(z);
            return this;
        }

        public Builder d(View view) {
            this.a.S3 = view;
            return this;
        }

        /* renamed from: e */
        public Builder setMessage(int i) {
            return f(i, 0);
        }

        public Builder f(int i, int i2) {
            return h(i > 0 ? getContext().getResources().getString(i) : "", i2);
        }

        public Builder g(String str) {
            return h(str, 0);
        }

        public Builder h(String str, int i) {
            this.a.p3 = str;
            if (i > 0) {
                this.a.H3 = i;
            }
            return this;
        }

        public Builder i(int i, int i2, d dVar) {
            return j(i > 0 ? getContext().getResources().getString(i) : "", i2, dVar);
        }

        public Builder j(String str, int i, d dVar) {
            ColorStateList colorStateList;
            if (i > 0) {
                colorStateList = getContext().getResources().getColorStateList(i);
            } else {
                colorStateList = getContext().getResources().getColorStateList(R.color.common_tplink_green_selector);
            }
            this.a.I3 = str;
            this.a.J3 = colorStateList;
            this.a.L3 = dVar;
            return this;
        }

        /* renamed from: k */
        public Builder setTitle(int i) {
            return l(i, 0);
        }

        public Builder l(int i, int i2) {
            return n(i > 0 ? getContext().getResources().getString(i) : "", i2);
        }

        public Builder m(String str) {
            return n(str, 0);
        }

        public Builder n(String str, int i) {
            this.a.p1 = str;
            if (i > 0) {
                this.a.p2 = i;
            }
            return this;
        }

        /* renamed from: o */
        public Builder setView(int i) {
            return setView(i > 0 ? LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.a.y, false) : null);
        }

        /* renamed from: p */
        public Builder setView(View view) {
            this.a.Q3 = view;
            return this;
        }

        /* renamed from: q */
        public TPMaterialDialog show() {
            TPMaterialDialog a = create();
            a.show();
            return a;
        }
    }

    /* loaded from: classes2.dex */
    class a implements RippleView.b {
        a() {
        }

        @Override // com.andexert.library.RippleView.b
        public void j0(RippleView rippleView) {
            if (TPMaterialDialog.this.U3) {
                TPMaterialDialog.this.dismiss();
                if (TPMaterialDialog.this.L3 != null) {
                    TPMaterialDialog.this.L3.onClick(rippleView);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements RippleView.b {
        b() {
        }

        @Override // com.andexert.library.RippleView.b
        public void j0(RippleView rippleView) {
            if (TPMaterialDialog.this.V3) {
                TPMaterialDialog.this.dismiss();
                if (TPMaterialDialog.this.P3 != null) {
                    TPMaterialDialog.this.P3.onClick(rippleView);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(TPMaterialDialog tPMaterialDialog, View view);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onClick(View view);
    }

    protected TPMaterialDialog(Context context) {
        super(context, R.style.TPDialog);
    }

    private void o(TPMaterialDialog tPMaterialDialog) {
        if (tPMaterialDialog.S3 != null) {
            tPMaterialDialog.f5274c.removeAllViews();
            tPMaterialDialog.f5274c.addView(tPMaterialDialog.S3);
            c cVar = tPMaterialDialog.T3;
            if (cVar != null) {
                cVar.a(tPMaterialDialog, tPMaterialDialog.S3);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(tPMaterialDialog.p1)) {
            tPMaterialDialog.f5275d.setVisibility(8);
        } else {
            tPMaterialDialog.f5275d.setVisibility(0);
            tPMaterialDialog.f5275d.setText(tPMaterialDialog.p1);
            tPMaterialDialog.f5275d.setTextColor(getContext().getResources().getColor(tPMaterialDialog.p2));
        }
        if (TextUtils.isEmpty(tPMaterialDialog.p3)) {
            tPMaterialDialog.f5276f.setVisibility(8);
        } else {
            tPMaterialDialog.f5276f.setVisibility(0);
            tPMaterialDialog.f5276f.setText(tPMaterialDialog.p3);
            tPMaterialDialog.f5276f.setTextColor(getContext().getResources().getColor(tPMaterialDialog.H3));
        }
        if (this.Q3 != null) {
            tPMaterialDialog.f5276f.setVisibility(8);
            tPMaterialDialog.y.setVisibility(0);
            tPMaterialDialog.y.removeAllViews();
            tPMaterialDialog.y.addView(tPMaterialDialog.Q3);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tPMaterialDialog.z.getLayoutParams();
            layoutParams.addRule(3, tPMaterialDialog.y.getId());
            tPMaterialDialog.z.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) tPMaterialDialog.p0.getLayoutParams();
            layoutParams2.addRule(3, tPMaterialDialog.y.getId());
            tPMaterialDialog.p0.setLayoutParams(layoutParams2);
            c cVar2 = this.R3;
            if (cVar2 != null) {
                cVar2.a(this, tPMaterialDialog.y);
            }
        } else {
            tPMaterialDialog.y.setVisibility(8);
        }
        if (TextUtils.isEmpty(tPMaterialDialog.I3)) {
            tPMaterialDialog.q.setVisibility(8);
        } else {
            tPMaterialDialog.q.setVisibility(0);
            tPMaterialDialog.q.setText(tPMaterialDialog.I3);
            tPMaterialDialog.q.setTextColor(tPMaterialDialog.J3);
            float f2 = this.K3;
            if (f2 != -1.0f) {
                tPMaterialDialog.q.setTextSize(f2);
            }
        }
        if (TextUtils.isEmpty(tPMaterialDialog.M3)) {
            tPMaterialDialog.x.setVisibility(8);
            return;
        }
        tPMaterialDialog.x.setVisibility(0);
        tPMaterialDialog.x.setText(tPMaterialDialog.M3);
        tPMaterialDialog.x.setTextColor(tPMaterialDialog.N3);
        float f3 = this.O3;
        if (f3 != -1.0f) {
            tPMaterialDialog.x.setTextSize(f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tp_material_dialog);
        this.f5274c = (CardView) findViewById(R.id.dialog_card);
        this.f5275d = (TextView) findViewById(R.id.title);
        this.f5276f = (TextView) findViewById(R.id.message);
        this.y = (FrameLayout) findViewById(R.id.dialog_content);
        this.q = (Button) findViewById(R.id.btn_positive);
        this.x = (Button) findViewById(R.id.btn_negative);
        this.z = (RippleView) findViewById(R.id.btn_positive_ripple);
        this.p0 = (RippleView) findViewById(R.id.btn_negative_ripple);
        this.W3 = this.z.getRippleDuration();
        this.X3 = this.p0.getRippleDuration();
        int i = 0;
        this.z.setRippleDuration(this.U3 ? this.W3 : 0);
        RippleView rippleView = this.p0;
        if (this.V3) {
            i = this.X3;
        }
        rippleView.setRippleDuration(i);
        this.q.setEnabled(this.U3);
        this.x.setEnabled(this.V3);
        this.z.setOnRippleCompleteListener(new a());
        this.p0.setOnRippleCompleteListener(new b());
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        o(this);
    }
}
