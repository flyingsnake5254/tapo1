package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes2.dex */
public class ProxySOCKS5 implements Proxy {
    private static int DEFAULTPORT = 1080;
    private InputStream in;
    private OutputStream out;
    private String passwd;
    private String proxy_host;
    private int proxy_port;
    private Socket socket;
    private String user;

    public ProxySOCKS5(String str) {
        int i = DEFAULTPORT;
        if (str.indexOf(58) != -1) {
            try {
                str = str.substring(0, str.indexOf(58));
                try {
                    i = Integer.parseInt(str.substring(str.indexOf(58) + 1));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        }
        this.proxy_host = str;
        this.proxy_port = i;
    }

    private void fill(InputStream inputStream, byte[] bArr, int i) throws JSchException, IOException {
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read > 0) {
                i2 += read;
            } else {
                throw new JSchException("ProxySOCKS5: stream is closed");
            }
        }
    }

    public static int getDefaultPort() {
        return DEFAULTPORT;
    }

    @Override // com.jcraft.jsch.Proxy
    public void close() {
        try {
            InputStream inputStream = this.in;
            if (inputStream != null) {
                inputStream.close();
            }
            OutputStream outputStream = this.out;
            if (outputStream != null) {
                outputStream.close();
            }
            Socket socket = this.socket;
            if (socket != null) {
                socket.close();
            }
        } catch (Exception unused) {
        }
        this.in = null;
        this.out = null;
        this.socket = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c1 A[Catch: Exception -> 0x0146, RuntimeException -> 0x0169, TryCatch #5 {RuntimeException -> 0x0169, Exception -> 0x0146, blocks: (B:3:0x0002, B:4:0x001b, B:6:0x0035, B:7:0x003a, B:11:0x0064, B:13:0x0068, B:16:0x006d, B:22:0x00c1, B:24:0x00f1, B:29:0x00fc, B:30:0x0104, B:31:0x0114, B:34:0x0120, B:35:0x0138, B:37:0x013e, B:38:0x0145), top: B:56:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.jcraft.jsch.Proxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void connect(com.jcraft.jsch.SocketFactory r9, java.lang.String r10, int r11, int r12) throws com.jcraft.jsch.JSchException {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.ProxySOCKS5.connect(com.jcraft.jsch.SocketFactory, java.lang.String, int, int):void");
    }

    @Override // com.jcraft.jsch.Proxy
    public InputStream getInputStream() {
        return this.in;
    }

    @Override // com.jcraft.jsch.Proxy
    public OutputStream getOutputStream() {
        return this.out;
    }

    @Override // com.jcraft.jsch.Proxy
    public Socket getSocket() {
        return this.socket;
    }

    public void setUserPasswd(String str, String str2) {
        this.user = str;
        this.passwd = str2;
    }

    public ProxySOCKS5(String str, int i) {
        this.proxy_host = str;
        this.proxy_port = i;
    }
}
