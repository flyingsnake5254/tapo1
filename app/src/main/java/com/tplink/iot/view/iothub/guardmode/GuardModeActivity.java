package com.tplink.iot.view.iothub.guardmode;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.Utils.h0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.databinding.ActivityGuardModeBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.viewmodel.iothub.guardmode.GuardModeViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: GuardModeActivity.kt */
/* loaded from: classes2.dex */
public final class GuardModeActivity extends IoTMVVMBaseActivity<ActivityGuardModeBinding> {
    private final kotlin.f p0;
    private final kotlin.f p1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GuardModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        a() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            GuardModeActivity.this.r1().i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GuardModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements io.reactivex.g0.g<Throwable> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: GuardModeActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a implements s0.h {
            a() {
            }

            @Override // com.tplink.iot.Utils.s0.h
            public final void onDismiss() {
                GuardModeActivity.this.finish();
            }
        }

        b() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            GuardModeActivity.this.r1().c();
            s0.o(GuardModeActivity.this, R.string.common_operation_failed, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GuardModeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements io.reactivex.g0.a {
        c() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            GuardModeActivity.this.r1().c();
        }
    }

    /* compiled from: GuardModeActivity.kt */
    /* loaded from: classes2.dex */
    static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuardModeActivity.this.t1(EnumGuardMode.HOME.getValue());
        }
    }

    /* compiled from: GuardModeActivity.kt */
    /* loaded from: classes2.dex */
    static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuardModeActivity.this.t1(EnumGuardMode.AWAY.getValue());
        }
    }

    /* compiled from: GuardModeActivity.kt */
    /* loaded from: classes2.dex */
    static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuardModeActivity.this.t1(EnumGuardMode.SLEEP.getValue());
        }
    }

    /* compiled from: GuardModeActivity.kt */
    /* loaded from: classes2.dex */
    static final class g extends Lambda implements kotlin.jvm.b.a<h0> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: GuardModeActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a implements DialogInterface.OnCancelListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                GuardModeActivity.this.finish();
            }
        }

        g() {
            super(0);
        }

        /* renamed from: a */
        public final h0 invoke() {
            h0 h0Var = new h0(GuardModeActivity.this);
            Dialog e2 = h0Var.e();
            if (e2 != null) {
                e2.setCancelable(true);
                e2.setCanceledOnTouchOutside(false);
                e2.setOnCancelListener(new a());
            }
            return h0Var;
        }
    }

    /* compiled from: GuardModeActivity.kt */
    /* loaded from: classes2.dex */
    static final class h extends Lambda implements kotlin.jvm.b.a<GuardModeViewModel> {
        h() {
            super(0);
        }

        /* renamed from: a */
        public final GuardModeViewModel invoke() {
            GuardModeActivity guardModeActivity = GuardModeActivity.this;
            ViewModel viewModel = new ViewModelProvider(guardModeActivity, new IoTViewModelFactory(guardModeActivity, guardModeActivity.g1())).get(GuardModeViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …odeViewModel::class.java)");
            return (GuardModeViewModel) viewModel;
        }
    }

    public GuardModeActivity() {
        kotlin.f b2;
        kotlin.f b3;
        b2 = i.b(new h());
        this.p0 = b2;
        b3 = i.b(new g());
        this.p1 = b3;
    }

    private final void q1() {
        s1().f().l0(io.reactivex.d0.b.a.a()).F(new a()).C(new b()).z(new c()).F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h0 r1() {
        return (h0) this.p1.getValue();
    }

    private final GuardModeViewModel s1() {
        return (GuardModeViewModel) this.p0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(String str) {
        startActivity(GuardModeConfigActivity.y.a(this, str, g1()));
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_guard_mode;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.guard_mode_settings);
        ActivityGuardModeBinding f1 = f1();
        f1.x.setOnClickListener(new d());
        f1.q.setOnClickListener(new e());
        f1.y.setOnClickListener(new f());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity, com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q1();
        s1().g();
    }
}
