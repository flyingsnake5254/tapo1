package uk.co.senab.photoview.g;

import android.annotation.TargetApi;
import android.content.Context;

/* compiled from: IcsScroller.java */
@TargetApi(14)
/* loaded from: classes4.dex */
public class b extends a {
    public b(Context context) {
        super(context);
    }

    @Override // uk.co.senab.photoview.g.a, uk.co.senab.photoview.g.d
    public boolean a() {
        return this.a.computeScrollOffset();
    }
}
