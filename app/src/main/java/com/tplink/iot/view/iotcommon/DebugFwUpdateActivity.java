package com.tplink.iot.view.iotcommon;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.textfield.TextInputEditText;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.databinding.ActivityDebugFwUpdateBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.DeviceTimeInfo;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.FwDownloadStatus;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Lambda;

/* compiled from: DebugFwUpdateActivity.kt */
/* loaded from: classes2.dex */
public final class DebugFwUpdateActivity extends IoTMVVMBaseActivity<ActivityDebugFwUpdateBinding> {
    private final kotlin.f p0;
    private final kotlin.f p1;
    private final kotlin.f p2;
    private final kotlin.f p3;

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Object systemService = DebugFwUpdateActivity.this.getSystemService("clipboard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            String A1 = DebugFwUpdateActivity.this.A1();
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("FirmwareUrl", A1));
            DebugFwUpdateActivity debugFwUpdateActivity = DebugFwUpdateActivity.this;
            Toast.makeText(debugFwUpdateActivity, "已复制：" + A1, 0).show();
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CharSequence charSequence;
            ClipData.Item itemAt;
            Object systemService = DebugFwUpdateActivity.this.getSystemService("clipboard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipData primaryClip = ((ClipboardManager) systemService).getPrimaryClip();
            if (primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null || (charSequence = itemAt.getText()) == null) {
                Toast.makeText(DebugFwUpdateActivity.this, "剪贴板为空", 0).show();
                charSequence = "";
            }
            Matcher matcher = Pattern.compile("^http://(.*):(.*)/(.*).bin$").matcher(charSequence);
            if (matcher.matches() && matcher.groupCount() == 3) {
                DebugFwUpdateActivity.p1(DebugFwUpdateActivity.this).p1.setText(matcher.group(1));
                DebugFwUpdateActivity.p1(DebugFwUpdateActivity.this).p2.setText(matcher.group(2));
                DebugFwUpdateActivity.p1(DebugFwUpdateActivity.this).p0.setText(matcher.group(3));
            }
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View it) {
            kotlin.jvm.internal.j.d(it, "it");
            it.setEnabled(false);
            DebugFwUpdateActivity.this.K1();
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DebugFwUpdateActivity debugFwUpdateActivity = DebugFwUpdateActivity.this;
            debugFwUpdateActivity.H1(debugFwUpdateActivity.F1().h());
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DebugFwUpdateActivity debugFwUpdateActivity = DebugFwUpdateActivity.this;
            TextInputEditText textInputEditText = DebugFwUpdateActivity.p1(debugFwUpdateActivity).H3;
            kotlin.jvm.internal.j.d(textInputEditText, "mBinding.etWlanSsid");
            String valueOf = String.valueOf(textInputEditText.getText());
            TextInputEditText textInputEditText2 = DebugFwUpdateActivity.p1(DebugFwUpdateActivity.this).p3;
            kotlin.jvm.internal.j.d(textInputEditText2, "mBinding.etWlanPsd");
            String valueOf2 = String.valueOf(textInputEditText2.getText());
            TextInputEditText textInputEditText3 = DebugFwUpdateActivity.p1(DebugFwUpdateActivity.this).I3;
            kotlin.jvm.internal.j.d(textInputEditText3, "mBinding.etWlanType");
            debugFwUpdateActivity.I1(valueOf, valueOf2, String.valueOf(textInputEditText3.getText()));
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DebugFwUpdateActivity.this.B1();
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DebugFwUpdateActivity.this.J1();
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class h extends Lambda implements kotlin.jvm.b.a<TextView> {
        h() {
            super(0);
        }

        /* renamed from: a */
        public final TextView invoke() {
            TextView textView = DebugFwUpdateActivity.p1(DebugFwUpdateActivity.this).W3;
            kotlin.jvm.internal.j.d(textView, "mBinding.tvDeviceTime");
            return textView;
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class i extends Lambda implements kotlin.jvm.b.a<ProgressBar> {
        i() {
            super(0);
        }

        /* renamed from: a */
        public final ProgressBar invoke() {
            ProgressBar progressBar = DebugFwUpdateActivity.p1(DebugFwUpdateActivity.this).M3;
            kotlin.jvm.internal.j.d(progressBar, "mBinding.progressBar");
            return progressBar;
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class j extends Lambda implements kotlin.jvm.b.a<TextView> {
        j() {
            super(0);
        }

        /* renamed from: a */
        public final TextView invoke() {
            TextView textView = DebugFwUpdateActivity.p1(DebugFwUpdateActivity.this).Z3;
            kotlin.jvm.internal.j.d(textView, "mBinding.tvProgress");
            return textView;
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class k extends Lambda implements kotlin.jvm.b.a<DebugFwUpdateViewModel> {
        k() {
            super(0);
        }

        /* renamed from: a */
        public final DebugFwUpdateViewModel invoke() {
            DebugFwUpdateActivity debugFwUpdateActivity = DebugFwUpdateActivity.this;
            ViewModel viewModel = new ViewModelProvider(debugFwUpdateActivity, new IoTViewModelFactory(debugFwUpdateActivity, debugFwUpdateActivity.g1())).get(DebugFwUpdateViewModel.class);
            kotlin.jvm.internal.j.d(viewModel, "ViewModelProvider(this, …ateViewModel::class.java)");
            return (DebugFwUpdateViewModel) viewModel;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class l<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        l() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            com.tplink.iot.Utils.extension.e.m(DebugFwUpdateActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class m implements io.reactivex.g0.a {
        m() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            com.tplink.iot.Utils.extension.e.g(DebugFwUpdateActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class n<T> implements io.reactivex.g0.g<Throwable> {
        n() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.tplink.iot.Utils.extension.e.e(DebugFwUpdateActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class o<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        o() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            com.tplink.iot.Utils.extension.e.m(DebugFwUpdateActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class p implements io.reactivex.g0.a {
        p() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            com.tplink.iot.Utils.extension.e.g(DebugFwUpdateActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class q<T> implements io.reactivex.g0.g<Throwable> {
        q() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.tplink.iot.Utils.extension.e.e(DebugFwUpdateActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class r extends Lambda implements kotlin.jvm.b.l<com.tplink.iot.Utils.extension.f, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f8581c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(String str) {
            super(1);
            this.f8581c = str;
        }

        public final void a(com.tplink.iot.Utils.extension.f receiver) {
            kotlin.jvm.internal.j.e(receiver, "$receiver");
            receiver.j("ThingModel");
            String thingModelStr = this.f8581c;
            kotlin.jvm.internal.j.d(thingModelStr, "thingModelStr");
            receiver.i(thingModelStr);
            com.tplink.iot.Utils.extension.f.g(receiver, R.string.common_ok, receiver.b(), null, 4, null);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.p invoke(com.tplink.iot.Utils.extension.f fVar) {
            a(fVar);
            return kotlin.p.a;
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class s<T> implements Observer<FwDownloadStatus> {
        s() {
        }

        /* renamed from: a */
        public final void onChanged(FwDownloadStatus it) {
            DebugFwUpdateActivity debugFwUpdateActivity = DebugFwUpdateActivity.this;
            kotlin.jvm.internal.j.d(it, "it");
            debugFwUpdateActivity.G1(it);
        }
    }

    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    static final class t<T> implements Observer<DeviceTimeInfo> {
        t() {
        }

        /* renamed from: a */
        public final void onChanged(DeviceTimeInfo deviceTimeInfo) {
            DebugFwUpdateActivity.this.C1().setText(com.tplink.libtpnetwork.Utils.i.j(deviceTimeInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class u<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {
        u() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            s0.m(DebugFwUpdateActivity.this, "Sending command...");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class v implements io.reactivex.g0.a {
        v() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            s0.C(DebugFwUpdateActivity.this, "Send command success", null);
            DebugFwUpdateActivity.this.L1(0);
            DebugFwUpdateActivity.this.F1().t(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugFwUpdateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class w<T> implements io.reactivex.g0.g<Throwable> {
        w() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            Button button = DebugFwUpdateActivity.p1(DebugFwUpdateActivity.this).f6538f;
            kotlin.jvm.internal.j.d(button, "mBinding.btnDownload");
            button.setEnabled(true);
            DebugFwUpdateActivity debugFwUpdateActivity = DebugFwUpdateActivity.this;
            s0.p(debugFwUpdateActivity, "Send command Failed：" + th);
        }
    }

    public DebugFwUpdateActivity() {
        kotlin.f b2;
        kotlin.f b3;
        kotlin.f b4;
        kotlin.f b5;
        b2 = kotlin.i.b(new i());
        this.p0 = b2;
        b3 = kotlin.i.b(new j());
        this.p1 = b3;
        b4 = kotlin.i.b(new h());
        this.p2 = b4;
        b5 = kotlin.i.b(new k());
        this.p3 = b5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String A1() {
        StringBuilder sb = new StringBuilder();
        sb.append(SSLClient.HTTP_PREFIX);
        TextInputEditText textInputEditText = f1().p1;
        kotlin.jvm.internal.j.d(textInputEditText, "mBinding.etIp");
        sb.append((Object) textInputEditText.getText());
        sb.append(':');
        TextInputEditText textInputEditText2 = f1().p2;
        kotlin.jvm.internal.j.d(textInputEditText2, "mBinding.etPort");
        sb.append((Object) textInputEditText2.getText());
        sb.append('/');
        TextInputEditText textInputEditText3 = f1().p0;
        kotlin.jvm.internal.j.d(textInputEditText3, "mBinding.etFile");
        sb.append((Object) textInputEditText3.getText());
        sb.append(".bin");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1() {
        F1().j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView C1() {
        return (TextView) this.p2.getValue();
    }

    private final ProgressBar D1() {
        return (ProgressBar) this.p0.getValue();
    }

    private final TextView E1() {
        return (TextView) this.p1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DebugFwUpdateViewModel F1() {
        return (DebugFwUpdateViewModel) this.p3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1(FwDownloadStatus fwDownloadStatus) {
        switch (fwDownloadStatus.getErrorCode()) {
            case 1:
            case 3:
                Button button = f1().f6538f;
                kotlin.jvm.internal.j.d(button, "mBinding.btnDownload");
                button.setEnabled(true);
                z1();
                return;
            case 2:
                Button button2 = f1().f6538f;
                kotlin.jvm.internal.j.d(button2, "mBinding.btnDownload");
                button2.setEnabled(true);
                L1(100);
                s0.C(this, "下载成功", null);
                return;
            case 4:
                L1(fwDownloadStatus.getDownloadProgress());
                return;
            case 5:
                Button button3 = f1().f6538f;
                kotlin.jvm.internal.j.d(button3, "mBinding.btnDownload");
                button3.setEnabled(true);
                L1(100);
                s0.m(this, "安装固件中...");
                return;
            case 6:
                Button button4 = f1().f6538f;
                kotlin.jvm.internal.j.d(button4, "mBinding.btnDownload");
                button4.setEnabled(true);
                s0.C(this, "安装成功！", null);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1(String str) {
        F1().r(str).r(io.reactivex.d0.b.a.a()).l(new l()).i(new m()).j(new n()).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1(String str, String str2, String str3) {
        F1().s(str, str2, str3).r(io.reactivex.d0.b.a.a()).l(new o()).i(new p()).j(new q()).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1() {
        com.tplink.iot.Utils.extension.e.r(this, new r(com.tplink.libtpnetwork.Utils.i.j(F1().m())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        boolean r2;
        String A1 = A1();
        r2 = kotlin.text.v.r(A1);
        if (!r2) {
            F1().p(A1).C(io.reactivex.l0.a.c()).r(io.reactivex.d0.b.a.a()).l(new u()).i(new v()).j(new w()).y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void L1(int i2) {
        D1().setProgress(i2);
        TextView E1 = E1();
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append('%');
        E1.setText(sb.toString());
    }

    public static final /* synthetic */ ActivityDebugFwUpdateBinding p1(DebugFwUpdateActivity debugFwUpdateActivity) {
        return debugFwUpdateActivity.f1();
    }

    private final void z1() {
        s0.p(this, "下载失败");
        L1(0);
        Button button = f1().f6538f;
        kotlin.jvm.internal.j.d(button, "mBinding.btnDownload");
        button.setEnabled(true);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_debug_fw_update;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    @SuppressLint({"SetTextI18n"})
    public void j1() {
        c1("设备调试控制台");
        TextView textView = f1().V3;
        kotlin.jvm.internal.j.d(textView, "mBinding.tvConnectionType");
        textView.setText(F1().n() ? "本地" : "远程");
        f1().f6537d.setOnClickListener(new a());
        f1().x.setOnClickListener(new b());
        f1().f6538f.setOnClickListener(new c());
        f1().y.setOnClickListener(new d());
        f1().f6536c.setOnClickListener(new e());
        f1().q.setOnClickListener(new f());
        f1().z.setOnClickListener(new g());
        L1(0);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void k1() {
        F1().t(true);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void l1() {
        super.l1();
        f1().h(F1());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        F1().l().observe(this, new s());
        F1().k().observe(this, new t());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        F1().u();
        super.onDestroy();
    }
}
