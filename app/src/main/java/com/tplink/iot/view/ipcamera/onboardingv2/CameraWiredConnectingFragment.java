package com.tplink.iot.view.ipcamera.onboardingv2;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentCameraWiredConnectingBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWiredConnectingViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

/* loaded from: classes2.dex */
public class CameraWiredConnectingFragment extends OnBoardingFragment<FragmentCameraWiredConnectingBinding, CameraWiredConnectingViewModel> {
    private boolean I3;
    private Bitmap p0;
    private boolean p1;
    private CountDownTimer p2;
    private ValueAnimator x;
    private ValueAnimator y;
    private ValueAnimator z;
    private boolean p3 = false;
    private boolean H3 = true;
    private Handler J3 = new Handler();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraWiredConnectingFragment.this.q.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends CountDownTimer {
        b(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.tplink.iot.Utils.x0.f.H();
            CameraWiredConnectingFragment.this.q.q2();
            CameraWiredConnectingFragment.this.f8811f.e0("CameraNotFoundFragment.TAG", null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (CameraWiredConnectingFragment.this.H3) {
                CameraWiredConnectingFragment.this.H3 = false;
                CameraWiredConnectingFragment.this.q1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).p0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            CameraWiredConnectingFragment.this.p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            VDB vdb = CameraWiredConnectingFragment.this.f8809c;
            if (((FragmentCameraWiredConnectingBinding) vdb).H3 != null && ((FragmentCameraWiredConnectingBinding) vdb).f6965f != null) {
                if (floatValue < 60.0f) {
                    ((FragmentCameraWiredConnectingBinding) vdb).p1.setTranslationY((floatValue / 60.0f) * (((FragmentCameraWiredConnectingBinding) vdb).f6963c.getHeight() + ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).p0.getHeight()));
                }
                if (floatValue > 45.0f && floatValue <= 100.0f) {
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).I3.setVisibility(4);
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).p3.setVisibility(4);
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).H3.setVisibility(0);
                }
                if (floatValue > 40.0f && floatValue <= 100.0f) {
                    VDB vdb2 = CameraWiredConnectingFragment.this.f8809c;
                    ((FragmentCameraWiredConnectingBinding) vdb2).H3.setTranslationY(((40.0f - floatValue) / 100.0f) * ((FragmentCameraWiredConnectingBinding) vdb2).f6963c.getHeight());
                    float f2 = ((floatValue - 40.0f) / 100.0f) + 1.0f;
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).H3.setScaleX(f2);
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).H3.setScaleY(f2);
                }
                if (floatValue >= 100.0f && floatValue <= 200.0f) {
                    float f3 = (floatValue - 100.0f) / 100.0f;
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).f6965f.setScaleX(f3);
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).f6965f.setScaleY(f3);
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).f6965f.setVisibility(0);
                }
                if (floatValue >= 200.0f && floatValue <= 300.0f && !CameraWiredConnectingFragment.this.p1) {
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).f6965f.h();
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).J3.setText("");
                    CameraWiredConnectingFragment.this.p1 = true;
                }
                if (floatValue > 300.0f) {
                    float f4 = 400.0f - floatValue;
                    float f5 = f4 / 110.0f;
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).f6965f.setScaleX(f5);
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).f6965f.setScaleY(f5);
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).J3.setAlpha((f4 * 1.0f) / 100.0f);
                    float f6 = (((floatValue - 300.0f) * 8.0f) / 100.0f) + 1.6f;
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).H3.setScaleX(f6);
                    ((FragmentCameraWiredConnectingBinding) CameraWiredConnectingFragment.this.f8809c).H3.setScaleY(f6);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Animator.AnimatorListener {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CameraWiredConnectingFragment.this.f8811f.e0("CameraSetNameFragment.TAG", null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RectF f8798c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8799d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Canvas f8800f;
        final /* synthetic */ Paint q;

        f(RectF rectF, int i, Canvas canvas, Paint paint) {
            this.f8798c = rectF;
            this.f8799d = i;
            this.f8800f = canvas;
            this.q = paint;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RectF rectF = this.f8798c;
            int i = this.f8799d;
            V v = CameraWiredConnectingFragment.this.f8810d;
            rectF.top = ((i - (i / 12)) - ((((CameraWiredConnectingViewModel) v).a * i) / 8)) - 3;
            rectF.bottom = (i - ((((CameraWiredConnectingViewModel) v).a * i) / 8)) - 3;
            this.f8800f.drawRoundRect(rectF, 8.0f, 8.0f, this.q);
            CameraWiredConnectingFragment cameraWiredConnectingFragment = CameraWiredConnectingFragment.this;
            ((FragmentCameraWiredConnectingBinding) cameraWiredConnectingFragment.f8809c).f6963c.setImageBitmap(cameraWiredConnectingFragment.p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements Animator.AnimatorListener {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CameraWiredConnectingFragment cameraWiredConnectingFragment = CameraWiredConnectingFragment.this;
            ((CameraWiredConnectingViewModel) cameraWiredConnectingFragment.f8810d).a = 0;
            cameraWiredConnectingFragment.U0();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            ((CameraWiredConnectingViewModel) CameraWiredConnectingFragment.this.f8810d).a++;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private void P0() {
        ValueAnimator valueAnimator = this.x;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.x.cancel();
            this.x = null;
        }
        ValueAnimator valueAnimator2 = this.y;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.y.cancel();
            this.y = null;
        }
        ValueAnimator valueAnimator3 = this.z;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
            this.z.cancel();
            this.z = null;
        }
        VDB vdb = this.f8809c;
        if (((FragmentCameraWiredConnectingBinding) vdb).p2 != null) {
            ((FragmentCameraWiredConnectingBinding) vdb).p2.f();
        }
        VDB vdb2 = this.f8809c;
        if (((FragmentCameraWiredConnectingBinding) vdb2).p1 != null) {
            ((FragmentCameraWiredConnectingBinding) vdb2).p1.f();
        }
    }

    private void Q0() {
        CountDownTimer countDownTimer = this.p2;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.p2 = null;
        }
    }

    private void R0() {
        this.p3 = true;
        if (isAdded()) {
            ((FragmentCameraWiredConnectingBinding) this.f8809c).J3.setText(getString(R.string.quicksetup_no_bluetooth_found_m5));
        }
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p0.setVisibility(4);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p0.setVisibility(0);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).f6963c.setVisibility(4);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p1.setTranslationY(0.0f);
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.z.cancel();
            this.z = null;
        }
        ((FragmentCameraWiredConnectingBinding) this.f8809c).q.setVisibility(4);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).x.setVisibility(4);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p1.f();
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p2.f();
        this.p1 = false;
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 400.0f).setDuration(4000L);
        this.y = duration;
        duration.setStartDelay(200L);
        this.y.addUpdateListener(new d());
        this.y.addListener(new e());
        this.y.start();
    }

    private void T0() {
        this.p3 = false;
        this.q.e2(null);
        this.p2 = new b(30000L, 1000L);
        VDB vdb = this.f8809c;
        if (((FragmentCameraWiredConnectingBinding) vdb).p0 != null) {
            ((FragmentCameraWiredConnectingBinding) vdb).p0.getViewTreeObserver().addOnGlobalLayoutListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        if (!this.p3) {
            ((FragmentCameraWiredConnectingBinding) this.f8809c).x.setTranslationY(0.0f);
            ((FragmentCameraWiredConnectingBinding) this.f8809c).q.setTranslationY(0.0f);
            ((FragmentCameraWiredConnectingBinding) this.f8809c).x.setVisibility(0);
            ((FragmentCameraWiredConnectingBinding) this.f8809c).q.setVisibility(0);
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 100.0f).setDuration(1000L);
            this.z = duration;
            duration.setStartDelay(200L);
            this.z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.p1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CameraWiredConnectingFragment.this.X0(valueAnimator);
                }
            });
            this.z.setRepeatMode(1);
            this.z.setRepeatCount(-1);
            this.z.start();
        }
    }

    private void V0() {
        if (!this.I3) {
            this.I3 = true;
            VDB vdb = this.f8809c;
            if (((FragmentCameraWiredConnectingBinding) vdb).f6963c != null) {
                int height = ((FragmentCameraWiredConnectingBinding) vdb).f6963c.getHeight();
                ((FragmentCameraWiredConnectingBinding) this.f8809c).f6963c.setImageResource(R.color.transparent);
                ((FragmentCameraWiredConnectingBinding) this.f8809c).f6963c.setVisibility(0);
                this.p0 = Bitmap.createBitmap(((FragmentCameraWiredConnectingBinding) this.f8809c).f6963c.getWidth(), height, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.p0);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                paint.setColor(ContextCompat.getColor(getActivity(), R.color.common_white));
                RectF rectF = new RectF();
                rectF.left = 0.0f;
                rectF.right = ((FragmentCameraWiredConnectingBinding) this.f8809c).f6963c.getWidth();
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 100.0f).setDuration(80L);
                this.x = duration;
                duration.setStartDelay(200L);
                this.x.addUpdateListener(new f(rectF, height, canvas, paint));
                this.x.addListener(new g());
                this.x.setRepeatMode(1);
                this.x.setRepeatCount(8);
                this.x.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public /* synthetic */ void X0(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        VDB vdb = this.f8809c;
        ((FragmentCameraWiredConnectingBinding) vdb).q.setTranslationY(((floatValue / 200.0f) * ((FragmentCameraWiredConnectingBinding) vdb).f6963c.getHeight()) + 8.0f);
        VDB vdb2 = this.f8809c;
        ((FragmentCameraWiredConnectingBinding) vdb2).x.setTranslationY((((-floatValue) / 200.0f) * ((FragmentCameraWiredConnectingBinding) vdb2).f6963c.getHeight()) - 8.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0 */
    public /* synthetic */ void Z0() {
        this.f8811f.e0("CameraResetFragment.TAG", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public /* synthetic */ void b1() {
        this.f8811f.e0("CameraConnectRouterFragment.TAG", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1 */
    public /* synthetic */ void d1(Boolean bool) throws Exception {
        CountDownTimer countDownTimer = this.p2;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1() {
        requireActivity().runOnUiThread(new Runnable() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.o1
            @Override // java.lang.Runnable
            public final void run() {
                CameraWiredConnectingFragment.this.Z0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1() {
        requireActivity().runOnUiThread(new Runnable() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.t1
            @Override // java.lang.Runnable
            public final void run() {
                CameraWiredConnectingFragment.this.b1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null) {
            if (bool.booleanValue()) {
                this.q.W();
                this.q.q2();
                CountDownTimer countDownTimer = this.p2;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                this.q.k2();
                this.q.d2();
                this.q.y();
                this.J3.postDelayed(new a(), 2000L);
                return;
            }
            com.tplink.iot.Utils.x0.f.F(this.q.B());
            this.q.q2();
            CountDownTimer countDownTimer2 = this.p2;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
            }
            s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void l1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null) {
            if (bool.booleanValue()) {
                this.q.H().removeObservers(this);
                R0();
                return;
            }
            this.f8811f.e0("CameraNotFoundFragment.TAG", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void n1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null) {
            b.d.w.c.a.c("CameraWiredConnectingFragment.TAG", "IsSameAccount = " + bool);
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_same_account", bool.booleanValue());
            this.f8811f.e0("CameraConfiguredBeforeFragment.TAG", bundle);
        }
    }

    private void o1() {
        this.I3 = false;
        ((FragmentCameraWiredConnectingBinding) this.f8809c).q.setVisibility(4);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).q.setTranslationY(0.0f);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).x.setVisibility(4);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).x.setTranslationY(0.0f);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).f6963c.setImageResource(R.color.transparent);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).f6963c.setVisibility(0);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).f6963c.setTranslationY(0.0f);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).f6963c.setAlpha(1.0f);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p1.setVisibility(0);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p1.setTranslationY(0.0f);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p0.setVisibility(0);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p0.setAlpha(1.0f);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).I3.setVisibility(0);
        ((FragmentCameraWiredConnectingBinding) this.f8809c).I3.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        P0();
        o1();
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p1.e();
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p2.e();
        this.q.O1().E(new io.reactivex.g0.g() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.u1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                CameraWiredConnectingFragment.this.d1((Boolean) obj);
            }
        }).F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        if (!this.q.h0()) {
            V0();
            this.q.W1();
        }
    }

    private void r1() {
        ((FragmentCameraWiredConnectingBinding) this.f8809c).p0.setImageResource(com.tplink.iot.view.ipcamera.base.c.e(this.q.D()));
    }

    private void s1() {
        if (isAdded()) {
            UniversalDialog l = new UniversalDialog.a().q(getString(R.string.camera_soft_ap_found_not_factory)).u(getString(R.string.go_to_reset)).s(getString(R.string.action_cancel)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.n1
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    CameraWiredConnectingFragment.this.f1();
                }
            }).r(new UniversalDialog.b() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.s1
                @Override // com.tplink.iot.widget.UniversalDialog.b
                public final void a() {
                    CameraWiredConnectingFragment.this.h1();
                }
            }).l();
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            beginTransaction.add(l, "");
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private void t1() {
        this.q.I().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.m1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraWiredConnectingFragment.this.j1((a) obj);
            }
        });
        this.q.H().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.r1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraWiredConnectingFragment.this.l1((a) obj);
            }
        });
        this.q.K().observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.q1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CameraWiredConnectingFragment.this.n1((a) obj);
            }
        });
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment
    public int A0() {
        return R.layout.fragment_camera_wired_connecting;
    }

    /* renamed from: S0 */
    public CameraWiredConnectingViewModel B0() {
        return (CameraWiredConnectingViewModel) ViewModelProviders.of(this).get(CameraWiredConnectingViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_close && isAdded()) {
            this.q.o2(20001);
        }
    }

    @Override // com.tplink.iot.view.ipcamera.onboardingv2.OnBoardingFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.q.q2();
        super.onDestroyView();
        this.J3.removeCallbacksAndMessages(null);
        P0();
        Q0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        r1();
        this.f8811f.q0();
        this.q.n2(10002);
        T0();
        t1();
    }
}
