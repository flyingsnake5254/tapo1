package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectDecoder;
import io.netty.handler.codec.memcache.DefaultLastMemcacheContent;
import io.netty.handler.codec.memcache.MemcacheContent;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
public abstract class AbstractBinaryMemcacheDecoder<M extends BinaryMemcacheMessage> extends AbstractMemcacheObjectDecoder {
    public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
    private int alreadyReadChunkSize;
    private final int chunkSize;
    private M currentMessage;
    private State state;

    /* renamed from: io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State = iArr;
            try {
                iArr[State.READ_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.READ_EXTRAS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.READ_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.READ_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State[State.BAD_MESSAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum State {
        READ_HEADER,
        READ_EXTRAS,
        READ_KEY,
        READ_CONTENT,
        BAD_MESSAGE
    }

    protected AbstractBinaryMemcacheDecoder() {
        this(8192);
    }

    private MemcacheContent invalidChunk(Exception exc) {
        this.state = State.BAD_MESSAGE;
        DefaultLastMemcacheContent defaultLastMemcacheContent = new DefaultLastMemcacheContent(Unpooled.EMPTY_BUFFER);
        defaultLastMemcacheContent.setDecoderResult(DecoderResult.failure(exc));
        return defaultLastMemcacheContent;
    }

    private M invalidMessage(Exception exc) {
        this.state = State.BAD_MESSAGE;
        M buildInvalidMessage = buildInvalidMessage();
        buildInvalidMessage.setDecoderResult(DecoderResult.failure(exc));
        return buildInvalidMessage;
    }

    protected abstract M buildInvalidMessage();

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelInactive(channelHandlerContext);
        resetDecoder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0074 A[Catch: Exception -> 0x00f1, TryCatch #3 {Exception -> 0x00f1, blocks: (B:27:0x006c, B:29:0x0074, B:32:0x007b, B:33:0x0084), top: B:72:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d8 A[Catch: Exception -> 0x00e5, TryCatch #2 {Exception -> 0x00e5, blocks: (B:34:0x0091, B:38:0x00ae, B:41:0x00b3, B:44:0x00ba, B:46:0x00c5, B:47:0x00cb, B:48:0x00d0, B:51:0x00d8, B:52:0x00dd), top: B:70:0x0091 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, java.util.List<java.lang.Object> r5) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    protected abstract M decodeHeader(ByteBuf byteBuf);

    protected void resetDecoder() {
        M m = this.currentMessage;
        if (m != null) {
            m.release();
            this.currentMessage = null;
        }
        this.alreadyReadChunkSize = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractBinaryMemcacheDecoder(int i) {
        this.state = State.READ_HEADER;
        ObjectUtil.checkPositiveOrZero(i, "chunkSize");
        this.chunkSize = i;
    }
}
