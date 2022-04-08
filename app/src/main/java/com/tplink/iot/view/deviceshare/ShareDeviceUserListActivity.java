package com.tplink.iot.view.deviceshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.adapter.deviceshare.DeviceShareUserAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.deviceshare.DeviceShareViewModel;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumUserRole;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareDeviceUserListActivity extends BaseActivity implements View.OnClickListener {
    private MenuItem H3;
    private DeviceShareViewModel p0;
    private List<TCDeviceUserInfoBean> p1 = new ArrayList();
    private DeviceShareUserAdapter p2;
    private BaseALIoTDevice p3;
    private LinearLayout y;
    private LinearLayout z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DeviceShareUserAdapter.d {
        a() {
        }

        @Override // com.tplink.iot.adapter.deviceshare.DeviceShareUserAdapter.d
        public void a(View view, int i) {
            ShareDeviceUserListActivity shareDeviceUserListActivity = ShareDeviceUserListActivity.this;
            shareDeviceUserListActivity.p1((TCDeviceUserInfoBean) shareDeviceUserListActivity.p1.get(i));
        }

        @Override // com.tplink.iot.adapter.deviceshare.DeviceShareUserAdapter.d
        public void b(View view, int i) {
            ShareDeviceUserListActivity.this.D1(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TPMaterialDialogV2.d {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            ShareDeviceUserListActivity.this.z1(this.a);
            q.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TPMaterialDialogV2.d {
        c() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            ShareDeviceUserListActivity.this.y1();
            q.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<List<BaseALIoTDevice>> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            ShareDeviceUserListActivity.this.F1(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Observer<i<CloudResult<Void>>> {
        e() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<CloudResult<Void>> iVar) {
            s0.g();
            if (iVar == null || iVar.b() != 0) {
                ShareDeviceUserListActivity.this.w1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements TPMaterialDialogV2.d {
        f() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            ShareDeviceUserListActivity.this.o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements Comparator<TCDeviceUserInfoBean> {
        g() {
        }

        /* renamed from: a */
        public int compare(TCDeviceUserInfoBean tCDeviceUserInfoBean, TCDeviceUserInfoBean tCDeviceUserInfoBean2) {
            if (tCDeviceUserInfoBean == null) {
                return 1;
            }
            String c2 = a.c(tCDeviceUserInfoBean);
            if (TextUtils.isEmpty(c2)) {
                return 1;
            }
            if (tCDeviceUserInfoBean2 == null) {
                return -1;
            }
            String c3 = a.c(tCDeviceUserInfoBean2);
            if (TextUtils.isEmpty(c3)) {
                return -1;
            }
            return c2.compareToIgnoreCase(c3);
        }
    }

    private void A1() {
        this.p0.F().observe(this, new d());
        this.p0.I().observe(this, new e());
    }

    private void B1() {
        BaseALIoTDevice baseALIoTDevice = this.p3;
        if (baseALIoTDevice != null) {
            if (baseALIoTDevice.isCamera()) {
                u.h(this, new f());
            } else {
                o1();
            }
        }
    }

    private void C1() {
        TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this);
        builder.setMessage(R.string.share_device_share_device_clear_all);
        builder.c(false);
        builder.setCancelable(false);
        builder.o(R.string.share_device_share_device_clear, R.color.common_iot_red, new c());
        builder.l(R.string.common_cancel, R.color.common_iot_light_black, null);
        builder.g(8, 8);
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1(int i) {
        TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this);
        builder.setMessage(R.string.share_device_share_device_delete);
        builder.c(false);
        builder.setCancelable(false);
        builder.o(R.string.delete, R.color.common_iot_red, new b(i));
        builder.l(R.string.common_cancel, R.color.common_iot_light_black, null);
        builder.g(8, 8);
        builder.create().show();
    }

    private void E1() {
        Collections.sort(this.p1, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1(List<BaseALIoTDevice> list) {
        BaseALIoTDevice baseALIoTDevice;
        if (list != null && !list.isEmpty() && (baseALIoTDevice = this.p3) != null && baseALIoTDevice.isHasThingOrCloudDevice()) {
            Iterator<BaseALIoTDevice> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BaseALIoTDevice next = it.next();
                if (next.isHasThingOrCloudDevice() && !TextUtils.isEmpty(next.getDeviceId()) && next.getDeviceId().equals(this.p3.getDeviceId())) {
                    this.p3 = next;
                    s1();
                    break;
                }
            }
        }
        G1();
    }

    private void G1() {
        q1();
        r1();
        if (this.p1.isEmpty()) {
            this.y.setVisibility(8);
            this.z.setVisibility(0);
            return;
        }
        this.y.setVisibility(0);
        this.z.setVisibility(8);
        this.p2.notifyDataSetChanged();
    }

    private String m1() {
        BaseALIoTDevice baseALIoTDevice = this.p3;
        if (baseALIoTDevice != null) {
            return baseALIoTDevice.getDeviceType();
        }
        return null;
    }

    private void n1() {
        BaseALIoTDevice I1;
        Intent intent = getIntent();
        if (intent != null && (I1 = TPIoTClientManager.I1(intent.getStringExtra("device_id_md5"))) != null) {
            this.p3 = I1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.p3);
        AddShareDeviceActivity.D1(this, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(TCDeviceUserInfoBean tCDeviceUserInfoBean) {
        ShareDeviceUserDetailActivity.j1(this, this.p3.getDeviceId(), tCDeviceUserInfoBean, this.p3.isSubDevice());
    }

    private void q1() {
        MenuItem menuItem = this.H3;
        if (menuItem != null) {
            List<TCDeviceUserInfoBean> list = this.p1;
            menuItem.setEnabled(list != null && !list.isEmpty());
        }
    }

    private void r1() {
        BaseALIoTDevice baseALIoTDevice = this.p3;
        if (baseALIoTDevice != null) {
            c1(l.e(this, baseALIoTDevice.getDeviceType(), this.p3.getDeviceName(), this.p3.getDeviceModel()));
        } else {
            b1(R.string.share_device_share_devices);
        }
    }

    private void s1() {
        List<TCDeviceUserInfoBean> userInfo = this.p3.getDeviceManagerInfo() != null ? this.p3.getDeviceManagerInfo().getUserInfo() : null;
        if (!(userInfo == null || userInfo.isEmpty())) {
            this.p1.clear();
            for (TCDeviceUserInfoBean tCDeviceUserInfoBean : userInfo) {
                if (tCDeviceUserInfoBean != null && tCDeviceUserInfoBean.getRole() == EnumUserRole.ROLE_USER) {
                    this.p1.add(tCDeviceUserInfoBean);
                }
            }
            E1();
            this.p0.Z(this.p1);
            this.p0.Y(this.p1);
        }
    }

    private void t1() {
        r1();
        this.y = (LinearLayout) findViewById(R.id.ll_content);
        this.z = (LinearLayout) findViewById(R.id.ll_empty);
        findViewById(R.id.tv_device_share).setOnClickListener(this);
        E1();
        this.p2 = new DeviceShareUserAdapter(this, this.p1);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.p2);
        this.p2.o(new a());
    }

    private boolean u1() {
        return this.p1.size() >= a.d(m1());
    }

    public static void v1(Context context, String str) {
        Intent intent = new Intent(context, ShareDeviceUserListActivity.class);
        intent.putExtra("device_id_md5", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        s0.p(this, getString(R.string.common_operation_failed));
    }

    private void x1(List<String> list) {
        s0.l(this);
        this.p0.S(this.p3.getDeviceId(), list, this.p3.isSubDevice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1() {
        ArrayList arrayList = new ArrayList();
        for (TCDeviceUserInfoBean tCDeviceUserInfoBean : this.p1) {
            arrayList.add(tCDeviceUserInfoBean.getCloudUserName());
        }
        x1(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.p1.get(i).getCloudUserName());
        x1(arrayList);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_device_share) {
            if (u1()) {
                s0.p(this, a.a(this, m1()));
            } else {
                B1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_device_share_user_list);
            this.p0 = (DeviceShareViewModel) ViewModelProviders.of(this).get(DeviceShareViewModel.class);
            n1();
            t1();
            A1();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_device_share_user_list, menu);
        this.H3 = menu.findItem(R.id.action_clear_all);
        q1();
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_clear_all) {
            C1();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BaseALIoTDevice baseALIoTDevice = this.p3;
        if (baseALIoTDevice != null && baseALIoTDevice.isHasThingOrCloudDevice()) {
            this.p0.A(this.p3.getDeviceId(), this.p3.isSubDevice());
        }
    }
}
