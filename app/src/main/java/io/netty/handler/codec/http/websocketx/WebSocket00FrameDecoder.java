package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* loaded from: classes3.dex */
public class WebSocket00FrameDecoder extends ReplayingDecoder<Void> implements a {
    static final int DEFAULT_MAX_FRAME_SIZE = 16384;
    private final long maxFrameSize;
    private boolean receivedClosingHandshake;

    public WebSocket00FrameDecoder() {
        this(16384);
    }

    private WebSocketFrame decodeBinaryFrame(ChannelHandlerContext channelHandlerContext, byte b2, ByteBuf byteBuf) {
        byte readByte;
        long j = 0;
        int i = 0;
        do {
            readByte = byteBuf.readByte();
            j = (j << 7) | (readByte & Byte.MAX_VALUE);
            if (j <= this.maxFrameSize) {
                i++;
                if (i > 8) {
                    throw new TooLongFrameException();
                }
            } else {
                throw new TooLongFrameException();
            }
        } while ((readByte & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) == 128);
        if (b2 != -1 || j != 0) {
            return new BinaryWebSocketFrame(ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, (int) j));
        }
        this.receivedClosingHandshake = true;
        return new CloseWebSocketFrame(true, 0, channelHandlerContext.alloc().buffer(0));
    }

    private WebSocketFrame decodeTextFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        int readerIndex = byteBuf.readerIndex();
        int actualReadableBytes = actualReadableBytes();
        int indexOf = byteBuf.indexOf(readerIndex, readerIndex + actualReadableBytes, (byte) -1);
        if (indexOf != -1) {
            int i = indexOf - readerIndex;
            if (i <= this.maxFrameSize) {
                ByteBuf readBytes = ByteBufUtil.readBytes(channelHandlerContext.alloc(), byteBuf, i);
                byteBuf.skipBytes(1);
                if (readBytes.indexOf(readBytes.readerIndex(), readBytes.writerIndex(), (byte) -1) < 0) {
                    return new TextWebSocketFrame(readBytes);
                }
                readBytes.release();
                throw new IllegalArgumentException("a text frame should not contain 0xFF.");
            }
            throw new TooLongFrameException();
        } else if (actualReadableBytes <= this.maxFrameSize) {
            return null;
        } else {
            throw new TooLongFrameException();
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        WebSocketFrame webSocketFrame;
        if (this.receivedClosingHandshake) {
            byteBuf.skipBytes(actualReadableBytes());
            return;
        }
        byte readByte = byteBuf.readByte();
        if ((readByte & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) == 128) {
            webSocketFrame = decodeBinaryFrame(channelHandlerContext, readByte, byteBuf);
        } else {
            webSocketFrame = decodeTextFrame(channelHandlerContext, byteBuf);
        }
        if (webSocketFrame != null) {
            list.add(webSocketFrame);
        }
    }

    public WebSocket00FrameDecoder(int i) {
        this.maxFrameSize = i;
    }

    public WebSocket00FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        this.maxFrameSize = ((WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig")).maxFramePayloadLength();
    }
}