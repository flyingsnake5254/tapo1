package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/* loaded from: classes3.dex */
public class CloseWebSocketFrame extends WebSocketFrame {
    public CloseWebSocketFrame() {
        super(Unpooled.buffer(0));
    }

    private static ByteBuf newBinaryData(int i, String str) {
        if (str == null) {
            str = "";
        }
        ByteBuf buffer = Unpooled.buffer(str.length() + 2);
        buffer.writeShort(i);
        if (!str.isEmpty()) {
            buffer.writeCharSequence(str, CharsetUtil.UTF_8);
        }
        buffer.readerIndex(0);
        return buffer;
    }

    public String reasonText() {
        ByteBuf content = content();
        if (content == null || content.capacity() <= 2) {
            return "";
        }
        content.readerIndex(2);
        String byteBuf = content.toString(CharsetUtil.UTF_8);
        content.readerIndex(0);
        return byteBuf;
    }

    public int statusCode() {
        ByteBuf content = content();
        if (content == null || content.capacity() == 0) {
            return -1;
        }
        content.readerIndex(0);
        return content.getShort(0);
    }

    public CloseWebSocketFrame(WebSocketCloseStatus webSocketCloseStatus) {
        this(webSocketCloseStatus.code(), webSocketCloseStatus.reasonText());
    }

    public CloseWebSocketFrame(WebSocketCloseStatus webSocketCloseStatus, String str) {
        this(webSocketCloseStatus.code(), str);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame copy() {
        return (CloseWebSocketFrame) super.copy();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame duplicate() {
        return (CloseWebSocketFrame) super.duplicate();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame replace(ByteBuf byteBuf) {
        return new CloseWebSocketFrame(isFinalFragment(), rsv(), byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public CloseWebSocketFrame retainedDuplicate() {
        return (CloseWebSocketFrame) super.retainedDuplicate();
    }

    public CloseWebSocketFrame(int i, String str) {
        this(true, 0, i, str);
    }

    public CloseWebSocketFrame(boolean z, int i) {
        this(z, i, Unpooled.buffer(0));
    }

    public CloseWebSocketFrame(boolean z, int i, int i2, String str) {
        super(z, i, newBinaryData(i2, str));
    }

    public CloseWebSocketFrame(boolean z, int i, ByteBuf byteBuf) {
        super(z, i, byteBuf);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame retain(int i) {
        super.retain(i);
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketFrame, io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    public CloseWebSocketFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
