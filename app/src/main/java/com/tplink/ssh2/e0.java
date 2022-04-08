package com.tplink.ssh2;

import com.jcraft.jsch.SocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/* compiled from: SSH2SocketFactory.java */
/* loaded from: classes3.dex */
public class e0 implements SocketFactory {
    private final javax.net.SocketFactory a;

    public e0(javax.net.SocketFactory socketFactory) {
        this.a = socketFactory;
    }

    @Override // com.jcraft.jsch.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return this.a.createSocket(str, i);
    }

    @Override // com.jcraft.jsch.SocketFactory
    public InputStream getInputStream(Socket socket) throws IOException {
        return socket.getInputStream();
    }

    @Override // com.jcraft.jsch.SocketFactory
    public OutputStream getOutputStream(Socket socket) throws IOException {
        return socket.getOutputStream();
    }
}
