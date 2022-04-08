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
public class TPLongThreeMaterialDialog extends AlertDialog {
    private ColorStateList M3;
    private ColorStateList N3;
    private ColorStateList R3;

    /* renamed from: c  reason: collision with root package name */
    private CardView f5268c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f5269d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f5270f;
    private RippleView p0;
    private RippleView p1;
    private RippleView p2;
    private Button q;
    private Button x;
    private Button y;
    private FrameLayout z;
    private String p3 = "";
    private int H3 = R.color.common_iot_dark_black;
    private String I3 = "";
    private int J3 = R.color.common_gray_black_color_transparent_80;
    private String K3 = "";
    private String L3 = "";
    private e O3 = null;
    private e P3 = null;
    private String Q3 = "";
    private e S3 = null;
    private View T3 = null;
    private d U3 = null;
    private View V3 = null;
    private d W3 = null;
    private View X3 = null;
    private View Y3 = null;
    private int Z3 = -1;
    private int a4 = 0;
    private int b4 = 0;
    private boolean c4 = true;
    private boolean d4 = true;
    private boolean e4 = true;
    private int f4 = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    private int g4 = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    private int h4 = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    private boolean i4 = true;
    private boolean j4 = true;
    private boolean k4 = true;

    /* loaded from: classes2.dex */
    public static class Builder extends AlertDialog.Builder {
        private TPLongThreeMaterialDialog a;

        public Builder(Context context) {
            super(context);
            this.a = new TPLongThreeMaterialDialog(context);
        }

        /* renamed from: a */
        public TPLongThreeMaterialDialog create() {
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

        public Builder d(int i, int i2) {
            this.a.a4 = i;
            this.a.b4 = i2;
            return this;
        }

        /* renamed from: e */
        public Builder setMessage(int i) {
            return f(i, 0);
        }

        public Builder f(int i, int i2) {
            return g(i > 0 ? getContext().getResources().getString(i) : "", i2);
        }

        public Builder g(String str, int i) {
            this.a.I3 = str;
            if (i > 0) {
                this.a.J3 = i;
            }
            return this;
        }

        public Builder h(int i, int i2, e eVar) {
            return j(i > 0 ? getContext().getResources().getString(i) : "", i2, eVar);
        }

        public Builder i(int i, e eVar) {
            return h(i, 0, eVar);
        }

        public Builder j(String str, int i, e eVar) {
            ColorStateList colorStateList;
            if (i > 0) {
                colorStateList = getContext().getResources().getColorStateList(i);
            } else {
                colorStateList = getContext().getResources().getColorStateList(R.color.common_iot_gray_selector);
            }
            this.a.Q3 = str;
            this.a.R3 = colorStateList;
            this.a.S3 = eVar;
            return this;
        }

        public Builder k(int i, int i2, e eVar) {
            return l(i > 0 ? getContext().getResources().getString(i) : "", i2, eVar);
        }

        public Builder l(String str, int i, e eVar) {
            ColorStateList colorStateList;
            if (i > 0) {
                colorStateList = getContext().getResources().getColorStateList(i);
            } else {
                colorStateList = getContext().getResources().getColorStateList(R.color.common_iot_blue_selector);
            }
            this.a.K3 = str;
            this.a.M3 = colorStateList;
            this.a.O3 = eVar;
            return this;
        }

        public Builder m(int i, int i2, e eVar) {
            return n(i > 0 ? getContext().getResources().getString(i) : "", i2, eVar);
        }

        public Builder n(String str, int i, e eVar) {
            ColorStateList colorStateList;
            if (i > 0) {
                colorStateList = getContext().getResources().getColorStateList(i);
            } else {
                colorStateList = getContext().getResources().getColorStateList(R.color.common_iot_blue_selector);
            }
            this.a.L3 = str;
            this.a.N3 = colorStateList;
            this.a.P3 = eVar;
            return this;
        }

        /* renamed from: o */
        public Builder setTitle(int i) {
            return p(i, 0);
        }

        public Builder p(int i, int i2) {
            return q(i > 0 ? getContext().getResources().getString(i) : "", i2);
        }

        public Builder q(String str, int i) {
            this.a.p3 = str;
            if (i > 0) {
                this.a.H3 = i;
            }
            return this;
        }

        /* renamed from: r */
        public Builder setView(int i) {
            return setView(i > 0 ? LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.a.z, false) : null);
        }

