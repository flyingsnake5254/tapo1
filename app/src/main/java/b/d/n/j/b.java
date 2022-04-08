package b.d.n.j;

import java.io.File;

/* compiled from: FileUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static void a(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static boolean b(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }
}
