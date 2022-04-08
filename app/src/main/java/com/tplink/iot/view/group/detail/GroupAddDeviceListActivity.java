package com.tplink.iot.view.group.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.n;
import com.tplink.iot.adapter.group.DeviceAdapter;
import com.tplink.iot.adapter.group.EditDeviceAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.viewmodel.group.DeviceListViewModel;
import com.tplink.iot.viewmodel.home.t;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class GroupAddDeviceListActivity extends BaseActivity implements View.OnClickListener {
    private DeviceListViewModel H3;
    private String I3;
    private GroupInfo J3;
    private View p0;
    private View p1;
    private View p2;
    private View p3;
    private EditDeviceAdapter y;
    private DeviceAdapter z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements EditDeviceAdapter.a {
        final /* synthetic */ Button a;

        a(Button button) {
            this.a = button;
        }

        @Override // com.tplink.iot.adapter.group.EditDeviceAdapter.a
        public void b(int i) {
            this.a.setEnabled(i > 0);
        }

        @Override // com.tplink.iot.adapter.group.EditDeviceAdapter.a
        public void o() {
            GroupAddDeviceListActivity groupAddDeviceListActivity = GroupAddDeviceListActivity.this;
            s0.p(groupAddDeviceListActivity, groupAddDeviceListActivity.getString(R.string.group_devices_limit, new Object[]{"32"}));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<List<GroupInfo>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(List<GroupInfo> list) {
            GroupAddDeviceListActivity groupAddDeviceListActivity = GroupAddDeviceListActivity.this;
            groupAddDeviceListActivity.J3 = groupAddDeviceListActivity.m1(list);
            if (GroupAddDeviceListActivity.this.J3 == null) {
                GroupAddDeviceListActivity.this.u1();
            } else {
                GroupAddDeviceListActivity.this.o1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<Integer> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(Integer num) {
            s0.g();
            if (num == null) {
                return;
            }
            if (num.intValue() == 0) {
                GroupAddDeviceListActivity.this.finish();
                n.b();
            } else if (num.intValue() == 15017) {
                GroupAddDeviceListActivity.this.v1();
            } else {
                GroupAddDeviceListActivity.this.s1();
            }
        }
    }

    private void l1() {
        List<BaseALIoTDevice> r = this.y.r();
        if (!(r == null || r.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            for (BaseALIoTDevice baseALIoTDevice : r) {
                if (!(baseALIoTDevice == null || baseALIoTDevice.getDeviceId() == null)) {
                    arrayList.add(baseALIoTDevice.getDeviceId());
                }
            }
            GroupInfo groupInfo = this.J3;
            if (!(groupInfo == null || groupInfo.getThingNames() == null)) {
                for (String str : this.J3.getThingNames()) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                s0.l(this);
                this.H3.i(this.I3, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GroupInfo m1(List<GroupInfo> list) {
        for (GroupInfo groupInfo : list) {
            if (!(groupInfo == null || groupInfo.getId() == null || !groupInfo.getId().equals(this.I3))) {
                return groupInfo;
            }
        }
        return null;
    }

    private void n1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.I3 = intent.getStringExtra(FirebaseAnalytics.Param.GROUP_ID);
        }
        if (this.I3 == null) {
            this.I3 = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        List<BaseALIoTDevice> k = this.H3.k();
        if (k == null || k.isEmpty()) {
            u1();
            return;
        }
        List<String> thingNames = this.J3.getThingNames();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : k) {
            if (baseALIoTDevice != null && baseALIoTDevice.isBulb() && !baseALIoTDevice.isLightStrip() && q1(thingNames, baseALIoTDevice.getDeviceId())) {
                if (baseALIoTDevice.isSupportIoTCloud()) {
                    arrayList.add(baseALIoTDevice);
                } else {
                    arrayList2.add(baseALIoTDevice);
                }
            }
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            t1();
            if (arrayList.isEmpty()) {
                this.p1.setVisibility(8);
            } else {
                t.h(arrayList);
                this.y.t(arrayList, true, this.H3.n(this.J3));
                this.p1.setVisibility(0);
            }
            if (arrayList2.isEmpty()) {
                this.p2.setVisibility(8);
                return;
            }
            t.h(arrayList2);
            this.z.n(arrayList2);
            this.p2.setVisibility(0);
            return;
        }
        u1();
    }

    private void p1() {
        this.H3 = (DeviceListViewModel) ViewModelProviders.of(this).get(DeviceListViewModel.class);
        c1(getString(R.string.home_group_device_empty_add));
        Button button = (Button) findViewById(R.id.btn_bottom);
        button.setText(getString(R.string.common_save));
        button.setEnabled(false);
        button.setOnClickListener(this);
        this.p3 = findViewById(R.id.layout_empty);
        this.p0 = findViewById(R.id.layout_device);
        this.p1 = findViewById(R.id.layout_available_device);
        this.p2 = findViewById(R.id.layout_old_device);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        EditDeviceAdapter editDeviceAdapter = new EditDeviceAdapter(this);
        this.y = editDeviceAdapter;
        editDeviceAdapter.setHasStableIds(true);
        this.y.u(new a(button));
        recyclerView.setAdapter(this.y);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view_old_device);
        recyclerView2.setLayoutManager(new GridLayoutManager(this, 2));
        DeviceAdapter deviceAdapter = new DeviceAdapter(this);
        this.z = deviceAdapter;
        deviceAdapter.setHasStableIds(true);
        recyclerView2.setAdapter(this.z);
    }

    private boolean q1(List<String> list, String str) {
        return list == null || !list.contains(str);
    }

    public static void r1(Context context, String str) {
        Intent intent = new Intent(context, GroupAddDeviceListActivity.class);
        intent.putExtra(FirebaseAnalytics.Param.GROUP_ID, str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1() {
        s0.p(this, getString(R.string.common_operation_failed));
    }

    private void t1() {
        this.p3.setVisibility(8);
        this.p0.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        this.p3.setVisibility(0);
        this.p0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        s0.p(this, getString(R.string.group_devices_limit, new Object[]{"32"}));
    }

    private void w1() {
        this.H3.o().observe(this, new b());
        this.H3.j().observe(this, new c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_bottom) {
            l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_group_add_device_list);
        n1();
        p1();
        w1();
    }
}
