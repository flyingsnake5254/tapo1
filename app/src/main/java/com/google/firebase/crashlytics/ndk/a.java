package com.google.firebase.crashlytics.ndk;

import java.io.File;
import java.io.FileFilter;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements FileFilter {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a f4800c = new a();

    private /* synthetic */ a() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.isDirectory();
    }
}
