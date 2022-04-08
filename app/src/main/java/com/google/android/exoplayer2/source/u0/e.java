package com.google.android.exoplayer2.source.u0;

import java.util.NoSuchElementException;

/* compiled from: MediaChunkIterator.java */
/* loaded from: classes.dex */
public interface e {
    public static final e a = new a();

    /* compiled from: MediaChunkIterator.java */
    /* loaded from: classes.dex */
    class a implements e {
        a() {
        }

        @Override // com.google.android.exoplayer2.source.u0.e
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // com.google.android.exoplayer2.source.u0.e
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // com.google.android.exoplayer2.source.u0.e
        public boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
