package uk.co.senab.photoview.e;

import android.content.Context;
import android.os.Build;

/* compiled from: VersionedGestureDetector.java */
/* loaded from: classes4.dex */
public final class f {
    public static d a(Context context, e eVar) {
        d dVar;
        int i = Build.VERSION.SDK_INT;
        if (i < 5) {
            dVar = new a(context);
        } else if (i < 8) {
            dVar = new b(context);
        } else {
            dVar = new c(context);
        }
        dVar.b(eVar);
        return dVar;
    }
}
