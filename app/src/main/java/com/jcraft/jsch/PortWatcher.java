package com.jcraft.jsch;

import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class PortWatcher implements Runnable {
    private static InetAddress anyLocalAddress;
    private static Vector pool = new Vector();
    InetAddress boundaddress;
    int connectTimeout = 0;
    String host;
    int lport;
    int rport;
    Session session;
    ServerSocket ss;
    Runnable thread;

    static {
        anyLocalAddress = null;
        try {
            anyLocalAddress = InetAddress.getByName("0.0.0.0");
        } catch (UnknownHostException unused) {
        }
    }

    PortWatcher(Session session, String str, int i, String str2, int i2, ServerSocketFactory serverSocketFactory) throws JSchException {
        int localPort;
        this.session = session;
        this.lport = i;
        this.host = str2;
        this.rport = i2;
        try {
            InetAddress byName = InetAddress.getByName(str);
            this.boundaddress = byName;
            ServerSocket serverSocket = serverSocketFactory == null ? new ServerSocket(i, 0, this.boundaddress) : serverSocketFactory.createServerSocket(i, 0, byName);
            this.ss = serverSocket;
            if (i == 0 && (localPort = serverSocket.getLocalPort()) != -1) {
                this.lport = localPort;
            }
        } catch (Exception e2) {
            throw new JSchException("PortForwardingL: local port " + str + SSLClient.COLON + i + " cannot be bound.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PortWatcher addPort(Session session, String str, int i, String str2, int i2, ServerSocketFactory serverSocketFactory) throws JSchException {
        String normalize = normalize(str);
        if (getPort(session, normalize, i) == null) {
            PortWatcher portWatcher = new PortWatcher(session, normalize, i, str2, i2, serverSocketFactory);
            pool.addElement(portWatcher);
            return portWatcher;
        }
        throw new JSchException("PortForwardingL: local port " + normalize + SSLClient.COLON + i + " is already registered.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void delPort(Session session, String str, int i) throws JSchException {
        String normalize = normalize(str);
        PortWatcher port = getPort(session, normalize, i);
        if (port != null) {
            port.delete();
            pool.removeElement(port);
            return;
        }
        throw new JSchException("PortForwardingL: local port " + normalize + SSLClient.COLON + i + " is not registered.");
    }

    static PortWatcher getPort(Session session, String str, int i) throws JSchException {
        InetAddress inetAddress;
        try {
            InetAddress byName = InetAddress.getByName(str);
            synchronized (pool) {
                for (int i2 = 0; i2 < pool.size(); i2++) {
                    PortWatcher portWatcher = (PortWatcher) pool.elementAt(i2);
                    if (portWatcher.session == session && portWatcher.lport == i && (((inetAddress = anyLocalAddress) != null && portWatcher.boundaddress.equals(inetAddress)) || portWatcher.boundaddress.equals(byName))) {
                        return portWatcher;
                    }
                }
                return null;
            }
        } catch (UnknownHostException e2) {
            throw new JSchException("PortForwardingL: invalid address " + str + " specified.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] getPortForwarding(Session session) {
        int i;
        Vector vector = new Vector();
        synchronized (pool) {
            for (int i2 = 0; i2 < pool.size(); i2++) {
                PortWatcher portWatcher = (PortWatcher) pool.elementAt(i2);
                if (portWatcher.session == session) {
                    vector.addElement(portWatcher.lport + SSLClient.COLON + portWatcher.host + SSLClient.COLON + portWatcher.rport);
                }
            }
        }
        String[] strArr = new String[vector.size()];
        for (i = 0; i < vector.size(); i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    private static String normalize(String str) {
        return str != null ? (str.length() == 0 || str.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) ? "0.0.0.0" : str.equals("localhost") ? "127.0.0.1" : str : str;
    }

    void delete() {
        this.thread = null;
        try {
            ServerSocket serverSocket = this.ss;
            if (serverSocket != null) {
                serverSocket.close();
            }
            this.ss = null;
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.thread = this;
        while (this.thread != null) {
            try {
                Socket accept = this.ss.accept();
                accept.setTcpNoDelay(true);
                InputStream inputStream = accept.getInputStream();
                OutputStream outputStream = accept.getOutputStream();
                ChannelDirectTCPIP channelDirectTCPIP = new ChannelDirectTCPIP();
                channelDirectTCPIP.init();
                channelDirectTCPIP.setInputStream(inputStream);
                channelDirectTCPIP.setOutputStream(outputStream);
                this.session.addChannel(channelDirectTCPIP);
                channelDirectTCPIP.setHost(this.host);
                channelDirectTCPIP.setPort(this.rport);
                channelDirectTCPIP.setOrgIPAddress(accept.getInetAddress().getHostAddress());
                channelDirectTCPIP.setOrgPort(accept.getPort());
                channelDirectTCPIP.connect(this.connectTimeout);
            } catch (Exception unused) {
            }
        }
        delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void delPort(Session session) {
        synchronized (pool) {
            PortWatcher[] portWatcherArr = new PortWatcher[pool.size()];
            int i = 0;
            for (int i2 = 0; i2 < pool.size(); i2++) {
                PortWatcher portWatcher = (PortWatcher) pool.elementAt(i2);
                if (portWatcher.session == session) {
                    portWatcher.delete();
                    i++;
                    portWatcherArr[i] = portWatcher;
                }
            }
            for (int i3 = 0; i3 < i; i3++) {
                pool.removeElement(portWatcherArr[i3]);
            }
        }
    }
}
