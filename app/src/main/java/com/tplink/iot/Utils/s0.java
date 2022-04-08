package com.tplink.iot.Utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialog;
import com.tplink.iot.Utils.i0;
import com.tplink.iot.Utils.j0;
import com.tplink.iot.Utils.k0;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCProtocolRepository;

/* compiled from: UIUtils.java */
/* loaded from: classes2.dex */
public class s0 {
    private static h0 a;

    /* renamed from: b  reason: collision with root package name */
    private static k0 f5362b;

    /* renamed from: c  reason: collision with root package name */
    private static i0 f5363c;

    /* renamed from: d  reason: collision with root package name */
    private static j0 f5364d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIUtils.java */
    /* loaded from: classes2.dex */
    public static class a implements j0.b {
        final /* synthetic */ h a;

        a(h hVar) {
            this.a = hVar;
        }

        @Override // com.tplink.iot.Utils.j0.b
        public void onDismiss() {
            j0 unused = s0.f5364d = null;
            this.a.onDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIUtils.java */
    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (s0.f5364d != null) {
                s0.f5364d.b();
                j0 unused = s0.f5364d = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIUtils.java */
    /* loaded from: classes2.dex */
    public static class c implements k0.b {
        final /* synthetic */ h a;

        c(h hVar) {
            this.a = hVar;
        }

        @Override // com.tplink.iot.Utils.k0.b
        public void onDismiss() {
            k0 unused = s0.f5362b = null;
            this.a.onDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIUtils.java */
    /* loaded from: classes2.dex */
    public static class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (s0.f5362b != null) {
                s0.f5362b.b();
                k0 unused = s0.f5362b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIUtils.java */
    /* loaded from: classes2.dex */
    public static class e implements i0.b {
        final /* synthetic */ h a;

        e(h hVar) {
            this.a = hVar;
        }

        @Override // com.tplink.iot.Utils.i0.b
        public void onDismiss() {
            i0 unused = s0.f5363c = null;
            this.a.onDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIUtils.java */
    /* loaded from: classes2.dex */
    public static class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (s0.f5363c != null) {
                s0.f5363c.b();
                i0 unused = s0.f5363c = null;
            }
        }
    }

    /* compiled from: UIUtils.java */
    /* loaded from: classes2.dex */
    static class g implements TPMaterialDialog.d {
        g() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialog.d
        public void onClick(View view) {
            ((TCProtocolRepository) b.d.b.f.b.a(b.d.s.a.a.f(), TCProtocolRepository.class)).e().L0(io.reactivex.l0.a.c()).F0();
        }
    }

    /* compiled from: UIUtils.java */
    /* loaded from: classes2.dex */
    public interface h {
        void onDismiss();
    }

    public static void A(Activity activity, int i, h hVar) {
        z(activity, true, activity.getString(i), hVar);
    }

    public static void B(Activity activity, h hVar) {
        z(activity, true, "", hVar);
    }

    public static void C(Activity activity, CharSequence charSequence, h hVar) {
        z(activity, true, charSequence, hVar);
    }

    public static void D(Context context, long j) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }

    public static void g() {
        h0 h0Var = a;
        if (h0Var != null) {
            h0Var.c();
            a = null;
        }
    }

    public static void h() {
        j0 j0Var = f5364d;
        if (j0Var != null) {
            j0Var.b();
            f5364d = null;
        }
    }

    public static void i() {
        k0 k0Var = f5362b;
        if (k0Var != null) {
            k0Var.b();
            f5362b = null;
        }
        i0 i0Var = f5363c;
        if (i0Var != null) {
            i0Var.b();
            f5363c = null;
        }
    }

    public static boolean j() {
        h0 h0Var = a;
        return h0Var != null && h0Var.f();
    }

    public static void k(Activity activity) {
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            TPMaterialDialog.Builder builder = new TPMaterialDialog.Builder(activity);
            builder.m(activity.getString(R.string.cloud_unavailable));
            builder.g(activity.getString(R.string.cloud_unavailable_message));
            builder.setCancelable(false);
            builder.c(false);
            builder.i(R.string.common_ok, R.color.common_iot_main_blue, new g());
            builder.create().show();
        }
    }

    public static boolean l(Activity activity) {
        return m(activity, null);
    }

    public static boolean m(Activity activity, String str) {
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        h0 h0Var = a;
        if (h0Var == null || !h0Var.f() || activity != a.d()) {
            h0 h0Var2 = new h0(activity);
            a = h0Var2;
            h0Var2.h(str);
            a.g(false);
            a.i();
            return true;
        }
        a.h(str);
        return true;
    }

    public static void n(Activity activity, int i) {
        z(activity, false, activity.getString(i), null);
    }

    public static void o(Activity activity, int i, h hVar) {
        z(activity, false, activity.getString(i), hVar);
    }

    public static void p(Activity activity, CharSequence charSequence) {
        z(activity, false, charSequence, null);
    }

    public static void q(Activity activity, CharSequence charSequence, h hVar) {
        z(activity, false, charSequence, hVar);
    }

    public static void r(Activity activity, CharSequence charSequence, long j) {
        y(activity, false, charSequence, 0, null, j);
    }

    public static void s(Activity activity, int i) {
        w(activity, activity.getString(i), null);
    }

    public static void t(Activity activity, int i, h hVar) {
        x(activity, activity.getString(i), hVar, 2000L);
    }

    public static void u(Activity activity, int i, h hVar, long j) {
        x(activity, activity.getString(i), hVar, j);
    }

    public static void v(Activity activity, String str) {
        w(activity, str, null);
    }

    public static void w(Activity activity, String str, h hVar) {
        x(activity, str, hVar, 2000L);
    }

    public static void x(Activity activity, String str, h hVar, long j) {
        j0 j0Var = f5364d;
        if (j0Var != null) {
            j0Var.b();
            f5364d = null;
        }
        j0 j0Var2 = new j0(activity, str);
        f5364d = j0Var2;
        j0Var2.d();
        if (hVar != null) {
            f5364d.c(new a(hVar));
        }
        new Handler().postDelayed(new b(), j);
    }

    private static void y(Activity activity, boolean z, CharSequence charSequence, int i, h hVar, long j) {
        h0 h0Var = a;
        String str = null;
        if (h0Var != null) {
            h0Var.c();
            a = null;
        }
        k0 k0Var = f5362b;
        if (k0Var != null) {
            k0Var.b();
            f5362b = null;
        }
        i0 i0Var = f5363c;
        if (i0Var != null) {
            i0Var.b();
            f5363c = null;
        }
        j0 j0Var = f5364d;
        if (j0Var != null) {
            j0Var.b();
            f5364d = null;
        }
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            if (z) {
                k0 k0Var2 = new k0(activity, ((Object) charSequence) + "");
                f5362b = k0Var2;
                k0Var2.d(((Object) charSequence) + "");
                f5362b.c(false);
                f5362b.f();
                if (hVar != null) {
                    f5362b.e(new c(hVar));
                }
                new Handler().postDelayed(new d(), j);
                return;
            }
            i0 i0Var2 = new i0(activity, ((Object) charSequence) + "");
            f5363c = i0Var2;
            if (!TextUtils.isEmpty(charSequence)) {
                str = ((Object) charSequence) + "";
            }
            i0Var2.e(str);
            if (i > 0) {
                f5363c.d(i);
            }
            f5363c.c(false);
            f5363c.g();
            if (hVar != null) {
                f5363c.f(new e(hVar));
            }
            new Handler().postDelayed(new f(), j);
        }
    }

    private static void z(Activity activity, boolean z, CharSequence charSequence, h hVar) {
        y(activity, z, charSequence, 0, hVar, 2000L);
    }
}
