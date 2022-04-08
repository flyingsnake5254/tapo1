package com.tplink.ssh2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/* compiled from: SSH2Decoder.java */
/* loaded from: classes3.dex */
public class y extends ByteToMessageDecoder {
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        while (byteBuf.isReadable()) {
            byte[] bArr = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bArr);
            list.add(bArr);
        }
    }
}
