package org.apache.commons.io;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.Objects;

/* compiled from: FileUtils.java */
/* loaded from: classes4.dex */
public class a {
    public static final BigInteger a;

    /* renamed from: b  reason: collision with root package name */
    public static final BigInteger f16617b;

    /* renamed from: c  reason: collision with root package name */
    public static final BigInteger f16618c;

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f16619d;

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f16620e;

    /* renamed from: f  reason: collision with root package name */
    public static final BigInteger f16621f;
    public static final BigInteger g;
    public static final BigInteger h;
    public static final File[] i = new File[0];

    static {
        BigInteger valueOf = BigInteger.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
        a = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        f16617b = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        f16618c = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        f16619d = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        f16620e = multiply4;
        f16621f = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).multiply(BigInteger.valueOf(1152921504606846976L));
        g = multiply5;
        h = valueOf.multiply(multiply5);
    }

    private static void a(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    private static void b(File file, File file2) throws FileNotFoundException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
    }

    public static void c(File file) throws IOException {
        IOException e2 = null;
        for (File file2 : p(file)) {
            try {
                i(file2);
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 != null) {
            throw e2;
        }
    }

    public static void d(File file, File file2) throws IOException {
        e(file, file2, true);
    }

    public static void e(File file, File file2, boolean z) throws IOException {
        b(file, file2);
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!file2.exists() || file2.canWrite()) {
                h(file, file2, z);
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        } else {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
    }

    public static void f(File file) throws IOException {
        if (file.exists()) {
            if (!k(file)) {
                c(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static boolean g(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                c(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    private static void h(File file, File file2, boolean z) throws IOException {
        if (!file2.exists() || !file2.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                FileChannel channel2 = fileOutputStream.getChannel();
                try {
                    long size = channel.size();
                    long j = 0;
                    while (j < size) {
                        long j2 = size - j;
                        long transferFrom = channel2.transferFrom(channel, j, j2 > 31457280 ? 31457280L : j2);
                        if (transferFrom == 0) {
                            break;
                        }
                        j += transferFrom;
                    }
                    if (channel2 != null) {
                        channel2.close();
                    }
                    fileOutputStream.close();
                    channel.close();
                    fileInputStream.close();
                    long length = file.length();
                    long length2 = file2.length();
                    if (length != length2) {
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } else if (z) {
                        file2.setLastModified(file.lastModified());
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (channel2 != null) {
                            try {
                                channel2.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } else {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
    }

    public static void i(File file) throws IOException {
        if (file.isDirectory()) {
            f(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static boolean j(File file, long j) {
        if (file != null) {
            return file.exists() && file.lastModified() > j;
        }
        throw new IllegalArgumentException("No specified file");
    }

    public static boolean k(File file) throws IOException {
        Objects.requireNonNull(file, "File must not be null");
        return Files.isSymbolicLink(file.toPath());
    }

    public static void l(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        } else if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        } else if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        } else if (!file.renameTo(file2)) {
            d(file, file2);
            if (!file.delete()) {
                g(file2);
                throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
            }
        }
    }

    private static long m(File file) {
        if (file.isDirectory()) {
            return o(file);
        }
        return file.length();
    }

    public static long n(File file) {
        a(file);
        return o(file);
    }

    private static long o(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        long j = 0;
        for (File file2 : listFiles) {
            try {
                if (!k(file2)) {
                    j += m(file2);
                    if (j < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            } catch (IOException unused) {
            }
        }
        return j;
    }

    private static File[] p(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                return listFiles;
            }
            throw new IOException("Failed to list contents of " + file);
        } else {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }
}
