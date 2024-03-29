package com.jcraft.jsch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class RequestWindowChange extends Request {
    int width_columns = 80;
    int height_rows = 24;
    int width_pixels = 640;
    int height_pixels = 480;

    @Override // com.jcraft.jsch.Request
    public void request(Session session, Channel channel) throws Exception {
        super.request(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte) 98);
        buffer.putInt(channel.getRecipient());
        buffer.putString(Util.str2byte("window-change"));
        buffer.putByte(waitForReply() ? (byte) 1 : (byte) 0);
        buffer.putInt(this.width_columns);
        buffer.putInt(this.height_rows);
        buffer.putInt(this.width_pixels);
        buffer.putInt(this.height_pixels);
        write(packet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSize(int i, int i2, int i3, int i4) {
        this.width_columns = i;
        this.height_rows = i2;
        this.width_pixels = i3;
        this.height_pixels = i4;
    }
}
