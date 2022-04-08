package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;

/* loaded from: classes3.dex */
public interface Socks5AddressDecoder {
    public static final Socks5AddressDecoder DEFAULT = new Socks5AddressDecoder() { // from class: io.netty.handler.codec.socksx.v5.Socks5AddressDecoder.1
        private static final int IPv6_LEN = 16;

        @Override // io.netty.handler.codec.socksx.v5.Socks5AddressDecoder
        public String decodeAddress(Socks5AddressType socks5AddressType, ByteBuf byteBuf) throws Exception {
            if (socks5AddressType == Socks5AddressType.IPv4) {
                return NetUtil.intToIpAddress(byteBuf.readInt());
            }
            if (socks5AddressType == Socks5AddressType.DOMAIN) {
                short readUnsignedByte = byteBuf.readUnsignedByte();
                String byteBuf2 = byteBuf.toString(byteBuf.readerIndex(), readUnsignedByte, CharsetUtil.US_ASCII);
                byteBuf.skipBytes(readUnsignedByte);
                return byteBuf2;
            } else if (socks5AddressType != Socks5AddressType.IPv6) {
                throw new DecoderException("unsupported address type: " + (socks5AddressType.byteValue() & 255));
            } else if (byteBuf.hasArray()) {
                int readerIndex = byteBuf.readerIndex();
                byteBuf.readerIndex(readerIndex + 16);
                return NetUtil.bytesToIpAddress(byteBuf.array(), byteBuf.arrayOffset() + readerIndex, 16);
            } else {
                byte[] bArr = new byte[16];
                byteBuf.readBytes(bArr);
                return NetUtil.bytesToIpAddress(bArr);
            }
        }
    };

    String decodeAddress(Socks5AddressType socks5AddressType, ByteBuf byteBuf) throws Exception;
}
