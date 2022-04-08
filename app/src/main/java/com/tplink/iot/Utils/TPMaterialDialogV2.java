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
public class TPMaterialDialogV2 extends AlertDialog {
    private ColorStateList J3;
    private ColorStateList M3;

    /* renamed from: c  reason: collision with root package name */
    private CardView f5279c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f5280d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f5281f;
    private RippleView p0;
    private Button q;
    private Button x;
    private FrameLayout y;
    private RippleView z;
    private String p1 = "";
    private int p2 = R.color.common_iot_dark_black;
    private String p3 = "";
    private int H3 = R.color.common_gray_black_color_transparent_80;
    private String I3 = "";
    private d K3 = null;
    private String L3 = "";
    private d N3 = null;
    private View O3 = null;
    private c P3 = null;
    private View Q3 = null;
    private c R3 = null;
    private View S3 = null;
    private View T3 = null;
    private int U3 = -1;
    private int V3 = 0;
    private int W3 = 0;
    private boolean X3 = true;
    private boolean Y3 = true;
    private int Z3 = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    private int a4 = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    private boolean b4 = true;
    private boolean c4 = true;

    /* loaded from: classes2.dex */
    public static class Builder extends AlertDialog.Builder {
        private TPMaterialDialogV2 a;

        public Builder(Context context) {
            super(context);
            this.a = new TPMaterialDialogV2(context);
        }

        /* renamed from: a */
        public TPMaterialDialogV2 create() {
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

        public Builder d(int i) {
            return e(i > 0 ? LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.a.f5279c, false) : null);
        }

        public Builder e(View view) {
            this.a.Q3 = view;
            return this;
        }

        public Builder f(c cVar) {
            this.a.R3 = cVar;
            return this;
        }

        public Builder g(int i, int i2) {
            this.a.V3 = i;
            this.a.W3 = i2;
            return this;
        }

        /* renamed from: h */
        public Builder setMessage(int i) {
            return i(i, 0);
        }

        public Builder i(int i, int i2) {
            return k(i > 0 ? getContext().getResources().getString(i) : "", i2);
        }

        public Builder j(String str) {
            return k(str, 0);
        }

        public Builder k(String str, int i) {
            this.a.p3 = str;
            if (i > 0) {
                this.a.H3 = i;
            }
            return this;
        }

        public Builder l(int i, int i2, d dVar) {
            return n(i > 0 ? getContext().getResources().getString(i) : "", i2, dVar);
        }

        public Builder m(int i, d dVar) {
            return l(i, 0, dVar);
        }

        public Builder n(String str, int i, d dVar) {
            ColorStateList colorStateList;
            if (i > 0) {
                colorStateList = getContext().getResources().getColorStateList(i);
            } else {
                colorStateList = getContext().getResources().getColorStateList(R.color.common_iot_gray_selector);
            }
            this.a.L3 = str;
            this.a.M3 = colorStateList;
            this.a.N3 = dVar;
            return this;
        }

        public Builder o(int i, int i2, d dVar) {
            return q(i > 0 ? getContext().getResources().getString(i) : "", i2, dVar);
        }

        public Builder p(int i, d dVar) {
            return o(i, 0, dVar);
        }

        public Builder q(String str, int i, d dVar) {
            ColorStateList colorStateList;
            if (i > 0) {
                colorStateList = getContext().getResources().getColorStateList(i);
            } else {
                colorStateList = getContext().getResources().getColorStateList(R.color.common_iot_blue_selector);
            }
            this.a.I3 = str;
            this.a.J3 = colorStateList;
            this.a.K3 = dVar;
            return this;
        }

        /* renamed from: r */
        public Builder setTitle(int i) {
            return s(i, 0);
        }

        public Builder s(int i, int i2) {
            return u(i > 0 ? getContext().getResources().getString(i) : "", i2);
        }

        public Builder t(String str) {
            return u(str, 0);
        }

        public Builder u(String str, int i) {
            this.a.p1 = str;
            if (i > 0) {
                this.a.p2 = i;
            }
            return this;
        }

        /* renamed from: v */
        public Builder setView(int i) {
            return setView(i > 0 ? LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.a.y, false) : null);
        }

        /* renamed from: w */
        public Builder setView(View view) {
            this.a.O3 = view;
            return this;
        }

        public Builder x(c cVar) {
            this.a.P3 = cVar;
            return this;
        }

