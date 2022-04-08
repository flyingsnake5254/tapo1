package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.util.d0;

/* loaded from: classes.dex */
abstract class TagPayloadReader {
    protected final b0 a;

    /* loaded from: classes.dex */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TagPayloadReader(b0 b0Var) {
        this.a = b0Var;
    }

    public final boolean a(d0 d0Var, long j) throws ParserException {
        return b(d0Var) && c(d0Var, j);
    }

    protected abstract boolean b(d0 d0Var) throws ParserException;

    protected abstract boolean c(d0 d0Var, long j) throws ParserException;
}
