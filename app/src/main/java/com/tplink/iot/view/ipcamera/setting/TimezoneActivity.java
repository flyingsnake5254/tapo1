package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTimeZoneNewIpcBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.TimezoneViewModel;
import com.tplink.iot.widget.UniversalDialog;
import io.reactivex.e0.b;
import io.reactivex.l0.a;

/* loaded from: classes2.dex */
public class TimezoneActivity extends BaseActivity implements View.OnClickListener {
    private TimezoneViewModel p0;
    private b p1 = new b();
    private ActivityTimeZoneNewIpcBinding y;
    private TimezoneListAdapter z;

    private void e1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.y = (ActivityTimeZoneNewIpcBinding) DataBindingUtil.setContentView(this, R.layout.activity_time_zone_new_ipc);
        TimezoneViewModel timezoneViewModel = (TimezoneViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(TimezoneViewModel.class);
        this.p0 = timezoneViewModel;
        timezoneViewModel.h();
        this.y.h(this);
        this.y.i(this.p0);
        TimezoneListAdapter timezoneListAdapter = new TimezoneListAdapter();
        this.z = timezoneListAdapter;
        this.y.x.setAdapter(timezoneListAdapter);
        this.y.x.setLayoutManager(new LinearLayoutManager(this));
        TimezoneListAdapter timezoneListAdapter2 = this.z;
        TimezoneViewModel timezoneViewModel2 = this.p0;
        timezoneListAdapter2.r(timezoneViewModel2.f10835b, timezoneViewModel2.g());
        if (this.p0.g() != null) {
            TimezoneViewModel timezoneViewModel3 = this.p0;
            int indexOf = timezoneViewModel3.f10835b.indexOf(timezoneViewModel3.g());
            if (indexOf != -1) {
                this.y.x.scrollToPosition(indexOf);
            }
        }
        this.y.y.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.s4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimezoneActivity.this.g1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1 */
    public /* synthetic */ void g1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1 */
    public /* synthetic */ void i1() {
        this.p0.a.set(true);
        o1(this.z.m().c(), this.z.m().d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1 */
    public /* synthetic */ void k1(String str, String str2, Boolean bool) throws Exception {
        this.p0.i(str);
        this.p0.f().x().setTimezone(str2, str);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public /* synthetic */ void m1(Throwable th) throws Exception {
        this.p0.a.set(false);
        TSnackbar.x(this, R.string.general_failed, -1).N();
    }

    private void n1() {
        g.d(this.p0.f10836c);
    }

    public void o1(final String str, final String str2) {
        this.p1.b(this.p0.f().H1(str, str2).L0(a.c()).l0(io.reactivex.d0.b.a.a()).H0(new io.reactivex.g0.g() { // from class: com.tplink.iot.view.ipcamera.setting.u4
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                TimezoneActivity.this.k1(str2, str, (Boolean) obj);
            }
        }, new io.reactivex.g0.g() { // from class: com.tplink.iot.view.ipcamera.setting.r4
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                TimezoneActivity.this.m1((Throwable) obj);
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.save) {
            n1();
            new UniversalDialog.a().u(getString(R.string.onBoarding_change)).q(getString(R.string.setting_change_timezone_tip)).s(getString(R.string.action_cancel)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.t4
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    TimezoneActivity.this.i1();
                }
            }).l().show(getSupportFragmentManager(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        e1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.p1.d();
    }
}
