package com.tplink.iot.view.group.device;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.o;
import com.tplink.iot.adapter.group.GroupAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.view.group.create.CreateGroupActivity;
import com.tplink.iot.viewmodel.group.GroupListViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShowGroupListActivity extends BaseActivity implements View.OnClickListener {
    private List<GroupInfo> H3;
    private TextView p0;
    private GroupListViewModel p1;
    private GroupAdapter p2;
    private String p3;
    private LinearLayout y;
    private LinearLayout z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements GroupAdapter.a {
        a() {
        }

        @Override // com.tplink.iot.adapter.group.GroupAdapter.a
        public void a(View view, GroupInfo groupInfo) {
            DeviceShowGroupListActivity.this.q1(groupInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<List<GroupInfo>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(List<GroupInfo> list) {
            DeviceShowGroupListActivity deviceShowGroupListActivity = DeviceShowGroupListActivity.this;
            deviceShowGroupListActivity.H3 = deviceShowGroupListActivity.p1.l(list, DeviceShowGroupListActivity.this.p3);
            if (DeviceShowGroupListActivity.this.s1()) {
                DeviceShowGroupListActivity.this.p0.setText(DeviceShowGroupListActivity.this.getString(R.string.device_group_list_add_to_group));
            } else {
                DeviceShowGroupListActivity.this.p0.setText(DeviceShowGroupListActivity.this.getString(R.string.device_group_list_add_a_group));
            }
            if (DeviceShowGroupListActivity.this.H3 == null || DeviceShowGroupListActivity.this.H3.isEmpty()) {
                DeviceShowGroupListActivity.this.v1();
                return;
            }
            DeviceShowGroupListActivity.this.p2.o(DeviceShowGroupListActivity.this.H3);
            DeviceShowGroupListActivity.this.w1();
        }
    }

    private void o1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.p3 = intent.getStringExtra(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID);
        }
    }

    private void p1() {
        if (s1()) {
            DeviceAddGroupListActivity.o1(this, this.p3);
        } else {
            CreateGroupActivity.l1(this, this.p3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(GroupInfo groupInfo) {
        o.e(this, groupInfo);
    }

    private void r1() {
        b1(R.string.groups);
        TextView textView = (TextView) findViewById(R.id.tv_add);
        this.p0 = textView;
        textView.setText(getString(R.string.device_group_list_add_a_group));
        this.p0.setOnClickListener(this);
        this.y = (LinearLayout) findViewById(R.id.ll_content);
        this.z = (LinearLayout) findViewById(R.id.ll_empty);
        this.p2 = new GroupAdapter(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_user);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.p2);
        this.p2.p(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s1() {
        return this.p1.m(this.p3);
    }

    public static void t1(Context context, String str) {
        Intent intent = new Intent(context, DeviceShowGroupListActivity.class);
        intent.putExtra(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID, str);
        context.startActivity(intent);
    }

    private void u1() {
        this.p1.k().observe(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        this.y.setVisibility(8);
        this.z.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        this.y.setVisibility(0);
        this.z.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_add) {
            p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tplink.iot.core.o.a() != 0) {
            setContentView(R.layout.activity_device_show_group_list);
            this.p1 = (GroupListViewModel) ViewModelProviders.of(this).get(GroupListViewModel.class);
            o1();
            r1();
            u1();
        }
    }
}
