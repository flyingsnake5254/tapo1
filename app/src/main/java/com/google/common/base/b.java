package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractIterator.java */
/* loaded from: classes2.dex */
abstract class b<T> implements Iterator<T> {

    /* renamed from: c  reason: collision with root package name */
    private EnumC0150b f4114c = EnumC0150b.NOT_READY;
    @NullableDecl

    /* renamed from: d  reason: collision with root package name */
    private T f4115d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractIterator.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC0150b.values().length];
            a = iArr;
            try {
                iArr[EnumC0150b.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC0150b.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractIterator.java */
    /* renamed from: com.google.common.base.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0150b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean c() {
        this.f4114c = EnumC0150b.FAILED;
        this.f4115d = a();
        if (this.f4114c == EnumC0150b.DONE) {
            return false;
        }
        this.f4114c = EnumC0150b.READY;
        return true;
    }

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    @NullableDecl
    public final T b() {
        this.f4114c = EnumC0150b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        n.u(this.f4114c != EnumC0150b.FAILED);
        int i = a.a[this.f4114c.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f4114c = EnumC0150b.NOT_READY;
            T t = this.f4115d;
            this.f4115d = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
