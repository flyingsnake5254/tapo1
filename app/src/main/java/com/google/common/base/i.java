package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Joiner.java */
/* loaded from: classes2.dex */
public class i {
    private final String a;

    /* compiled from: Joiner.java */
    /* loaded from: classes2.dex */
    class a extends i {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4130b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(i iVar, String str) {
            super(iVar, null);
            this.f4130b = str;
        }

        @Override // com.google.common.base.i
        CharSequence h(@NullableDecl Object obj) {
            return obj == null ? this.f4130b : i.this.h(obj);
        }

        @Override // com.google.common.base.i
        public i i(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    /* synthetic */ i(i iVar, a aVar) {
        this(iVar);
    }

    public static i f(char c2) {
        return new i(String.valueOf(c2));
    }

    public static i g(String str) {
        return new i(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A a(A a2, Iterator<?> it) throws IOException {
        n.o(a2);
        if (it.hasNext()) {
            a2.append(h(it.next()));
            while (it.hasNext()) {
                a2.append(this.a);
                a2.append(h(it.next()));
            }
        }
        return a2;
    }

    @CanIgnoreReturnValue
    public final StringBuilder b(StringBuilder sb, Iterator<?> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String c(Iterable<?> iterable) {
        return d(iterable.iterator());
    }

    public final String d(Iterator<?> it) {
        return b(new StringBuilder(), it).toString();
    }

    public final String e(Object[] objArr) {
        return c(Arrays.asList(objArr));
    }

    CharSequence h(Object obj) {
        n.o(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public i i(String str) {
        n.o(str);
        return new a(this, str);
    }

    private i(String str) {
        this.a = (String) n.o(str);
    }

    private i(i iVar) {
        this.a = iVar.a;
    }
}
