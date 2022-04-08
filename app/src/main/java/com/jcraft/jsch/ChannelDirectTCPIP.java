package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class ChannelDirectTCPIP extends Channel {
    private static final int LOCAL_MAXIMUM_PACKET_SIZE = 16384;
    private static final int LOCAL_WINDOW_SIZE_MAX = 131072;
    private static final byte[] _type = Util.str2byte("direct-tcpip");
    String host;
    String originator_IP_address = "127.0.0.1";
    int originator_port = 0;
    int port;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelDirectTCPIP() {
        this.type = _type;
        setLocalWindowSizeMax(131072);
        setLocalWindowSize(131072);
        setLocalPacketSize(16384);
    }

    @Override // com.jcraft.jsch.Channel
    public void connect(int i) throws JSchException {
        this.connectTimeout = i;
        try {
            Session session = getSession();
            if (!session.isConnected()) {
                throw new JSchException("session is down");
            } else if (this.f5104io.in != null) {
                Thread thread = new Thread(this);
                this.thread = thread;
                thread.setName("DirectTCPIP thread " + session.getHost());
                boolean z = session.daemon_thread;
                if (z) {
                    this.thread.setDaemon(z);
                }
                this.thread.start();
            } else {
                sendChannelOpen();
            }
        } catch (Exception e2) {
            this.f5104io.close();
            this.f5104io = null;
            Channel.del(this);
            if (e2 instanceof JSchException) {
                throw ((JSchException) e2);
            }
        }
    }

    @Override // com.jcraft.jsch.Channel
    protected Packet genChannelOpenPacket() {
        Buffer buffer = new Buffer(this.host.length() + 50 + this.originator_IP_address.length() + 128);
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte) 90);
        buffer.putString(this.type);
        buffer.putInt(this.id);
        buffer.putInt(this.lwsize);
        buffer.putInt(this.lmpsize);
        buffer.putString(Util.str2byte(this.host));
        buffer.putInt(this.port);
        buffer.putString(Util.str2byte(this.originator_IP_address));
        buffer.putInt(this.originator_port);
        return packet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.jcraft.jsch.Channel
    public void init() {
        this.f5104io = new IO();
    }

    @Override // com.jcraft.jsch.Channel, java.lang.Runnable
    public void run() {
        IO io2;
        InputStream inputStream;
        try {
            sendChannelOpen();
            Buffer buffer = new Buffer(this.rmpsize);
            Packet packet = new Packet(buffer);
            Session session = getSession();
            while (true) {
                if (isConnected() && this.thread != null && (io2 = this.f5104io) != null && (inputStream = io2.in) != null) {
                    byte[] bArr = buffer.buffer;
                    int read = inputStream.read(bArr, 14, (bArr.length - 14) - 128);
                    if (read > 0) {
                        packet.reset();
                        buffer.putByte((byte) 94);
                        buffer.putInt(this.recipient);
                        buffer.putInt(read);
                        buffer.skip(read);
                        synchronized (this) {
                            if (!this.close) {
                                session.write(packet, this, read);
                            }
                        }
                        break;
                    }
                    eof();
                    break;
                }
                break;
            }
            eof();
            disconnect();
        } catch (Exception unused) {
            if (!this.connected) {
                this.connected = true;
            }
            disconnect();
        }
    }

    public void setHost(String str) {
        this.host = str;
    }

    @Override // com.jcraft.jsch.Channel
    public void setInputStream(InputStream inputStream) {
        this.f5104io.setInputStream(inputStream);
    }

    public void setOrgIPAddress(String str) {
        this.originator_IP_address = str;
    }

    public void setOrgPort(int i) {
        this.originator_port = i;
    }

    @Override // com.jcraft.jsch.Channel
    public void setOutputStream(OutputStream outputStream) {
        this.f5104io.setOutputStream(outputStream);
    }

    public void setPort(int i) {
        this.port = i;
    }
}
