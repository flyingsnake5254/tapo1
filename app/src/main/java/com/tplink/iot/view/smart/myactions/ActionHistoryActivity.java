package com.tplink.iot.view.smart.myactions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.c.e;
import com.scwang.smart.refresh.layout.c.g;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.smart.q;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.iot.viewmodel.smart.SmartLogViewModel;
import com.tplink.iot.widget.refreshlayout.SmartRefreshFooter;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ActionHistoryActivity extends BaseActivity {
    private List<SmartLog> p0 = new ArrayList();
    private q p1;
    private SmartLogViewModel p2;
    private TextView y;
    private TPSmartRefreshLayout z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements g {
        a() {
        }

        @Override // com.scwang.smart.refresh.layout.c.g
        public void m(@NonNull f fVar) {
            ActionHistoryActivity.this.p2.l(ActionHistoryActivity.this.p2.m());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements e {
        b() {
        }

        @Override // com.scwang.smart.refresh.layout.c.e
        public void q(@NonNull f fVar) {
            ActionHistoryActivity.this.p2.i(ActionHistoryActivity.this.p2.k());
        }
    }

    private void f1() {
        this.y = (TextView) findViewById(R.id.tv_empty_history);
        this.p1 = new q(this);
        ((ExpandableListView) findViewById(R.id.rv_history_list)).setAdapter(this.p1);
        TPSmartRefreshLayout tPSmartRefreshLayout = (TPSmartRefreshLayout) findViewById(R.id.logs_refresh_layout);
        this.z = tPSmartRefreshLayout;
        tPSmartRefreshLayout.Q(new SmartRefreshHeader(this));
        this.z.O(new SmartRefreshFooter(this));
        this.z.G(true);
        this.z.E(true);
        this.z.F(false);
        this.z.N(new a());
        this.z.L(new b());
        this.p0 = this.p2.j();
        n1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1(View view) {
        s0.l(this);
        this.p2.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1(List list) {
        this.z.q();
        this.z.l();
        this.p0 = list;
        n1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void l1(Boolean bool) {
        s0.g();
        if (bool == null || !bool.booleanValue()) {
            s0.n(this, R.string.operation_failed_try_again);
            return;
        }
        this.p2.t(null);
        o1();
    }

    public static void m1(Context context) {
        context.startActivity(new Intent(context, ActionHistoryActivity.class));
    }

    private void n1() {
        this.p1.h(this.p0);
        this.y.setVisibility(this.p0.isEmpty() ? 0 : 8);
    }

    private void p1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.smart_history_clear)).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_clear, R.color.common_iot_main_blue, new TPMaterialDialogV2.d() { // from class: com.tplink.iot.view.smart.myactions.a
            @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
            public final void onClick(View view) {
                ActionHistoryActivity.this.h1(view);
            }
        }).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void q1() {
        this.p2.h().observe(this, new Observer() { // from class: com.tplink.iot.view.smart.myactions.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActionHistoryActivity.this.j1((List) obj);
            }
        });
        this.p2.g().observe(this, new Observer() { // from class: com.tplink.iot.view.smart.myactions.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActionHistoryActivity.this.l1((Boolean) obj);
            }
        });
    }

    public void o1() {
        TPSmartRefreshLayout tPSmartRefreshLayout = this.z;
        if (tPSmartRefreshLayout != null) {
            tPSmartRefreshLayout.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_smart_history);
        b1(R.string.smart_history);
        this.p2 = (SmartLogViewModel) ViewModelProviders.of(this).get(SmartLogViewModel.class);
        f1();
        q1();
        SmartLogViewModel smartLogViewModel = this.p2;
        smartLogViewModel.l(smartLogViewModel.m());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_delete, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.common_delete) {
            p1();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
