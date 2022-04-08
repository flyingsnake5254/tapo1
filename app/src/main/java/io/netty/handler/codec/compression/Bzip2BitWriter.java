package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
final class Bzip2BitWriter {
    private long bitBuffer;
    private int bitCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flush(ByteBuf byteBuf) {
        int i = this.bitCount;
        if (i > 0) {
            long j = this.bitBuffer;
            int i2 = 64 - i;
            if (i <= 8) {
                byteBuf.writeByte((int) ((j >>> i2) << (8 - i)));
            } else if (i <= 16) {
                byteBuf.writeShort((int) ((j >>> i2) << (16 - i)));
            } else if (i <= 24) {
                byteBuf.writeMedium((int) ((j >>> i2) << (24 - i)));
            } else {
                byteBuf.writeInt((int) ((j >>> i2) << (32 - i)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeBits(ByteBuf byteBuf, int i, long j) {
        if (i < 0 || i > 32) {
            throw new IllegalArgumentException("count: " + i + " (expected: 0-32)");
        }
        int i2 = this.bitCount;
        long j2 = ((j << (64 - i)) >>> i2) | this.bitBuffer;
        int i3 = i2 + i;
        if (i3 >= 32) {
            byteBuf.writeInt((int) (j2 >>> 32));
            j2 <<= 32;
            i3 -= 32;
        }
        this.bitBuffer = j2;
        this.bitCount = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeBoolean(ByteBuf byteBuf, boolean z) {
        int i = this.bitCount + 1;
        long j = 0;
        long j2 = this.bitBuffer | (z ? 1 << (64 - i) : 0L);
        if (i == 32) {
            byteBuf.writeInt((int) (j2 >>> 32));
            i = 0;
        } else {
            j = j2;
        }
        this.bitBuffer = j;
        this.bitCount = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeInt(ByteBuf byteBuf, int i) {
        writeBits(byteBuf, 32, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeUnary(ByteBuf byteBuf, int i) {
        if (i >= 0) {
            while (true) {
                i--;
                if (i > 0) {
                    writeBoolean(byteBuf, true);
                } else {
                    writeBoolean(byteBuf, false);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("value: " + i + " (expected 0 or more)");
        }
    }
}
