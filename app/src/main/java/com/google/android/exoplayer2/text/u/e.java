package com.google.android.exoplayer2.text.u;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.common.base.c;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttCssParser.java */
/* loaded from: classes.dex */
final class e {
    private static final Pattern a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f3574b = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: c  reason: collision with root package name */
    private final d0 f3575c = new d0();

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f3576d = new StringBuilder();

    private void a(f fVar, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = a.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    fVar.z((String) g.e(matcher.group(1)));
                }
                str = str.substring(0, indexOf);
            }
            String[] E0 = o0.E0(str, "\\.");
            String str2 = E0[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                fVar.y(str2.substring(0, indexOf2));
                fVar.x(str2.substring(indexOf2 + 1));
            } else {
                fVar.y(str2);
            }
            if (E0.length > 1) {
                fVar.w((String[]) o0.x0(E0, 1, E0.length));
            }
        }
    }

    private static boolean b(d0 d0Var) {
        int e2 = d0Var.e();
        int f2 = d0Var.f();
        byte[] d2 = d0Var.d();
        if (e2 + 2 > f2) {
            return false;
        }
        int i = e2 + 1;
        if (d2[e2] != 47) {
            return false;
        }
        int i2 = i + 1;
        if (d2[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= f2) {
                d0Var.Q(f2 - d0Var.e());
                return true;
            } else if (((char) d2[i2]) == '*' && ((char) d2[i3]) == '/') {
                i2 = i3 + 1;
                f2 = i2;
            } else {
                i2 = i3;
            }
        }
    }

    private static boolean c(d0 d0Var) {
        char k = k(d0Var, d0Var.e());
        if (k != '\t' && k != '\n' && k != '\f' && k != '\r' && k != ' ') {
            return false;
        }
        d0Var.Q(1);
        return true;
    }

    private static void e(String str, f fVar) {
        Matcher matcher = f3574b.matcher(c.e(str));
        if (!matcher.matches()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("Invalid font-size: '");
            sb.append(str);
            sb.append("'.");
            u.h("WebvttCssParser", sb.toString());
            return;
        }
        String str2 = (String) g.e(matcher.group(2));
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 37:
                if (str2.equals("%")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3240:
                if (str2.equals("em")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3592:
                if (str2.equals("px")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                fVar.t(3);
                break;
            case 1:
                fVar.t(2);
                break;
            case 2:
                fVar.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        fVar.s(Float.parseFloat((String) g.e(matcher.group(1))));
    }

    private static String f(d0 d0Var, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int e2 = d0Var.e();
        int f2 = d0Var.f();
        while (e2 < f2 && !z) {
            char c2 = (char) d0Var.d()[e2];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                e2++;
                sb.append(c2);
            }
        }
        d0Var.Q(e2 - d0Var.e());
        return sb.toString();
    }

    @Nullable
    static String g(d0 d0Var, StringBuilder sb) {
        n(d0Var);
        if (d0Var.a() == 0) {
            return null;
        }
        String f2 = f(d0Var, sb);
        if (!"".equals(f2)) {
            return f2;
        }
        StringBuilder sb2 = new StringBuilder(1);
        sb2.append((char) d0Var.D());
        return sb2.toString();
    }

    @Nullable
    private static String h(d0 d0Var, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int e2 = d0Var.e();
            String g = g(d0Var, sb);
            if (g == null) {
                return null;
            }
            if ("}".equals(g) || ";".equals(g)) {
                d0Var.P(e2);
                z = true;
            } else {
                sb2.append(g);
            }
        }
        return sb2.toString();
    }

    @Nullable
    private static String i(d0 d0Var, StringBuilder sb) {
        n(d0Var);
        if (d0Var.a() < 5 || !"::cue".equals(d0Var.A(5))) {
            return null;
        }
        int e2 = d0Var.e();
        String g = g(d0Var, sb);
        if (g == null) {
            return null;
        }
        if ("{".equals(g)) {
            d0Var.P(e2);
            return "";
        }
        String l = "(".equals(g) ? l(d0Var) : null;
        if (!")".equals(g(d0Var, sb))) {
            return null;
        }
        return l;
    }

    private static void j(d0 d0Var, f fVar, StringBuilder sb) {
        n(d0Var);
        String f2 = f(d0Var, sb);
        if (!"".equals(f2) && SSLClient.COLON.equals(g(d0Var, sb))) {
            n(d0Var);
            String h = h(d0Var, sb);
            if (h != null && !"".equals(h)) {
                int e2 = d0Var.e();
                String g = g(d0Var, sb);
                if (!";".equals(g)) {
                    if ("}".equals(g)) {
                        d0Var.P(e2);
                    } else {
                        return;
                    }
                }
                if ("color".equals(f2)) {
                    fVar.q(j.b(h));
                } else if ("background-color".equals(f2)) {
                    fVar.n(j.b(h));
                } else {
                    boolean z = true;
                    if ("ruby-position".equals(f2)) {
                        if ("over".equals(h)) {
                            fVar.v(1);
                        } else if ("under".equals(h)) {
                            fVar.v(2);
                        }
                    } else if ("text-combine-upright".equals(f2)) {
                        if (!"all".equals(h) && !h.startsWith("digits")) {
                            z = false;
                        }
                        fVar.p(z);
                    } else if ("text-decoration".equals(f2)) {
                        if ("underline".equals(h)) {
                            fVar.A(true);
                        }
                    } else if ("font-family".equals(f2)) {
                        fVar.r(h);
                    } else if ("font-weight".equals(f2)) {
                        if ("bold".equals(h)) {
                            fVar.o(true);
                        }
                    } else if ("font-style".equals(f2)) {
                        if ("italic".equals(h)) {
                            fVar.u(true);
                        }
                    } else if ("font-size".equals(f2)) {
                        e(h, fVar);
                    }
                }
            }
        }
    }

    private static char k(d0 d0Var, int i) {
        return (char) d0Var.d()[i];
    }

    private static String l(d0 d0Var) {
        int e2 = d0Var.e();
        int f2 = d0Var.f();
        boolean z = false;
        while (e2 < f2 && !z) {
            e2++;
            z = ((char) d0Var.d()[e2]) == ')';
        }
        return d0Var.A((e2 - 1) - d0Var.e()).trim();
    }

    static void m(d0 d0Var) {
        do {
        } while (!TextUtils.isEmpty(d0Var.p()));
    }

    static void n(d0 d0Var) {
        while (true) {
            for (boolean z = true; d0Var.a() > 0 && z; z = false) {
                if (c(d0Var) || b(d0Var)) {
                }
            }
            return;
        }
    }

    public List<f> d(d0 d0Var) {
        this.f3576d.setLength(0);
        int e2 = d0Var.e();
        m(d0Var);
        this.f3575c.N(d0Var.d(), d0Var.e());
        this.f3575c.P(e2);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String i = i(this.f3575c, this.f3576d);
            if (i == null || !"{".equals(g(this.f3575c, this.f3576d))) {
                return arrayList;
            }
            f fVar = new f();
            a(fVar, i);
            String str = null;
            boolean z = false;
            while (!z) {
                int e3 = this.f3575c.e();
                String g = g(this.f3575c, this.f3576d);
                boolean z2 = g == null || "}".equals(g);
                if (!z2) {
                    this.f3575c.P(e3);
                    j(this.f3575c, fVar, this.f3576d);
                }
                str = g;
                z = z2;
            }
            if ("}".equals(str)) {
                arrayList.add(fVar);
            }
        }
    }
}
