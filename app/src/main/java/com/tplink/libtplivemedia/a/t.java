package com.tplink.libtplivemedia.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableLong;
import androidx.lifecycle.MutableLiveData;
import b.d.d.h.c;
import b.d.d.h.d;
import b.d.d.m.f;
import b.d.h.b;
import b.d.j.a.a;
import b.d.r.a.e;
import b.d.z.b.g;
import b.d.z.b.h;
import b.d.z.b.i;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.libmediakit.jniinterface.DecoderProperty;
import com.tplink.libmediakit.media.audioprocess.b;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpappcommonmedia.bean.stream.MediaDataFormat;
import com.tplink.libtpappcommonmedia.bean.stream.StreamMediaData;
import com.tplink.libtpdemux.tsdemux.common.EnumESFrameType;
import com.tplink.libtpdemux.tsdemux.common.EnumESType;
import com.tplink.libtplivemedia.a.t;
import com.tplink.libtpstreamclientmanager.m;
import com.tplink.libtpvideorender.view.GestureSurfaceView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: StreamDisplayClient.java */
/* loaded from: classes3.dex */
public class t implements g, b.d.x.a, b.a, h, b.d.r.a.g.b, b.d.d.h.b, b.d.d.h.a, Runnable, a.AbstractC0020a {
    private b.d.e.a H3;
    private c L3;
    private d M3;
    private BitStreamType O3;

    /* renamed from: d  reason: collision with root package name */
    private GestureSurfaceView f12561d;
    private MutableLiveData<f<Pair<Bitmap, String>>> d4;
    private MutableLiveData<f<String>> e4;

    /* renamed from: f  reason: collision with root package name */
    private Context f12562f;
    private final String f4;
    private b.d.d.g.b i4;
    private b.d.j.a.a p1;
    private com.tplink.libmediakit.media.audioprocess.b<com.tplink.libmediakit.media.audioprocess.a> p2;
    private b.d.x.b p3;
    private i q;
    private b x;

    /* renamed from: c  reason: collision with root package name */
    private final String f12560c = "StreamDisplayClient";
    private final Object z = new Object();
    protected DecoderProperty p0 = new DecoderProperty();
    private b.d.r.a.g.a K3 = null;
    private final Object N3 = new Object();
    private int P3 = 0;
    private int Q3 = 0;
    private float R3 = 1.0f;
    private int S3 = 1;
    private boolean T3 = false;
    private boolean U3 = false;
    private volatile boolean V3 = false;
    private final AtomicBoolean W3 = new AtomicBoolean(false);
    private volatile boolean X3 = false;
    private boolean Y3 = false;
    private boolean Z3 = false;
    private final ObservableBoolean a4 = new ObservableBoolean();
    private final ObservableBoolean b4 = new ObservableBoolean(false);
    private final ObservableLong c4 = new ObservableLong(0);
    private final ArrayList<WeakReference<b.d.z.a.a>> h4 = new ArrayList<>();
    private Handler j4 = new a(Looper.getMainLooper());
    private final b.d.r.a.b y = new b.d.r.a.b();
    private int g4 = -1;
    private float I3 = 1.0f;
    private boolean J3 = false;

