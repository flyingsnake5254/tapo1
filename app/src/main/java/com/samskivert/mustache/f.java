package com.samskivert.mustache;

import com.samskivert.mustache.MustacheException;
import com.samskivert.mustache.g;
import com.tplink.libtpmediastatistics.SSLClient;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* compiled from: Mustache.java */
/* loaded from: classes2.dex */
public class f {
    protected static final u a = new a();

    /* renamed from: b  reason: collision with root package name */
    protected static final l f5139b = new b();

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    static class a implements u {
        a() {
        }

        @Override // com.samskivert.mustache.f.u
        public Reader a(String str) {
            throw new UnsupportedOperationException("Template loading not configured");
        }
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    static class b implements l {
        b() {
        }

        @Override // com.samskivert.mustache.f.l
        public String a(Object obj) {
            return String.valueOf(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public static class c {
        protected final C0186f a;

        /* renamed from: b  reason: collision with root package name */
        protected final boolean f5140b;

        /* renamed from: c  reason: collision with root package name */
        protected final List<g.f> f5141c = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Mustache.java */
        /* loaded from: classes2.dex */
        public class a extends c {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f5142d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f5143e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ c f5144f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C0186f fVar, boolean z, String str, int i, c cVar) {
                super(fVar, z);
                this.f5142d = str;
                this.f5143e = i;
                this.f5144f = cVar;
            }

            @Override // com.samskivert.mustache.f.c
            protected c a(String str, int i) {
                c.g(this.f5142d, str, i);
                this.f5144f.f5141c.add(new s(this.a, str, super.e(), this.f5143e));
                return this.f5144f;
            }

            @Override // com.samskivert.mustache.f.c
            public g.f[] e() {
                throw new MustacheParseException("Section missing close tag '" + this.f5142d + "'", this.f5143e);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Mustache.java */
        /* loaded from: classes2.dex */
        public class b extends c {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f5145d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f5146e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ c f5147f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C0186f fVar, boolean z, String str, int i, c cVar) {
                super(fVar, z);
                this.f5145d = str;
                this.f5146e = i;
                this.f5147f = cVar;
            }

            @Override // com.samskivert.mustache.f.c
            protected c a(String str, int i) {
                c.g(this.f5145d, str, i);
                this.f5147f.f5141c.add(new n(this.a, str, super.e(), this.f5146e));
                return this.f5147f;
            }

            @Override // com.samskivert.mustache.f.c
            public g.f[] e() {
                throw new MustacheParseException("Inverted section missing close tag '" + this.f5145d + "'", this.f5146e);
            }
        }

        public c(C0186f fVar, boolean z) {
            this.a = fVar;
            this.f5140b = z;
        }

        protected static void f(String str, int i) {
            if (str.indexOf(10) != -1 || str.indexOf(13) != -1) {
                throw new MustacheParseException("Invalid tag name: contains newline '" + str + "'", i);
            }
        }

        protected static void g(String str, String str2, int i) {
            if (!str.equals(str2)) {
                throw new MustacheParseException("Section close tag with mismatched open tag '" + str2 + "' != '" + str + "'", i);
            }
        }

        protected c a(String str, int i) {
            throw new MustacheParseException("Section close tag with no open tag '" + str + "'", i);
        }

        public void b() {
            this.f5141c.add(new j());
        }

        public c c(StringBuilder sb, int i) {
            String trim = sb.toString().trim();
            String trim2 = trim.substring(1).trim();
            sb.setLength(0);
            char charAt = trim.charAt(0);
            if (charAt == '!') {
                this.f5141c.add(new j());
                return this;
            } else if (charAt == '#') {
                f(trim, i);
                return new a(this.a, false, trim2, i, this);
            } else if (charAt == '&') {
                f(trim, i);
                this.f5141c.add(new w(trim2, i, this.a.g, c.f5136b));
                return this;
            } else if (charAt == '/') {
                f(trim, i);
                return a(trim2, i);
            } else if (charAt == '>') {
                this.f5141c.add(new m(this.a, trim2));
                return this;
            } else if (charAt != '^') {
                f(trim, i);
                List<g.f> list = this.f5141c;
                C0186f fVar = this.a;
                list.add(new w(trim, i, fVar.g, fVar.h));
                return this;
            } else {
                f(trim, i);
                return new b(this.a, false, trim2, i, this);
            }
        }

        public void d(StringBuilder sb) {
            if (sb.length() > 0) {
                this.f5141c.add(new t(sb.toString(), this.f5141c.isEmpty() && this.f5140b));
                sb.setLength(0);
            }
        }

        public g.f[] e() {
            List<g.f> list = this.f5141c;
            return (g.f[]) list.toArray(new g.f[list.size()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public static abstract class d extends q {

        /* renamed from: c  reason: collision with root package name */
        protected final g.f[] f5148c;

        protected d(String str, g.f[] fVarArr, int i) {
            super(str, i);
            this.f5148c = f.d(fVarArr, false);
        }

        protected void c(g gVar, g.c cVar, Writer writer) {
            for (g.f fVar : this.f5148c) {
                fVar.a(gVar, cVar, writer);
            }
        }

        public boolean d() {
            g.f[] fVarArr = this.f5148c;
            if (fVarArr.length == 0 || !(fVarArr[0] instanceof t)) {
                return false;
            }
            return ((t) fVarArr[0]).d();
        }

        public boolean e() {
            g.f[] fVarArr = this.f5148c;
            int length = fVarArr.length - 1;
            if (fVarArr.length == 0 || !(fVarArr[length] instanceof t)) {
                return false;
            }
            return ((t) fVarArr[length]).e();
        }

        public void f() {
            g.f[] fVarArr = this.f5148c;
            fVarArr[0] = ((t) fVarArr[0]).f();
        }

        public void g() {
            g.f[] fVarArr = this.f5148c;
            int length = fVarArr.length - 1;
            fVarArr[length] = ((t) fVarArr[length]).g();
        }
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public interface e {
        Iterator<?> a(Object obj);

        <K, V> Map<K, V> b();

        v c(Object obj, String str);
    }

    /* compiled from: Mustache.java */
    /* renamed from: com.samskivert.mustache.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0186f {
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5149b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5150c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f5151d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f5152e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f5153f;
        public final l g;
        public final i h;
        public final u i;
        public final e j;
        public final h k;

        protected C0186f(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, l lVar, i iVar, u uVar, e eVar, h hVar) {
            this.a = z;
            this.f5149b = z2;
            this.f5150c = str;
            this.f5151d = z3;
            this.f5152e = z4;
            this.f5153f = z5;
            this.g = lVar;
            this.h = iVar;
            this.i = uVar;
            this.j = eVar;
            this.k = hVar;
        }

        public g a(Reader reader) {
            return f.a(reader, this);
        }

        public g b(String str) {
            return a(new StringReader(str));
        }

        public String c(String str) {
            String str2 = this.f5150c;
            if (str2 == null) {
                return null;
            }
            return str2.replace("{{name}}", str);
        }

        public boolean d(Object obj) {
            return (this.f5152e && "".equals(this.g.a(obj))) || (this.f5153f && (obj instanceof Number) && ((Number) obj).longValue() == 0);
        }

        public g e(String str) throws MustacheException {
            Reader reader = null;
            try {
                try {
                    reader = this.i.a(str);
                    g a = a(reader);
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                    return a;
                } catch (Exception e3) {
                    if (e3 instanceof RuntimeException) {
                        throw ((RuntimeException) e3);
                    }
                    throw new MustacheException("Unable to load template: " + str, e3);
                }
            } catch (Throwable th) {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e4) {
                        throw new RuntimeException(e4);
                    }
                }
                throw th;
            }
        }
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public interface g {
        Object get(String str) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public static class h {
        public char a = '{';

        /* renamed from: b  reason: collision with root package name */
        public char f5154b = '}';

        /* renamed from: c  reason: collision with root package name */
        public char f5155c = '{';

        /* renamed from: d  reason: collision with root package name */
        public char f5156d = '}';

        protected h() {
        }

        private static String b(String str) {
            return "Invalid delimiter configuration '" + str + "'. Must be of the form {{=1 2=}} or {{=12 34=}} where 1, 2, 3 and 4 are delimiter chars.";
        }

        h a() {
            h hVar = new h();
            hVar.a = this.a;
            hVar.f5155c = this.f5155c;
            hVar.f5154b = this.f5154b;
            hVar.f5156d = this.f5156d;
            return hVar;
        }

        public boolean c() {
            return this.a == '{' && this.f5155c == '{' && this.f5154b == '}' && this.f5156d == '}';
        }

        public h d(String str) {
            String[] split = str.split(SSLClient.WHITE_SPACE);
            if (split.length == 2) {
                int length = split[0].length();
                if (length == 1) {
                    this.a = split[0].charAt(0);
                    this.f5155c = (char) 0;
                } else if (length == 2) {
                    this.a = split[0].charAt(0);
                    this.f5155c = split[0].charAt(1);
                } else {
                    throw new MustacheException(b(str));
                }
                int length2 = split[1].length();
                if (length2 == 1) {
                    this.f5154b = split[1].charAt(0);
                    this.f5156d = (char) 0;
                } else if (length2 == 2) {
                    this.f5154b = split[1].charAt(0);
                    this.f5156d = split[1].charAt(1);
                } else {
                    throw new MustacheException(b(str));
                }
                return this;
            }
            throw new MustacheException(b(str));
        }
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public interface i {
        String a(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public static class j extends g.f {
        protected j() {
        }

        @Override // com.samskivert.mustache.g.f
        public void a(g gVar, g.c cVar, Writer writer) {
        }

        public String toString() {
            return "Faux";
        }
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public interface k {
        Object a(Object obj, List<Object> list) throws IOException;
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public interface l {
        String a(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public static class m extends g.f {
        protected final C0186f a;

        /* renamed from: b  reason: collision with root package name */
        protected final String f5157b;

        /* renamed from: c  reason: collision with root package name */
        private g f5158c;

        public m(C0186f fVar, String str) {
            this.a = fVar;
            this.f5157b = str;
        }

        @Override // com.samskivert.mustache.g.f
        public void a(g gVar, g.c cVar, Writer writer) {
            c().e(cVar, writer);
        }

        protected g c() {
            if (this.f5158c == null) {
                this.f5158c = this.a.e(this.f5157b);
            }
            return this.f5158c;
        }
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    protected static class n extends d {

        /* renamed from: d  reason: collision with root package name */
        protected final C0186f f5159d;

        public n(C0186f fVar, String str, g.f[] fVarArr, int i) {
            super(str, fVarArr, i);
            this.f5159d = fVar;
        }

        @Override // com.samskivert.mustache.g.f
        public void a(g gVar, g.c cVar, Writer writer) {
            Object h = gVar.h(cVar, this.a, this.f5160b);
            Iterator<?> a = this.f5159d.j.a(h);
            if (a != null) {
                if (!a.hasNext()) {
                    c(gVar, cVar, writer);
                }
            } else if (h instanceof Boolean) {
                if (!((Boolean) h).booleanValue()) {
                    c(gVar, cVar, writer);
                }
            } else if (h instanceof o) {
                try {
                    ((o) h).b(gVar.b(this.f5148c, cVar), writer);
                } catch (IOException e2) {
                    throw new MustacheException(e2);
                }
            } else if (this.f5159d.d(h)) {
                c(gVar, cVar, writer);
            }
        }

        public String toString() {
            return "Inverted(" + this.a + SSLClient.COLON + this.f5160b + "): " + Arrays.toString(this.f5148c);
        }
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public interface o extends p {
        void b(g.d dVar, Writer writer) throws IOException;
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public interface p {
        void a(g.d dVar, Writer writer) throws IOException;
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    protected static abstract class q extends g.f {
        protected final String a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f5160b;

        protected q(String str, int i) {
            this.a = str;
            this.f5160b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public static class r {
        final h a;

        /* renamed from: c  reason: collision with root package name */
        Reader f5162c;

        /* renamed from: d  reason: collision with root package name */
        c f5163d;

        /* renamed from: b  reason: collision with root package name */
        final StringBuilder f5161b = new StringBuilder();

        /* renamed from: e  reason: collision with root package name */
        int f5164e = 0;

        /* renamed from: f  reason: collision with root package name */
        int f5165f = 1;
        int g = 0;
        int h = -1;

        public r(C0186f fVar) {
            this.f5163d = new c(fVar, true);
            this.a = fVar.k.a();
        }

        protected int a() {
            try {
                return this.f5162c.read();
            } catch (IOException e2) {
                throw new MustacheException(e2);
            }
        }

        public c b(Reader reader) {
            this.f5162c = reader;
            while (true) {
                int a = a();
                if (a == -1) {
                    break;
                }
                char c2 = (char) a;
                this.g++;
                c(c2);
                if (c2 == '\n') {
                    this.g = 0;
                    this.f5165f++;
                }
            }
            int i = this.f5164e;
            if (i == 1) {
                this.f5161b.append(this.a.a);
            } else if (i == 2) {
                f.c(this.f5161b, this.a);
                this.f5161b.append(this.a.f5154b);
            } else if (i == 3) {
                f.c(this.f5161b, this.a);
            }
            this.f5163d.d(this.f5161b);
            return this.f5163d;
        }

        protected void c(char c2) {
            int i = this.f5164e;
            if (i == 0) {
                h hVar = this.a;
                if (c2 == hVar.a) {
                    this.f5164e = 1;
                    this.h = this.g;
                    if (hVar.f5155c == 0) {
                        c((char) 0);
                        return;
                    }
                    return;
                }
                this.f5161b.append(c2);
            } else if (i == 1) {
                h hVar2 = this.a;
                if (c2 == hVar2.f5155c) {
                    this.f5163d.d(this.f5161b);
                    this.f5164e = 3;
                    return;
                }
                this.f5161b.append(hVar2.a);
                this.f5164e = 0;
                c(c2);
            } else if (i == 2) {
                h hVar3 = this.a;
                if (c2 == hVar3.f5156d) {
                    if (this.f5161b.charAt(0) == '=') {
                        h hVar4 = this.a;
                        StringBuilder sb = this.f5161b;
                        hVar4.d(sb.substring(1, sb.length() - 1));
                        this.f5161b.setLength(0);
                        this.f5163d.b();
                    } else {
                        if (this.a.c() && this.f5161b.charAt(0) == this.a.a) {
                            int a = a();
                            if (a != 125) {
                                String valueOf = a == -1 ? "" : String.valueOf((char) a);
                                throw new MustacheParseException("Invalid triple-mustache tag: {{" + ((Object) this.f5161b) + "}}" + valueOf, this.f5165f);
                            }
                            this.f5161b.replace(0, 1, "&");
                        }
                        this.f5163d = this.f5163d.c(this.f5161b, this.f5165f);
                    }
                    this.f5164e = 0;
                    return;
                }
                this.f5161b.append(hVar3.f5154b);
                this.f5164e = 3;
                c(c2);
            } else if (i == 3) {
                h hVar5 = this.a;
                if (c2 == hVar5.f5154b) {
                    this.f5164e = 2;
                    if (hVar5.f5156d == 0) {
                        c((char) 0);
                    }
                } else if (c2 != hVar5.a || this.f5161b.length() <= 0 || this.f5161b.charAt(0) == '!') {
                    this.f5161b.append(c2);
                } else {
                    f.c(this.f5161b, this.a);
                    this.f5163d.d(this.f5161b);
                    this.h = this.g;
                    if (this.a.f5155c == 0) {
                        this.f5163d.d(this.f5161b);
                        this.f5164e = 3;
                        return;
                    }
                    this.f5164e = 1;
                }
            }
        }
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    protected static class s extends d {

        /* renamed from: d  reason: collision with root package name */
        protected final C0186f f5166d;

        public s(C0186f fVar, String str, g.f[] fVarArr, int i) {
            super(str, fVarArr, i);
            this.f5166d = fVar;
        }

        @Override // com.samskivert.mustache.g.f
        public void a(g gVar, g.c cVar, Writer writer) {
            Object h = gVar.h(cVar, this.a, this.f5160b);
            Iterator<?> a = this.f5166d.j.a(h);
            if (a != null) {
                int i = 0;
                while (a.hasNext()) {
                    Object next = a.next();
                    boolean z = i == 0;
                    i++;
                    c(gVar, cVar.b(next, i, z, true ^ a.hasNext()), writer);
                }
            } else if (h instanceof Boolean) {
                if (((Boolean) h).booleanValue()) {
                    c(gVar, cVar, writer);
                }
            } else if (h instanceof p) {
                try {
                    ((p) h).a(gVar.b(this.f5148c, cVar), writer);
                } catch (IOException e2) {
                    throw new MustacheException(e2);
                }
            } else if (!this.f5166d.d(h)) {
                c(gVar, cVar.a(h), writer);
            }
        }

        public String toString() {
            return "Section(" + this.a + SSLClient.COLON + this.f5160b + "): " + Arrays.toString(this.f5148c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public static class t extends g.f {
        protected final String a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f5167b;

        /* renamed from: c  reason: collision with root package name */
        protected final int f5168c;

        public t(String str, boolean z) {
            this(str, c(str, true, z), c(str, false, z));
        }

        private static int c(String str, boolean z, boolean z2) {
            int length = str.length();
            if (!z) {
                length = -1;
            }
            int i = z ? 1 : -1;
            for (int i2 = z ? 0 : length - 1; i2 != length; i2 += i) {
                char charAt = str.charAt(i2);
                if (charAt == '\n') {
                    return z ? i2 : i2 + 1;
                }
                if (!Character.isWhitespace(charAt)) {
                    return -1;
                }
            }
            return (z || !z2) ? -1 : 0;
        }

        @Override // com.samskivert.mustache.g.f
        public void a(g gVar, g.c cVar, Writer writer) {
            g.f.b(writer, this.a);
        }

        public boolean d() {
            return this.f5167b != -1;
        }

        public boolean e() {
            return this.f5168c != -1;
        }

        public t f() {
            int i = this.f5167b;
            if (i == -1) {
                return this;
            }
            int i2 = i + 1;
            int i3 = this.f5168c;
            return new t(this.a.substring(i2), -1, i3 == -1 ? -1 : i3 - i2);
        }

        public t g() {
            int i = this.f5168c;
            return i == -1 ? this : new t(this.a.substring(0, i), this.f5167b, -1);
        }

        public String toString() {
            return "Text(" + this.a.replace("\r", "\\r").replace("\n", "\\n") + ")" + this.f5167b + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.f5168c;
        }

        public t(String str, int i, int i2) {
            this.a = str;
            this.f5167b = i;
            this.f5168c = i2;
        }
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public interface u {
        Reader a(String str) throws Exception;
    }

    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public interface v {
        Object a(Object obj, String str) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Mustache.java */
    /* loaded from: classes2.dex */
    public static class w extends q {

        /* renamed from: c  reason: collision with root package name */
        protected final l f5169c;

        /* renamed from: d  reason: collision with root package name */
        protected final i f5170d;

        public w(String str, int i, l lVar, i iVar) {
            super(str, i);
            this.f5169c = lVar;
            this.f5170d = iVar;
        }

        @Override // com.samskivert.mustache.g.f
        public void a(g gVar, g.c cVar, Writer writer) {
            String str;
            StringBuilder sb;
            Object k = gVar.k(cVar, this.a, this.f5160b);
            if (k == null) {
                if (g.l(this.a)) {
                    sb = new StringBuilder();
                    str = "Resolved '.' to null (which is disallowed), on line ";
                } else {
                    sb = new StringBuilder();
                    sb.append("No key, method or field with name '");
                    sb.append(this.a);
                    str = "' on line ";
                }
                sb.append(str);
                sb.append(this.f5160b);
                throw new MustacheException.Context(sb.toString(), this.a, this.f5160b);
            }
            g.f.b(writer, this.f5170d.a(this.f5169c.a(k)));
        }

        public String toString() {
            return "Var(" + this.a + SSLClient.COLON + this.f5160b + ")";
        }
    }

    protected static g a(Reader reader, C0186f fVar) {
        c b2 = new r(fVar).b(reader);
        return new g(d(b2.e(), true), fVar, new e());
    }

    public static C0186f b() {
        return new C0186f(false, false, null, false, false, false, f5139b, c.a, a, new b(), new h());
    }

    protected static void c(StringBuilder sb, h hVar) {
        sb.insert(0, hVar.a);
        char c2 = hVar.f5155c;
        if (c2 != 0) {
            sb.insert(1, c2);
        }
    }

    protected static g.f[] d(g.f[] fVarArr, boolean z) {
        int length = fVarArr.length;
        int i2 = 0;
        while (i2 < length) {
            g.f fVar = fVarArr[i2];
            t tVar = null;
            t tVar2 = i2 > 0 ? fVarArr[i2 - 1] : null;
            t tVar3 = i2 < length + (-1) ? fVarArr[i2 + 1] : null;
            t tVar4 = tVar2 instanceof t ? tVar2 : null;
            if (tVar3 instanceof t) {
                tVar = tVar3;
            }
            boolean z2 = true;
            boolean z3 = (tVar2 == null && z) || (tVar4 != null && tVar4.e());
            if ((tVar3 != null || !z) && (tVar == null || !tVar.d())) {
                z2 = false;
            }
            if (fVar instanceof d) {
                d dVar = (d) fVar;
                if (z3 && dVar.d()) {
                    if (tVar2 != null) {
                        fVarArr[i2 - 1] = tVar4.g();
                    }
                    dVar.f();
                }
                if (z2 && dVar.e()) {
                    dVar.g();
                    if (tVar3 != null) {
                        fVarArr[i2 + 1] = tVar.f();
                    }
                }
            } else if ((fVar instanceof j) && z3 && z2) {
                if (tVar2 != null) {
                    fVarArr[i2 - 1] = tVar4.g();
                }
                if (tVar3 != null) {
                    fVarArr[i2 + 1] = tVar.f();
                }
            }
            i2++;
        }
        return fVarArr;
    }
}
