package b.d.y;

import android.media.MediaCodec;
import android.media.MediaFormat;
import b.d.f.a;
import b.d.j.a.a;
import b.d.r.a.d;
import com.tplink.libtpappcommonmedia.bean.stream.MediaDataFormat;
import com.tplink.libtpdemux.tsdemux.common.EnumESType;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.h;
import kotlin.collections.r;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: TsToMp4Converter.kt */
/* loaded from: classes3.dex */
public final class a implements a.AbstractC0020a, d.a, a.AbstractC0018a {
    private MediaFormat H3;
    private MediaFormat I3;
    private long J3;
    private b.d.f.a p1;
    private b.d.r.a.f p2;
    private boolean p3;
    private b.d.e.d q;

    /* renamed from: c  reason: collision with root package name */
    private final String f836c = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private final int f837d = 188;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<C0032a> f838f = new ArrayList<>();
    private b.d.d.m.e x = new b.d.d.m.e();
    private final MediaCodec.BufferInfo y = new MediaCodec.BufferInfo();
    private final b.d.r.a.c z = new b.d.r.a.c();
    private final b.d.r.a.d p0 = new b.d.r.a.d(this);
    private int K3 = -1;
    private int L3 = -1;
    private int M3 = -1;

    /* compiled from: TsToMp4Converter.kt */
    /* renamed from: b.d.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0032a {
        private MediaDataFormat a;

        /* renamed from: b  reason: collision with root package name */
        private long f839b;

        /* renamed from: c  reason: collision with root package name */
        private byte[] f840c;

        public C0032a(MediaDataFormat format, long j, byte[] raw) {
            j.e(format, "format");
            j.e(raw, "raw");
            this.a = format;
            this.f839b = j;
            this.f840c = raw;
        }

        public final MediaDataFormat a() {
            return this.a;
        }

        public final long b() {
            return this.f839b;
        }

