package com.tplink.iot.view.cloudvideo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseAdapter;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideoDevice;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.tapocare.BillingActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoDeviceListViewModel;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.enumerate.EnumDeviceStatus;
import com.tplink.libtpnetwork.enumerate.EnumUserRole;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: CloudVideoDeviceListActivity.kt */
/* loaded from: classes2.dex */
public final class CloudVideoDeviceListActivity extends BaseActivity implements BaseAdapter.a {
    private CloudVideoDeviceListViewModel p0;
    private HashMap p1;
    private BaseAdapter<CloudVideoDevice> y;
    private final ArrayList<CloudVideoDevice> z = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudVideoDeviceListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements Observer<Boolean> {
        a() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            j.d(it, "it");
            if (it.booleanValue()) {
                TextView iv_empty = (TextView) CloudVideoDeviceListActivity.this.e1(com.tplink.iot.a.iv_empty);
                j.d(iv_empty, "iv_empty");
                iv_empty.setVisibility(0);
                RecyclerView rv_device_list = (RecyclerView) CloudVideoDeviceListActivity.this.e1(com.tplink.iot.a.rv_device_list);
                j.d(rv_device_list, "rv_device_list");
                rv_device_list.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudVideoDeviceListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer<List<? extends CloudVideoDevice>> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(List<? extends CloudVideoDevice> it) {
            j.d(it, "it");
            if (!it.isEmpty()) {
                TextView iv_empty = (TextView) CloudVideoDeviceListActivity.this.e1(com.tplink.iot.a.iv_empty);
                j.d(iv_empty, "iv_empty");
                iv_empty.setVisibility(8);
                RecyclerView rv_device_list = (RecyclerView) CloudVideoDeviceListActivity.this.e1(com.tplink.iot.a.rv_device_list);
                j.d(rv_device_list, "rv_device_list");
                rv_device_list.setVisibility(0);
            } else {
                TextView iv_empty2 = (TextView) CloudVideoDeviceListActivity.this.e1(com.tplink.iot.a.iv_empty);
                j.d(iv_empty2, "iv_empty");
                iv_empty2.setVisibility(0);
            }
            CloudVideoDeviceListActivity.f1(CloudVideoDeviceListActivity.this).m(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudVideoDeviceListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (j.a(bool, Boolean.TRUE)) {
                if (!CloudVideoDeviceListActivity.this.isDestroyed()) {
                    s0.l(CloudVideoDeviceListActivity.this);
                }
            } else if (j.a(bool, Boolean.FALSE)) {
                s0.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudVideoDeviceListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            if (j.a(bool, Boolean.TRUE)) {
                TextView tv_confirm = (TextView) CloudVideoDeviceListActivity.this.e1(com.tplink.iot.a.tv_confirm);
                j.d(tv_confirm, "tv_confirm");
                tv_confirm.setVisibility(8);
                TextView iv_empty = (TextView) CloudVideoDeviceListActivity.this.e1(com.tplink.iot.a.iv_empty);
                j.d(iv_empty, "iv_empty");
                iv_empty.setText(CloudVideoDeviceListActivity.this.getString(R.string.tapo_care_cloud_videos_sub_tip));
            } else if (j.a(bool, Boolean.FALSE)) {
                TextView tv_confirm2 = (TextView) CloudVideoDeviceListActivity.this.e1(com.tplink.iot.a.tv_confirm);
                j.d(tv_confirm2, "tv_confirm");
                tv_confirm2.setVisibility(0);
                TextView iv_empty2 = (TextView) CloudVideoDeviceListActivity.this.e1(com.tplink.iot.a.iv_empty);
                j.d(iv_empty2, "iv_empty");
                iv_empty2.setText(CloudVideoDeviceListActivity.this.getString(R.string.tapo_care_cloud_videos_have_no_sub_tip));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudVideoDeviceListActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BillingActivity.f1(CloudVideoDeviceListActivity.this, com.tplink.iot.Utils.v0.e.f());
        }
    }

    public static final /* synthetic */ BaseAdapter f1(CloudVideoDeviceListActivity cloudVideoDeviceListActivity) {
        BaseAdapter<CloudVideoDevice> baseAdapter = cloudVideoDeviceListActivity.y;
        if (baseAdapter == null) {
            j.t("deviceListAdapter");
        }
        return baseAdapter;
    }

    private final void g1(CloudVideoDevice cloudVideoDevice) {
        TCDeviceBean tCDeviceBean = new TCDeviceBean();
        tCDeviceBean.setDeviceId(cloudVideoDevice.getDeviceId());
        tCDeviceBean.setDeviceType(cloudVideoDevice.getDeviceType());
        tCDeviceBean.setOemId(cloudVideoDevice.getOemId());
        tCDeviceBean.setDeviceHwVer(cloudVideoDevice.getHwVer());
        tCDeviceBean.setHwId(cloudVideoDevice.getHwId());
        tCDeviceBean.setStatus(cloudVideoDevice.getStatus() == 0 ? EnumDeviceStatus.STATUS_OFFLINE : EnumDeviceStatus.STATUS_ONLINE);
        tCDeviceBean.setAlias(cloudVideoDevice.getAlias());
        tCDeviceBean.setDeviceMac(cloudVideoDevice.getDeviceMac());
        tCDeviceBean.setDeviceModel(cloudVideoDevice.getDeviceModel());
        tCDeviceBean.setFwVer(String.valueOf(cloudVideoDevice.getFwVerNum()));
        tCDeviceBean.setAppServerUrl(cloudVideoDevice.getAppServerUrl());
        tCDeviceBean.setDeviceName(cloudVideoDevice.getDeviceName());
        tCDeviceBean.setRole(cloudVideoDevice.getRole() == 0 ? EnumUserRole.ROLE_OWNER : EnumUserRole.ROLE_USER);
        tCDeviceBean.setSameRegion(cloudVideoDevice.getSameRegion());
        ALCameraDevice aLCameraDevice = new ALCameraDevice();
        aLCameraDevice.setCloudIoTDevice(tCDeviceBean);
        Intent intent = new Intent(this, CloudVideoListActivity.class);
        intent.putExtra("cloud_video_device_id", aLCameraDevice.getDeviceId());
        intent.putExtra("cloud_video_open_from_me", true);
        intent.putExtra("cloud_video_device", aLCameraDevice);
        startActivity(intent);
    }

    private final void h1() {
        CloudVideoDeviceListViewModel cloudVideoDeviceListViewModel = this.p0;
        if (cloudVideoDeviceListViewModel == null) {
            j.t("cloudVideoDeviceListViewModel");
        }
        cloudVideoDeviceListViewModel.o();
        final ArrayList<CloudVideoDevice> arrayList = this.z;
        this.y = new BaseAdapter<CloudVideoDevice>(arrayList) { // from class: com.tplink.iot.view.cloudvideo.CloudVideoDeviceListActivity$initData$1
            @Override // com.tplink.iot.base.BaseAdapter
            public int o(int i) {
                return R.layout.layout_device_list_item;
            }

            /* renamed from: r */
            public void n(BaseAdapter.VH holder, CloudVideoDevice data, int i) {
                j.e(holder, "holder");
                j.e(data, "data");
                ((ImageView) holder.d(R.id.img_icon, null)).setBackgroundResource(c.f(DeviceModel.fromValue(data.getDeviceModel())));
                View d2 = holder.d(R.id.tv_name, null);
                j.d(d2, "holder.getView<TextView>(R.id.tv_name,null)");
                ((TextView) d2).setText(TextUtils.isEmpty(data.getAlias()) ? data.getDeviceModel() : data.getAlias());
                View d3 = holder.d(R.id.tv_location, null);
                j.d(d3, "holder.getView<TextView>(R.id.tv_location, null)");
                ((TextView) d3).setText(l.a(data.getDeviceMac()));
                holder.d(R.id.device_list_item, CloudVideoDeviceListActivity.this);
            }
        };
    }

    private final void i1() {
        CloudVideoDeviceListViewModel cloudVideoDeviceListViewModel = this.p0;
        if (cloudVideoDeviceListViewModel == null) {
            j.t("cloudVideoDeviceListViewModel");
        }
        cloudVideoDeviceListViewModel.p().observe(this, new a());
        CloudVideoDeviceListViewModel cloudVideoDeviceListViewModel2 = this.p0;
        if (cloudVideoDeviceListViewModel2 == null) {
            j.t("cloudVideoDeviceListViewModel");
        }
        cloudVideoDeviceListViewModel2.n().observe(this, new b());
        CloudVideoDeviceListViewModel cloudVideoDeviceListViewModel3 = this.p0;
        if (cloudVideoDeviceListViewModel3 == null) {
            j.t("cloudVideoDeviceListViewModel");
        }
        cloudVideoDeviceListViewModel3.r().observe(this, new c());
        CloudVideoDeviceListViewModel cloudVideoDeviceListViewModel4 = this.p0;
        if (cloudVideoDeviceListViewModel4 == null) {
            j.t("cloudVideoDeviceListViewModel");
        }
        cloudVideoDeviceListViewModel4.s().observe(this, new d());
    }

    private final void j1() {
        RecyclerView recyclerView = (RecyclerView) e1(com.tplink.iot.a.rv_device_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        BaseAdapter<CloudVideoDevice> baseAdapter = this.y;
        if (baseAdapter == null) {
            j.t("deviceListAdapter");
        }
        recyclerView.setAdapter(baseAdapter);
        ((TextView) e1(com.tplink.iot.a.tv_confirm)).setOnClickListener(new e());
    }

    @Override // com.tplink.iot.base.BaseAdapter.a
    public <T> void A0(int i, View v) {
        j.e(v, "v");
        BaseAdapter<CloudVideoDevice> baseAdapter = this.y;
        if (baseAdapter == null) {
            j.t("deviceListAdapter");
        }
        CloudVideoDevice item = baseAdapter.getItem(i);
        j.d(item, "deviceListAdapter.getItem(position)");
        g1(item);
    }

    public View e1(int i) {
        if (this.p1 == null) {
            this.p1 = new HashMap();
        }
        View view = (View) this.p1.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.p1.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1345 && i2 == -1) {
            CloudVideoDeviceListViewModel cloudVideoDeviceListViewModel = this.p0;
            if (cloudVideoDeviceListViewModel == null) {
                j.t("cloudVideoDeviceListViewModel");
            }
            cloudVideoDeviceListViewModel.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_device_list);
        c1(getString(R.string.cloud_videos));
        ViewModel viewModel = ViewModelProviders.of(this).get(CloudVideoDeviceListViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(th…istViewModel::class.java]");
        this.p0 = (CloudVideoDeviceListViewModel) viewModel;
        i1();
        h1();
        j1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (s0.j()) {
            s0.g();
        }
    }
}
