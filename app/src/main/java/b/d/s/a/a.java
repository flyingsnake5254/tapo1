package b.d.s.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.iot.cloud.bean.common.IoTWebServiceIdParams;
import com.tplink.libtpnetwork.Utils.o;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: TPAppCloudContext.java */
/* loaded from: classes3.dex */
public class a {
    private static final a a = new a();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, b> f700b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private b f701c;

    /* renamed from: d  reason: collision with root package name */
    private com.tplink.cloud.context.a f702d;

    /* renamed from: e  reason: collision with root package name */
    private String f703e;

    /* renamed from: f  reason: collision with root package name */
    private IoTWebServiceIdParams f704f;
    private b g;
    private b h;

    private a() {
    }

    private b a(@NonNull TCAccountBean tCAccountBean) {
        Objects.requireNonNull(this.f702d, "mDefaultCloudEnvironment must be inited");
        b bVar = this.f700b.get(tCAccountBean.getCloudUserName());
        if (bVar != null) {
            return bVar;
        }
        com.tplink.iot.c.c.a aVar = new com.tplink.iot.c.c.a(tCAccountBean, this.f702d, this.f703e, this.f704f);
        this.f701c = aVar;
        this.f700b.put(tCAccountBean.getCloudUserName(), aVar);
        return aVar;
    }

    private b b() {
        return this.f701c;
    }

    public static b c(@NonNull TCAccountBean tCAccountBean) {
        return a.a(tCAccountBean);
    }

    public static String d() {
        TCAccountBean c2 = f().c();
        return (c2 == null || c2.getAccountId() == null) ? "" : c2.getAccountId();
    }

    public static String e() {
        TCAccountBean c2 = f().c();
        return (c2 == null || c2.getCloudUserName() == null) ? "" : c2.getCloudUserName();
    }

    public static b f() {
        a aVar = a;
        return aVar.b() != null ? aVar.b() : aVar.g;
    }

    public static b g() {
        return a.h;
    }

    public static String h() {
        String email = (f() == null || f().c() == null) ? "" : f().c().getEmail();
        return !TextUtils.isEmpty(email) ? b.d.w.h.a.g(email) : "";
    }

    public static void i(com.tplink.cloud.context.a aVar, String str, IoTWebServiceIdParams ioTWebServiceIdParams) {
        a aVar2 = a;
        aVar2.f702d = aVar;
        aVar2.f703e = str;
        aVar2.f704f = ioTWebServiceIdParams;
        TCAccountBean P = o.h0().P();
        if (P != null) {
            c(P);
        } else {
            aVar2.g = new com.tplink.iot.c.c.a(new TCAccountBean(), aVar, str, ioTWebServiceIdParams);
        }
        aVar2.h = new com.tplink.iot.c.c.a(new TCAccountBean("test@tp-link.net", "test"), aVar, str, ioTWebServiceIdParams);
    }

    public static void j(String str) {
        a.f700b.remove(str);
    }
}
