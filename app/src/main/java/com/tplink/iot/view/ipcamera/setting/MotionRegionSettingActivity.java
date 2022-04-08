package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import b.d.q.b.l;
import b.d.q.b.o;
import b.d.w.c.a;
import com.bumptech.glide.request.g;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.databinding.ActivityMotionRegionSettingBinding;
import com.tplink.iot.view.ipcamera.widget.ChangeableAreaView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.MotionDetectionViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.libtpmediaother.database.model.c;
import com.tplink.libtpnetwork.Utils.f0.b;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.util.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MotionRegionSettingActivity extends BaseActivity implements ChangeableAreaView.a {
    private static final int y = e.a(32, AppContext.f6185c);
    private int H3;
    private ActivityMotionRegionSettingBinding I3;
    private ChangeableAreaView p0;
    private MotionDetectionViewModel p1;
    private int p3;
    private int z = 0;
    private List<ChangeableAreaView> p2 = new ArrayList();
    private int J3 = 3;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B1 */
    public /* synthetic */ void C1(Boolean bool) {
        if (bool.booleanValue()) {
            TSnackbar.y(this, getString(R.string.general_failed), PathInterpolatorCompat.MAX_NUM_POINTS).N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D1 */
    public /* synthetic */ void E1(Boolean bool) {
        if (bool.booleanValue()) {
            s0.g();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F1 */
    public /* synthetic */ void G1(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.i())) {
            String i = cVar.i();
            new g().V(R.drawable.ic_launcher_background).j(R.drawable.ic_launcher_background);
            com.bumptech.glide.c.u(getApplication()).s(i).x0(this.I3.O3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I1 */
    public /* synthetic */ void J1(List list) {
        this.p3 = this.I3.M3.getWidth();
        this.H3 = this.I3.M3.getHeight();
        P1();
        N1();
        this.p1.f10771b.setValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K1 */
    public /* synthetic */ void L1(View view) {
        onBackPressed();
    }

    public static void M1(Context context, String str, int i) {
        Intent intent = new Intent(context, MotionRegionSettingActivity.class);
        intent.putExtra("device_id_md5", str);
        intent.putExtra("detection_home_mode", i);
        context.startActivity(intent);
    }

    private void N1() {
        l.e(this.p1.i(), new b() { // from class: com.tplink.iot.view.ipcamera.setting.x2
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                MotionRegionSettingActivity.this.G1((c) obj);
            }
        });
    }

    private void O1() {
        if (this.p2.isEmpty()) {
            new UniversalDialog.a().q(getString(R.string.no_zones_alert)).s(getString(R.string.action_cancel)).r(null).u(getString(R.string.action_save)).t(new UniversalDialog.c() { // from class: com.tplink.iot.view.ipcamera.setting.z2
                @Override // com.tplink.iot.widget.UniversalDialog.c
                public final void a() {
                    MotionRegionSettingActivity.this.i1();
                }
            }).m(true).l().show(getSupportFragmentManager(), "REGION");
        } else {
            this.p1.Z(h1());
        }
    }

    private void P1() {
        this.p1.g.set(true);
        for (ChangeableAreaView changeableAreaView : this.p2) {
            if (changeableAreaView != null) {
                this.I3.M3.removeView(changeableAreaView);
            }
        }
        this.p1.h.set(false);
        this.p1.i.set(false);
        this.p2.clear();
        this.z = 0;
    }

    public static void Q1(Activity activity, boolean z) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(z);
                ((ViewGroup) childAt).setClipToPadding(z);
            }
        }
    }

    private void R1() {
        Toolbar toolbar = this.I3.R3;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.a3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MotionRegionSettingActivity.this.L1(view);
                }
            });
        }
    }

    private void S1() {
        int a;
        if (!r1()) {
            getWindow().getDecorView().setSystemUiVisibility(0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            getWindow().clearFlags(512);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.I3.M3.getLayoutParams();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            marginLayoutParams.width = displayMetrics.widthPixels;
            int a2 = o.a(this, 216.0f);
            int a3 = ((int) ((displayMetrics.widthPixels - a) / 1.7777778f)) + o.a(this, 30.0f);
            if (a2 < a3) {
                a2 = a3;
            }
            marginLayoutParams.height = a2;
        }
    }

    private void T1() {
        int i = this.z;
        if (i < 0 || i >= 14) {
            this.p1.g.set(false);
        } else {
            this.p1.g.set(true);
        }
    }

    private void U1(ChangeableAreaView changeableAreaView) {
        ChangeableAreaView changeableAreaView2 = this.p0;
        if (changeableAreaView2 != null) {
            changeableAreaView2.i(false);
        }
        this.p0 = changeableAreaView;
        changeableAreaView.i(true);
    }

    private void e1() {
        int i = this.z;
        if (i >= 14) {
            T1();
            return;
        }
        this.z = i + 1;
        ChangeableAreaView changeableAreaView = new ChangeableAreaView(this);
        changeableAreaView.setAreaViewListener(this);
        int i2 = this.p3;
        int i3 = this.H3;
        l1(changeableAreaView, new d(2500, (int) ((i2 * 2500.0d) / i3), 3750, (10000 - ((int) ((i2 * 2500.0d) / i3))) / 2));
        this.p2.add(changeableAreaView);
        this.I3.M3.addView(changeableAreaView);
        U1(changeableAreaView);
        T1();
        this.p1.h.set(true);
    }

    private void f1(ChangeableAreaView changeableAreaView) {
        d g1 = g1(changeableAreaView);
        this.p2.remove(changeableAreaView);
        this.p2.add(changeableAreaView);
        this.I3.M3.removeView(changeableAreaView);
        l1(changeableAreaView, g1);
        this.I3.M3.addView(changeableAreaView, this.p2.size());
    }

    private d g1(ChangeableAreaView changeableAreaView) {
        d dVar = new d();
        int i = this.p3;
        int i2 = y;
        dVar.g((int) (((changeableAreaView.getLeft() * 10000) * 1.0d) / (i - i2)));
        dVar.h((int) (((changeableAreaView.getTop() * 10000) * 1.0d) / (this.H3 - i2)));
        dVar.f((int) ((((changeableAreaView.getWidth() - i2) * 10000) * 1.0d) / (this.p3 - i2)));
        dVar.e((int) ((((changeableAreaView.getHeight() - i2) * 10000) * 1.0d) / (this.H3 - i2)));
        return dVar;
    }

    private List<d> h1() {
        ArrayList arrayList = new ArrayList();
        for (ChangeableAreaView changeableAreaView : this.p2) {
            arrayList.add(g1(changeableAreaView));
        }
        a.e("DetectionRegionActivity", "stash region size" + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        ArrayList arrayList = new ArrayList();
        d dVar = new d();
        dVar.g(0);
        dVar.h(0);
        dVar.e(10000);
        dVar.f(10000);
        arrayList.add(dVar);
        this.p1.Z(arrayList);
    }

    private void j1(boolean z) {
        if (z) {
            Q1(this, false);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags |= 1024;
            getWindow().setAttributes(attributes);
            return;
        }
        Q1(this, true);
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.flags &= -1025;
        getWindow().setAttributes(attributes2);
    }

    private void k1() {
        this.I3.getRoot().post(new Runnable() { // from class: com.tplink.iot.view.ipcamera.setting.c3
            @Override // java.lang.Runnable
            public final void run() {
                MotionRegionSettingActivity.this.u1();
            }
        });
    }

    private void l1(ChangeableAreaView changeableAreaView, d dVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 51;
        int i = this.p3;
        int i2 = y;
        layoutParams.leftMargin = (int) (((dVar.c() * 1.0d) / 10000.0d) * (i - i2));
        layoutParams.topMargin = (int) (((dVar.d() * 1.0d) / 10000.0d) * (this.H3 - i2));
        layoutParams.width = (int) ((((dVar.b() * 1.0d) / 10000.0d) * (this.p3 - i2)) + i2);
        layoutParams.height = (int) ((((dVar.a() * 1.0d) / 10000.0d) * (this.H3 - i2)) + i2);
        changeableAreaView.setLayoutParams(layoutParams);
    }

    private void m1(List<d> list) {
        this.p2.clear();
        this.z = list.size();
        T1();
        a.e("DetectionRegionActivity", "load region size = " + list.size());
        int i = 0;
        while (i < list.size()) {
            ChangeableAreaView changeableAreaView = new ChangeableAreaView(this);
            this.p2.add(changeableAreaView);
            changeableAreaView.setAreaViewListener(this);
            l1(changeableAreaView, list.get(i));
            int i2 = i + 1;
            this.I3.M3.addView(changeableAreaView, i2);
            if (i == list.size() - 1) {
                U1(changeableAreaView);
                this.p0.post(new Runnable() { // from class: com.tplink.iot.view.ipcamera.setting.d3
                    @Override // java.lang.Runnable
                    public final void run() {
                        MotionRegionSettingActivity.this.w1();
                    }
                });
            }
            d dVar = list.get(i);
            if (dVar.c() == 0 && dVar.d() == 0 && dVar.a() == 10000 && dVar.b() == 10000) {
                this.p1.i.set(true);
            }
            i = i2;
        }
    }

    private void n1() {
        ActivityMotionRegionSettingBinding activityMotionRegionSettingBinding = (ActivityMotionRegionSettingBinding) DataBindingUtil.setContentView(this, R.layout.activity_motion_region_setting);
        this.I3 = activityMotionRegionSettingBinding;
        activityMotionRegionSettingBinding.i(this.p1);
        this.I3.h(new e3(this));
    }

    private void o1() {
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.J3 = getIntent().getIntExtra("detection_home_mode", 3);
        this.I3 = (ActivityMotionRegionSettingBinding) DataBindingUtil.setContentView(this, R.layout.activity_motion_region_setting);
        MotionDetectionViewModel motionDetectionViewModel = (MotionDetectionViewModel) ViewModelProviders.of(this, new CameraViewModelFactory(this, stringExtra)).get(MotionDetectionViewModel.class);
        this.p1 = motionDetectionViewModel;
        motionDetectionViewModel.j(this.J3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_region /* 2131361939 */:
            case R.id.add_region_lan /* 2131361940 */:
                e1();
                return;
            case R.id.change_orientation /* 2131362222 */:
                setRequestedOrientation(0);
                return;
            case R.id.change_orientation_lan /* 2131362223 */:
                setRequestedOrientation(1);
                return;
            case R.id.close_lan /* 2131362256 */:
                onBackPressed();
                return;
            case R.id.delete_region /* 2131362389 */:
            case R.id.delete_region_lan /* 2131362390 */:
                P1();
                return;
            case R.id.done_lan /* 2131362489 */:
            case R.id.ok_btn /* 2131363582 */:
                O1();
                return;
            default:
                return;
        }
    }

    private void p1() {
        this.p1.f10771b.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.f3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MotionRegionSettingActivity.this.y1((List) obj);
            }
        });
        this.p1.f10773d.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.y2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MotionRegionSettingActivity.this.A1((Boolean) obj);
            }
        });
        this.p1.f10774e.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.w2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MotionRegionSettingActivity.this.C1((Boolean) obj);
            }
        });
        this.p1.f10775f.observe(this, new Observer() { // from class: com.tplink.iot.view.ipcamera.setting.g3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MotionRegionSettingActivity.this.E1((Boolean) obj);
            }
        });
    }

    private void q1() {
        this.I3.i(this.p1);
        this.I3.h(new e3(this));
        j1(r1());
        S1();
        R1();
        k1();
        N1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t1 */
    public /* synthetic */ void u1() {
        this.p3 = this.I3.M3.getWidth();
        this.H3 = this.I3.M3.getHeight();
        this.p1.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v1 */
    public /* synthetic */ void w1() {
        this.p0.k();
        this.p0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x1 */
    public /* synthetic */ void y1(List list) {
        if (list != null) {
            P1();
            m1(list);
            this.p1.h.set(list.size() != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z1 */
    public /* synthetic */ void A1(Boolean bool) {
        if (bool.booleanValue()) {
            s0.l(this);
        } else {
            s0.g();
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.ChangeableAreaView.a
    public void H(ChangeableAreaView changeableAreaView) {
        if (this.p0 != changeableAreaView) {
            f1(changeableAreaView);
        }
        U1(changeableAreaView);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.ChangeableAreaView.a
    public void O(ChangeableAreaView changeableAreaView) {
        this.p2.remove(changeableAreaView);
        this.I3.M3.removeView(changeableAreaView);
        List<ChangeableAreaView> list = this.p2;
        boolean z = true;
        if (list != null && list.size() > 0) {
            List<ChangeableAreaView> list2 = this.p2;
            ChangeableAreaView changeableAreaView2 = list2.get(list2.size() - 1);
            this.p0 = changeableAreaView2;
            changeableAreaView2.i(true);
        }
        this.z--;
        this.p1.g.set(true);
        ObservableBoolean observableBoolean = this.p1.h;
        if (this.z == 0) {
            z = false;
        }
        observableBoolean.set(z);
        d g1 = g1(changeableAreaView);
        if (g1.c() == 0 && g1.d() == 0 && g1.a() == 10000 && g1.b() == 10000) {
            this.p1.i.set(false);
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.ChangeableAreaView.a
    public void h0(ChangeableAreaView changeableAreaView) {
        this.p1.f(h1());
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (r1()) {
            setRequestedOrientation(1);
        } else {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final List<d> h1 = h1();
        n1();
        j1(r1());
        S1();
        if (!r1()) {
            R1();
        }
        this.I3.getRoot().post(new Runnable() { // from class: com.tplink.iot.view.ipcamera.setting.b3
            @Override // java.lang.Runnable
            public final void run() {
                MotionRegionSettingActivity.this.J1(h1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o1();
        q1();
        p1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_edit_done) {
            O1();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        T1();
    }

    protected boolean r1() {
        return getResources().getConfiguration().orientation == 2;
    }
}
