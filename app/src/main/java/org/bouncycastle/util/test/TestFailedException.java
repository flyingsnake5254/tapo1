package org.bouncycastle.util.test;

/* loaded from: classes4.dex */
public class TestFailedException extends RuntimeException {
    private a _result;

    public TestFailedException(a aVar) {
        this._result = aVar;
    }

    public a getResult() {
        return this._result;
    }
}
