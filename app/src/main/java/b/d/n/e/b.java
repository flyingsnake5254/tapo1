package b.d.n.e;

import b.d.n.i.d;
import com.tplink.nbu.a.a;
import com.tplink.nbu.bean.iam.Event;
import com.tplink.nbu.bean.iam.MaterialsResult;
import com.tplink.nbu.bean.iam.ShowedTaskParams;
import com.tplink.nbu.bean.iam.ShowedTaskResult;
import io.reactivex.q;

/* compiled from: IAMCloudImp.java */
/* loaded from: classes3.dex */
public class b implements d {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f550b;

    /* renamed from: c  reason: collision with root package name */
    private a f551c;

    /* renamed from: d  reason: collision with root package name */
    private final String f552d;

    public b(String str, a aVar, String str2) {
        this.f551c = aVar;
        this.f552d = str2;
        this.f550b = str;
    }

    @Override // b.d.n.i.d
    public void a(String str) {
        this.a = str;
    }

    @Override // b.d.n.i.d
    public void b(String str, String str2, b.d.n.i.a aVar) {
        b.d.n.h.b.a().execute(new c(str, str2, this.f552d, aVar));
    }

    @Override // b.d.n.i.d
    public q<ShowedTaskResult> c(String str) {
        ShowedTaskParams showedTaskParams = new ShowedTaskParams();
        showedTaskParams.setAccountId(this.a);
        showedTaskParams.setTaskId(str);
        return this.f551c.c(this.f550b, showedTaskParams);
    }

    @Override // b.d.n.i.d
    public void clear() {
        this.a = null;
    }

    @Override // b.d.n.i.d
    public q<MaterialsResult> d(String str) {
        return this.f551c.b(this.f550b, this.a, str);
    }

    @Override // b.d.n.i.d
    public void e(Event event) {
        this.f551c.a(this.f550b, event).j(a.f549c).C(io.reactivex.l0.a.b(b.d.n.h.a.a())).y();
    }
}
