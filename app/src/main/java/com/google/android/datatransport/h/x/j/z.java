package com.google.android.datatransport.h.x.j;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.datatransport.h.x.j.w;
import com.google.auto.value.AutoValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventStoreConfig.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class z {
    static final z a = a().f(10485760).d(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION).b(10000).c(604800000).e(81920).a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventStoreConfig.java */
    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        abstract z a();

        abstract a b(int i);

        abstract a c(long j);

        abstract a d(int i);

        abstract a e(int i);

        abstract a f(long j);
    }

    static a a() {
        return new w.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long f();
}
