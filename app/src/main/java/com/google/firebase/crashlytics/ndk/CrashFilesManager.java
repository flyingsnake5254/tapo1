package com.google.firebase.crashlytics.ndk;

import java.io.File;

/* loaded from: classes2.dex */
interface CrashFilesManager {
    void cleanOldSessionFileDirectories();

    void deleteSessionFileDirectory(String str);

    File getSessionFileDirectory(String str);

    boolean hasSessionFileDirectory(String str);
}
