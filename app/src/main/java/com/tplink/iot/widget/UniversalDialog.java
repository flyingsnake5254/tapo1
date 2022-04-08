package com.tplink.iot.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class UniversalDialog extends DialogFragment {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private TextView f11609c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private TextView f11610d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private TextView f11611f;
    @Nullable
    private TextView q;
    private a x;

    /* loaded from: classes3.dex */
    public static class a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f11612b;

        /* renamed from: c  reason: collision with root package name */
        private String f11613c;

        /* renamed from: d  reason: collision with root package name */
        private String f11614d;

        /* renamed from: f  reason: collision with root package name */
        private c f11616f;
        private b g;
        private Integer h;
        private d i;

        /* renamed from: e  reason: collision with root package name */
        private int f11615e = -1;
        private boolean j = false;
        private boolean k = true;

        public UniversalDialog l() {
            UniversalDialog universalDialog = new UniversalDialog();
            universalDialog.I0(this);
            return universalDialog;
        }

        public a m(boolean z) {
            this.j = z;
            return this;
        }

        public a n(boolean z) {
            this.k = z;
            return this;
        }

        public a o(@LayoutRes int i) {
            this.h = Integer.valueOf(i);
            return this;
        }

        public a p(@LayoutRes int i, d dVar) {
            this.h = Integer.valueOf(i);
            this.i = dVar;
            return this;
        }

        public a q(String str) {
            this.f11612b = str;
            return this;
        }

        public a r(b bVar) {
            this.g = bVar;
            return this;
        }

        public a s(String str) {
            this.f11613c = str;
            return this;
        }

        public a t(c cVar) {
            this.f11616f = cVar;
            return this;
        }

        public a u(String str) {
            this.f11614d = str;
            return this;
        }

        public a v(@ColorInt int i) {
            this.f11615e = i;
            return this;
        }

        public a w(String str) {
            this.a = str;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0(View view) {
        if (this.x.f11616f != null) {
            this.x.f11616f.a();
        }
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0 */
    public /* synthetic */ void H0(View view) {
        dismiss();
        if (this.x.g != null) {
            this.x.g.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(a aVar) {
        this.x = aVar;
    }

    public void J0(String str) {
        TextView textView = this.f11610d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        a aVar = this.x;
        View inflate = layoutInflater.inflate((aVar == null || aVar.h == null) ? R.layout.dialog_universal : this.x.h.intValue(), viewGroup);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            a aVar2 = this.x;
            if (aVar2 != null && !aVar2.k) {
                dialog.setCanceledOnTouchOutside(false);
            }
        }
        this.f11609c = (TextView) inflate.findViewById(R.id.dialog_title);
        this.f11610d = (TextView) inflate.findViewById(R.id.dialog_message);
        this.f11611f = (TextView) inflate.findViewById(R.id.dialog_positive_btn);
        this.q = (TextView) inflate.findViewById(R.id.dialog_negative_btn);
        TextView textView = this.f11609c;
        String str = "";
        if (textView != null) {
            a aVar3 = this.x;
            textView.setText((aVar3 == null || aVar3.a == null) ? str : this.x.a);
            TextView textView2 = this.f11609c;
            a aVar4 = this.x;
            textView2.setVisibility((aVar4 == null || aVar4.a == null) ? 8 : 0);
        }
        TextView textView3 = this.f11610d;
        if (textView3 != null) {
            a aVar5 = this.x;
            if (aVar5 != null) {
                str = aVar5.f11612b;
            }
            textView3.setText(str);
        }
        TextView textView4 = this.f11611f;
        if (textView4 != null) {
            a aVar6 = this.x;
            if (aVar6 == null) {
                textView4.setAllCaps(false);
            } else {
                textView4.setAllCaps(aVar6.j);
            }
            a aVar7 = this.x;
            if (aVar7 == null || aVar7.f11614d == null) {
                this.f11611f.setVisibility(8);
            } else {
                this.f11611f.setText(this.x.f11614d);
                this.f11611f.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.widget.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UniversalDialog.this.C0(view);
                    }
                });
            }
            a aVar8 = this.x;
            if (aVar8 == null || aVar8.f11615e == -1) {
                this.f11611f.setTextColor(-14955521);
            } else {
                this.f11611f.setTextColor(this.x.f11615e);
            }
        }
        TextView textView5 = this.q;
        if (textView5 != null) {
            a aVar9 = this.x;
            if (aVar9 == null) {
                textView5.setAllCaps(false);
            } else {
                textView5.setAllCaps(aVar9.j);
            }
            a aVar10 = this.x;
            if (aVar10 == null || aVar10.f11613c == null) {
                this.q.setVisibility(8);
            } else {
                this.q.setText(this.x.f11613c);
                this.q.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.widget.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UniversalDialog.this.H0(view);
                    }
                });
            }
        }
        a aVar11 = this.x;
        if (!(aVar11 == null || aVar11.i == null)) {
            this.x.i.a(inflate);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (Exception unused) {
            b.d.w.c.a.d("dialog show Exception");
        }
    }
}
