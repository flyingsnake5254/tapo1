package com.tplink.iot.view.iotplug.settings;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.adapter.iotplug.PlugSettingLocationAdapter;
import com.tplink.iot.adapter.quicksetup.SelectLocationBean;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.viewmodel.iotplug.PlugSettingLocationViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.Utils.v;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PlugSettingLocationActivity extends BaseActivity implements PlugSettingLocationAdapter.c {
    private String H3;
    private PlugSettingLocationAdapter p0;
    private String p1;
    private MenuItem p2;
    private int p3;
    private PlugSettingLocationViewModel y;
    private List<SelectLocationBean> z = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Integer> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
        }
    }

    private boolean e1() {
        String str;
        if (this.p3 < this.p0.getItemCount() - 1) {
            str = this.z.get(this.p3).getLocation().getName();
        } else {
            str = b.d.w.h.a.b(this.p0.n());
        }
        return !str.equals(this.p1);
    }

    private void f1() {
        b1(R.string.iot_location_title);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        int i = 0;
        for (EnumDeviceNicknameType enumDeviceNicknameType : EnumDeviceNicknameType.values()) {
            this.z.add(new SelectLocationBean(enumDeviceNicknameType));
        }
        PlugSettingLocationAdapter plugSettingLocationAdapter = new PlugSettingLocationAdapter(this.z);
        this.p0 = plugSettingLocationAdapter;
        plugSettingLocationAdapter.s(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.p0);
        this.p3 = -1;
        String g = this.y.g();
        this.p1 = g;
        if (TextUtils.isEmpty(g)) {
            this.p3 = 0;
        } else {
            while (true) {
                if (i >= this.z.size() - 1) {
                    break;
                } else if (this.z.get(i).getLocation().getName().equals(this.p1)) {
                    this.p3 = i;
                    break;
                } else {
                    i++;
                }
            }
        }
        if (this.p3 == -1) {
            this.p0.r(v.a(this.p1));
            this.p3 = this.p0.getItemCount() - 1;
        }
        this.p0.q(this.p3);
    }

    private void g1() {
        this.y.h().observe(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            String stringExtra = intent.getStringExtra("custom_location");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.p3 = this.p0.getItemCount() - 1;
                this.p0.r(stringExtra);
                this.p0.q(this.p3);
                this.p2.setEnabled(e1());
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_plug_setting_location);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.H3 = stringExtra;
        this.y = (PlugSettingLocationViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(PlugSettingLocationViewModel.class);
        f1();
        g1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        MenuItem findItem = menu.findItem(R.id.common_save);
        this.p2 = findItem;
        findItem.setEnabled(e1());
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str;
        if (menuItem.getItemId() == R.id.common_save) {
            if (this.p3 != this.p0.getItemCount() - 1) {
                str = this.z.get(this.p3).getLocation().getName();
                this.y.i(str);
            } else {
                str = this.p0.n();
                this.y.i(b.d.w.h.a.b(str));
            }
            i.g(this.H3, str);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.tplink.iot.adapter.iotplug.PlugSettingLocationAdapter.c
    public void r0(View.OnClickListener onClickListener, int i) {
        if (i == this.p0.getItemCount() - 1) {
            Intent intent = new Intent(this, PlugSettingLocationCustomActivity.class);
            if (this.p3 == this.p0.getItemCount() - 1) {
                intent.putExtra("old_custom_location", this.p0.n());
            }
            startActivityForResult(intent, 1);
            return;
        }
        this.p3 = i;
        this.p0.q(i);
        this.p2.setEnabled(e1());
    }
}
