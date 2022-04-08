package com.jcraft.jsch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class RequestX11 extends Request {
    @Override // com.jcraft.jsch.Request
    public void request(Session session, Channel channel) throws Exception {
        super.request(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte) 98);
        buffer.putInt(channel.getRecipient());
        buffer.putString(Util.str2byte("x11-req"));
        buffer.putByte(waitForReply() ? (byte) 1 : (byte) 0);
        buffer.putByte((byte) 0);
        buffer.putString(Util.str2byte("MIT-MAGIC-COOKIE-1"));
        buffer.putString(ChannelX11.getFakedCookie(session));
        buffer.putInt(0);
        write(packet);
        session.x11_forwarding = true;
    }

    public void setCookie(String str) {
        ChannelX11.cookie = Util.str2byte(str);
    }
}
