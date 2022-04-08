package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a f3627c = new a();

    private /* synthetic */ a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return e.v((Format) obj, (Format) obj2);
    }
}
