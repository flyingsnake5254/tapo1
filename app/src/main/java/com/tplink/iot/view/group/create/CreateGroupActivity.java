package com.tplink.iot.view.group.create;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.n;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.adapter.group.CreateEditDeviceAdapter;
import com.tplink.iot.adapter.group.DeviceAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.view.group.info.GroupAvatarActivity;
import com.tplink.iot.view.group.info.GroupLocationSelectActivity;
import com.tplink.iot.view.group.info.GroupNameActivity;
import com.tplink.iot.viewmodel.group.AllDeviceListViewModel;
import com.tplink.iot.viewmodel.home.t;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CreateGroupActivity extends BaseActivity implements CreateEditDeviceAdapter.a, View.OnClickListener {
    private DeviceAdapter H3;
    private AllDeviceListViewModel I3;
    private Button J3;
    private String K3;
    private GroupInfo L3;
    private ItemSettingLayout p0;
    private View p1;
    private CreateEditDeviceAdapter p2;
    private View p3;
    private ImageView y;
    private ItemSettingLayout z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<List<BaseALIoTDevice>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(List<BaseALIoTDevice> list) {
            CreateGroupActivity.this.j1(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Integer> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(Integer num) {
            s0.g();
            if (num.intValue() == 0) {
                CreateGroupActivity.this.finish();
                n.a();
            } else if (num.intValue() == 15016) {
                CreateGroupActivity.this.p1();
            } else {
                CreateGroupActivity.this.o1();
            }
        }
    }

    private boolean h1() {
        GroupInfo groupInfo = this.L3;
        return groupInfo != null && !TextUtils.isEmpty(groupInfo.getName()) && !TextUtils.isEmpty(this.L3.getAvatarUrl()) && !TextUtils.isEmpty(this.L3.getFamilyId()) && !TextUtils.isEmpty(this.L3.getRoomId());
    }

    private void i1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.K3 = intent.getStringExtra(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(List<BaseALIoTDevice> list) {
        if (list == null || list.isEmpty()) {
            this.p1.setVisibility(8);
            this.p3.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : list) {
            if (baseALIoTDevice != null && baseALIoTDevice.isBulb() && !baseALIoTDevice.isLightStrip()) {
                if (baseALIoTDevice.isSupportIoTCloud()) {
                    arrayList.add(baseALIoTDevice);
                } else {
                    arrayList2.add(baseALIoTDevice);
                }
            }
        }
        if (arrayList.isEmpty()) {
            this.p1.setVisibility(8);
        } else {
            t.h(arrayList);
            this.p2.r(arrayList);
            this.p1.setVisibility(0);
        }
        if (arrayList2.isEmpty()) {
            this.p3.setVisibility(8);
            return;
        }
        t.h(arrayList2);
        this.H3.n(arrayList2);
        this.p3.setVisibility(0);
    }

    private void k1() {
        this.I3 = (AllDeviceListViewModel) ViewModelProviders.of(this).get(AllDeviceListViewModel.class);
        b1(R.string.device_group_list_add_a_group);
        View findViewById = findViewById(R.id.item_avatar);
        this.z = (ItemSettingLayout) findViewById(R.id.item_name);
        this.p0 = (ItemSettingLayout) findViewById(R.id.item_location);
        this.y = (ImageView) findViewById(R.id.plug_avatar);
        GroupInfo groupInfo = new GroupInfo();
        this.L3 = groupInfo;
        groupInfo.setFamilyId(this.I3.l());
        this.L3.setCommon(Boolean.TRUE);
        String name = EnumBulbAvatarType.BULB.getName();
        this.L3.setAvatarUrl(name);
        this.y.setImageResource(g.d(EnumBulbAvatarType.fromString(name)));
        n1();
        findViewById.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.p0.setOnClickListener(this);
        Button button = (Button) findViewById(R.id.btn_bottom);
        this.J3 = button;
        button.setText(getString(R.string.common_save));
        this.J3.setOnClickListener(this);
        this.J3.setEnabled(false);
        this.p1 = findViewById(R.id.layout_available_device);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_available_device);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        CreateEditDeviceAdapter createEditDeviceAdapter = new CreateEditDeviceAdapter(this);
        this.p2 = createEditDeviceAdapter;
        createEditDeviceAdapter.t(this);
        this.p2.setHasStableIds(true);
        this.p2.s(this.K3);
        recyclerView.setAdapter(this.p2);
        this.p3 = findViewById(R.id.layout_old_device);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view_old_device);
        recyclerView2.setLayoutManager(new GridLayoutManager(this, 2));
        DeviceAdapter deviceAdapter = new DeviceAdapter(this);
        this.H3 = deviceAdapter;
        deviceAdapter.setHasStableIds(true);
        recyclerView2.setAdapter(this.H3);
    }

    public static void l1(Context context, String str) {
        Intent intent = new Intent(context, CreateGroupActivity.class);
        intent.putExtra(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID, str);
        context.startActivity(intent);
    }

    private void m1() {
        if (h1()) {
            s0.l(this);
            ArrayList arrayList = new ArrayList();
            List<BaseALIoTDevice> q = this.p2.q();
            if (q != null && !q.isEmpty()) {
                for (BaseALIoTDevice baseALIoTDevice : q) {
                    if (!TextUtils.isEmpty(baseALIoTDevice.getDeviceId())) {
                        arrayList.add(baseALIoTDevice.getDeviceId());
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                this.L3.setThingNames(arrayList);
            }
            this.I3.h(this.L3);
        }
    }

    private void n1() {
        BaseALIoTDevice j;
        String str = this.K3;
        if (str != null && (j = this.I3.j(str)) != null) {
            String familyId = j.getFamilyId();
            String roomId = j.getRoomId();
            if (!TextUtils.isEmpty(familyId) && !TextUtils.isEmpty(roomId)) {
                String f0 = ((FamilyManagerRepository) b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class)).f0(familyId, roomId);
                if (!TextUtils.isEmpty(f0)) {
                    this.L3.setFamilyId(familyId);
                    this.L3.setRoomId(roomId);
                    this.p0.setItemInfo(f0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        s0.p(this, getString(R.string.common_operation_failed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        s0.p(this, getString(R.string.groups_limit, new Object[]{"32"}));
    }

    private void q1() {
        this.I3.i().observe(this, new a());
        this.I3.k().observe(this, new b());
    }

    @Override // com.tplink.iot.adapter.group.CreateEditDeviceAdapter.a
    public void b(int i) {
    }

    @Override // com.tplink.iot.adapter.group.CreateEditDeviceAdapter.a
    public void o() {
        s0.p(this, getString(R.string.group_devices_limit, new Object[]{"32"}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i2 != -1) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        switch (i) {
            case 100:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("group_name");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        this.L3.setName(stringExtra);
                        this.z.setItemInfo(stringExtra);
                        break;
                    }
                }
                break;
            case 101:
                if (intent != null) {
                    String stringExtra2 = intent.getStringExtra("group_avatar");
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        this.L3.setAvatarUrl(stringExtra2);
                        this.y.setImageResource(g.d(EnumBulbAvatarType.fromString(stringExtra2)));
                        break;
                    }
                }
                break;
            case 102:
                if (intent != null) {
                    String stringExtra3 = intent.getStringExtra("room_id");
                    String stringExtra4 = intent.getStringExtra("room_name");
                    if (!TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(stringExtra4)) {
                        this.L3.setRoomId(stringExtra3);
                        this.p0.setItemInfo(stringExtra4);
                        break;
                    }
                }
                break;
        }
        Button button = this.J3;
        if (button != null) {
            button.setEnabled(h1());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_bottom /* 2131362037 */:
                m1();
                return;
            case R.id.item_avatar /* 2131362888 */:
                GroupAvatarActivity.i1(this, 101, this.L3.getAvatarUrl());
                return;
            case R.id.item_location /* 2131362930 */:
                GroupLocationSelectActivity.p1(this, 102, this.L3.getRoomId());
                return;
            case R.id.item_name /* 2131362936 */:
                GroupNameActivity.h1(this, 100, this.L3.getName());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_create_group);
        i1();
        k1();
        q1();
    }
}
