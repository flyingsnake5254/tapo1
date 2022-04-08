package com.tplink.iot.view.iotcommon;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.adapter.iot.IoTSettingAvatarAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.iot.d;
import com.tplink.iot.viewmodel.iotcommon.IoTSettingAvatarViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class IoTSettingAvatarActivity extends BaseActivity implements IoTSettingAvatarAdapter.d {
    private IoTSettingAvatarAdapter p0;
    private String p1;
    private MenuItem p2;
    private String p3;
    private IoTSettingAvatarViewModel y;
    private List<d> z = new ArrayList();

    private void e1() {
        b1(R.string.select_device_icon);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        this.p1 = this.y.g();
        boolean z = false;
        for (String str : this.y.h()) {
            d dVar = new d(str, false);
            if (!TextUtils.isEmpty(this.p1) && this.p1.equals(str)) {
                dVar.c(true);
                z = true;
            }
            this.z.add(dVar);
        }
        if (!z) {
            this.z.get(0).c(true);
        }
        IoTSettingAvatarAdapter ioTSettingAvatarAdapter = new IoTSettingAvatarAdapter(this.z, this.y.j(), this.y.i());
        this.p0 = ioTSettingAvatarAdapter;
        ioTSettingAvatarAdapter.u(this);
        recyclerView.setAdapter(this.p0);
    }

    private boolean f1() {
        return TextUtils.isEmpty(this.p1) || !this.p1.equals(this.p0.q());
    }

    @Override // com.tplink.iot.adapter.iot.IoTSettingAvatarAdapter.d
    public void e(int i) {
        this.p2.setEnabled(f1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_iot_setting_avatar);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.p3 = stringExtra;
        this.y = (IoTSettingAvatarViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(IoTSettingAvatarViewModel.class);
        e1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        MenuItem findItem = menu.findItem(R.id.common_save);
        this.p2 = findItem;
        findItem.setEnabled(f1());
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.common_save) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.y.k(this.p0.q());
        i.f(this.p3, this.p0.q());
        finish();
        return true;
    }
}
