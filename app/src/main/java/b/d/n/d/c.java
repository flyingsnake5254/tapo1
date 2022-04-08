package b.d.n.d;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import b.d.n.j.b;
import b.d.n.j.e;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IAMCacheImp.java */
/* loaded from: classes3.dex */
public class c implements b.d.n.i.c {
    private static final String a = b.d.n.i.c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f547b;

    /* renamed from: c  reason: collision with root package name */
    private final String f548c;

    /* compiled from: IAMCacheImp.java */
    /* loaded from: classes3.dex */
    class a extends com.google.gson.r.a<HashMap<String, String>> {
        a() {
        }
    }

    public c(Application application, String str) {
        this.f547b = application.getSharedPreferences("tp_iam_sp", 0);
        this.f548c = str;
        g();
    }

    private void g() {
        File file = new File(this.f548c);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i() {
        b.a(this.f548c + File.separator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(String str) {
        String str2 = this.f548c + File.separator + str;
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        e.b(a + " delete \n[file]:" + str2);
    }

    @Override // b.d.n.i.c
    public void a(String str) {
        SharedPreferences.Editor edit = this.f547b.edit();
        edit.putString("tp_iam_account_id", str);
        edit.apply();
    }

    @Override // b.d.n.i.c
    public void b(final String str) {
        b.d.n.h.a.a().execute(new Runnable() { // from class: b.d.n.d.a
            @Override // java.lang.Runnable
            public final void run() {
                c.this.k(str);
            }
        });
    }

    @Override // b.d.n.i.c
    public void c() {
        b.d.n.h.a.a().execute(new Runnable() { // from class: b.d.n.d.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.i();
            }
        });
    }

    @Override // b.d.n.i.c
    public void clear() {
        SharedPreferences.Editor edit = this.f547b.edit();
        edit.remove("tp_iam_account_id");
        edit.apply();
    }

    @Override // b.d.n.i.c
    public String d() {
        return this.f547b.getString("tp_iam_account_id", "");
    }

    @Override // b.d.n.i.c
    public Map<String, String> e() {
        String string = this.f547b.getString("tp_iam_resources_map", "");
        if (TextUtils.isEmpty(string)) {
            return new HashMap();
        }
        Map<String, String> map = (Map) b.d.n.j.c.a.m(string, new a().getType());
        e.b(a + " getResourcesMap \n[resMapString]:" + map);
        return map;
    }

    @Override // b.d.n.i.c
    public void f(Map<String, String> map) {
        String u = b.d.n.j.c.a.u(map);
        e.b(a + " saveResourcesMap \n[resMapString]:" + u);
        SharedPreferences.Editor edit = this.f547b.edit();
        edit.putString("tp_iam_resources_map", u);
        edit.apply();
    }
}
