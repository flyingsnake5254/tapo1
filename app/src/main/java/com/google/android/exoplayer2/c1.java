package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.q;
import com.google.android.exoplayer2.audio.t;
import com.google.android.exoplayer2.mediacodec.s;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.metadata.f;
import com.google.android.exoplayer2.text.k;
import com.google.android.exoplayer2.text.l;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.video.y;
import java.util.ArrayList;

/* compiled from: DefaultRenderersFactory.java */
/* loaded from: classes.dex */
public class c1 implements f2 {
    private final Context a;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2149d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2151f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;

    /* renamed from: b  reason: collision with root package name */
    private int f2147b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f2148c = 5000;

    /* renamed from: e  reason: collision with root package name */
    private s f2150e = s.a;

    public c1(Context context) {
        this.a = context;
    }

    @Override // com.google.android.exoplayer2.f2
    public b2[] a(Handler handler, y yVar, t tVar, k kVar, e eVar) {
        ArrayList<b2> arrayList = new ArrayList<>();
        h(this.a, this.f2147b, this.f2150e, this.f2149d, handler, yVar, this.f2148c, arrayList);
        AudioSink c2 = c(this.a, this.i, this.j, this.k);
        if (c2 != null) {
            b(this.a, this.f2147b, this.f2150e, this.f2149d, c2, handler, tVar, arrayList);
        }
        g(this.a, kVar, handler.getLooper(), this.f2147b, arrayList);
        e(this.a, eVar, handler.getLooper(), this.f2147b, arrayList);
        d(this.a, this.f2147b, arrayList);
        f(this.a, handler, this.f2147b, arrayList);
        return (b2[]) arrayList.toArray(new b2[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:39|11)|37|17|18|34|19|(2:40|25)) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a3, code lost:
        r7 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r15, int r16, com.google.android.exoplayer2.mediacodec.s r17, boolean r18, com.google.android.exoplayer2.audio.AudioSink r19, android.os.Handler r20, com.google.android.exoplayer2.audio.t r21, java.util.ArrayList<com.google.android.exoplayer2.b2> r22) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c1.b(android.content.Context, int, com.google.android.exoplayer2.mediacodec.s, boolean, com.google.android.exoplayer2.audio.AudioSink, android.os.Handler, com.google.android.exoplayer2.audio.t, java.util.ArrayList):void");
    }

    @Nullable
    protected AudioSink c(Context context, boolean z, boolean z2, boolean z3) {
        return new DefaultAudioSink(q.c(context), new DefaultAudioSink.d(new AudioProcessor[0]), z, z2, z3 ? 1 : 0);
    }

    protected void d(Context context, int i, ArrayList<b2> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.video.spherical.e());
    }

    protected void e(Context context, e eVar, Looper looper, int i, ArrayList<b2> arrayList) {
        arrayList.add(new f(eVar, looper));
    }

    protected void f(Context context, Handler handler, int i, ArrayList<b2> arrayList) {
    }

    protected void g(Context context, k kVar, Looper looper, int i, ArrayList<b2> arrayList) {
        arrayList.add(new l(kVar, looper));
    }

    protected void h(Context context, int i, s sVar, boolean z, Handler handler, y yVar, long j, ArrayList<b2> arrayList) {
        com.google.android.exoplayer2.video.q qVar = new com.google.android.exoplayer2.video.q(context, sVar, j, z, handler, yVar, 50);
        qVar.g0(this.f2151f);
        qVar.h0(this.g);
        qVar.i0(this.h);
        arrayList.add(qVar);
        if (i != 0) {
            int size = arrayList.size();
            if (i == 2) {
                size--;
            }
            try {
                try {
                    size++;
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating VP9 extension", e2);
                }
            } catch (ClassNotFoundException unused) {
            }
            try {
                arrayList.add(size, (b2) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, y.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, yVar, 50));
                u.f("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException unused2) {
                size = size;
                arrayList.add(size, (b2) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, y.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, yVar, 50));
                u.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
            }
            try {
                arrayList.add(size, (b2) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, y.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, yVar, 50));
                u.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
            } catch (ClassNotFoundException unused3) {
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating AV1 extension", e3);
            }
        }
    }

    public c1 i(int i) {
        this.f2147b = i;
        return this;
    }
}
