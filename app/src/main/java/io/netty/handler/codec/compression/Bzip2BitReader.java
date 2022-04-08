package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
class Bzip2BitReader {
    private static final int MAX_COUNT_OF_READABLE_BYTES = 268435455;
    private long bitBuffer;
    private int bitCount;
    private ByteBuf in;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasReadableBits(int i) {
        if (i >= 0) {
            return this.bitCount >= i || ((this.in.readableBytes() << 3) & Integer.MAX_VALUE) >= i - this.bitCount;
        }
        throw new IllegalArgumentException("count: " + i + " (expected value greater than 0)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasReadableBytes(int i) {
        if (i >= 0 && i <= MAX_COUNT_OF_READABLE_BYTES) {
            return hasReadableBits(i << 3);
        }
        throw new IllegalArgumentException("count: " + i + " (expected: 0-" + MAX_COUNT_OF_READABLE_BYTES + ')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isReadable() {
        return this.bitCount > 0 || this.in.isReadable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int readBits(int i) {
        int i2;
        long j;
        if (i < 0 || i > 32) {
            throw new IllegalArgumentException("count: " + i + " (expected: 0-32 )");
        }
        int i3 = this.bitCount;
        long j2 = this.bitBuffer;
        if (i3 < i) {
            int readableBytes = this.in.readableBytes();
            if (readableBytes == 1) {
                j = this.in.readUnsignedByte();
                i2 = 8;
            } else if (readableBytes == 2) {
                j = this.in.readUnsignedShort();
                i2 = 16;
            } else if (readableBytes != 3) {
                j = this.in.readUnsignedInt();
                i2 = 32;
            } else {
                j = this.in.readUnsignedMedium();
                i2 = 24;
            }
            j2 = (j2 << i2) | j;
            i3 += i2;
            this.bitBuffer = j2;
        }
        int i4 = i3 - i;
        this.bitCount = i4;
        return (int) ((j2 >>> i4) & (i != 32 ? (1 << i) - 1 : 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean readBoolean() {
        return readBits(1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int readInt() {
        return readBits(32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void refill() {
        this.bitBuffer = (this.bitBuffer << 8) | this.in.readUnsignedByte();
        this.bitCount += 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setByteBuf(ByteBuf byteBuf) {
        this.in = byteBuf;
    }
}
