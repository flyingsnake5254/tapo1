package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractIterator.java */
/* loaded from: classes2.dex */
public abstract class c<T> extends j3<T> {

    /* renamed from: c  reason: collision with root package name */
    private b f4373c = b.NOT_READY;
    @NullableDecl

    /* renamed from: d  reason: collision with root package name */
    private T f4374d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractIterator.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractIterator.java */
    /* loaded from: classes2.dex */
    public enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean c() {
        this.f4373c = b.FAILED;
        this.f4374d = a();
        if (this.f4373c == b.DONE) {
            return false;
        }
        this.f4373c = b.READY;
        return true;
    }

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public final T b() {
        this.f4373c = b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        n.u(this.f4373c != b.FAILED);
        int i = a.a[this.f4373c.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final T next() {
        if (hasNext()) {
            this.f4373c = b.NOT_READY;
            T t = this.f4374d;
            this.f4374d = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
