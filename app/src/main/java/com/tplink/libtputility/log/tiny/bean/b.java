package com.tplink.libtputility.log.tiny.bean;

import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LogFactoryPacket.java */
/* loaded from: classes3.dex */
public class b {
    private byte a;

    /* renamed from: b  reason: collision with root package name */
    private byte f15122b;

    /* renamed from: c  reason: collision with root package name */
    private int f15123c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f15124d;

    /* renamed from: e  reason: collision with root package name */
    private int f15125e;

    /* renamed from: f  reason: collision with root package name */
    private List<byte[]> f15126f;

    public b(List<a> list) {
        if (list != null && list.size() > 0) {
            this.a = (byte) 1;
            this.f15122b = (byte) 0;
            byte[] jsonByte = new LogFactoryBean(list).toJsonByte();
            this.f15124d = jsonByte;
            if (jsonByte != null) {
                this.f15123c = jsonByte.length;
                this.f15126f = new ArrayList();
                for (a aVar : list) {
                    if (aVar.h() != null && aVar.g() > 0) {
                        this.f15126f.add(aVar.h());
                        this.f15125e += aVar.g();
                    }
                }
            }
        }
    }

    public String a() {
        byte[] bArr = this.f15124d;
        if (bArr == null) {
            return "";
        }
        try {
            int i = this.f15123c;
            byte[] bArr2 = new byte[i + 4 + this.f15125e];
            bArr2[0] = this.a;
            bArr2[1] = this.f15122b;
            bArr2[2] = (byte) ((i >> 8) & 255);
            bArr2[3] = (byte) (i & 255);
            System.arraycopy(bArr, 0, bArr2, 4, i);
            int i2 = this.f15123c + 4;
            for (byte[] bArr3 : this.f15126f) {
                System.arraycopy(bArr3, 0, bArr2, i2, bArr3.length);
                i2 += bArr3.length;
            }
            return new String(Base64.encode(bArr2, 2), "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }
}
