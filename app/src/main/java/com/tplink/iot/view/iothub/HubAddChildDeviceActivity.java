package com.tplink.iot.view.iothub;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.quicksetup.DeviceCategoryBean;
import com.tplink.iot.adapter.quicksetup.SelectCategoryNewAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.SubThingCategoryBean;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import com.tplink.iot.view.quicksetup.sub.SubGOnBoardingActivity;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.viewmodel.iothub.HubChildDeviceViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HubAddChildDeviceActivity extends BaseActivity {
    private HubChildDeviceViewModel p0;
    private RecyclerView y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements SelectCategoryNewAdapter.e {
        a() {
        }

        @Override // com.tplink.iot.adapter.quicksetup.SelectCategoryNewAdapter.e
        public void a(DeviceCategoryBean deviceCategoryBean) {
            HubAddChildDeviceActivity.this.f1(deviceCategoryBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1(final DeviceCategoryBean deviceCategoryBean) {
        if (this.p0.f()) {
            new TPMaterialDialogV2.Builder(this).setMessage(R.string.subg_qs_hub_reach_max_devices).o(R.string.common_ok, R.color.common_iot_main_blue, null).show();
            return;
        }
        s0.l(this);
        this.p0.g().l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.iot.view.iothub.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubAddChildDeviceActivity.this.m1(deviceCategoryBean, (Boolean) obj);
            }
        }).C(new g() { // from class: com.tplink.iot.view.iothub.b
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                HubAddChildDeviceActivity.this.o1((Throwable) obj);
            }
        }).F0();
    }

    private List<SubThingCategoryBean> g1() {
        return ((HubRepository) e.d(this.z, HubRepository.class)).s5().getValue();
    }

    private List<DeviceCategoryBean> h1() {
        List<SubThingCategoryBean> g1 = g1();
        ArrayList<String> arrayList = new ArrayList();
        if (g1 != null && !g1.isEmpty()) {
            for (SubThingCategoryBean subThingCategoryBean : g1) {
                arrayList.addAll(SubDeviceModel.getOrEmptyModelList(subThingCategoryBean.getCategory()));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            arrayList2.add(new DeviceCategoryBean(str));
        }
        return arrayList2;
    }

    private void i1(DeviceCategoryBean deviceCategoryBean) {
        if (!deviceCategoryBean.isCategory()) {
            SubGOnBoardingActivity.E1(this, this.z, deviceCategoryBean.getDevice());
        }
    }

    private void j1(boolean z, DeviceCategoryBean deviceCategoryBean) {
        if (z) {
            IoTFirmwareUpdateActivity.t1(this, this.z, true);
        } else {
            i1(deviceCategoryBean);
        }
    }

    private void k1() {
        c1("");
        List<DeviceCategoryBean> h1 = h1();
        this.y = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(1);
        this.y.setLayoutManager(gridLayoutManager);
        SelectCategoryNewAdapter selectCategoryNewAdapter = new SelectCategoryNewAdapter(this, h1);
        selectCategoryNewAdapter.q(new a());
        this.y.setAdapter(selectCategoryNewAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public /* synthetic */ void m1(DeviceCategoryBean deviceCategoryBean, Boolean bool) throws Exception {
        s0.g();
        j1(bool.booleanValue(), deviceCategoryBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(Throwable th) throws Exception {
        s0.g();
        s0.n(this, R.string.common_operation_failed);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_hub_add_child_device);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.z = stringExtra;
        this.p0 = (HubChildDeviceViewModel) new ViewModelProvider(this, new IoTViewModelFactory(this, stringExtra)).get(HubChildDeviceViewModel.class);
        k1();
    }
}
