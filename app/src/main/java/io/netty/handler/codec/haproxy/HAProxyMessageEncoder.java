package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.haproxy.HAProxyProxiedProtocol;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.nio.charset.Charset;
import java.util.List;

@ChannelHandler.a
/* loaded from: classes3.dex */
public final class HAProxyMessageEncoder extends MessageToByteEncoder<HAProxyMessage> {
    public static final HAProxyMessageEncoder INSTANCE = new HAProxyMessageEncoder();
    static final int TOTAL_UNIX_ADDRESS_BYTES_LENGTH = 216;
    static final int UNIX_ADDRESS_BYTES_LENGTH = 108;
    private static final int V2_VERSION_BITMASK = 32;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.haproxy.HAProxyMessageEncoder$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProtocolVersion;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily;

        static {
            int[] iArr = new int[HAProxyProxiedProtocol.AddressFamily.values().length];
            $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily = iArr;
            try {
                iArr[HAProxyProxiedProtocol.AddressFamily.AF_IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[HAProxyProxiedProtocol.AddressFamily.AF_IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[HAProxyProxiedProtocol.AddressFamily.AF_UNIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[HAProxyProxiedProtocol.AddressFamily.AF_UNSPEC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[HAProxyProtocolVersion.values().length];
            $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProtocolVersion = iArr2;
            try {
                iArr2[HAProxyProtocolVersion.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProtocolVersion[HAProxyProtocolVersion.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private HAProxyMessageEncoder() {
    }

    private static void encodeTlv(HAProxyTLV hAProxyTLV, ByteBuf byteBuf) {
        if (hAProxyTLV instanceof HAProxySSLTLV) {
            HAProxySSLTLV hAProxySSLTLV = (HAProxySSLTLV) hAProxyTLV;
            byteBuf.writeByte(hAProxyTLV.typeByteValue());
            byteBuf.writeShort(hAProxySSLTLV.contentNumBytes());
            byteBuf.writeByte(hAProxySSLTLV.client());
            byteBuf.writeInt(hAProxySSLTLV.verify());
            encodeTlvs(hAProxySSLTLV.encapsulatedTLVs(), byteBuf);
            return;
        }
        byteBuf.writeByte(hAProxyTLV.typeByteValue());
        ByteBuf content = hAProxyTLV.content();
        int readableBytes = content.readableBytes();
        byteBuf.writeShort(readableBytes);
        byteBuf.writeBytes(content.readSlice(readableBytes));
    }

    private static void encodeTlvs(List<HAProxyTLV> list, ByteBuf byteBuf) {
        for (int i = 0; i < list.size(); i++) {
            encodeTlv(list.get(i), byteBuf);
        }
    }

    private static void encodeV1(HAProxyMessage hAProxyMessage, ByteBuf byteBuf) {
        byteBuf.writeBytes(HAProxyConstants.TEXT_PREFIX);
        byteBuf.writeByte(32);
        String name = hAProxyMessage.proxiedProtocol().name();
        Charset charset = CharsetUtil.US_ASCII;
        byteBuf.writeCharSequence(name, charset);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(hAProxyMessage.sourceAddress(), charset);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(hAProxyMessage.destinationAddress(), charset);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(String.valueOf(hAProxyMessage.sourcePort()), charset);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(String.valueOf(hAProxyMessage.destinationPort()), charset);
        byteBuf.writeByte(13);
        byteBuf.writeByte(10);
    }

    private static void encodeV2(HAProxyMessage hAProxyMessage, ByteBuf byteBuf) {
        byteBuf.writeBytes(HAProxyConstants.BINARY_PREFIX);
        byteBuf.writeByte(hAProxyMessage.command().byteValue() | 32);
        byteBuf.writeByte(hAProxyMessage.proxiedProtocol().byteValue());
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[hAProxyMessage.proxiedProtocol().addressFamily().ordinal()];
        if (i == 1 || i == 2) {
            byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(hAProxyMessage.sourceAddress());
            byte[] createByteArrayFromIpAddressString2 = NetUtil.createByteArrayFromIpAddressString(hAProxyMessage.destinationAddress());
            byteBuf.writeShort(createByteArrayFromIpAddressString.length + createByteArrayFromIpAddressString2.length + 4 + hAProxyMessage.tlvNumBytes());
            byteBuf.writeBytes(createByteArrayFromIpAddressString);
            byteBuf.writeBytes(createByteArrayFromIpAddressString2);
            byteBuf.writeShort(hAProxyMessage.sourcePort());
            byteBuf.writeShort(hAProxyMessage.destinationPort());
            encodeTlvs(hAProxyMessage.tlvs(), byteBuf);
        } else if (i == 3) {
            byteBuf.writeShort(hAProxyMessage.tlvNumBytes() + TOTAL_UNIX_ADDRESS_BYTES_LENGTH);
            String sourceAddress = hAProxyMessage.sourceAddress();
            Charset charset = CharsetUtil.US_ASCII;
            byteBuf.writeZero(108 - byteBuf.writeCharSequence(sourceAddress, charset));
            byteBuf.writeZero(108 - byteBuf.writeCharSequence(hAProxyMessage.destinationAddress(), charset));
            encodeTlvs(hAProxyMessage.tlvs(), byteBuf);
        } else if (i == 4) {
            byteBuf.writeShort(0);
        } else {
            throw new HAProxyProtocolException("unexpected addrFamily");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void encode(ChannelHandlerContext channelHandlerContext, HAProxyMessage hAProxyMessage, ByteBuf byteBuf) throws Exception {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProtocolVersion[hAProxyMessage.protocolVersion().ordinal()];
        if (i == 1) {
            encodeV1(hAProxyMessage, byteBuf);
        } else if (i == 2) {
            encodeV2(hAProxyMessage, byteBuf);
        } else {
            throw new HAProxyProtocolException("Unsupported version: " + hAProxyMessage.protocolVersion());
        }
    }
}
