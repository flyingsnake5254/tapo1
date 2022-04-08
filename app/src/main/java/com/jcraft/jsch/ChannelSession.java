package com.jcraft.jsch;

import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ChannelSession extends Channel {
    private static byte[] _session = Util.str2byte("session");
    protected boolean agent_forwarding = false;
    protected boolean xforwading = false;
    protected Hashtable env = null;
    protected boolean pty = false;
    protected String ttype = "vt100";
    protected int tcol = 80;
    protected int trow = 24;
    protected int twp = 640;
    protected int thp = 480;
    protected byte[] terminal_mode = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelSession() {
        this.type = _session;
        this.f5104io = new IO();
    }

    private Hashtable getEnv() {
        if (this.env == null) {
            this.env = new Hashtable();
        }
        return this.env;
    }

    private byte[] toByteArray(Object obj) {
        if (obj instanceof String) {
            return Util.str2byte((String) obj);
        }
        return (byte[]) obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        eof();
     */
    @Override // com.jcraft.jsch.Channel, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r6 = this;
            com.jcraft.jsch.Buffer r0 = new com.jcraft.jsch.Buffer
            int r1 = r6.rmpsize
            r0.<init>(r1)
            com.jcraft.jsch.Packet r1 = new com.jcraft.jsch.Packet
            r1.<init>(r0)
        L_0x000c:
            boolean r2 = r6.isConnected()     // Catch: Exception -> 0x0054
            if (r2 == 0) goto L_0x0055
            java.lang.Thread r2 = r6.thread     // Catch: Exception -> 0x0054
            if (r2 == 0) goto L_0x0055
            com.jcraft.jsch.IO r2 = r6.f5104io     // Catch: Exception -> 0x0054
            if (r2 == 0) goto L_0x0055
            java.io.InputStream r2 = r2.in     // Catch: Exception -> 0x0054
            if (r2 == 0) goto L_0x0055
            byte[] r3 = r0.buffer     // Catch: Exception -> 0x0054
            int r4 = r3.length     // Catch: Exception -> 0x0054
            r5 = 14
            int r4 = r4 - r5
            int r4 = r4 + (-128)
            int r2 = r2.read(r3, r5, r4)     // Catch: Exception -> 0x0054
            if (r2 != 0) goto L_0x002d
            goto L_0x000c
        L_0x002d:
            r3 = -1
            if (r2 != r3) goto L_0x0034
            r6.eof()     // Catch: Exception -> 0x0054
            goto L_0x0055
        L_0x0034:
            boolean r3 = r6.close     // Catch: Exception -> 0x0054
            if (r3 == 0) goto L_0x0039
            goto L_0x0055
        L_0x0039:
            r1.reset()     // Catch: Exception -> 0x0054
            r3 = 94
            r0.putByte(r3)     // Catch: Exception -> 0x0054
            int r3 = r6.recipient     // Catch: Exception -> 0x0054
            r0.putInt(r3)     // Catch: Exception -> 0x0054
            r0.putInt(r2)     // Catch: Exception -> 0x0054
            r0.skip(r2)     // Catch: Exception -> 0x0054
            com.jcraft.jsch.Session r3 = r6.getSession()     // Catch: Exception -> 0x0054
            r3.write(r1, r6, r2)     // Catch: Exception -> 0x0054
            goto L_0x000c
        L_0x0054:
        L_0x0055:
            java.lang.Thread r0 = r6.thread
            if (r0 == 0) goto L_0x0062
            monitor-enter(r0)
            r0.notifyAll()     // Catch: all -> 0x005f
            monitor-exit(r0)     // Catch: all -> 0x005f
            goto L_0x0062
        L_0x005f:
            r1 = move-exception
            monitor-exit(r0)     // Catch: all -> 0x005f
            throw r1
        L_0x0062:
            r0 = 0
            r6.thread = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.ChannelSession.run():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendRequests() throws Exception {
        Session session = getSession();
        if (this.agent_forwarding) {
            new RequestAgentForwarding().request(session, this);
        }
        if (this.xforwading) {
            new RequestX11().request(session, this);
        }
        if (this.pty) {
            RequestPtyReq requestPtyReq = new RequestPtyReq();
            requestPtyReq.setTType(this.ttype);
            requestPtyReq.setTSize(this.tcol, this.trow, this.twp, this.thp);
            byte[] bArr = this.terminal_mode;
            if (bArr != null) {
                requestPtyReq.setTerminalMode(bArr);
            }
            requestPtyReq.request(session, this);
        }
        Hashtable hashtable = this.env;
        if (hashtable != null) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                Object nextElement = keys.nextElement();
                Object obj = this.env.get(nextElement);
                RequestEnv requestEnv = new RequestEnv();
                requestEnv.setEnv(toByteArray(nextElement), toByteArray(obj));
                requestEnv.request(session, this);
            }
        }
    }

    public void setAgentForwarding(boolean z) {
        this.agent_forwarding = z;
    }

    public void setEnv(Hashtable hashtable) {
        synchronized (this) {
            this.env = hashtable;
        }
    }

    public void setPty(boolean z) {
        this.pty = z;
    }

    public void setPtySize(int i, int i2, int i3, int i4) {
        setPtyType(this.ttype, i, i2, i3, i4);
        if (this.pty && isConnected()) {
            try {
                RequestWindowChange requestWindowChange = new RequestWindowChange();
                requestWindowChange.setSize(i, i2, i3, i4);
                requestWindowChange.request(getSession(), this);
            } catch (Exception unused) {
            }
        }
    }

    public void setPtyType(String str) {
        setPtyType(str, 80, 24, 640, 480);
    }

    public void setTerminalMode(byte[] bArr) {
        this.terminal_mode = bArr;
    }

    @Override // com.jcraft.jsch.Channel
    public void setXForwarding(boolean z) {
        this.xforwading = z;
    }

    public void setPtyType(String str, int i, int i2, int i3, int i4) {
        this.ttype = str;
        this.tcol = i;
        this.trow = i2;
        this.twp = i3;
        this.thp = i4;
    }

    public void setEnv(String str, String str2) {
        setEnv(Util.str2byte(str), Util.str2byte(str2));
    }

    public void setEnv(byte[] bArr, byte[] bArr2) {
        synchronized (this) {
            getEnv().put(bArr, bArr2);
        }
    }
}
