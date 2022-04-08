package b.a.a.a.a.a;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import b.a.a.a.a.a.e.a.a;
import b.a.a.a.a.a.e.a.b.b;
import b.a.a.a.a.a.e.a.b.c;
import io.reactivex.q;

/* compiled from: ReactiveNetwork.java */
/* loaded from: classes.dex */
public class d {
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static q<a> a(Context context) {
        a aVar;
        if (c.c()) {
            aVar = new b();
        } else if (c.b()) {
            aVar = new b.a.a.a.a.a.e.a.b.a();
        } else {
            aVar = new c();
        }
        return b(context, aVar);
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static q<a> b(Context context, a aVar) {
        c.a(context, "context == null");
        c.a(aVar, "strategy == null");
        return aVar.a(context);
    }
}
