package com.jcraft.jsch;

/* loaded from: classes2.dex */
public class Packet {
    private static Random random;
    byte[] ba4 = new byte[4];
    Buffer buffer;

    public Packet(Buffer buffer) {
        this.buffer = buffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setRandom(Random random2) {
        random = random2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Buffer getBuffer() {
        return this.buffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void padding(int i) {
        Buffer buffer = this.buffer;
        int i2 = buffer.index;
        int i3 = (-i2) & (i - 1);
        if (i3 < i) {
            i3 += i;
        }
        int i4 = (i2 + i3) - 4;
        byte[] bArr = this.ba4;
        bArr[0] = (byte) (i4 >>> 24);
        bArr[1] = (byte) (i4 >>> 16);
        bArr[2] = (byte) (i4 >>> 8);
        bArr[3] = (byte) i4;
        System.arraycopy(bArr, 0, buffer.buffer, 0, 4);
        this.buffer.buffer[4] = (byte) i3;
        synchronized (random) {
            Random random2 = random;
            Buffer buffer2 = this.buffer;
            random2.fill(buffer2.buffer, buffer2.index, i3);
        }
        this.buffer.skip(i3);
    }

    public void reset() {
        this.buffer.index = 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int shift(int i, int i2, int i3) {
        int i4 = i + 5 + 9;
        int i5 = (-i4) & (i2 - 1);
        if (i5 < i2) {
            i5 += i2;
        }
        int i6 = i5 + i4 + i3 + 32;
        Buffer buffer = this.buffer;
        byte[] bArr = buffer.buffer;
        int length = bArr.length;
        int i7 = buffer.index;
        if (length < (((i6 + i7) - 5) - 9) - i) {
            byte[] bArr2 = new byte[(((i7 + i6) - 5) - 9) - i];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.buffer.buffer = bArr2;
        }
        Buffer buffer2 = this.buffer;
        byte[] bArr3 = buffer2.buffer;
        System.arraycopy(bArr3, i4, bArr3, i6, ((buffer2.index - 5) - 9) - i);
        Buffer buffer3 = this.buffer;
        buffer3.index = 10;
        buffer3.putInt(i);
        this.buffer.index = i4;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unshift(byte b2, int i, int i2, int i3) {
        byte[] bArr = this.buffer.buffer;
        System.arraycopy(bArr, i2, bArr, 14, i3);
        Buffer buffer = this.buffer;
        buffer.buffer[5] = b2;
        buffer.index = 6;
        buffer.putInt(i);
        this.buffer.putInt(i3);
        this.buffer.index = i3 + 5 + 9;
    }
}
