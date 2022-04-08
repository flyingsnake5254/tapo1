package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements LibraryVersionComponent.VersionExtractor {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public final String extract(Object obj) {
        return r1.getPackageManager().getInstallerPackageName(((Context) obj).getPackageName());
    }
}
