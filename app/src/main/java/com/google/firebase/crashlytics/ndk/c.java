package com.google.firebase.crashlytics.ndk;

import java.io.File;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Comparator {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ c f4801c = new c();

    private /* synthetic */ c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((File) obj2).getName().compareTo(((File) obj).getName());
        return compareTo;
    }
}
