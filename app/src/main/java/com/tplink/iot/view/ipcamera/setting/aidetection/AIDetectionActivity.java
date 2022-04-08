package com.tplink.iot.view.ipcamera.setting.aidetection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.core.o;
import com.tplink.iot.databinding.ActivityAiDetectionBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.tapocare.BillingDialogActivity;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.aidetection.AIDetectionViewModel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.EventObserver;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: AIDetectionActivity.kt */
/* loaded from: classes2.dex */
public final class AIDetectionActivity extends BaseActivity implements View.OnClickListener, SeekBarBindingAdapter.OnStopTrackingTouch {
    public static final a y = new a(null);
    private String H3;
    public AIDetectionViewModel p0;
    public CloudVideoViewModel p1;
    private ActivityAiDetectionBinding p2;
    private final String z = AIDetectionActivity.class.getSimpleName();
    private final io.reactivex.e0.b p3 = new io.reactivex.e0.b();
    private int I3 = 3;

    /* compiled from: AIDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIdMD5, int i) {
            j.e(context, "context");
            j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, AIDetectionActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            intent.putExtra("detection_home_mode", i);
            context.startActivity(intent);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AIDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (j.a(bool, Boolean.TRUE)) {
                AIDetectionActivity.this.l1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AIDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<String> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(String str) {
            if (str != null) {
                TSnackbar.y(AIDetectionActivity.this, str, -1).N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AIDetectionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<Boolean> {
        final /* synthetic */ AIDetectionViewModel a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AIDetectionActivity f9188b;

