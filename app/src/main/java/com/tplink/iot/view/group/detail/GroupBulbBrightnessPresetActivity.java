package com.tplink.iot.view.group.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.iot.R;
import com.tplink.iot.adapter.iotbulb.BrightnessPresetAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.viewmodel.group.GroupSettingViewModel;
import com.tplink.libtpnetwork.Utils.g;
import java.util.List;

/* loaded from: classes2.dex */
public class GroupBulbBrightnessPresetActivity extends BaseActivity implements BrightnessPresetAdapter.f {
    private GroupSettingViewModel p0;
    private String y;
    private BrightnessPresetAdapter z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<List<GroupInfo>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(List<GroupInfo> list) {
            GroupInfo n = GroupBulbBrightnessPresetActivity.this.p0.n(list, GroupBulbBrightnessPresetActivity.this.y);
            if (n != null) {
                GroupBulbBrightnessPresetActivity.this.z.r(g.c(n));
                GroupBulbBrightnessPresetActivity groupBulbBrightnessPresetActivity = GroupBulbBrightnessPresetActivity.this;
                groupBulbBrightnessPresetActivity.c1(groupBulbBrightnessPresetActivity.i1(groupBulbBrightnessPresetActivity.z.p()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i1(int i) {
        return getString(R.string.bulb_settings_brightness_preset) + String.format("(%s/5)", String.valueOf(i));
    }

    public static void j1(Context context, String str) {
        Intent intent = new Intent(context, GroupBulbBrightnessPresetActivity.class);
        intent.putExtra(FirebaseAnalytics.Param.GROUP_ID, str);
        context.startActivity(intent);
    }

    private void k1() {
        this.p0.w(this.y, this.z.q());
    }

    private void l1() {
        this.p0.o().observe(this, new a());
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        k1();
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_group_bulb_brightness_preset);
        this.y = getIntent().getStringExtra(FirebaseAnalytics.Param.GROUP_ID);
        this.p0 = (GroupSettingViewModel) ViewModelProviders.of(this).get(GroupSettingViewModel.class);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BrightnessPresetAdapter brightnessPresetAdapter = new BrightnessPresetAdapter();
        this.z = brightnessPresetAdapter;
        brightnessPresetAdapter.s(this);
        c1(i1(this.z.p()));
        recyclerView.setAdapter(this.z);
        l1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            k1();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.tplink.iot.adapter.iotbulb.BrightnessPresetAdapter.f
    public void z(int i) {
        c1(i1(i));
    }
}
