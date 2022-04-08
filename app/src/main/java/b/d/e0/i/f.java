package b.d.e0.i;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: FinishListener.java */
/* loaded from: classes3.dex */
public final class f implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable {

    /* renamed from: c  reason: collision with root package name */
    private final Activity f437c;

    public f(Activity activity) {
        this.f437c = activity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f437c.finish();
    }
}