        /* renamed from: s */
        public Builder setView(View view) {
            this.a.T3 = view;
            return this;
        }

        /* renamed from: t */
        public TPLongThreeMaterialDialog show() {
            TPLongThreeMaterialDialog a = create();
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
            if (TPLongThreeMaterialDialog.this.c4) {
                if (TPLongThreeMaterialDialog.this.i4) {
                    TPLongThreeMaterialDialog.this.dismiss();
                }
                if (TPLongThreeMaterialDialog.this.O3 != null) {
                    TPLongThreeMaterialDialog.this.O3.onClick(rippleView);
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
            if (TPLongThreeMaterialDialog.this.d4) {
                if (TPLongThreeMaterialDialog.this.j4) {
                    TPLongThreeMaterialDialog.this.dismiss();
                }
                if (TPLongThreeMaterialDialog.this.P3 != null) {
                    TPLongThreeMaterialDialog.this.P3.onClick(rippleView);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements RippleView.b {
        c() {
        }

        @Override // com.andexert.library.RippleView.b
        public void j0(RippleView rippleView) {
            if (TPLongThreeMaterialDialog.this.e4) {
                if (TPLongThreeMaterialDialog.this.k4) {
                    TPLongThreeMaterialDialog.this.dismiss();
                }
                if (TPLongThreeMaterialDialog.this.S3 != null) {
                    TPLongThreeMaterialDialog.this.S3.onClick(rippleView);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(TPLongThreeMaterialDialog tPLongThreeMaterialDialog, View view);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void onClick(View view);
    }

    protected TPLongThreeMaterialDialog(Context context) {
        super(context, R.style.TPDialog);
    }

    private void A(TPLongThreeMaterialDialog tPLongThreeMaterialDialog) {
        int i = tPLongThreeMaterialDialog.Z3;
        if (i != -1) {
            tPLongThreeMaterialDialog.f5268c.setRadius(i);
        }
        if (tPLongThreeMaterialDialog.V3 != null) {
            tPLongThreeMaterialDialog.f5268c.removeAllViews();
            tPLongThreeMaterialDialog.f5268c.addView(tPLongThreeMaterialDialog.V3);
            d dVar = tPLongThreeMaterialDialog.W3;
            if (dVar != null) {
                dVar.a(tPLongThreeMaterialDialog, tPLongThreeMaterialDialog.V3);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(tPLongThreeMaterialDialog.p3)) {
            tPLongThreeMaterialDialog.f5269d.setVisibility(8);
        } else {
            tPLongThreeMaterialDialog.f5269d.setVisibility(0);
            tPLongThreeMaterialDialog.f5269d.setText(tPLongThreeMaterialDialog.p3);
            tPLongThreeMaterialDialog.f5269d.setTextColor(getContext().getResources().getColor(tPLongThreeMaterialDialog.H3));
        }
        if (TextUtils.isEmpty(tPLongThreeMaterialDialog.I3)) {
            tPLongThreeMaterialDialog.f5270f.setVisibility(8);
        } else {
            tPLongThreeMaterialDialog.f5270f.setVisibility(0);
            tPLongThreeMaterialDialog.f5270f.setText(tPLongThreeMaterialDialog.I3);
            tPLongThreeMaterialDialog.f5270f.setTextColor(getContext().getResources().getColor(tPLongThreeMaterialDialog.J3));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tPLongThreeMaterialDialog.f5270f.getLayoutParams();
            if (TextUtils.isEmpty(tPLongThreeMaterialDialog.p3)) {
                layoutParams.topMargin = b.d.w.f.a.a(getContext(), 20.0f);
            } else {
                layoutParams.topMargin = b.d.w.f.a.a(getContext(), 15.0f);
            }
            tPLongThreeMaterialDialog.f5270f.setLayoutParams(layoutParams);
        }
        if (this.T3 != null) {
            tPLongThreeMaterialDialog.z.setVisibility(0);
            tPLongThreeMaterialDialog.z.removeAllViews();
            tPLongThreeMaterialDialog.z.addView(tPLongThreeMaterialDialog.T3);
            d dVar2 = this.U3;
            if (dVar2 != null) {
                dVar2.a(this, tPLongThreeMaterialDialog.z);
            }
        } else {
            tPLongThreeMaterialDialog.z.setVisibility(8);
        }
        this.X3.setVisibility(this.a4);
        this.Y3.setVisibility(this.b4);
        if (TextUtils.isEmpty(tPLongThreeMaterialDialog.K3)) {
            tPLongThreeMaterialDialog.q.setVisibility(8);
        } else {
            tPLongThreeMaterialDialog.q.setVisibility(0);
            tPLongThreeMaterialDialog.q.setText(tPLongThreeMaterialDialog.K3);
            tPLongThreeMaterialDialog.q.setTextColor(tPLongThreeMaterialDialog.M3);
        }
        if (TextUtils.isEmpty(tPLongThreeMaterialDialog.L3)) {
            tPLongThreeMaterialDialog.x.setVisibility(8);
        } else {
            tPLongThreeMaterialDialog.x.setVisibility(0);
            tPLongThreeMaterialDialog.x.setText(tPLongThreeMaterialDialog.L3);
            tPLongThreeMaterialDialog.x.setTextColor(tPLongThreeMaterialDialog.N3);
        }
        if (TextUtils.isEmpty(tPLongThreeMaterialDialog.Q3)) {
            tPLongThreeMaterialDialog.y.setVisibility(8);
            return;
        }
        tPLongThreeMaterialDialog.y.setVisibility(0);
        tPLongThreeMaterialDialog.y.setText(tPLongThreeMaterialDialog.Q3);
        tPLongThreeMaterialDialog.y.setTextColor(tPLongThreeMaterialDialog.R3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tp_long_three_material_dialog_v2);
        this.f5268c = (CardView) findViewById(R.id.dialog_card);
        this.f5269d = (TextView) findViewById(R.id.title);
        this.f5270f = (TextView) findViewById(R.id.message);
        this.z = (FrameLayout) findViewById(R.id.dialog_content);
        this.q = (Button) findViewById(R.id.btn_positive_first);
        this.x = (Button) findViewById(R.id.btn_positive_second);
        this.y = (Button) findViewById(R.id.btn_negative);
        this.p0 = (RippleView) findViewById(R.id.btn_positive_ripple_first);
        this.p1 = (RippleView) findViewById(R.id.btn_positive_ripple_second);
        this.p2 = (RippleView) findViewById(R.id.btn_negative_ripple);
        this.f4 = this.p0.getRippleDuration();
        this.g4 = this.p1.getRippleDuration();
        this.h4 = this.p2.getRippleDuration();
        int i = 0;
        this.p0.setRippleDuration(this.c4 ? this.f4 : 0);
        this.p1.setRippleDuration(this.d4 ? this.g4 : 0);
        RippleView rippleView = this.p2;
        if (this.e4) {
            i = this.h4;
        }
        rippleView.setRippleDuration(i);
        this.q.setEnabled(this.c4);
        this.x.setEnabled(this.d4);
        this.y.setEnabled(this.e4);
        this.X3 = findViewById(R.id.top_divider);
        this.Y3 = findViewById(R.id.bottom_divider);
        this.p0.setOnRippleCompleteListener(new a());
        this.p1.setOnRippleCompleteListener(new b());
        this.p2.setOnRippleCompleteListener(new c());
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        A(this);
    }
}
