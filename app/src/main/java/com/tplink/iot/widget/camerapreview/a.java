package com.tplink.iot.widget.camerapreview;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import b.d.d.m.f;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import com.tplink.iot.widget.camerapreview.e;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

/* compiled from: DisplayInteractor.kt */
/* loaded from: classes3.dex */
public final class a {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private final f f11698b = new f();

    /* renamed from: c  reason: collision with root package name */
    private final h f11699c = new h();

    /* renamed from: d  reason: collision with root package name */
    private e f11700d = e.a.e();

    /* renamed from: e  reason: collision with root package name */
    private final io.reactivex.e0.b f11701e = new io.reactivex.e0.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DisplayInteractor.kt */
    /* renamed from: com.tplink.iot.widget.camerapreview.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0241a<T, R> implements j<Throwable, e> {

        /* renamed from: c  reason: collision with root package name */
        public static final C0241a f11702c = new C0241a();

        C0241a() {
        }

        /* renamed from: a */
        public final e apply(Throwable it) {
            kotlin.jvm.internal.j.e(it, "it");
            return e.a.b(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DisplayInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class b<T, R> implements j<Throwable, e> {

        /* renamed from: c  reason: collision with root package name */
        public static final b f11703c = new b();

        b() {
        }

        /* renamed from: a */
        public final e apply(Throwable it) {
            kotlin.jvm.internal.j.e(it, "it");
            return e.a.b(it);
        }
    }

    public final q<e> a(boolean z) {
        if (z) {
            e.a aVar = e.a;
            q<e> j = q.j(q.f0(aVar.l().B("ShowFuncBtn")), q.f0(aVar.d().B("HideFuncBtn after 5s")).o(5L, TimeUnit.SECONDS));
            kotlin.jvm.internal.j.d(j, "Observable.concat(\n     …it.SECONDS)\n            )");
            return j;
        }
        q<e> f0 = q.f0(e.a.d().B("HideFuncBtn"));
        kotlin.jvm.internal.j.d(f0, "Observable.just(DisplayV…().setTag(\"HideFuncBtn\"))");
        return f0;
    }

    public final void b() {
        this.f11701e.d();
        this.f11699c.c();
    }

    public final q<e> c() {
        f fVar = this.f11698b;
        String str = this.a;
        kotlin.jvm.internal.j.c(str);
        return fVar.a(str);
    }

    public final MutableLiveData<f<String>> d() {
        return this.f11699c.d();
    }

    public final q<e> e() {
        Boolean x = this.f11700d.x();
        Boolean bool = Boolean.TRUE;
        if (kotlin.jvm.internal.j.a(x, bool) || ((!kotlin.jvm.internal.j.a(this.f11700d.z(), bool)) && kotlin.jvm.internal.j.a(this.f11700d.u(), bool))) {
            h hVar = this.f11699c;
            String str = this.a;
            kotlin.jvm.internal.j.c(str);
            q<e> L0 = hVar.e(str).p0(C0241a.f11702c).L0(io.reactivex.l0.a.c());
            kotlin.jvm.internal.j.d(L0, "streamDisplayEngine\n    …scribeOn(Schedulers.io())");
            return L0;
        }
        q<e> f0 = q.f0(this.f11700d.B("pause no operation"));
        kotlin.jvm.internal.j.d(f0, "Observable.just(displayV…ag(\"pause no operation\"))");
        return f0;
    }

    public final q<e> f(ViewGroup viewGroup, Context context) {
        kotlin.jvm.internal.j.e(viewGroup, "viewGroup");
        kotlin.jvm.internal.j.e(context, "context");
        if (kotlin.jvm.internal.j.a(this.f11700d.x(), Boolean.TRUE)) {
            q<e> f0 = q.f0(this.f11700d.B("play no operation"));
            kotlin.jvm.internal.j.d(f0, "Observable.just(displayV…Tag(\"play no operation\"))");
            return f0;
        }
        h hVar = this.f11699c;
        String str = this.a;
        kotlin.jvm.internal.j.c(str);
        q<e> L0 = hVar.f(str, viewGroup, context).E0(e.a.f().B("playPreLoading")).p0(b.f11703c).L0(io.reactivex.l0.a.c());
        kotlin.jvm.internal.j.d(L0, "streamDisplayEngine\n    …scribeOn(Schedulers.io())");
        return L0;
    }

    public final void g(String str) {
        this.a = str;
        if (str != null) {
            this.f11699c.g(str);
        }
    }

    public final void h(e eVar) {
        kotlin.jvm.internal.j.e(eVar, "<set-?>");
        this.f11700d = eVar;
    }

    public final q<e> i(CameraPreviewInfo previewInfo) {
        e eVar;
        kotlin.jvm.internal.j.e(previewInfo, "previewInfo");
        if (previewInfo.m()) {
            eVar = e.a.k(previewInfo.l(), previewInfo.f(), Boolean.valueOf(previewInfo.h())).B("device info");
        } else {
            eVar = e.a.j(previewInfo.l(), previewInfo.f(), Boolean.valueOf(previewInfo.h())).B("device info");
        }
        q<e> f0 = q.f0(eVar);
        kotlin.jvm.internal.j.d(f0, "Observable.just(\n       …(\"device info\")\n        )");
        return f0;
    }
}
