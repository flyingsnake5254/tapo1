package com.tplink.iot.widget.camerapreview;

import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.hannesdorfmann.mosby3.mvi.c;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import io.reactivex.q;
import io.reactivex.t;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: DisplayPresenter.kt */
/* loaded from: classes3.dex */
public final class b extends com.hannesdorfmann.mosby3.mvi.c<d, e> {
    private String i;
    private final a j = new a();
    private d k;

    /* compiled from: DisplayPresenter.kt */
    /* loaded from: classes3.dex */
    static final /* synthetic */ class a extends FunctionReferenceImpl implements p<d, e, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        public static final a f11704c = new a();

        a() {
            super(2, d.class, "render", "render(Lcom/tplink/iot/widget/camerapreview/DisplayViewState;)V", 0);
        }

        public final void a(d p1, e p2) {
            kotlin.jvm.internal.j.e(p1, "p1");
            kotlin.jvm.internal.j.e(p2, "p2");
            p1.s0(p2);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(d dVar, e eVar) {
            a(dVar, eVar);
            return kotlin.p.a;
        }
    }

    /* compiled from: DisplayPresenter.kt */
    /* renamed from: com.tplink.iot.widget.camerapreview.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0242b<V extends com.hannesdorfmann.mosby3.k.b, I> implements c.AbstractC0183c<d, CameraPreviewInfo> {
        public static final C0242b a = new C0242b();

        C0242b() {
        }

        /* renamed from: b */
        public final q<CameraPreviewInfo> a(d it) {
            kotlin.jvm.internal.j.e(it, "it");
            return it.K();
        }
    }

    /* compiled from: DisplayPresenter.kt */
    /* loaded from: classes3.dex */
    static final class c<T, R> implements io.reactivex.g0.j<CameraPreviewInfo, t<? extends e>> {
        c() {
        }

        /* renamed from: a */
        public final t<? extends e> apply(CameraPreviewInfo previewInfo) {
            kotlin.jvm.internal.j.e(previewInfo, "previewInfo");
            return b.this.j.i(previewInfo);
        }
    }

    /* compiled from: DisplayPresenter.kt */
    /* loaded from: classes3.dex */
    static final class d<V extends com.hannesdorfmann.mosby3.k.b, I> implements c.AbstractC0183c<d, Boolean> {
        public static final d a = new d();

        d() {
        }

        /* renamed from: b */
        public final q<Boolean> a(d it) {
            kotlin.jvm.internal.j.e(it, "it");
            return it.getFirmwareIntent();
        }
    }

    /* compiled from: DisplayPresenter.kt */
    /* loaded from: classes3.dex */
    static final class e<T, R> implements io.reactivex.g0.j<Boolean, t<? extends e>> {
        e() {
        }

        /* renamed from: a */
        public final t<? extends e> apply(Boolean it) {
            kotlin.jvm.internal.j.e(it, "it");
            return b.this.j.c();
        }
    }

    /* compiled from: DisplayPresenter.kt */
    /* loaded from: classes3.dex */
    static final class f<V extends com.hannesdorfmann.mosby3.k.b, I> implements c.AbstractC0183c<d, Boolean> {
        public static final f a = new f();

        f() {
        }

        /* renamed from: b */
        public final q<Boolean> a(d it) {
            kotlin.jvm.internal.j.e(it, "it");
            return it.P();
        }
    }

    /* compiled from: DisplayPresenter.kt */
    /* loaded from: classes3.dex */
    static final class g<T, R> implements io.reactivex.g0.j<Boolean, t<? extends e>> {
        g() {
        }

        /* renamed from: a */
        public final t<? extends e> apply(Boolean visible) {
            kotlin.jvm.internal.j.e(visible, "visible");
            return b.this.j.a(visible.booleanValue());
        }
    }

    /* compiled from: DisplayPresenter.kt */
    /* loaded from: classes3.dex */
    static final class h<V extends com.hannesdorfmann.mosby3.k.b, I> implements c.AbstractC0183c<d, Boolean> {
        public static final h a = new h();

        h() {
        }

        /* renamed from: b */
        public final q<Boolean> a(d it) {
            kotlin.jvm.internal.j.e(it, "it");
            return it.x0();
        }
    }

    /* compiled from: DisplayPresenter.kt */
    /* loaded from: classes3.dex */
    static final class i<T, R> implements io.reactivex.g0.j<Boolean, t<? extends e>> {
        i() {
        }

        /* renamed from: a */
        public final t<? extends e> apply(Boolean isPlay) {
            kotlin.jvm.internal.j.e(isPlay, "isPlay");
            a aVar = b.this.j;
            if (!isPlay.booleanValue()) {
                return aVar.e();
            }
            d dVar = b.this.k;
            kotlin.jvm.internal.j.c(dVar);
            ViewGroup parentView = dVar.getParentView();
            d dVar2 = b.this.k;
            kotlin.jvm.internal.j.c(dVar2);
            return aVar.f(parentView, dVar2.getContextForView());
        }
    }

    /* compiled from: DisplayPresenter.kt */
    /* loaded from: classes3.dex */
    static final class j<T1, T2, R> implements io.reactivex.g0.c<e, e, e> {
        j() {
        }

        /* renamed from: a */
        public final e apply(e t1, e t2) {
            kotlin.jvm.internal.j.e(t1, "t1");
            kotlin.jvm.internal.j.e(t2, "t2");
            e r = b.this.r(t1, t2);
            a aVar = b.this.j;
            kotlin.jvm.internal.j.d(r, "this");
            aVar.h(r);
            return r;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e r(e eVar, e eVar2) {
        Boolean z = eVar2.z();
        Boolean bool = Boolean.FALSE;
        if (!kotlin.jvm.internal.j.a(z, bool) || !kotlin.jvm.internal.j.a(eVar2.v(), bool) || eVar2.w() != null) {
            return eVar2.A(eVar);
        }
        Boolean z2 = eVar.z();
        Boolean bool2 = Boolean.TRUE;
        return (kotlin.jvm.internal.j.a(z2, bool2) || kotlin.jvm.internal.j.a(eVar.v(), bool2)) ? eVar2.A(eVar) : eVar;
    }

    @Override // com.hannesdorfmann.mosby3.mvi.c, com.hannesdorfmann.mosby3.k.a
    public void destroy() {
        super.destroy();
        this.j.b();
    }

    @Override // com.hannesdorfmann.mosby3.mvi.c
    protected void e() {
        q z0 = q.h0(g(h.a).O0(new i()).l0(io.reactivex.d0.b.a.a()), g(f.a).O0(new g()).l0(io.reactivex.d0.b.a.a()), g(C0242b.a).O0(new c()).l0(io.reactivex.d0.b.a.a()), g(d.a).O0(new e()).l0(io.reactivex.d0.b.a.a())).z0(e.a.e().B("initialViewState"), new j());
        a aVar = a.f11704c;
        Object obj = aVar;
        if (aVar != null) {
            obj = new c(aVar);
        }
        i(z0, (c.d) obj);
    }

    /* renamed from: o */
    public void a(d view) {
        kotlin.jvm.internal.j.e(view, "view");
        super.a(view);
        this.k = view;
    }

    public final MutableLiveData<b.d.d.m.f<String>> p() {
        return this.j.d();
    }

    public final void q(String str) {
        this.i = str;
        this.j.g(str);
    }
}
