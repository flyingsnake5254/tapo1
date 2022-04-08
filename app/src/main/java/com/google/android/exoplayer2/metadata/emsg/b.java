package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: EventMessageEncoder.java */
/* loaded from: classes.dex */
public final class b {
    private final ByteArrayOutputStream a;

    /* renamed from: b  reason: collision with root package name */
    private final DataOutputStream f2543b;

    public b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        this.f2543b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.a.reset();
        try {
            b(this.f2543b, eventMessage.f2542f);
            String str = eventMessage.q;
            if (str == null) {
                str = "";
            }
            b(this.f2543b, str);
            this.f2543b.writeLong(eventMessage.x);
            this.f2543b.writeLong(eventMessage.y);
            this.f2543b.write(eventMessage.z);
            this.f2543b.flush();
            return this.a.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
