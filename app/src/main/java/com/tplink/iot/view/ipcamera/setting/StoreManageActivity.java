package com.tplink.iot.view.ipcamera.setting;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityStoreManageBinding;
import com.tplink.iot.databinding.DialogFormatProcessBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.wss.WssAmazonInstrWebActivity;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.StoreManageViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import io.reactivex.e0.b;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class StoreManageActivity extends BaseActivity implements View.OnClickListener {
    private a p0;
    private UniversalDialog p1;
    private UniversalDialog p2;
    private ActivityStoreManageBinding y;
    private StoreManageViewModel z;
    private boolean p3 = false;
    private b H3 = new b();

    /* loaded from: classes2.dex */
    public static class a extends DialogFragment {

        /* renamed from: c  reason: collision with root package name */
        private DialogFormatProcessBinding f9157c;

        /* renamed from: d  reason: collision with root package name */
        private StoreManageViewModel f9158d;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9159f = false;

        public void b(StoreManageViewModel storeManageViewModel) {
            this.f9158d = storeManageViewModel;
        }

        @Override // android.app.DialogFragment
        public void dismiss() {
            if (this.f9159f) {
                super.dismiss();
                this.f9159f = false;
            }
        }

        @Override // android.app.Fragment
        @Nullable
        public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
            DialogFormatProcessBinding dialogFormatProcessBinding = (DialogFormatProcessBinding) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_format_process, viewGroup, false);
            this.f9157c = dialogFormatProcessBinding;
            dialogFormatProcessBinding.h(this.f9158d);
            this.f9157c.f6771c.setProgressBarColor(getResources().getColor(R.color.common_iot_light_green));
            setCancelable(false);
            this.f9157c.f6771c.h();
            return this.f9157c.getRoot();
        }

        @Override // android.app.DialogFragment
        public void show(FragmentManager fragmentManager, String str) {
            if (!this.f9159f) {
                super.show(fragmentManager, str);
                this.f9159f = true;
            }
        }
    }

    private void A1() {
        if (this.p1 == null) {
            this.p1 = new UniversalDialog.a().u(getString(R.string.common_ok)).q(getString(R.string.setting_format_storage_success)).v(getResources().getColor(R.color.common_iot_main_blue)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.k4
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    StoreManageActivity.this.y1();
                }
            }).l();
        }
        if (!this.p3) {
            this.p3 = true;
            this.p1.show(getSupportFragmentManager(), "formatSuccessDialog");
        }
    }

    private void B1() {
        if (this.p0 == null) {
            this.p0 = new a();
        }
        if (!this.p0.f9159f) {
            this.p0.b(this.z);
            this.p0.show(getFragmentManager(), "");
        }
    }

    private void e1() {
        this.z.t.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.p4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StoreManageActivity.this.g1((Integer) obj);
            }
        });
        this.y.f6701f.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.n4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreManageActivity.this.i1(view);
            }
        });
        this.z.v.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.o4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StoreManageActivity.this.k1((a) obj);
            }
        });
        j.c(this.z.w, this, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.view.ipcamera.setting.m4
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                StoreManageActivity.this.m1((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1 */
    public /* synthetic */ void g1(Integer num) {
        if (num.intValue() != -1) {
            if (num.intValue() >= 100 && this.p0 != null) {
                this.z.l.set(false);
                this.H3.b(this.z.F().H0(new g() { // from class: com.tplink.iot.view.ipcamera.setting.j4
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        StoreManageActivity.this.o1((Boolean) obj);
                    }
                }, new g() { // from class: com.tplink.iot.view.ipcamera.setting.h4
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        StoreManageActivity.this.q1((Throwable) obj);
                    }
                }));
            } else if (num.intValue() < 100) {
                B1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1 */
    public /* synthetic */ void i1(View view) {
        this.z.H(this.y.f6701f.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1 */
    public /* synthetic */ void k1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        Boolean bool = (Boolean) aVar.a();
        if (bool != null && !bool.booleanValue()) {
            this.p0.dismiss();
            this.z.l.set(false);
            this.z.f();
            TSnackbar.y(this, getString(R.string.general_failed), -1).N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public /* synthetic */ void m1(String str) {
        TSnackbar.y(this, str, -1).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(Boolean bool) throws Exception {
        this.z.i();
        this.p0.dismiss();
        A1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public /* synthetic */ void q1(Throwable th) throws Exception {
        this.z.j.set(0);
        th.printStackTrace();
        this.p0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1 */
    public /* synthetic */ void s1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t1 */
    public /* synthetic */ void u1() {
        WssAmazonInstrWebActivity.j1(this, "https://www.tp-link.com/en/support/faq/2592/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v1 */
    public /* synthetic */ void w1() {
        this.z.g();
        B1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x1 */
    public /* synthetic */ void y1() {
        this.p3 = false;
    }

    private void z1() {
        if (this.p2 == null) {
            this.p2 = new UniversalDialog.a().q(getString(R.string.setting_format_storage_hint)).s(getString(R.string.action_cancel)).v(getResources().getColor(R.color.common_iot_red)).u(getString(R.string.device_setting_format)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.q4
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    StoreManageActivity.this.w1();
                }
            }).l();
        }
        this.p2.show(getSupportFragmentManager(), "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.format) {
            z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.y = (ActivityStoreManageBinding) DataBindingUtil.setContentView(this, R.layout.activity_store_manage);
        StoreManageViewModel storeManageViewModel = (StoreManageViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(StoreManageViewModel.class);
        this.z = storeManageViewModel;
        storeManageViewModel.G(getIntent().getStringExtra("device_id_md5"));
        this.y.i(this.z);
        this.y.h(this);
        this.y.y.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.l4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreManageActivity.this.s1(view);
            }
        });
        d0.h(this.y.z, getString(R.string.wss_function_learn_more), ContextCompat.getColor(this, R.color.common_iot_purple), new d0.g() { // from class: com.tplink.iot.view.ipcamera.setting.i4
            @Override // com.tplink.iot.Utils.d0.g
            public final void a() {
                StoreManageActivity.this.u1();
            }
        });
        this.z.i();
        e1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.z.f();
        this.H3.dispose();
        super.onDestroy();
    }
}
