package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;
import java.util.RandomAccess;

@ChannelHandler.a
/* loaded from: classes3.dex */
public class Socks5ClientEncoder extends MessageToByteEncoder<a> {
    public static final Socks5ClientEncoder DEFAULT = new Socks5ClientEncoder();
    private final Socks5AddressEncoder addressEncoder;

    protected Socks5ClientEncoder() {
        this(Socks5AddressEncoder.DEFAULT);
    }

    private static void encodeAuthMethodRequest(Socks5InitialRequest socks5InitialRequest, ByteBuf byteBuf) {
        byteBuf.writeByte(socks5InitialRequest.version().byteValue());
        List<Socks5AuthMethod> authMethods = socks5InitialRequest.authMethods();
        int size = authMethods.size();
        byteBuf.writeByte(size);
        if (authMethods instanceof RandomAccess) {
            for (int i = 0; i < size; i++) {
                byteBuf.writeByte(authMethods.get(i).byteValue());
            }
            return;
        }
        for (Socks5AuthMethod socks5AuthMethod : authMethods) {
            byteBuf.writeByte(socks5AuthMethod.byteValue());
        }
    }

    private void encodeCommandRequest(Socks5CommandRequest socks5CommandRequest, ByteBuf byteBuf) throws Exception {
        byteBuf.writeByte(socks5CommandRequest.version().byteValue());
        byteBuf.writeByte(socks5CommandRequest.type().byteValue());
        byteBuf.writeByte(0);
        Socks5AddressType dstAddrType = socks5CommandRequest.dstAddrType();
        byteBuf.writeByte(dstAddrType.byteValue());
        this.addressEncoder.encodeAddress(dstAddrType, socks5CommandRequest.dstAddr(), byteBuf);
        byteBuf.writeShort(socks5CommandRequest.dstPort());
    }

    private static void encodePasswordAuthRequest(Socks5PasswordAuthRequest socks5PasswordAuthRequest, ByteBuf byteBuf) {
        byteBuf.writeByte(1);
        String username = socks5PasswordAuthRequest.username();
        byteBuf.writeByte(username.length());
        ByteBufUtil.writeAscii(byteBuf, username);
        String password = socks5PasswordAuthRequest.password();
        byteBuf.writeByte(password.length());
        ByteBufUtil.writeAscii(byteBuf, password);
    }

    protected final Socks5AddressEncoder addressEncoder() {
        return this.addressEncoder;
    }

    public Socks5ClientEncoder(Socks5AddressEncoder socks5AddressEncoder) {
        this.addressEncoder = (Socks5AddressEncoder) ObjectUtil.checkNotNull(socks5AddressEncoder, "addressEncoder");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void encode(ChannelHandlerContext channelHandlerContext, a aVar, ByteBuf byteBuf) throws Exception {
        if (aVar instanceof Socks5InitialRequest) {
            encodeAuthMethodRequest((Socks5InitialRequest) aVar, byteBuf);
        } else if (aVar instanceof Socks5PasswordAuthRequest) {
            encodePasswordAuthRequest((Socks5PasswordAuthRequest) aVar, byteBuf);
        } else if (aVar instanceof Socks5CommandRequest) {
            encodeCommandRequest((Socks5CommandRequest) aVar, byteBuf);
        } else {
            throw new EncoderException("unsupported message type: " + StringUtil.simpleClassName(aVar));
        }
    }
}
