package io.netty.handler.codec.compression;

/* loaded from: classes3.dex */
final class Bzip2MTFAndRLE2StageEncoder {
    private int alphabetSize;
    private final int[] bwtBlock;
    private final int bwtLength;
    private final boolean[] bwtValuesPresent;
    private final char[] mtfBlock;
    private int mtfLength;
    private final int[] mtfSymbolFrequencies = new int[258];

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bzip2MTFAndRLE2StageEncoder(int[] iArr, int i, boolean[] zArr) {
        this.bwtBlock = iArr;
        this.bwtLength = i;
        this.bwtValuesPresent = zArr;
        this.mtfBlock = new char[i + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode() {
        int i = this.bwtLength;
        boolean[] zArr = this.bwtValuesPresent;
        int[] iArr = this.bwtBlock;
        char[] cArr = this.mtfBlock;
        int[] iArr2 = this.mtfSymbolFrequencies;
        byte[] bArr = new byte[256];
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        char c2 = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (zArr[i3]) {
                i2++;
                bArr[i3] = (byte) i2;
            }
        }
        int i4 = i2 + 1;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i5 < i) {
            int valueToFront = bzip2MoveToFrontTable.valueToFront(bArr[iArr[i5] & 255]);
            if (valueToFront == 0) {
                i6++;
            } else {
                if (i6 > 0) {
                    int i10 = i6 - 1;
                    while (true) {
                        if ((i10 & 1) == 0) {
                            i7++;
                            cArr[i7] = c2;
                            i8++;
                        } else {
                            i7++;
                            cArr[i7] = 1;
                            i9++;
                        }
                        if (i10 <= 1) {
                            break;
                        }
                        i10 = (i10 - 2) >>> 1;
                    }
                    i6 = 0;
                }
                i7++;
                int i11 = valueToFront + 1;
                cArr[i7] = (char) i11;
                iArr2[i11] = iArr2[i11] + 1;
            }
            i5++;
            c2 = 0;
        }
        if (i6 > 0) {
            int i12 = i6 - 1;
            while (true) {
                if ((i12 & 1) == 0) {
                    i7++;
                    cArr[i7] = 0;
                    i8++;
                } else {
                    i7++;
                    cArr[i7] = 1;
                    i9++;
                }
                if (i12 <= 1) {
                    break;
                }
                i12 = (i12 - 2) >>> 1;
            }
        }
        cArr[i7] = (char) i4;
        iArr2[i4] = iArr2[i4] + 1;
        iArr2[0] = iArr2[0] + i8;
        iArr2[1] = iArr2[1] + i9;
        this.mtfLength = i7 + 1;
        this.alphabetSize = i4 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int mtfAlphabetSize() {
        return this.alphabetSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char[] mtfBlock() {
        return this.mtfBlock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int mtfLength() {
        return this.mtfLength;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] mtfSymbolFrequencies() {
        return this.mtfSymbolFrequencies;
    }
}
