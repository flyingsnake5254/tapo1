package com.tplink.libtpcontrols.wheelpicker;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.commit451.nativestackblur.NativeStackBlur;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;

/* loaded from: classes3.dex */
public class TPBlurAlertDialogForTest extends Fragment {
    private Bitmap b4;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f12468c = null;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f12469d = null;

    /* renamed from: f  reason: collision with root package name */
    private int f12470f = -1;
    private int q = -1;
    private CharSequence x = null;
    private int y = -1;
    private int z = -1;
    private int p0 = -1;
    private View p1 = null;
    private int p2 = -1;
    private int p3 = -1;
    private View.OnClickListener H3 = null;
    private CharSequence I3 = null;
    private int J3 = -1;
    private int K3 = -1;
    private View.OnClickListener L3 = null;
    private CharSequence M3 = null;
    private View N3 = null;
    private LayoutInflater O3 = null;
    private Activity P3 = null;
    private ImageView Q3 = null;
    private ImageView R3 = null;
    private ImageView S3 = null;
    private TextView T3 = null;
    private TextView U3 = null;
    private TextView V3 = null;
    private TextView W3 = null;
    private View X3 = null;
    private View Y3 = null;
    private ImageView Z3 = null;
    private int a4 = 0;
    private boolean c4 = false;

    /* loaded from: classes3.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            TPBlurAlertDialogForTest.this.K0();
            TPBlurAlertDialogForTest.this.J0();
            TPBlurAlertDialogForTest.this.N3.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TPBlurAlertDialogForTest tPBlurAlertDialogForTest = TPBlurAlertDialogForTest.this;
            tPBlurAlertDialogForTest.L0(tPBlurAlertDialogForTest.b4);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private void I0() {
        ObjectAnimator objectAnimator;
        int e2 = b.d.w.f.a.e(this.P3);
        int c2 = b.d.w.f.a.c(this.P3);
        int height = this.Y3.getHeight();
        if (e2 > 0) {
            objectAnimator = ObjectAnimator.ofFloat(this.Y3, "translationY", 0.0f, (((c2 - e2) - height) - b.d.w.f.a.a(this.P3, 20.0f)) - this.Y3.getTop());
        } else {
            int[] iArr = new int[2];
            this.Y3.getLocationOnScreen(iArr);
            objectAnimator = ObjectAnimator.ofFloat(this.Y3, "translationY", -(((c2 - height) / 2) - iArr[1]), 0.0f);
        }
        objectAnimator.addListener(new b());
        objectAnimator.setDuration(150L);
        objectAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N3, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        long currentTimeMillis = System.currentTimeMillis();
        View view = this.X3;
        if (view == null) {
            view = this.P3.getWindow().getDecorView();
        }
        view.setDrawingCacheEnabled(true);
        if (!this.c4) {
            view.buildDrawingCache();
        }
        Bitmap drawingCache = view.getDrawingCache();
        this.b4 = drawingCache;
        N0(this.Y3, drawingCache, this.Z3);
        view.setDrawingCacheEnabled(false);
        long currentTimeMillis2 = System.currentTimeMillis();
        b.d.w.c.a.e("TPBlurAlertDialog", "Blur time = " + (currentTimeMillis2 - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(Bitmap bitmap) {
        Bitmap bitmap2 = this.b4;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            K0();
        } else {
            N0(this.Y3, bitmap, this.Z3);
        }
    }

    private void N0(View view, Bitmap bitmap, ImageView imageView) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[1] = iArr[1] - (b.d.w.f.a.c(this.P3) - bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, iArr[0], iArr[1], view.getWidth(), view.getHeight());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        imageView.setImageDrawable(new BitmapDrawable(getResources(), NativeStackBlur.process(createBitmap, 100)));
    }

    private void O0() {
        View view = this.N3;
        int i = s0.dialog_title_tv;
        this.T3 = (TextView) view.findViewById(i);
        this.U3 = (TextView) this.N3.findViewById(i);
        this.V3 = (TextView) this.N3.findViewById(s0.dialog_left_button_tv);
        this.W3 = (TextView) this.N3.findViewById(s0.dialog_right_button_tv);
        this.Y3 = this.N3.findViewById(s0.dialog_container_rl);
        this.Z3 = (ImageView) this.N3.findViewById(s0.dialog_blur_bg_iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0() {
        int e2 = b.d.w.f.a.e(this.P3);
        if (e2 != this.a4) {
            I0();
            this.a4 = e2;
        }
        b.d.w.c.a.e("TPBlurAlertDialog", "Visible height = " + b.d.w.f.a.e(this.P3));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.P3 = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.O3 == null) {
            this.O3 = layoutInflater;
        }
        this.N3 = layoutInflater.inflate(t0.tpblur_alert_dialog_main, viewGroup, true);
        O0();
        ((ViewGroup) getActivity().getWindow().getDecorView()).addView(this.N3);
        this.N3.getViewTreeObserver().addOnPreDrawListener(new a());
        this.N3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tplink.libtpcontrols.wheelpicker.a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                TPBlurAlertDialogForTest.this.Q0();
            }
        });
        return this.N3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ((ViewGroup) this.P3.getWindow().getDecorView()).removeView(this.N3);
        super.onDestroyView();
    }
}
