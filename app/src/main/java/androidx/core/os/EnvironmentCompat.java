package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    private EnvironmentCompat() {
    }

    @NonNull
    public static String getStorageState(@NonNull File file) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            return Environment.getExternalStorageState(file);
        }
        if (i >= 19) {
            return Environment.getStorageState(file);
        }
        try {
            return file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()) ? Environment.getExternalStorageState() : MEDIA_UNKNOWN;
        } catch (IOException e2) {
            Log.w(TAG, "Failed to resolve canonical path: " + e2);
            return MEDIA_UNKNOWN;
        }
    }
}
