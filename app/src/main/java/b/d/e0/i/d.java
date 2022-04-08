package b.d.e0.i;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import b.b.a.a.a.a;
import b.d.e0.h.e;
import b.d.e0.h.g;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.b;
import com.google.mlkit.vision.barcode.c;
import com.tplink.zxing.activity.CaptureFragment;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* compiled from: DecodeHandler.java */
/* loaded from: classes3.dex */
final class d extends Handler {
    private static final String a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final CaptureFragment f432b;

    /* renamed from: c  reason: collision with root package name */
    private final BarcodeScanner f433c = c.a(new b.a().a());

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CaptureFragment captureFragment) {
        this.f432b = captureFragment;
    }

    private void a(byte[] bArr, int i, int i2) {
        System.currentTimeMillis();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        final g a2 = b.d.e0.h.c.c().a(bArr2, i2, i);
        try {
            e a3 = new e.b().d(i2).b(i).c(0).a();
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(bArr2);
            this.f433c.q(a.a(allocate, a3.c(), a3.a(), a3.b(), 17)).addOnSuccessListener(new OnSuccessListener() { // from class: b.d.e0.i.b
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    d.this.c(a2, (List) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: b.d.e0.i.a
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    d.this.e(exc);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.f432b.B0() != null) {
                Message.obtain(this.f432b.B0(), b.d.e0.d.decode_failed).sendToTarget();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(g gVar, List list) {
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                com.google.mlkit.vision.barcode.a aVar = (com.google.mlkit.vision.barcode.a) it.next();
                String str = a;
                Log.d(str, "decode=" + aVar.b());
                if (this.f432b.B0() != null) {
                    Message obtain = Message.obtain(this.f432b.B0(), b.d.e0.d.decode_succeeded, aVar.b());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("barcode_bitmap", gVar.d());
                    obtain.setData(bundle);
                    obtain.sendToTarget();
                }
            }
        } else if (this.f432b.B0() != null) {
            Log.d(a, "onSuccess not barcode");
            Message.obtain(this.f432b.B0(), b.d.e0.d.decode_failed).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(Exception exc) {
        Log.d(a, "onFailure ----");
        if (this.f432b.B0() != null) {
            Message.obtain(this.f432b.B0(), b.d.e0.d.decode_failed).sendToTarget();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == b.d.e0.d.decode) {
            a((byte[]) message.obj, message.arg1, message.arg2);
        } else if (i == b.d.e0.d.quit) {
            this.f433c.close();
            Looper.myLooper().quit();
        }
    }
}
