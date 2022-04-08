package com.tplink.iot.view.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.login.CloudRegionCode;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.login.RegionListNewAdapter;
import com.tplink.iot.widget.skin.SkinCompatWordIndexView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudRegionChooseActivity extends BaseActivity {
    private RecyclerView H3;
    private SkinCompatWordIndexView I3;
    private RegionListNewAdapter J3;
    @BindView
    Toolbar mToolbar;
    private boolean p1;
    private TextView p2;
    private EditText p3;
    private List<com.tplink.iot.j.b.a> y = new ArrayList();
    private String z = "";
    private String p0 = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            CloudRegionChooseActivity.this.k1(charSequence.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements SkinCompatWordIndexView.a {
        b() {
        }

        @Override // com.tplink.iot.widget.skin.SkinCompatWordIndexView.a
        public void a(String str) {
            int q = CloudRegionChooseActivity.this.J3.q(str);
            if (q >= 0) {
                ((LinearLayoutManager) CloudRegionChooseActivity.this.H3.getLayoutManager()).scrollToPositionWithOffset(q, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements RegionListNewAdapter.c {
        c() {
        }

        @Override // com.tplink.iot.view.login.RegionListNewAdapter.c
        public void a(String str, String str2) {
            CloudRegionChooseActivity.this.z = str2;
            CloudRegionChooseActivity.this.J3.s(str);
            CloudRegionChooseActivity.this.r1(true);
        }
    }

    /* loaded from: classes2.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudRegionChooseActivity.this.n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements TPMaterialDialogV3.d {
        e() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV3.d
        public void onClick(View view) {
            CloudRegionChooseActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements TPMaterialDialogV3.d {
        f() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV3.d
        public void onClick(View view) {
            CloudRegionChooseActivity.this.setResult(101);
            CloudRegionChooseActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(String str) {
        if (str.isEmpty()) {
            this.J3.r(this.y, true);
            if (com.tplink.iot.Utils.login.a.e(getApplicationContext())) {
                this.I3.setVisibility(0);
            }
            findViewById(R.id.region_no_match).setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.y.size(); i++) {
            com.tplink.iot.j.b.a aVar = this.y.get(i);
            if (com.tplink.iot.j.b.a.e(aVar.b()).toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(aVar);
            }
        }
        this.J3.r(arrayList, false);
        if (com.tplink.iot.Utils.login.a.e(getApplicationContext())) {
            this.I3.setVisibility(8);
        }
        if (arrayList.isEmpty()) {
            findViewById(R.id.region_no_match).setVisibility(0);
        } else {
            findViewById(R.id.region_no_match).setVisibility(8);
        }
    }

    private void l1() {
        s1();
        if (this.y.size() != 0) {
            RegionListNewAdapter regionListNewAdapter = new RegionListNewAdapter(this, new c());
            this.J3 = regionListNewAdapter;
            regionListNewAdapter.r(this.y, true);
            this.H3.setAdapter(this.J3);
            if (!TextUtils.isEmpty(this.z)) {
                String c2 = com.tplink.iot.Utils.login.a.c(this, this.z);
                if (!TextUtils.isEmpty(c2)) {
                    this.J3.s(c2);
                    ((LinearLayoutManager) this.H3.getLayoutManager()).scrollToPositionWithOffset(this.J3.p(), 0);
                }
            }
        }
    }

    private void m1() {
        p1();
        if (this.p1) {
            this.mToolbar.setNavigationIcon(R.mipmap.close);
        }
        this.H3 = (RecyclerView) findViewById(R.id.region_lv);
        EditText editText = (EditText) findViewById(R.id.region_searchbar);
        this.p3 = editText;
        editText.addTextChangedListener(new a());
        SkinCompatWordIndexView skinCompatWordIndexView = (SkinCompatWordIndexView) findViewById(R.id.region_wiv);
        this.I3 = skinCompatWordIndexView;
        skinCompatWordIndexView.setOnTouchingLetterChangedListener(new b());
        if (com.tplink.iot.Utils.login.a.e(getApplicationContext())) {
            this.I3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        b.d.w.f.a.g(this);
        Intent intent = new Intent();
        intent.putExtra("REGION_CODE", this.z);
        setResult(-1, intent);
        finish();
    }

    private void o1() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("REGION_CODE");
            this.p0 = stringExtra;
            this.z = stringExtra;
            this.p1 = intent.getBooleanExtra("args_is_from_dashboard", false);
        }
    }

    private void p1() {
        if (!f.a.f.a.d.e().o() && Build.VERSION.SDK_INT >= 23) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        }
    }

    private void q1() {
        new TPMaterialDialogV3.Builder(this).f(getString(R.string.region_choose_log_out)).setCancelable(false).c(false).h(R.string.common_cancel, R.color.common_iot_light_black, null).j(R.string.common_logout, R.color.common_iot_main_blue, new f()).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(boolean z) {
        TextView textView = this.p2;
        if (textView != null) {
            if (z) {
                textView.setEnabled(true);
                this.p2.setTextColor(getResources().getColor(R.color.common_iot_main_blue));
                return;
            }
            textView.setEnabled(false);
            this.p2.setTextColor(getResources().getColor(R.color.common_iot_light_green));
        }
    }

    private void s1() {
        CloudRegionCode[] values;
        for (CloudRegionCode cloudRegionCode : CloudRegionCode.values()) {
            com.tplink.iot.j.b.a aVar = new com.tplink.iot.j.b.a(cloudRegionCode.getRegionCode(), getString(cloudRegionCode.getResId()), false);
            List<com.tplink.iot.j.b.a> list = this.y;
            list.add(list.size(), aVar);
            String str = this.z;
            if (str != null && str.equals(cloudRegionCode.getRegionCode())) {
                aVar.d(true);
                r1(true);
            }
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.p1) {
            q1();
        } else if (!this.p0.equalsIgnoreCase(this.z)) {
            new TPMaterialDialogV3.Builder(this).f(getString(R.string.high_speed_mode_quit_hint)).setCancelable(false).c(false).h(R.string.common_cancel, R.color.common_iot_light_black, null).j(R.string.common_leave, R.color.common_iot_main_blue, new e()).create().show();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cloud_region_choose);
        ButterKnife.a(this);
        o1();
        m1();
        l1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_done, menu);
        MenuItem findItem = menu.findItem(R.id.common_done);
        findItem.setActionView(R.layout.login_region_menu_view);
        TextView textView = (TextView) findItem.getActionView().findViewById(R.id.tv_login_region);
        this.p2 = textView;
        textView.setText(R.string.common_done);
        this.p2.setOnClickListener(new d());
        RegionListNewAdapter regionListNewAdapter = this.J3;
        r1(regionListNewAdapter != null && regionListNewAdapter.p() >= 0);
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        b.d.w.f.a.g(this);
        onBackPressed();
        return true;
    }
}
