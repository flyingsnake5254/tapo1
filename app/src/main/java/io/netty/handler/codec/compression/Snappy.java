package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes3.dex */
public final class Snappy {
    private static final int COPY_1_BYTE_OFFSET = 1;
    private static final int COPY_2_BYTE_OFFSET = 2;
    private static final int COPY_4_BYTE_OFFSET = 3;
    private static final int LITERAL = 0;
    private static final int MAX_HT_SIZE = 16384;
    private static final int MIN_COMPRESSIBLE_BYTES = 15;
    private static final int NOT_ENOUGH_INPUT = -1;
    private static final int PREAMBLE_NOT_FULL = -1;
    private State state = State.READY;
    private byte tag;
    private int written;

    /* renamed from: io.netty.handler.codec.compression.Snappy$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Snappy$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Snappy$State = iArr;
            try {
                iArr[State.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_PREAMBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_TAG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_LITERAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_COPY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private enum State {
        READY,
        READING_PREAMBLE,
        READING_TAG,
        READING_LITERAL,
        READING_COPY
    }

    private static int bitsToEncode(int i) {
        int highestOneBit = Integer.highestOneBit(i);
        int i2 = 0;
        while (true) {
            highestOneBit >>= 1;
            if (highestOneBit == 0) {
                return i2;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int calculateChecksum(ByteBuf byteBuf) {
        return calculateChecksum(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static int decodeCopyWith1ByteOffset(byte b2, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (!byteBuf.isReadable()) {
            return -1;
        }
        int writerIndex = byteBuf2.writerIndex();
        int i2 = ((b2 & 28) >> 2) + 4;
        int readUnsignedByte = (((b2 & 224) << 8) >> 5) | byteBuf.readUnsignedByte();
        validateOffset(readUnsignedByte, i);
        byteBuf2.markReaderIndex();
        if (readUnsignedByte < i2) {
            for (int i3 = i2 / readUnsignedByte; i3 > 0; i3--) {
                byteBuf2.readerIndex(writerIndex - readUnsignedByte);
                byteBuf2.readBytes(byteBuf2, readUnsignedByte);
            }
            int i4 = i2 % readUnsignedByte;
            if (i4 != 0) {
                byteBuf2.readerIndex(writerIndex - readUnsignedByte);
                byteBuf2.readBytes(byteBuf2, i4);
            }
        } else {
            byteBuf2.readerIndex(writerIndex - readUnsignedByte);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    private static int decodeCopyWith2ByteOffset(byte b2, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (byteBuf.readableBytes() < 2) {
            return -1;
        }
        int writerIndex = byteBuf2.writerIndex();
        int i2 = ((b2 >> 2) & 63) + 1;
        int readUnsignedShortLE = byteBuf.readUnsignedShortLE();
        validateOffset(readUnsignedShortLE, i);
        byteBuf2.markReaderIndex();
        if (readUnsignedShortLE < i2) {
            for (int i3 = i2 / readUnsignedShortLE; i3 > 0; i3--) {
                byteBuf2.readerIndex(writerIndex - readUnsignedShortLE);
                byteBuf2.readBytes(byteBuf2, readUnsignedShortLE);
            }
            int i4 = i2 % readUnsignedShortLE;
            if (i4 != 0) {
                byteBuf2.readerIndex(writerIndex - readUnsignedShortLE);
                byteBuf2.readBytes(byteBuf2, i4);
            }
        } else {
            byteBuf2.readerIndex(writerIndex - readUnsignedShortLE);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    private static int decodeCopyWith4ByteOffset(byte b2, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (byteBuf.readableBytes() < 4) {
            return -1;
        }
        int writerIndex = byteBuf2.writerIndex();
        int i2 = ((b2 >> 2) & 63) + 1;
        int readIntLE = byteBuf.readIntLE();
        validateOffset(readIntLE, i);
        byteBuf2.markReaderIndex();
        if (readIntLE < i2) {
            for (int i3 = i2 / readIntLE; i3 > 0; i3--) {
                byteBuf2.readerIndex(writerIndex - readIntLE);
                byteBuf2.readBytes(byteBuf2, readIntLE);
            }
            int i4 = i2 % readIntLE;
            if (i4 != 0) {
                byteBuf2.readerIndex(writerIndex - readIntLE);
                byteBuf2.readBytes(byteBuf2, i4);
            }
        } else {
            byteBuf2.readerIndex(writerIndex - readIntLE);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    static int decodeLiteral(byte b2, ByteBuf byteBuf, ByteBuf byteBuf2) {
        byteBuf.markReaderIndex();
        int i = (b2 >> 2) & 63;
        switch (i) {
            case 60:
                if (byteBuf.isReadable()) {
                    i = byteBuf.readUnsignedByte();
                    break;
                } else {
                    return -1;
                }
            case 61:
                if (byteBuf.readableBytes() >= 2) {
                    i = byteBuf.readUnsignedShortLE();
                    break;
                } else {
                    return -1;
                }
            case 62:
                if (byteBuf.readableBytes() >= 3) {
                    i = byteBuf.readUnsignedMediumLE();
                    break;
                } else {
                    return -1;
                }
            case 63:
                if (byteBuf.readableBytes() >= 4) {
                    i = byteBuf.readIntLE();
                    break;
                } else {
                    return -1;
                }
        }
        int i2 = i + 1;
        if (byteBuf.readableBytes() < i2) {
            byteBuf.resetReaderIndex();
            return -1;
        }
        byteBuf2.writeBytes(byteBuf, i2);
        return i2;
    }

    private static void encodeCopy(ByteBuf byteBuf, int i, int i2) {
        while (i2 >= 68) {
            encodeCopyWithOffset(byteBuf, i, 64);
            i2 -= 64;
        }
        if (i2 > 64) {
            encodeCopyWithOffset(byteBuf, i, 60);
            i2 -= 60;
        }
        encodeCopyWithOffset(byteBuf, i, i2);
    }

    private static void encodeCopyWithOffset(ByteBuf byteBuf, int i, int i2) {
        if (i2 >= 12 || i >= 2048) {
            byteBuf.writeByte(((i2 - 1) << 2) | 2);
            byteBuf.writeByte(i & 255);
            byteBuf.writeByte((i >> 8) & 255);
            return;
        }
        byteBuf.writeByte(((i2 - 4) << 2) | 1 | ((i >> 8) << 5));
        byteBuf.writeByte(i & 255);
    }

    static void encodeLiteral(ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (i < 61) {
            byteBuf2.writeByte((i - 1) << 2);
        } else {
            int i2 = i - 1;
            int bitsToEncode = (bitsToEncode(i2) / 8) + 1;
            byteBuf2.writeByte((bitsToEncode + 59) << 2);
            for (int i3 = 0; i3 < bitsToEncode; i3++) {
                byteBuf2.writeByte((i2 >> (i3 * 8)) & 255);
            }
        }
        byteBuf2.writeBytes(byteBuf, i);
    }

    private static int findMatchingLength(ByteBuf byteBuf, int i, int i2, int i3) {
        int i4 = 0;
        while (i2 <= i3 - 4 && byteBuf.getInt(i2) == byteBuf.getInt(i + i4)) {
            i2 += 4;
            i4 += 4;
        }
        while (i2 < i3 && byteBuf.getByte(i + i4) == byteBuf.getByte(i2)) {
            i2++;
            i4++;
        }
        return i4;
    }

    private static short[] getHashTable(int i) {
        int i2 = 256;
        while (i2 < 16384 && i2 < i) {
            i2 <<= 1;
        }
        return new short[i2];
    }

    private static int hash(ByteBuf byteBuf, int i, int i2) {
        return (byteBuf.getInt(i) * 506832829) >>> i2;
    }

    static int maskChecksum(long j) {
        return (int) (((j << 17) | (j >> 15)) - 1568478504);
    }

    private static int readPreamble(ByteBuf byteBuf) {
        int i = 0;
        int i2 = 0;
        while (byteBuf.isReadable()) {
            short readUnsignedByte = byteBuf.readUnsignedByte();
            int i3 = i2 + 1;
            i |= (readUnsignedByte & 127) << (i2 * 7);
            if ((readUnsignedByte & MqttException.REASON_CODE_SUBSCRIBE_FAILED) == 0) {
                return i;
            }
            if (i3 < 4) {
                i2 = i3;
            } else {
                throw new DecompressionException("Preamble is greater than 4 bytes");
            }
        }
        return 0;
    }

    static void validateChecksum(int i, ByteBuf byteBuf) {
        validateChecksum(i, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static void validateOffset(int i, int i2) {
        if (i == 0) {
            throw new DecompressionException("Offset is less than minimum permissible value");
        } else if (i < 0) {
            throw new DecompressionException("Offset is greater than maximum value supported by this implementation");
        } else if (i > i2) {
            throw new DecompressionException("Offset exceeds size of chunk");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0097 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.buffer.ByteBuf r7, io.netty.buffer.ByteBuf r8) {
        /*
            r6 = this;
        L_0x0000:
            boolean r0 = r7.isReadable()
            if (r0 == 0) goto L_0x00b5
            int[] r0 = io.netty.handler.codec.compression.Snappy.AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$Snappy$State
            io.netty.handler.codec.compression.Snappy$State r1 = r6.state
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            r3 = -1
            r4 = 3
            if (r0 == r2) goto L_0x0078
            if (r0 == r1) goto L_0x007c
            if (r0 == r4) goto L_0x0091
            r5 = 4
            if (r0 == r5) goto L_0x0065
            r5 = 5
            if (r0 == r5) goto L_0x0021
            goto L_0x0000
        L_0x0021:
            byte r0 = r6.tag
            r5 = r0 & 3
            if (r5 == r2) goto L_0x0052
            if (r5 == r1) goto L_0x003f
            if (r5 == r4) goto L_0x002c
            goto L_0x0000
        L_0x002c:
            int r1 = r6.written
            int r0 = decodeCopyWith4ByteOffset(r0, r7, r8, r1)
            if (r0 == r3) goto L_0x003e
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L_0x0000
        L_0x003e:
            return
        L_0x003f:
            int r1 = r6.written
            int r0 = decodeCopyWith2ByteOffset(r0, r7, r8, r1)
            if (r0 == r3) goto L_0x0051
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L_0x0000
        L_0x0051:
            return
        L_0x0052:
            int r1 = r6.written
            int r0 = decodeCopyWith1ByteOffset(r0, r7, r8, r1)
            if (r0 == r3) goto L_0x0064
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L_0x0000
        L_0x0064:
            return
        L_0x0065:
            byte r0 = r6.tag
            int r0 = decodeLiteral(r0, r7, r8)
            if (r0 == r3) goto L_0x0077
            io.netty.handler.codec.compression.Snappy$State r1 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r1
            int r1 = r6.written
            int r1 = r1 + r0
            r6.written = r1
            goto L_0x0000
        L_0x0077:
            return
        L_0x0078:
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_PREAMBLE
            r6.state = r0
        L_0x007c:
            int r0 = readPreamble(r7)
            if (r0 != r3) goto L_0x0083
            return
        L_0x0083:
            if (r0 != 0) goto L_0x008a
            io.netty.handler.codec.compression.Snappy$State r7 = io.netty.handler.codec.compression.Snappy.State.READY
            r6.state = r7
            return
        L_0x008a:
            r8.ensureWritable(r0)
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_TAG
            r6.state = r0
        L_0x0091:
            boolean r0 = r7.isReadable()
            if (r0 != 0) goto L_0x0098
            return
        L_0x0098:
            byte r0 = r7.readByte()
            r6.tag = r0
            r0 = r0 & r4
            if (r0 == 0) goto L_0x00af
            if (r0 == r2) goto L_0x00a9
            if (r0 == r1) goto L_0x00a9
            if (r0 == r4) goto L_0x00a9
            goto L_0x0000
        L_0x00a9:
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_COPY
            r6.state = r0
            goto L_0x0000
        L_0x00af:
            io.netty.handler.codec.compression.Snappy$State r0 = io.netty.handler.codec.compression.Snappy.State.READING_LITERAL
            r6.state = r0
            goto L_0x0000
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Snappy.decode(io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
        encodeLiteral(r13, r14, r3 - r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
        r4 = findMatchingLength(r13, r10 + 4, r3 + 4, r15) + 4;
        r5 = r3 + r4;
        encodeCopy(r14, r3 - r10, r4);
        r13.readerIndex(r13.readerIndex() + r4);
        r3 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0074, code lost:
        if (r5 < r8) goto L_0x0077;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
        r6 = r5 - r0;
        r1[hash(r13, r3, r2)] = (short) (r6 - 1);
        r4 = r3 + 1;
        r7 = hash(r13, r4, r2);
        r10 = r0 + r1[r7];
        r1[r7] = (short) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0097, code lost:
        if (r13.getInt(r4) == r13.getInt(r10)) goto L_0x00a2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a2, code lost:
        r3 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void encode(io.netty.buffer.ByteBuf r13, io.netty.buffer.ByteBuf r14, int r15) {
        /*
            r12 = this;
            r0 = 0
        L_0x0001:
            int r1 = r0 * 7
            int r1 = r15 >>> r1
            r2 = r1 & (-128(0xffffffffffffff80, float:NaN))
            if (r2 == 0) goto L_0x0013
            r1 = r1 & 127(0x7f, float:1.78E-43)
            r1 = r1 | 128(0x80, float:1.794E-43)
            r14.writeByte(r1)
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0013:
            r14.writeByte(r1)
            int r0 = r13.readerIndex()
            short[] r1 = getHashTable(r15)
            int r2 = r1.length
            int r2 = java.lang.Integer.numberOfLeadingZeros(r2)
            int r2 = r2 + 1
            int r3 = r15 - r0
            r4 = 15
            if (r3 < r4) goto L_0x00a8
            int r3 = r0 + 1
            int r4 = hash(r13, r3, r2)
            r5 = r0
        L_0x0032:
            r6 = 32
        L_0x0034:
            int r7 = r6 + 1
            int r6 = r6 >> 5
            int r6 = r6 + r3
            int r8 = r15 + (-4)
            if (r6 <= r8) goto L_0x003f
        L_0x003d:
            r0 = r5
            goto L_0x00a8
        L_0x003f:
            int r9 = hash(r13, r6, r2)
            short r10 = r1[r4]
            int r10 = r10 + r0
            int r11 = r3 - r0
            short r11 = (short) r11
            r1[r4] = r11
            int r4 = r13.getInt(r3)
            int r11 = r13.getInt(r10)
            if (r4 != r11) goto L_0x00a4
            int r4 = r3 - r5
            encodeLiteral(r13, r14, r4)
        L_0x005a:
            int r4 = r10 + 4
            int r5 = r3 + 4
            int r4 = findMatchingLength(r13, r4, r5, r15)
            int r4 = r4 + 4
            int r5 = r3 + r4
            int r3 = r3 - r10
            encodeCopy(r14, r3, r4)
            int r3 = r13.readerIndex()
            int r3 = r3 + r4
            r13.readerIndex(r3)
            int r3 = r5 + (-1)
            if (r5 < r8) goto L_0x0077
            goto L_0x003d
        L_0x0077:
            int r4 = hash(r13, r3, r2)
            int r6 = r5 - r0
            int r7 = r6 + (-1)
            short r7 = (short) r7
            r1[r4] = r7
            int r4 = r3 + 1
            int r7 = hash(r13, r4, r2)
            short r9 = r1[r7]
            int r10 = r0 + r9
            short r6 = (short) r6
            r1[r7] = r6
            int r4 = r13.getInt(r4)
            int r6 = r13.getInt(r10)
            if (r4 == r6) goto L_0x00a2
            int r3 = r3 + 2
            int r4 = hash(r13, r3, r2)
            int r3 = r5 + 1
            goto L_0x0032
        L_0x00a2:
            r3 = r5
            goto L_0x005a
        L_0x00a4:
            r3 = r6
            r6 = r7
            r4 = r9
            goto L_0x0034
        L_0x00a8:
            if (r0 >= r15) goto L_0x00ae
            int r15 = r15 - r0
            encodeLiteral(r13, r14, r15)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Snappy.encode(io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf, int):void");
    }

    public void reset() {
        this.state = State.READY;
        this.tag = (byte) 0;
        this.written = 0;
    }

    static int calculateChecksum(ByteBuf byteBuf, int i, int i2) {
        Crc32c crc32c = new Crc32c();
        try {
            crc32c.update(byteBuf, i, i2);
            return maskChecksum(crc32c.getValue());
        } finally {
            crc32c.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void validateChecksum(int i, ByteBuf byteBuf, int i2, int i3) {
        int calculateChecksum = calculateChecksum(byteBuf, i2, i3);
        if (calculateChecksum != i) {
            throw new DecompressionException("mismatching checksum: " + Integer.toHexString(calculateChecksum) + " (expected: " + Integer.toHexString(i) + ')');
        }
    }
}
