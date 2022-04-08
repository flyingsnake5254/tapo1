package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements FilenameFilter {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a f4791c = new a();

    private /* synthetic */ a() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        boolean startsWith;
        startsWith = str.startsWith(CrashlyticsController.APP_EXCEPTION_MARKER_PREFIX);
        return startsWith;
    }
}