        d(AIDetectionViewModel aIDetectionViewModel, AIDetectionActivity aIDetectionActivity) {
            this.a = aIDetectionViewModel;
            this.f9188b = aIDetectionActivity;
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (j.a(bool, Boolean.TRUE)) {
                TrialDialogActivity.f1(this.f9188b, com.tplink.iot.Utils.v0.e.d(h.j(this.a.s())));
            }
        }
    }

    /* compiled from: AIDetectionActivity.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements com.tplink.libtpnetwork.Utils.f0.b<Boolean> {
        e() {
        }

        /* renamed from: b */
        public final void a(Boolean bool) {
            AIDetectionActivity.this.h1().L().setValue(bool);
        }
    }

    /* compiled from: AIDetectionActivity.kt */
    /* loaded from: classes2.dex */
    static final class f<T> implements io.reactivex.g0.g<Integer> {

        /* renamed from: c  reason: collision with root package name */
        public static final f f9189c = new f();

        f() {
        }

        public final void a(int i) {
        }

        @Override // io.reactivex.g0.g
        public /* bridge */ /* synthetic */ void accept(Integer num) {
            a(num.intValue());
        }
    }

    /* compiled from: AIDetectionActivity.kt */
    /* loaded from: classes2.dex */
    static final class g<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final g f9190c = new g();

        g() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            b.d.w.c.a.e("CameraSettingsActivity", Log.getStackTraceString(th));
        }
    }

    private final void f1(MutableLiveData<Boolean> mutableLiveData) {
        if (j.a(mutableLiveData.getValue(), Boolean.TRUE)) {
            AIDetectionViewModel aIDetectionViewModel = this.p0;
            if (aIDetectionViewModel == null) {
                j.t("mViewModel");
            }
            aIDetectionViewModel.O(mutableLiveData);
            return;
        }
        AIDetectionViewModel aIDetectionViewModel2 = this.p0;
        if (aIDetectionViewModel2 == null) {
            j.t("mViewModel");
        }
        aIDetectionViewModel2.l(mutableLiveData);
    }

    private final void i1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.H3 = stringExtra;
        this.I3 = getIntent().getIntExtra("detection_home_mode", 3);
        String str = this.H3;
        if (str == null) {
            j.t("deviceIdMD5");
        }
        ViewModel viewModel = ViewModelProviders.of(this, new CameraViewModelFactory(this, str)).get(AIDetectionViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(th…ionViewModel::class.java)");
        this.p0 = (AIDetectionViewModel) viewModel;
        ViewModel viewModel2 = ViewModelProviders.of(this).get(CloudVideoViewModel.class);
        j.d(viewModel2, "ViewModelProviders.of(th…deoViewModel::class.java)");
        this.p1 = (CloudVideoViewModel) viewModel2;
        AIDetectionViewModel aIDetectionViewModel = this.p0;
        if (aIDetectionViewModel == null) {
            j.t("mViewModel");
        }
        aIDetectionViewModel.F(this.I3);
    }

    private final void j1() {
        AIDetectionViewModel aIDetectionViewModel = this.p0;
        if (aIDetectionViewModel == null) {
            j.t("mViewModel");
        }
        aIDetectionViewModel.z().observe(this, new EventObserver(new b()));
        aIDetectionViewModel.v().observe(this, new EventObserver(new c()));
        aIDetectionViewModel.A().observe(this, new EventObserver(new d(aIDetectionViewModel, this)));
    }

    private final void k1() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_ai_detection);
        j.d(contentView, "DataBindingUtil.setConte…ut.activity_ai_detection)");
        ActivityAiDetectionBinding activityAiDetectionBinding = (ActivityAiDetectionBinding) contentView;
        this.p2 = activityAiDetectionBinding;
        if (activityAiDetectionBinding == null) {
            j.t("mDataBinding");
        }
        AIDetectionViewModel aIDetectionViewModel = this.p0;
        if (aIDetectionViewModel == null) {
            j.t("mViewModel");
        }
        activityAiDetectionBinding.l(aIDetectionViewModel);
        activityAiDetectionBinding.h(this);
        activityAiDetectionBinding.i(this);
        activityAiDetectionBinding.setLifecycleOwner(this);
        setTitle(R.string.ai_detection_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        CloudVideoViewModel cloudVideoViewModel = this.p1;
        if (cloudVideoViewModel == null) {
            j.t("mVideoCloudViewModel");
        }
        cloudVideoViewModel.N().observe(this, new Observer<List<? extends OrderInfo>>() { // from class: com.tplink.iot.view.ipcamera.setting.aidetection.AIDetectionActivity$observeOrders$1
            /* renamed from: a */
            public void onChanged(List<? extends OrderInfo> list) {
                AIDetectionActivity.this.g1().N().removeObserver(this);
                if (AIDetectionActivity.this.g1().H(list, "")) {
                    BillingDialogActivity.f1(AIDetectionActivity.this, e.x());
                    return;
                }
                AIDetectionActivity aIDetectionActivity = AIDetectionActivity.this;
                BillingDialogActivity.f1(aIDetectionActivity, e.c(h.j(aIDetectionActivity.h1().s())));
            }
        });
    }

    public final CloudVideoViewModel g1() {
        CloudVideoViewModel cloudVideoViewModel = this.p1;
        if (cloudVideoViewModel == null) {
            j.t("mVideoCloudViewModel");
        }
        return cloudVideoViewModel;
    }

    public final AIDetectionViewModel h1() {
        AIDetectionViewModel aIDetectionViewModel = this.p0;
        if (aIDetectionViewModel == null) {
            j.t("mViewModel");
        }
        return aIDetectionViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1345) {
            AIDetectionViewModel aIDetectionViewModel = this.p0;
            if (aIDetectionViewModel == null) {
                j.t("mViewModel");
            }
            this.p3.b(h.o(aIDetectionViewModel.s(), false, new e()).H0(f.f9189c, g.f9190c));
            com.tplink.iot.Utils.v0.b.a().b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view != null) {
            switch (view.getId()) {
                case R.id.baby_crying_detection_switch /* 2131361998 */:
                    AIDetectionViewModel aIDetectionViewModel = this.p0;
                    if (aIDetectionViewModel == null) {
                        j.t("mViewModel");
                    }
                    Integer value = aIDetectionViewModel.p().getValue();
                    AIDetectionViewModel aIDetectionViewModel2 = this.p0;
                    if (aIDetectionViewModel2 == null) {
                        j.t("mViewModel");
                    }
                    int w = aIDetectionViewModel2.w();
                    if (value != null && value.intValue() == w) {
                        str = "high";
                    } else {
                        AIDetectionViewModel aIDetectionViewModel3 = this.p0;
                        if (aIDetectionViewModel3 == null) {
                            j.t("mViewModel");
                        }
                        Integer value2 = aIDetectionViewModel3.p().getValue();
                        AIDetectionViewModel aIDetectionViewModel4 = this.p0;
                        if (aIDetectionViewModel4 == null) {
                            j.t("mViewModel");
                        }
                        str = (value2 != null && value2.intValue() == aIDetectionViewModel4.y()) ? "medium" : "low";
                    }
                    AIDetectionViewModel aIDetectionViewModel5 = this.p0;
                    if (aIDetectionViewModel5 == null) {
                        j.t("mViewModel");
                    }
                    String s = aIDetectionViewModel5.s();
                    AIDetectionViewModel aIDetectionViewModel6 = this.p0;
                    if (aIDetectionViewModel6 == null) {
                        j.t("mViewModel");
                    }
                    w.a(s, j.a(aIDetectionViewModel6.o().getValue(), Boolean.FALSE), str);
                    AIDetectionViewModel aIDetectionViewModel7 = this.p0;
                    if (aIDetectionViewModel7 == null) {
                        j.t("mViewModel");
                    }
                    f1(aIDetectionViewModel7.o());
                    return;
                case R.id.human_recognition_switch /* 2131362791 */:
                    AIDetectionViewModel aIDetectionViewModel8 = this.p0;
                    if (aIDetectionViewModel8 == null) {
                        j.t("mViewModel");
                    }
                    String s2 = aIDetectionViewModel8.s();
                    AIDetectionViewModel aIDetectionViewModel9 = this.p0;
                    if (aIDetectionViewModel9 == null) {
                        j.t("mViewModel");
                    }
                    w.A(s2, j.a(aIDetectionViewModel9.t().getValue(), Boolean.FALSE));
                    AIDetectionViewModel aIDetectionViewModel10 = this.p0;
                    if (aIDetectionViewModel10 == null) {
                        j.t("mViewModel");
                    }
                    f1(aIDetectionViewModel10.t());
                    return;
                case R.id.sensitivity_high_btn /* 2131364017 */:
                    AIDetectionViewModel aIDetectionViewModel11 = this.p0;
                    if (aIDetectionViewModel11 == null) {
                        j.t("mViewModel");
                    }
                    aIDetectionViewModel11.p().setValue(100);
                    AIDetectionViewModel aIDetectionViewModel12 = this.p0;
                    if (aIDetectionViewModel12 == null) {
                        j.t("mViewModel");
                    }
                    aIDetectionViewModel12.E();
                    return;
                case R.id.sensitivity_low_btn /* 2131364019 */:
                    AIDetectionViewModel aIDetectionViewModel13 = this.p0;
                    if (aIDetectionViewModel13 == null) {
                        j.t("mViewModel");
                    }
                    aIDetectionViewModel13.p().setValue(0);
                    AIDetectionViewModel aIDetectionViewModel14 = this.p0;
                    if (aIDetectionViewModel14 == null) {
                        j.t("mViewModel");
                    }
                    aIDetectionViewModel14.E();
                    return;
                case R.id.sensitivity_normal_btn /* 2131364020 */:
                    AIDetectionViewModel aIDetectionViewModel15 = this.p0;
                    if (aIDetectionViewModel15 == null) {
                        j.t("mViewModel");
                    }
                    aIDetectionViewModel15.p().setValue(50);
                    AIDetectionViewModel aIDetectionViewModel16 = this.p0;
                    if (aIDetectionViewModel16 == null) {
                        j.t("mViewModel");
                    }
                    aIDetectionViewModel16.E();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            i1();
            k1();
            j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.p3.d();
    }

    @Override // androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar != null) {
            int progress = seekBar.getProgress();
            AIDetectionViewModel aIDetectionViewModel = this.p0;
            if (aIDetectionViewModel == null) {
                j.t("mViewModel");
            }
            MutableLiveData<Integer> p = aIDetectionViewModel.p();
            int max = seekBar.getMax();
            double d2 = max;
            int i = (int) (0.75d * d2);
            kotlin.v.d dVar = new kotlin.v.d(i, max);
            kotlin.v.d dVar2 = new kotlin.v.d((int) (d2 * 0.25d), i);
            if (dVar.f(progress) && !com.tplink.libtpnetwork.Utils.j.b(p, Integer.valueOf(progress))) {
                p.setValue(Integer.valueOf(max));
            } else if (dVar2.f(progress) && !com.tplink.libtpnetwork.Utils.j.b(p, Integer.valueOf(progress))) {
                p.setValue(Integer.valueOf(max / 2));
            } else if (!com.tplink.libtpnetwork.Utils.j.b(p, Integer.valueOf(progress))) {
                p.setValue(0);
            }
            AIDetectionViewModel aIDetectionViewModel2 = this.p0;
            if (aIDetectionViewModel2 == null) {
                j.t("mViewModel");
            }
            aIDetectionViewModel2.E();
        }
    }
}
