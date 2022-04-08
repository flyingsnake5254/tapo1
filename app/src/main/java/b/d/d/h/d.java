package b.d.d.h;

import java.math.BigDecimal;
import java.util.Arrays;

/* compiled from: VideoFramePerSecondThread.java */
/* loaded from: classes3.dex */
public class d implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private boolean f192c;

    /* renamed from: d  reason: collision with root package name */
    private a f193d;

    /* renamed from: f  reason: collision with root package name */
    private int f194f = 0;

    public d() {
        this.f192c = false;
        this.f192c = true;
        new Thread(this).start();
    }

    private int c(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] >= 0) {
                i += iArr[i2];
            }
        }
        return i / iArr.length;
    }

    private boolean d(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i : iArr) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    public void a(int i) {
        this.f194f += i;
    }

    public void b() {
        this.f192c = false;
        this.f193d = null;
    }

    public void e(a aVar) {
        this.f193d = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[8];
        Arrays.fill(iArr, -1);
        int i = 0;
        int i2 = 0;
        while (this.f192c) {
            try {
                Thread.sleep(1000L);
                int intValue = new BigDecimal(this.f194f - i).setScale(1, 4).intValue();
                i = this.f194f;
                iArr[i2] = intValue;
                i2 = (i2 + 1) % 8;
                if (d(iArr)) {
                    int c2 = c(iArr);
                    a aVar = this.f193d;
                    if (aVar != null) {
                        aVar.b(c2);
                    }
                }
            } catch (InterruptedException unused) {
                b();
            }
        }
    }
}
