package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightAdjustBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.LightFrequencyViewModel;
import com.tplink.libtpnetwork.cameranetwork.model.LightFrequencyMode;
import io.reactivex.e0.c;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class LightFrequencyActivity extends BaseActivity {
    private LightFrequencyMode p0;
    private c p1;
    private ActivityLightAdjustBinding y;
    private LightFrequencyViewModel z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LightFrequencyMode.values().length];
            a = iArr;
            try {
                iArr[LightFrequencyMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LightFrequencyMode.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LightFrequencyMode.FREQUENCY_50_HZ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LightFrequencyMode.FREQUENCY_60_HZ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void e1() {
        LightFrequencyMode lightFrequencyMode = this.z.f10755c.x().getLightFrequencyMode();
        this.p0 = lightFrequencyMode;
        if (lightFrequencyMode != null) {
            int i = a.a[lightFrequencyMode.ordinal()];
            if (i == 1) {
                this.y.f6581c.setClickable(false);
                this.y.x.check(R.id.auto);
            } else if (i == 3) {
                this.y.f6582d.setClickable(false);
                this.y.x.check(R.id.hz_50);
            } else if (i == 4) {
                this.y.f6583f.setClickable(false);
                this.y.x.check(R.id.hz_60);
            }
        }
    }

    private void f1() {
        this.y.f6581c.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LightFrequencyActivity.this.h1(view);
            }
        });
        this.y.f6582d.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LightFrequencyActivity.this.j1(view);
            }
        });
        this.y.f6583f.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LightFrequencyActivity.this.l1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1(View view) {
        t1(LightFrequencyMode.AUTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1(View view) {
        t1(LightFrequencyMode.FREQUENCY_50_HZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void l1(View view) {
        t1(LightFrequencyMode.FREQUENCY_60_HZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void n1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1 */
    public /* synthetic */ void p1(LightFrequencyMode lightFrequencyMode, Boolean bool) throws Exception {
        this.z.f10754b.set(false);
        this.z.f10755c.x().setLightFrequencyMode(lightFrequencyMode);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1 */
    public /* synthetic */ void r1(Throwable th) throws Exception {
        s1();
        this.z.f10754b.set(false);
        TSnackbar.x(this, R.string.general_failed, -1).N();
    }

    private void s1() {
        LightFrequencyMode lightFrequencyMode = this.p0;
        if (lightFrequencyMode != null) {
            int i = a.a[lightFrequencyMode.ordinal()];
            if (i == 1) {
                this.y.x.check(R.id.auto);
            } else if (i == 3) {
                this.y.x.check(R.id.hz_50);
            } else if (i == 4) {
                this.y.x.check(R.id.hz_60);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.y = (ActivityLightAdjustBinding) DataBindingUtil.setContentView(this, R.layout.activity_light_adjust);
        this.z = (LightFrequencyViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(LightFrequencyViewModel.class);
        this.y.y.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LightFrequencyActivity.this.n1(view);
            }
        });
        this.y.h(this.z);
        e1();
        f1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.p1;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public void t1(final LightFrequencyMode lightFrequencyMode) {
        this.z.f10754b.set(true);
        this.p1 = this.z.f10755c.B1(lightFrequencyMode.getRaw()).H0(new g() { // from class: com.tplink.iot.view.ipcamera.setting.e2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                LightFrequencyActivity.this.p1(lightFrequencyMode, (Boolean) obj);
            }
        }, new g() { // from class: com.tplink.iot.view.ipcamera.setting.d2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                LightFrequencyActivity.this.r1((Throwable) obj);
            }
        });
    }
}