        public final byte[] c() {
            return this.f840c;
        }
    }

    /* compiled from: TsToMp4Converter.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements p<byte[], Integer, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.d.j.a.a f841c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(b.d.j.a.a aVar) {
            super(2);
            this.f841c = aVar;
        }

        public final void a(byte[] fileData, int i) {
            j.e(fileData, "fileData");
            this.f841c.o(fileData, i);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(byte[] bArr, Integer num) {
            a(bArr, num.intValue());
            return kotlin.p.a;
        }
    }

    /* compiled from: TsToMp4Converter.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<kotlin.p> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ File f843d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.a f844f;
        final /* synthetic */ l q;
        final /* synthetic */ b.d.j.a.a x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(File file, kotlin.jvm.b.a aVar, l lVar, b.d.j.a.a aVar2) {
            super(0);
            this.f843d = file;
            this.f844f = aVar;
            this.q = lVar;
            this.x = aVar2;
        }

        public final void a() {
            if (a.this.i(this.f843d, this.f844f, this.q) != 0) {
                this.f843d.delete();
                this.q.invoke(new IOException("generateMP4 failed"));
            }
            this.x.q();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* compiled from: TsToMp4Converter.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements l<IOException, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f845c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.a f846d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(l lVar, kotlin.jvm.b.a aVar) {
            super(1);
            this.f845c = lVar;
            this.f846d = aVar;
        }

        public final void a(IOException it) {
            j.e(it, "it");
            this.f845c.invoke(it);
            this.f846d.invoke();
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.p invoke(IOException iOException) {
            a(iOException);
            return kotlin.p.a;
        }
    }

    /* compiled from: TsToMp4Converter.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements kotlin.jvm.b.a<kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.a f847c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.a f848d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(kotlin.jvm.b.a aVar, kotlin.jvm.b.a aVar2) {
            super(0);
            this.f847c = aVar;
            this.f848d = aVar2;
        }

        public final void a() {
            this.f847c.invoke();
            this.f848d.invoke();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* compiled from: TsToMp4Converter.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements kotlin.jvm.b.a<kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.a f849c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.b.a f850d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(kotlin.jvm.b.a aVar, kotlin.jvm.b.a aVar2) {
            super(0);
            this.f849c = aVar;
            this.f850d = aVar2;
        }

        public final void a() {
            this.f849c.invoke();
            this.f850d.invoke();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.p invoke() {
            a();
            return kotlin.p.a;
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes3.dex */
    public static final class g<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.q.b.a(Long.valueOf(((C0032a) t).b()), Long.valueOf(((C0032a) t2).b()));
            return a;
        }
    }

    private final void f(MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer, long j) {
        b.d.r.a.f fVar = this.p2;
        if (fVar != null) {
            bufferInfo.presentationTimeUs = j - this.J3;
            if (fVar != null) {
                fVar.e(byteBuffer, bufferInfo);
            }
        }
    }

    private final void g(byte[] bArr, long j) {
        if (this.p2 != null) {
            MediaCodec.BufferInfo bufferInfo = this.y;
            bufferInfo.offset = 0;
            int length = bArr.length;
            bufferInfo.size = length;
            if (((byte) (bArr[4] & 31)) == 5) {
                bufferInfo.flags = 1;
            } else if (((byte) (bArr[4] & 31)) == 7 || ((byte) (bArr[4] & 31)) == 8) {
                bufferInfo.flags = 2;
            } else {
                bufferInfo.flags = 0;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, length);
            MediaCodec.BufferInfo bufferInfo2 = this.y;
            bufferInfo2.presentationTimeUs = j - this.J3;
            b.d.r.a.f fVar = this.p2;
            if (fVar != null) {
                fVar.g(wrap, bufferInfo2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int i(File file, kotlin.jvm.b.a<kotlin.p> aVar, l<? super IOException, kotlin.p> lVar) {
        int i;
        if (file.exists()) {
            aVar.invoke();
            return 0;
        }
        if (this.p2 == null) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            this.p2 = new b.d.r.a.f(file.getAbsolutePath());
        }
        if (this.p1 == null) {
            b.d.f.a aVar2 = new b.d.f.a(this);
            this.p1 = aVar2;
            if (aVar2 != null) {
                aVar2.g(this.L3, 32000, this.K3);
            }
        }
        if (!(this.H3 == null || this.I3 == null)) {
            k();
        }
        r.o(this.f838f, new g());
        if (!this.f838f.isEmpty()) {
            this.J3 = this.f838f.get(0).b();
            int size = this.f838f.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0032a aVar3 = this.f838f.get(i2);
                j.d(aVar3, "muxDataList[i]");
                C0032a aVar4 = aVar3;
                if (aVar4.a() == MediaDataFormat.AUDIO_WAV) {
                    b.d.f.a aVar5 = this.p1;
                    if (aVar5 != null) {
                        aVar5.a(aVar4.c(), aVar4.b());
                    }
                } else {
                    this.p0.a(aVar4.c(), aVar4.b());
                }
            }
            i = 0;
        } else {
            i = -3200001;
        }
        b.d.r.a.f fVar = this.p2;
        if (fVar != null) {
            if (fVar != null) {
                fVar.d();
            }
            this.p3 = false;
        }
        b.d.f.a aVar6 = this.p1;
        if (aVar6 != null) {
            aVar6.h();
        }
        if (i == 0) {
            aVar.invoke();
        } else {
            lVar.invoke(new IOException("file is empty"));
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[], java.lang.Object] */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void j(java.io.File r4, int r5, kotlin.jvm.b.a<kotlin.p> r6, kotlin.jvm.b.p<? super byte[], ? super java.lang.Integer, kotlin.p> r7, kotlin.jvm.b.a<kotlin.p> r8) {
        /*
            r3 = this;
            byte[] r0 = new byte[r5]
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: FileNotFoundException -> 0x001f
            r1.<init>(r4)     // Catch: FileNotFoundException -> 0x001f
            r4 = 0
            int r6 = r1.read(r0, r4, r5)
        L_0x000c:
            r2 = -1
            if (r6 == r2) goto L_0x001b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.invoke(r0, r6)
            int r6 = r1.read(r0, r4, r5)
            goto L_0x000c
        L_0x001b:
            r8.invoke()
            return
        L_0x001f:
            r4 = move-exception
            java.lang.String r5 = r3.f836c
            java.lang.String r4 = android.util.Log.getStackTraceString(r4)
            b.d.p.d.c(r5, r4)
            r6.invoke()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.y.a.j(java.io.File, int, kotlin.jvm.b.a, kotlin.jvm.b.p, kotlin.jvm.b.a):void");
    }

    private final void k() {
        MediaFormat mediaFormat;
        if (!this.p3 && (mediaFormat = this.H3) != null && this.I3 != null) {
            b.d.r.a.f fVar = this.p2;
            if (fVar != null) {
                fVar.b(mediaFormat);
            }
            b.d.r.a.f fVar2 = this.p2;
            if (fVar2 != null) {
                fVar2.a(this.I3);
            }
            b.d.r.a.f fVar3 = this.p2;
            if (fVar3 != null) {
                fVar3.c();
            }
            this.p3 = true;
        }
    }

    @Override // b.d.f.a.AbstractC0018a
    public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j) {
        j.e(byteBuffer, "byteBuffer");
        j.e(bufferInfo, "bufferInfo");
        if (this.p3) {
            f(bufferInfo, byteBuffer, j);
        }
    }

    @Override // b.d.f.a.AbstractC0018a
    public void b(MediaFormat format) {
        j.e(format, "format");
        if (this.I3 == null) {
            this.I3 = format;
        }
        k();
    }

    @Override // b.d.r.a.d.a
    public void c(byte[] datas, long j) {
        j.e(datas, "datas");
        k();
        g(datas, j);
    }

    @Override // b.d.j.a.a.AbstractC0020a
    public void e(byte[] bArr, int i, com.tplink.libtpdemux.tsdemux.common.b bVar) {
        byte[] bArr2;
        byte[] e2;
        if (bArr != null) {
            boolean z = true;
            int i2 = 0;
            if (!(bArr.length == 0)) {
                EnumESType b2 = bVar != null ? bVar.b() : null;
                if (b2 != null) {
                    int i3 = b.a[b2.ordinal()];
                    int i4 = 90000;
                    if (i3 == 1) {
                        if (this.K3 == -1) {
                            com.tplink.libtpdemux.tsdemux.common.a a = bVar.a();
                            j.d(a, "esParam.audio_param");
                            this.K3 = a.c();
                        }
                        if (this.L3 == -1) {
                            com.tplink.libtpdemux.tsdemux.common.a a2 = bVar.a();
                            j.d(a2, "esParam.audio_param");
                            this.L3 = a2.e();
                        }
                        if (this.M3 == -1) {
                            com.tplink.libtpdemux.tsdemux.common.a a3 = bVar.a();
                            j.d(a3, "esParam.audio_param");
                            this.M3 = a3.b();
                        }
                        if (this.q == null) {
                            b.d.e.d dVar = new b.d.e.d();
                            this.q = dVar;
                            dVar.e(this.L3, this.M3, this.K3);
                        }
                        long j = 0;
                        while (i2 < i) {
                            int h = this.x.h(bArr, i2) + i2;
                            if (h < i) {
                                b.d.e.d dVar2 = this.q;
                                if (dVar2 != null) {
                                    e2 = h.e(bArr, i2, h);
                                    bArr2 = dVar2.a(e2);
                                } else {
                                    bArr2 = null;
                                }
                                if (bArr2 != null) {
                                    if (j == 0) {
                                        com.tplink.libtpdemux.tsdemux.common.a a4 = bVar.a();
                                        j.d(a4, "esParam.audio_param");
                                        i2 = h;
                                        j = (a4.d() * 1000000) / i4;
                                    } else {
                                        i2 = h;
                                        j += (bArr2.length * 1000000) / (this.L3 * 2);
                                    }
                                    this.f838f.add(new C0032a(MediaDataFormat.AUDIO_WAV, j, bArr2));
                                } else {
                                    i2 = h;
                                }
                                i4 = 90000;
                            } else {
                                return;
                            }
                        }
                    } else if (i3 == 2) {
                        if (this.H3 == null) {
                            List<byte[]> b3 = this.p0.b(bArr);
                            int size = b3.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size) {
                                    z = false;
                                    break;
                                } else if (((byte) (b3.get(i5)[4] & 31)) == 7) {
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                            if (z) {
                                this.z.a(b3);
                                this.H3 = this.z.f();
                            }
                        }
                        com.tplink.libtpdemux.tsdemux.common.c c2 = bVar.c();
                        j.d(c2, "esParam.video_param");
                        this.f838f.add(new C0032a(MediaDataFormat.VIDEO_H264, (c2.b() * 1000000) / 90000, bArr));
                    }
                }
            }
        }
    }

    public final void h(File tsFile, File mp4File, int i, kotlin.jvm.b.a<kotlin.p> fileNotFoundCallback, kotlin.jvm.b.a<kotlin.p> successCallBack, l<? super IOException, kotlin.p> failCallBack, kotlin.jvm.b.a<kotlin.p> finalCallBack) {
        j.e(tsFile, "tsFile");
        j.e(mp4File, "mp4File");
        j.e(fileNotFoundCallback, "fileNotFoundCallback");
        j.e(successCallBack, "successCallBack");
        j.e(failCallBack, "failCallBack");
        j.e(finalCallBack, "finalCallBack");
        e eVar = new e(fileNotFoundCallback, finalCallBack);
        f fVar = new f(successCallBack, finalCallBack);
        d dVar = new d(failCallBack, finalCallBack);
        b.d.j.a.a aVar = new b.d.j.a.a();
        aVar.r(this);
        j(tsFile, this.f837d * i, eVar, new b(aVar), new c(mp4File, fVar, dVar, aVar));
    }
}
