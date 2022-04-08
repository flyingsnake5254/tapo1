package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class ChannelSubsystem extends ChannelSession {
    boolean xforwading = false;
    boolean pty = false;
    boolean want_reply = true;
    String subsystem = "";

    public InputStream getErrStream() throws IOException {
        return getExtInputStream();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.jcraft.jsch.Channel
    public void init() throws JSchException {
        this.f5104io.setInputStream(getSession().in);
        this.f5104io.setOutputStream(getSession().out);
    }

    @Override // com.jcraft.jsch.ChannelSession, com.jcraft.jsch.Channel, java.lang.Runnable
    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    @Override // com.jcraft.jsch.ChannelSession
    public /* bridge */ /* synthetic */ void setAgentForwarding(boolean z) {
        super.setAgentForwarding(z);
    }

    @Override // com.jcraft.jsch.ChannelSession
    public /* bridge */ /* synthetic */ void setEnv(String str, String str2) {
        super.setEnv(str, str2);
    }

    public void setErrStream(OutputStream outputStream) {
        setExtOutputStream(outputStream);
    }

    @Override // com.jcraft.jsch.ChannelSession
    public void setPty(boolean z) {
        this.pty = z;
    }

    @Override // com.jcraft.jsch.ChannelSession
    public /* bridge */ /* synthetic */ void setPtySize(int i, int i2, int i3, int i4) {
        super.setPtySize(i, i2, i3, i4);
    }

    @Override // com.jcraft.jsch.ChannelSession
    public /* bridge */ /* synthetic */ void setPtyType(String str) {
        super.setPtyType(str);
    }

    public void setSubsystem(String str) {
        this.subsystem = str;
    }

    @Override // com.jcraft.jsch.ChannelSession
    public /* bridge */ /* synthetic */ void setTerminalMode(byte[] bArr) {
        super.setTerminalMode(bArr);
    }

    public void setWantReply(boolean z) {
        this.want_reply = z;
    }

    @Override // com.jcraft.jsch.ChannelSession, com.jcraft.jsch.Channel
    public void setXForwarding(boolean z) {
        this.xforwading = z;
    }

    @Override // com.jcraft.jsch.Channel
    public void start() throws JSchException {
        Session session = getSession();
        try {
            if (this.xforwading) {
                new RequestX11().request(session, this);
            }
            if (this.pty) {
                new RequestPtyReq().request(session, this);
            }
            new RequestSubsystem().request(session, this, this.subsystem, this.want_reply);
            if (this.f5104io.in != null) {
                Thread thread = new Thread(this);
                this.thread = thread;
                thread.setName("Subsystem for " + session.host);
                boolean z = session.daemon_thread;
                if (z) {
                    this.thread.setDaemon(z);
                }
                this.thread.start();
            }
        } catch (Exception e2) {
            if (!(e2 instanceof JSchException)) {
                throw new JSchException("ChannelSubsystem", e2);
            }
            throw ((JSchException) e2);
        }
    }

    @Override // com.jcraft.jsch.ChannelSession
    public /* bridge */ /* synthetic */ void setEnv(Hashtable hashtable) {
        super.setEnv(hashtable);
    }

    @Override // com.jcraft.jsch.ChannelSession
    public /* bridge */ /* synthetic */ void setPtyType(String str, int i, int i2, int i3, int i4) {
        super.setPtyType(str, i, i2, i3, i4);
    }

    @Override // com.jcraft.jsch.ChannelSession
    public /* bridge */ /* synthetic */ void setEnv(byte[] bArr, byte[] bArr2) {
        super.setEnv(bArr, bArr2);
    }
}
