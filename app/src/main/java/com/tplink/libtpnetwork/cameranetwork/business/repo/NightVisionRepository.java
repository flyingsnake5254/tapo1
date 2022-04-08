package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.model.ImageFlip;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionCapability;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionMode;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionModeType;
import com.tplink.libtpnetwork.cameranetwork.model.WhiteLampConfig;
import com.tplink.libtpnetwork.cameranetwork.model.WhitelampState;
import io.reactivex.q;
import java.util.ArrayList;

/* compiled from: NightVisionRepository.kt */
/* loaded from: classes3.dex */
public final class NightVisionRepository extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c {

    /* renamed from: d  reason: collision with root package name */
    private boolean f14294d;

    /* renamed from: e  reason: collision with root package name */
    private NightVisionModeType f14295e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<NightVisionModeType> f14296f = new ArrayList<>();
    private String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements io.reactivex.g0.g<ImageFlip> {
        a() {
        }

        /* renamed from: a */
        public final void accept(ImageFlip imageFlip) {
            NightVisionRepository.this.D(imageFlip != null ? imageFlip.isWhiteLampOn() : false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class b<T, R> implements io.reactivex.g0.j<ImageFlip, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public static final b f14298c = new b();

        b() {
        }

        /* renamed from: a */
        public final Boolean apply(ImageFlip it) {
            kotlin.jvm.internal.j.e(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f14299c = new c();

        c() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class d<T> implements io.reactivex.g0.g<ImageFlip> {
        d() {
        }

        /* renamed from: a */
        public final void accept(ImageFlip imageFlip) {
            if (imageFlip != null) {
                NightVisionRepository.this.B(imageFlip.getWtlIntensityLevel());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class e<T, R> implements io.reactivex.g0.j<ImageFlip, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public static final e f14301c = new e();

        e() {
        }

        /* renamed from: a */
        public final Boolean apply(ImageFlip it) {
            kotlin.jvm.internal.j.e(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class f<T> implements io.reactivex.g0.g<Object> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f14303d;

        f(boolean z) {
            this.f14303d = z;
        }

        @Override // io.reactivex.g0.g
        public final void accept(Object obj) {
            NightVisionRepository.this.D(this.f14303d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class g<T, R> implements io.reactivex.g0.j<Object, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public static final g f14304c = new g();

        g() {
        }

        /* renamed from: a */
        public final Boolean apply(Object it) {
            kotlin.jvm.internal.j.e(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class h<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final h f14305c = new h();

        h() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class i<T> implements io.reactivex.g0.g<Object> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ NightVisionModeType f14307d;

        i(NightVisionModeType nightVisionModeType) {
            this.f14307d = nightVisionModeType;
        }

        @Override // io.reactivex.g0.g
        public final void accept(Object obj) {
            NightVisionRepository.this.z(this.f14307d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class j<T, R> implements io.reactivex.g0.j<Object, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public static final j f14308c = new j();

        j() {
        }

        /* renamed from: a */
        public final Boolean apply(Object it) {
            kotlin.jvm.internal.j.e(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class k<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        public static final k f14309c = new k();

        k() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class l<T> implements io.reactivex.g0.g<Object> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f14311d;

        l(int i) {
            this.f14311d = i;
        }

        @Override // io.reactivex.g0.g
        public final void accept(Object obj) {
            NightVisionRepository.this.B(String.valueOf(this.f14311d));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NightVisionRepository.kt */
    /* loaded from: classes3.dex */
    public static final class m<T, R> implements io.reactivex.g0.j<Object, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public static final m f14312c = new m();

        m() {
        }

        /* renamed from: a */
        public final Boolean apply(Object it) {
            kotlin.jvm.internal.j.e(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NightVisionRepository(@NonNull TPCameraDeviceContext deviceContext) {
        super(deviceContext);
        kotlin.jvm.internal.j.e(deviceContext, "deviceContext");
    }

    public final q<Boolean> A(NightVisionModeType mode) {
        kotlin.jvm.internal.j.e(mode, "mode");
        q<Boolean> L0 = this.f14514c.O2(new NightVisionMode(mode)).i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).E(new i(mode)).g0(j.f14308c).C(k.f14309c).L0(io.reactivex.l0.a.c());
        kotlin.jvm.internal.j.d(L0, "cameraClient.setNightVis…scribeOn(Schedulers.io())");
        return L0;
    }

    public final void B(String str) {
        this.g = str;
    }

    public final q<Boolean> C(int i2) {
        q<Boolean> L0 = this.f14514c.b3(new WhiteLampConfig(i2)).i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).E(new l(i2)).g0(m.f14312c).L0(io.reactivex.l0.a.c());
        kotlin.jvm.internal.j.d(L0, "cameraClient.setWhiteLam…scribeOn(Schedulers.io())");
        return L0;
    }

    public final void D(boolean z) {
        this.f14294d = z;
    }

    public final void E(NightVisionCapability nightVisionCapability) {
        kotlin.jvm.internal.j.e(nightVisionCapability, "nightVisionCapability");
        this.f14296f.clear();
        this.f14296f.addAll(nightVisionCapability.getNightVisionModeTypes());
    }

    public final void F(ImageFlip imageFlip) {
        this.f14294d = imageFlip != null ? imageFlip.isWhiteLampOn() : false;
        this.f14295e = imageFlip != null ? imageFlip.getNightVisionModeType() : null;
    }

    public final q<Boolean> s() {
        f4 cameraClient = this.f14514c;
        kotlin.jvm.internal.j.d(cameraClient, "cameraClient");
        q<Boolean> L0 = cameraClient.P().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).E(new a()).g0(b.f14298c).C(c.f14299c).L0(io.reactivex.l0.a.c());
        kotlin.jvm.internal.j.d(L0, "cameraClient.forceWhitel…scribeOn(Schedulers.io())");
        return L0;
    }

    public final NightVisionModeType t() {
        return this.f14295e;
    }

    public final ArrayList<NightVisionModeType> u() {
        return this.f14296f;
    }

    public final String v() {
        return this.g;
    }

    public final q<Boolean> w() {
        f4 cameraClient = this.f14514c;
        kotlin.jvm.internal.j.d(cameraClient, "cameraClient");
        q<Boolean> L0 = cameraClient.A0().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).E(new d()).g0(e.f14301c).L0(io.reactivex.l0.a.c());
        kotlin.jvm.internal.j.d(L0, "cameraClient.whiteLampCo…scribeOn(Schedulers.io())");
        return L0;
    }

    public final boolean x() {
        return this.f14294d;
    }

    public final q<Boolean> y(boolean z) {
        q<Boolean> L0 = this.f14514c.w2(new WhitelampState(z)).i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).E(new f(z)).g0(g.f14304c).C(h.f14305c).L0(io.reactivex.l0.a.c());
        kotlin.jvm.internal.j.d(L0, "cameraClient.setForceWhi…scribeOn(Schedulers.io())");
        return L0;
    }

    public final void z(NightVisionModeType nightVisionModeType) {
        this.f14295e = nightVisionModeType;
    }
}
