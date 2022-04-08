package io.netty.resolver.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes3.dex */
final class DnsAddressDecoder {
    private static final int INADDRSZ4 = 4;
    private static final int INADDRSZ6 = 16;

    private DnsAddressDecoder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InetAddress decodeAddress(DnsRecord dnsRecord, String str, boolean z) {
        if (!(dnsRecord instanceof DnsRawRecord)) {
            return null;
        }
        ByteBuf content = ((ByteBufHolder) dnsRecord).content();
        int readableBytes = content.readableBytes();
        if (readableBytes != 4 && readableBytes != 16) {
            return null;
        }
        byte[] bArr = new byte[readableBytes];
        content.getBytes(content.readerIndex(), bArr);
        if (z) {
            try {
                str = IDN.toUnicode(str);
            } catch (UnknownHostException e2) {
                throw new Error(e2);
            }
        }
        return InetAddress.getByAddress(str, bArr);
    }
}
