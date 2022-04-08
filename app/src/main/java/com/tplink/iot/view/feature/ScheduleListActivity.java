package com.tplink.iot.view.feature;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.adapter.feature.ScheduleAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.devices.trv.view.TRVEarlyStartActivity;
import com.tplink.iot.viewmodel.iotcommon.feature.ScheduleViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.g;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ScheduleRuleBean;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public class ScheduleListActivity extends BaseActivity implements ScheduleAdapter.f {
    private ScheduleAdapter H3;
    private ScheduleViewModel I3;
    private boolean J3;
    private Comparator<ScheduleRuleBean> K3 = new e();
    private PullToRefreshContainer p0;
    private MenuItem p1;
    private String p2;
    private boolean p3;
    private View y;
    private RecyclerView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<List<ScheduleRuleBean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<ScheduleRuleBean> list) {
            ScheduleListActivity.this.p0.A();
            int i = 0;
            if (list == null || list.isEmpty()) {
                ScheduleListActivity.this.y.setVisibility(0);
                ScheduleListActivity.this.z.setVisibility(8);
            } else {
                ScheduleListActivity.this.y.setVisibility(8);
                ScheduleListActivity.this.z.setVisibility(0);
                ScheduleListActivity.this.p1(list);
                i = list.size();
            }
            i.z(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                ScheduleListActivity.this.p0.A();
                s0.n(ScheduleListActivity.this, R.string.common_operation_failed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<com.tplink.iot.viewmodel.quicksetup.i<ScheduleRuleBean>> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(com.tplink.iot.viewmodel.quicksetup.i<ScheduleRuleBean> iVar) {
            ScheduleRuleBean a;
            if (iVar != null && iVar.b() != 0 && (a = iVar.a()) != null) {
                a.setDeleting(false);
                ScheduleListActivity.this.H3.notifyDataSetChanged();
                if (iVar.b() == -1012) {
                    w.f();
                } else {
                    s0.n(ScheduleListActivity.this, R.string.common_operation_failed);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements PullToRefreshContainer.e {
        d() {
        }

        @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e
        public void a() {
        }

        @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e
        public void onRefresh() {
            ScheduleListActivity.this.I3.G();
        }
    }

    /* loaded from: classes2.dex */
    class e implements Comparator<ScheduleRuleBean> {
        e() {
        }

        /* renamed from: a */
        public int compare(ScheduleRuleBean scheduleRuleBean, ScheduleRuleBean scheduleRuleBean2) {
            return ScheduleListActivity.this.I3.u(scheduleRuleBean.getStartTimeMin()) - ScheduleListActivity.this.I3.u(scheduleRuleBean2.getStartTimeMin());
        }
    }

    private void k1() {
        boolean z = false;
        boolean booleanExtra = getIntent().getBooleanExtra("is_color_bulb", false);
        ScheduleViewModel scheduleViewModel = this.I3;
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this, scheduleViewModel.s, booleanExtra, scheduleViewModel.E(), this.I3.t());
        this.H3 = scheduleAdapter;
        scheduleAdapter.s(this);
        this.z.setLayoutManager(new LinearLayoutManager(this));
        this.z.setAdapter(this.H3);
        ScheduleViewModel scheduleViewModel2 = this.I3;
        if (scheduleViewModel2.p && scheduleViewModel2.q) {
            z = true;
        }
        this.J3 = z;
    }

    private void l1() {
        c1(getString(R.string.plug_schedule));
        this.y = findViewById(R.id.view_empty);
        this.z = (RecyclerView) findViewById(R.id.recycler_view);
        PullToRefreshContainer pullToRefreshContainer = (PullToRefreshContainer) findViewById(R.id.refresh_layout);
        this.p0 = pullToRefreshContainer;
        pullToRefreshContainer.setHeader(new g());
        this.p0.setEnableFooter(false);
        this.p0.setListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void n1(Integer num) {
        if (num != null && num.intValue() != 0 && num.intValue() != 1001) {
            if (num.intValue() == 10000) {
                s0.s(this, R.string.schedule_event_conflict);
            } else if (num.intValue() == -1012) {
                w.f();
            } else if (num.intValue() == -1803) {
                s0.p(this, getResources().getString(R.string.schedule_event_conflict));
            } else if (num.intValue() == -1) {
                s0.n(this, R.string.common_operation_failed);
            }
        }
    }

    public static void o1(Context context, String str, boolean z) {
        Intent intent = new Intent(context, ScheduleListActivity.class);
        intent.putExtra("device_id_md5", str);
        intent.putExtra("is_color_bulb", z);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(List<ScheduleRuleBean> list) {
        if (list != null) {
            Collections.sort(list, this.K3);
            this.H3.r(list);
        }
    }

    private void q1(boolean z) {
        MenuItem menuItem = this.p1;
        if (menuItem != null) {
            menuItem.setVisible(z);
        }
    }

    private void r1(DesiredStatesBean desiredStatesBean) {
        if (desiredStatesBean != null) {
            desiredStatesBean.isTRV = this.J3;
        }
    }

    private void s1() {
        this.I3.B().observe(this, new a());
        this.I3.v().observe(this, new b());
        this.I3.A().observe(this, new c());
        this.I3.y().observe(this, new Observer() { // from class: com.tplink.iot.view.feature.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ScheduleListActivity.this.n1((Integer) obj);
            }
        });
    }

    @Override // com.tplink.iot.adapter.feature.ScheduleAdapter.f
    public void H0(ScheduleRuleBean scheduleRuleBean) {
        this.I3.H(scheduleRuleBean);
        i.A(this.p2);
    }

    @Override // com.tplink.iot.adapter.feature.ScheduleAdapter.f
    public void N(ScheduleRuleBean scheduleRuleBean) {
        ScheduleDetailActivity.J1(this, scheduleRuleBean, this.p2);
    }

    @Override // com.tplink.iot.adapter.feature.ScheduleAdapter.f
    public void W(ScheduleRuleBean scheduleRuleBean) {
        r1(scheduleRuleBean.getDesiredStates());
        this.I3.m(scheduleRuleBean, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_schedule_list);
        this.p3 = o0.p(this);
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.p2 = stringExtra;
        this.I3 = (ScheduleViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(ScheduleViewModel.class);
        l1();
        k1();
        s1();
        this.p0.e();
        i.u();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_schedule_list, menu);
        this.p1 = menu.findItem(R.id.schedule_settings);
        q1(this.I3.r);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.plug_schedule_list) {
            if (this.H3.getItemCount() >= this.I3.z()) {
                s0.v(this, getResources().getString(R.string.smart_action_add_limit_tip, Integer.valueOf(this.I3.z())));
            } else {
                ScheduleDetailActivity.J1(this, null, this.p2);
            }
            return true;
        }
        if (menuItem.getItemId() == R.id.schedule_settings && this.I3.r) {
            X0(TRVEarlyStartActivity.class, this.p2);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        ScheduleAdapter scheduleAdapter;
        super.onResume();
        if (this.p3 != o0.p(this) && (scheduleAdapter = this.H3) != null) {
            scheduleAdapter.notifyDataSetChanged();
            this.p3 = o0.p(this);
        }
    }
}
