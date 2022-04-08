package org.bouncycastle.util.io.pem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import org.bouncycastle.util.encoders.a;
import org.bouncycastle.util.i;

/* loaded from: classes4.dex */
public class f extends BufferedWriter {

    /* renamed from: c  reason: collision with root package name */
    private final int f17524c;

    /* renamed from: d  reason: collision with root package name */
    private char[] f17525d = new char[64];

    public f(Writer writer) {
        super(writer);
        String d2 = i.d();
        this.f17524c = d2 != null ? d2.length() : 2;
    }

    private void a(byte[] bArr) throws IOException {
        char[] cArr;
        int i;
        byte[] b2 = a.b(bArr);
        int i2 = 0;
        while (i2 < b2.length) {
            int i3 = 0;
            while (true) {
                cArr = this.f17525d;
                if (i3 != cArr.length && (i = i2 + i3) < b2.length) {
                    cArr[i3] = (char) b2[i];
                    i3++;
                }
            }
            write(cArr, 0, i3);
            newLine();
            i2 += this.f17525d.length;
        }
    }

    private void e(String str) throws IOException {
        write("-----END " + str + "-----");
        newLine();
    }

    private void g(String str) throws IOException {
        write("-----BEGIN " + str + "-----");
        newLine();
    }

    public void c(c cVar) throws IOException {
        b a = cVar.a();
        g(a.d());
        if (!a.c().isEmpty()) {
            for (a aVar : a.c()) {
                write(aVar.b());
                write(": ");
                write(aVar.c());
                newLine();
            }
            newLine();
        }
        a(a.b());
        e(a.d());
    }
}
