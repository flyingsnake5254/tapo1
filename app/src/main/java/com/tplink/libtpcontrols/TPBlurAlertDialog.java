package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.andexert.library.RippleView;
import com.commit451.nativestackblur.NativeStackBlur;
import com.tplink.libtpcontrols.z0.g;

/* loaded from: classes3.dex */
public class TPBlurAlertDialog extends Fragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f12054c = null;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f12055d = null;

    /* renamed from: f  reason: collision with root package name */
    private int f12056f = -1;
    private int q = -1;
    private CharSequence x = null;
    private int y = -1;
    private int z = -1;
    private int p0 = -1;
    private View p1 = null;
    private int p2 = -1;
    private int p3 = -1;
    private g H3 = null;
    private CharSequence I3 = null;
    private int J3 = -1;
    private int K3 = -1;
    private g L3 = null;
    private CharSequence M3 = null;
    private View N3 = null;
    private LayoutInflater O3 = null;
    private Activity P3 = null;
    private TextView Q3 = null;
    private TextView R3 = null;
    private TextView S3 = null;
    private TextView T3 = null;
    private View U3 = null;
    private View V3 = null;
    private ImageView W3 = null;
    private int X3 = 0;
    private int Y3 = 150;
    private View Z3 = null;
    private LinearLayout a4 = null;
    private boolean b4 = true;
    private RippleView c4 = null;
    private RippleView d4 = null;
    private boolean e4 = true;
    private Bitmap f4 = null;
    private com.tplink.libtpcontrols.z0.b g4 = null;
    private boolean h4 = true;
    private boolean i4 = true;
    private boolean j4 = false;
    private boolean k4 = false;
    private boolean l4 = false;
    private boolean m4 = true;
    private boolean n4 = true;

    /* loaded from: classes3.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            TPBlurAlertDialog.this.N0();
            TPBlurAlertDialog.this.J0();
            TPBlurAlertDialog.this.N3.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f12058c;

        b(int i) {
            this.f12058c = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            TPBlurAlertDialog.this.O0(-this.f12058c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TPBlurAlertDialog.this.O0(-this.f12058c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(TPBlurAlertDialog.this.W3, "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(250L);
            ofFloat.start();
        }
    }

    private void I0() {
        ObjectAnimator objectAnimator;
        final int i;
        int e2 = b.d.w.f.a.e(this.P3);
        int c2 = b.d.w.f.a.c(this.P3);
        int height = this.V3.getHeight();
        if (e2 > 0) {
            int a2 = ((c2 - e2) - height) - b.d.w.f.a.a(this.P3, 20.0f);
            int i2 = (c2 - height) / 2;
            if (a2 > i2) {
                a2 = i2;
            }
            int[] iArr = new int[2];
            this.V3.getLocationOnScreen(iArr);
            i = a2 - iArr[1];
            if (this.n4) {
                this.V3.setTranslationY(i);
                this.n4 = false;
                this.V3.post(new Runnable() { // from class: com.tplink.libtpcontrols.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPBlurAlertDialog.this.V0(i);
                    }
                });
                return;
            }
            objectAnimator = ObjectAnimator.ofFloat(this.V3, "translationY", 0.0f, i);
        } else {
            int[] iArr2 = new int[2];
            this.V3.getLocationOnScreen(iArr2);
            i = ((c2 - height) / 2) - iArr2[1];
            objectAnimator = ObjectAnimator.ofFloat(this.V3, "translationY", -i, 0.0f);
            objectAnimator.setStartDelay(50L);
        }
        objectAnimator.addListener(new b(i));
        objectAnimator.setDuration(250L);
        objectAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N3, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.start();
    }

    private void K0() {
        if (this.Q3.getVisibility() == 0 && 8 == this.R3.getVisibility() && this.p0 == -1) {
            this.Q3.setPadding(b.d.w.f.a.a(this.P3, 35.0f), b.d.w.f.a.a(this.P3, 23.0f), b.d.w.f.a.a(this.P3, 35.0f), b.d.w.f.a.a(this.P3, 19.0f));
        }
        if (this.Q3.getVisibility() == 0 && this.R3.getVisibility() == 0 && this.p0 == -1) {
            this.Q3.setPadding(b.d.w.f.a.a(this.P3, 35.0f), b.d.w.f.a.a(this.P3, 18.0f), b.d.w.f.a.a(this.P3, 35.0f), b.d.w.f.a.a(this.P3, 14.0f));
            this.R3.setPadding(b.d.w.f.a.a(this.P3, 15.0f), 0, b.d.w.f.a.a(this.P3, 18.0f), b.d.w.f.a.a(this.P3, 14.0f));
        }
        if (8 == this.Q3.getVisibility() && this.R3.getVisibility() == 0 && this.p0 == -1) {
            this.R3.setPadding(b.d.w.f.a.a(this.P3, 15.0f), b.d.w.f.a.a(this.P3, 29.0f), b.d.w.f.a.a(this.P3, 18.0f), b.d.w.f.a.a(this.P3, 29.0f));
        }
        if (this.Q3.getVisibility() == 0 && 8 == this.R3.getVisibility() && this.p0 != -1) {
            this.Q3.setPadding(b.d.w.f.a.a(this.P3, 35.0f), b.d.w.f.a.a(this.P3, 23.0f), b.d.w.f.a.a(this.P3, 35.0f), b.d.w.f.a.a(this.P3, 19.0f));
            this.a4.setPadding(0, 0, 0, b.d.w.f.a.a(this.P3, 19.0f));
        }
        if (8 == this.Q3.getVisibility() && this.R3.getVisibility() == 0 && this.p0 != -1) {
            this.R3.setPadding(b.d.w.f.a.a(this.P3, 15.0f), b.d.w.f.a.a(this.P3, 18.0f), b.d.w.f.a.a(this.P3, 15.0f), b.d.w.f.a.a(this.P3, 19.0f));
            this.a4.setPadding(0, 0, 0, b.d.w.f.a.a(this.P3, 19.0f));
        }
        if (this.Q3.getVisibility() == 0 && this.R3.getVisibility() == 0 && this.p0 != -1) {
            this.Q3.setPadding(b.d.w.f.a.a(this.P3, 35.0f), b.d.w.f.a.a(this.P3, 18.0f), b.d.w.f.a.a(this.P3, 35.0f), b.d.w.f.a.a(this.P3, 14.0f));
            this.R3.setPadding(b.d.w.f.a.a(this.P3, 15.0f), 0, b.d.w.f.a.a(this.P3, 18.0f), b.d.w.f.a.a(this.P3, 14.0f));
            this.a4.setPadding(0, 0, 0, b.d.w.f.a.a(this.P3, 19.0f));
        }
        if (8 == this.Q3.getVisibility() && 8 == this.R3.getVisibility() && this.p0 != -1) {
            this.a4.setPadding(0, b.d.w.f.a.a(this.P3, 19.0f), 0, b.d.w.f.a.a(this.P3, 19.0f));
        }
    }

    private void L0() {
        if (!TextUtils.isEmpty(this.f12055d)) {
            this.Q3.setText(this.f12055d);
        } else {
            int i = this.f12056f;
            if (i != -1) {
                this.Q3.setText(i);
            } else {
                this.Q3.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(this.x)) {
            this.R3.setText(this.x);
        } else {
            int i2 = this.y;
            if (i2 != -1) {
                this.R3.setText(i2);
            } else {
                this.R3.setVisibility(8);
            }
        }
        if (this.l4) {
            this.c4.setVisibility(0);
            if (!TextUtils.isEmpty(this.I3)) {
                this.T3.setText(this.I3);
            } else {
                int i3 = this.p2;
                if (i3 != -1) {
                    this.T3.setText(i3);
                }
            }
            int i4 = this.p3;
            if (i4 != -1) {
                this.T3.setTextColor(ContextCompat.getColorStateList(this.P3, i4));
            }
            if (this.H3 != null) {
                this.c4.setOnRippleCompleteListener(new RippleView.b() { // from class: com.tplink.libtpcontrols.d
                    @Override // com.andexert.library.RippleView.b
                    public final void j0(RippleView rippleView) {
                        TPBlurAlertDialog.this.X0(rippleView);
                    }
                });
            }
        } else {
            this.c4.setVisibility(8);
            this.Z3.setVisibility(8);
        }
        if (this.k4) {
            this.d4.setVisibility(0);
            if (!TextUtils.isEmpty(this.M3)) {
                this.S3.setText(this.M3);
            } else {
                int i5 = this.J3;
                if (i5 != -1) {
                    this.S3.setText(i5);
                }
            }
            int i6 = this.K3;
            if (i6 != -1) {
                this.S3.setTextColor(ContextCompat.getColorStateList(this.P3, i6));
            }
            if (this.L3 != null) {
                this.d4.setOnRippleCompleteListener(new RippleView.b() { // from class: com.tplink.libtpcontrols.h
                    @Override // com.andexert.library.RippleView.b
                    public final void j0(RippleView rippleView) {
                        TPBlurAlertDialog.this.Z0(rippleView);
                    }
                });
            }
        } else {
            this.d4.setVisibility(8);
            this.Z3.setVisibility(8);
        }
        int i7 = this.q;
        if (i7 != -1) {
            this.Q3.setTextColor(ContextCompat.getColorStateList(this.P3, i7));
        }
        int i8 = this.z;
        if (i8 != -1) {
            this.R3.setTextColor(ContextCompat.getColorStateList(this.P3, i8));
        }
        View view = this.p1;
        if (view != null) {
            this.a4.addView(view);
        } else {
            int i9 = this.p0;
            if (i9 != -1) {
                this.O3.inflate(i9, (ViewGroup) this.a4, true);
                this.p1 = this.a4.getChildAt(0);
            }
        }
        this.N3.setOnKeyListener(new View.OnKeyListener() { // from class: com.tplink.libtpcontrols.g
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i10, KeyEvent keyEvent) {
                return TPBlurAlertDialog.this.b1(view2, i10, keyEvent);
            }
        });
        K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        O0(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(int i) {
        P0(this.V3, this.f4, this.W3, i);
    }

    private void P0(View view, Bitmap bitmap, ImageView imageView, int i) {
        if (bitmap != null) {
            try {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                iArr[1] = iArr[1] - (b.d.w.f.a.c(this.P3) - bitmap.getHeight());
                iArr[1] = iArr[1] - i;
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, iArr[0], iArr[1], view.getWidth(), view.getHeight());
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setFlags(2);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
                imageView.setImageDrawable(new BitmapDrawable(this.P3.getResources(), NativeStackBlur.process(createBitmap, this.Y3)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private Animation Q0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    private void S0() {
        View view = this.U3;
        if (view == null) {
            view = this.P3.getWindow().getDecorView();
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f4 = view.getDrawingCache();
    }

    private void T0() {
        Bitmap bitmap = this.f4;
        if (bitmap == null || bitmap.isRecycled()) {
            S0();
        }
        this.Q3 = (TextView) this.N3.findViewById(s0.dialog_title_tv);
        this.R3 = (TextView) this.N3.findViewById(s0.dialog_message_tv);
        TextView textView = (TextView) this.N3.findViewById(s0.dialog_left_button_tv);
        this.S3 = textView;
        textView.setOnClickListener(this);
        this.S3.setEnabled(this.i4);
        TextView textView2 = (TextView) this.N3.findViewById(s0.dialog_right_button_tv);
        this.T3 = textView2;
        textView2.setOnClickListener(this);
        this.T3.setEnabled(this.h4);
        this.V3 = this.N3.findViewById(s0.dialog_container_rl);
        this.Z3 = this.N3.findViewById(s0.dialog_button_divider);
        this.W3 = (ImageView) this.N3.findViewById(s0.dialog_blur_bg_iv);
        this.a4 = (LinearLayout) this.N3.findViewById(s0.dialog_customer_view_container_ll);
        RippleView rippleView = (RippleView) this.N3.findViewById(s0.dialog_positive_button_container_rv);
        this.c4 = rippleView;
        rippleView.setEnabled(this.h4);
        RippleView rippleView2 = (RippleView) this.N3.findViewById(s0.dialog_negative_button_container_rv);
        this.d4 = rippleView2;
        rippleView2.setEnabled(this.i4);
        this.N3.setOnClickListener(this);
        L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ void V0(int i) {
        O0(-i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public /* synthetic */ void X0(RippleView rippleView) {
        this.H3.a(this, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0 */
    public /* synthetic */ void Z0(RippleView rippleView) {
        this.L3.a(this, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public /* synthetic */ boolean b1(View view, int i, KeyEvent keyEvent) {
        return this.m4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1 */
    public /* synthetic */ void d1() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.popBackStack();
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1() {
        int e2 = b.d.w.f.a.e(this.P3);
        if (e2 != this.X3) {
            I0();
            this.X3 = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1() {
        this.N3.startAnimation(Q0());
        ((ViewGroup) this.P3.getWindow().getDecorView()).removeView(this.N3);
    }

    public void R0(boolean z) {
        this.j4 = z;
        if (!this.e4) {
            this.e4 = true;
            new Handler().post(new Runnable() { // from class: com.tplink.libtpcontrols.e
                @Override // java.lang.Runnable
                public final void run() {
                    TPBlurAlertDialog.this.d1();
                }
            });
        }
    }

    public void dismiss() {
        R0(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == s0.blur_alert_dialog_root_view && this.b4) {
            dismiss();
        }
        view.getId();
        view.getId();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.P3 = getActivity();
        if (bundle != null) {
            this.e4 = bundle.getBoolean("EXTRA_DISMISSED");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.O3 == null) {
            this.O3 = layoutInflater;
        }
        this.N3 = layoutInflater.inflate(t0.tpblur_alert_dialog_main, viewGroup, true);
        T0();
        ((ViewGroup) getActivity().getWindow().getDecorView()).addView(this.N3);
        this.N3.getViewTreeObserver().addOnPreDrawListener(new a());
        this.N3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tplink.libtpcontrols.f
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                TPBlurAlertDialog.this.f1();
            }
        });
        com.tplink.libtpcontrols.z0.b bVar = this.g4;
        if (bVar != null) {
            bVar.b(this, this.N3);
        }
        return this.N3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        b.d.w.f.a.g(this.P3);
        if (this.j4) {
            this.N3.postDelayed(new Runnable() { // from class: com.tplink.libtpcontrols.j
                @Override // java.lang.Runnable
                public final void run() {
                    TPBlurAlertDialog.this.h1();
                }
            }, 200L);
        } else {
            ((ViewGroup) this.P3.getWindow().getDecorView()).removeView(this.N3);
        }
        com.tplink.libtpcontrols.z0.b bVar = this.g4;
        if (bVar != null) {
            bVar.a(this, this.N3);
        }
        this.e4 = true;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("EXTRA_DISMISSED", this.e4);
    }
}
