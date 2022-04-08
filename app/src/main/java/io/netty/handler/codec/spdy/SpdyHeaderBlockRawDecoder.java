package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
public class SpdyHeaderBlockRawDecoder extends SpdyHeaderBlockDecoder {
    private static final int LENGTH_FIELD_SIZE = 4;
    private ByteBuf cumulation;
    private int headerSize;
    private int length;
    private final int maxHeaderSize;
    private String name;
    private int numHeaders;
    private State state = State.READ_NUM_HEADERS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State = iArr;
            try {
                iArr[State.READ_NUM_HEADERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_NAME_LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.SKIP_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_VALUE_LENGTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.READ_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.SKIP_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.END_HEADER_BLOCK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[State.ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum State {
        READ_NUM_HEADERS,
        READ_NAME_LENGTH,
        READ_NAME,
        SKIP_NAME,
        READ_VALUE_LENGTH,
        READ_VALUE,
        SKIP_VALUE,
        END_HEADER_BLOCK,
        ERROR
    }

    public SpdyHeaderBlockRawDecoder(SpdyVersion spdyVersion, int i) {
        ObjectUtil.checkNotNull(spdyVersion, "spdyVersion");
        this.maxHeaderSize = i;
    }

    private static int readLengthField(ByteBuf byteBuf) {
        int signedInt = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex());
        byteBuf.skipBytes(4);
        return signedInt;
    }

    private void releaseBuffer() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            byteBuf.release();
            this.cumulation = null;
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    void decode(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        ObjectUtil.checkNotNull(byteBuf, "headerBlock");
        ObjectUtil.checkNotNull(spdyHeadersFrame, "frame");
        ByteBuf byteBuf2 = this.cumulation;
        if (byteBuf2 == null) {
            decodeHeaderBlock(byteBuf, spdyHeadersFrame);
            if (byteBuf.isReadable()) {
                ByteBuf buffer = byteBufAllocator.buffer(byteBuf.readableBytes());
                this.cumulation = buffer;
                buffer.writeBytes(byteBuf);
                return;
            }
            return;
        }
        byteBuf2.writeBytes(byteBuf);
        decodeHeaderBlock(this.cumulation, spdyHeadersFrame);
        if (this.cumulation.isReadable()) {
            this.cumulation.discardReadBytes();
        } else {
            releaseBuffer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0000 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decodeHeaderBlock(io.netty.buffer.ByteBuf r9, io.netty.handler.codec.spdy.SpdyHeadersFrame r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.decodeHeaderBlock(io.netty.buffer.ByteBuf, io.netty.handler.codec.spdy.SpdyHeadersFrame):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void end() {
        releaseBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void endHeaderBlock(SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        if (this.state != State.END_HEADER_BLOCK) {
            spdyHeadersFrame.setInvalid();
        }
        releaseBuffer();
        this.headerSize = 0;
        this.name = null;
        this.state = State.READ_NUM_HEADERS;
    }
}
