package b.d.w.c.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import androidx.annotation.NonNull;
import b.d.w.b.b;
import com.tplink.libtputility.log.tiny.bean.d;
import com.tplink.libtputility.security.PlainEncryptKeyDelegate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TinyDiskWriteHandler.java */
/* loaded from: classes3.dex */
public class f extends Handler {
    private static final String a = System.getProperty("line.separator");

    /* renamed from: b  reason: collision with root package name */
    private final com.tplink.libtputility.security.a f821b;

    /* renamed from: c  reason: collision with root package name */
    private final String f822c;

    /* renamed from: d  reason: collision with root package name */
    private final String f823d;

    /* renamed from: e  reason: collision with root package name */
    private final StringBuffer f824e;

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue<com.tplink.libtputility.log.tiny.bean.a> f825f;
    private final ExecutorService g;
    private int h;

    /* compiled from: TinyDiskWriteHandler.java */
    /* loaded from: classes3.dex */
    class a implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f826c = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("pool-tinyLogCache.executorService-" + this.f826c.incrementAndGet());
            return thread;
        }
    }

    public f(Context context, Looper looper) {
        super(looper);
        byte[] bArr = new byte[0];
        try {
            bArr = b.d.w.h.a.f(PlainEncryptKeyDelegate.b().getBytes("utf-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        this.f821b = new com.tplink.libtputility.security.a(bArr, null, "AES");
        String absolutePath = context.getApplicationContext().getCacheDir().getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        sb.append(absolutePath);
        String str = File.separator;
        sb.append(str);
        sb.append("tiny_logger");
        String sb2 = sb.toString();
        this.f822c = sb2 + str + "snap";
        this.f823d = sb2 + str + "block";
        this.f825f = new LinkedBlockingQueue();
        this.f824e = new StringBuffer(2048002);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1, new a());
        this.g = newFixedThreadPool;
        newFixedThreadPool.execute(new Runnable() { // from class: b.d.w.c.c.c
            @Override // java.lang.Runnable
            public final void run() {
                f.this.n();
            }
        });
    }

    private void a(d dVar) {
        com.tplink.libtputility.log.tiny.bean.a aVar;
        if (dVar != null && dVar.b() != null) {
            if (dVar.b().length() >= 1024000 - this.f824e.length()) {
                try {
                    aVar = new com.tplink.libtputility.log.tiny.bean.a(this.f824e.toString());
                } catch (Exception unused) {
                    aVar = null;
                }
                if (aVar != null) {
                    l(aVar);
                    aVar.j(this.f823d);
                    if (this.h - 2048000 > 0 && this.f825f.size() > 2) {
                        f(2);
                    }
                    b.c(new File(this.f822c, "logs_snap.dat"));
                    StringBuffer stringBuffer = this.f824e;
                    stringBuffer.delete(0, stringBuffer.length());
                }
            }
            p(dVar);
        }
    }

    private File c() {
        b.d(this.f822c);
        return new File(this.f822c, "logs_snap.dat");
    }

    private String d(String str) throws Exception {
        return new String(b.d.w.h.a.e(this.f821b.b(Base64.decode(str, 2))), "UTF-8");
    }

    private String e(String str) throws Exception {
        return new String(Base64.encode(this.f821b.d(b.d.w.h.a.d(str.getBytes("UTF-8"))), 2), "UTF-8");
    }

    private void f(int i) {
        if (i <= this.f825f.size()) {
            for (int i2 = 0; i2 < i; i2++) {
                m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ String i() throws Exception {
        com.tplink.libtputility.log.tiny.bean.a aVar;
        ArrayList<com.tplink.libtputility.log.tiny.bean.a> arrayList = new ArrayList(Arrays.asList((com.tplink.libtputility.log.tiny.bean.a[]) this.f825f.toArray(new com.tplink.libtputility.log.tiny.bean.a[this.f825f.size()])));
        int i = this.h;
        try {
            aVar = new com.tplink.libtputility.log.tiny.bean.a(this.f824e.toString());
        } catch (Exception unused) {
            aVar = null;
        }
        if (aVar != null) {
            arrayList.add(aVar);
            i += aVar.g();
        }
        if (i <= 1638400) {
            return new com.tplink.libtputility.log.tiny.bean.b(arrayList).a();
        }
        ArrayList arrayList2 = new ArrayList();
        for (com.tplink.libtputility.log.tiny.bean.a aVar2 : arrayList) {
            arrayList2.add(aVar2);
            i -= aVar2.g();
            if (i <= 1638400) {
                break;
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList2.size();
        for (int i2 = size; i2 < arrayList.size(); i2++) {
            arrayList3.add(arrayList.get(i2));
        }
        f(size);
        return new com.tplink.libtputility.log.tiny.bean.b(arrayList3).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(String str, String str2) {
        a(new d(str, str2));
    }

    private void l(com.tplink.libtputility.log.tiny.bean.a aVar) {
        this.f825f.offer(aVar);
        this.h += aVar.g();
    }

    private void m() {
        com.tplink.libtputility.log.tiny.bean.a poll = this.f825f.poll();
        if (poll != null) {
            this.h -= poll.g();
            b.c(new File(this.f823d, poll.f()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        File file = new File(this.f823d);
        if (file.exists() && !file.isFile()) {
            for (File file2 : b.f(file.listFiles())) {
                com.tplink.libtputility.log.tiny.bean.a d2 = com.tplink.libtputility.log.tiny.bean.a.d(file2);
                if (d2 != null) {
                    l(d2);
                }
            }
        }
        o();
    }

    private void o() {
        String str = "";
        try {
            FileReader fileReader = new FileReader(c());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(d(readLine));
            }
            str = sb.toString();
            bufferedReader.close();
            fileReader.close();
        } catch (Exception unused) {
        }
        this.f824e.append(str);
    }

    private void p(d dVar) {
        this.f824e.append(dVar.b());
        try {
            FileWriter fileWriter = new FileWriter(c(), true);
            fileWriter.append((CharSequence) dVar.a());
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception unused) {
        }
    }

    public Future<String> b() {
        return this.g.submit(new Callable() { // from class: b.d.w.c.c.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f.this.i();
            }
        });
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        final String str = (String) message.obj;
        try {
            final String str2 = e(str) + a;
            this.g.execute(new Runnable() { // from class: b.d.w.c.c.a
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.k(str2, str);
                }
            });
        } catch (Exception unused) {
        }
    }
}
