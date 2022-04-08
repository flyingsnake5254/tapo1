package b.d.i.a.c.b;

import android.text.TextUtils;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.StringTokenizer;

/* compiled from: Authenticate.java */
/* loaded from: classes3.dex */
public class a {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f491b;

    /* renamed from: c  reason: collision with root package name */
    private String f492c;

    /* renamed from: d  reason: collision with root package name */
    private String f493d;

    /* renamed from: e  reason: collision with root package name */
    private String f494e;

    /* renamed from: f  reason: collision with root package name */
    private String f495f;
    private String g;
    private String h;
    private String i;

    private a() {
    }

    private boolean g(String str) {
        return str.toLowerCase().startsWith("digest");
    }

    private void h(String str) {
        if (g(str)) {
            l(str);
            int indexOf = str.toLowerCase().indexOf("realm");
            if (indexOf >= 0) {
                StringTokenizer stringTokenizer = new StringTokenizer(str.substring(indexOf), SSLClient.COMMA);
                while (stringTokenizer.hasMoreTokens()) {
                    n(stringTokenizer.nextToken());
                }
                p("MD5");
            }
        }
    }

    private void i(String str) {
        String lowerCase = str.toLowerCase();
        int indexOf = lowerCase.indexOf("qop=");
        if (indexOf >= 0) {
            int indexOf2 = lowerCase.indexOf(SSLClient.DOUBLE_QUOTATION, indexOf + 4);
            int i = indexOf2 + 1;
            int indexOf3 = lowerCase.indexOf(SSLClient.DOUBLE_QUOTATION, i);
            if (indexOf2 >= 0 && indexOf3 >= 0) {
                try {
                    v(str.substring(i, indexOf3));
                } catch (IndexOutOfBoundsException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static a j(String str) {
        a aVar = new a();
        aVar.h(str);
        return aVar;
    }

    private void k(String str) {
        String lowerCase = str.toLowerCase();
        int indexOf = lowerCase.indexOf("domain=");
        if (indexOf >= 0) {
            int indexOf2 = lowerCase.indexOf(SSLClient.DOUBLE_QUOTATION, indexOf);
            int indexOf3 = lowerCase.indexOf(SSLClient.DOUBLE_QUOTATION, indexOf2 + 1);
            if (indexOf2 >= 0 && indexOf3 >= 0) {
                try {
                    r(str.substring(indexOf + 1, indexOf3));
                } catch (IndexOutOfBoundsException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void l(String str) {
        k(str);
        i(str);
    }

    private void m(String str) {
        str.replaceAll("\\\"", SSLClient.DOUBLE_QUOTATION);
        s(str);
    }

    private void n(String str) {
        String str2;
        IndexOutOfBoundsException e2;
        int indexOf = str.indexOf(SSLClient.EQUALS);
        if (indexOf >= 0) {
            String str3 = null;
            try {
                str2 = str.substring(0, indexOf).toLowerCase();
            } catch (IndexOutOfBoundsException e3) {
                e2 = e3;
                str2 = null;
            }
            try {
                str3 = str.substring(indexOf + 1);
            } catch (IndexOutOfBoundsException e4) {
                e2 = e4;
                e2.printStackTrace();
                if (!TextUtils.isEmpty(str2)) {
                    return;
                }
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                try {
                    String o = o(str3);
                    if ("nonce".equals(str2)) {
                        m(o);
                    } else {
                        u(str2, o);
                    }
                } catch (IndexOutOfBoundsException e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private String o(String str) throws IndexOutOfBoundsException {
        if (str.charAt(0) == '\"') {
            str = str.substring(1);
        }
        return str.charAt(str.length() - 1) == '\"' ? str.substring(0, str.length() - 1) : str;
    }

    private void p(String str) {
        this.f495f = str;
    }

    private void q(String str) {
        this.h = str;
    }

    private void r(String str) {
        this.f491b = str;
    }

    private void s(String str) {
        this.f492c = str;
    }

    private void t(String str) {
        this.f493d = str;
    }

    private void u(String str, String str2) {
        if (str.equals("realm")) {
            w(str2);
        } else if (str.equals("opaque")) {
            t(str2);
        } else if (str.equals("stale")) {
            x(str2);
        } else if (str.equals("algorithm")) {
            p(str2);
        } else if (str.equals("charset")) {
            q(str2);
        } else if (str.equals("userhash")) {
            y(str2);
        }
    }

    private void v(String str) {
        this.g = str;
    }

    private void w(String str) {
        this.a = str;
    }

    private void x(String str) {
        this.f494e = str;
    }

    private void y(String str) {
        this.i = str;
    }

    public String a() {
        return this.f495f;
    }

    public String b() {
        return this.f492c;
    }

    public String c() {
        return this.f493d;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.i;
    }
}
