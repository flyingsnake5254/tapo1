package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* compiled from: JsonTreeReader.java */
/* loaded from: classes2.dex */
public final class a extends com.google.gson.stream.a {
    private static final Reader M3 = new C0177a();
    private static final Object N3 = new Object();
    private Object[] O3 = new Object[32];
    private int P3 = 0;
    private String[] Q3 = new String[32];
    private int[] R3 = new int[32];

    /* compiled from: JsonTreeReader.java */
    /* renamed from: com.google.gson.internal.bind.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0177a extends Reader {
        C0177a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    }

    public a(i iVar) {
        super(M3);
        W(iVar);
    }

    private void S(JsonToken jsonToken) throws IOException {
        if (G() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + G() + v());
        }
    }

    private Object T() {
        return this.O3[this.P3 - 1];
    }

    private Object U() {
        Object[] objArr = this.O3;
        int i = this.P3 - 1;
        this.P3 = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private void W(Object obj) {
        int i = this.P3;
        Object[] objArr = this.O3;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.O3 = Arrays.copyOf(objArr, i2);
            this.R3 = Arrays.copyOf(this.R3, i2);
            this.Q3 = (String[]) Arrays.copyOf(this.Q3, i2);
        }
        Object[] objArr2 = this.O3;
        int i3 = this.P3;
        this.P3 = i3 + 1;
        objArr2[i3] = obj;
    }

    private String v() {
        return " at path " + getPath();
    }

    @Override // com.google.gson.stream.a
    public String A() throws IOException {
        S(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) T()).next();
        String str = (String) entry.getKey();
        this.Q3[this.P3 - 1] = str;
        W(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public void C() throws IOException {
        S(JsonToken.NULL);
        U();
        int i = this.P3;
        if (i > 0) {
            int[] iArr = this.R3;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String E() throws IOException {
        JsonToken G = G();
        JsonToken jsonToken = JsonToken.STRING;
        if (G == jsonToken || G == JsonToken.NUMBER) {
            String e2 = ((m) U()).e();
            int i = this.P3;
            if (i > 0) {
                int[] iArr = this.R3;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return e2;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + G + v());
    }

    @Override // com.google.gson.stream.a
    public JsonToken G() throws IOException {
        if (this.P3 == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object T = T();
        if (T instanceof Iterator) {
            boolean z = this.O3[this.P3 - 2] instanceof k;
            Iterator it = (Iterator) T;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z) {
                return JsonToken.NAME;
            }
            W(it.next());
            return G();
        } else if (T instanceof k) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (T instanceof f) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (T instanceof m) {
                m mVar = (m) T;
                if (mVar.q()) {
                    return JsonToken.STRING;
                }
                if (mVar.n()) {
                    return JsonToken.BOOLEAN;
                }
                if (mVar.p()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (T instanceof j) {
                return JsonToken.NULL;
            } else {
                if (T == N3) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // com.google.gson.stream.a
    public void Q() throws IOException {
        if (G() == JsonToken.NAME) {
            A();
            this.Q3[this.P3 - 2] = "null";
        } else {
            U();
            int i = this.P3;
            if (i > 0) {
                this.Q3[i - 1] = "null";
            }
        }
        int i2 = this.P3;
        if (i2 > 0) {
            int[] iArr = this.R3;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public void V() throws IOException {
        S(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) T()).next();
        W(entry.getValue());
        W(new m((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.a
    public void a() throws IOException {
        S(JsonToken.BEGIN_ARRAY);
        W(((f) T()).iterator());
        this.R3[this.P3 - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void c() throws IOException {
        S(JsonToken.BEGIN_OBJECT);
        W(((k) T()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.O3 = new Object[]{N3};
        this.P3 = 1;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.P3) {
            Object[] objArr = this.O3;
            if (objArr[i] instanceof f) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.R3[i]);
                    sb.append(']');
                }
            } else if (objArr[i] instanceof k) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.Q3;
                    if (strArr[i] != null) {
                        sb.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // com.google.gson.stream.a
    public void j() throws IOException {
        S(JsonToken.END_ARRAY);
        U();
        U();
        int i = this.P3;
        if (i > 0) {
            int[] iArr = this.R3;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void k() throws IOException {
        S(JsonToken.END_OBJECT);
        U();
        U();
        int i = this.P3;
        if (i > 0) {
            int[] iArr = this.R3;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean s() throws IOException {
        JsonToken G = G();
        return (G == JsonToken.END_OBJECT || G == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return a.class.getSimpleName();
    }

    @Override // com.google.gson.stream.a
    public boolean w() throws IOException {
        S(JsonToken.BOOLEAN);
        boolean j = ((m) U()).j();
        int i = this.P3;
        if (i > 0) {
            int[] iArr = this.R3;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return j;
    }

    @Override // com.google.gson.stream.a
    public double x() throws IOException {
        JsonToken G = G();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (G == jsonToken || G == JsonToken.STRING) {
            double k = ((m) T()).k();
            if (t() || (!Double.isNaN(k) && !Double.isInfinite(k))) {
                U();
                int i = this.P3;
                if (i > 0) {
                    int[] iArr = this.R3;
                    int i2 = i - 1;
                    iArr[i2] = iArr[i2] + 1;
                }
                return k;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + k);
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + G + v());
    }

    @Override // com.google.gson.stream.a
    public int y() throws IOException {
        JsonToken G = G();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (G == jsonToken || G == JsonToken.STRING) {
            int a = ((m) T()).a();
            U();
            int i = this.P3;
            if (i > 0) {
                int[] iArr = this.R3;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return a;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + G + v());
    }

    @Override // com.google.gson.stream.a
    public long z() throws IOException {
        JsonToken G = G();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (G == jsonToken || G == JsonToken.STRING) {
            long l = ((m) T()).l();
            U();
            int i = this.P3;
            if (i > 0) {
                int[] iArr = this.R3;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return l;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + G + v());
    }
}
