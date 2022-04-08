package com.tplink.iot.view.group.info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.group.GroupRoomLocationAdapter;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.group.GroupLocationViewModel;
import java.util.List;

/* loaded from: classes2.dex */
public class GroupLocationSelectActivity extends BaseActivity {
    private GroupLocationViewModel H3;
    private MenuItem I3;
    private GroupRoomLocationAdapter J3;
    private List<RoomInfo> p1;
    private String p2;
    private String y;
    private String z;
    private boolean p0 = false;
    private int p3 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements f {
        a() {
        }

        @Override // com.tplink.iot.adapter.quicksetup.f
        public void a(View view, int i) {
            if (GroupLocationSelectActivity.this.p1 == null || GroupLocationSelectActivity.this.p1.isEmpty() || i >= GroupLocationSelectActivity.this.p1.size()) {
                GroupLocationSelectActivity.this.m1();
                return;
            }
            GroupLocationSelectActivity.this.p3 = i;
            if (GroupLocationSelectActivity.this.I3 != null) {
                GroupLocationSelectActivity.this.I3.setEnabled(GroupLocationSelectActivity.this.k1());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                s0.g();
                GroupLocationSelectActivity.this.r1();
                return;
            }
            s0.g();
            GroupLocationSelectActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k1() {
        List<RoomInfo> list = this.p1;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return TextUtils.isEmpty(this.p2) || this.p3 >= this.p1.size() || !this.p2.equals(this.p1.get(this.p3).getId());
    }

    private void l1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.y = intent.getStringExtra(FirebaseAnalytics.Param.GROUP_ID);
            this.z = intent.getStringExtra("room_id");
            this.p0 = !TextUtils.isEmpty(this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        if (this.J3.p() >= 32) {
            v1();
        } else {
            GroupLocationCustomActivity.p1(this, 111);
        }
    }

    private void n1() {
        List<RoomInfo> list;
        this.p1 = this.H3.j();
        if (this.p0) {
            this.p2 = this.H3.k(this.y);
        } else {
            this.p2 = this.z;
        }
        if (!(TextUtils.isEmpty(this.p2) || (list = this.p1) == null || list.isEmpty())) {
            for (int i = 0; i < this.p1.size(); i++) {
                if (this.p2.equals(this.p1.get(i).getId())) {
                    this.p3 = i;
                    return;
                }
            }
        }
    }

    private void o1() {
        b1(R.string.set_group_location);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GroupRoomLocationAdapter groupRoomLocationAdapter = new GroupRoomLocationAdapter(this, this.p1, this.p3);
        this.J3 = groupRoomLocationAdapter;
        recyclerView.setAdapter(groupRoomLocationAdapter);
        this.J3.q(new a());
    }

    public static void p1(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, GroupLocationSelectActivity.class);
        intent.putExtra("room_id", str);
        activity.startActivityForResult(intent, i);
    }

    public static void q1(Context context, String str) {
        Intent intent = new Intent(context, GroupLocationSelectActivity.class);
        intent.putExtra(FirebaseAnalytics.Param.GROUP_ID, str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1() {
        s0.p(this, getString(R.string.common_operation_failed));
    }

    private void s1() {
        if (this.p0) {
            u1();
        } else {
            t1();
        }
    }

    private void t1() {
        List<RoomInfo> list = this.p1;
        String name = list != null ? list.get(this.p3).getName() : null;
        String l = this.H3.l(name);
        Intent intent = getIntent();
        intent.putExtra("room_id", l);
        intent.putExtra("room_name", name);
        setResult(-1, intent);
        finish();
    }

    private void u1() {
        List<RoomInfo> list = this.p1;
        String name = list != null ? list.get(this.p3).getName() : null;
        s0.l(this);
        this.H3.n(this.y, name);
    }

    private void v1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.room_num_out_of_range, new Object[]{32})).o(R.string.action_got_it, R.color.common_iot_main_blue, null).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void w1() {
        this.H3.m().observe(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        List<RoomInfo> list;
        MenuItem menuItem;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 111 && intent != null) {
            String stringExtra = intent.getStringExtra("extra_new_custom_room_id");
            this.p1 = this.H3.j();
            this.J3.notifyDataSetChanged();
            if (!(TextUtils.isEmpty(stringExtra) || (list = this.p1) == null || list.isEmpty())) {
                for (int i3 = 0; i3 < this.p1.size(); i3++) {
                    if (stringExtra.equals(this.p1.get(i3).getId())) {
                        this.p3 = i3;
                        if (!TextUtils.equals(this.p2, stringExtra) && (menuItem = this.I3) != null) {
                            menuItem.setEnabled(k1());
                        }
                        this.J3.r(this.p3);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_group_location);
            this.H3 = (GroupLocationViewModel) ViewModelProviders.of(this).get(GroupLocationViewModel.class);
            l1();
            n1();
            o1();
            w1();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        MenuItem findItem = menu.findItem(R.id.common_save);
        this.I3 = findItem;
        findItem.setEnabled(k1());
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.common_save) {
            s1();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
