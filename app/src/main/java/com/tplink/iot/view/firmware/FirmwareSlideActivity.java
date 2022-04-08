package com.tplink.iot.view.firmware;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.m;
import com.tplink.iot.adapter.firmware.FirmwareMainAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.firmware.IotSeriesBean;
import com.tplink.iot.viewmodel.firmware.FirmwareSlideViewModel;
import com.tplink.iot.widget.g;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FirmwareSlideActivity extends BaseActivity implements View.OnClickListener {
    private TPCircleProgressBar H3;
    private TextView I3;
    private Button J3;
    private FirmwareMainAdapter K3;
    private List<IotSeriesBean> L3 = new ArrayList();
    private FirmwareSlideViewModel M3;
    private List<IotSeriesBean> N3;
    private View p0;
    private View p1;
    private View p2;
    private RecyclerView p3;
    private PullToRefreshContainer y;
    private View z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements PullToRefreshContainer.e {
        a() {
        }

        @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e
        public void a() {
        }

        @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e
        public void onRefresh() {
            FirmwareSlideActivity.this.M3.t();
        }
    }

    private void f1() {
        this.H3.i();
        this.z.setVisibility(8);
    }

    private void g1() {
        b1(R.string.firmware_slide_update_title);
        this.y = (PullToRefreshContainer) findViewById(R.id.refresh_layout);
        this.H3 = (TPCircleProgressBar) findViewById(R.id.circle_progress_bar);
        this.z = findViewById(R.id.layout_loading);
        this.p1 = findViewById(R.id.layout_empty);
        this.p0 = findViewById(R.id.layout_result);
        this.p3 = (RecyclerView) findViewById(R.id.recycler_view);
        this.I3 = (TextView) findViewById(R.id.tv_not_power_off_hint);
        this.p2 = findViewById(R.id.ll_bottom_button);
        this.J3 = (Button) findViewById(R.id.btn_update_all);
        this.H3.setProgressBarColor(ContextCompat.getColor(this, R.color.common_iot_light_gray));
        this.y.setHeader(new g());
        this.y.setEnableHeader(true);
        this.y.setEnableFooter(false);
        this.y.setListener(new a());
        this.J3.setOnClickListener(this);
        this.p3.setLayoutManager(new LinearLayoutManager(this));
        FirmwareMainAdapter firmwareMainAdapter = new FirmwareMainAdapter(this, this.L3);
        this.K3 = firmwareMainAdapter;
        this.p3.setAdapter(firmwareMainAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1 */
    public /* synthetic */ void i1(List list) {
        this.N3 = list;
        t1(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1 */
    public /* synthetic */ void k1(Boolean bool) {
        if (bool == null || !bool.booleanValue()) {
            f1();
        } else {
            r1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public /* synthetic */ void m1(Boolean bool) {
        if (bool != null && !bool.booleanValue()) {
            this.y.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(Boolean bool) {
        this.J3.setEnabled(bool != null && bool.booleanValue());
    }

    private void p1() {
        Intent intent = getIntent();
        m.c(intent != null ? intent.getStringExtra("entry") : "");
    }

    public static void q1(Context context, String str) {
        Intent intent = new Intent(context, FirmwareSlideActivity.class);
        intent.putExtra("entry", str);
        context.startActivity(intent);
    }

    private void r1() {
        this.p0.setVisibility(8);
        this.z.setVisibility(0);
        this.H3.g();
    }

    private void s1() {
        this.M3.g().observe(this, new Observer() { // from class: com.tplink.iot.view.firmware.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FirmwareSlideActivity.this.i1((List) obj);
            }
        });
        this.M3.i().observe(this, new Observer() { // from class: com.tplink.iot.view.firmware.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FirmwareSlideActivity.this.k1((Boolean) obj);
            }
        });
        this.M3.h().observe(this, new Observer() { // from class: com.tplink.iot.view.firmware.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FirmwareSlideActivity.this.m1((Boolean) obj);
            }
        });
        this.M3.j().observe(this, new Observer() { // from class: com.tplink.iot.view.firmware.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FirmwareSlideActivity.this.o1((Boolean) obj);
            }
        });
    }

    private void t1(List<IotSeriesBean> list) {
        f1();
        if (list == null || list.size() == 0) {
            this.I3.setVisibility(8);
            this.p2.setVisibility(8);
            this.p3.setVisibility(8);
            this.p0.setVisibility(0);
            this.p1.setVisibility(0);
            return;
        }
        this.I3.setVisibility(0);
        this.p1.setVisibility(8);
        this.p0.setVisibility(0);
        this.p2.setVisibility(0);
        this.p3.setVisibility(0);
        this.K3.r(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_update_all) {
            this.M3.v(this.N3);
            m.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_firmware_slide);
        this.M3 = (FirmwareSlideViewModel) ViewModelProviders.of(this).get(FirmwareSlideViewModel.class);
        g1();
        s1();
        this.M3.k();
        p1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        FirmwareSlideViewModel firmwareSlideViewModel = this.M3;
        if (firmwareSlideViewModel != null) {
            firmwareSlideViewModel.f();
        }
        super.onDestroy();
    }
}
