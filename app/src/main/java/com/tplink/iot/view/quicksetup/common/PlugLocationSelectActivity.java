package com.tplink.iot.view.quicksetup.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.quicksetup.PlugLocationAdapter;
import com.tplink.iot.adapter.quicksetup.SelectLocationBean;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class PlugLocationSelectActivity extends BaseActivity implements View.OnClickListener {
    private EnumDeviceNicknameType p0;
    private QuickSetupInfoBean y;
    private QuickSetupDeviceInfoBean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements f {
        final /* synthetic */ ArrayList a;

        a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.tplink.iot.adapter.quicksetup.f
        public void a(View view, int i) {
            PlugLocationSelectActivity.this.p0 = ((SelectLocationBean) this.a.get(i)).getLocation();
            if (PlugLocationSelectActivity.this.p0 == null || PlugLocationSelectActivity.this.p0 == EnumDeviceNicknameType.CUSTOM) {
                PlugLocationSelectActivity.this.i1();
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
        d.C(this, PlugLocationCustomActivity.class, this.y, this.z);
    }

    private void j1(EnumDeviceNicknameType enumDeviceNicknameType) {
        this.z.setLocation(enumDeviceNicknameType.getName());
        d.C(this, PlugIconSelectActivity.class, this.y, this.z);
    }

    private void k1() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.device_place_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList arrayList = new ArrayList();
        for (EnumDeviceNicknameType enumDeviceNicknameType : EnumDeviceNicknameType.values()) {
            arrayList.add(new SelectLocationBean(enumDeviceNicknameType));
        }
        this.p0 = ((SelectLocationBean) arrayList.get(0)).getLocation();
        ((SelectLocationBean) arrayList.get(0)).setSelect(true);
        PlugLocationAdapter plugLocationAdapter = new PlugLocationAdapter(this, arrayList);
        recyclerView.setAdapter(plugLocationAdapter);
        plugLocationAdapter.o(new a(arrayList));
        ((Button) findViewById(R.id.btn_bottom)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            EnumDeviceNicknameType enumDeviceNicknameType = this.p0;
            if (enumDeviceNicknameType == null || enumDeviceNicknameType == EnumDeviceNicknameType.CUSTOM) {
                i1();
            } else {
                j1(enumDeviceNicknameType);
            }
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
            k1();
        }
    }
}
