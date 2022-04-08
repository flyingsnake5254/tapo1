package com.tplink.iot.view.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.home.DeviceMoveAdapter;
import com.tplink.iot.adapter.home.DeviceMoveSelectMenuAdapter;
import com.tplink.iot.adapter.home.HomeFamilySelectBean;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.home.DeviceMoveViewModel;
import com.tplink.libtpcontrols.DropDownView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceMoveActivity extends BaseActivity implements DeviceMoveAdapter.b, View.OnClickListener {
    private TextView H3;
    private ImageView I3;
    private TextView K3;
    private com.tplink.iot.model.home.b p0;
    private DeviceMoveAdapter y;
    private DeviceMoveViewModel z;
    private List<String> p1 = new ArrayList();
    private List<String> p2 = new ArrayList();
    private List<HomeFamilySelectBean> p3 = new ArrayList();
    private DropDownView J3 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DropDownView.d {

        /* renamed from: com.tplink.iot.view.home.DeviceMoveActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0221a extends AnimatorListenerAdapter {
            C0221a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DeviceMoveActivity.this.J3.setVisibility(4);
            }
        }

        a() {
        }

        @Override // com.tplink.libtpcontrols.DropDownView.d
        public void a() {
            DeviceMoveActivity.this.J3.setVisibility(0);
            ObjectAnimator.ofFloat(DeviceMoveActivity.this.I3, View.ROTATION.getName(), 180.0f).start();
        }

        @Override // com.tplink.libtpcontrols.DropDownView.d
        public void b() {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(DeviceMoveActivity.this.I3, View.ROTATION.getName(), -180.0f, 0.0f);
            ofFloat.addListener(new C0221a());
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements DeviceMoveSelectMenuAdapter.b {
        b() {
        }

        @Override // com.tplink.iot.adapter.home.DeviceMoveSelectMenuAdapter.b
        public void a(View view, int i) {
            if (DeviceMoveActivity.this.J3.l()) {
                DeviceMoveActivity.this.J3.g();
            }
            DeviceMoveActivity deviceMoveActivity = DeviceMoveActivity.this;
            deviceMoveActivity.j1((HomeFamilySelectBean) deviceMoveActivity.p3.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            s0.g();
            if (bool == null || !bool.booleanValue()) {
                DeviceMoveActivity.this.t1();
            } else {
                DeviceMoveActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(HomeFamilySelectBean homeFamilySelectBean) {
        this.p0 = this.z.h(homeFamilySelectBean.getFamilyId());
        q1();
        r1(this.p0.c());
    }

    private List<HomeFamilySelectBean> k1() {
        ArrayList arrayList = new ArrayList();
        for (com.tplink.iot.model.home.b bVar : this.z.f()) {
            HomeFamilySelectBean homeFamilySelectBean = new HomeFamilySelectBean();
            homeFamilySelectBean.setFamilyId(bVar.b());
            if (!bVar.a() || !TextUtils.isEmpty(bVar.c())) {
                homeFamilySelectBean.setFamilyName(bVar.c());
            } else {
                homeFamilySelectBean.setFamilyName(getString(R.string.home_default_family));
            }
            homeFamilySelectBean.setSelected(o1(bVar));
            if (homeFamilySelectBean.isSelected()) {
                arrayList.add(0, homeFamilySelectBean);
            } else {
                arrayList.add(homeFamilySelectBean);
            }
        }
        return arrayList;
    }

    private void l1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.p0 = this.z.h(intent.getStringExtra("family_id"));
            Bundle extras = intent.getExtras();
            if (extras != null) {
                List list = (List) extras.getSerializable("device_id_list");
                if (list != null && !list.isEmpty()) {
                    this.p1.addAll(list);
                }
                List list2 = (List) extras.getSerializable("group_id_list");
                if (list2 != null && !list2.isEmpty()) {
                    this.p2.addAll(list2);
                }
            }
        }
    }

    private void m1() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.home_pop_view_layout, (ViewGroup) null, false);
        inflate.findViewById(R.id.layout_home_setting).setVisibility(8);
        this.J3.setExpandedView(inflate);
        this.J3.setDropDownListener(new a());
        this.p3 = k1();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        DeviceMoveSelectMenuAdapter deviceMoveSelectMenuAdapter = new DeviceMoveSelectMenuAdapter(this, this.p3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(deviceMoveSelectMenuAdapter);
        deviceMoveSelectMenuAdapter.o(new b());
    }

    private void n1() {
        this.H3 = (TextView) findViewById(R.id.toolbar_title);
        this.J3 = (DropDownView) findViewById(R.id.drop_down_view);
        this.I3 = (ImageView) findViewById(R.id.collapsed_header_arrow);
        this.K3 = (TextView) findViewById(R.id.tv_no_room);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DeviceMoveAdapter deviceMoveAdapter = new DeviceMoveAdapter(this);
        this.y = deviceMoveAdapter;
        deviceMoveAdapter.o(this);
        recyclerView.setAdapter(this.y);
        q1();
        s1(this.z.m());
        r1(this.p0.c());
        this.H3.setOnClickListener(this);
    }

    private boolean o1(com.tplink.iot.model.home.b bVar) {
        com.tplink.iot.model.home.b bVar2 = this.p0;
        if (bVar2 == null || bVar2.b() == null) {
            return false;
        }
        return this.p0.b().equals(bVar.b());
    }

    public static void p1(Context context, String str, List<String> list, List<String> list2) {
        Intent intent = new Intent(context, DeviceMoveActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("device_id_list", (Serializable) list);
        bundle.putSerializable("group_id_list", (Serializable) list2);
        intent.putExtras(bundle);
        intent.putExtra("family_id", str);
        context.startActivity(intent);
    }

    private void q1() {
        List<com.tplink.iot.model.home.c> d2 = this.p0.d();
        this.y.n(d2);
        if (d2 == null || d2.isEmpty()) {
            this.K3.setVisibility(0);
        } else {
            this.K3.setVisibility(8);
        }
    }

    private void r1(String str) {
        if (TextUtils.isEmpty(str)) {
            c1(getString(R.string.home_default_family));
        } else {
            c1(str);
        }
    }

    private void s1(boolean z) {
        if (z) {
            this.I3.setVisibility(0);
            this.H3.setEnabled(true);
            return;
        }
        this.I3.setVisibility(8);
        this.H3.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1() {
        s0.p(this, getString(R.string.common_operation_failed));
    }

    private void u1() {
        this.z.k().observe(this, new c());
    }

    @Override // com.tplink.iot.adapter.home.DeviceMoveAdapter.b
    public void Z(com.tplink.iot.model.home.c cVar) {
        s0.l(this);
        this.z.w(this.p0.b(), cVar.b(), this.p1, this.p2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.toolbar_title) {
            return;
        }
        if (this.J3.l()) {
            this.J3.g();
        } else {
            this.J3.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_device_move);
        this.z = (DeviceMoveViewModel) ViewModelProviders.of(this).get(DeviceMoveViewModel.class);
        l1();
        n1();
        m1();
        u1();
    }
}
