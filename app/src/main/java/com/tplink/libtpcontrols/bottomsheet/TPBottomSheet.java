package com.tplink.libtpcontrols.bottomsheet;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;

/* loaded from: classes3.dex */
public class TPBottomSheet extends Fragment implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    private e f12183f;
    private ViewGroup p1;
    private View x;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12181c = true;

    /* renamed from: d  reason: collision with root package name */
    private Activity f12182d = null;
    private LayoutInflater q = null;
    private int y = 2171169;
    private boolean z = false;
    private View p0 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            TPBottomSheet.this.C0();
            TPBottomSheet.this.x.getViewTreeObserver().removeOnPreDrawListener(this);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.3f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.bottomsheet.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPBottomSheet.this.I0(valueAnimator);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    private void G0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.3f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.bottomsheet.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TPBottomSheet.this.K0(valueAnimator);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(ValueAnimator valueAnimator) {
        this.x.setBackgroundColor(ColorUtils.setAlphaComponent(this.y, (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f)));
        this.p1.setTranslationY((this.p1.getHeight() + b.d.w.f.a.e(this.f12182d)) * (1.0f - valueAnimator.getAnimatedFraction()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(ValueAnimator valueAnimator) {
        this.x.setBackgroundColor(ColorUtils.setAlphaComponent(this.y, (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f)));
        this.p1.setTranslationY((this.p1.getHeight() + b.d.w.f.a.e(this.f12182d)) * valueAnimator.getAnimatedFraction());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0() {
        getFragmentManager().popBackStack();
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.remove(this);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0() {
        ((ViewGroup) this.f12182d.getWindow().getDecorView()).removeView(this.x);
        this.p1.removeAllViews();
    }

    private void Q0() {
        View view = this.p0;
        if (view != null) {
            this.p1.addView(view, -1, -2);
            this.x.getViewTreeObserver().addOnPreDrawListener(new a());
            return;
        }
        throw new IllegalStateException("Custom View Not Set!!!");
    }

    public void dismiss() {
        if (!this.f12181c) {
            this.f12181c = true;
            new Handler().post(new Runnable() { // from class: com.tplink.libtpcontrols.bottomsheet.a
                @Override // java.lang.Runnable
                public final void run() {
                    TPBottomSheet.this.N0();
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View getView() {
        return this.p0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == s0.bottom_sheet_rootview && this.z) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f12182d = getActivity();
        if (bundle != null) {
            this.f12181c = bundle.getBoolean("EXTRA_DISMISSED");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = layoutInflater;
        View inflate = layoutInflater.inflate(t0.bottom_sheet_container, viewGroup, true);
        this.x = inflate;
        this.p1 = (ViewGroup) inflate.findViewById(s0.bottom_sheet_container);
        if (b.d.w.f.a.b(this.f12182d)) {
            ((RelativeLayout.LayoutParams) this.p1.getLayoutParams()).bottomMargin = b.d.w.f.a.e(this.f12182d);
        }
        this.x.setOnClickListener(this);
        Q0();
        ViewGroup viewGroup2 = (ViewGroup) getActivity().getWindow().getDecorView();
        viewGroup2.removeView(this.x);
        viewGroup2.addView(this.x);
        e eVar = this.f12183f;
        if (eVar != null) {
            eVar.a(this, this.p1);
        }
        return this.x;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        e eVar = this.f12183f;
        if (eVar != null) {
            eVar.b(this, this.p1);
        }
        G0();
        this.x.postDelayed(new Runnable() { // from class: com.tplink.libtpcontrols.bottomsheet.c
            @Override // java.lang.Runnable
            public final void run() {
                TPBottomSheet.this.P0();
            }
        }, 300L);
        this.f12181c = true;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("EXTRA_DISMISSED", this.f12181c);
    }
}
