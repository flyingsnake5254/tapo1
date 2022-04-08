package com.tplink.iot.view.iothub;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.home.HomeMainAdapter;
import com.tplink.iot.adapter.home.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.devices.switches.view.SwitchDetailActivity;
import com.tplink.iot.devices.trv.view.TRVDetailActivity;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.k;
import com.tplink.iot.view.iotsensor.SensorDetailActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.iothub.HubChildDeviceViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HubChildDeviceListActivity extends BaseActivity implements View.OnClickListener, h {
    private HubChildDeviceViewModel H3;
    private Toolbar I3;
    private String J3;
    private com.tplink.iot.devicecommon.feature.a K3;
    private TextView p0;
    private TextView p1;
    private RecyclerView p2;
    private HomeMainAdapter p3;
    private View y;
    private View z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TPLongMaterialDialogV2.d {
        a() {
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            HubChildDeviceListActivity.this.v1();
        }
    }

    private void f1() {
        int size = this.p3.n().size();
        this.I3.setNavigationIcon(R.mipmap.close);
        this.I3.setTitle(getResources().getString(R.string.home_toolbar_selected_with_number, Integer.valueOf(size)));
        this.p0.setVisibility(8);
        this.p1.setVisibility(0);
        w1(size);
    }

    private void g1() {
        this.I3.setNavigationIcon(R.mipmap.back);
        this.I3.setTitle(R.string.child_devices);
        this.p0.setVisibility(0);
        this.p1.setVisibility(8);
    }

    private void h1(@Nullable BaseALIoTDevice baseALIoTDevice) {
        if (baseALIoTDevice != null) {
            if (baseALIoTDevice.isSensor()) {
                SensorDetailActivity.D1(this, baseALIoTDevice.getDeviceIdMD5());
            } else if (baseALIoTDevice.isSwitch()) {
                SwitchDetailActivity.R1(this, baseALIoTDevice.getDeviceIdMD5());
            } else if (b.k(baseALIoTDevice)) {
                TRVDetailActivity.e2(this, baseALIoTDevice.getDeviceIdMD5());
            }
        }
    }

    private void i1(@Nullable BaseALIoTDevice baseALIoTDevice) {
        if (baseALIoTDevice != null) {
            if (baseALIoTDevice.isOnline()) {
                h1(baseALIoTDevice);
            } else if (baseALIoTDevice.isDeviceOffLine()) {
                u.j(this, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceModel(), baseALIoTDevice.getDeviceHwVer());
            }
        }
    }

    private void j1(@Nullable BaseALIoTDevice baseALIoTDevice, boolean z, int i) {
        if (baseALIoTDevice != null && !TextUtils.isEmpty(baseALIoTDevice.getDeviceIdMD5())) {
            this.H3.t(baseALIoTDevice, z);
            baseALIoTDevice.setDeviceOn(z);
            this.p3.notifyDataSetChanged();
        }
    }

    private void k1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.J3 = stringExtra;
        this.H3 = (HubChildDeviceViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(HubChildDeviceViewModel.class);
    }

    private void l1() {
        this.H3.h().observe(this, new Observer() { // from class: com.tplink.iot.view.iothub.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HubChildDeviceListActivity.this.o1((List) obj);
            }
        });
        this.H3.j().observe(this, new Observer() { // from class: com.tplink.iot.view.iothub.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HubChildDeviceListActivity.this.q1((Integer) obj);
            }
        });
        this.H3.i().observe(this, new Observer() { // from class: com.tplink.iot.view.iothub.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HubChildDeviceListActivity.this.s1((a) obj);
            }
        });
    }

    private void m1() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.I3 = toolbar;
        toolbar.setContentInsetStartWithNavigation(0);
        this.I3.setTitle(R.string.child_devices);
        setSupportActionBar(this.I3);
        this.y = findViewById(R.id.tv_empty_layout);
        this.z = findViewById(R.id.content_layout);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.p2 = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        this.p0 = (TextView) findViewById(R.id.tv_add_device);
        this.p1 = (TextView) findViewById(R.id.tv_delete);
        this.p0.setOnClickListener(this);
        this.p1.setOnClickListener(this);
        this.K3 = new com.tplink.iot.devicecommon.feature.a();
        HomeMainAdapter homeMainAdapter = new HomeMainAdapter(this, true);
        this.p3 = homeMainAdapter;
        homeMainAdapter.u(this);
        this.p3.setHasStableIds(true);
        this.p2.setAdapter(this.p3);
        i.g(this.p2);
        this.H3.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(List list) {
        if (list == null || list.isEmpty()) {
            this.p3.s(new ArrayList());
            this.y.setVisibility(0);
            this.z.setVisibility(8);
            return;
        }
        this.p3.s(list);
        this.y.setVisibility(8);
        this.z.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public /* synthetic */ void q1(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == -1) {
                s0.n(this, R.string.common_operation_failed);
            } else if (intValue == 0) {
                s0.l(this);
            } else if (intValue != 1) {
                s0.g();
            } else {
                s0.B(this, new s0.h() { // from class: com.tplink.iot.view.iothub.c
                    @Override // com.tplink.iot.Utils.s0.h
                    public final void onDismiss() {
                        HubChildDeviceListActivity.this.u1();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1 */
    public /* synthetic */ void s1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a aVar) {
        BaseALIoTDevice<?> baseALIoTDevice;
        if (aVar != null && (baseALIoTDevice = (BaseALIoTDevice) aVar.a()) != null) {
            this.K3.b(this, baseALIoTDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t1 */
    public /* synthetic */ void u1() {
        this.p3.c(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        BaseALIoTDevice g;
        List<e> n = this.p3.n();
        ArrayList arrayList = new ArrayList();
        for (e eVar : n) {
            if ((eVar instanceof k) && (g = ((k) eVar).g()) != null) {
                arrayList.add(g);
            }
        }
        this.H3.s(arrayList);
    }

    private void w1(int i) {
        if (i == 0) {
            this.p1.setEnabled(false);
            this.p1.setAlpha(0.5f);
            return;
        }
        this.p1.setEnabled(true);
        this.p1.setAlpha(1.0f);
    }

    private void x1() {
        new TPLongMaterialDialogV2.Builder(this).g(getString(R.string.remove_child_device_from_hub_tips)).i(R.string.common_cancel, R.color.common_iot_light_black, null).l(R.string.remove_device_from_group, R.color.common_iot_red, new a()).d(8, 8).setCancelable(false).c(false).create().show();
    }

    @Override // com.tplink.iot.adapter.home.h
    public void b(int i) {
        w1(i);
        if (this.p3.a()) {
            this.I3.setTitle(getResources().getString(R.string.home_toolbar_selected_with_number, Integer.valueOf(i)));
        }
    }

    @Override // com.tplink.iot.adapter.home.h
    public void f(int i, int i2) {
    }

    @Override // com.tplink.iot.adapter.home.h
    public void i(e eVar) {
        if (eVar instanceof k) {
            i1(((k) eVar).g());
        }
    }

    @Override // com.tplink.iot.adapter.home.h
    public void j(e eVar) {
        f1();
    }

    @Override // com.tplink.iot.adapter.home.h
    public void l(int i, e eVar, boolean z) {
        if (eVar instanceof k) {
            j1(((k) eVar).g(), z, i);
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.p3.a()) {
            this.p3.c(false);
            g1();
            return;
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_add_device) {
            X0(HubAddChildDeviceActivity.class, this.J3);
        } else if (id == R.id.tv_delete) {
            x1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_hub_child_device_list);
        k1();
        m1();
        l1();
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"NotifyDataSetChanged"})
    public void onResume() {
        super.onResume();
        this.p3.notifyDataSetChanged();
    }
}
