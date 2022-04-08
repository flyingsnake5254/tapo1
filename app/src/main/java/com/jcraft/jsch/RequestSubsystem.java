package com.jcraft.jsch;

/* loaded from: classes2.dex */
public class RequestSubsystem extends Request {
    private String subsystem = null;

    public void request(Session session, Channel channel, String str, boolean z) throws Exception {
        setReply(z);
        this.subsystem = str;
        request(session, channel);
    }

    @Override // com.jcraft.jsch.Request
    public void request(Session session, Channel channel) throws Exception {
        super.request(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte) 98);
        buffer.putInt(channel.getRecipient());
        buffer.putString(Util.str2byte("subsystem"));
        buffer.putByte(waitForReply() ? (byte) 1 : (byte) 0);
        buffer.putString(Util.str2byte(this.subsystem));
        write(packet);
    }
}
