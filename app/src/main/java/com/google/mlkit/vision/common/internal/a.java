package com.google.mlkit.vision.common.internal;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class a {
    private static final GmsLogger a = new GmsLogger("StreamingFormatChecker", "");

    /* renamed from: b  reason: collision with root package name */
    private final LinkedList<Long> f5007b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    private long f5008c = -1;

    @KeepForSdk
    public void a(b.b.a.a.a.a aVar) {
        if (aVar.d() == -1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f5007b.add(Long.valueOf(elapsedRealtime));
            if (this.f5007b.size() > 5) {
                this.f5007b.removeFirst();
            }
            if (this.f5007b.size() == 5 && elapsedRealtime - this.f5007b.peekFirst().longValue() < 5000) {
                long j = this.f5008c;
                if (j == -1 || elapsedRealtime - j >= TimeUnit.SECONDS.toMillis(5L)) {
                    this.f5008c = elapsedRealtime;
                    a.w("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
                }
            }
        }
    }
}
