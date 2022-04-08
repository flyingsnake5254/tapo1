package com.tplink.iot.view.smart.template;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.j;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.v;
import com.tplink.iot.adapter.smart.SmartTaskAdapter;
import com.tplink.iot.adapter.smart.SmartTriggerAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.smart.a.b;
import com.tplink.iot.view.smart.a.g;
import com.tplink.iot.view.smart.actionsetup.ActionDetailActivity;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.SmartTemplateViewModel;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class SmartTemplateDetailActivity extends BaseActivity {
    private SmartTriggerAdapter I3;
    private SmartTaskAdapter J3;
    private SmartTemplateViewModel p0;
    private ActionSetupViewModel p1;
    private Button y;
    private CollapsingToolbarLayout z;
    private int p2 = 0;
    private SmartTemplate p3 = null;
    private SmartInfo H3 = null;

    private void e1() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.template_toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_white_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.smart.template.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmartTemplateDetailActivity.this.g1(view);
            }
        });
        this.z = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        this.y = (Button) findViewById(R.id.btn_template_apply);
        this.I3 = new SmartTriggerAdapter(this, true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cy_template_schedules);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.I3);
        recyclerView.setNestedScrollingEnabled(false);
        this.J3 = new SmartTaskAdapter(this, true);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.cy_template_things_trigger);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(this.J3);
        recyclerView2.setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1 */
    public /* synthetic */ void g1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1 */
    public /* synthetic */ void i1(View view) {
        v.b(this.p3.getName());
        ActionDetailActivity.F1(this, this.p2, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1 */
    public /* synthetic */ void k1(View view) {
        s0.l(this);
        v.a(this.p3.getName());
        this.H3 = this.p1.f(this.p3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public /* synthetic */ void m1(List list) {
        int i = this.p2;
        if (i >= 0 && i < this.p0.j().size()) {
            this.p3 = this.p0.j().get(this.p2);
        }
        s1(this.p3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void o1(Boolean bool) {
        s0.g();
        if (bool == null || !bool.booleanValue()) {
            s0.n(this, R.string.operation_failed_try_again);
            return;
        }
        s0.B(this, null);
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public /* synthetic */ void q1(Boolean bool) {
        if (bool == null || bool.booleanValue()) {
            s0.g();
            s0.n(this, R.string.tapo_request_permission_once);
            return;
        }
        this.p1.i(this.H3);
    }

    public static Intent r1(Context context, int i) {
        Intent intent = new Intent(context, SmartTemplateDetailActivity.class);
        intent.putExtra("template_item_index", i);
        return intent;
    }

    private void s1(SmartTemplate smartTemplate) {
        String str;
        boolean z;
        if (smartTemplate == null) {
            finish();
            return;
        }
        if (g.c(smartTemplate)) {
            str = getString(R.string.smart_automation);
        } else {
            str = smartTemplate.getTitle();
        }
        this.z.setTitle(str);
        ((TextView) findViewById(R.id.tv_sub_toolbar)).setText(smartTemplate.getSubTitle());
        ((TextView) findViewById(R.id.tv_template_name)).setText(smartTemplate.getName());
        ImageView imageView = (ImageView) findViewById(R.id.back_drop);
        c.u(imageView.getContext()).s(smartTemplate.getTitleDetailImgUrl()).a(new com.bumptech.glide.request.g().V(R.mipmap.smart_bg_shadow_rect).j(R.mipmap.smart_bg_shadow_rect).g().f(j.f1461d)).x0(imageView);
        this.I3.A(smartTemplate.getTriggerSetting());
        this.J3.t(smartTemplate.getActionSetting());
        this.J3.u(smartTemplate.getMarketingUrls());
        boolean z2 = false;
        if (smartTemplate.getTriggerSetting() != null && !smartTemplate.getTriggerSetting().isManual()) {
            this.p1.M(false);
        }
        findViewById(R.id.btn_template_edit).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.smart.template.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmartTemplateDetailActivity.this.i1(view);
            }
        });
        List<ThingInfo> value = this.p0.h().getValue();
        if (!(value == null || value.isEmpty() || smartTemplate.getActionSetting() == null)) {
            boolean z3 = false;
            for (SmartThingAction smartThingAction : smartTemplate.getActionSetting().getThings()) {
                Iterator<ThingInfo> it = value.iterator();
                while (true) {
                    if (it.hasNext()) {
                        ThingInfo next = it.next();
                        if (!b.d(smartThingAction.getCategory(), next) || !this.p1.Q(next.getThingModelId(), smartThingAction, next.getThingName())) {
                            z = false;
                            continue;
                        } else {
                            z = true;
                            continue;
                        }
                        if (z) {
                            this.y.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.smart.template.a
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    SmartTemplateDetailActivity.this.k1(view);
                                }
                            });
                            z3 = true;
                            break;
                        }
                    }
                }
            }
            z2 = z3;
        }
        this.y.setAlpha(z2 ? 1.0f : 0.4f);
        this.y.setEnabled(z2);
    }

    private void t1() {
        this.p0.g();
        this.p0.f();
    }

    private void u1() {
        this.p0.k().observe(this, new Observer() { // from class: com.tplink.iot.view.smart.template.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SmartTemplateDetailActivity.this.m1((List) obj);
            }
        });
        this.p1.x().observe(this, new Observer() { // from class: com.tplink.iot.view.smart.template.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SmartTemplateDetailActivity.this.o1((Boolean) obj);
            }
        });
        this.p1.B().observe(this, new Observer() { // from class: com.tplink.iot.view.smart.template.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SmartTemplateDetailActivity.this.q1((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_smart_template_detail);
        d.J(this, findViewById(R.id.template_toolbar));
        this.p0 = (SmartTemplateViewModel) ViewModelProviders.of(this).get(SmartTemplateViewModel.class);
        this.p1 = (ActionSetupViewModel) ViewModelProviders.of(this).get(ActionSetupViewModel.class);
        if (getIntent() != null) {
            this.p2 = getIntent().getIntExtra("template_item_index", 0);
        } else {
            finish();
        }
        e1();
        u1();
        t1();
    }
}
