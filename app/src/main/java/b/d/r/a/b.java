package b.d.r.a;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.stream.MediaDataFormat;
import com.tplink.libtpappcommonmedia.bean.stream.StreamMediaData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ESBufferQueue.java */
/* loaded from: classes3.dex */
public class b {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f682b;

    /* renamed from: c  reason: collision with root package name */
    private long f683c;

    /* renamed from: d  reason: collision with root package name */
    private long f684d;

    /* renamed from: e  reason: collision with root package name */
    private long f685e;

    /* renamed from: f  reason: collision with root package name */
    private long f686f;
    private boolean g;
    private long h;
    private long i;
    private long j;
    private long k;
    private int l;
    private final List<StreamMediaData> m;
    private final Object n;

    public b() {
        this.m = new ArrayList();
        this.n = new Object();
        this.a = false;
        this.f682b = false;
        this.f683c = 0L;
        this.f684d = 0L;
        this.f685e = 0L;
        this.f686f = 0L;
        this.g = false;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 10;
    }

    private void b(StreamMediaData streamMediaData) {
        boolean z = false;
        for (int i = 0; i < this.m.size(); i++) {
            StreamMediaData streamMediaData2 = this.m.get(i);
            if (Math.abs(streamMediaData.ptsUs - streamMediaData2.ptsUs) > 5965232355L) {
                if (streamMediaData.ptsUs > streamMediaData2.ptsUs) {
                    this.m.add(i, streamMediaData);
                    z = true;
                    break;
                }
            } else if (streamMediaData.ptsUs < streamMediaData2.ptsUs) {
                this.m.add(i, streamMediaData);
                z = true;
                break;
            }
        }
        if (!z) {
            this.m.add(streamMediaData);
        }
        if (this.m.size() > this.l) {
            this.a = true;
        }
    }

    private void d() {
        this.m.clear();
        this.a = false;
        this.f682b = false;
        this.f683c = 0L;
        this.f684d = 0L;
        this.f685e = 0L;
        this.f686f = 0L;
        this.g = false;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
    }

    public void a() {
        synchronized (this.n) {
            d();
        }
    }

    public void c(@NonNull StreamMediaData streamMediaData) {
        synchronized (this.n) {
            MediaDataFormat mediaDataFormat = streamMediaData.format;
            if (mediaDataFormat == MediaDataFormat.VIDEO_MP2T) {
                long abs = Math.abs(streamMediaData.ptsUs - this.f686f);
                if (this.f686f > 0 && abs > 1000000 && abs < 5965232355L) {
                    this.f682b = true;
                }
                if (this.a || !this.f682b) {
                    if (this.f682b) {
                        this.f682b = false;
                        this.f683c = streamMediaData.ptsUs - this.f685e;
                    }
                    long j = streamMediaData.ptsUs;
                    this.f686f = j;
                    long j2 = (j - this.f683c) - this.f684d;
                    streamMediaData.ptsUs = j2;
                    long j3 = this.f685e;
                    if (j3 > 0 && Math.abs(j2 - j3) > 5965232355L) {
                        long j4 = j - this.f685e;
                        this.f684d = j4;
                        streamMediaData.ptsUs = (j - this.f683c) - j4;
                    }
                    this.f685e = streamMediaData.ptsUs;
                    b(streamMediaData);
                } else {
                    d();
                }
            } else if (mediaDataFormat == MediaDataFormat.AUDIO_MP2T) {
                long abs2 = Math.abs(streamMediaData.ptsUs - this.k);
                if (this.k > 0 && abs2 > 1000000 && abs2 < 5965232355L) {
                    this.g = true;
                }
                if (this.a || !this.g) {
                    if (this.g) {
                        this.g = false;
                        this.h = streamMediaData.ptsUs - this.j;
                    }
                    long j5 = streamMediaData.ptsUs;
                    this.k = j5;
                    long j6 = (j5 - this.h) - this.i;
                    streamMediaData.ptsUs = j6;
                    long j7 = this.j;
                    if (j7 > 0 && Math.abs(j6 - j7) > 5965232355L) {
                        long j8 = j5 - this.j;
                        this.i = j8;
                        streamMediaData.ptsUs = (j5 - this.h) - j8;
                    }
                    this.j = streamMediaData.ptsUs;
                    b(streamMediaData);
                } else {
                    d();
                }
            }
        }
    }

    public void e(int i) {
        synchronized (this.n) {
            this.l = 10 / i;
        }
    }

    public int f() {
        return this.m.size();
    }

    public StreamMediaData g() {
        synchronized (this.n) {
            if (this.m.size() <= (this.a ? 0 : this.l)) {
                return null;
            }
            return this.m.remove(0);
        }
    }

    public b(int i) {
        this.m = new ArrayList();
        this.n = new Object();
        this.a = false;
        this.f682b = false;
        this.f683c = 0L;
        this.f684d = 0L;
        this.f685e = 0L;
        this.f686f = 0L;
        this.g = false;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = i;
    }
}
