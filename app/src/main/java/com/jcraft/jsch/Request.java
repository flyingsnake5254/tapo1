package com.jcraft.jsch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Request {
    private boolean reply = false;
    private Session session = null;
    private Channel channel = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void request(Session session, Channel channel) throws Exception {
        this.session = session;
        this.channel = channel;
        if (channel.connectTimeout > 0) {
            setReply(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setReply(boolean z) {
        this.reply = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean waitForReply() {
        return this.reply;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void write(Packet packet) throws Exception {
        if (this.reply) {
            this.channel.reply = -1;
        }
        this.session.write(packet);
        if (this.reply) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.channel.connectTimeout;
            while (this.channel.isConnected() && this.channel.reply == -1) {
                try {
                    Thread.sleep(10L);
                } catch (Exception unused) {
                }
                if (j > 0 && System.currentTimeMillis() - currentTimeMillis > j) {
                    this.channel.reply = 0;
                    throw new JSchException("channel request: timeout");
                }
            }
            if (this.channel.reply == 0) {
                throw new JSchException("failed to send channel request");
            }
        }
    }
}
