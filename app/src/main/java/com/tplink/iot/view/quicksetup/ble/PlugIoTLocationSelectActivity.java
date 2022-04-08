package com.tplink.iot.view.quicksetup.ble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.f.b;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.adapter.quicksetup.RoomLocationAdapter;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.common.PlugIconSelectActivity;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import java.util.List;

/* loaded from: classes2.dex */
public class PlugIoTLocationSelectActivity extends BaseActivity implements View.OnClickListener {
    private String p0;
    private List<RoomInfo> p1;
    private QuickSetupInfoBean y;
    private QuickSetupDeviceInfoBean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements f {
        a() {
        }

        @Override // com.tplink.iot.adapter.quicksetup.f
        public void a(View view, int i) {
            if (PlugIoTLocationSelectActivity.this.p1 != null && !PlugIoTLocationSelectActivity.this.p1.isEmpty()) {
                if (i < PlugIoTLocationSelectActivity.this.p1.size()) {
                    PlugIoTLocationSelectActivity plugIoTLocationSelectActivity = PlugIoTLocationSelectActivity.this;
                    plugIoTLocationSelectActivity.p0 = ((RoomInfo) plugIoTLocationSelectActivity.p1.get(i)).getName();
                } else if (i == PlugIoTLocationSelectActivity.this.p1.size()) {
                    PlugIoTLocationSelectActivity.this.i1();
                }
            }
        }
    }

    private void h1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.y = (QuickSetupInfoBean) extras.getSerializable("device_info_bean");
            this.z = (QuickSetupDeviceInfoBean) extras.getSerializable("device_info");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        d.C(this, PlugIoTLocationCustomActivity.class, this.y, this.z);
    }

    private void j1(String str) {
        this.z.setLocation(str);
        d.C(this, PlugIconSelectActivity.class, this.y, this.z);
        m1(str);
    }

    private void k1() {
        TPIoTClientManager tPIoTClientManager = (TPIoTClientManager) b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
        List<RoomInfo> rooms = tPIoTClientManager.Q1() != null ? tPIoTClientManager.Q1().getRooms() : null;
        this.p1 = rooms;
        if (rooms != null && !rooms.isEmpty()) {
            this.p0 = this.p1.get(0).getName();
        }
    }

    private void l1() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.device_place_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        k1();
        RoomLocationAdapter roomLocationAdapter = new RoomLocationAdapter(this, this.p1, 0);
        recyclerView.setAdapter(roomLocationAdapter);
        roomLocationAdapter.q(new a());
        ((Button) findViewById(R.id.btn_bottom)).setOnClickListener(this);
    }

    private void m1(String str) {
        QuickSetupInfoBean quickSetupInfoBean = this.y;
        if (quickSetupInfoBean != null) {
            r.j(quickSetupInfoBean.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), str, false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            j1(this.p0);
        } else if (id == R.id.img_back) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_qs_plug_location_select);
            h1();
            l1();
        }
    }
}
