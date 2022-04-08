package org.apache.commons.io.filefilter;

import java.io.File;

/* compiled from: AbstractFileFilter.java */
/* loaded from: classes4.dex */
public abstract class a implements b {
    @Override // org.apache.commons.io.filefilter.b, java.io.FileFilter
    public boolean accept(File file) {
        return accept(file.getParentFile(), file.getName());
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    @Override // org.apache.commons.io.filefilter.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return accept(new File(file, str));
    }
}
