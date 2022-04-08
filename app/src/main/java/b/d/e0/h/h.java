package b.d.e0.h;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* compiled from: PreviewCallback.java */
/* loaded from: classes3.dex */
public final class h implements Camera.PreviewCallback {
    private static final String a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final b f421b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f422c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f423d;

    /* renamed from: e  reason: collision with root package name */
    private int f424e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, boolean z) {
        this.f421b = bVar;
        this.f422c = z;
    }

    public void a(Handler handler, int i) {
        this.f423d = handler;
        this.f424e = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point c2 = this.f421b.c();
        if (!this.f422c) {
            camera.setPreviewCallback(null);
        }
        Handler handler = this.f423d;
        if (handler != null) {
            handler.obtainMessage(this.f424e, c2.x, c2.y, bArr).sendToTarget();
            this.f423d = null;
            return;
        }
        Log.d(a, "Got preview callback, but no handler for it");
    }
}
