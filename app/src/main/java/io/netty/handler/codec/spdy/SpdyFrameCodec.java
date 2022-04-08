package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;
import java.util.List;

/* loaded from: classes3.dex */
public class SpdyFrameCodec extends ByteToMessageDecoder implements SpdyFrameDecoderDelegate, ChannelOutboundHandler {
    private static final SpdyProtocolException INVALID_FRAME = new SpdyProtocolException("Received invalid frame");
    private ChannelHandlerContext ctx;
    private boolean read;
    private final SpdyFrameDecoder spdyFrameDecoder;
    private final SpdyFrameEncoder spdyFrameEncoder;
    private final SpdyHeaderBlockDecoder spdyHeaderBlockDecoder;
    private final SpdyHeaderBlockEncoder spdyHeaderBlockEncoder;
    private SpdyHeadersFrame spdyHeadersFrame;
    private SpdySettingsFrame spdySettingsFrame;
    private final boolean validateHeaders;

    public SpdyFrameCodec(SpdyVersion spdyVersion) {
        this(spdyVersion, true);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.read && !channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        this.read = false;
        super.channelReadComplete(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        this.spdyFrameDecoder.decode(byteBuf);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerAdded(channelHandlerContext);
        this.ctx = channelHandlerContext;
        channelHandlerContext.channel().closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.spdy.SpdyFrameCodec.1
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                SpdyFrameCodec.this.spdyHeaderBlockDecoder.end();
                SpdyFrameCodec.this.spdyHeaderBlockEncoder.end();
            }
        });
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.read();
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readDataFrame(int i, boolean z, ByteBuf byteBuf) {
        this.read = true;
        DefaultSpdyDataFrame defaultSpdyDataFrame = new DefaultSpdyDataFrame(i, byteBuf);
        defaultSpdyDataFrame.setLast(z);
        this.ctx.fireChannelRead((Object) defaultSpdyDataFrame);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readFrameError(String str) {
        this.ctx.fireExceptionCaught((Throwable) INVALID_FRAME);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readGoAwayFrame(int i, int i2) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyGoAwayFrame(i, i2));
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readHeaderBlock(ByteBuf byteBuf) {
        try {
            try {
                this.spdyHeaderBlockDecoder.decode(this.ctx.alloc(), byteBuf, this.spdyHeadersFrame);
            } catch (Exception e2) {
                this.ctx.fireExceptionCaught((Throwable) e2);
            }
        } finally {
            byteBuf.release();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readHeaderBlockEnd() {
        /*
            r4 = this;
            r0 = 0
            io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder r1 = r4.spdyHeaderBlockDecoder     // Catch: Exception -> 0x000f
            io.netty.handler.codec.spdy.SpdyHeadersFrame r2 = r4.spdyHeadersFrame     // Catch: Exception -> 0x000f
            r1.endHeaderBlock(r2)     // Catch: Exception -> 0x000f
            io.netty.handler.codec.spdy.SpdyHeadersFrame r1 = r4.spdyHeadersFrame     // Catch: Exception -> 0x000f
            r4.spdyHeadersFrame = r0     // Catch: Exception -> 0x000d
            goto L_0x0018
        L_0x000d:
            r0 = move-exception
            goto L_0x0013
        L_0x000f:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x0013:
            io.netty.channel.ChannelHandlerContext r2 = r4.ctx
            r2.fireExceptionCaught(r0)
        L_0x0018:
            if (r1 == 0) goto L_0x0022
            r0 = 1
            r4.read = r0
            io.netty.channel.ChannelHandlerContext r0 = r4.ctx
            r0.fireChannelRead(r1)
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.spdy.SpdyFrameCodec.readHeaderBlockEnd():void");
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readHeadersFrame(int i, boolean z) {
        DefaultSpdyHeadersFrame defaultSpdyHeadersFrame = new DefaultSpdyHeadersFrame(i, this.validateHeaders);
        this.spdyHeadersFrame = defaultSpdyHeadersFrame;
        defaultSpdyHeadersFrame.setLast(z);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readPingFrame(int i) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyPingFrame(i));
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readRstStreamFrame(int i, int i2) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyRstStreamFrame(i, i2));
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSetting(int i, int i2, boolean z, boolean z2) {
        this.spdySettingsFrame.setValue(i, i2, z, z2);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSettingsEnd() {
        this.read = true;
        SpdySettingsFrame spdySettingsFrame = this.spdySettingsFrame;
        this.spdySettingsFrame = null;
        this.ctx.fireChannelRead((Object) spdySettingsFrame);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSettingsFrame(boolean z) {
        this.read = true;
        DefaultSpdySettingsFrame defaultSpdySettingsFrame = new DefaultSpdySettingsFrame();
        this.spdySettingsFrame = defaultSpdySettingsFrame;
        defaultSpdySettingsFrame.setClearPreviouslyPersistedSettings(z);
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSynReplyFrame(int i, boolean z) {
        DefaultSpdySynReplyFrame defaultSpdySynReplyFrame = new DefaultSpdySynReplyFrame(i, this.validateHeaders);
        defaultSpdySynReplyFrame.setLast(z);
        this.spdyHeadersFrame = defaultSpdySynReplyFrame;
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readSynStreamFrame(int i, int i2, byte b2, boolean z, boolean z2) {
        DefaultSpdySynStreamFrame defaultSpdySynStreamFrame = new DefaultSpdySynStreamFrame(i, i2, b2, this.validateHeaders);
        defaultSpdySynStreamFrame.setLast(z);
        defaultSpdySynStreamFrame.setUnidirectional(z2);
        this.spdyHeadersFrame = defaultSpdySynStreamFrame;
    }

    @Override // io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate
    public void readWindowUpdateFrame(int i, int i2) {
        this.read = true;
        this.ctx.fireChannelRead((Object) new DefaultSpdyWindowUpdateFrame(i, i2));
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        ByteBuf encode;
        if (obj instanceof SpdyDataFrame) {
            SpdyDataFrame spdyDataFrame = (SpdyDataFrame) obj;
            ByteBuf encodeDataFrame = this.spdyFrameEncoder.encodeDataFrame(channelHandlerContext.alloc(), spdyDataFrame.streamId(), spdyDataFrame.isLast(), spdyDataFrame.content());
            spdyDataFrame.release();
            channelHandlerContext.write(encodeDataFrame, channelPromise);
        } else if (obj instanceof SpdySynStreamFrame) {
            SpdySynStreamFrame spdySynStreamFrame = (SpdySynStreamFrame) obj;
            encode = this.spdyHeaderBlockEncoder.encode(channelHandlerContext.alloc(), spdySynStreamFrame);
            try {
                ByteBuf encodeSynStreamFrame = this.spdyFrameEncoder.encodeSynStreamFrame(channelHandlerContext.alloc(), spdySynStreamFrame.streamId(), spdySynStreamFrame.associatedStreamId(), spdySynStreamFrame.priority(), spdySynStreamFrame.isLast(), spdySynStreamFrame.isUnidirectional(), encode);
                encode.release();
                channelHandlerContext.write(encodeSynStreamFrame, channelPromise);
            } finally {
            }
        } else if (obj instanceof SpdySynReplyFrame) {
            SpdySynReplyFrame spdySynReplyFrame = (SpdySynReplyFrame) obj;
            encode = this.spdyHeaderBlockEncoder.encode(channelHandlerContext.alloc(), spdySynReplyFrame);
            try {
                ByteBuf encodeSynReplyFrame = this.spdyFrameEncoder.encodeSynReplyFrame(channelHandlerContext.alloc(), spdySynReplyFrame.streamId(), spdySynReplyFrame.isLast(), encode);
                encode.release();
                channelHandlerContext.write(encodeSynReplyFrame, channelPromise);
            } finally {
            }
        } else if (obj instanceof SpdyRstStreamFrame) {
            SpdyRstStreamFrame spdyRstStreamFrame = (SpdyRstStreamFrame) obj;
            channelHandlerContext.write(this.spdyFrameEncoder.encodeRstStreamFrame(channelHandlerContext.alloc(), spdyRstStreamFrame.streamId(), spdyRstStreamFrame.status().code()), channelPromise);
        } else if (obj instanceof SpdySettingsFrame) {
            channelHandlerContext.write(this.spdyFrameEncoder.encodeSettingsFrame(channelHandlerContext.alloc(), (SpdySettingsFrame) obj), channelPromise);
        } else if (obj instanceof SpdyPingFrame) {
            channelHandlerContext.write(this.spdyFrameEncoder.encodePingFrame(channelHandlerContext.alloc(), ((SpdyPingFrame) obj).id()), channelPromise);
        } else if (obj instanceof SpdyGoAwayFrame) {
            SpdyGoAwayFrame spdyGoAwayFrame = (SpdyGoAwayFrame) obj;
            channelHandlerContext.write(this.spdyFrameEncoder.encodeGoAwayFrame(channelHandlerContext.alloc(), spdyGoAwayFrame.lastGoodStreamId(), spdyGoAwayFrame.status().code()), channelPromise);
        } else if (obj instanceof SpdyHeadersFrame) {
            SpdyHeadersFrame spdyHeadersFrame = (SpdyHeadersFrame) obj;
            encode = this.spdyHeaderBlockEncoder.encode(channelHandlerContext.alloc(), spdyHeadersFrame);
            try {
                ByteBuf encodeHeadersFrame = this.spdyFrameEncoder.encodeHeadersFrame(channelHandlerContext.alloc(), spdyHeadersFrame.streamId(), spdyHeadersFrame.isLast(), encode);
                encode.release();
                channelHandlerContext.write(encodeHeadersFrame, channelPromise);
            } finally {
            }
        } else if (obj instanceof SpdyWindowUpdateFrame) {
            SpdyWindowUpdateFrame spdyWindowUpdateFrame = (SpdyWindowUpdateFrame) obj;
            channelHandlerContext.write(this.spdyFrameEncoder.encodeWindowUpdateFrame(channelHandlerContext.alloc(), spdyWindowUpdateFrame.streamId(), spdyWindowUpdateFrame.deltaWindowSize()), channelPromise);
        } else {
            throw new UnsupportedMessageTypeException(obj, new Class[0]);
        }
    }

    public SpdyFrameCodec(SpdyVersion spdyVersion, boolean z) {
        this(spdyVersion, 8192, 16384, 6, 15, 8, z);
    }

    public SpdyFrameCodec(SpdyVersion spdyVersion, int i, int i2, int i3, int i4, int i5) {
        this(spdyVersion, i, i2, i3, i4, i5, true);
    }

    public SpdyFrameCodec(SpdyVersion spdyVersion, int i, int i2, int i3, int i4, int i5, boolean z) {
        this(spdyVersion, i, SpdyHeaderBlockDecoder.newInstance(spdyVersion, i2), SpdyHeaderBlockEncoder.newInstance(spdyVersion, i3, i4, i5), z);
    }

    protected SpdyFrameCodec(SpdyVersion spdyVersion, int i, SpdyHeaderBlockDecoder spdyHeaderBlockDecoder, SpdyHeaderBlockEncoder spdyHeaderBlockEncoder, boolean z) {
        this.spdyFrameDecoder = new SpdyFrameDecoder(spdyVersion, this, i);
        this.spdyFrameEncoder = new SpdyFrameEncoder(spdyVersion);
        this.spdyHeaderBlockDecoder = spdyHeaderBlockDecoder;
        this.spdyHeaderBlockEncoder = spdyHeaderBlockEncoder;
        this.validateHeaders = z;
    }
}