    /* compiled from: StreamDisplayClient.java */
    /* loaded from: classes3.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(b.d.z.a.a aVar) {
            aVar.onRenderProgramAdd(t.this.f4, t.this.f12561d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e(int i, b.d.z.a.a aVar) {
            aVar.framePerSecond(t.this.f4, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l */
        public /* synthetic */ void m(BitStreamType bitStreamType, boolean z, int i, b.d.z.a.a aVar) {
            aVar.changeVideoBitStreamType(t.this.f4, bitStreamType, z, i);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    t.this.Z3 = true;
                    t.this.a4.set(false);
                    b.d.z.c.a.a(t.this.h4, a.a);
                    return;
                case 2:
                    t.this.a4.set(true);
                    if (t.this.Z3) {
                        t.this.Z3 = false;
                    }
                    b.d.z.c.a.a(t.this.h4, q.a);
                    return;
                case 3:
                    if (t.this.f12561d != null) {
                        t.this.f12561d.b();
                        b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.l
                            @Override // b.d.p.e.b
                            public final void a(Object obj) {
                                t.a.this.b((b.d.z.a.a) obj);
                            }
                        });
                        return;
                    }
                    return;
                case 4:
                    t.this.o0();
                    t.this.a4.set(false);
                    final Exception exc = (Exception) message.getData().getSerializable("Exception");
                    b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.g
                        @Override // b.d.p.e.b
                        public final void a(Object obj) {
                            ((b.d.z.a.a) obj).playFatalException(exc);
                        }
                    });
                    return;
                case 5:
                    final String string = message.getData().getString("snapShotUri");
                    b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.c
                        @Override // b.d.p.e.b
                        public final void a(Object obj) {
                            ((b.d.z.a.a) obj).onSnapshotComplete(string);
                        }
                    });
                    return;
                case 6:
                    long j = message.getData().getLong("vodPlayProgress");
                    if (t.this.i4 != null) {
                        t.this.i4.showDisplayProgress(j);
                        return;
                    }
                    return;
                case 7:
                    final int i = message.getData().getInt("RecordDuration");
                    final String string2 = message.getData().getString("RecordFileUri");
                    b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.d
                        @Override // b.d.p.e.b
                        public final void a(Object obj) {
                            ((b.d.z.a.a) obj).recordSuccess(i, string2);
                        }
                    });
                    return;
                case 8:
                    t.this.o0();
                    final int i2 = message.getData().getInt("error_code");
                    b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.f
                        @Override // b.d.p.e.b
                        public final void a(Object obj) {
                            ((b.d.z.a.a) obj).recordFailed(i2);
                        }
                    });
                    return;
                case 9:
                default:
                    return;
                case 10:
                    if (!t.this.Z3) {
                        final float f2 = message.getData().getFloat("NetworkSpeed");
                        b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.h
                            @Override // b.d.p.e.b
                            public final void a(Object obj) {
                                ((b.d.z.a.a) obj).displayNetworkSpeed(f2);
                            }
                        });
                        return;
                    }
                    return;
                case 11:
                    final boolean z = message.getData().getBoolean(FirebaseAnalytics.Param.SUCCESS);
                    final int i3 = message.getData().getInt("errorCode");
                    String string3 = message.getData().getString("BitStreamType");
                    if (z) {
                        t.this.O3 = BitStreamType.fromString(string3);
                    } else {
                        b.d.d.e.a.c(t.this.f4, t.this.O3);
                    }
                    final BitStreamType fromString = BitStreamType.fromString(string3);
                    b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.b
                        @Override // b.d.p.e.b
                        public final void a(Object obj) {
                            t.a.this.m(fromString, z, i3, (b.d.z.a.a) obj);
                        }
                    });
                    return;
                case 12:
                    if (t.this.i4 != null) {
                        t.this.i4.vodPlayRate(message.getData().getBoolean(FirebaseAnalytics.Param.SUCCESS), message.getData().getFloat("rate"));
                        return;
                    }
                    return;
                case 13:
                    if (t.this.i4 != null) {
                        t.this.i4.vodSeekTime(message.getData().getBoolean(FirebaseAnalytics.Param.SUCCESS));
                        return;
                    }
                    return;
                case 14:
                    final long j2 = message.getData().getLong("RecordTime");
                    t.this.c4.set(j2 / 1000);
                    b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.j
                        @Override // b.d.p.e.b
                        public final void a(Object obj) {
                            ((b.d.z.a.a) obj).recordProgress(j2);
                        }
                    });
                    return;
                case 15:
                    final int i4 = message.getData().getInt("timeoutSeconds");
                    b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.i
                        @Override // b.d.p.e.b
                        public final void a(Object obj) {
                            ((b.d.z.a.a) obj).relayPreviewTimeLimit(i4);
                        }
                    });
                    t.this.a4.set(false);
                    return;
                case 16:
                    final int i5 = message.getData().getInt("FramePerSecond");
                    b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.e
                        @Override // b.d.p.e.b
                        public final void a(Object obj) {
                            t.a.this.e(i5, (b.d.z.a.a) obj);
                        }
                    });
                    return;
                case 17:
                    final BitStreamType bitStreamType = (BitStreamType) message.getData().getSerializable("STREAM_TYPE");
                    b.d.z.c.a.a(t.this.h4, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.k
                        @Override // b.d.p.e.b
                        public final void a(Object obj) {
                            ((b.d.z.a.a) obj).retryResolutions(BitStreamType.this);
                        }
                    });
                    return;
                case 18:
                    b.d.z.c.a.a(t.this.h4, s.a);
                    return;
            }
        }
    }

    public t(final String str) {
        this.f4 = str;
        b.d.d.e.a.a(str, new b.d.p.e.b() { // from class: com.tplink.libtplivemedia.a.m
            @Override // b.d.p.e.b
            public final void a(Object obj) {
                t.this.M((BitStreamType) obj);
            }
        });
        b.d.j.a.a aVar = new b.d.j.a.a();
        this.p1 = aVar;
        aVar.r(this);
        com.tplink.libmediakit.media.audioprocess.b<com.tplink.libmediakit.media.audioprocess.a> bVar = new com.tplink.libmediakit.media.audioprocess.b<>();
        this.p2 = bVar;
        bVar.l(8000);
        this.p2.c(2);
        this.p2.c(6);
        this.p2.k(new b.a() { // from class: com.tplink.libtplivemedia.a.n
            @Override // com.tplink.libmediakit.media.audioprocess.b.a
            public final void a(com.tplink.libmediakit.media.audioprocess.d dVar) {
                t.this.O(str, (com.tplink.libmediakit.media.audioprocess.a) dVar);
            }
        });
    }

    private int[] H(byte[] bArr) {
        if (bArr[0] != 0 || bArr[1] != 0 || bArr[2] != 0 || bArr[3] != 1 || (bArr[4] & 31) != 7) {
            return null;
        }
        int i = 5;
        while (true) {
            if (i < bArr.length - 4) {
                if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 1) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        DecoderProperty.a aVar = new DecoderProperty.a();
        this.p0.a(bArr2, aVar);
        return new int[]{aVar.b(), aVar.a()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(BitStreamType bitStreamType) {
        this.O3 = bitStreamType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O(String str, com.tplink.libmediakit.media.audioprocess.a aVar) {
        StreamMediaData streamMediaData = new StreamMediaData();
        streamMediaData.format = MediaDataFormat.AUDIO_MP2T;
        streamMediaData.deviceIdMD5 = str;
        streamMediaData.rawData = aVar.f11931d;
        streamMediaData.playTimeMs = aVar.j();
        streamMediaData.duration = aVar.m();
        streamMediaData.ptsUs = aVar.e();
        R(streamMediaData);
    }

    private void U() {
        b.d.h.b bVar = this.x;
        if (bVar != null) {
            bVar.e();
        }
        P(true);
        b.d.e.a aVar = this.H3;
        if (aVar != null) {
            aVar.c();
        }
    }

    private boolean V() {
        return this.R3 == 1.0f && this.S3 == 1;
    }

    private void Y(byte[] bArr, StreamMediaData streamMediaData, long j, long j2) {
        if (bArr.length > 0) {
            com.tplink.libmediakit.media.audioprocess.a aVar = new com.tplink.libmediakit.media.audioprocess.a();
            aVar.a = j2;
            aVar.f11929b = j;
            aVar.f11931d = (byte[]) bArr.clone();
            aVar.q(streamMediaData.deviceIdMD5);
            com.tplink.libmediakit.media.audioprocess.b<com.tplink.libmediakit.media.audioprocess.a> bVar = this.p2;
            if (bVar != null) {
                bVar.i(aVar);
            }
        }
    }

    private void b0() {
        b.d.h.b bVar = this.x;
        if (bVar != null) {
            bVar.g();
        }
        P(false);
        b.d.e.a aVar = this.H3;
        if (aVar != null) {
            aVar.g();
        }
    }

    private int d0(String str, String str2) {
        MediaMetadataRetriever mediaMetadataRetriever;
        String str3 = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str2);
                str3 = mediaMetadataRetriever.extractMetadata(9);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever != null) {
            mediaMetadataRetriever.release();
        }
        int round = (str3 == null || "0".equals(str3)) ? 0 : Math.round(Float.parseFloat(str3) / 1000.0f);
        if (round <= 0) {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        } else {
            b.d.d.l.a.c(this.f4, str, str2, round);
        }
        return round;
    }

    private void x() {
        if (this.K3 != null) {
            if (!V()) {
                b.d.r.a.g.a aVar = this.K3;
                if (!(aVar instanceof b.d.r.a.a)) {
                    aVar.d();
                    b.d.r.a.a aVar2 = new b.d.r.a.a();
                    this.K3 = aVar2;
                    aVar2.f(this);
                    return;
                }
            }
            if (V()) {
                b.d.r.a.g.a aVar3 = this.K3;
                if (aVar3 instanceof b.d.r.a.a) {
                    aVar3.d();
                    e eVar = new e();
                    this.K3 = eVar;
                    eVar.f(this);
                }
            }
        }
    }

    public void A() {
        this.U3 = false;
        this.j4.removeCallbacksAndMessages(null);
        this.j4 = null;
        this.y.c(new StreamMediaData());
        synchronized (this.z) {
            this.z.notifyAll();
        }
        b.d.j.a.a aVar = this.p1;
        if (aVar != null) {
            aVar.r(null);
            this.p1.q();
        }
        B();
        this.f12561d = null;
        this.a4.set(false);
        b.d.z.c.a.a(this.h4, p.a);
    }

    public void B() {
        this.T3 = false;
        this.X3 = false;
        this.Y3 = true;
        b.d.h.b bVar = this.x;
        if (bVar != null) {
            bVar.m();
            this.x = null;
        }
        b.d.x.b bVar2 = this.p3;
        if (bVar2 != null) {
            bVar2.destroy();
            this.p3 = null;
        }
        b.d.e.a aVar = this.H3;
        if (aVar != null) {
            aVar.destroy();
            this.H3 = null;
        }
        b.d.r.a.g.a aVar2 = this.K3;
        if (aVar2 != null) {
            aVar2.d();
            this.K3 = null;
        }
        c cVar = this.L3;
        if (cVar != null) {
            cVar.b();
            this.L3 = null;
        }
        d dVar = this.M3;
        if (dVar != null) {
            dVar.b();
            this.M3 = null;
        }
        Handler handler = this.j4;
        if (handler != null) {
            handler.removeMessages(15);
        }
    }

    public void C(int i) {
        if (this.j4 != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putInt("timeoutSeconds", i);
            message.what = 15;
            message.setData(bundle);
            this.j4.sendMessage(message);
        }
    }

    public int D() {
        return this.g4;
    }

    public String E() {
        return this.f4;
    }

    public ObservableLong F() {
        return this.c4;
    }

    public ArrayList<WeakReference<b.d.z.a.a>> G() {
        return this.h4;
    }

    public boolean I() {
        return this.U3;
    }

    public ObservableBoolean J() {
        return this.a4;
    }

    public ObservableBoolean K() {
        return this.b4;
    }

    public void P(boolean z) {
        if (z) {
            b.d.e.a aVar = this.H3;
            if (aVar != null && aVar.f() > 0.0f) {
                this.I3 = this.H3.f();
            }
            q0(0.0f);
            return;
        }
        q0(this.I3);
    }

    public void Q(boolean z) {
        com.tplink.libmediakit.media.audioprocess.b<com.tplink.libmediakit.media.audioprocess.a> bVar = this.p2;
        if (bVar != null) {
            bVar.h(z);
        }
    }

    public void R(StreamMediaData streamMediaData) {
        List<b.d.a0.b.e> Z;
        if (this.L3 == null) {
            c cVar = new c();
            this.L3 = cVar;
            cVar.c(this);
        }
        byte[] bArr = streamMediaData.rawData;
        if (bArr != null) {
            this.L3.a(bArr.length);
        }
        if (this.M3 == null) {
            d dVar = new d();
            this.M3 = dVar;
            dVar.e(this);
        }
        MediaDataFormat mediaDataFormat = MediaDataFormat.VIDEO_MP2T;
        if (mediaDataFormat == streamMediaData.format) {
            this.M3.a(1);
        }
        if (mediaDataFormat == streamMediaData.format && streamMediaData.isConfigFrame && !this.T3) {
            this.P3 = streamMediaData.width;
            this.Q3 = streamMediaData.height;
            this.T3 = true;
        }
        if (this.T3) {
            this.y.c(streamMediaData);
            synchronized (this.z) {
                this.z.notifyAll();
            }
            if (!(this.W3.get() || this.y.f() <= 300 || (Z = m.V().Z(this.f4)) == null)) {
                for (b.d.a0.b.e eVar : Z) {
                    if (eVar != null) {
                        eVar.v();
                    }
                }
            }
        }
    }

    public void S(byte[] bArr) {
        b.d.j.a.a aVar = this.p1;
        if (aVar != null) {
            aVar.o(bArr, bArr.length);
        }
    }

    public void T() {
        this.V3 = true;
        U();
    }

    public void W(MutableLiveData<f<String>> mutableLiveData) {
        this.e4 = mutableLiveData;
        i iVar = this.q;
        if (iVar != null) {
            iVar.c(this.f4);
        }
    }

    public void X() {
        i iVar = this.q;
        if (iVar != null) {
            iVar.c(this.f4);
        }
    }

    public void Z(b.d.z.a.a aVar) {
        if (aVar != null) {
            for (int size = this.h4.size() - 1; size >= 0; size--) {
                if (aVar.equals(this.h4.get(size).get())) {
                    this.h4.set(size, new WeakReference<>(null));
                    return;
                }
            }
        }
    }

    @Override // b.d.r.a.g.b
    public void a(String str, String str2) {
        int d0 = d0(str, str2);
        Bundle bundle = new Bundle();
        bundle.putInt("RecordDuration", d0);
        bundle.putString("RecordFileUri", str2);
        Message message = new Message();
        message.what = 7;
        message.setData(bundle);
        Handler handler = this.j4;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    public void a0() {
        this.V3 = false;
        synchronized (this.N3) {
            this.N3.notifyAll();
        }
        b0();
    }

    @Override // b.d.d.h.a
    public void b(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("FramePerSecond", i);
        Handler handler = this.j4;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(16);
            obtainMessage.setData(bundle);
            Handler handler2 = this.j4;
            if (handler2 != null) {
                handler2.sendMessage(obtainMessage);
            }
        }
    }

    @Override // b.d.r.a.g.b
    public void c(int i, String str, String str2) {
        if (i != -1) {
            switch (i) {
                case -3200004:
                    d0(str, str2);
                    break;
                case -3200003:
                    d0(str, str2);
                    break;
                case -3200002:
                case -3200001:
                    break;
                default:
                    i = -1;
                    break;
            }
        }
        if (this.j4 != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putInt("error_code", i);
            message.what = 8;
            message.setData(bundle);
            this.j4.sendMessage(message);
        }
    }

    public void c0(BitStreamType bitStreamType) {
        this.W3.set(false);
        if (this.j4 != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("STREAM_TYPE", bitStreamType);
            Message message = new Message();
            message.setData(bundle);
            message.what = 17;
            this.j4.sendMessage(message);
        }
    }

    @Override // b.d.z.b.h
    public void d(@NonNull YUVBuffer yUVBuffer) {
        b.d.x.b bVar = this.p3;
        if (bVar != null) {
            bVar.c(yUVBuffer);
        }
    }

    @Override // b.d.j.a.a.AbstractC0020a
    public void e(byte[] bArr, int i, com.tplink.libtpdemux.tsdemux.common.b bVar) {
        int[] H;
        if (bVar != null && bVar.b() == EnumESType.TS_ES_TYPE_AUDIO) {
            StreamMediaData streamMediaData = new StreamMediaData();
            streamMediaData.format = MediaDataFormat.AUDIO_MP2T;
            streamMediaData.deviceIdMD5 = this.f4;
            streamMediaData.ptsUs = StreamMediaData.parsePtsUs(bVar.a().d());
            b.d.j.a.b.a().g(this.f4, 0, bVar.a(), i * 2);
            Y(b.d.e.c.a(bArr, bArr.length), streamMediaData, streamMediaData.ptsUs, b.d.j.a.b.a().c(this.f4, 0));
        } else if (bVar != null && bVar.b() == EnumESType.TS_ES_TYPE_VIDEO) {
            StreamMediaData streamMediaData2 = new StreamMediaData();
            if (EnumESFrameType.TS_ES_FRAME_TYPE_SPS == bVar.c().a() && (H = H(bArr)) != null && H.length == 2) {
                streamMediaData2.width = H[0];
                streamMediaData2.height = H[1];
                streamMediaData2.isConfigFrame = true;
            }
            streamMediaData2.format = MediaDataFormat.VIDEO_MP2T;
            streamMediaData2.deviceIdMD5 = this.f4;
            long h = b.d.j.a.b.a().h(this.f4, 0, bVar.c());
            streamMediaData2.playTimeMs = b.d.j.a.b.a().e(this.f4, 0);
            streamMediaData2.duration = h;
            streamMediaData2.rawData = bArr;
            streamMediaData2.isKeyFrame = bVar.c().d();
            streamMediaData2.ptsUs = StreamMediaData.parsePtsUs(bVar.c().b());
            R(streamMediaData2);
        }
    }

    public void e0(boolean z) {
        this.U3 = z;
    }

    @Override // b.d.z.b.g
    public void f(int i, String str) {
        b.d.d.l.a.d(this.f4, str);
        MutableLiveData<f<String>> mutableLiveData = this.e4;
        if (mutableLiveData != null) {
            mutableLiveData.postValue(new f<>(this.f4));
            this.e4 = null;
        }
        if (!TextUtils.isEmpty(this.f4)) {
            b.d.d.f.a.e(this.f4, new File(str).getName());
        }
    }

    public void f0(int i) {
        this.g4 = i;
    }

    @Override // b.d.d.h.b
    public void g(float f2) {
        if (this.j4 != null) {
            Bundle bundle = new Bundle();
            bundle.putFloat("NetworkSpeed", f2);
            Handler handler = this.j4;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage(10);
                obtainMessage.setData(bundle);
                Handler handler2 = this.j4;
                if (handler2 != null) {
                    handler2.sendMessage(obtainMessage);
                }
            }
        }
    }

    public void g0(boolean z) {
        this.J3 = z;
        b.d.e.a aVar = this.H3;
        if (aVar != null) {
            aVar.b(z);
        }
        P(z);
    }

    @Override // b.d.z.b.g
    public void h(int i, String str) {
        MutableLiveData<f<Pair<Bitmap, String>>> mutableLiveData = this.d4;
        if (mutableLiveData != null) {
            mutableLiveData.postValue(new f<>(new Pair(null, str)));
            this.d4 = null;
            return;
        }
        Handler handler = this.j4;
        if (handler != null) {
            handler.removeMessages(5);
            Message obtainMessage = this.j4.obtainMessage(5);
            Bundle bundle = new Bundle();
            bundle.putString("snapShotUri", str);
            obtainMessage.setData(bundle);
            this.j4.sendMessage(obtainMessage);
            b.d.p.d.a("StreamDisplayClient", "截图完成");
        }
    }

    public void h0(Context context) {
        this.f12562f = context;
    }

    @Override // b.d.x.a
    public void i(YUVBuffer yUVBuffer, boolean z) {
        if (this.Y3) {
            this.Y3 = false;
            q0(1.0f);
        }
        int i = 1;
        if (this.q == null) {
            i iVar = new i(1);
            this.q = iVar;
            iVar.l(this);
            this.q.n(this);
        }
        if (this.x == null) {
            b.d.h.b bVar = new b.d.h.b(z);
            this.x = bVar;
            bVar.j(this);
            this.x.h(this);
            b.d.h.b bVar2 = this.x;
            if (!z) {
                i = this.S3;
            }
            bVar2.i(i);
            this.x.l();
        }
        this.x.b(yUVBuffer);
    }

    public void i0(b.d.d.g.b bVar) {
        this.i4 = bVar;
    }

    @Override // b.d.h.b.a
    public void j(YUVBuffer yUVBuffer) {
        GestureSurfaceView gestureSurfaceView;
        if (this.W3.get()) {
            b.d.x.b bVar = this.p3;
            if (bVar != null) {
                bVar.c(yUVBuffer);
                return;
            }
            return;
        }
        if (this.f12561d == null) {
            this.P3 = yUVBuffer.width;
            this.Q3 = yUVBuffer.height;
            GestureSurfaceView gestureSurfaceView2 = new GestureSurfaceView(this.f12562f);
            this.f12561d = gestureSurfaceView2;
            gestureSurfaceView2.k(yUVBuffer.width, yUVBuffer.height);
            this.f12561d.setGlRenderer(this.q);
            Handler handler = this.j4;
            if (handler != null) {
                handler.removeMessages(3);
                this.j4.sendEmptyMessage(3);
            }
        }
        int i = this.P3;
        int i2 = yUVBuffer.width;
        if (i != i2) {
            int i3 = this.Q3;
            int i4 = yUVBuffer.height;
            if (!(i3 == i4 || (gestureSurfaceView = this.f12561d) == null)) {
                gestureSurfaceView.k(i2, i4);
                this.f12561d.i();
            }
        }
        GestureSurfaceView gestureSurfaceView3 = this.f12561d;
        if (gestureSurfaceView3 != null) {
            gestureSurfaceView3.setOutputBuffer(yUVBuffer);
        }
        long j = yUVBuffer.timestamp;
        if (j > 0) {
            b.d.e.a aVar = this.H3;
            if (aVar != null) {
                aVar.e(j);
            }
            if (this.V3) {
                Handler handler2 = this.j4;
                if (handler2 != null) {
                    handler2.removeMessages(6);
                }
            } else {
                Handler handler3 = this.j4;
                if (handler3 != null) {
                    handler3.removeMessages(6);
                    Message obtainMessage = this.j4.obtainMessage(6);
                    Bundle bundle = new Bundle();
                    bundle.putLong("vodPlayProgress", j);
                    obtainMessage.setData(bundle);
                    this.j4.sendMessage(obtainMessage);
                }
            }
            Handler handler4 = this.j4;
            if (handler4 != null) {
                handler4.removeMessages(2);
                this.j4.sendEmptyMessage(2);
            }
        }
        b.d.h.b bVar2 = this.x;
        if (bVar2 != null && bVar2.k() == 0 && this.X3) {
            o0();
            Handler handler5 = this.j4;
            if (handler5 != null) {
                handler5.removeMessages(18);
                this.j4.sendEmptyMessage(18);
            }
        }
    }

    public void j0() {
        i iVar = this.q;
        if (iVar != null) {
            iVar.o(null);
        }
    }

    public void k0(MutableLiveData<f<Pair<Bitmap, String>>> mutableLiveData) {
        this.d4 = mutableLiveData;
        i iVar = this.q;
        if (iVar != null) {
            iVar.o(null);
        }
    }

    public void l0() {
        this.W3.set(true);
        List<b.d.a0.b.e> Z = m.V().Z(this.f4);
        if (Z != null) {
            for (b.d.a0.b.e eVar : Z) {
                if (eVar != null) {
                    eVar.w();
                }
            }
        }
    }

    public void m0() {
        if (!this.b4.get()) {
            this.b4.set(true);
            if (this.a4.get()) {
                b.d.z.c.a.a(this.h4, r.a);
                x();
                b.d.r.a.g.a aVar = this.K3;
                if (aVar != null) {
                    aVar.g();
                }
                b.d.p.d.a("StreamDisplayClient", "device " + this.f4 + " start record");
            }
        }
    }

    public void n0() {
        c cVar = this.L3;
        if (cVar != null) {
            cVar.b();
            this.L3 = null;
        }
        d dVar = this.M3;
        if (dVar != null) {
            dVar.b();
            this.M3 = null;
        }
    }

    public void o0() {
        if (this.b4.get()) {
            this.b4.set(false);
            b.d.r.a.g.a aVar = this.K3;
            if (aVar != null) {
                aVar.h();
            }
            b.d.z.c.a.a(this.h4, o.a);
        }
    }

    public void p0(Exception exc) {
        b.d.p.d.f("StreamDisplayClient");
        if (exc == null) {
            exc = new Exception("UnKnown Exception!");
        }
        if (this.j4 != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("Exception", exc);
            Message message = new Message();
            message.setData(bundle);
            message.what = 4;
            this.j4.sendMessage(message);
            y();
        }
    }

    public void q0(float f2) {
        b.d.e.a aVar = this.H3;
        if (aVar != null) {
            aVar.d(f2);
        }
    }

    @Override // b.d.r.a.g.b
    public void recordProgress(long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("RecordTime", j);
        Message message = new Message();
        message.what = 14;
        message.setData(bundle);
        Handler handler = this.j4;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        List<b.d.a0.b.e> Z;
        this.U3 = true;
        Handler handler = this.j4;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
        while (this.U3) {
            try {
                if (this.V3) {
                    synchronized (this.N3) {
                        this.N3.wait();
                    }
                }
                int f2 = this.y.f();
                if (!this.X3 && f2 < 150 && (Z = m.V().Z(this.f4)) != null) {
                    for (b.d.a0.b.e eVar : Z) {
                        if (eVar != null) {
                            eVar.w();
                        }
                    }
                }
                if (this.y.f() == 0 && this.U3) {
                    synchronized (this.z) {
                        this.z.wait();
                    }
                }
                StreamMediaData g = this.y.g();
                if (g != null) {
                    MediaDataFormat mediaDataFormat = g.format;
                    boolean z = g.isLiveStream;
                    if (MediaDataFormat.VOD_STREAM_FINISH == mediaDataFormat) {
                        this.X3 = true;
                    } else {
                        if (g.isConfigFrame) {
                            int i = g.width;
                            int i2 = g.height;
                            if (!(this.P3 == i && this.Q3 == i2)) {
                                this.P3 = i;
                                this.Q3 = i2;
                                o0();
                                b.d.r.a.g.a aVar = this.K3;
                                if (aVar != null) {
                                    aVar.d();
                                    this.K3 = null;
                                }
                            }
                        }
                        if (MediaDataFormat.VIDEO_MP2T == mediaDataFormat) {
                            b.d.x.b bVar = this.p3;
                            if (bVar == null) {
                                b.d.x.c cVar = new b.d.x.c(z);
                                this.p3 = cVar;
                                cVar.b(this);
                                this.p3.a(g);
                            } else {
                                bVar.a(g);
                            }
                            b.d.r.a.g.a aVar2 = this.K3;
                            if (aVar2 == null) {
                                e eVar2 = new e();
                                this.K3 = eVar2;
                                eVar2.f(this);
                                this.K3.e(g.clone());
                            } else {
                                aVar2.e(g.clone());
                            }
                            x();
                        } else if (MediaDataFormat.AUDIO_MP2T == mediaDataFormat) {
                            b.d.r.a.g.a aVar3 = this.K3;
                            if (aVar3 == null) {
                                e eVar3 = new e();
                                this.K3 = eVar3;
                                eVar3.f(this);
                                this.K3.e(g.clone());
                            } else {
                                aVar3.e(g.clone());
                            }
                            x();
                            if (this.S3 <= 1) {
                                b.d.e.a aVar4 = this.H3;
                                if (aVar4 == null) {
                                    b.d.e.b bVar2 = new b.d.e.b(2);
                                    this.H3 = bVar2;
                                    bVar2.b(this.J3);
                                    this.H3.a(g);
                                    if (this.Y3) {
                                        q0(0.0f);
                                    }
                                } else {
                                    aVar4.a(g);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void u(int i, b.d.z.a.a aVar) {
        if (aVar != null) {
            for (int size = this.h4.size() - 1; size >= 0; size--) {
                b.d.z.a.a aVar2 = this.h4.get(size).get();
                if (aVar2 != null && aVar2.equals(aVar)) {
                    return;
                }
            }
            this.h4.add(i, new WeakReference<>(aVar));
        }
    }

    public void v(b.d.z.a.a aVar) {
        if (aVar != null) {
            for (int size = this.h4.size() - 1; size >= 0; size--) {
                b.d.z.a.a aVar2 = this.h4.get(size).get();
                if (aVar2 != null && aVar2.equals(aVar)) {
                    return;
                }
            }
            this.h4.add(new WeakReference<>(aVar));
        }
    }

    public void w(BitStreamType bitStreamType, boolean z, int i) {
        this.W3.set(false);
        if (this.j4 != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(FirebaseAnalytics.Param.SUCCESS, z);
            bundle.putInt("errorCode", i);
            if (bitStreamType != null) {
                bundle.putString("BitStreamType", bitStreamType.getValue());
            }
            Message obtainMessage = this.j4.obtainMessage(11);
            obtainMessage.setData(bundle);
            this.j4.sendMessage(obtainMessage);
        }
    }

    public void y() {
        this.y.a();
        b.d.h.b bVar = this.x;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void z() {
        this.h4.clear();
    }
}
