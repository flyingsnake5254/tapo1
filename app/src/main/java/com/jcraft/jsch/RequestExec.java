package com.jcraft.jsch;

/* loaded from: classes2.dex */
class RequestExec extends Request {
    private byte[] command;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestExec(byte[] bArr) {
        this.command = new byte[0];
        this.command = bArr;
    }

    @Override // com.jcraft.jsch.Request
    public void request(Session session, Channel channel) throws Exception {
        super.request(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte) 98);
        buffer.putInt(channel.getRecipient());
        buffer.putString(Util.str2byte("exec"));
        buffer.putByte(waitForReply() ? (byte) 1 : (byte) 0);
        buffer.checkFreeSize(this.command.length + 4);
        buffer.putString(this.command);
        write(packet);
    }
}
