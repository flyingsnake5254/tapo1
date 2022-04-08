package com.google.firebase.crashlytics.ndk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
class NdkCrashFilesManager implements CrashFilesManager {
    private static final Comparator<? super File> LATEST_SESSION_FIRST = c.f4801c;
    private static final int MAX_SESSIONS = 8;
    private final File rootPath;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NdkCrashFilesManager(File file) {
        this.rootPath = file;
    }

    @Nullable
    private static File prepareDirectory(File file) {
        if (file == null) {
            return null;
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    private static void recursiveDelete(@NonNull File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                recursiveDelete(file2);
            }
        }
        file.delete();
    }

    @Override // com.google.firebase.crashlytics.ndk.CrashFilesManager
    public void cleanOldSessionFileDirectories() {
        File[] listFiles = this.rootPath.listFiles(a.f4800c);
        if (listFiles != null) {
            if (listFiles.length > 8) {
                Arrays.sort(listFiles, LATEST_SESSION_FIRST);
                for (int i = 8; i < listFiles.length; i++) {
                    recursiveDelete(listFiles[i]);
                }
            }
        }
    }

    @Override // com.google.firebase.crashlytics.ndk.CrashFilesManager
    public void deleteSessionFileDirectory(String str) {
        recursiveDelete(new File(this.rootPath, str));
    }

    @Override // com.google.firebase.crashlytics.ndk.CrashFilesManager
    public File getSessionFileDirectory(String str) {
        return prepareDirectory(new File(this.rootPath, str));
    }

    @Override // com.google.firebase.crashlytics.ndk.CrashFilesManager
    public boolean hasSessionFileDirectory(String str) {
        return new File(this.rootPath, str).exists();
    }
}
