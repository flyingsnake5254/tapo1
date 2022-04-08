package net.lucode.hackware.magicindicator.buildins.commonnavigator.a;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* compiled from: CommonNavigatorAdapter.java */
/* loaded from: classes4.dex */
public abstract class a {
    private final DataSetObservable a = new DataSetObservable();

    public abstract int a();

    public abstract c b(Context context);

    public abstract d c(Context context, int i);

    public float d(Context context, int i) {
        return 1.0f;
    }

    public final void e() {
        this.a.notifyChanged();
    }

    public final void f(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public final void g(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }
}
