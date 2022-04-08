package b.d.w.c.c;

import android.content.Context;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import b.c.a.c;
import b.c.a.e;
import com.tplink.libtpmediastatistics.SSLClient;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: TinyDiskFormatStrategy.java */
/* loaded from: classes3.dex */
public class d implements c {
    private static final String a = System.getProperty("line.separator");

    /* renamed from: b  reason: collision with root package name */
    private final Date f807b;

    /* renamed from: c  reason: collision with root package name */
    private final SimpleDateFormat f808c;

    /* renamed from: d  reason: collision with root package name */
    private final e f809d;

    /* renamed from: e  reason: collision with root package name */
    private final String f810e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f811f;

    /* compiled from: TinyDiskFormatStrategy.java */
    /* loaded from: classes3.dex */
    public static final class b {
        Date a;

        /* renamed from: b  reason: collision with root package name */
        SimpleDateFormat f812b;

        /* renamed from: c  reason: collision with root package name */
        e f813c;

        /* renamed from: d  reason: collision with root package name */
        String f814d;

        /* renamed from: e  reason: collision with root package name */
        Context f815e;

        /* renamed from: f  reason: collision with root package name */
        boolean f816f;

        public d a() {
            if (this.a == null) {
                this.a = new Date();
            }
            if (this.f812b == null) {
                this.f812b = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss", Locale.US);
            }
            if (this.f813c == null) {
                HandlerThread handlerThread = new HandlerThread("AndroidTinyFileLogger");
                handlerThread.start();
                this.f813c = new b.c.a.b(new f(this.f815e, handlerThread.getLooper()));
            }
            return new d(this);
        }

        public b b(boolean z) {
            this.f816f = z;
            return this;
        }

        public b c(e eVar) {
            this.f813c = eVar;
            return this;
        }

        private b(Context context) {
            this.f814d = "Tiny";
            this.f816f = true;
            this.f815e = context;
        }
    }

    public d(b bVar) {
        this.f807b = bVar.a;
        this.f808c = bVar.f812b;
        this.f809d = bVar.f813c;
        this.f810e = bVar.f814d;
        this.f811f = bVar.f816f;
    }

    public static b b(Context context) {
        return new b(context);
    }

    @Override // b.c.a.c
    public void a(int i, String str, @NonNull String str2) {
        if (!this.f811f || (str != null && str.equals(this.f810e))) {
            this.f807b.setTime(System.currentTimeMillis());
            this.f809d.a(i, str, this.f808c.format(this.f807b) + SSLClient.COMMA + str + SSLClient.COMMA + str2 + a);
        }
    }
}
