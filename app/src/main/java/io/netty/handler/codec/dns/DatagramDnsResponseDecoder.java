package io.netty.handler.codec.dns;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.net.InetSocketAddress;
import java.util.List;

@ChannelHandler.a
/* loaded from: classes3.dex */
public class DatagramDnsResponseDecoder extends MessageToMessageDecoder<DatagramPacket> {
    private final DnsResponseDecoder<InetSocketAddress> responseDecoder;

    public DatagramDnsResponseDecoder() {
        this(DnsRecordDecoder.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List list) throws Exception {
        decode2(channelHandlerContext, datagramPacket, (List<Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DnsResponse decodeResponse(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        return this.responseDecoder.decode(datagramPacket.sender(), datagramPacket.recipient(), datagramPacket.content());
    }

    public DatagramDnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.responseDecoder = new DnsResponseDecoder<InetSocketAddress>(dnsRecordDecoder) { // from class: io.netty.handler.codec.dns.DatagramDnsResponseDecoder.1
            /* JADX INFO: Access modifiers changed from: protected */
            public DnsResponse newResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) {
                return new DatagramDnsResponse(inetSocketAddress, inetSocketAddress2, i, dnsOpCode, dnsResponseCode);
            }
        };
    }

    /* renamed from: decode  reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) throws Exception {
        list.add(decodeResponse(channelHandlerContext, datagramPacket));
    }
}
