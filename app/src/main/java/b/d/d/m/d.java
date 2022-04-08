package b.d.d.m;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

/* compiled from: Installation.java */
/* loaded from: classes3.dex */
public class d {
    private static String a;

    public static synchronized String a(Context context) {
        String str;
        synchronized (d.class) {
            if (a == null) {
                File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        c(file);
                    }
                    a = b(file);
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            str = a;
        }
        return str;
    }

    private static String b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[(int) randomAccessFile.length()];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        String str = new String(bArr);
        return TextUtils.isEmpty(str) ? "UnKnownUUID" : str;
    }

    private static void c(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(UUID.randomUUID().toString().getBytes());
        fileOutputStream.close();
    }
}