        /* renamed from: y */
        public TPMaterialDialogV2 show() {
            TPMaterialDialogV2 a = create();
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
            if (TPMaterialDialogV2.this.X3) {
                if (TPMaterialDialogV2.this.b4) {
                    TPMaterialDialogV2.this.dismiss();
                }
                if (TPMaterialDialogV2.this.K3 != null) {
                    TPMaterialDialogV2.this.K3.onClick(rippleView);
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
            if (TPMaterialDialogV2.this.Y3) {
                if (TPMaterialDialogV2.this.c4) {
                    TPMaterialDialogV2.this.dismiss();
                }
                if (TPMaterialDialogV2.this.N3 != null) {
                    TPMaterialDialogV2.this.N3.onClick(rippleView);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(TPMaterialDialogV2 tPMaterialDialogV2, View view);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onClick(View view);
    }

    protected TPMaterialDialogV2(Context context) {
        super(context, R.style.TPDialog);
    }

    private void y(TPMaterialDialogV2 tPMaterialDialogV2) {
        int i = tPMaterialDialogV2.U3;
        if (i != -1) {
            tPMaterialDialogV2.f5279c.setRadius(i);
        }
        if (tPMaterialDialogV2.Q3 != null) {
            tPMaterialDialogV2.f5279c.removeAllViews();
            tPMaterialDialogV2.f5279c.addView(tPMaterialDialogV2.Q3);
            c cVar = tPMaterialDialogV2.R3;
            if (cVar != null) {
                cVar.a(tPMaterialDialogV2, tPMaterialDialogV2.Q3);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(tPMaterialDialogV2.p1)) {
            tPMaterialDialogV2.f5280d.setVisibility(8);
        } else {
            tPMaterialDialogV2.f5280d.setVisibility(0);
            tPMaterialDialogV2.f5280d.setText(tPMaterialDialogV2.p1);
            tPMaterialDialogV2.f5280d.setTextColor(getContext().getResources().getColor(tPMaterialDialogV2.p2));
        }
        if (TextUtils.isEmpty(tPMaterialDialogV2.p3)) {
            tPMaterialDialogV2.f5281f.setVisibility(8);
        } else {
            tPMaterialDialogV2.f5281f.setVisibility(0);
            tPMaterialDialogV2.f5281f.setText(tPMaterialDialogV2.p3);
            tPMaterialDialogV2.f5281f.setTextColor(getContext().getResources().getColor(tPMaterialDialogV2.H3));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tPMaterialDialogV2.f5281f.getLayoutParams();
            if (TextUtils.isEmpty(tPMaterialDialogV2.p1)) {
                layoutParams.topMargin = b.d.w.f.a.a(getContext(), 20.0f);
            } else {
                layoutParams.topMargin = b.d.w.f.a.a(getContext(), 15.0f);
            }
            tPMaterialDialogV2.f5281f.setLayoutParams(layoutParams);
        }
        if (this.O3 != null) {
            tPMaterialDialogV2.y.setVisibility(0);
            tPMaterialDialogV2.y.removeAllViews();
            tPMaterialDialogV2.y.addView(tPMaterialDialogV2.O3);
            c cVar2 = this.P3;
            if (cVar2 != null) {
                cVar2.a(this, tPMaterialDialogV2.y);
            }
        } else {
            tPMaterialDialogV2.y.setVisibility(8);
        }
        this.S3.setVisibility(this.V3);
        this.T3.setVisibility(this.W3);
        if (TextUtils.isEmpty(tPMaterialDialogV2.I3)) {
            tPMaterialDialogV2.q.setVisibility(8);
        } else {
            tPMaterialDialogV2.q.setVisibility(0);
            tPMaterialDialogV2.q.setText(tPMaterialDialogV2.I3);
            tPMaterialDialogV2.q.setTextColor(tPMaterialDialogV2.J3);
        }
        if (TextUtils.isEmpty(tPMaterialDialogV2.L3)) {
            tPMaterialDialogV2.x.setVisibility(8);
            return;
        }
        tPMaterialDialogV2.x.setVisibility(0);
        tPMaterialDialogV2.x.setText(tPMaterialDialogV2.L3);
        tPMaterialDialogV2.x.setTextColor(tPMaterialDialogV2.M3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tp_material_dialog_v2);
        this.f5279c = (CardView) findViewById(R.id.dialog_card);
        this.f5280d = (TextView) findViewById(R.id.title);
        this.f5281f = (TextView) findViewById(R.id.message);
        this.y = (FrameLayout) findViewById(R.id.dialog_content);
        this.q = (Button) findViewById(R.id.btn_positive);
        this.x = (Button) findViewById(R.id.btn_negative);
        this.z = (RippleView) findViewById(R.id.btn_positive_ripple);
        this.p0 = (RippleView) findViewById(R.id.btn_negative_ripple);
        this.Z3 = this.z.getRippleDuration();
        this.a4 = this.p0.getRippleDuration();
        int i = 0;
        this.z.setRippleDuration(this.X3 ? this.Z3 : 0);
        RippleView rippleView = this.p0;
        if (this.Y3) {
            i = this.a4;
        }
        rippleView.setRippleDuration(i);
        this.q.setEnabled(this.X3);
        this.x.setEnabled(this.Y3);
        this.S3 = findViewById(R.id.top_divider);
        this.T3 = findViewById(R.id.bottom_divider);
        this.z.setOnRippleCompleteListener(new a());
        this.p0.setOnRippleCompleteListener(new b());
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        y(this);
    }
}
