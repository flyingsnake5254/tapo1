package com.tplink.iot.view.about;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.core.q;
import com.tplink.iot.databinding.ActivityTapoDebugBinding;
import com.tplink.libtpnetwork.Utils.a0;
import com.tplink.libtpnetwork.Utils.o;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.i;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.v;

/* compiled from: TapoDebugActivity.kt */
/* loaded from: classes2.dex */
public final class TapoDebugActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    public static final a y = new a(null);
    private final kotlin.f p0;
    private final kotlin.f p1;
    private ActivityTapoDebugBinding p2;
    private final kotlin.f z;

    /* compiled from: TapoDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TapoDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        public static final a a = new a(null);

        /* renamed from: b  reason: collision with root package name */
        private final String f8287b;

        /* renamed from: c  reason: collision with root package name */
        private final l<Activity, p> f8288c;

        /* compiled from: TapoDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public final b a(String btnName, l<? super Activity, p> action) {
                j.e(btnName, "btnName");
                j.e(action, "action");
                return new b(btnName, action);
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String btnName, l<? super Activity, p> action) {
            j.e(btnName, "btnName");
            j.e(action, "action");
            this.f8287b = btnName;
            this.f8288c = action;
        }

        public final l<Activity, p> a() {
            return this.f8288c;
        }

        public final String b() {
            return this.f8287b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TapoDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements Runnable {

        /* compiled from: TapoDebugActivity.kt */
        /* loaded from: classes2.dex */
        static final class a implements Runnable {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f8291d;

            a(String str) {
                this.f8291d = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TextView textView = TapoDebugActivity.e1(TapoDebugActivity.this).L3;
                j.d(textView, "mBinding.tvLogPath");
                textView.setText(this.f8291d);
                s0.C(TapoDebugActivity.this, "Save successfully", null);
            }
        }

        /* compiled from: TapoDebugActivity.kt */
        /* loaded from: classes2.dex */
        static final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                TextView textView = TapoDebugActivity.e1(TapoDebugActivity.this).L3;
                j.d(textView, "mBinding.tvLogPath");
                textView.setText("--");
                TapoDebugActivity tapoDebugActivity = TapoDebugActivity.this;
                s0.q(tapoDebugActivity, tapoDebugActivity.getString(R.string.common_operation_failed), null);
            }
        }

        /* compiled from: TapoDebugActivity.kt */
        /* renamed from: com.tplink.iot.view.about.TapoDebugActivity$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static final class RunnableC0217c implements Runnable {
            RunnableC0217c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                TapoDebugActivity tapoDebugActivity = TapoDebugActivity.this;
                s0.q(tapoDebugActivity, tapoDebugActivity.getString(R.string.common_operation_failed), null);
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                String log = b.d.w.c.c.e.d(TapoDebugActivity.this).c().get();
                TapoDebugActivity tapoDebugActivity = TapoDebugActivity.this;
                j.d(log, "log");
                String x1 = tapoDebugActivity.x1(log, "TPLINK", "Tapo");
                if (!TextUtils.isEmpty(x1)) {
                    TapoDebugActivity.this.runOnUiThread(new a(x1));
                } else {
                    TapoDebugActivity.this.runOnUiThread(new b());
                }
            } catch (Throwable unused) {
                TapoDebugActivity.this.runOnUiThread(new RunnableC0217c());
            }
        }
    }

    /* compiled from: TapoDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<b> {

        /* renamed from: c  reason: collision with root package name */
        public static final d f8294c = new d();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapoDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements l<Activity, p> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f8295c = new a();

            a() {
                super(1);
            }

            public final void a(Activity activity) {
                j.e(activity, "activity");
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ p invoke(Activity activity) {
                a(activity);
                return p.a;
            }
        }

        d() {
            super(0);
        }

        /* renamed from: a */
        public final b invoke() {
            return b.a.a("跳转页面按钮名称1", a.f8295c);
        }
    }

    /* compiled from: TapoDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements kotlin.jvm.b.a<b> {

        /* renamed from: c  reason: collision with root package name */
        public static final e f8296c = new e();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapoDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements l<Activity, p> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f8297c = new a();

            a() {
                super(1);
            }

            public final void a(Activity activity) {
                j.e(activity, "activity");
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ p invoke(Activity activity) {
                a(activity);
                return p.a;
            }
        }

        e() {
            super(0);
        }

        /* renamed from: a */
        public final b invoke() {
            return b.a.a("跳转页面按钮名称2", a.f8297c);
        }
    }

    /* compiled from: TapoDebugActivity.kt */
    /* loaded from: classes2.dex */
    static final class f extends Lambda implements kotlin.jvm.b.a<b> {

        /* renamed from: c  reason: collision with root package name */
        public static final f f8298c = new f();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapoDebugActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements l<Activity, p> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f8299c = new a();

            a() {
                super(1);
            }

            public final void a(Activity activity) {
                j.e(activity, "activity");
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ p invoke(Activity activity) {
                a(activity);
                return p.a;
            }
        }

        f() {
            super(0);
        }

        /* renamed from: a */
        public final b invoke() {
            return b.a.a("跳转页面按钮名称3", a.f8299c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TapoDebugActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g implements TPMaterialDialogV2.d {
        g() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public final void onClick(View view) {
            TapoDebugActivity.this.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TapoDebugActivity.this.getPackageName())), 126);
        }
    }

    public TapoDebugActivity() {
        kotlin.f b2;
        kotlin.f b3;
        kotlin.f b4;
        b2 = i.b(d.f8294c);
        this.z = b2;
        b3 = i.b(e.f8296c);
        this.p0 = b3;
        b4 = i.b(f.f8298c);
        this.p1 = b4;
    }

    private final void A1() {
        q.j(this, 0);
    }

    private final void B1() {
        q.j(this, 1);
    }

    public static final /* synthetic */ ActivityTapoDebugBinding e1(TapoDebugActivity tapoDebugActivity) {
        ActivityTapoDebugBinding activityTapoDebugBinding = tapoDebugActivity.p2;
        if (activityTapoDebugBinding == null) {
            j.t("mBinding");
        }
        return activityTapoDebugBinding;
    }

    private final void g1(List<String> list) {
        h1(list, "android.permission.READ_EXTERNAL_STORAGE");
        if (com.tplink.iot.Utils.a1.b.c()) {
            h1(list, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    private final boolean h1(List<String> list, String str) {
        if (checkSelfPermission(str) == 0) {
            return true;
        }
        list.add(str);
        return shouldShowRequestPermissionRationale(str);
    }

    private final void i1() {
        if (Build.VERSION.SDK_INT >= 23) {
            r1();
        } else {
            o1();
        }
    }

    private final File j1(String str, String str2) {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", Locale.US);
        kotlin.jvm.internal.p pVar = kotlin.jvm.internal.p.a;
        String format = String.format("%s_%s.txt", Arrays.copyOf(new Object[]{str2, simpleDateFormat.format(new Date(System.currentTimeMillis()))}, 2));
        j.d(format, "java.lang.String.format(format, *args)");
        return new File(file, format);
    }

    private final String k1(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1897523141:
                    if (str.equals("staging")) {
                        return "Staging云环境";
                    }
                    break;
                case 99349:
                    if (str.equals("dev")) {
                        return "Dev云";
                    }
                    break;
                case 3020272:
                    if (str.equals("beta")) {
                        return "Beta云";
                    }
                    break;
                case 3083686:
                    if (str.equals("dist")) {
                        return "正式环境";
                    }
                    break;
                case 93628482:
                    if (str.equals("beta2")) {
                        return "Beta2云";
                    }
                    break;
                case 93628483:
                    if (str.equals("beta3")) {
                        return "Beta3云";
                    }
                    break;
            }
        }
        return "--";
    }

    private final b l1() {
        return (b) this.z.getValue();
    }

    private final b m1() {
        return (b) this.p0.getValue();
    }

    private final b n1() {
        return (b) this.p1.getValue();
    }

    private final void o1() {
        s0.l(this);
        new Thread(new c()).start();
    }

    private final void p1() {
        ActivityTapoDebugBinding activityTapoDebugBinding = this.p2;
        if (activityTapoDebugBinding == null) {
            j.t("mBinding");
        }
        activityTapoDebugBinding.h(this);
        ActivityTapoDebugBinding activityTapoDebugBinding2 = this.p2;
        if (activityTapoDebugBinding2 == null) {
            j.t("mBinding");
        }
        activityTapoDebugBinding2.i(this);
    }

    @SuppressLint({"SetTextI18n"})
    private final void q1() {
        ActivityTapoDebugBinding activityTapoDebugBinding = this.p2;
        if (activityTapoDebugBinding == null) {
            j.t("mBinding");
        }
        View findViewById = activityTapoDebugBinding.getRoot().findViewById(R.id.toolbar_title);
        j.d(findViewById, "mBinding.root.findViewBy…View>(R.id.toolbar_title)");
        ((TextView) findViewById).setText("Tapo调试页面");
        y1();
        ActivityTapoDebugBinding activityTapoDebugBinding2 = this.p2;
        if (activityTapoDebugBinding2 == null) {
            j.t("mBinding");
        }
        Button button = activityTapoDebugBinding2.f6720c;
        j.d(button, "mBinding.btnNavigation1");
        button.setText(l1().b());
        ActivityTapoDebugBinding activityTapoDebugBinding3 = this.p2;
        if (activityTapoDebugBinding3 == null) {
            j.t("mBinding");
        }
        Button button2 = activityTapoDebugBinding3.f6721d;
        j.d(button2, "mBinding.btnNavigation2");
        button2.setText(m1().b());
        ActivityTapoDebugBinding activityTapoDebugBinding4 = this.p2;
        if (activityTapoDebugBinding4 == null) {
            j.t("mBinding");
        }
        Button button3 = activityTapoDebugBinding4.f6722f;
        j.d(button3, "mBinding.btnNavigation3");
        button3.setText(n1().b());
        ActivityTapoDebugBinding activityTapoDebugBinding5 = this.p2;
        if (activityTapoDebugBinding5 == null) {
            j.t("mBinding");
        }
        Group group = activityTapoDebugBinding5.z;
        j.d(group, "mBinding.groupNavigation");
        group.setVisibility(s1() ? 0 : 8);
    }

    @TargetApi(23)
    private final void r1() {
        ArrayList arrayList = new ArrayList();
        if (o.h0().c("is_first", true)) {
            g1(arrayList);
        } else if (t1(arrayList)) {
            z1();
            return;
        }
        if (arrayList.size() > 0) {
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            requestPermissions((String[]) array, 125);
            return;
        }
        o1();
    }

    private final boolean s1() {
        return false;
    }

    private final boolean t1(List<String> list) {
        if (com.tplink.iot.Utils.a1.b.c()) {
            if (!h1(list, "android.permission.READ_EXTERNAL_STORAGE") || !h1(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return true;
            }
        } else if (!h1(list, "android.permission.READ_EXTERNAL_STORAGE")) {
            return true;
        }
        return false;
    }

    private final void u1() {
        l1().a().invoke(this);
    }

    private final void v1() {
        m1().a().invoke(this);
    }

    private final void w1() {
        n1().a().invoke(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String x1(String str, String str2, String str3) throws FileNotFoundException {
        File file;
        if (Build.VERSION.SDK_INT >= 29) {
            file = AppContext.f6185c.getExternalFilesDir("");
        } else {
            file = Environment.getExternalStorageDirectory();
        }
        if (file != null) {
            String absolutePath = file.getAbsolutePath();
            j.d(absolutePath, "rootFile.absolutePath");
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            sb.append(File.separatorChar);
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String upperCase = str2.toUpperCase();
            j.d(upperCase, "(this as java.lang.String).toUpperCase()");
            sb.append(upperCase);
            sb.append(File.separatorChar);
            Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
            String upperCase2 = str3.toUpperCase();
            j.d(upperCase2, "(this as java.lang.String).toUpperCase()");
            sb.append(upperCase2);
            String sb2 = sb.toString();
            File j1 = j1(sb2, str3);
            if (j1 != null) {
                new PrintStream(new FileOutputStream(j1)).println(str);
                String absolutePath2 = j1.getAbsolutePath();
                j.d(absolutePath2, "destFile.absolutePath");
                return absolutePath2;
            }
            throw new FileNotFoundException("Folder " + sb2 + " doesn't exit.");
        }
        throw new FileNotFoundException("dest path doesn't exit.");
    }

    @SuppressLint({"SetTextI18n"})
    private final void y1() {
        String str;
        String e2 = a0.e();
        boolean z = false;
        if (e2 == null || e2.length() == 0) {
            e2 = j.a("nbu.iot-app-server.app", "nbu.iot-app-server.app") ? "dist" : v.w("nbu.iot-app-server.app", "nbu.iot-app-server.app.", "", false, 4, null);
        }
        ActivityTapoDebugBinding activityTapoDebugBinding = this.p2;
        if (activityTapoDebugBinding == null) {
            j.t("mBinding");
        }
        TextView textView = activityTapoDebugBinding.K3;
        j.d(textView, "mBinding.tvIotCloudEnv");
        textView.setText(k1(e2));
        ActivityTapoDebugBinding activityTapoDebugBinding2 = this.p2;
        if (activityTapoDebugBinding2 == null) {
            j.t("mBinding");
        }
        TextView textView2 = activityTapoDebugBinding2.N3;
        j.d(textView2, "mBinding.tvTpCloudEnv");
        String str2 = "beta";
        if (j.a(e2, "dist")) {
            str = k1(e2);
        } else {
            str = k1(str2);
        }
        textView2.setText(str);
        String f2 = a0.f();
        if (f2 == null || f2.length() == 0) {
            z = true;
        }
        if (!z) {
            str2 = f2;
        }
        ActivityTapoDebugBinding activityTapoDebugBinding3 = this.p2;
        if (activityTapoDebugBinding3 == null) {
            j.t("mBinding");
        }
        TextView textView3 = activityTapoDebugBinding3.M3;
        j.d(textView3, "mBinding.tvTapoCareEnv");
        textView3.setText(k1(str2));
    }

    private final void z1() {
        new TPMaterialDialogV2.Builder(this).setTitle(R.string.login_deny_storage_permission_title).setMessage(R.string.login_deny_storage_permission_message).p(R.string.action_settings, new g()).l(R.string.common_cancel, R.color.common_iot_light_black, null).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.btn_switch_cloud_env) {
            A1();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_switch_tapo_care_env) {
            B1();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_navigation_1) {
            u1();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_navigation_2) {
            v1();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_navigation_3) {
            w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_tapo_debug);
        j.d(contentView, "DataBindingUtil.setConte…yout.activity_tapo_debug)");
        this.p2 = (ActivityTapoDebugBinding) contentView;
        p1();
        q1();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf == null || valueOf.intValue() != R.id.btn_save_log) {
            return true;
        }
        i1();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        boolean z;
        j.e(permissions, "permissions");
        j.e(grantResults, "grantResults");
        if (i != 125) {
            super.onRequestPermissionsResult(i, permissions, grantResults);
            return;
        }
        int length = grantResults.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (grantResults[i2] != 0) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            o1();
        } else {
            z1();
        }
        o.h0().h("is_first", false);
    }
}
