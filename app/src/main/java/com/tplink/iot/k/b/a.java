package com.tplink.iot.k.b;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/* compiled from: TUBPClient.java */
/* loaded from: classes2.dex */
public class a {
    private DatagramChannel a;

    /* renamed from: b  reason: collision with root package name */
    private InetSocketAddress f8009b;

    /* renamed from: c  reason: collision with root package name */
    private b f8010c;

    public a(InetSocketAddress inetSocketAddress) {
        this.f8009b = inetSocketAddress;
    }

    public void a(int i, String str) {
        b bVar = new b((byte) 1, (byte) 1, i, str);
        this.f8010c = bVar;
        try {
            this.a.send(ByteBuffer.wrap(bVar.d()), this.f8009b);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        b.d.w.c.a.c("TDP", "DatagramChannel.open");
        try {
            DatagramChannel open = DatagramChannel.open();
            this.a = open;
            open.socket().setReuseAddress(true);
            this.a.socket().setSoTimeout(8000);
            this.a.configureBlocking(false);
            this.a.socket().setBroadcast(true);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
