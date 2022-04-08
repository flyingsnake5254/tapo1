package com.tplink.iot.view.account;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.andexert.library.RippleView;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.u;
import com.tplink.iot.Utils.x0.p;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.viewmodel.account.AccountInfoViewModel;
import com.tplink.libtpcontrols.TPCircleMaskView;
import com.tplink.libtpnetwork.Utils.o;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AccountActivity extends BaseActivity implements View.OnClickListener {
    private TextView p0;
    private TPCircleMaskView p1;
    private TextView p2;
    private LinearLayout y;
    private TextView z;
    private File p3 = null;
    private AccountInfoViewModel H3 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TPMaterialDialogV2.c {
        a() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.c
        public void a(TPMaterialDialogV2 tPMaterialDialogV2, View view) {
            TextView textView = (TextView) view.findViewById(R.id.dialog_message_tv);
            textView.setText(R.string.account_logout_tip);
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.ill_log_out, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TPMaterialDialogV2.d {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            AccountActivity accountActivity = AccountActivity.this;
            List list = this.a;
            accountActivity.requestPermissions((String[]) list.toArray(new String[list.size()]), 13);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TPMaterialDialogV2.d {
        c() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            AccountActivity.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + AccountActivity.this.getPackageName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements TPMaterialDialogV2.d {
        d() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            AccountActivity.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + AccountActivity.this.getPackageName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements RippleView.b {
        e() {
        }

        @Override // com.andexert.library.RippleView.b
        public void j0(RippleView rippleView) {
            AccountActivity.this.W0(AccountChangeNameActivity.class);
            p.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements RippleView.b {
        f() {
        }

        @Override // com.andexert.library.RippleView.b
        public void j0(RippleView rippleView) {
            AccountActivity.this.W0(AccountPasswordVerifyActivity.class);
            p.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements Observer<TCAccountBean> {
        h() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable TCAccountBean tCAccountBean) {
            AccountActivity.this.t1(tCAccountBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements Observer<Boolean> {
        i() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                s0.k(AccountActivity.this);
            } else {
                AccountActivity.this.v1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements Observer<AccountInfoViewModel.h> {
        j() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable AccountInfoViewModel.h hVar) {
            AccountActivity.this.u1(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k implements Observer<Boolean> {
        k() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool == null) {
                s0.l(AccountActivity.this);
                return;
            }
            s0.g();
            u.a(AccountActivity.this);
            com.tplink.iot.model.about.c.c();
            com.tplink.iot.Utils.y0.d.a(AppContext.f6185c);
            AccountActivity.this.setResult(-1);
            AccountActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l implements TPMaterialDialogV2.c {

        /* loaded from: classes2.dex */
        class a implements View.OnClickListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ TPMaterialDialogV2 f8312c;

            a(TPMaterialDialogV2 tPMaterialDialogV2) {
                this.f8312c = tPMaterialDialogV2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f8312c.dismiss();
                if (Build.VERSION.SDK_INT >= 23) {
                    AccountActivity.this.z1();
                } else {
                    AccountActivity.this.C1();
                }
            }
        }

        /* loaded from: classes2.dex */
        class b implements View.OnClickListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ TPMaterialDialogV2 f8314c;

            b(TPMaterialDialogV2 tPMaterialDialogV2) {
                this.f8314c = tPMaterialDialogV2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f8314c.dismiss();
                AccountActivity.this.B1();
            }
        }

        l() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.c
        public void a(TPMaterialDialogV2 tPMaterialDialogV2, View view) {
            View findViewById = view.findViewById(R.id.dlg_take_photo);
            View findViewById2 = view.findViewById(R.id.dlg_chose_album);
            findViewById.setOnClickListener(new a(tPMaterialDialogV2));
            findViewById2.setOnClickListener(new b(tPMaterialDialogV2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class m implements TPMaterialDialogV2.d {
        m() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            AccountActivity.this.H3.w();
        }
    }

    private void A1() {
        this.H3.p().observe(this, new h());
        this.H3.s().observe(this, new i());
        this.H3.r().observe(this, new j());
        this.H3.u().observe(this, new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1() {
        Uri uri;
        File m1 = m1(this);
        if (m1 == null) {
            s0.p(this, getString(R.string.common_operation_failed));
            return;
        }
        File file = new File(m1, Long.toString(System.currentTimeMillis()) + ".jpg");
        this.p3 = file;
        if (Build.VERSION.SDK_INT < 21) {
            uri = Uri.fromFile(file);
        } else {
            uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", this.p3);
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        startActivityForResult(intent, 11);
    }

    @TargetApi(23)
    private boolean l1(List<String> list, String str) {
        if (checkSelfPermission(str) == 0) {
            return true;
        }
        list.add(str);
        return shouldShowRequestPermissionRationale(str);
    }

    public static File m1(@NonNull Context context) {
        File file;
        if (Build.VERSION.SDK_INT >= 29) {
            file = context.getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        } else if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        } else {
            file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private void n1() {
        this.y = (LinearLayout) findViewById(R.id.activity_account_container);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.p1 = (TPCircleMaskView) findViewById(R.id.account_icon);
        this.z = (TextView) findViewById(R.id.account_nickname_tv);
        this.p0 = (TextView) findViewById(R.id.account_email_tv);
        this.p2 = (TextView) findViewById(R.id.account_info_nickname_tv);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.drawer_account);
        ((RippleView) findViewById(R.id.account_info_nickname_panel)).setOnRippleCompleteListener(new e());
        ((RippleView) findViewById(R.id.account_info_change_password_panel)).setOnRippleCompleteListener(new f());
        findViewById(R.id.account_info_logout_bt).setOnClickListener(this);
        this.p1.setOnClickListener(this);
        toolbar.setNavigationOnClickListener(new g());
    }

    @TargetApi(23)
    private void o1() {
        ArrayList arrayList = new ArrayList();
        if (o.h0().m0()) {
            l1(arrayList, "android.permission.CAMERA");
            l1(arrayList, "android.permission.READ_EXTERNAL_STORAGE");
            if (com.tplink.iot.Utils.a1.b.c()) {
                l1(arrayList, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
        } else if (!l1(arrayList, "android.permission.CAMERA")) {
            w1();
            return;
        } else if (p1(arrayList)) {
            x1();
            return;
        }
        if (!arrayList.isEmpty()) {
            new TPMaterialDialogV2.Builder(this).s(R.string.common_permissions, R.color.common_black).setMessage(R.string.account_avatar_permission_tip).o(R.string.common_allow, R.color.common_iot_main_blue, new b(arrayList)).l(R.string.common_cancel, R.color.common_iot_light_black, null).g(8, 8).show();
        } else {
            C1();
        }
    }

    private boolean p1(List<String> list) {
        if (com.tplink.iot.Utils.a1.b.c()) {
            return !l1(list, "android.permission.READ_EXTERNAL_STORAGE") || !l1(list, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return !l1(list, "android.permission.READ_EXTERNAL_STORAGE");
    }

    private void q1(Intent intent) {
        this.H3.z(intent.getData(), null);
    }

    private void r1() {
        this.H3.A(this.p3);
    }

    private void s1(String str) {
        if (!str.isEmpty()) {
            this.p1.setImageUrl(str);
        } else {
            this.p1.setStrokeWidth(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(TCAccountBean tCAccountBean) {
        if (tCAccountBean != null) {
            String displayUserName = tCAccountBean.getDisplayUserName();
            this.z.setText(displayUserName);
            this.p2.setText(displayUserName);
            if (!TextUtils.isEmpty(tCAccountBean.getEmail())) {
                this.p0.setText(tCAccountBean.getEmail());
            } else {
                this.p0.setText(tCAccountBean.getCloudUserName());
            }
            String avatarUrl = tCAccountBean.getAvatarUrl();
            if (avatarUrl != null) {
                this.p1.setImageUrl(avatarUrl);
                this.H3.y(avatarUrl);
                return;
            }
            s1(this.H3.t());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(AccountInfoViewModel.h hVar) {
        if (hVar == null) {
            s0.k(this);
            return;
        }
        int a2 = hVar.a();
        if (a2 == -1) {
            this.p1.setImageBitmap(hVar.b());
            s0.l(this);
        } else if (a2 != 0) {
            s0.g();
            s0.p(this, getString(R.string.common_operation_failed));
        } else {
            s0.g();
            s0.C(this, "", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        new TPMaterialDialogV2.Builder(this).d(R.layout.layout_change_avatar_dlg).f(new l()).g(8, 8).show();
    }

    private void w1() {
        new TPMaterialDialogV2.Builder(this).s(R.string.common_permissions, R.color.common_black).setMessage(R.string.account_avatar_camera_permission_deny_tip).o(R.string.open_settings, R.color.common_iot_main_blue, new c()).l(R.string.common_cancel, R.color.common_iot_light_black, null).g(8, 8).show();
    }

    private void x1() {
        new TPMaterialDialogV2.Builder(this).s(R.string.common_permissions, R.color.common_black).setMessage(R.string.account_avatar_storage_permission_deny_tip).o(R.string.open_settings, R.color.common_iot_main_blue, new d()).l(R.string.common_cancel, R.color.common_iot_light_black, null).g(8, 8).show();
    }

    private void y1() {
        new TPMaterialDialogV2.Builder(this).setView(R.layout.layout_dialog_image_and_message).x(new a()).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_logout, R.color.common_iot_main_blue, new m()).c(true).g(8, 8).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        o1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            if (i2 == 10) {
                q1(intent);
            } else if (i2 != 11) {
                super.onActivityResult(i2, i3, intent);
            } else {
                r1();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.account_icon) {
            this.H3.x();
            p.b();
        } else if (id == R.id.account_info_logout_bt) {
            p.j();
            y1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (com.tplink.iot.core.o.a() != 0) {
            setContentView(R.layout.activity_account);
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
            this.H3 = (AccountInfoViewModel) ViewModelProviders.of(this).get(AccountInfoViewModel.class);
            n1();
            A1();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i2 != 13) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        boolean z = true;
        boolean z2 = true;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if ("android.permission.CAMERA".equals(strArr[i3])) {
                if (iArr[i3] != 0) {
                    z = false;
                }
            } else if (("android.permission.READ_EXTERNAL_STORAGE".equals(strArr[i3]) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(strArr[i3])) && iArr[i3] != 0) {
                z2 = false;
            }
        }
        if (z && z2) {
            C1();
        } else if (!z) {
            w1();
        } else {
            x1();
        }
        o.h0().B0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
