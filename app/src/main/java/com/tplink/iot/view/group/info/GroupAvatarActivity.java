package com.tplink.iot.view.group.info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.iotbulb.BulbSettingAvatarAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.group.GroupSettingViewModel;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class GroupAvatarActivity extends BaseActivity implements BulbSettingAvatarAdapter.c {
    private String H3;
    private MenuItem I3;
    private GroupSettingViewModel p1;
    private BulbSettingAvatarAdapter p3;
    private String y;
    private String z;
    private boolean p0 = false;
    private List<com.tplink.iot.model.iot.a> p2 = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Boolean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                s0.g();
                GroupAvatarActivity.this.k1();
                return;
            }
            s0.g();
            GroupAvatarActivity.this.finish();
        }
    }

    private void f1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.y = intent.getStringExtra(FirebaseAnalytics.Param.GROUP_ID);
            this.z = intent.getStringExtra("group_avatar");
            this.p0 = !TextUtils.isEmpty(this.y);
        }
    }

    private void g1() {
        EnumBulbAvatarType[] values;
        b1(R.string.set_group_icon);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        if (this.p0) {
            this.H3 = this.p1.k(this.y);
        } else {
            this.H3 = this.z;
        }
        boolean z = false;
        for (EnumBulbAvatarType enumBulbAvatarType : EnumBulbAvatarType.values()) {
            com.tplink.iot.model.iot.a aVar = new com.tplink.iot.model.iot.a(enumBulbAvatarType, false);
            if (!TextUtils.isEmpty(this.H3) && enumBulbAvatarType == EnumBulbAvatarType.fromString(this.H3)) {
                aVar.c(true);
                z = true;
            }
            this.p2.add(aVar);
        }
        if (!z) {
            this.p2.get(0).c(true);
        }
        BulbSettingAvatarAdapter bulbSettingAvatarAdapter = new BulbSettingAvatarAdapter(this.p2);
        this.p3 = bulbSettingAvatarAdapter;
        bulbSettingAvatarAdapter.t(this);
        recyclerView.setAdapter(this.p3);
    }

    private boolean h1() {
        return TextUtils.isEmpty(this.H3) || !this.H3.equals(this.p3.p().getName());
    }

    public static void i1(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, GroupAvatarActivity.class);
        intent.putExtra("group_avatar", str);
        activity.startActivityForResult(intent, i);
    }

    public static void j1(Context context, String str) {
        Intent intent = new Intent(context, GroupAvatarActivity.class);
        intent.putExtra(FirebaseAnalytics.Param.GROUP_ID, str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        s0.p(this, getString(R.string.common_operation_failed));
    }

    private void l1() {
        if (this.p0) {
            n1();
        } else {
            m1();
        }
    }

    private void m1() {
        String name = this.p3.p().getName();
        Intent intent = getIntent();
        intent.putExtra("group_avatar", name);
        setResult(-1, intent);
        finish();
    }

    private void n1() {
        s0.l(this);
        this.p1.u(this.y, this.p3.p().getName());
    }

    private void o1() {
        this.p1.s().observe(this, new a());
    }

    @Override // com.tplink.iot.adapter.iotbulb.BulbSettingAvatarAdapter.c
    public void e(int i) {
        this.I3.setEnabled(h1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_group_avatar);
        this.p1 = (GroupSettingViewModel) ViewModelProviders.of(this).get(GroupSettingViewModel.class);
        f1();
        g1();
        o1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        MenuItem findItem = menu.findItem(R.id.common_save);
        this.I3 = findItem;
        findItem.setEnabled(h1());
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.common_save) {
            l1();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
