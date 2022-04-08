package b.d.d.k;

import b.d.d.k.f.b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.SSLSocketFactory;
import org.bouncycastle.crypto.tls.n0;

/* compiled from: TPSSLSocketFactory.java */
/* loaded from: classes3.dex */
public class d extends SSLSocketFactory {
    private String[] a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f200b;

    /* renamed from: c  reason: collision with root package name */
    private b f201c;

    /* renamed from: d  reason: collision with root package name */
    private int f202d = 30000;

    /* renamed from: e  reason: collision with root package name */
    private int f203e = 15000;

    public d(String[] strArr, String[] strArr2, b bVar) {
        this.a = strArr;
        this.f200b = strArr2;
        this.f201c = bVar;
    }

    private Socket a(Socket socket, String str, int i) throws IOException {
        if (socket == null) {
            socket = new Socket();
        }
        if (!socket.isConnected()) {
            socket.connect(new InetSocketAddress(str, i), this.f202d);
            socket.setSoTimeout(this.f203e);
        }
        return new c(new n0(socket.getInputStream(), socket.getOutputStream(), new SecureRandom()), this.a, this.f200b, this.f201c);
    }

    public void b(int i) {
        this.f202d = i;
    }

    public void c(int i) {
        this.f203e = i;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(socket, str, i);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        String[] strArr = this.f200b;
        return strArr == null ? new String[0] : strArr;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f200b;
        return strArr == null ? new String[0] : strArr;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return a(null, str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return a(null, str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(null, inetAddress.getHostName(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(null, inetAddress.getHostName(), i);
    }
}
