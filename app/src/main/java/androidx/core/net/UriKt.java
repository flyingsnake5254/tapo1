package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.j;

/* compiled from: Uri.kt */
/* loaded from: classes.dex */
public final class UriKt {
    public static final File toFile(Uri toFile) {
        j.f(toFile, "$this$toFile");
        if (j.a(toFile.getScheme(), "file")) {
            String path = toFile.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + toFile).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + toFile).toString());
    }

    public static final Uri toUri(String toUri) {
        j.f(toUri, "$this$toUri");
        Uri parse = Uri.parse(toUri);
        j.b(parse, "Uri.parse(this)");
        return parse;
    }

    public static final Uri toUri(File toUri) {
        j.f(toUri, "$this$toUri");
        Uri fromFile = Uri.fromFile(toUri);
        j.b(fromFile, "Uri.fromFile(this)");
        return fromFile;
    }
}
