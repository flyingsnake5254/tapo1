package b.d.c.a.k;

import android.os.Bundle;
import android.text.TextUtils;
import b.d.c.a.d;
import b.d.c.a.i.b;
import b.d.c.a.m.c;
import com.tplink.libtpanalytics.bean.GAParams;
import com.tplink.libtpanalytics.core.define.TAException;
import com.tplink.libtpanalytics.core.define.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TAMGAEvent.java */
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private b f149b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f150c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f151d = true;

    public a(e eVar, b bVar) {
        super(eVar);
        this.f149b = bVar;
    }

    public void b(String str, Bundle bundle) {
        String string = bundle.getString("event_action");
        String string2 = bundle.getString("event_label");
        String string3 = bundle.getString("event_value");
        if (TextUtils.isEmpty(str)) {
            throw new TAException("categoryName required");
        } else if (!TextUtils.isEmpty(string)) {
            GAParams gAParams = new GAParams(str, string);
            if (!TextUtils.isEmpty(string2)) {
                gAParams.setLabel(string2);
            }
            if (!TextUtils.isEmpty(string3)) {
                gAParams.setValue(string3);
            }
            b.d.c.b.b bVar = new b.d.c.b.b("ga_event", this.a);
            bVar.d(gAParams);
            com.tplink.libtpanalytics.database.d.b a = b.d.c.b.a.a(bVar);
            if (a != null) {
                this.f149b.f(a);
            }
            if (!this.f151d) {
                c.f().e();
            }
        } else {
            throw new TAException("action required");
        }
    }

    public void c(String str, Bundle bundle) {
        d(str, bundle, "V1");
    }

    public void d(String str, Bundle bundle, String str2) {
        if (!this.f150c.contains(str2)) {
            b(str, bundle);
        }
    }

    public void e() {
        this.f151d = true;
    }

    public void f() {
        this.f151d = false;
    }
}
