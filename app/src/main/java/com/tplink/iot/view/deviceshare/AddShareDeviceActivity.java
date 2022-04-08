package com.tplink.iot.view.deviceshare;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.adapter.deviceshare.DeviceShareUserRecordAdapter;
import com.tplink.iot.adapter.deviceshare.RecordUserBean;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.share.params.DeviceShareListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareParams;
import com.tplink.iot.core.o;
import com.tplink.iot.view.wss.WssAmazonInstrWebActivity;
import com.tplink.iot.viewmodel.deviceshare.DeviceShareViewModel;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.ListContentLongDialog;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class AddShareDeviceActivity extends BaseActivity implements View.OnClickListener {
    private DeviceShareViewModel H3;
    private Button p0;
    private View p1;
    private View y;
    private DrawableEditText z;
    private List<BaseALIoTDevice> p2 = new ArrayList();
    private List<TCDeviceUserInfoBean> p3 = new ArrayList();
    private List<BaseALIoTDevice> I3 = new ArrayList();
    private ViewTreeObserver.OnGlobalLayoutListener J3 = new a();

    /* loaded from: classes2.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (AddShareDeviceActivity.this.p1 != null) {
                AddShareDeviceActivity.this.p1.setVisibility(AddShareDeviceActivity.this.C1() ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TPMaterialDialogV2.d {
        b() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            AddShareDeviceActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements d0.g {
        c() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            WssAmazonInstrWebActivity.j1(AddShareDeviceActivity.this, "https://www.tp-link.com/en/support/faq/1439/");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements DeviceShareUserRecordAdapter.b {
        d() {
        }

        @Override // com.tplink.iot.adapter.deviceshare.DeviceShareUserRecordAdapter.b
        public void a(View view, int i) {
            AddShareDeviceActivity addShareDeviceActivity = AddShareDeviceActivity.this;
            addShareDeviceActivity.E1((TCDeviceUserInfoBean) addShareDeviceActivity.p3.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AddShareDeviceActivity.this.p0.setEnabled(AddShareDeviceActivity.this.N1());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Observer<com.tplink.iot.viewmodel.quicksetup.i<Void>> {
        f() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.iot.viewmodel.quicksetup.i<Void> iVar) {
            if (iVar == null || iVar.b() != 0) {
                AddShareDeviceActivity.this.s1();
            } else {
                AddShareDeviceActivity.this.u1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements Observer<List<BaseALIoTDevice>> {
        g() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            AddShareDeviceActivity.this.I3 = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements Observer<com.tplink.iot.viewmodel.quicksetup.i<Void>> {
        h() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.iot.viewmodel.quicksetup.i<Void> iVar) {
            s0.g();
            if (iVar == null || iVar.b() != 0) {
                q.i(iVar);
                AddShareDeviceActivity.this.I1(iVar);
                return;
            }
            q.j(AddShareDeviceActivity.this.p2);
            AddShareDeviceActivity.this.L1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements ListContentLongDialog.e {
        i() {
        }

        @Override // com.tplink.iot.widget.ListContentLongDialog.e
        public void dismiss() {
            AddShareDeviceActivity.this.W0(ShareDeviceActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements TPLongMaterialDialogV2.d {
        final /* synthetic */ BaseALIoTDevice a;

        j(BaseALIoTDevice baseALIoTDevice) {
            this.a = baseALIoTDevice;
        }

        @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
        public void onClick(View view) {
            AddShareDeviceActivity.this.y1(this.a);
        }
    }

    private void A1() {
        b1(R.string.share_device_share_device);
        ImageView imageView = (ImageView) findViewById(R.id.iv_plug);
        if (this.p2.size() == 1) {
            l.p(this, this.p2.get(0), imageView);
        } else if (this.p2.size() > 1) {
            imageView.setImageResource(R.mipmap.iot_devices_48);
        }
        this.p1 = findViewById(R.id.ll_record);
        Button button = (Button) findViewById(R.id.btn_bottom);
        this.p0 = button;
        button.setEnabled(false);
        this.p0.setOnClickListener(this);
        d0.h((TextView) findViewById(R.id.tv_bottom_tip), getString(R.string.what_is_tp_link_id), ContextCompat.getColor(this, R.color.common_iot_purple), new c());
        this.p3 = this.H3.z();
        DrawableEditText drawableEditText = (DrawableEditText) findViewById(R.id.edit_name);
        this.z = drawableEditText;
        drawableEditText.setThreshold(1);
        this.z.setAdapter(new com.tplink.iot.adapter.deviceshare.a(this, r1(this.p3), Arrays.asList(getResources().getStringArray(R.array.email))));
        z1();
        DeviceShareUserRecordAdapter deviceShareUserRecordAdapter = new DeviceShareUserRecordAdapter(this, this.p3);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(deviceShareUserRecordAdapter);
        deviceShareUserRecordAdapter.n(new d());
        if (this.p3.isEmpty()) {
            this.p1.setVisibility(8);
            this.z.getEditText().requestFocus();
            this.z.getEditText().setFocusable(true);
            this.z.getEditText().setFocusableInTouchMode(true);
            return;
        }
        this.p1.setVisibility(0);
    }

    private boolean B1() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return (getWindow().getDecorView().getHeight() * 2) / 3 > rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C1() {
        List<TCDeviceUserInfoBean> list;
        return !B1() && (list = this.p3) != null && !list.isEmpty();
    }

    public static void D1(Context context, List<BaseALIoTDevice> list) {
        Intent intent = new Intent(context, AddShareDeviceActivity.class);
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (BaseALIoTDevice baseALIoTDevice : list) {
                arrayList.add(baseALIoTDevice.getDeviceIdMD5());
            }
        }
        bundle.putSerializable("device_id_md5_list", arrayList);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(TCDeviceUserInfoBean tCDeviceUserInfoBean) {
        if (tCDeviceUserInfoBean.getCloudUserName() != null) {
            this.z.setText(tCDeviceUserInfoBean.getCloudUserName());
            this.z.setSelection(tCDeviceUserInfoBean.getCloudUserName().length());
        }
    }

    private void F1() {
        View findViewById = getWindow().getDecorView().findViewById(16908290);
        this.y = findViewById;
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(this.J3);
    }

    private void G1() {
        this.H3.D().observe(this, new f());
        this.H3.F().observe(this, new g());
        this.H3.G().observe(this, new h());
    }

    private void H1() {
        com.tplink.iot.view.quicksetup.base.d.I(this);
        String trim = this.z.getText().toString().trim();
        if (TextUtils.equals(trim, b.d.s.a.a.e())) {
            J1();
            return;
        }
        s0.l(this);
        DeviceShareListParams deviceShareListParams = new DeviceShareListParams();
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : this.p2) {
            DeviceShareParams deviceShareParams = new DeviceShareParams();
            if (baseALIoTDevice.getCloudIoTDevice() != null) {
                deviceShareParams.setThingName(baseALIoTDevice.getCloudIoTDevice().getDeviceId());
                deviceShareParams.setSubThing(baseALIoTDevice.isSubDevice());
                deviceShareParams.setDeviceType(baseALIoTDevice.getDeviceType());
            } else if (baseALIoTDevice.getThingDevice() != null) {
                deviceShareParams.setThingName(baseALIoTDevice.getThingDevice().getThingName());
                deviceShareParams.setSubThing(baseALIoTDevice.isSubDevice());
                deviceShareParams.setDeviceType(baseALIoTDevice.getDeviceType());
            }
            deviceShareParams.setAppCategory("TP-Link_Tapo");
            deviceShareParams.setSharerUserName(trim);
            deviceShareParams.setShareExpires(432000L);
            arrayList.add(deviceShareParams);
        }
        deviceShareListParams.setShareList(arrayList);
        this.H3.Q(deviceShareListParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1(com.tplink.iot.viewmodel.quicksetup.i<Void> iVar) {
        if (iVar == null) {
            s0.n(this, R.string.common_operation_failed);
            return;
        }
        int b2 = iVar.b();
        if (b2 == -20618) {
            s0.n(this, R.string.account_not_exist_tip);
        } else if (b2 != -20508) {
            s0.n(this, R.string.common_operation_failed);
        } else if (this.p2.size() == 1) {
            M1(this.p2.get(0));
        } else {
            t1();
        }
    }

    private void J1() {
        new TPMaterialDialogV3.Builder(this).f(getString(R.string.device_share_is_current_account_tips_dialog_content)).setCancelable(false).c(false).i(null, R.color.common_iot_light_black, null).j(R.string.action_got_it, R.color.common_iot_main_blue, null).create().show();
    }

    private void K1(List<BaseALIoTDevice> list) {
        u.v(this, list, new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1() {
        new TPMaterialDialogV2.Builder(this).setTitle(R.string.device_share_success_invitation_dialog_title).j(getString(R.string.device_share_success_invitation_dialog_content)).setCancelable(false).c(false).n(null, R.color.common_iot_light_black, null).o(R.string.action_got_it, R.color.common_iot_main_blue, new b()).g(8, 8).create().show();
    }

    private void M1(BaseALIoTDevice baseALIoTDevice) {
        u.w(this, baseALIoTDevice.getDeviceType(), new j(baseALIoTDevice));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N1() {
        return b.d.w.h.b.c(this.z.getText().toString().trim());
    }

    private List<RecordUserBean> r1(List<TCDeviceUserInfoBean> list) {
        ArrayList arrayList = new ArrayList();
        for (TCDeviceUserInfoBean tCDeviceUserInfoBean : list) {
            arrayList.add(new RecordUserBean(tCDeviceUserInfoBean.getCloudUserName(), tCDeviceUserInfoBean.getNickname()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1() {
        s0.n(this, R.string.common_operation_failed);
    }

    private void t1() {
        this.H3.C(this.p2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        List<BaseALIoTDevice> w1 = w1();
        if (w1 == null || w1.size() == 0) {
            s0.n(this, R.string.common_operation_failed);
        } else if (w1.size() == 1) {
            M1(w1.get(0));
        } else {
            K1(w1);
        }
    }

    private void v1() {
        Bundle extras;
        List<String> list;
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null || (list = (List) extras.getSerializable("device_id_md5_list")) == null || list.isEmpty())) {
            for (String str : list) {
                BaseALIoTDevice I1 = TPIoTClientManager.I1(str);
                if (I1 != null) {
                    this.p2.add(I1);
                }
            }
        }
    }

    private List<BaseALIoTDevice> w1() {
        ArrayList arrayList = new ArrayList();
        for (BaseALIoTDevice baseALIoTDevice : this.p2) {
            BaseALIoTDevice x1 = x1(baseALIoTDevice.getDeviceId());
            if (!(x1 == null || x1.getDeviceManagerInfo() == null || x1.getDeviceManagerInfo().getUserInfo() == null || x1.getDeviceManagerInfo().getUserInfo().size() <= a.d(x1.getDeviceType()))) {
                arrayList.add(x1);
            }
        }
        return arrayList;
    }

    private BaseALIoTDevice x1(String str) {
        List<BaseALIoTDevice> list;
        if (!TextUtils.isEmpty(str) && (list = this.I3) != null) {
            for (BaseALIoTDevice baseALIoTDevice : list) {
                if (!(baseALIoTDevice == null || baseALIoTDevice.getCloudIoTDevice() == null || !str.equals(baseALIoTDevice.getCloudIoTDevice().getDeviceId()))) {
                    return baseALIoTDevice;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(BaseALIoTDevice baseALIoTDevice) {
        ShareDeviceUserListActivity.v1(this, baseALIoTDevice.getDeviceIdMD5());
    }

    private void z1() {
        this.z.f(new e());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_bottom) {
            H1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_add_device_share);
            this.H3 = (DeviceShareViewModel) ViewModelProviders.of(this).get(DeviceShareViewModel.class);
            v1();
            A1();
            F1();
            G1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.tplink.iot.view.quicksetup.base.d.I(this);
        View view = this.y;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.J3);
        }
    }
}
