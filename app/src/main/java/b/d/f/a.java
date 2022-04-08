package b.d.f;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import b.d.p.b;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: AACEncoder.java */
/* loaded from: classes3.dex */
public class a {
    private MediaCodec h;
    private AbstractC0018a m;
    private final String a = "audio/mp4a-latm";

    /* renamed from: b  reason: collision with root package name */
    private final int f440b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final int f441c = 8000;

    /* renamed from: d  reason: collision with root package name */
    private final int f442d = 16000;

    /* renamed from: e  reason: collision with root package name */
    private final int f443e = 2;

    /* renamed from: f  reason: collision with root package name */
    private final int f444f = 8192;
    private final int g = 2;
    private int j = 8000;
    private int k = 16000;
    private int l = 1;
    private boolean i = false;
    private long n = 0;

    /* compiled from: AACEncoder.java */
    /* renamed from: b.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface AbstractC0018a {
        void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j);

        void b(MediaFormat mediaFormat);
    }

    public a(AbstractC0018a aVar) {
        this.m = aVar;
    }

    private void b() {
        ByteBuffer byteBuffer;
        MediaCodec mediaCodec = this.h;
        if (mediaCodec != null) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(100L);
            if (dequeueInputBuffer >= 0) {
                if (b.a()) {
                    byteBuffer = this.h.getInputBuffer(dequeueInputBuffer);
                } else {
                    byteBuffer = this.h.getInputBuffers()[dequeueInputBuffer];
                }
                byteBuffer.clear();
                this.h.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.h.dequeueOutputBuffer(bufferInfo, 8000L);
            while (dequeueOutputBuffer >= 0) {
                if (b.b()) {
                    this.h.getOutputBuffer(dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer2 = this.h.getInputBuffers()[dequeueInputBuffer];
                }
                this.h.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.h.dequeueOutputBuffer(bufferInfo, 8000L);
            }
        }
    }

    private String c(int i, int i2) {
        if (b.b()) {
            return new MediaCodecList(0).findEncoderForFormat(MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2));
        }
        String str = null;
        for (int i3 = 0; i3 < MediaCodecList.getCodecCount(); i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            String[] supportedTypes = codecInfoAt.getSupportedTypes();
            int length = supportedTypes.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (TextUtils.equals(supportedTypes[i4], "audio/mp4a-latm") && codecInfoAt.isEncoder()) {
                    str = codecInfoAt.getName();
                    break;
                }
                i4++;
            }
            if (str != null) {
                break;
            }
        }
        return str;
    }

    @TargetApi(16)
    private boolean e(int i, int i2, int i3) {
        this.j = i;
        this.k = i2;
        this.l = i3;
        try {
            this.h = MediaCodec.createByCodecName(c(i, i3));
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.j, this.l);
            createAudioFormat.setString("mime", "audio/mp4a-latm");
            createAudioFormat.setInteger("bitrate", this.k);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setInteger("max-input-size", 8192);
            createAudioFormat.setInteger("pcm-encoding", 2);
            this.h.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.h.start();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void f() {
        MediaCodec mediaCodec = this.h;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.h.release();
                this.h = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(byte[] bArr, long j) {
        MediaCodec mediaCodec;
        AbstractC0018a aVar;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        if (this.i && (mediaCodec = this.h) != null) {
            if (this.n == 0) {
                this.n = j;
            }
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(8000L);
            if (dequeueInputBuffer >= 0) {
                if (b.a()) {
                    byteBuffer2 = this.h.getInputBuffer(dequeueInputBuffer);
                } else {
                    byteBuffer2 = this.h.getInputBuffers()[dequeueInputBuffer];
                }
                byteBuffer2.clear();
                byteBuffer2.put(bArr);
                this.h.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j - this.n, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.h.dequeueOutputBuffer(bufferInfo, 8000L);
            while (dequeueOutputBuffer >= 0) {
                if (b.a()) {
                    byteBuffer = this.h.getOutputBuffer(dequeueOutputBuffer);
                } else {
                    byteBuffer = this.h.getInputBuffers()[dequeueInputBuffer];
                }
                AbstractC0018a aVar2 = this.m;
                if (aVar2 != null) {
                    aVar2.a(byteBuffer, bufferInfo, this.n + bufferInfo.presentationTimeUs);
                }
                this.h.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.h.dequeueOutputBuffer(bufferInfo, 8000L);
            }
            if (dequeueOutputBuffer == -2 && (aVar = this.m) != null) {
                aVar.b(this.h.getOutputFormat());
            }
        }
    }

    public boolean d() {
        return this.i;
    }

    public boolean g(int i, int i2, int i3) {
        boolean e2 = e(i, i2, i3);
        this.i = e2;
        return e2;
    }

    public void h() {
        this.i = false;
        this.n = 0L;
        b();
        f();
    }
}
