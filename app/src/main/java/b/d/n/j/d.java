package b.d.n.j;

import b.d.n.i.f;
import com.tplink.nbu.bean.iam.Event;
import java.text.SimpleDateFormat;

/* compiled from: IAMEventLog.java */
/* loaded from: classes3.dex */
public class d {
    private static d a;

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f610b = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: c  reason: collision with root package name */
    private static final SimpleDateFormat f611c = new SimpleDateFormat("HH");

    /* renamed from: d  reason: collision with root package name */
    private f f612d;

    /* renamed from: e  reason: collision with root package name */
    private String f613e;

    /* renamed from: f  reason: collision with root package name */
    private String f614f;
    private b.d.n.i.d g;

    private d() {
    }

    private Event a(String str, String str2, String str3, String str4) {
        Event event = new Event();
        event.setAccountId(this.f613e);
        event.setAppType(this.f614f);
        event.setOs("android");
        event.setType(str4);
        event.setTaskId(str);
        event.setUnixTimestampUtc(System.currentTimeMillis());
        return event;
    }

    public static d c() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void b() {
        this.f613e = null;
    }

    public void d(String str, String str2, String str3) {
        this.g.e(a(str, str2, str3, "action_click"));
    }

    public void e(String str, String str2, String str3) {
        this.g.e(a(str, str2, str3, "action_show"));
    }

    public void f(String str) {
        this.f613e = str;
    }

    public void g(String str) {
        this.f614f = str;
    }

    public void h(b.d.n.i.d dVar) {
        this.g = dVar;
    }

    public void i(f fVar) {
        this.f612d = fVar;
    }
}
