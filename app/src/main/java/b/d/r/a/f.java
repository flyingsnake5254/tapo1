package b.d.r.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: MP4Muxer.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private MediaMuxer f696b;
    private String a = f.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private int f697c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f698d = -1;

    public f(String str) {
        try {
            this.f696b = new MediaMuxer(str, 0);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void f(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i) {
        if ((bufferInfo.flags & 2) != 0) {
            bufferInfo.size = 0;
        } else if (bufferInfo.size != 0) {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.f696b.writeSampleData(i, byteBuffer, bufferInfo);
            String str = this.a;
            Log.d(str, String.format("send [%d] [" + bufferInfo.size + "] with timestamp:[%d] to muxer", Integer.valueOf(i), Long.valueOf(bufferInfo.presentationTimeUs)));
            if ((bufferInfo.flags & 4) != 0) {
                Log.i(this.a, "BUFFER_FLAG_END_OF_STREAM received");
            }
        }
    }

    public void a(MediaFormat mediaFormat) {
        if (this.f698d == -1) {
            this.f698d = this.f696b.addTrack(mediaFormat);
            return;
        }
        throw new RuntimeException("already add audio tracks");
    }

    public void b(MediaFormat mediaFormat) {
        if (this.f697c == -1) {
            this.f697c = this.f696b.addTrack(mediaFormat);
            return;
        }
        throw new RuntimeException("already add video tracks");
    }

    public void c() {
        this.f696b.start();
    }

    public synchronized void d() {
        if (!(this.f696b == null || (this.f697c == -1 && this.f698d == -1))) {
            Log.i(this.a, String.format("muxer is started. now it will be stoped.", new Object[0]));
            try {
                this.f696b.stop();
                this.f696b.release();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    public synchronized void e(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        int i = this.f698d;
        if (i == -1) {
            Log.i(this.a, String.format("pumpStream [%s] but muxer is not start.ignore..", "audio"));
        } else {
            f(byteBuffer, bufferInfo, i);
        }
    }

    public synchronized void g(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        int i = this.f697c;
        if (i == -1) {
            Log.i(this.a, String.format("pumpStream [%s] but muxer is not start.ignore..", "video"));
        } else {
            f(byteBuffer, bufferInfo, i);
        }
    }
}
