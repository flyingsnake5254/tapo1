package com.tplink.iot.dailysummary.viewmodel;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClipVideo;
import com.tplink.iot.h.f;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.v;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: SummaryClipListViewModel.kt */
/* loaded from: classes2.dex */
public final class SummaryClipListViewModel extends ViewModel {
    private ALCameraDevice a;

    /* renamed from: c  reason: collision with root package name */
    private SummaryClipVideo f6435c;

    /* renamed from: d  reason: collision with root package name */
    private f f6436d;

    /* renamed from: b  reason: collision with root package name */
    private String f6434b = "";

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<Integer> f6437e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<Boolean> f6438f = new MutableLiveData<>();
    private final MutableLiveData<Boolean> g = new MutableLiveData<>();
    private final MutableLiveData<Boolean> h = new MutableLiveData<>();
    private final MutableLiveData<Boolean> i = new MutableLiveData<>();
    private final MutableLiveData<Boolean> j = new MutableLiveData<>();
    private final MutableLiveData<Boolean> k = new MutableLiveData<>();
    private final MutableLiveData<Integer> l = new MutableLiveData<>();

    /* compiled from: SummaryClipListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a implements s<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bitmap f6439b;

        a(Bitmap bitmap) {
            this.f6439b = bitmap;
        }

        @Override // io.reactivex.s
        public void subscribe(r<Boolean> emitter) {
            j.e(emitter, "emitter");
            emitter.onNext(Boolean.valueOf(SummaryClipListViewModel.this.n(this.f6439b)));
            emitter.onComplete();
        }
    }

    /* compiled from: SummaryClipListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b implements v<Boolean> {
        b() {
        }

        public void a(boolean z) {
            SummaryClipListViewModel.this.k.setValue(Boolean.valueOf(z));
        }

        @Override // io.reactivex.v
        public void onComplete() {
        }

        @Override // io.reactivex.v
        public void onError(Throwable e2) {
            j.e(e2, "e");
            b.d.w.c.a.c("PlayViewModel-tyler", "capturePic failed: " + e2.getMessage());
            SummaryClipListViewModel.this.k.setValue(Boolean.FALSE);
        }

        @Override // io.reactivex.v
        public /* bridge */ /* synthetic */ void onNext(Boolean bool) {
            a(bool.booleanValue());
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c d2) {
            j.e(d2, "d");
        }
    }

    /* compiled from: SummaryClipListViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c implements com.tplink.iot.h.i.b {
        final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f6441b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f6442c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6443d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ SummaryClipListViewModel f6444e;

        c(f fVar, String str, String str2, String str3, SummaryClipListViewModel summaryClipListViewModel) {
            this.a = fVar;
            this.f6441b = str;
            this.f6442c = str2;
            this.f6443d = str3;
            this.f6444e = summaryClipListViewModel;
        }

        @Override // com.tplink.iot.h.i.b
        public void a(long j, long j2, int i) {
            f fVar = this.f6444e.f6436d;
            if (fVar != null && fVar.E() && j > 0) {
                this.f6444e.l.setValue(Integer.valueOf(Math.min((int) ((100 * j2) / j), 99)));
            }
        }

        @Override // com.tplink.iot.h.i.b
        public void b(int i, int i2) {
            ALCameraDevice aLCameraDevice = this.f6444e.a;
            if (aLCameraDevice != null) {
                b.d.q.b.p.b.u(aLCameraDevice, String.valueOf(System.currentTimeMillis()), this.a.B(), i2);
                this.f6444e.f6437e.setValue(2);
            }
        }

        @Override // com.tplink.iot.h.i.a
        public void onError(Throwable errorMsg) {
            j.e(errorMsg, "errorMsg");
            this.f6444e.f6437e.setValue(3);
        }

        @Override // com.tplink.iot.h.i.a
        public void onStart() {
            this.f6444e.f6437e.setValue(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            return false;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(b.d.q.b.p.b.h());
        String str = File.separator;
        sb.append(str);
        sb.append("cloudvideo");
        sb.append(str);
        sb.append(valueOf);
        sb.append(".jpg");
        String sb2 = sb.toString();
        b.d.q.b.p.b.u(this.a, valueOf, sb2, -1);
        FileOutputStream fileOutputStream = new FileOutputStream(new File(sb2));
        try {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream.close();
                return true;
            } catch (Exception unused) {
                b.d.w.c.a.c("PlayViewModel-tyler", "catch (ignored: Exception)! in " + getClass().getSimpleName());
                fileOutputStream.close();
                return false;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    public final void A(boolean z) {
        this.f6438f.setValue(Boolean.valueOf(z));
    }

    public final void B(int i) {
        this.f6437e.postValue(Integer.valueOf(i));
        if (i == 5) {
            this.g.postValue(Boolean.FALSE);
        } else if (i == 6) {
            this.g.postValue(Boolean.TRUE);
        }
    }

    public final void l() {
        f fVar = this.f6436d;
        if (fVar != null) {
            fVar.y();
        }
    }

    public final void m(Bitmap bitmap) {
        j.e(bitmap, "bitmap");
        q.m(new a(bitmap)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).a(new b());
    }

    public final void o(boolean z) {
        this.h.setValue(Boolean.valueOf(z));
    }

    public final void p() {
        SummaryClipVideo summaryClipVideo = this.f6435c;
        if (summaryClipVideo != null) {
            String a2 = b.d.w.h.a.a(summaryClipVideo.getM3u8());
            String uri = summaryClipVideo.getUri();
            StringBuilder sb = new StringBuilder();
            Long startTimestamp = summaryClipVideo.getStartTimestamp();
            if (startTimestamp == null) {
                startTimestamp = summaryClipVideo.getUriExpiresAt();
            }
            sb.append(String.valueOf(startTimestamp.longValue()));
            sb.append(".mp4");
            String sb2 = sb.toString();
            f fVar = new f("1000");
            fVar.z(sb2, a2, uri, new c(fVar, sb2, a2, uri, this));
            p pVar = p.a;
            this.f6436d = fVar;
        }
    }

    public final MutableLiveData<Boolean> r() {
        return this.k;
    }

    public final MutableLiveData<Integer> s() {
        return this.l;
    }

    public final MutableLiveData<Boolean> t() {
        return this.f6438f;
    }

    public final MutableLiveData<Boolean> u() {
        return this.h;
    }

    public final MutableLiveData<Integer> v() {
        return this.f6437e;
    }

    public final void w() {
        String b2 = com.tplink.iot.e.a.c.k.b();
        this.f6434b = b2;
        String g = b.d.w.h.a.g(b2);
        if (g != null && !TextUtils.isEmpty(g)) {
            TPCameraDeviceContext K1 = TPIoTClientManager.K1(g);
            j.d(K1, "TPIoTClientManager.getCameraContext(md5String)");
            ALCameraDevice cameraDevice = K1.getCameraDevice();
            if (cameraDevice != null && !d0.a(this.a, cameraDevice)) {
                this.a = cameraDevice;
            }
        }
        this.h.setValue(Boolean.TRUE);
    }

    public final void x(SummaryClipVideo clipVideo) {
        j.e(clipVideo, "clipVideo");
        this.f6435c = clipVideo;
    }

    public final void y(boolean z) {
        this.i.setValue(Boolean.valueOf(z));
    }

    public final void z(boolean z) {
        this.j.setValue(Boolean.valueOf(z));
        if (z) {
            A(false);
            this.i.setValue(Boolean.FALSE);
        }
    }
}
