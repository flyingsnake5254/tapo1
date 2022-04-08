package io.netty.handler.codec.protobuf;

import com.google.protobuf.nano.MessageNano;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

@ChannelHandler.a
/* loaded from: classes3.dex */
public class ProtobufDecoderNano extends MessageToMessageDecoder<ByteBuf> {
    private final Class<? extends MessageNano> clazz;

    public ProtobufDecoderNano(Class<? extends MessageNano> cls) {
        this.clazz = (Class) ObjectUtil.checkNotNull(cls, "You must provide a Class");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        decode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    /* renamed from: decode  reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i;
        byte[] bArr;
        int readableBytes = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bArr = byteBuf.array();
            i = byteBuf.arrayOffset() + byteBuf.readerIndex();
        } else {
            bArr = ByteBufUtil.getBytes(byteBuf, byteBuf.readerIndex(), readableBytes, false);
            i = 0;
        }
        list.add(MessageNano.mergeFrom((MessageNano) this.clazz.getConstructor(new Class[0]).newInstance(new Object[0]), bArr, i, readableBytes));
    }
}
