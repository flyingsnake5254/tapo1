package b.d.c.a.j;

import androidx.annotation.NonNull;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* compiled from: CrashHandler.java */
/* loaded from: classes3.dex */
public class a implements Thread.UncaughtExceptionHandler {
    private AbstractC0015a a;

    /* compiled from: CrashHandler.java */
    /* renamed from: b.d.c.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface AbstractC0015a {
        void a(String str);
    }

    public a(AbstractC0015a aVar) {
        this.a = aVar;
    }

    private String a(Throwable th) {
        Throwable th2;
        PrintWriter printWriter;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter2 = null;
        try {
            printWriter = new PrintWriter(stringWriter);
        } catch (Exception unused) {
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            th.printStackTrace(printWriter);
            printWriter.close();
            return stringWriter.toString();
        } catch (Exception unused2) {
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            return "";
        } catch (Throwable th4) {
            th2 = th4;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th2;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        this.a.a(a(th));
    }
}
