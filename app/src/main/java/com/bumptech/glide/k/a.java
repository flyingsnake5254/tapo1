package com.bumptech.glide.k;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private final File f1306c;

    /* renamed from: d  reason: collision with root package name */
    private final File f1307d;

    /* renamed from: f  reason: collision with root package name */
    private final File f1308f;
    private Writer p1;
    private int p3;
    private final File q;
    private final int x;
    private long y;
    private final int z;
    private long p0 = 0;
    private final LinkedHashMap<String, d> p2 = new LinkedHashMap<>(0, 0.75f, true);
    private long H3 = 0;
    final ThreadPoolExecutor I3 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable<Void> J3 = new CallableC0041a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0041a implements Callable<Void> {
        CallableC0041a() {
        }

        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.p1 == null) {
                    return null;
                }
                a.this.J();
                if (a.this.B()) {
                    a.this.G();
                    a.this.p3 = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(CallableC0041a aVar) {
            this();
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c {
        private final d a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f1310b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1311c;

        /* synthetic */ c(a aVar, d dVar, CallableC0041a aVar2) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.u(this, false);
        }

        public void b() {
            if (!this.f1311c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() throws IOException {
            a.this.u(this, true);
            this.f1311c = true;
        }

        public File f(int i) throws IOException {
            File k;
            synchronized (a.this) {
                if (this.a.f1317f == this) {
                    if (!this.a.f1316e) {
                        this.f1310b[i] = true;
                    }
                    k = this.a.k(i);
                    a.this.f1306c.mkdirs();
                } else {
                    throw new IllegalStateException();
                }
            }
            return k;
        }

        private c(d dVar) {
            this.a = dVar;
            this.f1310b = dVar.f1316e ? null : new boolean[a.this.z];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class d {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f1313b;

        /* renamed from: c  reason: collision with root package name */
        File[] f1314c;

        /* renamed from: d  reason: collision with root package name */
        File[] f1315d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1316e;

        /* renamed from: f  reason: collision with root package name */
        private c f1317f;
        private long g;

        /* synthetic */ d(a aVar, String str, CallableC0041a aVar2) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.z) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.f1313b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i) {
            return this.f1314c[i];
        }

        public File k(int i) {
            return this.f1315d[i];
        }

        public String l() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f1313b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.a = str;
            this.f1313b = new long[a.this.z];
            this.f1314c = new File[a.this.z];
            this.f1315d = new File[a.this.z];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < a.this.z; i++) {
                sb.append(i);
                this.f1314c[i] = new File(a.this.f1306c, sb.toString());
                sb.append(DiskFileUpload.postfix);
                this.f1315d[i] = new File(a.this.f1306c, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class e {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final long f1318b;

        /* renamed from: c  reason: collision with root package name */
        private final long[] f1319c;

        /* renamed from: d  reason: collision with root package name */
        private final File[] f1320d;

        /* synthetic */ e(a aVar, String str, long j, File[] fileArr, long[] jArr, CallableC0041a aVar2) {
            this(str, j, fileArr, jArr);
        }

        public File a(int i) {
            return this.f1320d[i];
        }

        private e(String str, long j, File[] fileArr, long[] jArr) {
            this.a = str;
            this.f1318b = j;
            this.f1320d = fileArr;
            this.f1319c = jArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.f1306c = file;
        this.x = i;
        this.f1307d = new File(file, "journal");
        this.f1308f = new File(file, "journal.tmp");
        this.q = new File(file, "journal.bkp");
        this.z = i2;
        this.y = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        int i = this.p3;
        return i >= 2000 && i >= this.p2.size();
    }

    public static a C(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    I(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j);
            if (aVar.f1307d.exists()) {
                try {
                    aVar.E();
                    aVar.D();
                    return aVar;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.v();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i, i2, j);
            aVar2.G();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void D() throws IOException {
        w(this.f1308f);
        Iterator<d> it = this.p2.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.f1317f == null) {
                while (i < this.z) {
                    this.p0 += next.f1313b[i];
                    i++;
                }
            } else {
                next.f1317f = null;
                while (i < this.z) {
                    w(next.j(i));
                    w(next.k(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void E() throws IOException {
        b bVar = new b(new FileInputStream(this.f1307d), c.a);
        try {
            String g = bVar.g();
            String g2 = bVar.g();
            String g3 = bVar.g();
            String g4 = bVar.g();
            String g5 = bVar.g();
            if (!"libcore.io.DiskLruCache".equals(g) || !"1".equals(g2) || !Integer.toString(this.x).equals(g3) || !Integer.toString(this.z).equals(g4) || !"".equals(g5)) {
                throw new IOException("unexpected journal header: [" + g + ", " + g2 + ", " + g4 + ", " + g5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    F(bVar.g());
                    i++;
                } catch (EOFException unused) {
                    this.p3 = i - this.p2.size();
                    if (bVar.e()) {
                        G();
                    } else {
                        this.p1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1307d, true), c.a));
                    }
                    c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            c.a(bVar);
            throw th;
        }
    }

    private void F(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.p2.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            d dVar = this.p2.get(str2);
            if (dVar == null) {
                dVar = new d(this, str2, null);
                this.p2.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(SSLClient.WHITE_SPACE);
                dVar.f1316e = true;
                dVar.f1317f = null;
                dVar.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f1317f = new c(this, dVar, null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void G() throws IOException {
        Writer writer = this.p1;
        if (writer != null) {
            t(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1308f), c.a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.x));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.z));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.p2.values()) {
            if (dVar.f1317f != null) {
                bufferedWriter.write("DIRTY " + dVar.a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.a + dVar.l() + '\n');
            }
        }
        t(bufferedWriter);
        if (this.f1307d.exists()) {
            I(this.f1307d, this.q, true);
        }
        I(this.f1308f, this.f1307d, false);
        this.q.delete();
        this.p1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1307d, true), c.a));
    }

    private static void I(File file, File file2, boolean z) throws IOException {
        if (z) {
            w(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() throws IOException {
        while (this.p0 > this.y) {
            H(this.p2.entrySet().iterator().next().getKey());
        }
    }

    private void s() {
        if (this.p1 == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void t(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(c cVar, boolean z) throws IOException {
        d dVar = cVar.a;
        if (dVar.f1317f == cVar) {
            if (z && !dVar.f1316e) {
                for (int i = 0; i < this.z; i++) {
                    if (!cVar.f1310b[i]) {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!dVar.k(i).exists()) {
                        cVar.a();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < this.z; i2++) {
                File k = dVar.k(i2);
                if (!z) {
                    w(k);
                } else if (k.exists()) {
                    File j = dVar.j(i2);
                    k.renameTo(j);
                    long j2 = dVar.f1313b[i2];
                    long length = j.length();
                    dVar.f1313b[i2] = length;
                    this.p0 = (this.p0 - j2) + length;
                }
            }
            this.p3++;
            dVar.f1317f = null;
            if (dVar.f1316e || z) {
                dVar.f1316e = true;
                this.p1.append((CharSequence) "CLEAN");
                this.p1.append(' ');
                this.p1.append((CharSequence) dVar.a);
                this.p1.append((CharSequence) dVar.l());
                this.p1.append('\n');
                if (z) {
                    long j3 = this.H3;
                    this.H3 = 1 + j3;
                    dVar.g = j3;
                }
            } else {
                this.p2.remove(dVar.a);
                this.p1.append((CharSequence) "REMOVE");
                this.p1.append(' ');
                this.p1.append((CharSequence) dVar.a);
                this.p1.append('\n');
            }
            z(this.p1);
            if (this.p0 > this.y || B()) {
                this.I3.submit(this.J3);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static void w(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c y(String str, long j) throws IOException {
        s();
        d dVar = this.p2.get(str);
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, null);
            this.p2.put(str, dVar);
        } else if (dVar.f1317f != null) {
            return null;
        }
        c cVar = new c(this, dVar, null);
        dVar.f1317f = cVar;
        this.p1.append((CharSequence) "DIRTY");
        this.p1.append(' ');
        this.p1.append((CharSequence) str);
        this.p1.append('\n');
        z(this.p1);
        return cVar;
    }

    @TargetApi(26)
    private static void z(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public synchronized e A(String str) throws IOException {
        s();
        d dVar = this.p2.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f1316e) {
            return null;
        }
        for (File file : dVar.f1314c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.p3++;
        this.p1.append((CharSequence) "READ");
        this.p1.append(' ');
        this.p1.append((CharSequence) str);
        this.p1.append('\n');
        if (B()) {
            this.I3.submit(this.J3);
        }
        return new e(this, str, dVar.g, dVar.f1314c, dVar.f1313b, null);
    }

    public synchronized boolean H(String str) throws IOException {
        s();
        d dVar = this.p2.get(str);
        if (dVar != null && dVar.f1317f == null) {
            for (int i = 0; i < this.z; i++) {
                File j = dVar.j(i);
                if (j.exists() && !j.delete()) {
                    throw new IOException("failed to delete " + j);
                }
                this.p0 -= dVar.f1313b[i];
                dVar.f1313b[i] = 0;
            }
            this.p3++;
            this.p1.append((CharSequence) "REMOVE");
            this.p1.append(' ');
            this.p1.append((CharSequence) str);
            this.p1.append('\n');
            this.p2.remove(str);
            if (B()) {
                this.I3.submit(this.J3);
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.p1 != null) {
            Iterator it = new ArrayList(this.p2.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f1317f != null) {
                    dVar.f1317f.a();
                }
            }
            J();
            t(this.p1);
            this.p1 = null;
        }
    }

    public void v() throws IOException {
        close();
        c.b(this.f1306c);
    }

    public c x(String str) throws IOException {
        return y(str, -1L);
    }
}
