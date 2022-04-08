package com.tplink.iot.view.group.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.j;
import com.tplink.iot.Utils.k;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.Utils.z0.o;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.LocationPrepareActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.view.colorbulb.EditAutoDialog;
import com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog;
import com.tplink.iot.viewmodel.group.GroupDetailViewModel;
import com.tplink.iot.widget.BulbPresetsView;
import com.tplink.iot.widget.colorbulb.ColorPresetView;
import com.tplink.iot.widget.colorbulb.SimpleTextSwitcher;
import com.tplink.iot.widget.colorbulb.light.LightBgAnimView;
import com.tplink.iot.widget.colorbulb.light.LightBulbView;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.yinglan.scrolllayout.ScrollLayout;
import java.util.List;

/* loaded from: classes2.dex */
public class GroupDetailColorBulbActivity extends BaseActivity implements View.OnClickListener, LightBulbView.d, EditColorBulbPresetDialog.b, EditAutoDialog.a {
    private TextView H3;
    private SimpleTextSwitcher I3;
    private LightBulbView J3;
    private BulbPresetsView K3;
    private ColorPresetView L3;
    private View M3;
    private TPSwitchCompat N3;
    private ScrollLayout O3;
    private View P3;
    private View Q3;
    private String R3;
    private GroupDetailViewModel S3;
    private GroupDetailDeviceListFragment V3;
    private GroupInfo W3;
    private List<String> X3;
    private ImageView p0;
    private CardView p1;
    private TextView p2;
    private TextView p3;
    private ImageView y;
    private ImageView z;
    private EditColorBulbPresetDialog T3 = null;
    private EditAutoDialog U3 = null;
    private ColorPresetView.a Y3 = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ScrollLayout.g {
        a() {
        }

        @Override // com.yinglan.scrolllayout.ScrollLayout.g
        public void a(ScrollLayout.Status status) {
            if (status == ScrollLayout.Status.OPENED) {
                GroupDetailColorBulbActivity.this.p0.setImageResource(R.mipmap.ic_pull_up);
            } else if (status == ScrollLayout.Status.CLOSED) {
                GroupDetailColorBulbActivity.this.p0.setImageResource(R.mipmap.ic_pull_down);
            }
        }

        @Override // com.yinglan.scrolllayout.ScrollLayout.g
        public void b(float f2) {
        }

        @Override // com.yinglan.scrolllayout.ScrollLayout.g
        public void c(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements BulbPresetsView.c {
        b() {
        }

        @Override // com.tplink.iot.widget.BulbPresetsView.c
        public void a(int i) {
            GroupDetailColorBulbActivity.this.J(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TPSwitchCompat.a {
        c() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                GroupDetailColorBulbActivity.this.S3.h(GroupDetailColorBulbActivity.this.R3, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<List<GroupInfo>> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(List<GroupInfo> list) {
            GroupInfo o = GroupDetailColorBulbActivity.this.S3.o(list, GroupDetailColorBulbActivity.this.R3);
            if (o != null) {
                GroupDetailColorBulbActivity.this.W3 = o;
                GroupDetailColorBulbActivity.this.I1();
                GroupDetailColorBulbActivity.this.H1();
                GroupDetailColorBulbActivity.this.G1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Observer<Integer> {
        e() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            if (num != null && num.intValue() == 0) {
                s0.g();
                GroupDetailColorBulbActivity.this.q1();
            } else if (num == null || num.intValue() != 30) {
                s0.g();
                s0.n(GroupDetailColorBulbActivity.this, R.string.operation_failed_try_again);
            } else {
                s0.g();
                s0.s(GroupDetailColorBulbActivity.this, R.string.get_location_info_failed_tips);
            }
        }
    }

    /* loaded from: classes2.dex */
    class f implements ColorPresetView.a {
        f() {
        }

        @Override // com.tplink.iot.widget.colorbulb.ColorPresetView.a
        public void a(int i, LightStateBean lightStateBean) {
            GroupDetailColorBulbActivity.this.S3.G(GroupDetailColorBulbActivity.this.R3, lightStateBean);
        }

        @Override // com.tplink.iot.widget.colorbulb.ColorPresetView.a
        public void b() {
            GroupDetailColorBulbActivity.this.A1();
        }

        @Override // com.tplink.iot.widget.colorbulb.ColorPresetView.a
        public void c(int i, int i2, LightStateBean lightStateBean) {
            GroupDetailColorBulbActivity.this.B1(i, lightStateBean);
        }

        @Override // com.tplink.iot.widget.colorbulb.ColorPresetView.a
        public void d() {
            GroupDetailColorBulbActivity.this.o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements TPMaterialDialogV2.d {
        g() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            GroupDetailColorBulbActivity.this.p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1() {
        if (getSupportFragmentManager().findFragmentByTag("EditAutoDialog") == null) {
            EditAutoDialog G0 = EditAutoDialog.G0(s1());
            this.U3 = G0;
            G0.show(getSupportFragmentManager(), (String) null);
            this.U3.I0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(int i, LightStateBean lightStateBean) {
        if (getSupportFragmentManager().findFragmentByTag("EditColorBulbPresetDialog") == null) {
            EditColorBulbPresetDialog I0 = EditColorBulbPresetDialog.I0(true, i, lightStateBean);
            this.T3 = I0;
            I0.show(getSupportFragmentManager(), "EditColorBulbPresetDialog");
            this.T3.J0(this);
        }
    }

    private void C1() {
        this.y.setImageResource(R.mipmap.ic_white_back);
        this.z.setImageDrawable(getResources().getDrawable(R.mipmap.ic_setting_white));
        this.p2.setTextColor(getResources().getColor(R.color.white));
        this.p3.setTextColor(getResources().getColor(R.color.white));
        this.p3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), R.mipmap.ic_location_gray, null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void D1() {
        this.y.setImageResource(R.mipmap.ic_grey_back);
        this.z.setImageDrawable(getResources().getDrawable(R.mipmap.ic_setting_black));
        this.p2.setTextColor(getResources().getColor(R.color.common_iot_dark_black));
        this.p3.setTextColor(getResources().getColor(R.color.common_iot_dark_black));
        this.p3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), R.mipmap.ic_location_black, null), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void E1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.set_sunrise_sunset_limit_same_network_tips)).setCancelable(false).c(false).l(R.string.action_no, R.color.common_iot_light_black, null).o(R.string.action_yes, R.color.common_iot_main_blue, new g()).g(8, 8).create().show();
    }

    private void F1() {
        this.S3.p().observe(this, new d());
        this.S3.t().observe(this, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1() {
        GroupInfo groupInfo = this.W3;
        if (groupInfo != null) {
            this.p2.setText(o.d(this, groupInfo.getName()));
            String a2 = o.a(this.W3);
            int i = 8;
            if (TextUtils.isEmpty(a2)) {
                this.p3.setVisibility(8);
            } else {
                this.p3.setVisibility(0);
                this.p3.setText(a2);
            }
            this.N3.setChecked(this.W3.getCommon() == null ? false : this.W3.getCommon().booleanValue());
            this.H3.setText(String.valueOf(this.S3.m(this.W3)));
            this.N3.setEnabled(true);
            this.Q3.setAlpha(1.0f);
            this.p2.setEnabled(true);
            this.p3.setEnabled(true);
            this.P3.setEnabled(true);
            this.P3.setAlpha(1.0f);
            CardView cardView = this.p1;
            if (com.tplink.libtpnetwork.Utils.g.l(this.W3)) {
                i = 0;
            }
            cardView.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1() {
        if (this.W3 != null) {
            if (w1()) {
                this.L3.setColorPresets(com.tplink.libtpnetwork.Utils.g.f(this.W3));
                this.M3.setVisibility(0);
                this.K3.setVisibility(8);
                return;
            }
            this.K3.setPresets(com.tplink.libtpnetwork.Utils.g.c(this.W3));
            this.K3.setVisibility(0);
            this.M3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1() {
        int i;
        if (this.W3 != null) {
            if (w1()) {
                i = com.tplink.libtpnetwork.Utils.g.e(this.W3);
            } else {
                i = com.tplink.iot.Utils.z0.g.g();
            }
            this.J3.r(com.tplink.libtpnetwork.Utils.g.k(this.W3), com.tplink.libtpnetwork.Utils.g.b(this.W3), i);
            if (com.tplink.libtpnetwork.Utils.g.k(this.W3)) {
                D1();
            } else {
                C1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        GroupInfo groupInfo = this.W3;
        if (groupInfo != null) {
            List<String> s = this.S3.s(groupInfo);
            this.X3 = s;
            if (s == null || s.isEmpty()) {
                q1();
            } else {
                E1();
            }
        }
    }

    private String s1() {
        return com.tplink.libtpnetwork.Utils.g.h(this.W3);
    }

    private void t1() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.V3 == null) {
            this.V3 = GroupDetailDeviceListFragment.V1(this.R3);
        }
        if (this.V3.isAdded()) {
            beginTransaction.show(this.V3);
        } else {
            beginTransaction.add(R.id.ll_rules, this.V3, "Group_Device_List");
        }
        beginTransaction.commitAllowingStateLoss();
    }

    private void u1() {
        this.L3.setOnColorPresetCheckedListener(this.Y3);
        this.K3.setOnPresetItemCheckListener(new b());
        this.N3.setOnSwitchCheckedChangeListener(new c());
    }

    private void v1() {
        this.y = (ImageView) findViewById(R.id.iv_back);
        this.z = (ImageView) findViewById(R.id.iv_setting);
        this.p2 = (TextView) findViewById(R.id.tv_name);
        CardView cardView = (CardView) findViewById(R.id.card_part_offline);
        this.p1 = cardView;
        cardView.setVisibility(8);
        this.p3 = (TextView) findViewById(R.id.tv_location);
        this.I3 = (SimpleTextSwitcher) findViewById(R.id.text_switcher);
        this.J3 = (LightBulbView) findViewById(R.id.bulb_view);
        View findViewById = findViewById(R.id.fl_preset);
        this.K3 = (BulbPresetsView) findViewById(R.id.rg_common_brightness);
        this.L3 = (ColorPresetView) findViewById(R.id.color_preset_view);
        this.M3 = findViewById(R.id.color_preset_scroll_view);
        View findViewById2 = findViewById(R.id.ll_rules);
        this.N3 = (TPSwitchCompat) findViewById(R.id.switch_button);
        this.O3 = (ScrollLayout) findViewById(R.id.scroll_down_layout);
        this.Q3 = findViewById(R.id.rl_common_device);
        this.P3 = findViewById(R.id.item_group_settings);
        this.H3 = (TextView) findViewById(R.id.tv_person);
        this.p0 = (ImageView) findViewById(R.id.iv_pull_up_down);
        t1();
        this.J3.m((LightBgAnimView) findViewById(R.id.color_bulb_bg_anim_view), findViewById, this.I3);
        this.O3.setMinOffset(k.a(this, 50.0f) + com.tplink.iot.view.quicksetup.base.d.A(this));
        this.O3.setOnScrollChangedListener(new a());
        findViewById2.post(new Runnable() { // from class: com.tplink.iot.view.group.detail.a
            @Override // java.lang.Runnable
            public final void run() {
                GroupDetailColorBulbActivity.this.y1();
            }
        });
        this.J3.setOnBulbOperationListener(this);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        findViewById(R.id.iv_pull_up_down).setOnClickListener(this);
        this.P3.setOnClickListener(this);
        u1();
    }

    private boolean w1() {
        return o.f(this.W3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x1 */
    public /* synthetic */ void y1() {
        int measuredHeight = findViewById(R.id.root).getMeasuredHeight() - this.O3.getScreenHeight();
        int a2 = j.a(this, 90.0f);
        int measuredHeight2 = this.p0.getMeasuredHeight();
        if (a2 > 0 && measuredHeight2 > 0) {
            this.O3.setMaxOffset((a2 + measuredHeight2) - measuredHeight);
            this.O3.r();
        }
        int i = a2 + measuredHeight2;
        View findViewById = findViewById(R.id.content_scroll_view);
        if (((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).bottomMargin < i) {
            ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).bottomMargin = i;
            findViewById.requestLayout();
        }
    }

    public static void z1(Context context, String str) {
        Intent intent = new Intent(context, GroupDetailColorBulbActivity.class);
        intent.putExtra(FirebaseAnalytics.Param.GROUP_ID, str);
        context.startActivity(intent);
    }

    @Override // com.tplink.iot.widget.colorbulb.light.LightBulbView.d
    public void J(int i, boolean z) {
        this.S3.z(this.R3, i);
    }

    @Override // com.tplink.iot.view.colorbulb.EditAutoDialog.a
    public void J0(String str) {
        this.S3.y(this.R3, new AutoLightBean(true, str));
    }

    @Override // com.tplink.iot.widget.colorbulb.light.LightBulbView.d
    public void L(int i) {
        this.I3.a(true, i, false);
    }

    @Override // com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b
    public void U(LightStateBean lightStateBean) {
        this.S3.G(this.R3, lightStateBean);
    }

    @Override // com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b
    public void g(int i, LightStateBean lightStateBean) {
        EditPresetRule editPresetRule = new EditPresetRule();
        editPresetRule.setIndex(i);
        editPresetRule.setState(lightStateBean);
        this.S3.k(this.W3, editPresetRule);
        this.S3.G(this.R3, lightStateBean);
    }

    @Override // com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b
    public void h(LightStateBean lightStateBean) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 200 && com.tplink.iot.view.quicksetup.base.f.a.a(this)) {
            r1();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_group_settings /* 2131362919 */:
                GroupEditDeviceListActivity.q1(this, this.R3);
                return;
            case R.id.iv_back /* 2131363002 */:
                onBackPressed();
                return;
            case R.id.iv_pull_up_down /* 2131363103 */:
                if (this.O3.getCurrentStatus() == ScrollLayout.Status.CLOSED) {
                    this.O3.o();
                    return;
                } else if (this.O3.getCurrentStatus() == ScrollLayout.Status.OPENED) {
                    this.O3.m();
                    return;
                } else {
                    return;
                }
            case R.id.iv_setting /* 2131363121 */:
                GroupBulbSettingsActivity.l1(this, this.R3);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_group_detail_color_bulb);
        com.tplink.iot.view.quicksetup.base.d.J(this, findViewById(R.id.ll_toolbar));
        this.R3 = getIntent().getStringExtra(FirebaseAnalytics.Param.GROUP_ID);
        this.S3 = (GroupDetailViewModel) ViewModelProviders.of(this).get(GroupDetailViewModel.class);
        v1();
        F1();
        i.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LightBulbView lightBulbView = this.J3;
        if (lightBulbView != null) {
            lightBulbView.p();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.S3.n(this.R3);
    }

    public void p1() {
        if (!com.tplink.iot.view.quicksetup.base.f.a.a(this)) {
            startActivityForResult(new Intent(this, LocationPrepareActivity.class), ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        } else {
            r1();
        }
    }

    public void q1() {
        this.L3.d();
        this.S3.y(this.R3, new AutoLightBean(true, s1()));
        A1();
    }

    public void r1() {
        List<String> list = this.X3;
        if (list != null && !list.isEmpty()) {
            s0.l(this);
            this.S3.C(this.X3, new AutoLightBean(true, s1()));
        }
    }

    @Override // com.tplink.iot.widget.colorbulb.light.LightBulbView.d
    public void w0(boolean z) {
        this.S3.E(this.R3, z);
    }
}
