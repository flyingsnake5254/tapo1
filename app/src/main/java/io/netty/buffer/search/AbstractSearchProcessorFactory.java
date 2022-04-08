package io.netty.buffer.search;

/* loaded from: classes3.dex */
public abstract class AbstractSearchProcessorFactory implements SearchProcessorFactory {
    public static BitapSearchProcessorFactory newBitapSearchProcessorFactory(byte[] bArr) {
        return new BitapSearchProcessorFactory(bArr);
    }

    public static KmpSearchProcessorFactory newKmpSearchProcessorFactory(byte[] bArr) {
        return new KmpSearchProcessorFactory(bArr);
    }
}
