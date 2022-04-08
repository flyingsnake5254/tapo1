package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.j;

/* compiled from: Charsets.kt */
/* loaded from: classes4.dex */
public final class d {
    public static final Charset a;

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f16384b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f16385c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f16386d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f16387e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f16388f;
    public static final d g = new d();

    static {
        Charset forName = Charset.forName("UTF-8");
        j.d(forName, "Charset.forName(\"UTF-8\")");
        a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        j.d(forName2, "Charset.forName(\"UTF-16\")");
        f16384b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        j.d(forName3, "Charset.forName(\"UTF-16BE\")");
        f16385c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        j.d(forName4, "Charset.forName(\"UTF-16LE\")");
        f16386d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        j.d(forName5, "Charset.forName(\"US-ASCII\")");
        f16387e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        j.d(forName6, "Charset.forName(\"ISO-8859-1\")");
        f16388f = forName6;
    }

    private d() {
    }
}
