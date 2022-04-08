package b.c.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: LogcatLogStrategy.java */
/* loaded from: classes2.dex */
public class f implements e {
    @Override // b.c.a.e
    public void a(int i, @Nullable String str, @NonNull String str2) {
        k.a(str2);
        if (str == null) {
            str = "NO_TAG";
        }
        Log.println(i, str, str2);
    }
}
